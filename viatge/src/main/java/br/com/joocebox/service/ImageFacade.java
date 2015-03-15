package br.com.joocebox.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.joocebox.model.Image;
import br.com.joocebox.repositories.ImagesRepository;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ImageFacade {

	@Autowired
	private ImagesRepository imageRepository;
	
	public Image getImageId(Long imageId){
		return imageRepository.findOne(imageId);
	}

}
