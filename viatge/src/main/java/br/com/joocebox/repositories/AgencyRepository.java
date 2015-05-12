package br.com.joocebox.repositories;


import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Agency;

@Repository
public interface AgencyRepository extends BaseRepository<Agency, Long>{

	Agency getBySubdomain(String subdomain);
	
	//Agency findByEmail(String email);
}
