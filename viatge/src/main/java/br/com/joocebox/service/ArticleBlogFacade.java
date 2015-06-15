package br.com.joocebox.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.controller.FileArticleBlogController;
import br.com.joocebox.model.Article;
import br.com.joocebox.repositories.ArticleBlogRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ArticleBlogFacade {

	@Autowired
	private ArticleBlogRepository articleBlogRepository;
	@Autowired
	private DashboardFacade dashboardFacade;
	@Autowired
	private FileArticleBlogController fileController;
	@Autowired
	private CategoryBlogFacade categoryBlogFacade;

	public List<Article> getArticlesBlogList() {
		return articleBlogRepository.findAll();
	}

	/**
	 * Método que retorna uma lista de Artigos(Blog) ativos.
	 * @return List<Article> Artigos Ativos.
	 */
	public List<Article> getAtivesArticlesBlog() {
		List<Article> allArticleBlog = this.getArticlesBlogList();
		Iterator<Article> iterator = allArticleBlog.iterator();
		//Verificação de artigos que não estão ativos.		
		while (iterator.hasNext()) {
			Article articleBlog = (Article) iterator.next();
			if(articleBlog.getAtActive() != 1){ 
				iterator.remove();							
			}
		}
		return allArticleBlog;
	}

	public void addArticleBlog(Article article) {
		articleBlogRepository.save(article);
	}

	public Article getArticleBlogId(Long articleBlogId){
		return articleBlogRepository.findOne(articleBlogId);
	}
	
	public void articleBlogUpdate(Article articleBlog, Long id) {
		Article articleOld = this.getArticleBlogId(id);
		articleOld.setArticleCover(articleBlog.getArticleCover());
		articleOld.setAtContent(articleBlog.getAtContent());
		articleOld.setAtName(articleBlog.getAtName());
		articleOld.setCategoryBlog(articleBlog.getCategoryBlog());
		articleBlogRepository.save(articleOld);
	}
	
}