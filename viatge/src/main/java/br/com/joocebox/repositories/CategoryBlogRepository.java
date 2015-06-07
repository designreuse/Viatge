package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.CategoryBlog;

@Repository
public interface CategoryBlogRepository extends BaseRepository<CategoryBlog, Long>{

	List<CategoryBlog> findAll();

}