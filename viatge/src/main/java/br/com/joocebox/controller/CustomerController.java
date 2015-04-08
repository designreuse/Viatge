package br.com.joocebox.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.joocebox.model.Customer;
import br.com.joocebox.model.CustomerService;
import br.com.joocebox.model.Destination;
import br.com.joocebox.model.FamilyBond;
import br.com.joocebox.model.History;
import br.com.joocebox.model.Passenger;
import br.com.joocebox.model.SaleType;
import br.com.joocebox.model.ServiceItem;
import br.com.joocebox.model.views.VwOpenService;
import br.com.joocebox.service.CustomerFacade;
import br.com.joocebox.service.CustomerServiceFacade;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.ServiceFacade;
import br.com.joocebox.service.ServiceItemFacade;
import static br.com.joocebox.utils.FormatObjects.*;

import com.google.common.base.Strings;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")
public class CustomerController{

	final static Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Autowired
	private ServiceFacade serviceFacade;
	
	@Autowired
	private CustomerFacade customerFacade;
	
	@Autowired
	private CustomerServiceFacade customerServiceFacade;
	
	@Autowired
	private ServiceItemFacade serviceItemFacade;
	
	@Autowired
	private DashboardFacade dashboardFacade;

	private Set<CustomerService> customerServiceList;
	
	private Set<Passenger> passengerList = new HashSet<Passenger>();
	
	ConcurrentHashMap<String, ServiceItem> mapOfRequestedDestination = new ConcurrentHashMap<String, ServiceItem>();
	
	private List<History> history;
	
	private CustomerService cs;
	

	@RequestMapping("/service")
	public ModelAndView getMenuService(Model model) {

		initializeComponents(model);
		model.addAttribute("requestedDestination", new ServiceItem());
		return new ModelAndView("service/newService", "customer",
				new Customer());
	}

	@RequestMapping("/serviceList")
	public ModelAndView getMenuServiceList(Model model) {

		Iterable<VwOpenService> openServiceList = serviceFacade.getOpenServiceList();
		
		List<VwOpenService> auxCustomer = new ArrayList<VwOpenService>();
		
		for (VwOpenService vwOpenService : openServiceList) {
			
	        if ("SUBMITTED_BUDGET".equals(vwOpenService.getSaleType()) || "SEND_BUDGET".equals(vwOpenService.getSaleType())) {
	            auxCustomer.add(vwOpenService);
	            
	        }
			
		}

		ModelAndView mv = new ModelAndView("service/serviceList");
		mv.addObject("serviceListRegister", auxCustomer);
		mv.addObject("ListSize", auxCustomer.size());
		avgBudgets(model);
		countOfBudgets(model);
		
		return mv;

	}
	
	public void initializeComponents(Model model) {

		// Carrega os destinos no mutiple-select
		List<Destination> destinationList = dashboardFacade
				.getDestinationList();
		model.addAttribute("destinationList", destinationList);

		// Carrega o parentesco do passageiro
		Map<FamilyBond, String> map = new HashMap<FamilyBond, String>();
		for (FamilyBond family : Arrays.asList(FamilyBond.values())) {
			String bondName = family.getBond();
			map.put(family, bondName);
		}
		model.addAttribute("listOfBondNames", map);
		
		//Carrega os tipos de negociação
		Map<SaleType, String> saleTypeMap = new HashMap<SaleType, String>();
		for (SaleType sale : Arrays.asList(SaleType.values())) {
			String saleType = sale.getSaleType();
			saleTypeMap.put(sale, saleType);
		}
		
		model.addAttribute("listOfSaleTypes", saleTypeMap);

	}

