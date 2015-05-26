package br.com.joocebox.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Employee;
import br.com.joocebox.model.Goals;
import br.com.joocebox.model.Role;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.StaffRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class StaffFacade {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;

	public List<Employee> getListOfStaff() {
		return staffRepository.findAll();
	}

	public Employee save(Employee staff) {
		staff.setActive(Boolean.TRUE);
		staff.getLogin().setActive(Boolean.TRUE);
		staff.getLogin().setLastAccess(new Date());
		staff.getLogin().setTenantId(tenantResolver.getCurrentTenantId());
		staff.setGoal(new Goals());
		
		BCryptPasswordEncoder passEnconder = new BCryptPasswordEncoder();
		staff.getLogin().setPassword(passEnconder.encode(staff.getLogin().getPassword()));
		return staffRepository.save(staff);

	}

	public Employee findEmployeeById(Long id) {
		return staffRepository.findOne(id);

	}

	public void update(Employee newEmployee, Long id) {
		Employee oldEmployee = findEmployeeById(id);

		oldEmployee.setFirstName(newEmployee.getFirstName());
		oldEmployee.setLastName(newEmployee.getLastName());
		oldEmployee.setBirthDate(newEmployee.getBirthDate());
		oldEmployee.setGender(newEmployee.getGender());
		if(Boolean.FALSE.equals(oldEmployee.getAvatar()))
		oldEmployee.setAvatar(newEmployee.getAvatar());
		
		oldEmployee.getContact().setCelPhone(newEmployee.getContact().getCelPhone());
		oldEmployee.getContact().setHomePhone(newEmployee.getContact().getHomePhone());

		BCryptPasswordEncoder passEnconder = new BCryptPasswordEncoder();
		if(!passEnconder.matches(newEmployee.getLogin().getPassword(), oldEmployee.getLogin().getPassword()))
		oldEmployee.getLogin().setPassword(passEnconder.encode(newEmployee.getLogin().getPassword()));
		
		//oldEmployee.getLogin().setActive(newEmployee.getLogin().getActive());
		oldEmployee.getLogin().setEmail(newEmployee.getLogin().getEmail());
		oldEmployee.getLogin().setLastAccess(new Date());
		
		if(!Role.ROLE_MASTER.equals(oldEmployee.getLogin().getRole()))
		oldEmployee.getLogin().setRole(newEmployee.getLogin().getRole());
		oldEmployee.getLogin().setTenantId(tenantResolver.getCurrentTenantId());

		staffRepository.save(oldEmployee);

	}
	
	public void saveOrUpdateGoal(Goals goal, Long id) {
		Employee employee = findEmployeeById(id);
		Goals g = employee.getGoal();
		g.setYear("2015");
		g.setJanuary(goal.getJanuary());
		g.setFebruary(goal.getFebruary());
		g.setMarch(goal.getMarch());
		g.setApril(goal.getApril());
		g.setMay(goal.getMay());
		g.setJune(goal.getJune());
		g.setJuly(goal.getJuly());
		g.setSeptember(goal.getSeptember());
		g.setOctober(goal.getOctober());
		g.setNovember(goal.getNovember());
		g.setDecember(goal.getDecember());
		staffRepository.save(employee);

	}
}