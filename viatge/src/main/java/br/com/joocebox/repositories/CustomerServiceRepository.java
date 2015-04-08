package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.joocebox.model.CustomerService;
import br.com.joocebox.model.ServiceItem;

@Repository
public interface CustomerServiceRepository extends BaseRepository<CustomerService, Long>{
	
}
