package br.com.joocebox.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Destination;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.DestinationRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class DestinationFacade {
	
	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Destination> filterDestinations(String economic, String general, String social, String weather, String trip){
		Long currentTenantId = tenantResolver.getCurrentTenantId();		
		String query = "SELECT d FROM Destination d INNER JOIN EconomicProfile e ON d.idDestination = e.id INNER JOIN GeneralProfile g ON d.idDestination = g.id INNER JOIN SocialProfile s ON d.idDestination = s.id INNER JOIN WeatherProfile w ON d.idDestination = w.id INNER JOIN TripProfile t ON d.idDestination = t.id WHERE (e."+economic+" = ?1 and g."+general+" = ?2 and s."+social+" = ?3 and w."+weather+" = ?4 and t."+trip+" = ?5)";		
		entityManager.setProperty(PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT, currentTenantId);
		return entityManager.createQuery(query).setParameter(1, true).setParameter(2, true).setParameter(3, true).setParameter(4, true).setParameter(5, true).getResultList();
	}

}
