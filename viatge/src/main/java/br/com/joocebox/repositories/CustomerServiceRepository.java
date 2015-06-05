package br.com.joocebox.repositories;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.CustomerService;

@Repository
public interface CustomerServiceRepository extends BaseRepository<CustomerService, Long>{
	
}
