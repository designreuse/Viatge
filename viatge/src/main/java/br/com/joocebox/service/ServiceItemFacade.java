package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.ServiceItem;
import br.com.joocebox.repositories.ServiceItemRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ServiceItemFacade {

	
	@Autowired
	private ServiceItemRepository serviceItemRepository;
	
	public Iterable<ServiceItem> saveServiceItem(List<ServiceItem> serviceItem) {
		return serviceItemRepository.save(serviceItem);
	}

	public List<ServiceItem> getAllServiceItems() {
		return serviceItemRepository.findAll();
	}
}
