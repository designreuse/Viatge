package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.ImageJson;

@Repository
public interface ImageTempRepository extends BaseRepository<ImageJson, Long> {

	List<ImageJson> findAll();
}
