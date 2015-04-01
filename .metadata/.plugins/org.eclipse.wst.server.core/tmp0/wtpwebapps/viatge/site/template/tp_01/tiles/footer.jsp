<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<footer id="footer">
<div class="footer-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3">
				<h2>Descubra</h2>
				<ul class="discover triangle hover row">
					<li class="col-xs-6"><a href="#">Categorias</a></li>
					<li class="col-xs-6"><a href="#">Blog</a></li>
					<li class="col-xs-6"><a href="#">Quem Somos</a></li>
					<li class="col-xs-6"><a href="#">Contato</a></li>
				</ul>
			</div>


			<div class="col-sm-6 col-md-3 pull-right">
				<h2>Sobre o JooceBox</h2>
				<p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae
					pulvinar massaidp nequetiam lore elerisque.</p>
				<br />
				<address class="contact-details">
					<span class="contact-phone">
						<i class="soap-icon-phone"></i>
						<c:out value="${tenant.agencyPhone}"/></span> <br /> <a href="#" class="contact-email"><c:out value="${tenant.email}"></c:out></a>
				</address>
				<ul class="social-icons clearfix">
					<li class="twitter"><a title="twitter" href="#"
						data-toggle="tooltip"><i class="soap-icon-twitter"></i></a></li>
					<li class="googleplus"><a title="googleplus" href="#"
						data-toggle="tooltip"><i class="soap-icon-googleplus"></i></a></li>
					<li class="facebook"><a title="facebook" href="#"
						data-toggle="tooltip"><i class="soap-icon-facebook"></i></a></li>
					<li class="linkedin"><a title="linkedin" href="#"
						data-toggle="tooltip"><i class="soap-icon-linkedin"></i></a></li>
					<li class="vimeo"><a title="vimeo" href="#"
						data-toggle="tooltip"><i class="soap-icon-vimeo"></i></a></li>
					<li class="dribble"><a title="dribble" href="#"
						data-toggle="tooltip"><i class="soap-icon-dribble"></i></a></li>
					<li class="flickr"><a title="flickr" href="#"
						data-toggle="tooltip"><i class="soap-icon-flickr"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="bottom gray-area">
	<div class="container">
		<div class="logo pull-left">
			<a href="index.html"> <img
				src="${pageContext.request.contextPath}/image/logo/${tenant.agencyLogo}"
				alt="JooceBox - Faça o seu melhor!"
				style="height: 30px; width: 156px;" />
			</a>
		</div>
		<div class="pull-right">
			<a id="back-to-top" href="#" class="animated"
				data-animation-type="bounce"><i
				class="soap-icon-longarrow-up circle"></i></a>
		</div>
		<div class="copyright pull-right">
			<p>&copy; 2015 <c:out value="${tenant.agencyName}"/></p>
		</div>
	</div>
</div>
</footer>