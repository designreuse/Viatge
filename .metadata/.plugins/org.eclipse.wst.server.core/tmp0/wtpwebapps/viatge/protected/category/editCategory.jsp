<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- CONTENT -->
<!--TITLE -->
<div class="row">
    <div id="paper-top">
        <div class="col-sm-3">
            <!-- TITULO DA PÁGINA -->
            <h2 class="tittle-content-header"><i class="icon-menu"></i> <span>Editar CaTEGORIA</span></h2>
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
    <li><a href="${pageContext.request.contextPath}/auth/category" title="Listagem de Categorias">Gestão de Categorias</a></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="#" title="Editar Categorias">Editar Categoria</a></li>
</ul>
<!-- FIM BREADCRUMB -->


<div class="content-wrap">
    <div class="row">

        <div class="nest text">
            <div class="title-alt">
                <h6>Editar cATEGORIA</h6>
            </div>

            <%@ include file="form.jsp" %>

        </div>

    </div>
</div>