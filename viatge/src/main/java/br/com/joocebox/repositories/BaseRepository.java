package br.com.joocebox.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
}
