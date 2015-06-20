package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Destination;
import br.com.joocebox.repositories.DestinationRepository;
import br.com.joocebox.repositories.dao.DestinationDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class DestinationFacade {
	
	@Autowired
	private DestinationDAO destinationDao;
	@Autowired
	private DestinationRepository destinationRepository;
	
	public List<Destination> filterDestinations(String economic, String general, String social, String weather, String trip){
		return destinationDao.filterDestinations(economic, general, social, weather, trip);
	}
	
	public Destination getDestinationById(Long id) {
		return destinationRepository.findOne(id);
	}

}
