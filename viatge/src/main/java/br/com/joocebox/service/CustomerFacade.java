package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Country;
import br.com.joocebox.model.Customer;
import br.com.joocebox.repositories.CountryRepository;
import br.com.joocebox.repositories.CustomerRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CustomerFacade {

	@Autowired
	private CountryRepository countryRepsitory; 
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Country> getCountriesList() {
		return countryRepsitory.findAll();
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerId(Long id) {
		return customerRepository.findOne(id);
	}

}
