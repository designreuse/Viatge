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

import br.com.joocebox.model.Agency;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.service.DashboardFacade;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	// Injeção de dependências
	@Autowired
	private DashboardFacade dashboardFacade;

	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;

	// Entra no DashBoard do Tenant(Agência)
	@RequestMapping(value = {"/login"}, method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
	public String switchRequest(Model model) {
		if (tenantResolver.isMasterTenant() || tenantResolver.isSubDomainExist()) {
			//model.addAttribute("tenant", tenant);
			return "landing/login";
		}
		throw new ResourceNotFoundException();
	}

	// Adiona o objeto na tenant do Tipo agencia na view
	@ModelAttribute("tenant")
	public Agency getAgencyObject() {
		return new Agency();
	}
	
    @ExceptionHandler(ResourceNotFoundException.class)
	    public String handleResourceNotFoundException() {
	        return "error/notFound";
	    }

}