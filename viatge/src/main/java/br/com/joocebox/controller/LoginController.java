package br.com.joocebox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.joocebox.model.Login;
import br.com.joocebox.multitenancy.CurrentTenantResolver;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;

	// Entra no DashBoard do Tenant(Agência)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String switchRequest(Model model) {
		if (tenantResolver.isMasterTenant() || tenantResolver.isSubDomainExist()) {
			return "landing/login";
		}
		throw new ResourceNotFoundException();
	}

	// Adiona o objeto na tenant do Tipo agencia na view
	@ModelAttribute("tenant")
	public Login getAgencyObject() {
		return new Login();
	}
	
    @ExceptionHandler(ResourceNotFoundException.class)
	    public String handleResourceNotFoundException() {
	        return "error/notFound";
	    }

}