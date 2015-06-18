<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section>

	<!-- FILTRO -->
	<article class="filtro">
		<h1 class="bg-thema">ENCONTRAR DESTINO PERFEITO.</h1>
		<form id="form-filter-perfect-travel" action="/viatge/perfect-travel-filter" method="get" class="form-filtro">
			<div class="box-select">
				<label>VIAJO COM (SOU)</label> <select id="social-select"
					class="select01" name="social">
					<option value="">Selecionar...</option>
					<option value="accompanying">Acompanhante</option>
					<option value="alone">Sozinho</option>
					<option value="children">Crianças</option>
					<option value="friends">Amigos</option>
					<option value="elderly">Idosos</option>
					<option value="familyChildren">Sem Crianças</option>
					<option value="teenager">Jovem</option>
				</select>
			</div>

			<div class="box-select">
				<label>PROCURO POR</label> <select id="economic-select"
					class="select01" name="economic">
					<option value="">Selecionar...</option>
					<option value="economic">Viagem Económica</option>
					<option value="intermediate">Viagem Intermediária</option>
					<option value="luxury">Viagem de Luxo</option>
				</select>
			</div>

			<div class="box-select">
				<label>QUERO</label> <select id="trip-select" class="select01"
					name="trip">
					<option value="">Selecionar...</option>
					<option value="chill">Descanso e Relax</option>
					<option value="romance">Romance</option>
					<option value="history">História, Arte e Cultura</option>
					<option value="fun">Festas e Vida Noturna</option>
					<option value="shopping">Compras</option>
					<option value="sports">Ecoturismo e Esportes</option>
					<option value="gastronomy">Gastronomia e Culinária</option>
					<option value="party">Diversão e Aventura</option>
					<option value="entertainment">Parques Tematicos e
						Entretenimento</option>
				</select>
			</div>

			<div class="box-select">
				<label>PREFIRO</label> <select id="weather-select" class="select01"
					name="weather">
					<option value="">Selecionar...</option>
					<option value="cold">Calor</option>
					<option value="heat">Frio</option>
					<option value="winter">Frio e Neve</option>
				</select>
			</div>

			<div class="box-select">
				<label>ADORO</label> <select id="general-select" class="select01"
					name="general">
					<option value="">Selecionar...</option>
					<option value="beach">Praia</option>
					<option value="city">Cidades e Grandes Centros Urbanos</option>
					<option value="cottage">Campo</option>
					<option value="mountain">Montanha</option>
				</select>
			</div>

			<div class="box-botton">
				<button id="show-modal" type="button" class="button01 bg-thema">
					<i></i> REALIZAR BUSCA
				</button>
			</div>
		</form>
	</article>

	<!-- FIM DE FILTRO -->

	<article class="destaques">

		<div class="container">

			<h1>DESTAQUES</h1>

			<!-- DESTAQUES -->
			<div class="list-destaques">
				<c:forEach var="destinationHighlight"
					items="${destinationHightlightList}">
					<div class="item">
						<figure>
							<a
								href="${pageContext.request.contextPath}/destinationDetail/${destinationHighlight.idDestination}"><img
								src="${pageContext.request.contextPath}/image/destination/${destinationHighlight.dtName}"
								alt="nome do pacote"></a>
						</figure>
						<!-- IMAGEM 500PX POR 250PX -->
						<div class="info">

							<h2>
								<a
									href="${pageContext.request.contextPath}/destinationDetail/${destinationHighlight.idDestination}"><c:out
										value="${destinationHighlight.dtName}" /></a>
							</h2>
							<p class="pais">
								<a
									href="${pageContext.request.contextPath}/destinationDetail/${destinationHighlight.idDestination}">${destinationHighlight.country.countryName}</a>
							</p>

							<ul>
								<!-- TOOLTIP = TITLE DE LINK -->
								<li><a href="#" class="viajo" title="${destinationHighlight.socialProfiles}"></a></li>
								<!-- TOOLTIP = TITLE DE LINK -->
								<li><a href="#" class="procuro" title="${destinationHighlight.economicProfiles}"></a></li>
								<li><a href="#" class="quero" title="${destinationHighlight.tripProfiles}"></a></li>
								<li><a href="#" class="prefiro" title="${destinationHighlight.weatherprofile}"></a></li>
								<li><a href="#" class="adoro" title="${destinationHighlight.generalProfiles}"></a></li>
							</ul>
							<a
								href="${pageContext.request.contextPath}/destinationDetail/${destinationHighlight.idDestination}"
								class="btn hover-txt-thema">MAIS DETALHES</a>

						</div>
					</div>
				</c:forEach>

			</div>

			<!-- FIM DE DESTAQUES -->

		</div>

	</article>

	<article class="pacotes">

		<div class="container">

			<h1>PACOTES</h1>

			<!-- INICIO DE GRID -->
			<div class="grid">
				<c:forEach var="d" items="${destinationAppearInWebSiteList}">
					<div class="item">
						<figure>
							<a
								href="${pageContext.request.contextPath}/destinationDetail/${d.idDestination}"><img
								src="${pageContext.request.contextPath}/image/destination/thumbnail/${d.dtName}"
								alt="${d.dtName}"></a>
						</figure>
						<!-- IMAGEM 252PX POR 190PX -->
						<div class="info">

							<h2>
								<a
									href="${pageContext.request.contextPath}/destinationDetail/${d.idDestination}"><c:out
										value="${d.dtName}" /></a>
							</h2>
							<p class="pais">
								<a
									href="${pageContext.request.contextPath}/destinationDetail/${d.idDestination}"><c:out
										value="${d.country.countryName}" /></a>
							</p>

							<ul>
								<li><a href="#" class="viajo" title="${d.socialProfiles}"></a></li>
								<li><a href="#" class="procuro" title="${d.economicProfiles}"></a></li>
								<li><a href="#" class="quero" title="${d.tripProfiles}"></a></li>
								<li><a href="#" class="prefiro" title="${d.weatherprofile}"></a></li>
								<li><a href="#" class="adoro" title="${d.generalProfiles}"></a></li>
							</ul>
							<a
								href="${pageContext.request.contextPath}/destinationDetail/${d.idDestination}"
								class="btn hover-txt-thema">MAIS DETALHES</a>

						</div>
					</div>
				</c:forEach>
			</div>
			<!-- FIM DE GRID -->

		</div>

	</article>
	<!-- FIM DE PACOTES -->

</section>
<!-- Modal -->
<div id="dialog-form" title="Cadastar-se no site">
	<p class="validateTips txt-thema">Legal, encontramos os destinos que são
		perfeitos para você!</p>
	<p class="txt-thema">Por gentileza informe seu nome e e-mail...</p>

	<form>
		<div>
				<input type="text" name="name"
				id="name" placeholder="Primeiro Nome..."
				style="display: block; margin: 0; width: 100%; font-family: sans-serif; font-size: 14px; appearance: none; box-shadow: none; border-radius: none;">
		</div>
		<br />
		<div>
				<input type="text" name="email"
				id="email" placeholder="E-mail..."
				style="display: block; margin: 0; width: 100%; font-family: sans-serif; font-size: 14px; appearance: none; box-shadow: none; border-radius: none;">
		</div>

		<!-- Allow form submission with keyboard without duplicating the dialog button -->
		<input type="submit" tabindex="-1"
			style="position: absolute; top: -1000px">

	</form>
</div>