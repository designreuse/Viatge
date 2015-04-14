<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section>

	<!-- FILTRO -->
	<article class="filtro">
		<h1 class="bg-thema">ENCONTRAR DESTINO PERFEITO.</h1>

		<form action="#" method="post" name="form-filtro" class="form-filtro">
			<div class="box-select">
				<label>VIAJO COM (SOU)</label> <select class="select01" name="viajo">
					<option value="">Selecionar...</option>
					<option value="Opção 01">Opção 01</option>
					<option value="Opção 02">Opção 02</option>
					<option value="Opção 03">Opção 03</option>
					<option value="Opção 04">Opção 04</option>
				</select>
			</div>

			<div class="box-select">
				<label>PROCURO POR</label> <select class="select01" name="procuro">
					<option value="">Selecionar...</option>
					<option value="Opção 01">Opção 01</option>
					<option value="Opção 02">Opção 02</option>
					<option value="Opção 03">Opção 03</option>
					<option value="Opção 04">Opção 04</option>
				</select>
			</div>

			<div class="box-select">
				<label>QUERO</label> <select class="select01" name="quero">
					<option value="">Selecionar...</option>
					<option value="Opção 01">Opção 01</option>
					<option value="Opção 02">Opção 02</option>
					<option value="Opção 03">Opção 03</option>
					<option value="Opção 04">Opção 04</option>
				</select>
			</div>

			<div class="box-select">
				<label>PREFIRO</label> <select class="select01" name="prefiro">
					<option value="">Selecionar...</option>
					<option value="Opção 01">Opção 01</option>
					<option value="Opção 02">Opção 02</option>
					<option value="Opção 03">Opção 03</option>
					<option value="Opção 04">Opção 04</option>
				</select>
			</div>

			<div class="box-select">
				<label>ADORO</label> <select class="select01" name="adoro">
					<option value="">Selecionar...</option>
					<option value="Opção 01">Opção 01</option>
					<option value="Opção 02">Opção 02</option>
					<option value="Opção 03">Opção 03</option>
					<option value="Opção 04">Opção 04</option>
				</select>
			</div>

			<div class="box-botton">
				<button type="submit" class="button01 bg-thema">
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
								<a href="destino.php"><c:out
										value="${destinationHighlight.dtName}" /></a>
							</h2>
							<p class="pais">
								<a href="destino.php">${destinationHighlight.country.countryName}</a>
							</p>

							<ul>
								<!-- TOOLTIP = TITLE DE LINK -->
								<li><a href="#" class="viajo" title="viajo"></a></li>
								<li><a href="#" class="procuro" title="procuro"></a></li>
								<li><a href="#" class="quero" title="quero"></a></li>
								<li><a href="#" class="prefiro" title="prefiro"></a></li>
								<li><a href="#" class="adoro" title="adoro"></a></li>
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
								src="${pageContext.request.contextPath}/image/destination/${d.dtName}"
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
								<li><a href="#" class="viajo" title="${d.generalProfiles}"></a></li>
								<!-- TOOLTIP = TITLE DE LINK -->
								<li><a href="#" class="procuro" title="procuro"></a></li>
								<li><a href="#" class="quero" title="quero"></a></li>
								<li><a href="#" class="prefiro" title="prefiro"></a></li>
								<li><a href="#" class="adoro" title="adoro"></a></li>
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