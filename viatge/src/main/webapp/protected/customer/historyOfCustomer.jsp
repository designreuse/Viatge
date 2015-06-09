<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Histórico de Negociações</span>
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
	<li><a href="#" title="Sample page 1">Histórico de Negociações</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text width-fixid-fluida">
			<div class="title-alt">
				<h6>Histórico</h6>
			</div>

			<div class="col-sm-12">

				<table class="table table-bordered table-striped cf hn">
					<thead>
						<tr>
							<th class="vertical-align-center">Destino</th>
							<th class="vertical-align-center">Valor</th>
							<th>Data da Compra</th>
							<th>Data de Ida</th>
							<th>Data de Volta</th>
						</tr>
					</thead>
					<tbody>
						<!-- CONTEUDO DE TABLE -->
						<c:forEach items="${serviceItem}" var="si">
							<tr>
								<td><span class="footable-toggle"></span>${si.destination.dtName}</td>
								<td><fmt:setLocale value="pt_BR" /> <fmt:formatNumber
										value="${si.valueNegotiated}" type="currency" /></td>
								<td>
								</td>
								<td><fmt:formatDate value="${si.arrivalDate}" /></td>
								<td><fmt:formatDate value="${si.departureDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<p class="size17">Viagens Realizadas: ${serviceItemSize}</p>
				<fmt:setLocale value="pt_BR" />
				<p class="size17">Valor Total: <fmt:formatNumber value="${amount}" type="currency" /></p>
			</div>

		</div>


	</div>
</div>
