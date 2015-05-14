package br.com.joocebox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Employee;
import br.com.joocebox.repositories.EmployeeRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class EmployeeFacade {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Iterable<Employee> findAllEmployees() {
		return employeeRepository.findAll();
		
	}

}
