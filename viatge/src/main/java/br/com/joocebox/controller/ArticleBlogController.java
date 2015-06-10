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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.joocebox.model.Article;
import br.com.joocebox.model.CategoryBlog;
import br.com.joocebox.service.ArticleBlogFacade;
import br.com.joocebox.service.CategoryBlogFacade;

/**
 * Classe Controller para controle das views dos Artigos do Blog.
 * 
 * @author Bruno Neves.
 *
 */
@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/auth")	
public class ArticleBlogController {
    final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private ArticleBlogFacade articleBlogFacade;
	@Autowired
	private CategoryBlogFacade categoryBlogFacade;

	@RequestMapping("article-blog-list")
	public ModelAndView getMenuArticleBlogList() {
		List<Article> articlesBlogList = articleBlogFacade.getArticlesBlogList();
		ModelAndView mv = new ModelAndView("blog/articleBlogList", "articlesBlogList", articlesBlogList);
		mv.addObject("categoryBlogList", categoryBlogFacade.getAtivesCategoriesBlog());
		mv.addObject("categoryBlog", new CategoryBlog());
		return mv;
	}

    @RequestMapping("new-article-blog")
    public String newArticleBlog(Model model) {
        model.addAttribute("articleBlogForm", new Article());
        model.addAttribute("categoryBlogList", categoryBlogFacade.getAtivesCategoriesBlog());
        model.addAttribute("action", "addArticleBlog");
        return "blog/newArticleBlog";
    }

    @RequestMapping(value = "addArticleBlog", method = RequestMethod.POST)
    public String addArticleBlog(@ModelAttribute("articleBlog") @Valid Article articleBlog, BindingResult result, HttpServletRequest req, RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            req.setAttribute("validator", true);
            return newArticleBlog(model);
        } else {
        	articleBlog.setAtActive(1);
        	articleBlog.getAtName().trim();
        	CategoryBlog cb = categoryBlogFacade.getCategoryBlogId(articleBlog.getCategoryBlog().getIdCategoryBlog());
        	articleBlog.setCategoryBlog(cb);
        	articleBlogFacade.addArticleBlog(articleBlog);
        	redirectAttributes.addFlashAttribute("message", "O Artigo " + articleBlog.getAtName() + " foi adicionado com sucesso!");
            return "redirect:article-blog-list";
        }
    }

    /**
     * Ação responsável por apresentar o formulário de edição do artigo(Blog).
     * @param id
     * @param model
     * @return 
     */
    @RequestMapping(value = "edit-article-blog/{id}", method = RequestMethod.GET)
    public String editArticleBlog(@PathVariable("id") Long id, Model model) {
    	
        model.addAttribute("articleBlogForm", articleBlogFacade.getArticleBlogId(id));
        model.addAttribute("categoryBlogList", categoryBlogFacade.getAtivesCategoriesBlog());
        model.addAttribute("action", "update-article-blog");
        return "blog/updateArticleBlog";
    }

    /**
     * Método responsável por disponibilizar os dados para visualização do artigo do blog.
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "visualize-article-blog/{id}", method = RequestMethod.GET)
    public String visualizeArticleBlog(@PathVariable("id") Long id, Model model) {
        model.addAttribute("articleBlogForm", articleBlogFacade.getArticleBlogId(id));
        model.addAttribute("action", "edit-article-blog");
        return "blog/visualizeArticleBlog";
    }
    
    /**
     * Ação responsável por atualizar os dados enviados pelo formulário.
     * 
     * @param articleBlog
     * @param result
     * @param id
     * @param atName
     * @param model
     * @return 
     */
    @RequestMapping(value = "update-article-blog", method = RequestMethod.POST)
    public String updateArticle(@ModelAttribute("articleBlogForm") @Valid Article articleBlog, BindingResult result, @RequestParam Long id, Model model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
          model.addAttribute("validator", true);
          return editArticleBlog(id, model);
		} else {
            articleBlogFacade.articleBlogUpdate(articleBlog, id);
        	redirectAttributes.addFlashAttribute("message", "O Artigo " + articleBlog.getAtName() + " foi alterado com sucesso!");
            return "redirect:article-blog-list";
        }
    }
}