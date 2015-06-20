package br.com.joocebox.repositories.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Destination;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.dao.DestinationDAO;

@Repository
public class DestinationDaoImpl implements DestinationDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	protected void setCurrentTenant() {
		entityManager.setProperty(PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT, tenantResolver.getCurrentTenantId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Destination> filterDestinations(String economic, String general, String social, String weather, String trip) {
		setCurrentTenant();		
		Query q = entityManager.createQuery("SELECT d FROM Destination d INNER JOIN EconomicProfile e ON d.idDestination = e.id INNER JOIN GeneralProfile g ON d.idDestination = g.id INNER JOIN SocialProfile s ON d.idDestination = s.id INNER JOIN WeatherProfile w ON d.idDestination = w.id INNER JOIN TripProfile t ON d.idDestination = t.id WHERE (e."+economic+" = :economic and g."+general+" = :general and s."+social+" = :social and w."+weather+" = :weather and t."+trip+" = :trip)");
		q.setParameter("economic", true);
		q.setParameter("general", true);
		q.setParameter("social", true);
		q.setParameter("weather", true);
		q.setParameter("trip", true);
		return q.getResultList(); 
	}		
}