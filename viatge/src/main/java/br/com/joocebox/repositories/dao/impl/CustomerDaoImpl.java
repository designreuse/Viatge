package br.com.joocebox.repositories.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.dao.CustomerDAO;

@Repository
public class CustomerDaoImpl implements CustomerDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	  protected void setCurrentTenant() {
		  entityManager.setProperty(PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT, tenantResolver.getCurrentTenantId());
	  }
	
	public boolean findCustomerByEmail(String email){
		setCurrentTenant();	
		Query q = entityManager.createQuery("SELECT c.email FROM Customer c WHERE c.email = :email");
		q.setParameter("email", email);
		return q.getResultList().isEmpty();
	}

}
