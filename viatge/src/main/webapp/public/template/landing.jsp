<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="pt-BR" id="ng-app" ng-app="myApp">
<head>
<meta charset="utf-8">
<title>JooceBox - CRM</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="JooceBox - CRM">
<meta name="author" content="viatge">
<style type="text/css">
body {
	overflow: hidden !important;
	padding-top: 150px;
}
</style>
	<!-- Le styles -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loader-style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signin.css">
	
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<!-- Fav and touch icons -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/ico/favicon.ico">

</head>
<body>
	<!-- Preloader -->
	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<div class="container">

		<div id="login-wrapper">
			<tiles:insertAttribute name="register" />
		</div>
		<div style="text-align: center; margin: 0 auto;">
			<h6 style="color: #fff;">Powered by © JooceBox 2014</h6>
		</div>
	</div>
	
	<div id="test1" class="gmap3"></div>

	<!--  END OF PAPER WRAP -->


	<!-- MAIN EFFECT -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/preloader.js"></script>

</body>
</html>