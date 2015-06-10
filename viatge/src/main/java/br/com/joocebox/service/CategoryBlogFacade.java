package br.com.joocebox.service;

import java.util.Iterator;
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
	
	public void addCategoryBlog(CategoryBlog categoryBlog) {
		categoryBlogRepository.save(categoryBlog);
	}

	public CategoryBlog getCategoryBlogId(Long categoryBlogId){
		return categoryBlogRepository.findOne(categoryBlogId);
	}

	public void categoryBlogUpdate(String categoryBlogName, Long categoryBlogId) {
		CategoryBlog categoriaBlog = categoryBlogRepository.findOne(categoryBlogId);
		categoriaBlog.setCtBgName(categoryBlogName);
		categoryBlogRepository.save(categoriaBlog);
	}

	/**
	 * Método que retorna uma lista de Categorias(Blog) ativas.
	 * @return List<CategoryBlog> Categorias Ativas.
	 */
	public List<CategoryBlog> getAtivesCategoriesBlog() {
		List<CategoryBlog> allCategoryBlog = this.getCategoriesBlogList();
		Iterator<CategoryBlog> iterator = allCategoryBlog.iterator();
		//Verificação de categorias que não estão ativas.		
		while (iterator.hasNext()) {
			CategoryBlog categoryBlog = (CategoryBlog) iterator.next();
			if(categoryBlog.getCtBgActive() != 1){ 
				iterator.remove();							
			}
		}
		return allCategoryBlog;
	}
}