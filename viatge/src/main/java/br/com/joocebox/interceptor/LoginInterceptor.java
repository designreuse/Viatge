package br.com.joocebox.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.joocebox.model.Employee;
import br.com.joocebox.model.Login;
import br.com.joocebox.service.EmployeeFacade;
import br.com.joocebox.service.LoginFacade;

@Transactional(propagation = Propagation.REQUIRED)
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired 
	private LoginFacade loginFacade;
	
	@Autowired
	private EmployeeFacade employeeFacade;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        Login user = (Login) session.getAttribute("user");
        
        if(user == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            //Agency agency = dashboardFacade.getAgency();
            String email = auth.getName();
            user = loginFacade.findByEmail(email);
            
            for(Employee employee : employeeFacade.findAllEmployees()){
            	if(user.getId().equals(employee.getLogin().getId())){
                    session.setAttribute("employeeAvatar", employee);
            	}
            }

        }

        return super.preHandle(request, response, handler);
    }
}