package br.com.joocebox.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.joocebox.model.Image;

@Repository
public interface ImagesRepository extends BaseRepository<Image, Long>{

	List<Image> findAll();
}
