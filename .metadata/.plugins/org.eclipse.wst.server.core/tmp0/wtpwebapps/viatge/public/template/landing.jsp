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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/load.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map/gmap3.js"></script>
	<script type="text/javascript">

		$(function() {

			$("#test1")
					.gmap3(
							{
								marker : {
									latLng : [ -7.782893, 110.402645 ],
									options : {
										draggable : true
									},
									events : {
										dragend : function(marker) {
											$(this)
													.gmap3(
															{
																getaddress : {
																	latLng : marker
																			.getPosition(),
																	callback : function(
																			results) {
																		var map = $(
																				this)
																				.gmap3(
																						"get"), infowindow = $(
																				this)
																				.gmap3(
																						{
																							get : "infowindow"
																						}), content = results
																				&& results[1] ? results
																				&& results[1].formatted_address
																				: "no address";
																		if (infowindow) {
																			infowindow
																					.open(
																							map,
																							marker);
																			infowindow
																					.setContent(content);
																		} else {
																			$(
																					this)
																					.gmap3(
																							{
																								infowindow : {
																									anchor : marker,
																									options : {
																										content : content
																									}
																								}
																							});
																		}
																	}
																}
															});
										}
									}
								},
								map : {
									options : {
										zoom : 15
									}
								}
							});

		});
	</script>
</body>
</html>