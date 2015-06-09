<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="gravatar" uri="http://www.paalgyula.hu/schemas/tld/gravatar" %>


<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Dados do Cliente</span>
			</h2>
		</div>
	</div>
</div>
<!--/ TITLE -->

<!-- BREADCRUMB -->
<ul id="breadcrumb">
	<li><span class="entypo-home"></span></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Sample page 1">Página Inicial</a></li>
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Sample page 1">Visualizar Cadastro de Cliente</a></li>
</ul>
<!-- FIM BREADCRUMB -->

<div class="content-wrap margin-bottom width-fixid-fluida">
	<div class="row-cols novo-atendimento">

		<div class="col-sm-12 margin-bottom acoes-cliente">
			<a href="<c:url value="/auth/customer/edit/${customer.idCustomer}"/>" class="btn btn-info">Editar</a>&nbsp; &nbsp;
			<a href="<c:url value="/auth/service"/>" class="btn btn-info">Novo Atendimento</a>&nbsp; &nbsp;
			<a href="<c:url value="/auth/customer/history/${customer.idCustomer}"/>" class="btn btn-info">Histórico de Vendas</a>
		</div>
		
		<div class="col-sm-6">
			<!-- Dados Gerais -->
			<div class="nest text margin-bottom">
				<div class="title-alt">
					<h6>
						<a href="#" rel="dados-gerais" class="toggle-box">Dados Gerais</a>
					</h6>
					<a href="#" rel="dados-gerais" class="icon-chevron-down toggle-box"></a>
					
				</div>

				<div class="box-anotacoes">
					<figure>
							<img src="<gravatar:image email="${customer.email}" size="80"/>" alt="${customer.firstName}" title="${customer.firstName}" style="margin-left: 6px;"/>
					</figure>

					<p>					
						<span class="fontawesome-user"></span> <strong>&nbsp;${customer.firstName}&nbsp;${customer.lastName}</strong>
						
					</p>
					<p>
						<span class="fontawesome-star"></span> Nascimento: <fmt:formatDate value="${customer.birthDate}"/>
					</p>
					<p>
						<c:choose>
                        	<c:when test="${customer.gender eq 'M'}">
								<span class="maki-toilet"></span> Sexo: Masculino
							</c:when>
							<c:when test="${customer.gender eq 'F'}">
								<span class="maki-toilet"></span> Sexo: Feminino
							</c:when>
						</c:choose>
					</p>
					<p>
						<span class="entypo-phone"></span> Residencial: ${customer.customerPhone.homePhone}
					</p>
					<p>
						<span class="entypo-mobile"></span> Celular: ${customer.customerPhone.celPhone}
					</p>
					<p>
						<span class="fontawesome-briefcase"></span> Comercial: ${customer.customerPhone.workPhone}
					</p>
					<p>
						<span class="fontawesome-envelope-alt"></span> <a
							href="mailto:${customer.email}">${customer.email}</a>
					</p>
				</div>

			</div>

			<!-- Dados Complementares -->
			<div class="nest text margin-bottom">
				<div class="title-alt">
					<h6>
						<a href="#" rel="dados-complementares" class="toggle-box">Dados
							Complementares</a>
					</h6>
					<a href="#" rel="dados-complementares"
						class="icon-chevron-down toggle-box"></a>
				</div>

				<div class="body-nest" id="dados-complementares">
					<p>CPF: ${customer.document.cpf}</p>
					<p>RG: ${customer.document.rg}</p>
					<p>País: Brasil</p>
					<p>UF: ${customer.customerAddress.state}</p>
					<p>Cidade: ${customer.customerAddress.city}</p>
					<p>Bairro: ${customer.customerAddress.quarter}</p>
					<p>Rua: ${customer.customerAddress.street}, Nº ${customer.customerAddress.number}</p>
					<p>Complemento: ${customer.customerAddress.complement}</p>
					<p>CEP: ${customer.customerAddress.cep}</p>
				</div>

			</div>

			<!-- Passageiros Relacionados -->
			<div class="nest text margin-bottom">
				<div class="title-alt">
					<h6>
						<a href="#" rel="passageiros-relacionados" class="toggle-box">Passageiros
							Relacionados</a>
					</h6>
					<a href="#" rel="passageiros-relacionados"
						class="icon-chevron-down toggle-box"></a>
				</div>

				<div class="body-nest" id="passageiros-relacionados">

					<script type="text/javascript">
                            	$(document).ready(function(){
									$('.accordion h5').click(function(){
										$(this).next().slideToggle("slow");
										$(this).toggleClass('ativo');
									});
								});
							</script>
					<div class="accordion">
						<c:choose>
							<c:when test="${empty customer.passenger}">
								<p>Nenhum acompanhate cadastrado para esse cliente.</p>
							</c:when>
							<c:otherwise>
								<c:forEach items="${customer.passenger}" var="p">
									<h5>
										<span class="fontawesome-plus"></span><span
											class="fontawesome-minus"></span> ${p.firstName} - ${p.familyBond.bond}								
									</h5>
									<div>
										<p class="box01 fontawesome-star"><fmt:formatDate value="${p.birthDate}"/></p>
										<p class="box02 entypo-phone"> ${p.mainTel}</p>

										<p class="box01 entypo-vcard">CPF: ${p.documentPassenger.cpf}</p>
										<p class="box02 entypo-vcard">RG: ${p.documentPassenger.rg}</p>

										<p class="box03 fontawesome-envelope"> ${p.email}</p>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

			</div>

		</div>

		<div class="col-sm-6">
			<!-- Perfil -->
			<div class="nest text margin-bottom">
				<div class="title-alt">
					<h6>
						<a href="#" rel="perfil" class="toggle-box">Perfil</a>
					</h6>
					<a href="#" rel="perfil" class="icon-chevron-down toggle-box"></a>
				</div>

				<div class="col-sm-12 perfil">
					<p>
						<span class="entypo-users"></span> Família sem Criança
					</p>
					<p>
						<span class="fontawesome-plane"></span> Viagem de Luxo
					</p>
					<p>
						<span class="maki-town-hall"></span> História, Arte e Cultura
					</p>
					<p>
						<span class="wi-day-sunny"></span> Calor
					</p>
					<p>
						<span class="entypo-location"></span> Cidades e Grandes Centros
						Urbanos
					</p>
					<p>
						<span class="entypo-globe"></span> Internacional
					</p>
				</div>

			</div>

			<!-- Observações e Anotações -->
			<div class="nest text margin-bottom">
				<div class="title-alt">
					<h6>
						<a href="#" rel="dados-obs" class="toggle-box">Observações e
							Anotações</a>
					</h6>
					<a href="#" rel="dados-obs" class="icon-chevron-down toggle-box"></a>
				</div>

				<div class="body-nest" id="dados-obs">
					<div >
						<c:choose>
							<c:when test="${empty customer.observations}">
								<p>O Cliente não possui nenhuma observação.</p>
							</c:when>
							<c:otherwise>
								<p>
									<c:out value="${customer.observations}"></c:out>
								</p>
							</c:otherwise>
						</c:choose>
						
					</div>
				</div>

			</div>

		</div>

	</div>
</div>
