<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <div id="paper-top">
        <div class="col-sm-12">
            <h2 class="tittle-content-header">
                <i class="icon-menu"></i> <span>Nova Categoria (Blog)</span>
            </h2>
        </div>
    </div>
</div>

<ul id="breadcrumb">
    <li><span class="entypo-home"></span></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="${pageContext.request.contextPath}/auth/home" title="Página Inicial">Página Inicial</a></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="${pageContext.request.contextPath}/auth/category-blog-list" title="Listagem de Categorias">Categorias</a></li>
    <li><i class="fa fa-lg fa-angle-right"></i></li>
    <li><a href="#" title="Nova Categoria">Nova Categoria</a></li>
</ul>
    
<div class="content-wrap margin-bottom">
    <div class="row">
        <div class="nest text">
            <div class="title-alt">
                <h6>Criar Nova Categoria</h6>
            </div>
            
           <%@ include file="formCategoryBlog.jsp" %>
        
        </div>
    </div>
</div>