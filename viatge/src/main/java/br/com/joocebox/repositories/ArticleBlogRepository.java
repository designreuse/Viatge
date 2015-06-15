package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Article;
import br.com.joocebox.model.CategoryBlog;

@Repository
public interface ArticleBlogRepository extends BaseRepository<Article, Long>{

	List<Article> findAll();
	
	List<Article> findByCategoryBlogAndAtActive(CategoryBlog categoryBlog, int active);
}