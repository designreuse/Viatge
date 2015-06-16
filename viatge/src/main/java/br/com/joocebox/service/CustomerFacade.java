package br.com.joocebox.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Country;
import br.com.joocebox.model.Customer;
import br.com.joocebox.model.CustomerService;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.CountryRepository;
import br.com.joocebox.repositories.CustomerRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CustomerFacade {

	@Autowired
	private CountryRepository countryRepsitory; 
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	public List<Country> getCountriesList() {
		return countryRepsitory.findAll();
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerId(Long id) {
		return customerRepository.findOne(id);
	}
	
	public List<Customer> getCustomerByFirstName(String firstName, Long tenant) {
		return customerRepository.findByfirstNameAndTenantId(firstName, tenant);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public void saveCustomerBySite(String name, String email){
		
		//TODO: Realizar a verificação prévia se já existe tal e-mail na BD. Tudo isso para não duplicar clientes.
		//Customer findByEmailLike = customerRepository.findByEmailLikeAndTenantId(email, tenantResolver.getCurrentTenantId());	
			Set<CustomerService> customerServiceList = new HashSet<CustomerService>();
			
			Customer c = new Customer();
			c.setFirstName(name);
			c.setEmail(email);
			
			CustomerService cs = new CustomerService();
			cs.setDate(new Date());
			cs.setSituation(true);
			cs.setServiceObservations("Registro realizado via site");
			customerServiceList.add(cs);
			
			c.setCustomerService(customerServiceList);
			
			customerRepository.save(c);
		
	}
	
	public void update(Customer customer, Long id) {
		Customer oldCustomer = customerRepository.findOne(id);
		
		oldCustomer.setBirthDate(customer.getBirthDate());
		oldCustomer.setEmail(customer.getEmail());
		oldCustomer.setFirstName(customer.getFirstName());
		oldCustomer.setGender(customer.getGender());
		oldCustomer.setLastName(customer.getLastName());
		oldCustomer.setObservations(customer.getObservations());
		
		oldCustomer.getCustomerAddress().setCep(customer.getCustomerAddress().getCep());
		oldCustomer.getCustomerAddress().setCity(customer.getCustomerAddress().getCity());
		oldCustomer.getCustomerAddress().setComplement(customer.getCustomerAddress().getComplement());
		oldCustomer.getCustomerAddress().setCountry(customer.getCustomerAddress().getCountry());
		oldCustomer.getCustomerAddress().setNumber(oldCustomer.getCustomerAddress().getNumber());
		oldCustomer.getCustomerAddress().setQuarter(oldCustomer.getCustomerAddress().getQuarter());
		oldCustomer.getCustomerAddress().setState(oldCustomer.getCustomerAddress().getState());
		oldCustomer.getCustomerAddress().setStreet(oldCustomer.getCustomerAddress().getStreet());
		
		oldCustomer.getCustomerPhone().setCelPhone(customer.getCustomerPhone().getCelPhone());
		oldCustomer.getCustomerPhone().setHomePhone(customer.getCustomerPhone().getHomePhone());
		oldCustomer.getCustomerPhone().setWorkPhone(customer.getCustomerPhone().getWorkPhone());

		oldCustomer.getDocument().setCpf(customer.getDocument().getCpf());
		oldCustomer.getDocument().setRg(customer.getDocument().getRg());

		customerRepository.save(oldCustomer);
	}

}