    /**
     * Ação responsável por adicionar um novo atendimento
     * @param Customer
     * @param result
     * @param model
     * @return ModelAndView
     */
	@RequestMapping(value = "/addService", method = RequestMethod.POST)
	public ModelAndView addService(
			@ModelAttribute("customer") @Valid Customer customer,
			BindingResult result, Model model, @RequestParam Long id) {
		if(id==null){
			if (customer.getBirthDate() == null) {
	            customer.setBirthDate(customer.getBirthDate());
	        }

	        List<String> error = new ArrayList<String>();

	        if (result.hasErrors()) {
	            List<ObjectError> allErrors = result.getAllErrors();

	            for (ObjectError objectError : allErrors) {
	                String objectName = objectError.getDefaultMessage();
	                error.add(objectName);
	            }

	            model.addAttribute("errors", error);
	            model.addAttribute("validator", true);

	            initializeComponents(model);
	            return new ModelAndView("service/newService");

	        } else {
	            
	        	//Agrega uma lista de passageiros cadastrados a aquele cliente corrente
	            customer.setPassenger(passengerList);
	            
	            //Persiste um novo Cliente
	            customerFacade.saveCustomer(customer);
	            
	            //Inicia um objeto do tipo CustomerService para abrir um atendimento.
	            CustomerService customerService = new CustomerService();
	            
	            //Atualiza a data de abertura do serviço
	            customerService.setDate(new Date());
	            
	            //Verifica se existe algum atendimento marcado como "Orçamento", e marca como aberto e atualiza a data do mesmo
	            if(isOpenService()){
	                customerService.setSituation(Boolean.TRUE);         
	            }else{
	                customerService.setSituation(Boolean.FALSE);
	            }
	            
	            //Adiciona o atendimento em uma lista
	            customerServiceList = new HashSet<CustomerService>();
	            customerServiceList.add(customerService);
	            
	            //Seta uma lista de Atendimentos
	            customer.setCustomerService(customerServiceList);
	                       
	            //Cria um objeto com o Historico
	            history = new ArrayList<History>();
	            
	            //Salva um objeto do tipo ServiceItem
	            for (ServiceItem si : mapOfRequestedDestination.values()) {
	                 
	                String formatDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	                
	                String saleType = "";  
	                if (si.getSaleType() == SaleType.SEND_BUDGET) {
	                    saleType = SaleType.SEND_BUDGET.getSaleType();
	                    history.add(new History("[ " + saleType + " ]" + " Destino: " + si.getDestination().getDtName() + " Na data de: " +  formatDate));

	                }else if(si.getSaleType() == SaleType.SUBMITTED_BUDGET){
	                    saleType = SaleType.SUBMITTED_BUDGET.getSaleType();
	                    history.add(new History("[ " + saleType + " ]" + " Destino: " + si.getDestination().getDtName() + " Na data de: " + formatDate + " Valor: R$" + si.getValueNegotiated()));
	                    
	                }else if(si.getSaleType() == SaleType.NOT_WANTED){
	                    saleType = SaleType.NOT_WANTED.getSaleType();
	                    history.add(new History("[ " + saleType + " ]" + " Destino: " + si.getDestination().getDtName() + " Na data de: " +  formatDate + " Valor: R$" + si.getValueNegotiated()));
	                    
	                }else if(si.getSaleType() == SaleType.MAYBE_FUTURE){
	                    saleType = SaleType.MAYBE_FUTURE.getSaleType();
	                    history.add(new History("[ " + saleType + " ]" + " Destino: " + si.getDestination().getDtName() + " Na data de: " +  formatDate + " Valor: R$" + si.getValueNegotiated()));
	                    
	                }else if(si.getSaleType() == SaleType.BOUGHT){
	                    saleType = SaleType.BOUGHT.getSaleType();
	                    //TODO: Fazer um link que redirecione para a faura da venda.
	                    history.add(new History("[ " + saleType + " ]" + " Destino: " + si.getDestination().getDtName() + " Na data de: " + formatDate + " Valor: R$" + si.getValueNegotiated()));
	                    
	                }
	                
	                customerService.setHistory(history);                        
	                si.setCustomerService(customerService);
	            }
	            List<ServiceItem> list = new ArrayList<ServiceItem>(mapOfRequestedDestination.values());
	            serviceItemFacade.saveServiceItem(list);
	        }
		}else{
			
			//Setar informações dos clientes.
			Customer oldCustomer = customerFacade.getCustomerId(id);
			
			if(!passengerList.isEmpty()){
				oldCustomer.setPassenger(passengerList);
				customerFacade.saveCustomer(oldCustomer);
			}

			//Resgata o customerService por ID
			CustomerService oldCustomerService = customerServiceFacade.getCustomerServiceById(this.cs.getId());
			
            if(isOpenService()){
                oldCustomerService.setSituation(Boolean.TRUE);         
            }else{
                oldCustomerService.setSituation(Boolean.FALSE);
            }
            
            if(!mapOfRequestedDestination.isEmpty()){
                Set<ServiceItem> list = new HashSet<ServiceItem>(mapOfRequestedDestination.values());
    			oldCustomerService.setServiceItem(list);

            }
            customerServiceFacade.saveCustomerService(oldCustomerService);
			

		}
		return new ModelAndView(new RedirectView("serviceList"));
	}

	
	
