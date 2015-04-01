<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>JooceBox - CRM</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="JooceBox - CRM">
	<meta name="author" content="viatge">
    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.js"></script>
    <script type="text/javascript"  src="http://malsup.github.io/jquery.blockUI.js"></script>	
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.9.custom.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/wizard/lib/modernizr-2.6.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquerySteps/jquery.steps.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/inputMask/jquery.maskedinput.js"></script>

    
    
    <!-- INICIO dropZone -->
  	<script src="${pageContext.request.contextPath}/resources/js/dropZone/lib/dropzone.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/dropZone/downloads/css/dropzone.css">
    <!-- FIM REDE dropZone -->
    
    <!-- Fim do Wizard -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/landing-joocebox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/wizard/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/wizard/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/wizard/jquery.steps.css">
    


    
	
</head>

<body>
	<header>
    	<nav class="navigation navigation-header fixmenu-clone fixmenu-stick">
            <div class="container">
                <div class="navigation-brand">
                    <div class="brand-logo">
                    	<img src="${pageContext.request.contextPath}/resources/img/logo.png" height="100">
                    </div>
                </div>
                
                <div class="navigation-navbar">
                    <ul class="navigation-bar navigation-bar-left">
                        <li class="active"><a href="#principal">Principal</a></li>
                        <li class=""><a href="#funcionalidades">Funcionalidades</a></li>
                        <li><a href="#clientes">Clientes</a></li>
                        <li><a href="#sobre">Sobre Nós</a></li>
                        <li class=""><a href="#contato">Contato</a></li>
                    </ul>
                    <ul class="navigation-bar navigation-bar-right">
                        <li class="featured active"><a href="/clientes/" target="_blank">Entrar</a></li>
                    </ul>  
                </div>
                
            </div>
        </nav>
    </header>
    
    
    <section id="contato" class="">
   		<div class="text-heading">
            <p style="color: #2796FF; font-size: 36px;">
            	Seu JooceBox já está quase pronto para ser utilizado. 
            </p>
            
            <br />
            
            <p>
            	Configure abaixo as informações de sua agência.
            </p>
        </div>
          
      	<br clear="all"/>
   	
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
               		<tiles:insertAttribute name="wizard" />
                </div>
            </div>
        </div>
    </section>
    
</body>

</html>	