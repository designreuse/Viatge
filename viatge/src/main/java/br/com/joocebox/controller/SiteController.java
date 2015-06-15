package br.com.joocebox.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Agency;
import br.com.joocebox.model.Category;
import br.com.joocebox.model.Destination;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.DestinationFacade;

import com.google.common.base.Strings;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
public class SiteController{

	final static Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private DashboardFacade dashboardFacade;
    
    @Autowired
    private DestinationFacade destinationFacade;
    
    @Autowired
    private CurrentTenantResolver<Long> tenantResolver;
    
    
	/**
	 * Método utilizado para apresentar os dados do tenant corrente no site.
	 *  
	 * @return String
	 */
	@RequestMapping("/site")
	public String siteTemplate(Model model, HttpSession session){
		
		if (tenantResolver.isMasterTenant() || !tenantResolver.isSubDomainExist()) {
			model.addAttribute("tenant", new Agency());
			return "landing/register";		
		}

		Agency agency = dashboardFacade.getAgency();
		String agencyLogo = agency.getAgencyConfig().getAgencyLogo();
		
		String fileName = agencyLogo.replace("/app/joocebox-img/"+agency.getSubdomain()+"/logo/", "");
		agency.getAgencyConfig().setAgencyLogo(fileName);
		getAllCategories(model);
		getDestinationsForWebSite(model);
		session.setAttribute("tenant", agency);
		model.addAttribute("destination", new Destination());
		logger.info("Buscando agência e adicionando seus atributos");
		
		
		if (agency.getAgencyConfig().getSiteTemplate() == 1) {
			return "site/index";
		} else {
			return "site/index02";
		}
	}
	
	/**
	 * Método utilizado para-se recuperar todas as categorias do site.
	 * @param Model model
	 */
	public void getAllCategories(Model model){
		List<Category> categoryList = dashboardFacade.getCategoryList();
		model.addAttribute("categoryList", categoryList);		
	}
	
	/**
	 * Método utilizado para-se recuperar todos os destinos de destaque no site.
	 * @param Model model
	 */
	public void getDestinationsForWebSite(Model model){
		List<Destination> destinationList = dashboardFacade.getDestinationList();
		List<Destination> destinationHightlightList = new ArrayList<Destination>();
		List<Destination> destinationAppearInWebSiteList = new ArrayList<Destination>();
				
		for (Destination destination : destinationList) {
			if(destination.getDtHighlightWebsite()){
				destinationHightlightList.add(destination);
			}else if (destination.getDtAppearWebsite()) {
				destinationAppearInWebSiteList.add(destination);
			}
		}
		model.addAttribute("destinationAppearInWebSiteList", destinationAppearInWebSiteList);
		model.addAttribute("destinationHightlightList", destinationHightlightList);
	}
	
	//------------------------------------------------------------------------------------------
	
	@RequestMapping("/destinationDetail/{destinationId}")
	public String getDestinationDetail(@PathVariable Long destinationId,  Model model){
		Agency agency = dashboardFacade.getAgency();
		
		model.addAttribute("destinationDetail",dashboardFacade.getDestinationId(destinationId));
		model.addAttribute("agencyDetail", agency);
		
		if(agency.getAgencyConfig().getSiteTemplate() == 1){
			return "site/destinationDetail";
		}else{
			return "site/destinationDetail02";
		}
		
	}
	
	@RequestMapping("/category-list/{id}")
	public String getCategoryList(@PathVariable Long id, Model model){
		Agency agency = dashboardFacade.getAgency();
		
		Category categoryId = dashboardFacade.getCategoryId(id);
		model.addAttribute("listOfDestinationByCategory", categoryId.getDestination());
		
		if(agency.getAgencyConfig().getSiteTemplate() == 1){
			return "site/categoryList";
		}else{
			return "site/categoryList02";
		}
	}
	
	@RequestMapping("/contact")
	public String getContactPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/contact02";
	}
	
	@RequestMapping("/blog")
	public String getBlogPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/blog02";
	}
	
	@RequestMapping("/blog/post")
	public String getPostPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/post02";
	}
	
	@RequestMapping("/about-us")
	public String getAboutUsPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/aboutUs02";
	}
	
	@RequestMapping("/online-shop")
	public String getonlineShopPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/onlineShop02";
	}
	
	@RequestMapping("/perfect-travel")
	public ModelAndView getPerfectTravelPage(){		
		return new ModelAndView("site/perfectTravel02", "agencyName", dashboardFacade.getAgency().getAgencyName());
	}
	
	@RequestMapping("/budget")
	public String getBudgetPage(){
		//TODO: Implementar as atributos para a view		
		return "site/budget02";
	}
	
	@RequestMapping("/templateColorCodHex")
	@ResponseBody
	public String getCodHex(){
		return dashboardFacade.getAgency().getAgencyConfig().getTemplateColor();
	}
	
	@RequestMapping(value = "/perfect-travel-filter", method = RequestMethod.GET)
	public ModelAndView getDestinations(@RequestParam String social, @RequestParam String economic, @RequestParam String trip, @RequestParam String weather, @RequestParam String general, Model model) throws SQLException{
		if(Strings.isNullOrEmpty(social) || Strings.isNullOrEmpty(economic) || Strings.isNullOrEmpty(trip) || Strings.isNullOrEmpty(weather) || Strings.isNullOrEmpty(general)){
			return new ModelAndView("site/destinations02", "perfectDestinationError", true);
		}else{
			return new ModelAndView("site/destinations02", "perfectDestinations", destinationFacade.filterDestinations(economic, general, social, weather, trip));
		}

	}

}
