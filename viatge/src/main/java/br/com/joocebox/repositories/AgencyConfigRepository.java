package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.AgencyConfig;

/**
 * Classe Repository para as configurações de Agência.
 * @author Bruno Neves
 *
 */
@Repository
public interface AgencyConfigRepository extends BaseRepository<AgencyConfig, Long>{

	List<AgencyConfig> findAll();
}
