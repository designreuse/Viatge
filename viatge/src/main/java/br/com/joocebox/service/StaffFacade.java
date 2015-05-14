package br.com.joocebox.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Employee;
import br.com.joocebox.multitenancy.CurrentTenantResolver;
import br.com.joocebox.repositories.StaffRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class StaffFacade {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;

	// TODO:Incluir uma clausula "where" na colsulta para trazer o tenant
	// corrente.
	public List<Employee> getListOfStaff() {
		return staffRepository.findAll();
	}

	public Employee save(Employee staff) {
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
		oldEmployee.setAvatar(newEmployee.getAvatar());
		
		oldEmployee.getContact().setCelPhone(newEmployee.getContact().getCelPhone());
		oldEmployee.getContact().setHomePhone(newEmployee.getContact().getHomePhone());

		if (newEmployee.getGoal() != null) {
			oldEmployee.getGoal().setYear(newEmployee.getGoal().getYear());
			oldEmployee.getGoal().setJanuary(newEmployee.getGoal().getJanuary());
			oldEmployee.getGoal().setFebruary(newEmployee.getGoal().getFebruary());
			oldEmployee.getGoal().setMarch(newEmployee.getGoal().getMarch());
			oldEmployee.getGoal().setApril(newEmployee.getGoal().getApril());
			oldEmployee.getGoal().setMay(newEmployee.getGoal().getMay());
			oldEmployee.getGoal().setJune(newEmployee.getGoal().getJune());
			oldEmployee.getGoal().setJuly(newEmployee.getGoal().getJuly());
			oldEmployee.getGoal().setAugust(newEmployee.getGoal().getAugust());
			oldEmployee.getGoal().setSeptember(newEmployee.getGoal().getSeptember());
			oldEmployee.getGoal().setOctober(newEmployee.getGoal().getOctober());
			oldEmployee.getGoal().setNovember(newEmployee.getGoal().getNovember());
			oldEmployee.getGoal().setDecember(newEmployee.getGoal().getDecember());
		}
		
		BCryptPasswordEncoder passEnconder = new BCryptPasswordEncoder();
		
		oldEmployee.getLogin().setActive(newEmployee.getLogin().getActive());
		oldEmployee.getLogin().setEmail(newEmployee.getLogin().getEmail());
		oldEmployee.getLogin().setLastAccess(new Date());
		oldEmployee.getLogin().setPassword(passEnconder.encode(newEmployee.getLogin().getPassword()));
		oldEmployee.getLogin().setRole(newEmployee.getLogin().getRole());
		oldEmployee.getLogin().setTenantId(tenantResolver.getCurrentTenantId());

		save(oldEmployee);

	}
}