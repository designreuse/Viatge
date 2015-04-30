package br.com.joocebox.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Staff;
import br.com.joocebox.service.StaffFacade;
import br.com.joocebox.utils.JooceBoxUtils;

@Controller
@Transactional(propagation=Propagation.REQUIRED)
@RequestMapping("/auth")
public class StaffController{
	
	@Autowired
	private StaffFacade staffFacade;
	
	JooceBoxUtils jbUtils = new JooceBoxUtils();
	
	@RequestMapping("/staff")
	public ModelAndView staffScreen(HttpSession session){
		ModelAndView mv = new ModelAndView("staff/listOfStaff");
		mv.addObject("listOfStaff", staffFacade.getListOfStaff());		
		return mv;
	}
	
	@RequestMapping("/employee")
	public ModelAndView employeeSreen(){
		ModelAndView mv = new ModelAndView("staff/employee");
		mv.addObject("staff", new Staff());
		mv.addObject("systemRoles", jbUtils.getListOfSytemRoles());
		return mv;
	}
	
	/**
	 * @param result
	 * @param model
	 * @param error
	 */
	private void validForm(BindingResult result, ModelMap model) {
		List<String> error = new ArrayList<>();
		List<ObjectError> allErrors = result.getAllErrors();
		for (ObjectError objectError : allErrors) {
			String objectName = objectError.getDefaultMessage();
			error.add(objectName);
		}
		model.put("systemRoles", jbUtils.getListOfSytemRoles());
		model.put("errors", error);
		model.put("validator", true);
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@Valid Staff staff, BindingResult result, ModelMap model) {		

		if (result.hasErrors()) {
			validForm(result, model);	
			return "staff/employee";
		}
		staff.setActive(Boolean.TRUE);
		staffFacade.save(staff);
		
		return "redirect:/staff";
	}
	
	@RequestMapping(value = "/viewEmployee/id/{id}", method = RequestMethod.GET)
	public String viewEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("staff", staffFacade.findEmployeeById(id));   
		return "staff/employeeDetails";
	}
	
	@RequestMapping(value = "/editEmployee/id/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("systemRoles", jbUtils.getListOfSytemRoles());
		model.addAttribute("staff", staffFacade.findEmployeeById(id));   
		return "staff/employee";
	}

}
