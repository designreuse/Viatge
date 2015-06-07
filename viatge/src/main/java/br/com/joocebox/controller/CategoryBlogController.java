package br.com.joocebox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	private CategoryBlogFacade categoryBlogFacade;
	
	@RequestMapping("category-blog-list")
	public ModelAndView getMenuCategoryBlogList() {
		List<CategoryBlog> categoriesBlogList = categoryBlogFacade.getCategoriesBlogList();
		ModelAndView mv = new ModelAndView("blog/categoryBlogList", "categoriesBlogList", categoriesBlogList);
		return mv;
	}
}