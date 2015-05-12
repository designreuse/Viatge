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

import br.com.joocebox.model.Agency;
import br.com.joocebox.service.DashboardFacade;
import br.com.joocebox.service.LoginFacade;

@Transactional(propagation = Propagation.REQUIRED)
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired 
	private DashboardFacade dashboardFacade;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        Agency user = (Agency) session.getAttribute("user");
        if(user == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Agency agency = dashboardFacade.getAgency();
            //String email = auth.getName();
            //user = dashboardFacade.findByEmail(email);
            session.setAttribute("user", agency);
        }

        return super.preHandle(request, response, handler);
    }
}