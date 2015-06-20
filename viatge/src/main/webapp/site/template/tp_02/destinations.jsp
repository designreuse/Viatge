<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="destinos">

	<div class="container">
		<h1>Destinos Que Mais Combinam com você</h1>


		<div class="pacotes">
			<c:if test="${perfectDestinationError}">
				<div style="font-size: 20px" class="txt-destino-perfeito txt-thema">
					<p>Ops, você precisa preencher todos os filtros de viagem para
						nós acharmos o destino que mais combina com você :)</p>
				</div>
			</c:if>
			<div class="grid">


				<c:forEach var="destination" items="${perfectDestinations}">
					<div class="item">
						<figure>
							<a
								href="${pageContext.request.contextPath}/destinationDetail/${destination.idDestination}">
								<!-- IMAGEM 252PX POR 190PX --> <img
								src="${pageContext.request.contextPath}/image/destination/thumbnail/${destination.dtName}"
								alt="nome do pacote">
							</a>
						</figure>
						<div class="info">

							<h2>
								<a href="#"><c:out value="${destination.dtName}" /></a>
							</h2>

							<p class="pais">
								<a href="#"> <c:out
										value="${destination.country.countryName}" />
								</a>
							</p>

							<ul>
								<li><a href="#" class="viajo" title="${destination.socialProfiles}"></a></li>
								<li><a href="#" class="procuro" title="${destination.economicProfiles}"></a></li>
								<li><a href="#" class="quero" title="${destination.tripProfiles}"></a></li>
								<li><a href="#" class="prefiro" title="${destination.weatherprofile}"></a></li>
								<li><a href="#" class="adoro" title="${destination.generalProfiles}"></a></li>
							</ul>
							<a
								href="${pageContext.request.contextPath}/destinationDetail/${destination.idDestination}"
								class="btn">MAIS DETALHES</a>

						</div>
					</div>
				</c:forEach>
			</div>
			<!-- FIM DE GRID -->

		</div>

		<h3>Ainda não achou o seu destino perfeito? Podemos ajudar com
			isso?</h3>
		<p>
			<a href="${pageContext.request.contextPath}/perfect-travel"
				class="btn bg-thema">DESTINO PERFEITO</a>
		</p>


	</div>

</section>