package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.ServiceItem;

@Repository
public interface ServiceItemRepository extends BaseRepository<ServiceItem, Long>{
	
	List<ServiceItem> findAll();

}
