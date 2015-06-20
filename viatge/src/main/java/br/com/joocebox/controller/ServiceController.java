package br.com.joocebox.controller;

import static br.com.joocebox.utils.FormatObjects.formatStringDateToDateObject;
import static br.com.joocebox.utils.FormatObjects.formatStringPriceToNumberObject;

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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import br.com.joocebox.service.CustomerFacade;
import br.com.joocebox.service.CustomerServiceFacade;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.ServiceFacade;
import br.com.joocebox.service.ServiceItemFacade;
import br.com.joocebox.utils.JooceBoxUtils;

import com.google.common.base.Strings;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")
public class ServiceController{

	final static Logger logger = LoggerFactory
			.getLogger(ServiceController.class);

	@Autowired
	private ServiceFacade serviceFacade;
	
	@Autowired
	private CustomerFacade customerFacade;
	
	@Autowired
	private CustomerServiceFacade customerServiceFacade;
	
	@Autowired
	private DashboardFacade dashboardFacade;
	
	@Autowired
	private ServiceItemFacade serviceItemFacade;

	private Set<CustomerService> customerServiceList;
	
	private Set<Passenger> passengerList = new HashSet<Passenger>();
	
	ConcurrentHashMap<String, ServiceItem> mapOfRequestedDestination = new ConcurrentHashMap<String, ServiceItem>();
	
	private List<History> history;
	
	private CustomerService cs;
	

	@RequestMapping("/service")
	public ModelAndView getMenuService(ModelMap model) {
		initializeComponents(model);
		model.addAttribute("requestedDestination", new ServiceItem());
		return new ModelAndView("service/newService", "customer", new Customer());
	}
	
	public void initializeComponents(ModelMap model) {
		// Carrega os destinos no componente de DropDown
		List<Destination> destinationList = dashboardFacade.getDestinationList();
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
     * Ação responsável por adicionar ou atualizar o atendimento que está em aberto.
     * @param Customer
     * @param result
     * @param model
     * @return ModelAndView
     */
	@RequestMapping(value = "/add-service", method = RequestMethod.POST)
	public ModelAndView addService(@ModelAttribute("customer") @Valid @RequestBody Customer customer, BindingResult result, ModelMap model) {
		
        if (result.hasErrors()) {
        	new JooceBoxUtils().validForm(result, model);
            initializeComponents(model);
            return new ModelAndView("service/newService", "customer", customer);
        } else {
    		if(customer.getIdCustomer() == null){
    			customerFacade.save(customer);
    			return new ModelAndView(new RedirectView("serviceList"));
    		}else{
    			//edita o cliente
    			return new ModelAndView(new RedirectView("serviceList"));
    		}
        }
	}

    /**
     * Ação responsável por apresentar o formulário de edição do novo a
     * @param id
     * @param model
     * @param cs
     * @return destinationNegotiated
     */
    @RequestMapping(value = "editService", method = RequestMethod.GET)
    public String editService(@RequestParam Long id, @RequestParam Long cs, ModelMap model) {
    	initializeComponents(model);
    	
    	this.cs = new CustomerService();
    	this.cs.setId(cs);

    	Customer customerId = customerFacade.getCustomerId(id);
    	//getHistoryListCustomerId(model, customerId);
    	
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

//	public void getHistoryListCustomerId(ModelMap model, Customer customerId) {
//		for(CustomerService cs : customerId.getCustomerService()){
//    		List<History> historyMain = cs.getHistory();
//    		model.addAttribute("historyList", historyMain);
//    	}
//	}

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
     * Ação responsável por adicionar passageiros
     * @param id
     * @param result
     * @param model
     * @return Passenger
     */
	@RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
	public @ResponseBody Passenger addPassenger(@Valid Passenger passenger, BindingResult result, ModelMap model) {

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
    		    	
			Number valueFormated = formatStringPriceToNumberObject(price);
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
		
		List<Customer> customerByFirstName = customerFacade.getCustomerByFirstName(paramName, dashboardFacade.getAgency().getId());
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

}