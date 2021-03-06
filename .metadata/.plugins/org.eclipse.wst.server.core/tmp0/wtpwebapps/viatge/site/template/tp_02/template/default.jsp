<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><c:out value="${tenant.agencyName}"/></title>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/site/resources/tp_02/image/favicon.png" type="image/x-icon">

<link href="${pageContext.request.contextPath}/site/resources/tp_02/css/style.css" media="screen" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/site/resources/tp_02/css/thema.css" media="screen" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/site/resources/tp_02/css/jquery-ui.theme.min.css" media="screen" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/site/resources/tp_02/css/tooltipster.css" media="screen" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/site/resources/tp_02/css/owl.carousel.css" media="screen" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/site/resources/tp_02/css/fontello.css" media="screen" rel="stylesheet" type="text/css">

<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script type="text/javascript" src="http://sawpf.com/1.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery.tooltipster.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery.customSelect.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/placeholder.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/application.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/site/resources/tp_02/js/changeThemeColor.js"></script>

</head>

<body>

		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="body" />

		<tiles:insertAttribute name="footer" />

	
    <!--
    	OBS. GERAL: ESTOU USANDO UM PARAMETRO NA URL PARA ATIVAR OS ALERTAS...
        EXEMPLO URL. "alert=contato" ABRE A RESPOSTA DE CONTATO ENVIADO
    	ESTOU USANDO O PHP PARA ISSO, ENTÃO PRECISAMOS ADAPITAR PARA O JAVA
    -->
    
</body>
</html>