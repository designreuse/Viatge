<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<header id="header" class="navbar-static-top">
<div class="topnav hidden-xs" /></div>

<div class="main-header">

	<div class="container">
		<h1 class="logo navbar-brand">
			<a href="index.html" title="Travelo - home"> <img
				src="images/rsz_logo_joocebox.png"
				alt="JooceBox - Faça o seu melhor!"
				style="height: 30px; width: 156px;" />
			</a>
		</h1>

		<nav id="main-menu" role="navigation">
		<ul class="menu contact-details">
			<li class="menu-item-has-children"><a href="index.html">Inicio</a>
			</li>
			<li class="menu-item-has-children"><a href="hotel-index.html">Categorias</a>

				<ul>
					<c:forEach var="category" items="${categoryList}">
						<li>
							<a href="${pageContext.request.contextPath}/categoryList/${category.idCategory}">${category.ctName}</a>
						</li>
					</c:forEach>
				</ul></li>
			<li class="menu-item-has-children"><a href="flight-index.html">Blog</a></li>
			<li class="menu-item-has-children"><a href="car-index.html">Quem Somos</a></li>
			<li class="menu-item-has-children"><a href="cruise-index.html">Contato</a></li>
			<li class="menu-item-has-children">
				<span class="contact-phone">
					<i class="soap-icon-phone"></i>
					<c:out value="${tenant.agencyPhone}"/>
				</span>
			</li>
		</ul>

		</nav>
	</div>
</div>
</header>