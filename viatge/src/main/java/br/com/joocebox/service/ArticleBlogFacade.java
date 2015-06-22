package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.controller.FileArticleBlogController;
import br.com.joocebox.model.Article;
import br.com.joocebox.model.CategoryBlog;
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

	/**
	 * Método que retorna uma lista de Artigos(Blog) ativos.
	 * @return List<Article> Artigos Ativos.
	 */
	public List<Article> findActivesArticles() {
		return articleBlogRepository.findByAtActiveOrderByPostingDateDesc(1);
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
	
	public List<Article> findByCategoryBlogAndAtActive(CategoryBlog categoryBlog) {
		return articleBlogRepository.findByCategoryBlogAndAtActiveOrderByPostingDateDesc(categoryBlog, 1);
	}
}