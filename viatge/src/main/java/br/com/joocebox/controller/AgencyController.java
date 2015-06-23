package br.com.joocebox.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.joocebox.model.Agency;
import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.Login;
import br.com.joocebox.model.Role;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.utils.AjaxMessageReturn;
import br.com.joocebox.utils.ImageUtils;
import br.com.joocebox.utils.JooceBoxProperties;
import br.com.joocebox.utils.JooceBoxUtils;
import br.com.joocebox.utils.JsonUtils;

import com.google.common.base.Strings;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
public class AgencyController {
	@Autowired 
	private DashboardFacade dashboardFacade;
	
	private ImageUtils imageUtils;
	private AjaxMessageReturn ajaxMessageReturn; 
	private FileMeta fileMeta;
	private JsonUtils jsonUtils;
	
	
	final static Logger logger = LoggerFactory.getLogger(AgencyController.class);

	@RequestMapping("/register")
	public String newRegister(@ModelAttribute("tenant") Agency tenant){
		return "landing/register";	
	}
	
	@RequestMapping("/register/wizard")
	public String wizard(@ModelAttribute("agency") Agency agency){
		return "landing/wizard";	
	}
	
	/**
	 * Ação reponsável pela criação de um nova agência.
	 * @param agency - Agência que será cadastrada
	 * @return url de redirecionamento para o wizard
	 * @throws IOException 
	 */

	@RequestMapping(value = "/addAgency", method = RequestMethod.POST)
	public String addAgency(@ModelAttribute("tenant") Agency agency, Model model) {
		System.out.println("entrou add agency");
		agency.setActive(true);
		agency.setCreationDate(new Date());
//		agency.setRole(Role.ROLE_MASTER);
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
					byte[] resizeImage = imageUtils.resizeImageToPng(mpf.getBytes(), 190, 100);
					
	                FileCopyUtils.copy(resizeImage, new FileOutputStream(path)); 
	                jsonUtils.generateJson(fileMeta);
	                ajaxMessageReturn.setMessage("OK");
				} else {
					 File[] listFiles = base.listFiles();
					 for (File file : listFiles) {
						file.delete();
					}
	                 FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path));
	                 jsonUtils.generateJson(fileMeta);	      
				}

               Agency populatedAgency = dashboardFacade.getAgency();
               
               if(populatedAgency != null){
            	   populatedAgency.getAgencyConfig().setAgencyLogo(path);
            	   dashboardFacade.updateAgency(populatedAgency);
            	   ajaxMessageReturn.setSuccess(true);
            	   
            	   
            	   String uri = request.getScheme() + "://" +   
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
	public ModelAndView populateAgencyFromWizard(@ModelAttribute("agencyForm") @Valid Agency agency, BindingResult result, ModelMap model) {
		
		if(result.hasErrors() || isExtraFieldsHasErrors(agency, model)){
			new JooceBoxUtils().validForm(result, model);
			model.addAttribute("extraFields", true);
			return new ModelAndView("landing/wizard", "agencyForm", agency);
		}else{
			Agency populatedAgency = dashboardFacade.getAgency();
			
			if(populatedAgency != null){
				populatedAgency.setAgencyName(agency.getAgencyName());
				populatedAgency.setAgencyCNPJ(agency.getAgencyCNPJ());
				populatedAgency.setAgencyPhone(agency.getAgencyPhone());
				populatedAgency.setFirstName(agency.getFirstName());
				populatedAgency.setLastName(agency.getLastName());
				BCryptPasswordEncoder passEnconder = new BCryptPasswordEncoder();	
				populatedAgency.setLogin(new Login(agency.getLogin().getEmail(), passEnconder.encode(agency.getLogin().getPassword()), new Date(), Role.ROLE_MASTER, Boolean.TRUE, dashboardFacade.getAgency().getId()));
				populatedAgency.getAgencyConfig().setTemplateColor(agency.getAgencyConfig().getTemplateColor());
				populatedAgency.getAgencyConfig().setSiteTemplate(agency.getAgencyConfig().getSiteTemplate());
			
				dashboardFacade.updateAgency(populatedAgency);
				
				destinationImageReplication();
				
				//dashboardFacade.callReplicationDestinationProcedure(populatedAgency.getSubdomain(), dashboardFacade.getAgency().getTenantId());
				
				dashboardFacade.callCreateMasterEmployeeProcedure(agency.getFirstName(), agency.getLastName(), dashboardFacade.getAgency().getTenantId());
			}
			
			return new ModelAndView("redirect:" + getAgencyFullUrl(populatedAgency));
		}
	}

	private Boolean isExtraFieldsHasErrors(Agency agency, ModelMap model) {
		if(Strings.isNullOrEmpty(agency.getAgencyCNPJ()) ||
				Strings.isNullOrEmpty(agency.getAgencyName()) ||
				Strings.isNullOrEmpty(agency.getAgencyPhone())||
				Strings.isNullOrEmpty(agency.getFirstName())||
				Strings.isNullOrEmpty(agency.getLastName())){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public void destinationImageReplication() {
		  String source = "/app/joocebox-img/www/destination";
		    File srcDir = new File(source);
		    String destination = "/app/joocebox-img/"+dashboardFacade.getAgency().getSubdomain()+"/destination";
		    File destDir = new File(destination);

		    try {
		    	
		    	if(!destDir.exists()){
		    		destDir.mkdirs();
		    	}
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
