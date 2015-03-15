package br.com.joocebox.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.utils.AjaxMessageReturn;


public class AgencyControllerTest {
	@Autowired private DashboardFacade dashboardFacade;
	private AjaxMessageReturn ajaxMessageReturn; 
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAjaxVerifySubdomain() {
		String subdomain = "www";
		
		
	}


}
