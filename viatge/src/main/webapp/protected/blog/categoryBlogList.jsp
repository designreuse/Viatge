<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- CONTENT -->
<!--TITLE -->
<div class="row">
    <div id="paper-top">
        <div class="col-sm-12">
            <!-- TITULO DA PÁGINA -->
            <h2 class="tittle-content-header">
                <i class="icon-menu"></i> <span>Categorias (Blog)</span>
            </h2>
        </div>
    </div>
</div>
<!--/ TITLE -->

<!-- BREADCRUMB -->
<ul id="breadcrumb">
    <li><span class="entypo-home"></span></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="${pageContext.request.contextPath}/auth/home" title="Página Inicial">Página Inicial</a></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="${pageContext.request.contextPath}/auth/category-blog-list" title="Listagem de Categorias">Categorias</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
    <div class="row">


        <div class="nest text">
            <div class="title-alt">
                <h6>Lista de Categorias</h6>
            </div>

			<div class="row" style="margin-bottom: 10px;">
				<div class="col-sm-12">
					<c:if test="${message != null}">
						<div class="alert alert-success">
							<span class="entypo-thumbs-up"></span> <strong>Beleza!</strong>&nbsp;&nbsp;${message}
						</div>
					</c:if>
					<a href="<c:url value="new-category-blog"/>"
						class="pull-left btn btn-info" title="Adicionar Nova Categoria">Nova
						Categoria</a>
				</div>
			</div>

			<div class="col-sm-12">

                <c:choose>
                    <c:when test="${!empty categoriesBlogList}">
                        <table class="table-striped footable-res footable metro-blue"
                               data-page-size="10">
                            <thead>
                                <tr>
                                    <th><b>Nome</b></th>
                                    <th><b>Artigos Vinculados</b></th>
                                    <th><b>Ativo (Website)</b></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${categoriesBlogList}" var="c">
                                    <tr>
                                        <td><a href="edit-category-blog?id=${c.idCategoryBlog}">${c.ctBgName}</a></td>
                                        <td>${c.articlesLinked}</td>
                                        <td>
											<div class="make-switch" data-on="primary" data-off="info">
												<c:choose>
													<c:when test="${c.ctBgActive == 1}">
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
                            que você ainda não possui nenhuma categoria cadastrada, clique
                            no botão <b>"Nova Categoria"</b>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>

        </div>

    </div>
</div>
