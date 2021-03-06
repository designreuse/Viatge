package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Country;
import br.com.joocebox.model.Customer;
import br.com.joocebox.model.views.VwOpenService;
import br.com.joocebox.repositories.CountryRepository;
import br.com.joocebox.repositories.OpenServiceRepository;
import br.com.joocebox.repositories.ServiceRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ServiceFacade {

	@Autowired
	private CountryRepository countryRepsitory;

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private OpenServiceRepository vwOpenService;

	public List<Country> getCountriesList() {
		return countryRepsitory.findAll();
	}

	public Customer saveNewService(Customer service) {
		return serviceRepository.save(service);

	}

	public List<Customer> getServiceList() {
		return serviceRepository.findAll();
	}

	public List<VwOpenService> getOpenServiceList() {
		return vwOpenService.findAll();
	}
}