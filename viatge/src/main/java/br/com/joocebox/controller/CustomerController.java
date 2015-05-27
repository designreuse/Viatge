package br.com.joocebox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Customer;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
@RequestMapping("/auth")
public class CustomerController {
	
	final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping("customer-list")
	public ModelAndView customerListScreen(){
		ModelAndView mv = new ModelAndView("customer/customerList", "customerList", new Customer());
		return mv;
	}

}
