package br.com.joocebox.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.joocebox.model.Agency;
import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.Role;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.utils.AjaxMessageReturn;
import br.com.joocebox.utils.ImageUtils;
import br.com.joocebox.utils.JooceBoxProperties;
import br.com.joocebox.utils.JsonUtils;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
public class AgencyController {
	@Autowired 
	private DashboardFacade dashboardFacade;
	
	private ImageUtils imageUtils;
	private AjaxMessageReturn ajaxMessageReturn; 
	private JooceBoxProperties properties; 
	private FileMeta fileMeta;
	private JsonUtils jsonUtils;
	
	
	final static Logger logger = LoggerFactory.getLogger(AgencyController.class);

	@RequestMapping("/register")
	public String newRegister(@ModelAttribute("tenant") Agency tenant){
		return "landing/register";	
	}
	
	/**
	 * Ação reponsável pela criação de um nova agência.
	 * @param agency - Agência que será cadastrada
	 * @return url de redirecionamento para o wizard
	 * @throws IOException 
	 */

	@RequestMapping(value = "/addAgency", method = RequestMethod.POST)
	public String addAgency(@ModelAttribute("tenant") Agency agency, Model model) {
		agency.setActive(true);
		agency.setCreationDate(new Date());
		agency.setRole(Role.ROLE_MASTER);
		agency = dashboardFacade.addAgency(agency);
		
		if(agency != null){
			
			//Formação do path completo para criação do diretório do tenant
			String tenantDir = new JooceBoxProperties().getPathTenants()+agency.getSubdomain();
			File file = new File(tenantDir);
			
			if(file.isDirectory()){
				logger.warn("Diretório do tenant "+agency.getSubdomain()+" já existe");
			} else {
				if(file.mkdir()){
					logger.info("Criando diretório do tenant "+agency.getSubdomain());
				} else {
					logger.warn("Não foi possível criar o diretório do tenant "+agency.getSubdomain());
				}
			}
			
			return "redirect:" + getAgencyRegisterWizardFullUrl(agency);
			
		}
		
		return "landing/register";
	}
	
	
	@RequestMapping("/register/wizard")
	public String wizard(@ModelAttribute("tenant") Agency tenant){
		return "landing/wizard";	
	}
	
	/**
	 * Ação responsável por salvar a imagem de logo da agência que está sendo cadastrada.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/register/upload", method = RequestMethod.POST)
	@ResponseBody
	public AjaxMessageReturn uploadLogo(@ModelAttribute("agencyForm") Agency agency, MultipartHttpServletRequest request, HttpServletResponse response){
		ajaxMessageReturn = new AjaxMessageReturn();
		ajaxMessageReturn.setSuccess(false);
		
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;

        while(itr.hasNext()){
            mpf = request.getFile(itr.next()); 
            String subdomain = dashboardFacade.getAgency().getSubdomain();
            File base = new File(new JooceBoxProperties().getPathLogoTenants(subdomain));
            String path = base+"/"+mpf.getOriginalFilename();

            fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());
            fileMeta.setFileTmpPath(path);
            
            try {
            	jsonUtils = new JsonUtils();
            	
               if (!base.exists()) {
					base.mkdirs();
					
					imageUtils = new ImageUtils();
					byte[] resizeImage = imageUtils.resizeImageToPng(mpf.getBytes(), 156, 30);
					
	                FileCopyUtils.copy(resizeImage, new FileOutputStream(path)); 
	                jsonUtils.generateJson(fileMeta);
	                ajaxMessageReturn.setMessage("OK");
				} else {
	                 FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path));
	                 jsonUtils.generateJson(fileMeta);	      
				}

               Agency populatedAgency = dashboardFacade.getAgency();
               
               if(populatedAgency != null){
            	   populatedAgency.setAgencyLogo(path);
            	   dashboardFacade.updateAgency(populatedAgency);
            	   ajaxMessageReturn.setSuccess(true);
            	   
            	   
            	   String uri = request.getScheme() + "://" +   // "http" + "://
            	             request.getServerName() +       // "myhost"
            	             ":" +                           // ":"
            	             request.getServerPort() +       // "8080"
            	             "/viatge/image/view?pathname=";
            	   
            	   ajaxMessageReturn.setMessage(uri+path);
               }
               
           } catch (IOException e) {
               e.printStackTrace();
               ajaxMessageReturn.setSuccess(false);
               ajaxMessageReturn.setMessage("Houve algum erro ao tentar realizar upload da logo de sua agência: "+e.getMessage());
           }
        }
        
        return ajaxMessageReturn;
	}

	
	/**
	 * Ação reponsável pela inserção de dados no cadstro da agência de acordo com o Wizard
	 * @param agency - Agência que será cadastrada
	 * @return url de redirecionamento para o wizard
	 */
	@RequestMapping(value = "/register/populateAgency", method = RequestMethod.POST)
	public String populateAgencyFromWizard(@ModelAttribute("agencyForm") Agency agency) {
		
		Agency populatedAgency = dashboardFacade.getAgency();
		
		if(populatedAgency != null){
			populatedAgency.setAgencyName(agency.getAgencyName());
			populatedAgency.setAgencyCNPJ(agency.getAgencyCNPJ());
			populatedAgency.setAgencyPhone(agency.getAgencyPhone());
			populatedAgency.setFirstName(agency.getFirstName());
			populatedAgency.setLastName(agency.getLastName());
			populatedAgency.setEmail(agency.getEmail());
			populatedAgency.setPassword(agency.getPassword());
			populatedAgency.setTemplateColor(agency.getTemplateColor());
			populatedAgency.setSiteTemplate(agency.getSiteTemplate());
			dashboardFacade.updateAgency(populatedAgency);
			
			destinationImageReplication();
			
			dashboardFacade.callReplicationDestinationProcedure(populatedAgency.getSubdomain(), dashboardFacade.getAgency().getTenantId());
		}
		
		return "redirect:" + getAgencyFullUrl(populatedAgency);
		
	}

