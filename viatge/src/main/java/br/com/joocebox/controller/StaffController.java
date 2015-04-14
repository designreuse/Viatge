package br.com.joocebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.joocebox.model.Staff;

@Controller
public class StaffController {
	
	@RequestMapping("/staff")
	public ModelAndView staffScreen(){
		return new ModelAndView("staff/listOfStaff", "staffList", new Staff());
	}

}
