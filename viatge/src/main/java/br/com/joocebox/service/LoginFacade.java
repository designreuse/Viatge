package br.com.joocebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Login;
import br.com.joocebox.repositories.LoginRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class LoginFacade {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Login findByEmail(String email) {	
		return loginRepository.findByEmail(email);
	}

}
