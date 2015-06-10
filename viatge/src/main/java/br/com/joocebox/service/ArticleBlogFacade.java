package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Article;
import br.com.joocebox.repositories.ArticleBlogRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ArticleBlogFacade {

	@Autowired
	private ArticleBlogRepository articleBlogRepository;

	public List<Article> getArticlesBlogList() {
		return articleBlogRepository.findAll();
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