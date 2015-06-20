package br.com.joocebox.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Country;
import br.com.joocebox.model.Customer;
import br.com.joocebox.model.CustomerAddress;
import br.com.joocebox.model.CustomerPhone;
import br.com.joocebox.model.CustomerService;
import br.com.joocebox.model.Document;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.CountryRepository;
import br.com.joocebox.repositories.CustomerRepository;
import br.com.joocebox.repositories.dao.CustomerDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CustomerFacade {

	@Autowired
	private CountryRepository countryRepsitory; 
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	@Autowired
	private CustomerDAO customerDao;
	
	public List<Country> getCountriesList() {
		return countryRepsitory.findAll();
	}
	
	public void save(Customer customer) {
		//Agrega uma lista de passageiros cadastrados a aquele cliente corrente
        customer.setSite(Boolean.FALSE);
        
        //Inicia um objeto do tipo CustomerService para abrir um atendimento.
        CustomerService customerService = new CustomerService();        
        //Atualiza a data da ultima abertura do serviço
        customerService.setDate(new Date());
        
        //Seta 
        //customerService.setSituation(Boolean.TRUE);         

	
		//return customerRepository.save(customer);
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
		if(customerDao.findCustomerByEmail(email)){

			Customer c = new Customer();
			c.setFirstName(name);
			c.setEmail(email);
			c.setSite(Boolean.TRUE);

			CustomerService cs = new CustomerService();
			cs.setDate(new Date());
			cs.setSituation(true);
			cs.setServiceObservations("Registro realizado via site");

			c.setCustomerService(cs);
			
			c.setCustomerAddress(new CustomerAddress());
			c.setCustomerPhone(new CustomerPhone());
			c.setDocument(new Document());

			customerRepository.save(c);
		}else{
			//TODO: Abrir ou não um novo atendimento?
		}
		
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

	/**
	 * Retorna um Customer baseado no e-mail informado.
	 * @param email do Customer
	 * @return Customer referente ao e-mail ou NULO, caso não encontre.
	 */
	public Customer getCustomerByEmail(String email) {
		List<Customer> customers = customerRepository.findByEmail(email);
		if (customers != null && !customers.isEmpty()) {
			return customers.get(0);
		} else {
			return null;
		}
	}
}
