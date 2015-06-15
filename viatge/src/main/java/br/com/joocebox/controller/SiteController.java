package br.com.joocebox.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Agency;
import br.com.joocebox.model.Article;
import br.com.joocebox.model.Category;
import br.com.joocebox.model.CategoryBlog;
import br.com.joocebox.model.Destination;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.service.ArticleBlogFacade;
import br.com.joocebox.service.CategoryBlogFacade;
import br.com.joocebox.service.DashboardFacade;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
public class SiteController {
    final static Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private DashboardFacade dashboardFacade;    
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
	
	@RequestMapping("/about-us")
	public String getAboutUsPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/aboutUs02";
	}
	
	//--------- BLOG ---------------------------------------------------------------------------
	@RequestMapping("/blog")
	public ModelAndView getBlogPage(){
		List<Article> articlesBlog = articleBlogFacade.getAtivesArticlesBlog();
		// Diminui o conteudo do artigo para 50 caracteres, para exibirmos na tela principal do blog.
		for(Article at : articlesBlog) {
			at.setReducedContent(at.getAtContent().substring(0, 100));
		}
		ModelAndView mv = new ModelAndView("site/blog02", "articlesBlog", articlesBlog);
		mv.addObject("categories", categoryBlogFacade.getAtivesCategoriesBlog());
		
		return mv;
	}
	
	@RequestMapping("/blog/post/{idArticle}")
	public ModelAndView getPostPage(@PathVariable Long idArticle){
		Article articleId = articleBlogFacade.getArticleBlogId(idArticle);
		ModelAndView mv = new ModelAndView("site/post02", "articleCurrent", articleId);
		mv.addObject("categories", categoryBlogFacade.getAtivesCategoriesBlog());
		return mv;
	}
	
	@RequestMapping(value="/blog/category", method=RequestMethod.GET)
	public ModelAndView getPostCategory(@RequestParam Long id) {
		CategoryBlog cb = categoryBlogFacade.getCategoryBlogId(id);
		ModelAndView mv = new ModelAndView("site/blog02", "articlesBlog", cb.getArticlesBlog());
		mv.addObject("categories", categoryBlogFacade.getAtivesCategoriesBlog());
		return mv;
	}
	//--------- FIM BLOG ---------------------------------------------------------------------------
	
	@RequestMapping("/online-shop")
	public String getonlineShopPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/onlineShop02";
	}
	
	@RequestMapping("/perfect-travel")
	public String getPerfectTravelPage(){
		//TODO: Implementar as atributos para a view
		
		return "site/perfectTravel02";
	}
	
	@RequestMapping("/templateColorCodHex")
	@ResponseBody
	public String getCodHex(){
		return dashboardFacade.getAgency().getAgencyConfig().getTemplateColor();
	}
	
	@RequestMapping(value = "/perfect-travel-filter", method = RequestMethod.POST)
	public String getDestinations(@ModelAttribute("destination") Destination destination){
		//Busca por um metodo que faça a pesquisa
		return "site/destinations02";
	}

}
