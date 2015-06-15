package br.com.joocebox.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.joocebox.model.Article;
import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.Image;
import br.com.joocebox.model.ImageJson;
import br.com.joocebox.service.ArticleBlogFacade;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.utils.ImageUtils;
import br.com.joocebox.utils.JooceBoxProperties;

import com.google.gson.Gson;

@Controller
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/fileArticleBlog")
public class FileArticleBlogController {

	final static Logger logger = LoggerFactory.getLogger(FileArticleBlogController.class);
	
	@Autowired
	public DashboardFacade dashboardFacade;
	@Autowired
	public ArticleBlogFacade articleBlogFacade;

	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
    ImageJson pathJson = null;
    
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public void upload(MultipartHttpServletRequest request, HttpServletResponse response) {
 
        //1. build an iterator
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
 
         //2. get each file
         while(itr.hasNext()){

             //2.1 get next MultipartFile
             mpf = request.getFile(itr.next()); 
             System.out.println(mpf.getOriginalFilename() +" uploaded! ");
 
             //2.2 if files > 10 remove the first from the list
             // TODO Verificar se existem mais de 8 arquivos sendo upados
             
             String subdomain = dashboardFacade.getAgency().getSubdomain();
             File base = new File("/tmp/joocebox-img/"+subdomain+"/articleBlog");
             String path = base+"/"+mpf.getOriginalFilename();
 
             //2.3 create new fileMeta
             fileMeta = new FileMeta();
             fileMeta.setFileName(mpf.getOriginalFilename());
             fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
             fileMeta.setFileType(mpf.getContentType());
             fileMeta.setFileTmpPath(path);
 
             try {
                
                if (!base.exists()) {
					base.mkdirs();		
					
	                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path));
	                generateJson(fileMeta);
				
				} else {
					logger.info("Pasta " + base + "/ já existente");
	                 // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)            
	                 FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path));
	                 generateJson(fileMeta);	                	                 
				}
 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }
    }
    
	public void generateJson(FileMeta fileMeta) {
		Gson gson = new Gson();
		String generated = gson.toJson(fileMeta);
		pathJson = new ImageJson();
		pathJson.setJson(generated);
		dashboardFacade.addImagePathTmp(pathJson);
		logger.info("Imagem adicionada.");
	}
	
	public void deleteTmpImages(String oldPath, ImageJson imageJsonList){
		File fileToDelete = new File(oldPath);
		if (!fileToDelete.exists()) {
			logger.info("Arquivo inexistente!");
		}else{
		fileToDelete.delete();		
		dashboardFacade.deleteAllTmpImages(imageJsonList);
		}
	}
	
	public void deleteTmp(){
		Gson gson = null;
		List<ImageJson> imagePathTmpList = dashboardFacade.getImagePathTmpList();

		for (ImageJson imageJsonList : imagePathTmpList) {
			gson = new Gson();
			
			FileMeta imgTmp = gson.fromJson(imageJsonList.getJson(), FileMeta.class);
			
			String oldPath = imgTmp.getFileTmpPath();
			deleteTmpImages(oldPath, imageJsonList);				
		}

	}
	public void deleteAllImages(Set<Image> images, String articleBlogName) {
		
		for (Image image : images) {			
			dashboardFacade.deleteImageId(image.getId());
		}
		
		File originalImageToDelete = new File(new JooceBoxProperties().getPathOriginalImagesArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+articleBlogName);
		originalImageToDelete.delete();
		File resizedImageToDelete = new File(new JooceBoxProperties().getPathResizedImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+articleBlogName);
		resizedImageToDelete.delete();
		File thumbnailImageToDelete = new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+"/"+articleBlogName);
		thumbnailImageToDelete.delete();
	}
	
	@RequestMapping(value="/imageDelete/{idImage}/{imageName}", method=RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public void deleteImageAjax(@PathVariable Long idImage, @PathVariable String imageName){	
		Gson gson = null;
		
		String path = "/tmp/joocebox-img/"+dashboardFacade.getAgency().getSubdomain()+"/articleBlog/"+"/"+imageName;
		if(new File(path).exists()){
			List<ImageJson> imagePathTmpList = dashboardFacade.getImagePathTmpList();

			for (ImageJson imageJsonList : imagePathTmpList) {
				gson = new Gson();
				
				FileMeta imgTmp = gson.fromJson(imageJsonList.getJson(), FileMeta.class);
				
				if(imageName.equals(imgTmp.getFileName())){
					String oldPath = imgTmp.getFileTmpPath();
					deleteTmpImages(oldPath, imageJsonList);	
				}
			}
		}else{

			Article articleBlogId = articleBlogFacade.getArticleBlogId(idImage);
			
			Set<Image> images = articleBlogId.getImages();
			for (Image imagenPathList : images) {
				gson = new Gson();
				FileMeta fromJson =  gson.fromJson(imagenPathList.getJson(), FileMeta.class);
				
				if(imageName.concat(".jpg").equals(fromJson.getFileName())){
					
					File originalImageToDelete = new File(fromJson.getFileTmpPath());
					File resizedImageToDelete = new File(new JooceBoxProperties().getPathResizedImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+articleBlogId.getAtName()+"/"+fromJson.getFileName());
					File thumbnailImageToDelete = new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(dashboardFacade.getAgency().getSubdomain())+articleBlogId.getAtName()+"/"+fromJson.getFileName());
					if (!originalImageToDelete.exists() && !resizedImageToDelete.exists() && !thumbnailImageToDelete.exists()) {
						logger.info("Arquivo inexistente!");
					}else{
					originalImageToDelete.delete();		
					resizedImageToDelete.delete();
					thumbnailImageToDelete.delete();
					dashboardFacade.deleteImageId(imagenPathList.getId());
					}
				}
			}
		}

	}
	
	@RequestMapping(value ="/imageList/{id}", method=RequestMethod.GET)  
	public @ResponseBody List<String> getImagesJson(@PathVariable Long id){ 
		List<String> jsonObj= null;
		Gson gson;
		
		Article articleBlog = articleBlogFacade.getArticleBlogId(id);		
		File file = new File(new JooceBoxProperties().getPathOriginalImagesArticleBlog(dashboardFacade.getAgency().getSubdomain())+articleBlog.getAtName());
		
		if(file.exists()){
			File[] listFiles = file.listFiles();
			FileMeta fileMeta = new FileMeta();
			jsonObj = new ArrayList<String>();
			for (File files : listFiles) {
				fileMeta.setFileName(files.getName());
				fileMeta.setFileSize(String.valueOf(files.length()));
				fileMeta.setFileType(new MimetypesFileTypeMap().getContentType(files));
				fileMeta.setFileTmpPath(files.getAbsolutePath());
				
				//TODO: Generate Thumbnail Image by call
				
				gson = new Gson();
				String generated = gson.toJson(fileMeta);
				jsonObj.add(generated);
				
			}
		} else{
			logger.info("Caminho " + file.toString() + " inexistente!");
		}
		
	    return jsonObj;
	}

	public Set<Image> imageReplication(Article articleBlog) {
		Gson gson = null;
		Set<Image> copyOriginalFilesToServerList = new HashSet<Image>();
	
		List<ImageJson> imagePathTmpList = dashboardFacade.getImagePathTmpList();

		String subdomain = dashboardFacade.getAgency().getSubdomain();

		if (imagePathTmpList.size() == 0 || imagePathTmpList == null) {
			
			return articleBlog.getImages();
			
		} else {
			try {

				for (ImageJson imageJsonList : imagePathTmpList) {
					
					gson = new Gson();

					FileMeta imgTmp = gson.fromJson(imageJsonList.getJson(), FileMeta.class);

					String oldPath = imgTmp.getFileTmpPath();
					System.out.println("Variavel oldpath " + oldPath);
					 
					Image copyOriginalFilesToServer = copyOriginalFilesToServer(subdomain, oldPath, articleBlog, imgTmp.getFileName(), imgTmp);
					copyOriginalFilesToServerList.add(copyOriginalFilesToServer);
					
					copyThumbnailFilesToServer(subdomain, oldPath, articleBlog.getAtName(), imgTmp.getFileName());
					copyResizedFilesToServer(subdomain, oldPath, articleBlog.getAtName(), imgTmp.getFileName());
					
				}

			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				deleteTmp();
			}

			return copyOriginalFilesToServerList;
		}

	}

	public Image copyOriginalFilesToServer(String subdomain, String oldPath, Article articleBlog, String fileName, FileMeta fileMeta) throws FileNotFoundException, IOException {		
		Gson gson = new Gson();
		Image image = new Image();
		File folder = new File(new JooceBoxProperties().getPathOriginalImagesArticleBlog(subdomain)+articleBlog.getAtName());
		
		fileMeta.setFileTmpPath(folder.getAbsolutePath()+"/"+fileName);		
		String finalJsonImgAttributes = gson.toJson(fileMeta);		
		image.setJson(finalJsonImgAttributes);


		if (!folder.exists())
			folder.mkdirs();			
		
			FileCopyUtils.copy(new File(oldPath), new File(new JooceBoxProperties().getPathOriginalImagesArticleBlog(subdomain)+articleBlog.getAtName()+"/"+fileName));
			
			if (articleBlog.getImages() != null) 			
				 return image;
			
		return image;
	}
	
	public void copyThumbnailFilesToServer(String subdomain, String oldPath, String articleBlogName, String fileName) throws FileNotFoundException, IOException{
		
		File folder = new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(subdomain)+articleBlogName);
		FileUtils.touch(new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(subdomain)+articleBlogName+"/"+fileName));
		
		if (!folder.exists())
			folder.mkdirs();
		
		FileCopyUtils.copy(resizeArticleBlogImageToThumb(oldPath), new File(new JooceBoxProperties().getPathThumbnailImageArticleBlog(subdomain)+articleBlogName+"/"+fileName));
	}
	
	public void copyResizedFilesToServer(String subdomain, String oldPath, String articleBlogName, String fileName) throws FileNotFoundException, IOException{
		
		File folder = new File(new JooceBoxProperties().getPathResizedImageArticleBlog(subdomain)+articleBlogName);
		FileUtils.touch(new File(new JooceBoxProperties().getPathResizedImageArticleBlog(subdomain)+articleBlogName+"/"+fileName));
		
		if (!folder.exists())
			folder.mkdirs();
		
			FileCopyUtils.copy(resizeArticleBlogImage(oldPath), new File(new JooceBoxProperties().getPathResizedImageArticleBlog(subdomain)+articleBlogName+"/"+fileName));		
	}
	
	public byte[] resizeArticleBlogImage(String path) throws FileNotFoundException, IOException {
		
		File arq = new File(path);
		byte[] byteArray = IOUtils.toByteArray(FileUtils.openInputStream(arq));
		
		ImageUtils imageUtils = new ImageUtils();
		
		return imageUtils.resizeImageToJpg(byteArray, 696, 348);
}

	public byte[] resizeArticleBlogImageToThumb(String path) throws FileNotFoundException, IOException {
		
		File arq = new File(path);
		byte[] byteArray = IOUtils.toByteArray(FileUtils.openInputStream(arq));
						
		ImageUtils imageUtils = new ImageUtils();

		return imageUtils.resizeImageToJpg(byteArray, 70, 70);
	}
	
}