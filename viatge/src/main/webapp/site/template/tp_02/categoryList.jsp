<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="destinos">
	
    <div class="container">
    	<h1>Destinos referente a "Nome da Categoria"</h1>
    	
        <div class="pacotes">
        	
            <div class="grid">
            	<c:forEach var="listOfDestinationByCategory" items="${listOfDestinationByCategory}">
                	<div class="item">
                		<figure>
                			<a href="${pageContext.request.contextPath}/destinationDetail/${listOfDestinationByCategory.idDestination}">
                				<!-- IMAGEM 252PX POR 190PX -->
                				<img src="${pageContext.request.contextPath}/image/destination/thumbnail/${listOfDestinationByCategory.dtName}" alt="nome do pacote">
                			</a>
                		</figure> 
                    	<div class="info">
                    
                        	<h2>
                        		<a href="#"><c:out value="${listOfDestinationByCategory.dtName}"/></a>
                        	</h2>
                        	
                       		<p class="pais">
                       			<a href="#">
                       				<c:out value="${listOfDestinationByCategory.country.countryName}"/>
                       			</a>
                       		</p>
                        
                        <ul>
								<li><a href="#" class="viajo" title="${listOfDestinationByCategory.socialProfiles}"></a></li>
								<li><a href="#" class="procuro" title="${listOfDestinationByCategory.economicProfiles}"></a></li>
								<li><a href="#" class="quero" title="${listOfDestinationByCategory.tripProfiles}"></a></li>
								<li><a href="#" class="prefiro" title="${listOfDestinationByCategory.weatherprofile}"></a></li>
								<li><a href="#" class="adoro" title="${listOfDestinationByCategory.generalProfiles}"></a></li>
                        </ul>
                        <a href="${pageContext.request.contextPath}/destinationDetail/${listOfDestinationByCategory.idDestination}" class="btn">MAIS DETALHES</a>
                	
                    	</div>
                	</div>
                </c:forEach>                
            </div>
            <!-- FIM DE GRID -->
            
        </div>
        
        <h3>Ainda não achou o seu destino perfeito? Podemos ajudar com isso?</h3>
        <p><a href="${pageContext.request.contextPath}/perfect-travel" class="btn bg-thema">DESTINO PERFEITO</a></p>
        
        
	</div>
    
</section>