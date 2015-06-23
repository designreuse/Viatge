<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section id="orcamento">

	<div class="container">

		<h1>Contato</h1>
		<p>Fusce quis nibh tempor, posuere sapien et, venenatis tortor
			mauris feugiat tempor magna, a accumsan purus molestie sed.</p>
			
		<f:form action="${pageContext.request.contextPath}/budget/enviarOrcamento" 
				method="post"
				commandName="customerForm"
			    class="form-orcamento"
			    id="budgetForm">
			    <input type="hidden" id="customerId"  name="customerId" value="${customerForm.idCustomer}"/>
			    <input type="hidden" id="destinationId"  name="destinationId" value="${destinationForm.idDestination}"/>
			    <input type="hidden" id="customerServiceId"  name="customerServiceId" value="${cServiceIdForm}"/>
			    <input type="hidden" id="customerSite"  name="customerSite" value="${customerForm.site}"/>

			<h2>Dados de contato</h2>
			
			<div class="box-01">
				<label for="nome">*Primeiro Nome:</label> 
				<f:input path="firstName" cssClass="input01" id="nome"/>
			</div>

			<div class="box-02">
				<label for="sobrenome">*Sobrenome:</label> 
				<f:input path="lastName" cssClass="input01" id="sobrenome"/>			
			</div>

			<div class="box-01">
				<label for="email">*E-mail:</label> 
				<f:input path="email" cssClass="input01" id="email"/>
			</div>

			<div class="box-02">
				<label for="conf_email">*Confirme o E-mail:</label> <input
					type="email" class="input01" name="conf_email" id="conf_email">
			</div>

			<div class="box-01">
				<label for="telefone">*Telefone:</label> 
				<f:input path="customerPhone.homePhone" cssClass="input01" id="telefone" placeholder="Telefone: (00) 0000-0000"/>			
			</div>

			<div class="box-02">
				<label for="celular">Celular:</label> 
				<f:input path="customerPhone.celPhone" cssClass="input01" id="celular" placeholder="Celular: (00) 0000-0000"/>
			</div>

			<h2>Destino desejado</h2>

			<div class="box-100">
				<label for="destino">*Destino</label> 
				<input value="${destinationForm.dtName}" readonly="${not empty destinationForm.dtName}" class="input01" id="destino" name="destino"/>
			</div>

			<div class="box-01 data">
				<label for="ida">*Data de Ida:</label> <input type="text"
					class="input01" name="ida" id="ida">
			</div>

			<div class="box-02 data">
				<label for="volta">*Data de Volta:</label> 
				<input type="text"
					class="input01" name="volta" id="volta"/>
			</div>

			<h2>Quem irá com você?</h2>

			<!-- OS CAMPOS DE ACOMPANHATES SÃO ADICIONADOS VIA JAVASCRIPT. ARQUIVO "application.js" -->
			<div class="gerarAcompanhante box-100">
				<button class="btn addPessoa">Adicionar Acompanhante</button>
			</div>

			<h2>Informações Extras</h2>

			<div class="box-100">
				<label for="observacoes">Observações:</label>
				<textarea class="textarea01"
						  name="observacoes"
						  id="observacoes"
						  cols="5"
						  rows="5"></textarea>
			</div>

			<div>
				<button type="submit" class="submit01 bg-thema" >
					ENVIAR ORÇAMENTO 
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
		  
		   $('#budgetForm').submit( function(e){
			   var ida =  $('#ida').val();
			   var volta =  $('#volta').val();

			   $.ajax({
					type:'POST',
					data: {
						ida: ida,
						volta: volta,
					}
			   });
		   });

		   function SomenteNumero(e){
			    var tecla=(window.event)?event.keyCode:e.which;   
			    if((tecla>47 && tecla<58)) return true;
			    else{
			    	if (tecla==8 || tecla==0) return true;
				else  return false;
			    }
			}
		</script>
	</div>

</section>