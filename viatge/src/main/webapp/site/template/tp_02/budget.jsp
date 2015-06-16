<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="orcamento">

	<div class="container">

		<h1>Contato</h1>
		<p>Fusce quis nibh tempor, posuere sapien et, venenatis tortor
			mauris feugiat tempor magna, a accumsan purus molestie sed.</p>

		<f:form action="orcamento.php?alert=orcamento" method="post"
			name="form-contato" class="form-orcamento">

			<h2>Dados de contato</h2>

			<div class="box-01">
				<label for="nome">*Primeiro Nome:</label> <input type="text"
					class="input01" name="nome" id="nome" value="${customerForm.firstName}">
			</div>

			<div class="box-02">
				<label for="sobrenome">*Sobrenome:</label> <input type="text"
					class="input01" name="sobrenome" id="sobrenome" value="${customerForm.lastName}">
			</div>

			<div class="box-01">
				<label for="email">*E-mail:</label> <input type="email"
					class="input01" name="email" id="email" value="${customerForm.email}">
			</div>

			<div class="box-02">
				<label for="conf_email">*Confirme o E-mail:</label> <input
					type="email" class="input01" name="conf_email" id="conf_email">
			</div>

			<div class="box-01">
				<label for="telefone">*Telefone:</label> <input type="tel"
					class="input01" name="telefone" id="telefone"
					placeholder="Telefone: (00) 0000-0000" value="${contactForm.customerPhone.homePhone}">
			</div>

			<div class="box-02">
				<label for="celular">Celular:</label> <input type="tel"
					class="input01" name="celular" id="celular"
					placeholder="Celular: (00) 0000-0000" value="${contactForm.customerPhone.celPhone}">
			</div>

			<h2>Destino desejado</h2>

			<div class="box-100">
				<label for="destino">*Destino</label> <input type="text"
					class="input01" name="destino" id="destino">
			</div>

			<div class="box-01 data">
				<label for="ida">*Data de Ida:</label> <input type="text"
					class="input01" name="ida" id="ida">
			</div>

			<div class="box-02 data">
				<label for="volta">*Data de Volta:</label> <input type="text"
					class="input01" name="volta" id="volta">
			</div>

			<h2>Quem irá com você?</h2>

			<!-- OS CAMPOS DE ACOMPANHATES SÃO ADICIONADOS VIA JAVASCRIPT. ARQUIVO "application.js" -->
			<div class="gerarAcompanhante box-100">
				<button class="btn addPessoa">Adicionar Acompanhante</button>
			</div>

			<h2>Informações Extras</h2>

			<div class="box-100">
				<label for="observacoes">Observações:</label>
				<textarea class="textarea01" name="observacoes" id="observacoes"
					cols="5" rows="5"></textarea>
			</div>

			<div>
				<button type="submit" name="enviar" class="submit01 bg-thema">
					<i></i> ENVIAR ORÇAMENTO
				</button>
			</div>

		</f:form>

		<!-- AUTO COMPLATE DE DESTINO -->
		<script>
		  $(function() {
			var availableTags = [
			  "Acre (AC)",
			  "Alagoas (AL)",
			  "Amapá (AP)",
			  "Amazonas (AM)",
			  "Bahia (BA)",
			  "Ceará (CE)",
			  "Distrito Federal (DF)",
			  "Espírito Santo (ES)",
			  "Goiás (GO)",
			  "Maranhão (MA)",
			  "Mato Grosso (MT)",
			  "Mato Grosso do Sul (MS)",
			  "Minas Gerais (MG)",
			  "Pará (PA)",
			  "Paraíba (PB)",
			  "Paraná (PR)",
			  "Pernambuco (PE)",
			  "Piauí (PI)",
			  "Rio de Janeiro (RJ)",
			  "Rio Grande do Norte (RN)",
			  "Rio Grande do Sul (RS)",
			  "Rondônia (RO)",
			  "Roraima (RR)",
			  "Santa Catarina (SC)",
			  "São Paulo (SP)",
			  "Sergipe (SE)",
			  "Tocantins (TO)"
			];
			$( "#destino" ).autocomplete({
			  source: availableTags
			});
		  });
		</script>
	</div>

</section>