package br.com.joocebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Passenger;
import br.com.joocebox.repositories.PassengerRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class passengerFacade {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public void addPassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}
}
