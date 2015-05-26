package br.com.joocebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.repositories.AgencyRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class AgencyFacade {
	
	@Autowired
	private AgencyRepository agencyRepository;

}