	public void destinationImageReplication() {
		  String source = "/app/joocebox-img/www/destination";
		    File srcDir = new File(source);

		    //
		    // The destination directory to copy to. This directory
		    // doesn't exists and will be created during the copy
		    // directory process.
		    //
		    String destination = "/app/joocebox-img/"+dashboardFacade.getAgency().getSubdomain()+"/destination";
		    File destDir = new File(destination);

		    try {
		    	
		    	if(!destDir.exists()){
		    		destDir.mkdirs();
		    	}
		        //
		        // Copy source directory into destination directory
		        // including its child directories and files. When
		        // the destination directory is not exists it will
		        // be created. This copy process also preserve the
		        // date information of the file.
		        //
		        FileUtils.copyDirectory(srcDir, destDir);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
	
	/**
	 * Action ajax responsavel por verificar se o subdominio que o usuario digitou esta cadastrado ou nao.
	 * 
	 * @param subdomain - Subdominio que sera verificado
	 * @return {@link AjaxMessageReturn}
	 */
	@RequestMapping(value="/register/ajaxVerifySubdomain", method=RequestMethod.POST)
	@ResponseBody
	public AjaxMessageReturn ajaxVerifySubdomain(@RequestParam String subdomain){
		ajaxMessageReturn = new AjaxMessageReturn();
		ajaxMessageReturn.setSuccess(false);
		
		if(!subdomain.isEmpty()){
			
			if(dashboardFacade.isAgencySubdomainRegistrered(subdomain)){
				ajaxMessageReturn.setSuccess(true);
				ajaxMessageReturn.setMessage("Ops! O subdomínio "+subdomain+" já está em uso por outra agência.");
			} else {
				ajaxMessageReturn.setSuccess(true);
				ajaxMessageReturn.setMessage("OK");
			}
			
		} else {
			ajaxMessageReturn.setMessage("Ops! Nenhum subdomínio foi digitado.");
		}
	
		return ajaxMessageReturn;
	}
	
	/**
	 * Obtem URL para continuidade no processo de cadastramento da agência
	 * 
	 * @param agency - Agência
	 * @return url
	 */
	protected String getAgencyRegisterWizardFullUrl(Agency agency) {
		String url = "http://" + agency.getSubdomain() + ".lvh.me:8080/viatge/register/wizard";
		//String url = "http://" + agency.getSubdomain() + ".joocebox.com:8080/viatge/register/wizard";
		
		return url;
	}
	
	/**
	 * Obtem URL da Agência
	 * 
	 * @param agency - Agência
	 * @return url
	 */
	protected String getAgencyFullUrl(Agency agency) {
		String url = "http://" + agency.getSubdomain() + ".lvh.me:8080/viatge/login";
		//String url = "http://" + agency.getSubdomain() + ".joocebox.com:8080/viatge/login";
		
		return url;
	}
	
	/**
	 * Método utilitário em modo desenvolvimento para a criação  do tenant Master da aplicação
	 * 
	 * @param redirectAttributes 
	 * @return
	 */
	@RequestMapping(value = "/createMasterData", method = RequestMethod.GET)
	public String createMasterData(final RedirectAttributes redirectAttributes) {
		dashboardFacade.createMasterData();

		redirectAttributes.addFlashAttribute("MasterAgencyCreate", "Dados Master criados com sucesso");
		return "redirect:/login";
	}
}
