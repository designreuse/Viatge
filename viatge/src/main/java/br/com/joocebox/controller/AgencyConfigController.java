package br.com.joocebox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Agency;
import br.com.joocebox.model.AgencyConfig;
import br.com.joocebox.service.AgencyFacade;
import br.com.joocebox.service.DashboardFacade;

/**
 * Classe Controller para Configurações de uma Agência (AgencyConfig).
 * 
 * @author Bruno Neves.
 *
 */
@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")	
public class AgencyConfigController {

	@Autowired 
	private DashboardFacade dashboardFacade;
	@Autowired 
	private AgencyFacade agencyFacade;

	@RequestMapping("template-list")
	public ModelAndView getMenuTemplateList() {
		Agency agencyCurrent = dashboardFacade.getAgency();
		ModelAndView mv = new ModelAndView("website/templateList", "agConfig", agencyCurrent.getAgencyConfig());
		return mv;
	}
	
	@RequestMapping("template-selected")
	public String getTemplateSelected(@ModelAttribute("agConfig") AgencyConfig agConfigRef, Model model) {
		Agency agencyCurrent = dashboardFacade.getAgency();
		agencyCurrent.getAgencyConfig().setSiteTemplate(agConfigRef.getSiteTemplate());
		dashboardFacade.addAgency(agencyCurrent);
		
		model.addAttribute("agenciaUrl", this.getAgencyFullUrl(agencyCurrent));
		
		return "website/templateSelected";
	}
	
	//TODO: Retirar o método daqui e utilizar um genérico, que deve estar em Utils.
	/**
	 * Obtem URL da Agência
	 * 
	 * @param agency - Agência
	 * @return url
	 */
	private String getAgencyFullUrl(Agency agency) {
		String url = "http://" + agency.getSubdomain() + ".lvh.me:8080/viatge/site";
		//String url = "http://" + agency.getSubdomain() + ".joocebox.com:8080/viatge/site";
		return url;
	}
	
}