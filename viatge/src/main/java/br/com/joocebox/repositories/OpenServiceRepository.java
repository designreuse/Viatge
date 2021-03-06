package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.views.VwOpenService;

@Repository
public interface OpenServiceRepository extends BaseRepository<VwOpenService, Long>{
	
	List<VwOpenService> findAll();

}
