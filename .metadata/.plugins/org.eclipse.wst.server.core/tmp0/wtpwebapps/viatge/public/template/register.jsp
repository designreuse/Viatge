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
    
    <script src="${pageContext.request.contextPath}/resources/js/wizard/lib/modernizr-2.6.2.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.js"></script>		

    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/landing-joocebox.css">
    

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
            	O que é e porque o JooceBox é perfeito para Agência de Viagens?
            </p>
            
            <br />
            
            <p>
            	Assista o vídeo e descubra.	
            </p>
        </div>
          
      	<br clear="all"/>
   	
        <div class="container">
            <div class="row">
            	<div style="float: left;">
					<h4>1 minuto, é tudo que você precisa!</h4>
					
					<ul>
						<li>Insira sua logo</li>	
						<li>Escolha a cor</li>	
						<li>E o layout do seu site</li>	
					</ul>
				</div>
				
				<div style="float: right;">
					<iframe width="500" src="//www.youtube.com/embed/r7sZjzmD1oQ" frameborder="0" allowfullscreen></iframe>
				</div>
	
				<br clear="all"/>

                <div class="col-lg-12" style="margin-top: 100px;">
               		<tiles:insertAttribute name="register" />
                </div>
            </div>
        </div>
    </section>
    
</body>

</html>
		