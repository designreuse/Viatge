package br.com.joocebox.repositories;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Employee;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long>{
 
}
