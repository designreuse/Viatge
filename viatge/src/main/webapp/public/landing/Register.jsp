<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<script type="text/javascript">
$(document).ready(function() {
	$('button').click(function(e) {
		
		$("#msgSubdomain").text("");
		
		$.post('${pageContext.request.contextPath}/register/ajaxVerifySubdomain?${_csrf.parameterName}=${_csrf.token}', $('#form-register-subdomain').serialize(), function(data) {
			if(data != null){
				if(data.message != 'OK'){
					$("#msgSubdomain").text(data.message);
				} else {
					$('#form-register-subdomain').submit();
				}
			}
		});
		
		e.preventDefault(); 
	});

});
</script>

<f:form class="form-signin" method="post" action="addAgency" modelAttribute="tenant" id="form-register-subdomain">
		<small>Escolha o nome do seu site</small>
		<br />
		<f:input id="subdomain" path="subdomain" type="text" class="col-xs-6" placeholder="Exemplo: suagencia" style="float: left; height: 45px; width: 250px;" />
		<span style="font-size: 40px;">.joocebox.com</span>
		<br clear="all"/>
		<span id="msgSubdomain" style="color: #FF4500; font-size: 14px;"></span>
		<button type="submit" class="btn btn-lg btn-fltees btn-primary btn-block col-xs-6" style="width: 250px; float: right;">Fazer meu site</button>
</f:form>