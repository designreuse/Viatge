package br.com.joocebox.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Customer;
import br.com.joocebox.model.CustomerService;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.CustomerServiceRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CustomerServiceFacade {

	@Autowired
	private CustomerServiceRepository customerServiceRepository;
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	@PersistenceContext
    private EntityManager entityManager;

	public CustomerService findById(Long id) {
		return customerServiceRepository.findOne(id);
	}
	
	public CustomerService saveCustomerService(CustomerService customerService){
		return customerServiceRepository.save(customerService);
	}

	public CustomerService getCustomerServiceById(Long customerServiceId) {
		return customerServiceRepository.findOne(customerServiceId);
		
	}

	@SuppressWarnings("unchecked")
	public CustomerService getCustomerServiceByCustomer(Customer customer) {
		String query = "SELECT cService FROM Customer customer "
					 + " JOIN customer.customerService cService "
					 + " WHERE customer = :p0 "
					 + " AND cService.situation = :p1 "
					 + " ORDER BY cService.id DESC";
		Long currentTenantId = tenantResolver.getCurrentTenantId();
		entityManager.setProperty(PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT, currentTenantId);
		List<CustomerService> cServices = entityManager.createQuery(query).setParameter("p0", customer).setParameter("p1", Boolean.TRUE).getResultList();
		if (cServices != null && !cServices.isEmpty()) {
			return cServices.get(0);
		} else {
			return new CustomerService();
		}		
	}
}
