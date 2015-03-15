package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Country;

@Repository
public interface CountryRepository extends BaseRepository<Country, Long>{

	List<Country> findAll();
}
