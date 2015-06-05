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
			<!-- TITULO DA PÃGINA -->
			<h2 class="tittle-content-header">
				<i class="icon-menu"></i> <span>Alteração de Layout</span>
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
	<li><a href="#" title="Sample page 1">Layout</a></li>
</ul>
<!-- FIM BREADCRUMB -->

<div class="content-wrap">
	<div class="row">

		<div class="nest text">
			<div class="title-alt">
				<h6>Layout do website alterado com Sucesso!</h6>
			</div>
			<form action="#">
				<div align="center">
					<figure>
					<img src="../resources/layouts/thumb/emBreve.jpg"/>
					</figure>
					<br/><br/>
					Que legal seu website está de cara nova...
					<br/><br/>				
					<a href="javascript:window.open('${agenciaUrl}');">Clique aqui para ver como ficou</a>
				</div>

			</form>
		</div>
	</div>
</div>
