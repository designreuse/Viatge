package br.com.joocebox.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Customer;
import br.com.joocebox.service.CustomerFacade;
import br.com.joocebox.utils.JooceBoxUtils;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")
public class CustomerController {

	final static Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Autowired
	private CustomerFacade customerFacade;

	@RequestMapping("customer")
	public ModelAndView customerScreen() {
		return new ModelAndView("customer/newCustomer", "customer",
				new Customer());
	}

	@RequestMapping("customer-list")
	public ModelAndView customerListScreen() {
		List<Customer> allCustomers = customerFacade.getAllCustomers();
		ModelAndView mv = new ModelAndView("customer/customerList",
				"customerList", allCustomers);
		mv.addObject("customerCount", allCustomers.size());
		return mv;
	}

	@RequestMapping(value = "customer/history/{id}", method = RequestMethod.GET)
	public String customerHistoryScreen(@PathVariable Long id, Model model) {
		Customer customerId = customerFacade.getCustomerId(id);
		return "customer/history";
	}

	@RequestMapping(value = "customer/view/{id}", method = RequestMethod.GET)
	public String viewCustomer(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerFacade.getCustomerId(id));
		return "customer/customerDetails";
	}

	@RequestMapping(value = "customer/edit/{id}", method = RequestMethod.GET)
	public String editCustomer(@PathVariable Long id, Model model) {
		model.addAttribute("customerInformation",
				customerFacade.getCustomerId(id));
		return "customer/editCustomer";
	}

	@RequestMapping(value = "customer/add", method = { RequestMethod.PUT,
			RequestMethod.POST })
	public ModelAndView saveCustomer(
			@ModelAttribute("customerInformation") @Valid Customer customer,
			BindingResult result, ModelMap model) {

		if (customer.getIdCustomer() == null) {
			if (result.hasErrors()) {
				new JooceBoxUtils().validForm(result, model);
				return new ModelAndView("customer/newCustomer", "customer",
						customer);
			} else {
				customerFacade.save(customer);
				return new ModelAndView("redirect:/auth/customer-list");
			}
		} else {
			if (result.hasErrors()) {
				new JooceBoxUtils().validForm(result, model);
				return new ModelAndView("customer/editCustomer",
						"customerInformation", customer);
			} else {
				customerFacade.update(customer, customer.getIdCustomer());
				return new ModelAndView("redirect:/auth/customer-list");
			}

		}
	}
}