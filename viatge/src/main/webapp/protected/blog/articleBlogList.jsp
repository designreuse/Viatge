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
				<i class="icon-menu"></i> <span>Artigos (Blog)</span>
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
	<li><a
		href="${pageContext.request.contextPath}/auth/article-blog-list"
		title="Listagem de Artigos">Artigos</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">


		<div class="nest text">
			<div class="title-alt">
				<h6>Lista de Artigos</h6>
			</div>

			<div class="body-nest" id="Filtering">
				<c:if test="${message != null}">
					<div class="alert alert-success">
						<span class="entypo-thumbs-up"></span> <strong>Beleza!</strong>&nbsp;&nbsp;${message}
					</div>
				</c:if>
				<c:if test="${errorMessage != null}">
					<div class="alert alert-danger">
						<span class="entypo-attention"></span> <strong>Ops...!</strong>&nbsp;&nbsp;${errorMessage}
					</div>
				</c:if>

				<div class="row" style="margin-bottom: 10px;">
					<div class="col-sm-4">
						<input class="form-control" id="filterArticleBlog" placeholder="Procurar"
							type="text" />
					</div>

					<div class="col-sm-2">
						<f:select path="categoryBlog"
							cssClass="filter-status form-control">
							<f:option value="-1" label="Todas..." />
							<f:options items="${categoryBlogList}" itemValue="idCategoryBlog" itemLabel="ctBgName" />
						</f:select>
					</div>

					<div class="col-sm-6">
						<a href="#clear" style="margin-left: 10px;"
							class="pull-right btn btn-info clear-filter" title="clear filter">Limpar
							Pesquisa</a> <a href="<c:url value="new-article-blog"/>"
							class="pull-right btn btn-info" title="Adicionar Novo Artigo">Novo
							Artigo </a>
					</div>
				</div>
			</div>

			<div class="col-sm-12">
				<c:choose>
					<c:when test="${!empty articlesBlogList}">
						<table id="footable-res2"
						class="table-striped footable-res footable metro-blue"
						data-filter="#filterArticleBlog"
						data-filter-text-only="true"
						data-page-size="15">
							<thead>
								<tr>
									<th><b>Artigo</b></th>
									<th><b>Categoria</b></th>
									<th><b>Postagem</b></th>
									<th><b>Ativo (Website)</b></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${articlesBlogList}" var="a">
									<tr>
										<td><a href="visualize-article-blog/${a.idArticle}">${a.atName}</a></td>
										<td>${a.categoryBlog.ctBgName}</td>
										<td>
											<fmt:formatDate value="${a.postingDate}" pattern="dd/MM/yyyy"/>
										</td>																			

										
										<td>
											<div class="make-switch" data-on="primary" data-off="info">
												<c:choose>
													<c:when test="${a.atActive == 1}">
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
							<button data-dismiss="alert" class="close" type="button">×</button>
							<span class="entypo-info-circled"></span> <strong>Hummm!</strong>&nbsp;&nbsp;Parece
							que você ainda não possui nenhum artigo cadastrado, clique no
							botão <b>"Novo Artigo"</b>
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
				$('#ckArticleBlog').click(function() {
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