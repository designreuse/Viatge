package br.com.joocebox.repositories;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Customer;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long>{

}
