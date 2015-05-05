package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Employee;

@Repository
public interface StaffRepository extends BaseRepository<Employee, Long>{
	
	List<Employee> findAll();

}
