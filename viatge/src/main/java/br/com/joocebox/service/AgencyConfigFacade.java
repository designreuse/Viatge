package br.com.joocebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.AgencyConfig;
import br.com.joocebox.repositories.AgencyConfigRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class AgencyConfigFacade {

	@Autowired
	private AgencyConfigRepository agencyConfigRepository;
	
	public void addAgencyConfig(AgencyConfig agConfig) {
		agencyConfigRepository.save(agConfig);
	}
}