    /**
     * Ação responsável por apresentar o formulário de edição do novo a
     * @param id
     * @param model
     * @param cs
     * @return destinationNegotiated
     */
    @RequestMapping(value = "editService", method = RequestMethod.GET)
    public String editService(@RequestParam Long id, @RequestParam Long cs,Model model) {
    	initializeComponents(model);
    	
    	this.cs = new CustomerService();
    	this.cs.setId(cs);

    	Customer customerId = customerFacade.getCustomerId(id);
    	getHistoryListCustomerId(model, customerId);
    	
    	List<ServiceItem> serviceItemAuxBD = new ArrayList<ServiceItem>();

    	//CustomerService customerServiceById = customerServiceFacade.getCustomerServiceById(cs);
    	//Set<ServiceItem> serviceItem = customerServiceById.getServiceItem();
    	for(ServiceItem serviceItemBD : serviceItemFacade.getAllServiceItems()){
    		if(serviceItemBD.getCustomerService().getId().equals(cs)){
    			serviceItemAuxBD.add(serviceItemBD);
    		}
    	}
    	
    	List<ServiceItem> serviceItemAux = new ArrayList<ServiceItem>();
    	
    	for(ServiceItem si : serviceItemAuxBD){
    		if(si.getSaleType() != SaleType.BOUGHT)
    			serviceItemAux.add(si);
    	}
    			
    			
    	model.addAttribute("destinationNegotiated", serviceItemAux);
        model.addAttribute("serviceModify", customerId);
        return "service/editService";
    }

	public void getHistoryListCustomerId(Model model, Customer customerId) {
		for(CustomerService cs : customerId.getCustomerService()){
    		List<History> historyMain = cs.getHistory();
    		model.addAttribute("historyList", historyMain);
    	}
	}
	
    /**
     * Ação responsável pela somatorio de um contador de orçamentos
     * @param model
     */
	public void countOfBudgets(Model model){
		List<ServiceItem> serviceItemList = serviceItemFacade.getAllServiceItems();
		
		int send_budget_var = 0;
		int submitted_budget_var = 0;
		
		for (ServiceItem serviceItem : serviceItemList) {
			if(serviceItem.getSaleType() == SaleType.SEND_BUDGET){
				send_budget_var ++;
				
			}else if(serviceItem.getSaleType() == SaleType.SUBMITTED_BUDGET){
				submitted_budget_var ++;
			}
		}
		model.addAttribute("send_budget_div", send_budget_var);
		model.addAttribute("submitted_budget_div", submitted_budget_var);
	}

    /**
     * Ação responsável por verificar se existem destinos negociados como "Orçamento Enviado ou Enviar Orçamento"
     * @return Boolean
     */
	public Boolean isOpenService() {
		//Verificar a lista e o banco
		if(!mapOfRequestedDestination.isEmpty()){
			for (ServiceItem serviceItem : mapOfRequestedDestination.values()) {
				if(serviceItem.getSaleType() == SaleType.SEND_BUDGET || serviceItem.getSaleType() == SaleType.SUBMITTED_BUDGET){
					return Boolean.TRUE;
				}
			}
		}
		
		if(!serviceItemFacade.getAllServiceItems().isEmpty()){
			for(ServiceItem serviceItem : serviceItemFacade.getAllServiceItems()){
				if(serviceItem.getSaleType() == SaleType.SEND_BUDGET || serviceItem.getSaleType() == SaleType.SUBMITTED_BUDGET){
					return Boolean.TRUE;
				}
			}
			
		}
		return Boolean.FALSE;
	}

