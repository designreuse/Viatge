<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section id="orcamento">

	<div class="container">

		<h1>Orçamento enviado com sucesso !</h1>
		<p>Legal ${customerForm.firstName}!</p>
		<p>Agora iremos planejar a viagem dos seus sonhos e entraremos em contato assim que tivermos uma resposta para você!</p>
		<p>Iremos lhe (ligar / enviar e-mail) no (${customerForm.customerPhone.homePhone} / ${customerForm.email}). </p>
		<p>Você pode pedir mais orçamentos se estiver curioso quanto a outros destinos, e o melhor, sem precisar preencher tudo novamente. </p>
		<p>Basta clicar no botão "Solicitar Orçamento" dentro de qualquer destino que o resto das informações nós já temos. </p>
		
		<div class="posts">
        	<a href="${pageContext.request.contextPath}/site" class="btn bg-thema">Continuar Navegando</a>
        </div>
	</div>

</section>