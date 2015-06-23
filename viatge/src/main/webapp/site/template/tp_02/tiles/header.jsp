<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<header class="bg-thema">
	<div class="center">
		<h1 class="ocultar"><c:out value="${tenant.agencyName}"/></h1>
        <a href="<c:out value="${pageContext.request.contextPath}/site"/>" class="logo"><img src="${pageContext.request.contextPath}/image/logo/${tenant.agencyConfig.agencyLogo}" width="190" height="100" alt=<c:out value="${tenant.agencyName}"/>></a>
        
        <nav>
        	<div class="phone"><i></i> <span class="txt-thema"><c:out value="${tenant.agencyPhone}"/></span></div>
            
            <!-- MÍDIA SOCIAL -->
            <ul class="midia-social">
            	<li class="facebook"><a href="javascript:window.open('${linkFacebookSession}');"></a></li>
                <li class="twitter"><a href="javascript:window.open('${linkTwitterSession}');"></a></li>
                <li class="instagram"><a href="javascript:window.open('${linkInstagramSession}');"></a></li>
                <li class="plus"><a href="javascript:window.open('${linkGooglePlusSession}');"></a></li>
                <li class="youtube"><a href="#"></a></li>
                <li class="linkedin"><a href="#"></a></li>
            </ul>
			
            <!-- MENU PRINCIPAL -->  
            <span class="gatilho-menu">Menu</span>
                       
            <menu>
            	<li>
                	<a href="#">CATEGORIAS</a>
                    <!-- MENU DE CATEGORIAS -->
                	<ul>
					<c:forEach var="category" items="${categoryListSession}">
						<li>
							<a href="${pageContext.request.contextPath}/category-list/${category.idCategory}">${category.ctName}</a>
						</li>
					</c:forEach>
                    </ul>
                </li>
				<li><a href="${pageContext.request.contextPath}/perfect-travel">VIAGEM PERFEITA</a></li>
                <li><a href="${pageContext.request.contextPath}/blog">BLOG</a></li>
                <li><a href="${pageContext.request.contextPath}/online-shop">COMPRE ONLINE</a></li>
                <li><a href="${pageContext.request.contextPath}/about-us">QUEM SOMOS</a></li>
                <li><a href="${pageContext.request.contextPath}/contact">CONTATO</a></li>
            </menu>
            <!-- FIM MENU PRINCIPAL -->  
        </nav> 	
    </div>
</header>