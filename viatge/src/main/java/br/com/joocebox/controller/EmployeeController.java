package br.com.joocebox.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Employee;
import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.Goals;
import br.com.joocebox.model.Role;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.StaffFacade;
import br.com.joocebox.utils.ImageUtils;
import br.com.joocebox.utils.JooceBoxFileUtils;
import br.com.joocebox.utils.JooceBoxUtils;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
@RequestMapping("/auth")
public class EmployeeController{
	
	final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private StaffFacade staffFacade;
	
	@Autowired
	private DashboardFacade dashboardFacade;
	
	JooceBoxUtils jbUtils = new JooceBoxUtils();
	
	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
	
	@RequestMapping("staff")
	public ModelAndView staffScreen(){
		ModelAndView mv = new ModelAndView("staff/listOfStaff");
		mv.addObject("listOfStaff", staffFacade.getListOfStaff());
		return mv;
	}
	
	@RequestMapping("goals")
	public ModelAndView goalsScreen(){
		ModelAndView mv = new ModelAndView("staff/goals");
		mv.addObject("goals", new Goals());
		mv.addObject("staff", staffFacade.getListOfStaff());
		return mv;
	}
	
	@RequestMapping("employee")
	public ModelAndView employeeSreen(){
		ModelAndView mv = new ModelAndView("staff/employee");
		mv.addObject("staff", new Employee());
		mv.addObject("systemRoles", jbUtils.getListOfSytemRoles());
		mv.addObject("showRole", false);
		return mv;
	}
	
	@RequestMapping(value = "employee/chart/{id}", method = RequestMethod.GET)
	public ModelAndView chartScreen(@PathVariable Long id){
		Employee findEmployeeById = staffFacade.findEmployeeById(id);	
		ModelAndView mv = new ModelAndView("staff/chart");		
		mv.addObject("yearAmmount", "100");
		mv.addObject("dataChart", findEmployeeById.getGoal());
		return mv;
	}
	
	private void validForm(BindingResult result, ModelMap model) {
		List<String> error = new ArrayList<>();
		List<ObjectError> allErrors = result.getAllErrors();
		for (ObjectError objectError : allErrors) {
			String objectName = objectError.getDefaultMessage();
			error.add(objectName);
		}
		model.put("errors", error);
		model.put("validator", true);
	}
	
	@RequestMapping(value = "/employee/add", method ={RequestMethod.POST, RequestMethod.PUT})
	public ModelAndView saveEmployee(@ModelAttribute("staff") @Valid Employee staff, BindingResult result, ModelMap model, HttpServletRequest request) {
		
		String parameter = request.getParameter("id");
        
		if (result.hasErrors()) {
			validForm(result, model);
			model.put("systemRoles", jbUtils.getListOfSytemRoles());
			return new ModelAndView("staff/employee", "staff", staff);
			
		}else if(parameter == null || "".equals(parameter)){
			staffFacade.save(staff);
			return new ModelAndView("redirect:/auth/staff", "listOfStaff", staffFacade.getListOfStaff());
		}else{
			staffFacade.update(staff, Long.parseLong(parameter));
			return new ModelAndView("redirect:/auth/staff", "listOfStaff", staffFacade.getListOfStaff());
		}

	}
	
	@RequestMapping(value = "employee/view/{id}", method = RequestMethod.GET)
	public String viewEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("staff", staffFacade.findEmployeeById(id));   
		return "staff/employeeDetails";
	}
	
	@RequestMapping(value = "employee/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable Long id, Model model) {
		Employee findEmployeeById = staffFacade.findEmployeeById(id);		
		if(Role.ROLE_MASTER.equals(findEmployeeById.getLogin().getRole())){
			model.addAttribute("systemRoles", jbUtils.getListOfSytemRoles());
			model.addAttribute("staff", findEmployeeById);   
		    model.addAttribute("showRole", false);
		}else{
			model.addAttribute("systemRoles", jbUtils.getListOfSytemRoles());
			model.addAttribute("staff", findEmployeeById);
		    model.addAttribute("showRole", true);
		}
		return "staff/employee";
	}
	
	@RequestMapping(value = "/employee/upload/{id}", method = RequestMethod.POST)
	public @ResponseBody String uploadAvatar(
			MultipartHttpServletRequest request, HttpServletResponse response, @PathVariable Long id) {

		String subdomain = dashboardFacade.getAgency().getSubdomain();
		File base = new File("/app/joocebox-img/" + subdomain + "/avatar/"+id);

		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		ImageUtils imageUtils = new ImageUtils();

		mpf = request.getFile(itr.next());
		logger.info(mpf.getOriginalFilename() + " uploaded! " + files.size());
		File file = new File(base+"/"+mpf.getOriginalFilename());

		try {

			if (!base.exists()) {
				base.mkdirs();
				byte[] resizeImage = imageUtils.resizeImageToJpg(
						mpf.getBytes(), 150, 150);
				FileCopyUtils.copy(resizeImage,
						new FileOutputStream(base+"/"+ mpf.getOriginalFilename()));
				file.renameTo(new File(base+"/"+"avatar-"+id+".jpg"));

			} else {
				new JooceBoxFileUtils().deleteFilesInFolder(base);
				
				byte[] resizeImage = imageUtils.resizeImageToPng(
						mpf.getBytes(), 150, 150);
				FileCopyUtils.copy(resizeImage,
						new FileOutputStream(base+"/"+ mpf.getOriginalFilename()));  
				file.renameTo(new File(base+"/"+"avatar-"+id+".jpg"));
					
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Employee findEmployeeById = staffFacade.findEmployeeById(id);
		if(Boolean.FALSE.equals(findEmployeeById.getAvatar())){
			findEmployeeById.setAvatar(Boolean.TRUE);
			staffFacade.update(findEmployeeById, id);
		}
		return request.getContextPath()+"/image/avatar/"+id+"/avatar-"+id+".jpg";
	}
	
	@RequestMapping(value = "goal/add", method=RequestMethod.POST)
	public ModelAndView addGoals(@ModelAttribute("employee") @Valid Goals goals, @RequestParam Long employeeID, BindingResult result, ModelMap model){
		
		if (result.hasErrors()) {
			validForm(result, model);
			model.addAttribute("message", true);
			return goalsScreen();
		}else{
			staffFacade.saveOrUpdateGoal(goals, employeeID);
			return goalsScreen();
		}
		
	}
	
	@RequestMapping(value = "goal/getGoal", method=RequestMethod.GET)
	public @ResponseBody Goals addGoals(@RequestParam Long empID){
		Employee findEmployeeById = staffFacade.findEmployeeById(empID);		
		return findEmployeeById.getGoal();		
	}
}