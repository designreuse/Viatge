<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="logo-login">
	<h1>
		joocebox <span>v1.0</span>
	</h1>
</div>

<form class="form-signin" method="post" action="j_spring_security_check">
	<div ng-controller="loginController">
		<div class="alert alert-danger" ng-show="displayLoginError">
			<span class="entypo-attention"></span> <strong>Erro!</strong>&nbsp;&nbsp;Login
			e/ou Senha Incorretos!
		</div>


		<div class="alert alert-success" ng-show="displayLogoutMessage">
			<span class="entypo-thumbs-up"></span> <strong>Tchau!</strong>&nbsp;&nbsp;Você
			efetuou o logout com sucesso!
		</div>
	</div>
	<div class="input-group">
		<span class="input-group-addon entypo-user"></span> <input
			name="j_username" id="j_username" type="text" class="form-control"
			placeholder="E-mail">
	</div>
	<br>
	<div class="input-group">
		<span style="padding: 0 14px;" class="input-group-addon entypo-lock"></span>
		<input name="j_password" id="j_password" type="password"
			class="form-control" placeholder="Senha">
	</div>
	<br clear="all">

	<button type="submit"
		class="btn btn-lg btn-fltees btn-primary btn-block">Entrar</button>

	<a href="<c:url value="register"/>"
		class="btn btn-lg btn-fltees btn-primary btn-block">Crie uma nova
		Agência!</a> <input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/login.js"></script>
<script src="//fast.eager.io/6PyMYDDUrx.js"></script>