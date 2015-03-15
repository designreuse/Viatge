<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div id="logo-login">
	<h1>
		joocebox <span>v1.0</span>
	</h1>
</div>

<f:form class="form-signin" method="post" action="addAgency" modelAttribute="tenant">

	<div class="input-group">
		<span class="input-group-addon entypo-user"></span>
		<f:input path="firstName" type="text" class="form-control"
			placeholder="Nome" />
	</div>

	<br>

	<div class="input-group">
		<span class="input-group-addon entypo-user"></span>
		<f:input path="lastName" type="text" class="form-control"
			placeholder="Sobrenome" />
	</div>

	<br>

	<div class="input-group">
		<span class="input-group-addon entypo-mail"></span>
		<f:input path="email" type="text" class="form-control"
			placeholder="E-mail" />
	</div>

	<br>

	<div class="input-group">
		<span class="input-group-addon entypo-globe"></span>
		<f:input path="subdomain" type="text" class="form-control"
			placeholder="Subdominio" />
	</div>

	<br>

	<div class="input-group">
		<span style="padding: 0 14px;" class="input-group-addon entypo-lock"></span>
		<f:input path="password" type="text" class="form-control"
			placeholder="Senha" />
	</div>

	<br>

	<button type="submit"
		class="btn btn-lg btn-fltees btn-primary btn-block">Cadastrar
		Nova Agência</button>

	<button type="submit"
		class="btn btn-lg btn-fltees btn-primary btn-block">Já Possuo
		Cadastro</button>
</f:form>