package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Category;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long>{

	List<Category> findAll();
	
}
