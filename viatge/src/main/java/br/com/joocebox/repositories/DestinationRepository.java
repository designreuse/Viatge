package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Destination;

@Repository
public interface DestinationRepository extends BaseRepository<Destination, Long>{

	List<Destination> findAll();

}
