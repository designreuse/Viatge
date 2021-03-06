<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    <!-- TOP NAVBAR -->
    <nav role="navigation" class="navbar navbar-static-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="entypo-menu"></span>
                </button>
                <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
                    <span class="entypo-list-add"></span>
                </button>

                <div id="logo-mobile" class="visible-xs">
                    <h1>JooceBox <span>v1.0</span></h1>
                </div>

            </div>


            <!-- Collect the nav links, forms, and other content for toggling -->
            <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
				                <ul class="nav navbar-nav">

                    <li class="dropdown">

                        <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i style="font-size:20px;" class="icon-conversation"></i><div class="noft-red">3</div></a>


                        <ul style="margin: 11px 0 0 9px;" role="menu" class="dropdown-menu dropdown-wrap">
                            <li>
                                <a href="#">
                                    Você tem um novo orçamento
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    Você tem 1 cliente próximo(s) de viajar!
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    Um cliente acaba de voltar de viagem.
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                    </li>

                </ul>
                <div id="nt-title-container" class="navbar-left running-text visible-lg">
                    <ul class="date-top">
                        <li class="entypo-calendar" style="margin-right:5px"></li>
                        <li id="Date"></li>
                    </ul>
                    <ul id="digital-clock" class="digital">
                        <li class="entypo-clock" style="margin-right:5px"></li>
                        <li class="hour"></li>
                        <li>:</li>
                        <li class="min"></li>
                        <li>:</li>
                        <li class="sec"></li>
                        <li class="meridiem"></li>
                    </ul>
                </div>
				
			<c:url value="/logout" var="logoutUrl" />

			<!-- csrt for log out-->
						<ul style="margin-right:0;" class="nav navbar-nav navbar-right">
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        	<c:choose>
								<c:when test="${employeeAvatar.avatar}">
									<img alt="" class="admin-pic img-circle" src="${pageContext.request.contextPath}/image/avatar/${employeeAvatar.id}/avatar-${employeeAvatar.id}.jpg">Olá,&nbsp;&nbsp;${employeeAvatar.firstName} <b class="caret"></b>
								</c:when>
								<c:otherwise>
									<img alt="" class="admin-pic img-circle" src="https://s3-sa-east-1.amazonaws.com/joocebox-media/static-images/user-128.jpg">Olá,&nbsp;&nbsp;${employeeAvatar.firstName} <b class="caret"></b>
								</c:otherwise>	
							</c:choose>
                        </a>
                        <ul style="margin-top:14px;" role="menu" class="dropdown-setting dropdown-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/auth/employee/view/${employeeAvatar.id}">
                                    <span class="entypo-user"></span>&#160;&#160;Meu Perfil</a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="entypo-vcard"></span>&#160;&#160;Configurações</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="javascript:formSubmit()"> <span class="entypo-logout"></span>&#160;&#160;Sair</a>
                            </li>
                        </ul>
                    </li>
                </ul>
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>


		</div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- /END OF TOP NAVBAR -->