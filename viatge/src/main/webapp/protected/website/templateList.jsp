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
				<i class="icon-menu"></i> <span>Escolha o Layout de Seu
					Website</span>
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
				<h6>Layouts</h6>
			</div>
			<f:form action="template-selected" method="post"
				class="template-selected" modelAttribute="agConfig">

				<ul class="list-layout">
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/01.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A01</label>
							<f:radiobutton path="siteTemplate" value="1" />

						</div>
					</li>
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/emBreve.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A02</label>
							<f:radiobutton path="siteTemplate" value="2" disabled="true" />

						</div>
					</li>
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/emBreve.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A03</label>
							<f:radiobutton path="siteTemplate" value="3" disabled="true" />

						</div>
					</li>
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/emBreve.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A04</label>
							<f:radiobutton path="siteTemplate" value="4" disabled="true" />

						</div>
					</li>
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/emBreve.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A05</label>
							<f:radiobutton path="siteTemplate" value="5" disabled="true" />

						</div>
					</li>
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/emBreve.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A06</label>
							<f:radiobutton path="siteTemplate" value="6" disabled="true" />

						</div>
					</li>
					<li>
						<figure>
							<a href="javascript:window.open('http://www.gooogle.com.br','_blank');">
								<img src="../resources/layouts/thumb/emBreve.jpg">
							</a>
						</figure>
						<div class="skin skin-flat">
							<label for="layout-a01">Layout A07</label>
							<f:radiobutton path="siteTemplate" value="7" />

						</div>
					</li>

				</ul>

				<div class="col-sm-12 margin-bottom">
					<button type="submit" class="btn btn-primary pull-right">Pronto</button>
				</div>

			</f:form>
		</div>
	</div>
</div>
