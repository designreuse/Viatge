<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="contato">
	
    <div class="container">
    	
        <div class="col-1">
            <h1>Contato</h1>    
            <p>E vivencie as melhores experiências de viagem da sua vida.</p>
            
            <form action="contato.php?alert=contato" method="post" name="form-contato" class="form-contato">
                <div class="box-1">
                    <label for="nome">*Nome:</label>
                    <input type="text" class="input01" name="nome" id="nome" placeholder="Nome Completo">
                </div>
                <div class="box-1">
                    <label for="email">*E-mail:</label>
                    <input type="email" class="input01" name="email" id="email" placeholder="E-mail">
                </div>
                <div class="box-2">
                    <label for="telefone">*Telefone:</label>
                    <input type="tel" class="input01" name="telefone" id="telefone" placeholder="Telefone: (00) 0000-0000">
                </div>
                <div class="box-3">
                    <label for="celular">Celular:</label>
                    <input type="tel" class="input01" name="celular" id="celular" placeholder="Celular: (00) 0000-0000">
                </div>
                
                <div class="box-1">
                    <label for="mensagem">*Mensagem:</label>
                    <textarea class="textarea01" name="mensagem" id="mensagem" cols="5" rows="5"></textarea>
                </div>
                
                <div class="box-1">
                	<button type="submit" name="enviar" class="submit01 bg-thema"><i></i> ENVIAR MENSAGEM</button>
                </div>
            </form>
        </div>
    	
        
        <div class="col-2">
        	<!-- ENDEREÇO -->
        	<div class="endereco">
            	<h2>Endereço</h2>
                <p>
                	<i class="txt-thema"></i>
                	 Rua Pres Faria, 282<br>
                	Curitiba - Paraná
                </p>
                
                <p><a href="#mapa" onclick="$('html,body').animate({ scrollTop: $('#mapa').offset().top }, 1800);" class="btn bg-thema">VER NO MAPA</a></p>
            </div>
            
            <!-- TELEFONE -->
            <div class="telefone">
            	<h2>TELEFONE</h2>
                <p>
                	<i class="txt-thema"></i>
                    <a href="#" class="link-telefone"><small>(41) 9644-5090</small> </a>
                </p>
            </div>
            
            <!-- E-MAIL -->
            <div class="email">
            	<h2>E-MAIL</h2>
                <p>
                	<i class="txt-thema"></i>
                	<a href="mailto:contato@seusiteaqui.com.br">info@poltrona1.com.br</a>
                </p>
            </div>
        </div>
        
    </div>
    
    <!-- MAPA -->
    <div id="mapa" class="mapa-contato"></div>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">
    $(document).ready(function () {
        (function() {
            if($('#mapa').length > 0) {            
                var map = new google.maps.Map(document.getElementById('mapa'), {
                    zoom : 16,
                    zoomControl: true,
                    scaleControl: true,
                    scrollwheel: false,
                    disableDoubleClickZoom: true,
                    center : new google.maps.LatLng(-25.427908,-49.268486), //alterar coordenadas de endereço
                    mapTypeId : google.maps.MapTypeId.ROADMAP
                });
    
                var image = '/site/template/tp_02/assets/image/icons-location.png',
                    myLatLng = new google.maps.LatLng(-25.427908,-49.268486); //alterar coordenadas de endereço
    
                var beachMarker = new google.maps.Marker({
                    position : myLatLng,
                    map : map,
                    icon : image
                });
            }
        })();
    });
    </script>
    <!-- FIM MAPA -->
    
</section>