    /**
     * Ação responsável por calcular o valor total dos orçamentos enviados
     * @param model
     */
	public void avgBudgets(Model model) {
		List<ServiceItem> serviceItemList = serviceItemFacade.getAllServiceItems();
		
		Double amount = 0.00;
		
		for (ServiceItem si : serviceItemList) {
			if (si.getSaleType() == SaleType.SEND_BUDGET) {
				Double price = si.getValueNegotiated();
				amount += price;
			}
		}
		model.addAttribute("totalAmount", amount);
	}
	
    /**
     * Ação responsável por adicionar passageiros
     * @param id
     * @param result
     * @param model
     * @return Passenger
     */
	@RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
	public @ResponseBody Passenger addPassenger(@Valid Passenger passenger, BindingResult result, Model model) {

		if (result.hasErrors()) {
			logger.warn("[Novo Atendimento] Validação de campos de adição de passageiros com falhas!");
			return null;
		} else {
			passengerList.add(passenger);
			initializeComponents(model);
			logger.info("[Novo Atendimento] Passageiro adicionado a lista...");
			return passenger;
		}

	}
	
    /**
     * Ação responsável por deletar um passageiro
     * @param id
     * @return ServiceItem
     */
	@RequestMapping(value="/deletePassenger/{id}", method=RequestMethod.DELETE)
	public @ResponseBody List<Passenger> deletePassagenger(@PathVariable Long id){
//		for (Passenger pas : passengerList) {
//			if (pas.get == id) {
//				serviceItemList.remove(sil);
//				logger.info("[Novo Atendimento] Destino excluido do atendimento...");
//				return serviceItemList;
//			}
//		}
//		return serviceItemList;
		return null;
	}
	
