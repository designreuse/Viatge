package br.com.joocebox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Staff;
import br.com.joocebox.repositories.StaffRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class StaffFacade {
	
	@Autowired
	private StaffRepository staffRepository;
	
	
	public List<Staff> getListOfStaff() {
		return staffRepository.findAll();
	}


	public Staff save(Staff staff) {
		return staffRepository.save(staff);
		
	}


	public Staff findEmployeeById(Long id) {
		return staffRepository.findOne(id);
		
	}

}
