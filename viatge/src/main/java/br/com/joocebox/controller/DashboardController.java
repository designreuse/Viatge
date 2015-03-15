package br.com.joocebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class DashboardController {

	
	//Redirecionamento para a home feito com o Spring Security.
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
}
