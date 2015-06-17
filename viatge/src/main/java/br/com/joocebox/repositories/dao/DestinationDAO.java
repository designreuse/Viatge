package br.com.joocebox.repositories.dao;

import java.util.List;

import br.com.joocebox.model.Destination;

public interface DestinationDAO {
	
	List<Destination> filterDestinations(String economic, String general, String social, String weather, String trip);

}
