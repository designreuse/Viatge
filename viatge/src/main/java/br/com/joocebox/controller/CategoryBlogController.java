package br.com.joocebox.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.joocebox.model.CategoryBlog;
import br.com.joocebox.service.CategoryBlogFacade;

/**
 * Classe Controller para controle das views de Categoria do Blog.
 * 
 * @author Bruno Neves.
 *
 */
@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")	
public class CategoryBlogController {
    final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryBlogFacade categoryBlogFacade;
	
	@RequestMapping("category-blog-list")
	public ModelAndView getMenuCategoryBlogList() {
		List<CategoryBlog> categoriesBlogList = categoryBlogFacade.getCategoriesBlogList();
		ModelAndView mv = new ModelAndView("blog/categoryBlogList", "categoriesBlogList", categoriesBlogList);
		return mv;
	}

    @RequestMapping("new-category-blog")
    public String newCategoryBlog(Model model) {
        model.addAttribute("categoryBlogForm", new CategoryBlog());
        model.addAttribute("action", "addCategoryBlog");
        return "blog/newCategoryBlog";
    }
    
    @RequestMapping(value = "addCategoryBlog", method = RequestMethod.POST)
    public String addCategoryBlog(@ModelAttribute("categoryBlog") @Valid CategoryBlog categoryBlog, BindingResult result, HttpServletRequest req, RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            req.setAttribute("validator", true);
            return newCategoryBlog(model);
        } else {
        	categoryBlog.setCtBgActive(1);
        	categoryBlog.getCtBgName().trim();
        	categoryBlogFacade.addCategoryBlog(categoryBlog);
        	redirectAttributes.addFlashAttribute("message", "A categoria " + categoryBlog.getCtBgName() + " foi adicionada com sucesso!");
            return "redirect:category-blog-list";
        }
    }
    
    /**
     * Ação responsável por apresentar o formulário da categoria(Blog)
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = "edit-category-blog", method = RequestMethod.GET)
    public String editCategoryBlog(Long id, Model model) {
        model.addAttribute("categoryBlogForm", categoryBlogFacade.getCategoryBlogId(id));
        model.addAttribute("action", "update-category-blog");
        return "blog/updateCategoryBlog";
    }
    
    /**
     * Ação responsável por atualizar os dados enviados pelo formulário.
     * 
     * @param categoryBlog
     * @param result
     * @param id
     * @param ctBgName
     * @param model
     * @return 
     */
    @RequestMapping(value = "update-category-blog", method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("categoryBlogForm") @Valid CategoryBlog categoryBlog, BindingResult result, @RequestParam Long id, @RequestParam String ctBgName, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("validator", true);
            return editCategoryBlog(id, model);
        } else {
            categoryBlogFacade.categoryBlogUpdate(ctBgName, id);
            return "redirect:category-blog-list";
        }
    }
}