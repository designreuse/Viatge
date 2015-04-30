package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Staff;

@Repository
public interface StaffRepository extends BaseRepository<Staff, Long>{
	
	List<Staff> findAll();

}
