package br.com.joocebox.repositories;


import br.com.joocebox.model.Agency;


public interface AgencyRepository extends BaseRepository<Agency, Long>{

	Agency getBySubdomain(String subdomain);
	
	Agency findByEmail(String email);
}