    /**
     * Ação responsável por deletar os destinos requisitados em um atendimento
     * @param id
     * @return ServiceItem
     */
	@RequestMapping(value="/deleteRequestedDestination", method=RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteRequestedDestination(@RequestParam(value = "idServiceItem") String idServiceItem,
			@RequestParam(value= "deleteType") Long id){
		if(id == 1){
			if(mapOfRequestedDestination.containsKey(idServiceItem)){
				mapOfRequestedDestination.remove(idServiceItem);				
			}		
		}else{
			//TODO: Futuramente para realizar a deleção de registros já incluidos em um atendimento
		}
	}
	
	/**
	 * Ação resposavel por editar um destino requisitado
	 * 
	 * @param id
	 * @param model
	 * @return ServiceItem
	 */
	@RequestMapping(value = "/editRequestedDestination/{id}/{update}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ServiceItem editRequestedDestination(
			@PathVariable String id, @PathVariable int update, Model model) {

		if (update == 0) {
			ServiceItem serviceItem = mapOfRequestedDestination.get(id);
			return serviceItem;
		} else {
			Long value = Long.valueOf(id);
			ServiceItem serviceItemById = serviceItemFacade.getServiceItemById((long) value);
			return serviceItemById;
		}
	}

	/**
     * Metodo responsavel por salvar/atualizar o destino requisitado, quando o atendimento já estiver sido persistido.
     * 
     * @param result
     * @param ServiceItem
     * @param model
     */
	@RequestMapping(value = "/saveOrUpdateDestinationRequested", method = RequestMethod.POST)
	public @ResponseBody ConcurrentHashMap<String, String> saveOrUpdateDestinationRequested(
			@RequestParam(value = "customerServiceId", required = false) Long customerServiceId,
			@RequestParam(value = "arrive", required = false) String arrive,
			@RequestParam(value = "departure", required = false) String departure,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "saletype", required = true) SaleType saletype,
			@RequestParam(value = "destinationId", required = true) Long destinationId,
			@RequestParam(value = "observations", required = false) String observations,
			@RequestParam(value = "ckb", required = true) Boolean ckb,
			@RequestParam(value = "destinationNegotiatedID", required = false) String destinationNegotiatedID,
			@RequestParam(value = "seeIn", required=true) String seeIn,
			RedirectAttributes redirectAttributes, Model model) {
    		    	
			Number valueFormated = formatStringPriceToNumberObject(price, redirectAttributes);
			Date arriveFormated = formatStringDateToDateObject(arrive, redirectAttributes);
			Date departureFormated = formatStringDateToDateObject(departure, redirectAttributes);
			Date seeInFormated = formatStringDateToDateObject(seeIn, redirectAttributes);
			
    		if (customerServiceId == null) {
    	        if (saletype.equals(SaleType.MAYBE_FUTURE) || saletype.equals(SaleType.SUBMITTED_BUDGET) || saletype.equals(SaleType.NOT_WANTED)) {    	        	
    	            if (!Strings.isNullOrEmpty(saletype.toString()) && !Strings.isNullOrEmpty(destinationId.toString()) && !Strings.isNullOrEmpty(seeIn)) {          		
    	            		if(!Strings.isNullOrEmpty(destinationNegotiatedID)){
    	            			if(mapOfRequestedDestination.containsKey(destinationNegotiatedID)){
    	            				ServiceItem serviceItem = mapOfRequestedDestination.get(destinationNegotiatedID);
    	            				mapOfRequestedDestination.remove(destinationNegotiatedID);
    	            				
    	            				ConcurrentHashMap<String, ServiceItem> saveOrUpdateRequestedDestination = saveOrUpdateRequestedDestination(saletype, destinationId, observations, ckb, valueFormated,
    	            						arriveFormated, departureFormated, serviceItem, destinationNegotiatedID, seeInFormated);
    	            				
	       	            			 ConcurrentHashMap<String, String> mapRequestedDestinationAux = new ConcurrentHashMap<String, String>();
	       							 mapRequestedDestinationAux.put(destinationNegotiatedID, saveOrUpdateRequestedDestination.get(destinationNegotiatedID).getDestination().getDtName());
	       							
	       	            			return mapRequestedDestinationAux;
    	            			}
    	            			
    	            			
    	            		}else{
        	            		ServiceItem serviceItem = new ServiceItem();
        	            		
        	            		String uniqueID = UUID.randomUUID().toString();
    	            			 Map<String, ServiceItem> saveOrUpdateRequestedDestination = saveOrUpdateRequestedDestination(saletype,
    									destinationId, observations, ckb,
    									valueFormated, arriveFormated,
    									departureFormated, serviceItem, uniqueID, seeInFormated);

    	            			 	
    	            			 ConcurrentHashMap<String, String> mapRequestedDestinationAux = new ConcurrentHashMap<String, String>();
    							 mapRequestedDestinationAux.put(uniqueID, saveOrUpdateRequestedDestination.get(uniqueID).getDestination().getDtName());
    							
    	            			return mapRequestedDestinationAux;
    	            			
    	            		}

    	            }
    	        } else {

    	            if ((!Strings.isNullOrEmpty(arrive.toString()) && !Strings.isNullOrEmpty(departure.toString()) && !Strings.isNullOrEmpty(price) && !Strings.isNullOrEmpty(saletype.toString()) && !Strings
    	                        .isNullOrEmpty(destinationId.toString())) && !departureFormated.after(arriveFormated) && !Strings.isNullOrEmpty(seeIn)) {
    	            	if(!Strings.isNullOrEmpty(destinationNegotiatedID)){
	            			if(mapOfRequestedDestination.containsKey(destinationNegotiatedID)){
	            				ServiceItem serviceItem = mapOfRequestedDestination.get(destinationNegotiatedID);
	            				mapOfRequestedDestination.remove(destinationNegotiatedID);
	            				
	            				ConcurrentHashMap<String, ServiceItem> saveOrUpdateRequestedDestination = saveOrUpdateRequestedDestination(saletype, destinationId, observations, ckb, valueFormated,
	            						arriveFormated, departureFormated, serviceItem, destinationNegotiatedID, seeInFormated);
	            				
       	            			 ConcurrentHashMap<String, String> mapRequestedDestinationAux = new ConcurrentHashMap<String, String>();
       							 mapRequestedDestinationAux.put(destinationNegotiatedID, saveOrUpdateRequestedDestination.get(destinationNegotiatedID).getDestination().getDtName());
       							
       	            			return mapRequestedDestinationAux;
	            			}
    	            	}else{
		            		ServiceItem serviceItem = new ServiceItem();
		            		
		            		String uniqueID = UUID.randomUUID().toString();
	            			 Map<String, ServiceItem> saveOrUpdateRequestedDestination = saveOrUpdateRequestedDestination(saletype,
									destinationId, observations, ckb,
									valueFormated, arriveFormated,
									departureFormated, serviceItem, uniqueID, seeInFormated);

	            			 	
	            			 ConcurrentHashMap<String, String> mapRequestedDestinationAux = new ConcurrentHashMap<String, String>();
							 mapRequestedDestinationAux.put(uniqueID, saveOrUpdateRequestedDestination.get(uniqueID).getDestination().getDtName());
							
	            			return mapRequestedDestinationAux;
    	            	}
    	            } else {
    	                redirectAttributes.addFlashAttribute("errUpdateDestinationRequested","Você precisa obrigatoriamente preencher todos os atributos!");
    	            }
    	        }
			} else {
				//Recupera do BD e retorna para o ajax
    	        if (saletype.equals(SaleType.MAYBE_FUTURE) || saletype.equals(SaleType.SUBMITTED_BUDGET) || saletype.equals(SaleType.NOT_WANTED)) {    	        	
    	            if (!Strings.isNullOrEmpty(saletype.toString()) && !Strings.isNullOrEmpty(destinationId.toString()) && !Strings.isNullOrEmpty(seeIn)) {
    	            	serviceItemFacade.serviceItemUpdate(arriveFormated, departureFormated, seeInFormated, valueFormated, observations, ckb, saletype, Long.parseLong(destinationNegotiatedID));
    	            }
    	            
    	        }else{
    	            if ((!Strings.isNullOrEmpty(arrive.toString()) && !Strings.isNullOrEmpty(departure.toString()) && !Strings.isNullOrEmpty(price) && !Strings.isNullOrEmpty(saletype.toString()) && !Strings
	                        .isNullOrEmpty(destinationId.toString())) && !departureFormated.after(arriveFormated) && !Strings.isNullOrEmpty(seeIn)) {
    	            	serviceItemFacade.serviceItemUpdate(arriveFormated, departureFormated, seeInFormated, valueFormated, observations, ckb, saletype, Long.parseLong(destinationNegotiatedID));
    	            }
    	        }

			}
			return null;
	}

