package br.com.joocebox.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Customer;
import br.com.joocebox.model.Destination;
import br.com.joocebox.model.FamilyBond;
import br.com.joocebox.model.SaleType;
import br.com.joocebox.model.ServiceItem;
import br.com.joocebox.service.CustomerFacade;
import br.com.joocebox.service.DashboardFacade;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")
public class ServiceController{

	final static Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private CustomerFacade customerFacade;
	
	@Autowired
	private DashboardFacade dashboardFacade;
	
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
     * @return Lista de Atendimentos
     */
	@RequestMapping(value = "/add-service", method = RequestMethod.POST)
	public String addService(@RequestBody Customer customer) {
		if(customer.getIdCustomer() == null){
			//customerFacade.save(customer);
		}else{
			//Realiza o update
		}
		return "redirect:/auth/serviceList";
	}

    /**
     * Ação responsável por apresentar o formulário de edição do novo a
     * @param id
     * @param model
     * @return destinationNegotiated
     */
    @RequestMapping(value = "edit-service", method = RequestMethod.GET)
    public @ResponseBody ModelAndView editService(@RequestParam Long id, ModelMap model) {
    	initializeComponents(model);  	
        return new ModelAndView("service/editService", "serviceModify", new Customer());
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