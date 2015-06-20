package br.com.joocebox.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.Image;
import br.com.joocebox.service.ArticleBlogFacade;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.ImageFacade;
import br.com.joocebox.utils.JooceBoxProperties;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
public class ImageController {
    final static Logger logger = LoggerFactory.getLogger(ImageController.class);
	
    @Autowired
    private DashboardFacade dashboardFacade;
    @Autowired
    private ArticleBlogFacade articleBlogFacade;
    
    @Autowired
    private ImageFacade imageFacade;
    
	@RequestMapping(value = "/image/avatar/{id}/{fileName}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewAvatar(@PathVariable Long id, @PathVariable String fileName) {
		String absolutePath = pathWithTenant()+"/avatar/"+id+"/"+fileName+".jpg";				
		return serverImageJPEG(absolutePath);
	}

    
	@RequestMapping(value = "/image/logo/{pathname}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewLogo(@PathVariable String pathname) {
		String absolutePath = pathWithTenant()+"/logo/"+pathname+".png";
		return serverImagePNG(absolutePath);
	}
	
	@RequestMapping(value = "/image/destination/thubnail/{destinationName}/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewThubnailCRM(@PathVariable String destinationName, @PathVariable Long id) {	
		String pathDestination = pathWithTenant()+"/destination/thumbnail/"+dashboardFacade.getDestinationId(id).getDtName()+'/'+destinationName;
		return serverImageJPEG(pathDestination);	
	}

    
	@RequestMapping(value = "/image/destination/{destinationName}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewDestinationhighlightImages(@PathVariable String destinationName) {		
		String pathDestination = pathWithTenant()+"/destination/highlightImages/"+destinationName;
		return serverListOfImageJPEG(pathDestination);		
	}
	
	@RequestMapping(value = "/image/destination/thumbnail/{destinationName}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewDestinationThubnail(@PathVariable String destinationName) {
		String normalizeUnicode = normalizeUnicode(destinationName);
		String pathDestination = pathWithTenant()+"/destination/thumbnail/"+normalizeUnicode;
		return serverListOfImageJPEG(pathDestination);	
	}
	
	
	
	@RequestMapping(value = "/image/destinationDetail/{imageId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewDestinationDetail(@PathVariable Long imageId) {
		
		Image image = imageFacade.getImageId(imageId);

		FileMeta loadImageFromJSONGson = loadImageFromJSONGson(image.getJson());
		
		InputStream in;
		
		try {
			
			in = new FileInputStream(new File(loadImageFromJSONGson.getFileTmpPath().replace("original", "resizedImages")));

		    final HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);

		    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * @param pathDestination
	 * @return
	 */
	public ResponseEntity<byte[]> serverListOfImageJPEG(String pathDestination) {
		File imagesFile = new File(pathDestination);
		File[] listFiles = imagesFile.listFiles();
		
		InputStream in;
		
		try {
			
			in = new FileInputStream(listFiles[0]);

		    final HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);

		    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @param absolutePath
	 * @return
	 */
	public ResponseEntity<byte[]> serverImageJPEG(String absolutePath) {
		InputStream in;
		try {
			
			in = new FileInputStream(new File(absolutePath));

		    final HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);

		    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @param pathname
	 * @return
	 */
	public ResponseEntity<byte[]> serverImagePNG(String pathname) {
		InputStream in;
		try {
			
			in = new FileInputStream(new File(pathname));

		    final HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_PNG);

		    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public FileMeta loadImageFromJSONGson(String jsonString) {
	    Gson gson = new Gson();
	    FileMeta image = gson.fromJson(jsonString, FileMeta.class);
	    return image;
	}
	
	
	/**
	 * Método utilizado para retorndo do caminho de imagens, assim como o caminho corrente do tenant.
	 *  
	 * @return String
	 */
	public String pathWithTenant(){
		String tenantName = dashboardFacade.getAgency().getSubdomain();		
		String absolutePath = new JooceBoxProperties().getPathTenants()+tenantName;		
		return absolutePath;
	}

	/////// ****** Imagens Artigos do Blog ****** //////////
	
	@RequestMapping(value = "/image/articleBlog/thubnail/{articleBlogName}/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewArticleBlogThubnailCRM(@PathVariable String articleBlogName, @PathVariable Long id) {	
		String pathArticleBlog = pathWithTenant()+"/articleBlog/thumbnail/"+articleBlogFacade.getArticleBlogId(id).getAtName()+'/'+articleBlogName;
		return serverImageJPEG(pathArticleBlog);	
	}

    
	@RequestMapping(value = "/image/articleBlog/{articleBlogName}/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewArticleBlogResizedImagesCRM(@PathVariable String articleBlogName, @PathVariable Long id) {		
		String pathArticleBlog = pathWithTenant()+"/articleBlog/resizedImages/"+articleBlogFacade.getArticleBlogId(id).getAtName();
		return serverListOfImageJPEG(pathArticleBlog);		
	}
	
	@RequestMapping(value = "/image/articleBlog/{articleBlogName}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewArticleBlogResizedImages(@PathVariable String articleBlogName) {		
		String pathArticleBlog = pathWithTenant()+"/articleBlog/resizedImages/"+articleBlogName;
		return serverListOfImageJPEG(pathArticleBlog);		
	}
	
	@RequestMapping(value = "/image/articleBlog/thumbnail/{articleBlogName}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewArticleBlogThubnail(@PathVariable String articleBlogName) {		
		String pathArticleBlog = pathWithTenant()+"/articleBlog/thumbnail/"+articleBlogName;
		return serverListOfImageJPEG(pathArticleBlog);	
	}
	
	
	
	@RequestMapping(value = "/image/articleBlogDetail/{imageId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> viewArticleBlogDetail(@PathVariable Long imageId) {
		
		Image image = imageFacade.getImageId(imageId);

		FileMeta loadImageFromJSONGson = loadImageFromJSONGson(image.getJson());
		
		InputStream in;
		
		try {
			
			in = new FileInputStream(new File(loadImageFromJSONGson.getFileTmpPath().replace("original", "resizedImages")));

		    final HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);

		    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
	
	protected String normalizeUnicode(String str) {
	    Normalizer.Form form = Normalizer.Form.NFC;
	    if (!Normalizer.isNormalized(str, form)) {
	        return Normalizer.normalize(str, form);
	    }
	    return str;
	}
	
}