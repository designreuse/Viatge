package br.com.joocebox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Customer;
import br.com.joocebox.service.CustomerFacade;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
@RequestMapping("/auth")
public class CustomerController {
	
	final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerFacade customerFacade;
	
	@RequestMapping("customer-list")
	public ModelAndView customerListScreen(){
		List<Customer> allCustomers = customerFacade.getAllCustomers();	
		ModelAndView mv = new ModelAndView("customer/customerList", "customerList", allCustomers);
		mv.addObject("customerCount", allCustomers.size());
		return mv;
	}
	
	@RequestMapping(value = "customer/view/{id}", method = RequestMethod.GET)
	public String viewCustomer(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerFacade.getCustomerId(id));   
		return "customer/customerDetails";
	}

}
