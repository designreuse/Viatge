<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- CONTENT -->
<!--TITLE -->
<div class="row">
	<div id="paper-top">
		<div class="col-sm-12">
			<!-- TITULO DA PÁGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Lista de Clientes</span>
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
	<li><a href="#" title="Sample page 1">Lista de Clientes</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text">
			<div class="title-alt">
				<h6>Clientes</h6>
			</div>

			<div class="col-sm-12">
				<p>Você possui  <c:out value="${customerCount}"></c:out> clientes ativos</p>
			</div>

			<form action="#" method="post" class="form-filtro">
				<div class="col-sm-4">
					<input class="form-control" id="filter" placeholder="Procurar"
						type="text" />
				</div>
			</form>

			<div class="col-sm-12">
				<c:choose>
					<c:when test="${!empty customerList}">
						<table id="footable-res2" class="demo margin-bottom"
								data-filter="#filter" data-filter-text-only="true">
							<thead>
								<tr>
									<th class="vertical-align-center">Nome</th>
									<th class="vertical-align-center">Sobrenome</th>
									<th class="vertical-align-center">E-mail</th>
									<th class="vertical-align-center">Data de Nascimento</th>
									<th class="vertical-align-center">Ativo website</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${customerList}" var="c">
									<tr>
										<td><a href="<c:url value="customer/view/${c.idCustomer}"/>">${c.firstName}</a></td>
										<td>${c.firstName}</td>
										<td>${c.lastName}</td>
										<td>${c.email}</td>
										<td><fmt:formatDate value="${c.birthDate}"/></td>
										<td><div class="make-switch" data-on="info"
												data-off="success">
												<input type="checkbox" checked>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info">
							<span class="entypo-info-circled"></span> <strong>Hummm!</strong>&nbsp;&nbsp;Parece
							que você ainda não possui nenhuma cliente cadastrado, adicione
							por meio do <b>"Novo Atendimento"</b>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

		</div>


	</div>
</div>