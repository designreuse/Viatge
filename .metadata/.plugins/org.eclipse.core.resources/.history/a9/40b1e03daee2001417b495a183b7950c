<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Features section -->
<div class="features section global-map-area parallax"
	data-stellar-background-ratio="0.5">
	<div class="section container">
		<h2 align="center" style="color: white; font-size: 38px;">Destinos
			em Destaque</h2>
		<div class="row image-box style3">
			<c:forEach var="destinationHighlight" items="${destinationHightlightList}">
				<div class="col-sms-6 col-sm-6 col-md-3">
					<article class="box">
						<figure class="animated" data-animation-type="fadeInDown" data-animation-delay="0">
							<a href="${pageContext.request.contextPath}/destinationDetail/${destinationHighlight.idDestination}" class="hover-effect">
								<img width="270" height="160" alt="" src="${pageContext.request.contextPath}/image/destination/${destinationHighlight.dtName}">
							</a>
						</figure>
						<div class="details text-center">
							<h4 class="box-title">
								<c:out value="${destinationHighlight.dtName}" />
							</h4>
							<p class="offers-content">${destinationHighlight.country.countryName}</p>
						</div>
					</article>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<section id="content">
	<div class="search-box-wrapper">
		<div class="search-box container">
			<ul class="search-tabs clearfix">
				<li class="active"><a href="#hotels-tab" data-toggle="tab">DESTINO
						PERFEITO</a></li>
				<li><a href="#flights-tab" data-toggle="tab">PASSAGENS
						Aereas</a></li>
				<li><a href="#flight-and-hotel-tab" data-toggle="tab">RESERVA
						DE HOTÉIS</a></li>
			</ul>

			<div class="search-tab-content">
			<h4 class="title">Utilize os filtros de experiências para encontrar o seu destino perfeito!</h4>
				<div class="tab-pane fade active in" id="hotels-tab">
					<form action="hotel-list-view.html" method="post">
						
						<div class="row container-fluid">
							<div class="col-md-1">
								<div class="selector">
									<select class="full-width">
										<option value="">-- Viajo com/ou férias em --</option>
										<option value="">Viagem com Acompanhante</option>
										<option value="">Viagem com Amigos</option>
										<option value="">Viajentes Solitários</option>
										<option value="">Familia com Crianças</option>
										<option value="">Familia sem Crianças</option>
										<option value="">Terceira Idade</option>
										<option value="">Jovens</option>
										
									</select>
								</div>
							</div>
							<div class="col-md-1">
								<div class="selector">
									<select class="full-width">
										<option value="">-- Procuro por --</option>
										<option value="">Viagem Económica</option>
										<option value="">Viagem Intermediária</option>
										<option value="">Viagem de Luxo</option>
									</select>
								</div>
							</div>
							<div class="col-md-1">
								<div class="selector">
									<select class="full-width">
										<option value="">-- Quero --</option>																				
										<option value="">Descanso e Relax</option>
										<option value="">Festas e Vida Noturna</option>
										<option value="">Gastronomia e Culinária</option>
										<option value="">Romance</option>
										<option value="">Compras</option>
										<option value="">Diversão e Aventura</option>
										<option value="">História, Arte e Cultura</option>
										<option value="">Ecoturismo e Esportes</option>
										<option value="">Parques Tematicos e Entretenimento</option>

									</select>
								</div>
							</div>
							<div class="col-md-1">
								<div class="selector">
									<select class="full-width">
										<option value="">-- Prefiro --</option>
										<option value="">Calor</option>
										<option value="">Frio</option>
										<option value="">Neve</option>
									</select>
								</div>
							</div>
							<div class="col-md-1">
								<div class="selector">
									<select class="full-width">
										<option value="">-- Adoro --</option>
										<option value="">Praia</option>
										<option value="">Campo</option>
										<option value="">Montanha</option>
										<option value="">Cidades e Grandes Centros Urbanos</option>
									</select>
								</div>
							</div>
							<div class="col-md-1">
								<div class="selector">
									<select class="full-width">
										<option value="">-- Tiro --</option>
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="col-md-2 pull-right">
								<label>&nbsp;</label>
								<button class="full-width icon-check">SERACH NOW</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Popuplar Destinations -->
	<div class="destinations section">
		<div class="container">
			<h2>Explore Mais Destinos</h2>
			<div class="row image-box style1 add-clearfix">					
			<c:forEach var="d" items="${destinationAppearInWebSiteList}">
				<div class="col-sms-6 col-sm-6 col-md-3">
					<article class="box">
						<figure class="animated" data-animation-type="fadeInDown" data-animation-duration="1">
							<a href="${pageContext.request.contextPath}/destinationDetail/${d.idDestination}">
								<img src="${pageContext.request.contextPath}/image/destination/${d.dtName}" width="270"height="160" />
							</a>
						</figure>
						<div class="details">
							<h4 class="box-title">
								<a href="hotel-detailed.html"><c:out value="${d.dtName}" /><small><c:out value="${d.country.countryName}" /></small></a>
							</h4>
						</div>
					</article>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	<div class="container section">
		<h2>Ultimas do Blog</h2>
		<div class="row image-box style4">
			<div class="col-sm-4">
				<article class="box animated" data-animation-type="fadeInLeft"
					data-animation-delay="0">
					<figure>
						<a title="" href="#" class="hover-effect"><img
							src="http://placehold.it/370x172" alt=""></a>
					</figure>
					<div class="details">
						<h4 class="box-title">Get Attractions</h4>
						<a class="goto-detail" href="#"><span
							class="glyphicon glyphicon-arrow-right"></span></a>
					</div>
				</article>
			</div>
			<div class="col-sm-4">
				<article class="box animated" data-animation-type="fadeInLeft"
					data-animation-delay="0.3">
					<figure>
						<a title="" href="#" class="hover-effect"><img width="370"
							height="172" alt="" src="http://placehold.it/370x172"></a>
					</figure>
					<div class="details">
						<h4 class="box-title">Travel Hot Deals</h4>
						<a class="goto-detail" href="#"><span
							class="glyphicon glyphicon-arrow-right"></span></a>
					</div>
				</article>
			</div>
			<div class="col-sm-4">
				<article class="box animated" data-animation-type="fadeInLeft"
					data-animation-delay="0.6">
					<figure>
						<a title="" href="#" class="hover-effect"><img width="370"
							height="172" alt="" src="http://placehold.it/370x172"></a>
					</figure>
					<div class="details">
						<h4 class="box-title">Travelers Stories</h4>
						<a class="goto-detail" href="#"><span
							class="glyphicon glyphicon-arrow-right"></span></a>
					</div>
				</article>
			</div>
		</div>
		<br>
	</div>
</section>