<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="filtro">

	<div class="container">

		<h1>Viagem Perfeita</h1>

		<div class="passo-filtro txt-thema">

			<h2>Como utilizar o destino perfeito</h2>

			<ul>
				<li><span class="border-thema">1</span>
					<p>Selecione abaixo as opções que mais combinam com você!</p></li>
				<li><span class="border-thema">2</span>
					<p>Aperte o botão ok! Buscaremos os destinos perfeitos para sua
						férias!</p></li>
				<li><span class="border-thema">3</span>
					<p>Navegue pelos destinos sugeridos, escolha o que mais gostar
						e entre em contato conosco!</p></li>
			</ul>

		</div>

		<div class="filtro">
			<h2 class="bg-thema">ENCONTRAR DESTINO PERFEITO.</h2>

			<!-- FILTRO DE DESTINO -->

		<form id="form-filter-perfect-travel" action="${pageContext.request.contextPath}/perfect-travel-filter" method="get" class="form-filtro">
			<div class="box-select">
				<label>VIAJO COM (SOU)</label> <select id="social-select"
					class="select01" name="social">
					<option value="">Selecionar...</option>
					<option value="accompanying">Acompanhante</option>
					<option value="alone">Sozinho</option>
					<option value="children">Crianças</option>
					<option value="friends">Amigos</option>
					<option value="elderly">Terceira Idade</option>
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
					<option value="cold">Frio</option>
					<option value="heat">Calor</option>
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
				<button id="show-modal-perfect" type="button" class="button01 bg-thema">
					<i></i> REALIZAR BUSCA
				</button>
			</div>
		</form>

			<!-- FIM FILTRO DE DESTINO -->

		</div>

		<div class="txt-destino-perfeito txt-thema">
			<p>A <c:out value="${agencyName}"></c:out> é diferente porque é personalizada...</p>
			<p>Existe uma viagem PERFEITA para cada pessoa!</p>
			<p>Qual será a sua?</p>
		</div>

	</div>

</section>

<div id="dialog-form" title="Cadastar-se no site">
	<p class="validateTips txt-thema">Legal, encontramos os destinos que são perfeitos para você!</p>
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