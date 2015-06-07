package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.CategoryBlog;
import br.com.joocebox.repositories.CategoryBlogRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CategoryBlogFacade {

	@Autowired
	private CategoryBlogRepository categoryBlogRepository;

	public List<CategoryBlog> getCategoriesBlogList() {
		return categoryBlogRepository.findAll();
	}
}