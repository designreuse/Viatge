package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Customer;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long>{
	
	List<Customer> findByfirstNameAndTenantId(String firstName, Long tenantId);

}
