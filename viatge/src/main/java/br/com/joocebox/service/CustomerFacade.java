package br.com.joocebox.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Country;
import br.com.joocebox.model.Customer;
import br.com.joocebox.model.CustomerAddress;
import br.com.joocebox.model.CustomerPhone;
import br.com.joocebox.model.CustomerService;
import br.com.joocebox.model.FamilyBond;
import br.com.joocebox.model.Passenger;
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
	
	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private CustomerDAO customerDao;
	
	public List<Country> getCountriesList() {
		return countryRepsitory.findAll();
	}
	
	public void save(Customer customer) {        
        //Inicia um objeto do tipo CustomerService para abrir um atendimento.
        CustomerService customerService = new CustomerService();        
        //Atualiza a data da ultima abertura do serviço
        customerService.setDate(new Date());
        
        //Seta 
        //customerService.setSituation(Boolean.TRUE);         

	
		//return customerRepository.save(customer);
	}

	public void saveByBudget(Customer customer) {
		customerRepository.save(customer);
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
	@SuppressWarnings("unchecked")
	public Customer getCustomerByEmail(String email) {
		Long currentTenantId = tenantResolver.getCurrentTenantId();
		String query = "SELECT c FROM Customer c where c.email LIKE ?1";
		entityManager.setProperty(PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT, currentTenantId);
		List<Customer> customers = entityManager.createQuery(query).setParameter(1, email).getResultList();

		if (customers != null && !customers.isEmpty()) {
			return customers.get(0);
		} else {
			return null;
		}
	}
	
	public Set<Passenger> returnPassangersBudget(String vinculo,
												 String acompanhante,
												 String idade) {
		Set<Passenger> passengers = new HashSet<>();

		if (vinculo != null && !vinculo.isEmpty()) {
			String vinculos[] = vinculo.split(Pattern.quote(","));
			String acompanhantes[] = acompanhante.split(Pattern.quote(","));
			String idades[] = idade.split(Pattern.quote(","));
		
			Passenger passenger;
			if (vinculos != null && vinculos.length > 0) {
				for (int i = 0; i < vinculos.length; i++) {
					passenger = new Passenger();
					// Nome e Sobrenome
					String[] flName = acompanhantes[i].split(Pattern.quote(" "));
					passenger.setFirstName(flName[0]);
					passenger.setLastName(flName.length >= 2 ? flName[1] : "");
					// Vinculo 
					passenger.setFamilyBond(FamilyBond.valueOf(vinculos[i]));
					// Idade
					try {
						Integer intIdade = new Integer(idades[i]);
						Calendar calendar = Calendar.getInstance();
						calendar.add(Calendar.YEAR, -intIdade);
						passenger.setBirthDate(calendar.getTime());
					} catch(Exception ex) {					
					}
					passengers.add(passenger);
				}	
			}
		}
		return passengers;
	}
}
