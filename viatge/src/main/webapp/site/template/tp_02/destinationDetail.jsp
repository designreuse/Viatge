<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section id="destino">
	
    <div class="container">
    	
        <h1><c:out value="${destinationDetail.dtName}"/></h1>    
		
        <div class="info-destino">
        	
            <!-- NAV MÍDIAS DE DESTINO -->
            <ul class="nav-midia">
            	<li><a href="#">Fotos</a></li>
                <li><a href="#">Vídeo</a></li>
                <li><a href="#">Tour Virtual</a></li>
            </ul>
            <!-- FIM NAV MÍDIAS DE DESTINO -->
            
            <!-- MÍDIAS DE DESTINO -->
            <div class="midia-destino">
            	
                <!-- FOTOS -->
            	<div class="fotos">
            		<c:forEach var="image" items="${destinationDetail.images}">
						<div>
							<img src="${pageContext.request.contextPath}/image/destinationDetail/${image.id}" width="100%">
						</div>
					</c:forEach>
                </div>
                
                <!-- VIDEO -->
                <div class="video">
                	<div class='embed'>
                		<iframe src='${destinationDetail.video.code}' frameborder='0' allowfullscreen>
                		</iframe>
                	</div>
                </div>
            	
                <!-- MAPA -->
            	<div class="street-view" >             	
					<div id="map-canvas">
						<iframe height="421px" width="749px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="${destinationDetail.streetView.src}"></iframe>
					</div>

                </div>
                
            </div>
            <!-- FIM DE DESTINO -->
            
            <!-- TEXTO DE DESTINO -->
            <h2>Descrição</h2>
        	 ${destinationDetail.dtDescription}
        	<!-- FIM TEXTO DE DESTINO -->
            
        </div>
		
        <!-- CONTATO -->
        <div class="contato-destino">
       		<h2>Entre em contato</h2>
            <p>Morbi in libero sed turpis finibus egestas non sit amet dolor</p>
            <p class="telefone txt-thema"> <c:out value="${agencyDetail.agencyPhone}"/></p>
            <p class="email"><a href="mailto:${agencyDetail.login.email}"></a><c:out value="${agencyDetail.login.email}" /></a></p>
            <p><a href="${pageContext.request.contextPath}/budget/${destinationDetail.idDestination}" class="btn bg-thema">SOLICITAR ORÇAMENTO</a></p>
        </div>
        <!-- FIM CONTATO -->
         
	</div>    
    
</section>
