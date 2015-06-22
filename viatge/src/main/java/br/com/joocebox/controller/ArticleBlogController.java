package br.com.joocebox.controller;

import java.io.File;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;

import br.com.joocebox.model.Article;
import br.com.joocebox.model.CategoryBlog;
import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.Image;
import br.com.joocebox.service.ArticleBlogFacade;
import br.com.joocebox.service.CategoryBlogFacade;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.utils.JooceBoxProperties;

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
	@Autowired
	private DashboardFacade dashboardFacade;
	@Autowired
	public FileArticleBlogController fileController;

	@RequestMapping("article-blog-list")
	public ModelAndView getMenuArticleBlogList() {
		List<Article> articlesBlogList = articleBlogFacade.findActivesArticles();
		ModelAndView mv = new ModelAndView("blog/articleBlogList", "articlesBlogList", articlesBlogList);
		mv.addObject("categoryBlogList", categoryBlogFacade.getAtivesCategoriesBlog());
		mv.addObject("categoryBlog", new CategoryBlog());
		return mv;
	}

    @RequestMapping("new-article-blog")
    public String newArticleBlog(Model model) {
    	fileController.deleteTmp();
        model.addAttribute("articleBlogForm", new Article());
        model.addAttribute("categoryBlogList", categoryBlogFacade.getAtivesCategoriesBlog());
        model.addAttribute("action", "addArticleBlog");
        return "blog/newArticleBlog";
    }

    @RequestMapping(value = "addArticleBlog", method = RequestMethod.POST)
    public String addArticleBlog(@ModelAttribute("articleBlog") @Valid Article articleBlog, BindingResult result, HttpServletRequest req, RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            req.setAttribute("validator", true);
            fileController.deleteTmp();
            return newArticleBlog(model);
        } else {
        	// *** Imagem Capa Blog *** //
        	articleBlog.setImages(fileController.imageReplication(articleBlog));
        	FileMeta fileImg;
        	Gson gson;
        	
        	if (articleBlog.getImages() != null) {
        		for (Image img : articleBlog.getImages()) {
        			gson = new Gson();
        			fileImg = gson.fromJson(img.getJson(), FileMeta.class);
        			articleBlog.setArticleCover(fileImg.getFileName());
        		}	
        	}
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
    @RequestMapping(value = "edit-article-blog", method = RequestMethod.GET)
    public String editArticleBlog(Long id, Model model) {
    	
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
    @RequestMapping(value = "visualize-article-blog", method = RequestMethod.GET)
    public String visualizeArticleBlog(Long id, Model model) {
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
    public ModelAndView updateArticle(@ModelAttribute("articleBlogForm") @Valid Article articleBlog, BindingResult result, @RequestParam Long id, Model model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
          model.addAttribute("validator", true);
          fileController.deleteTmp();
          return new ModelAndView(editArticleBlog(id, model));
		} else {
			try {				
				Article articleId = this.articleBlogFacade.getArticleBlogId(id);
				if (articleId.getAtName() != articleBlog.getAtName()) {
					 String oldName = articleId.getAtName();
					 String newName = articleBlog.getAtName();
					 
					 File oldFileOriginal = new File(new JooceBoxProperties().getPathOriginalImagesArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+oldName);
					 oldFileOriginal.renameTo(new File(new JooceBoxProperties().getPathOriginalImagesArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+newName));
					 
					 File oldFileResized = new File(new JooceBoxProperties().getPathResizedImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+oldName);
					 oldFileResized.renameTo(new File(new JooceBoxProperties().getPathResizedImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+newName));
					 
					 File oldFileThumbnail = new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+oldName);
					 oldFileThumbnail.renameTo(new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+newName));
					 
					 for (Image image : articleId.getImages()) {
						Gson gson = new Gson();
						FileMeta fromJson = gson.fromJson(image.getJson(), FileMeta.class);							
						String imagePath = fromJson.getFileTmpPath();
						
						//TODO: Realizar o replace do nome do destino apenas na pasta;
						imagePath.replace(oldName, articleBlog.getAtName());
						
						articleId.setArticleCover(fromJson.getFileName());
					}
				}
				//Article Blog Image
				Set<Image> imageReplication = fileController.imageReplication(articleId);
				for (Image image : imageReplication) {
					articleId.getImages().add(image);
				}
				articleBlogFacade.articleBlogUpdate(articleBlog, id);
				redirectAttributes.addFlashAttribute("message", "O Artigo " + articleBlog.getAtName() + " foi alterado com sucesso!");
				return new ModelAndView("redirect:article-blog-list");
			} catch (Exception e) {
				e.printStackTrace();
				fileController.deleteAllImages(articleBlog.getImages(), articleBlog.getAtName());
				//TODO: apagar as pastas com as imagens assim como os registros na tabela de image
				redirectAttributes.addFlashAttribute("errorMessage", "Não foi possivel adicionar o artigo "+ articleBlog.getAtName());
				return new ModelAndView(new RedirectView("article-blog-list"));
			}
		}
    }
    
}