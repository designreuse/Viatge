package br.com.joocebox.repositories;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Login;

@Repository
public interface LoginRepository extends BaseRepository<Login, Long>{
	
	Login findByEmail(String email);

}
