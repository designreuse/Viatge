<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


		<!-- CONTENT -->
		<!--TITLE -->
		<div class="row">
			<div id="paper-top">
				<div class="col-sm-12">
					<!-- TITULO DA PÁGINA -->
					<h2 class="tittle-content-header">
						<i class="icon-menu"></i> <span>Gestão de Destinos</span>
					</h2>
				</div>
			</div>
		</div>
		<!--/ TITLE -->

		<!-- BREADCRUMB -->
		<ul id="breadcrumb">
			<li><span class="entypo-home"></span></li>
			<li><i class="fa fa-lg fa-angle-right"></i></li>
			<li><a href="${pageContext.request.contextPath}/auth/home"
				title="Página Inicial">Página Inicial</a></li>
			<li><i class="fa fa-lg fa-angle-right"></i></li>
			<li><a href="${pageContext.request.contextPath}/auth/category"
				title="Listagem de Categorias">Gestão de Destinos</a></li>
		</ul>
		<!-- FIM BREADCRUMB -->


		<div class="content-wrap margin-bottom">
			<div class="row">


				<div class="nest text">
					<div class="nest" id="FilteringClose">
						<div class="title-alt">
							<h6>Gerenciar Destinos</h6>
						</div>

				<div class="body-nest" id="Filtering">
					<c:if test="${message != null}">
						<div class="alert alert-success">
							<span class="entypo-thumbs-up"></span> <strong>Legal!</strong>&nbsp;&nbsp;${message}
						</div>
					</c:if>
					<c:if test="${errorMessage != null}">
						<div class="alert alert-danger">
							<span class="entypo-attention"></span> <strong>Ops...!</strong>&nbsp;&nbsp;${errorMessage}
						</div>
					</c:if>
					<div class="row" style="margin-bottom: 10px;">
						<div class="col-sm-4">
							<input class="form-control" id="filter" placeholder="Procurar"
								type="text" />
						</div>

						<div class="col-sm-2">
								<f:select path="category" cssClass="filter-status form-control">
									<f:option value="-1" label="Todas..." />
									<f:options items="${categoryList}" itemValue="idCategory" itemLabel="ctName"/>
								</f:select>
						</div>

						<div class="col-sm-6">
							<a href="#clear" style="margin-left: 10px;"
								class="pull-right btn btn-info clear-filter"
								title="clear filter">Limpar Pesquisa</a> <a
								href="<c:url value="newDestination"/>"
								class="pull-right btn btn-info"
								title="Adicionar um Novo Destino">Novo Destino</a>
						</div>
					</div>
				</div>
			</div>

					<div class="col-sm-12">
						<c:choose>
							<c:when test="${!empty destination}">
								<table id="footable-res2"
									class="table-striped footable-res footable metro-blue demo"
									data-filter="#filter" data-filter-text-only="true"
									data-page-size="15">
									<thead>
										<tr>
											<th>Destinos</th>
											<th>País</th>
											<th>Categoria</th>
											<th>Ativo (WebSite)</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${destination}" var="d">
											<tr>
												<td>
												<a href="editDestination?id=${d.idDestination}">${d.dtName}</a>

												<td>${d.country.countryName}</td>
												<td>${d.categories.ctName}</td>
												<td>
													<div class="make-switch" data-on="primary" data-off="info">
														<c:choose>
															<c:when test="${d.dtAppearWebsite}">
																<input type="checkbox" checked>
															</c:when>
															<c:otherwise>
																<input type="checkbox">
															</c:otherwise>
														</c:choose>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<td colspan="5">
												<div class="pagination pagination-centered"></div>
											</td>
										</tr>
									</tfoot>
								</table>
							</c:when>
							<c:otherwise>
								<div class="alert alert-info">
									<span class="entypo-info-circled"></span> <strong>Hummm!</strong>&nbsp;&nbsp;Parece
									que você ainda não possui nenhum destino cadastrado, clique no
									botão <b>"Novo Destino"</b>
								</div>
							</c:otherwise>
						</c:choose>

					</div>

				</div>

			</div>
		</div>

		<script>
			$(document).ready(function() {
				// usando id para identificar o checkbox
				$('#ckDestination').click(function() {
					var action = $(this).is(':checked') ? true : false;

					// uma vez determinada a action, é só usar o get do jQuery
					$.get(action, function(data) {
						// faz alguma coisa com o retorno, manda msg de sucesso, algo assim
						}).fail(function(error) {
						// se der problema cai aqui. Você pode exibir o erro e desfazer a checagem do checkbox
						});
				});
			});
		</script>