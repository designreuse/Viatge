package br.com.joocebox.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.joocebox.model.Agency;
import br.com.joocebox.model.Article;
import br.com.joocebox.model.Category;
import br.com.joocebox.model.CategoryBlog;
import br.com.joocebox.model.Customer;
import br.com.joocebox.model.CustomerPhone;
import br.com.joocebox.model.CustomerService;
import br.com.joocebox.model.Destination;
import br.com.joocebox.model.ServiceItem;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.service.ArticleBlogFacade;
import br.com.joocebox.service.CategoryBlogFacade;
import br.com.joocebox.service.CustomerFacade;
import br.com.joocebox.service.CustomerServiceFacade;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.DestinationFacade;
import br.com.joocebox.service.ServiceItemFacade;
import br.com.joocebox.utils.FormatObjects;

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
    private CustomerFacade customerFacade;
    @Autowired
    private CustomerServiceFacade customerServiceFacade;
    @Autowired
    private ServiceItemFacade serviceItemFacade;
    
    @Autowired
    private CurrentTenantResolver<Long> tenantResolver;
    @Autowired
    private ArticleBlogFacade articleBlogFacade;
    @Autowired
    private CategoryBlogFacade categoryBlogFacade;
    
    
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
		getDestinationsForWebSite(model);
		session.setAttribute("tenant", agency);
		model.addAttribute("destination", new Destination());
		logger.info("Buscando agência e adicionando seus atributos");
		headerFooterData(session);
		
		if (agency.getAgencyConfig().getSiteTemplate() == 1) {
			return "site/index";
		} else {
			return "site/index02";
		}
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
	public String getDestinationDetail(@PathVariable Long destinationId,  Model model, HttpSession session){
		Agency agency = dashboardFacade.getAgency();
		
		model.addAttribute("destinationDetail",dashboardFacade.getDestinationId(destinationId));
		model.addAttribute("agencyDetail", agency);
		headerFooterData(session);
		
		if(agency.getAgencyConfig().getSiteTemplate() == 1){
			return "site/destinationDetail";
		}else{
			return "site/destinationDetail02";
		}
		
	}
	
	@RequestMapping("/category-list/{id}")
	public String getCategoryList(@PathVariable Long id, Model model, HttpSession session){
		Agency agency = dashboardFacade.getAgency();
		
		Category categoryId = dashboardFacade.getCategoryId(id);
		model.addAttribute("listOfDestinationByCategory", categoryId.getDestination());
		headerFooterData(session);
		
		if(agency.getAgencyConfig().getSiteTemplate() == 1){
			return "site/categoryList";
		}else{
			return "site/categoryList02";
		}
	}
	
	@RequestMapping("/contact")
	public String getContactPage(HttpSession session){
		headerFooterData(session);
		//TODO: Implementar as atributos para a view
		
		return "site/contact02";
	}
	
	@RequestMapping("/about-us")
	public String getAboutUsPage(HttpSession session){
		headerFooterData(session);
		//TODO: Implementar as atributos para a view
		
		return "site/aboutUs02";
	}
	
	//--------- BLOG ---------------------------------------------------------------------------
	@RequestMapping("/blog")
	public ModelAndView getBlogPage(HttpSession session){
		ModelAndView mv = new ModelAndView("site/blog02");
		mv.addObject("categories", categoryBlogFacade.getAtivesCategoriesBlog());
		mv.addObject("articlesBlog", articleBlogFacade.findActivesArticles());
		headerFooterData(session);
		
		return mv;
	}
	
	@RequestMapping("/blog/post/{idArticle}")
	public ModelAndView getPostPage(@PathVariable Long idArticle, HttpSession session){
		Article articleId = articleBlogFacade.getArticleBlogId(idArticle);
		ModelAndView mv = new ModelAndView("site/post02", "articleCurrent", articleId);
		mv.addObject("categories", categoryBlogFacade.getAtivesCategoriesBlog());
		headerFooterData(session);
		return mv;
	}
	
	@RequestMapping(value="/blog/category", method=RequestMethod.GET)
	public ModelAndView getPostCategory(@RequestParam Long id, HttpSession session) {
		CategoryBlog cb = categoryBlogFacade.getCategoryBlogId(id);
		List<Article> articles = articleBlogFacade.findByCategoryBlogAndAtActive(cb);
		ModelAndView mv = new ModelAndView("site/blog02", "articlesBlog", articles);
		mv.addObject("categories", categoryBlogFacade.getAtivesCategoriesBlog());
		headerFooterData(session);
		return mv;
	}
	//--------- FIM BLOG ---------------------------------------------------------------------------
	
	@RequestMapping("/online-shop")
	public String getonlineShopPage(HttpSession session){
		headerFooterData(session);
		//TODO: Implementar as atributos para a view
		
		return "site/onlineShop02";
	}
	
	@RequestMapping("/perfect-travel")
	public ModelAndView getPerfectTravelPage(HttpSession session){
		headerFooterData(session);
		return new ModelAndView("site/perfectTravel02", "agencyName", dashboardFacade.getAgency().getAgencyName());
	}
	
	//--------- ORÇAMENTO BLOG ---------------------------------------------------------------------------
	private final Map<String, Object> budgetForm = new HashMap<String, Object>();
	public Map<String, Object> getBudgetForm() { return budgetForm; }
	
	@RequestMapping(value="/budget/{idDestination}", method=RequestMethod.GET)
	public ModelAndView getBudgetPage(@CookieValue(value="jb_client_email", defaultValue="defaultValue") String emailCookie, @PathVariable Long idDestination, HttpSession session){
		//emailCookie = "seven@seventur.com";
		
		Customer customerForm = customerFacade.getCustomerByEmail(emailCookie);	
		Destination destinationForm = destinationFacade.getDestinationById(idDestination);
		CustomerService cServiceForm;
		
		if (customerForm == null) {
			customerForm = new Customer();
			customerForm.setCustomerPhone(new CustomerPhone());
			cServiceForm = new CustomerService();
		} else {
			cServiceForm = customerServiceFacade.getCustomerServiceByCustomer(customerForm);
		}
		
		budgetForm.put("customerForm", customerForm);
		budgetForm.put("destinationForm", (destinationForm == null ? new Destination() : destinationForm));
		budgetForm.put("cServiceIdForm", cServiceForm.getId());
		headerFooterData(session);
		ModelAndView mv = new ModelAndView("site/budget02", budgetForm);
		return mv;
	}
	
	@RequestMapping(value="/budget/enviarOrcamento", method=RequestMethod.POST)
	public String sendingBudget(@ModelAttribute("customerForm") Customer customerForm,
								@RequestParam Long customerId, 
								@RequestParam Long destinationId,
								@RequestParam Long customerServiceId,
								@RequestParam(value = "ida", required = false) String ida,
								@RequestParam(value = "volta", required = false) String volta ,
								@RequestParam String observacoes,
								@RequestParam(value = "vinculo", required = false) String vinculo,
								@RequestParam(value = "acompanhante[]", required = false)  String acompanhante,
								@RequestParam(value = "idade[]", required = false) String idade,
								BindingResult result, HttpServletRequest req, RedirectAttributes redirectAttributes, Model model, HttpSession session) {

		Destination destinationSelected = destinationFacade.getDestinationById(destinationId);
		if (result.hasErrors()) {
			req.setAttribute("validator", true);
			return "redirect:/site";
		} else {
			Customer customer;
			if (customerId != null) {
				customer = customerFacade.getCustomerId(customerId);				
			} else {
				customer = new Customer();
				customer.setCustomerPhone(new CustomerPhone());
				
			}
			customer.setFirstName(customerForm.getFirstName());
			customer.setLastName(customerForm.getLastName());
			customer.setEmail(customerForm.getEmail());
			customer.getCustomerPhone().setHomePhone(customerForm.getCustomerPhone().getHomePhone());
			customer.getCustomerPhone().setCelPhone(customerForm.getCustomerPhone().getCelPhone());
			customer.setPassenger(customerFacade.returnPassangersBudget(vinculo, acompanhante, idade));
			
			CustomerService cService = new CustomerService();
			if (customerServiceId != null) {
				cService = customerServiceFacade.findById(customerServiceId);
			}			
			customer.setCustomerService(cService);
			Date dataIda = FormatObjects.formatStringDateToDateObject(ida, redirectAttributes);
			Date dataVolta = FormatObjects.formatStringDateToDateObject(volta, redirectAttributes);
			
			ServiceItem sItem = new ServiceItem(destinationSelected, cService, dataIda, dataVolta, observacoes, new Date());
			cService.setServiceItem(new HashSet<ServiceItem>());
			cService.getServiceItem().add(sItem);
			//save customer
			customerFacade.save(customer);
			//save customerService
			customerServiceFacade.saveCustomerService(cService);
			//save serviceItem
			serviceItemFacade.saveServiceItem(sItem);
			
			model.addAttribute("customerForm", customer);
			model.addAttribute("destinationForm", destinationSelected);
			headerFooterData(session);
			return "site/submittedBudget02";
		}
	}	
	//--------- FIM ORÇAMENTO BLOG ---------------------------------------------------------------------------
	
	@RequestMapping("/templateColorCodHex")
	@ResponseBody
	public String getCodHex(HttpSession session){
		headerFooterData(session);
		return dashboardFacade.getAgency().getAgencyConfig().getTemplateColor();
	}
	
	@RequestMapping(value = "/add-new-customer", method = RequestMethod.GET)
	@ResponseBody
	public void saveCustomerBySite(String name, String email, HttpSession session){
		headerFooterData(session);
		customerFacade.saveCustomerBySite(name, email);
	}
	
	@RequestMapping(value = "/perfect-travel-filter", method = RequestMethod.GET)
	public ModelAndView getDestinations(@RequestParam String social, @RequestParam String economic, @RequestParam String trip, @RequestParam String weather, @RequestParam String general, Model model, HttpSession session) throws SQLException{
		headerFooterData(session);
		if(Strings.isNullOrEmpty(social) || Strings.isNullOrEmpty(economic) || Strings.isNullOrEmpty(trip) || Strings.isNullOrEmpty(weather) || Strings.isNullOrEmpty(general)){
			return new ModelAndView("site/destinations02", "perfectDestinationError", true);
		}else{
			return new ModelAndView("site/destinations02", "perfectDestinations", destinationFacade.filterDestinations(economic, general, social, weather, trip));
		}

	}
	
	/**
	 * Este método é utilizado para colocar na sessão todos os valores fixo do site, no cabelçalho ou rodapé.
	 * Exemplo: Artigos do blog, que vão aparecer no rodapé, de todas as páginas do site.
	 * @param session
	 */
    public void headerFooterData(HttpSession session) {
    	try {
    		Object objectArticle = session.getAttribute("articlesFooter");
    		Object objectCategory = session.getAttribute("categoryListSession");
    		if(objectArticle == null) {
    			session.setAttribute("articlesFooterSession", articleBlogFacade.findActivesArticles());
    		}
    		if (objectCategory == null) {
    			session.setAttribute("categoryListSession", dashboardFacade.getCategoryList());
			}
    	} catch(IllegalStateException ise) {    		
    	}
    }
	
}