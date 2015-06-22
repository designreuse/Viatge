package br.com.joocebox.repositories.dao;

import java.util.List;

import br.com.joocebox.model.Article;

public interface ArticleBlogDAO {

	public List<Article> findArticlesByActivesOrderByPostingDateDesc();
}