	/**
	 * @param saletype
	 * @param destinationId
	 * @param observations
	 * @param ckb
	 * @param valueFormated
	 * @param arriveFormated
	 * @param departureFormated
	 * @param serviceItem
	 * @param serviceItemList
	 * @return
	 */
	private ConcurrentHashMap<String, ServiceItem> saveOrUpdateRequestedDestination(
			SaleType saletype, Long destinationId, String observations,
			Boolean ckb, Number valueFormated, Date arriveFormated,
			Date departureFormated, ServiceItem serviceItem, String uniqueID, Date seeIn) {
		
		serviceItem.setDestination(dashboardFacade.getDestinationId(destinationId));
		serviceItem.setArrivalDate(arriveFormated);
		serviceItem.setDepartureDate(departureFormated);
		serviceItem.setNegociationObservations(observations);
		serviceItem.setSaleType(saletype);
		serviceItem.setValueNegotiated(valueFormated.doubleValue());
		serviceItem.setRequestedDestination(ckb);
		serviceItem.setSeeIn(seeIn);
		serviceItem.setHashId(uniqueID);
		
		mapOfRequestedDestination.put(uniqueID, serviceItem);
		
		logger.info("[Novo Atendimento] Destino incluido com sucesso...");
		return mapOfRequestedDestination;
	}

		
	@RequestMapping(value="/getCustomerAJAX", method=RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomerAJAX(@RequestParam String paramName){
		
		List<Customer> customerByFirstName = customerFacade.getCustomerByFirstName(paramName, dashboardFacade.getAgency().getTenantId());
		List<Customer> customerList = new ArrayList<Customer>();
		for (Customer customer : customerByFirstName) {
			Customer c = new Customer();
			c.setIdCustomer(customer.getIdCustomer());
			c.setFirstName(customer.getFirstName());
			c.setLastName(customer.getLastName());
			c.setEmail(customer.getEmail());
			customerList.add(c);
		}
		return customerList;	
	}
	
	
	@InitBinder(value = "customer")
	public void bindingPreparationDate(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor birthDateEditor = new CustomDateEditor(df, false);
		binder.registerCustomEditor(Date.class, birthDateEditor);
	}

}