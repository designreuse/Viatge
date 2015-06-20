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
	<li><i class="fa fa-lg fa-angle-right"></i></li>
	<li><a href="#" title="Visualizar Artigo">Visualizar</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap margin-bottom">
	<div class="row">
		<f:form method="post" commandName="articleBlogForm" action="${action}">


			<div class="nest text">
				<div class="title-alt">
					<h6>Visualizar Artigo</h6>
				</div>

			<div class="row" style="margin-bottom: 10px;">
				<div class="col-sm-12">
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
						<div class="col-sm-4">
							<a href="edit-article-blog?id=${articleBlogForm.idArticle}"
							style="margin-right: 10px;"
								class="pull-right btn btn-info "
								title="Editar Artigo">Editar </a> 
								&nbsp;&nbsp;
								<a href="#"
								style="margin-left: 10px;"
								class="pull-right btn btn-info" title="Ver Artigo no Site">
								Ver no Site </a>
						</div>
				</div>
				</div>

				<div class="col-sm-12">
					<h4>Titulo: ${articleBlogForm.atName}</h4>
					<h4>Categoria : ${articleBlogForm.categoryBlog.ctBgName}</h4> 
					<br /> 
					<figure>
						<img id="cover-article-img" alt="Capa do Artigo"
							 src="${pageContext.request.contextPath}/image/articleBlog/${articleBlogForm.atName}/${articleBlogForm.idArticle}" />
					</figure>
						
						 <br /><br />
					${articleBlogForm.atContent}
				</div>

			</div>
		</f:form>

	</div>
</div>