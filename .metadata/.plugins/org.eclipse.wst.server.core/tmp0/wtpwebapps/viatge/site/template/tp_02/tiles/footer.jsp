<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<footer>

	<div class="container">
    
    	<div class="col-01">
        	<!-- MENU FOOTER -->
        	<div class="nav-footer">
                <h2 class="txt-thema">NAVEGAÇÃO</h2>
                <ul>
                    <li><a href="#">CATEGORIAS</a></li>
                    <li><a href="#">VIAGEM PERFEITA</a></li>
                    <li><a href="#">BLOG</a></li>
                    <li><a href="#">COMPRE ONLINE</a></li>
                    <li><a href="#">QUEM SOMOS</a></li>
                    <li><a href="#">CONTATO</a></li>
                </ul>
            </div>
            <!-- FIM MENU FOOTER -->
            
            <!-- TELEFONE FOOTER -->
            <div class="phone-footer">
            	<h2 class="txt-thema">TELEFONE</h2>
                NOSSA LINHA DIRETA E RÁPIDA,<br> LIGUE AGORA MESMO  <span class="txt-thema"><c:out value="${tenant.agencyPhone}"/></span>
            </div>
            <!-- FIM TELEFONE FOOTER -->
        </div>
        
        
        <div class="col-02">
        
        	<div class="feeds-footer">
            	<h2 class="txt-thema">NO BLOG</h2>
                <!-- FEEDS DE NOTÍCIAS -->
                <ul>
                	<li>
                    	<figure><a href="#"><img src="public/image/temp/post-p01.jpg" alt=""></a></figure> <!-- IMAGEM DE 70 x 70 PX -->
                        <div>
                            <h3><a href="#">AMAZING PLACES</a></h3>
                            <p><a href="#">Purus ac congue arcu cursus ut vitae pulvinar massaidp.</a></p>
                            <p>25 março, 2015</p>
                    	</div>
                    </li>
                    
                    <li>
                    	<figure><a href="#"><img src="public/image/temp/post-p02.jpg" alt=""></a></figure> <!-- IMAGEM DE 70 x 70 PX -->
                        <div>
                            <h3><a href="#">TRAVEL INSURANCE</a></h3>
                            <p><a href="#">Purus ac congue arcu cursus ut vitae pulvinar massaidp.</a></p>
                            <p>25 março, 2015</p>
                        </div>
                    </li>
                </ul>
                <!-- FIM FEEDS DE NOTÍCIAS -->
            </div>
            
        </div>
        
        
        <div class="col-03">
        	
            <!-- FORM DE MEWSLETTER -->
			<div class="newsletter">
            	<h2 class="txt-thema">NEWSLETTER</h2>
            	<p>Purus ac congue arcu cursus ut vitae pulvinar massaidp.</p>
        		<form action="#" method="post" class="form-newsletter">
                	<div><input type="email" name="newsletter" placeholder="Seu E-mail_"></div>
                    <div><button type="submit" name="cadasdrar-newsletter"></button></div>
                </form>
            </div>
            <!-- FIM FORM DE MEWSLETTER -->
            
            <!-- REDES SOCIAIS -->
            <div class="midia-social-footer">
            	<h2 class="txt-thema">REDE SOCIAIS</h2>
                <ul class="midia-social">
                    <li class="facebook"><a href="#"></a></li>
                    <li class="twitter"><a href="#"></a></li>
                    <li class="instagram"><a href="#"></a></li>
                    <li class="youtube"><a href="#"></a></li>
                    <li class="plus"><a href="#"></a></li>
                    <li class="linkedin"><a href="#"></a></li>
                </ul>
            </div>
            <!-- FIM REDES SOCIAIS -->
            
        </div>
        
    </div>
	
    <div class="copyright bg-thema">
    	<div class="container">
            <p>Todos os direitos reservador a <strong><c:out value="${tenant.agencyName}"/></strong>.</p>
            <a href="#" target="_blank" class="joocebox"></a> <!-- LOGO JOOCEBOX -->
            <a href="#" onclick="$('html,body').animate({ scrollTop: $('body').offset().top }, 1800);"  class="voltar-top"></a> <!-- LINK VOLTAR AO TOPO -->
        </div>
    </div>
    
</footer>