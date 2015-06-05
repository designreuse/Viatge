<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="blog">
	
    <div class="container">
    	
        <h1>Blog</h1>
        
        <div class="posts">
        	
            <!-- RESUMO DE POST -->
            <article class="post">
            	<h1>Maecenas quis turpis cursus</h1>
                <figure><img src="public/image/temp/post03.jpg" width="100%" alt="titulo do post"></figure><!-- IMAGEM 650PX POR ALT. AUTO -->
            	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis turpis cursus, sagittis arcu eu, condimentum mi. Donec mollis lacus arcu, a tincidunt orci euismod tempor. Etiam viverra nulla nec justo eleifend tristique tincidunt et dolor. Donec eu ullamcorper purus. Integer sed ullamcorper velit, et rhoncus turpis. Sed tempor nunc malesuada, scelerisque mauris ut, efficitur felis. Ut ut metus eu sapien faucibus condimentum. Vivamus quis suscipit neque, nec placerat velit.</p>

                <a href="${pageContext.request.contextPath}/blog/post" class="btn bg-thema">Continuar Lendo</a>
            </article>
            <!-- FIM DE POST -->
            
            <article class="post">
            	<h1>Maecenas quis turpis cursus</h1>
                <figure><img src="public/image/temp/post04.jpg" width="100%" alt="titulo do post"></figure>
            	<p>Integer semper dolor vitae lacus convallis, eget eleifend nisi pulvinar. Phasellus volutpat dictum fringilla. Etiam non risus nisl. Mauris tempor malesuada faucibus. Praesent sem nisi, imperdiet in ultrices blandit, porta sed quam. Integer rutrum elementum ligula, sit amet lobortis diam finibus vel. Praesent eget mauris tempor, commodo enim id, sagittis dui. Mauris volutpat elit sit amet suscipit convallis. Mauris orci odio, faucibus nec ante non, laoreet volutpat diam. Suspendisse a lobortis turpis. Sed sollicitudin velit odio, eget posuere turpis iaculis et. Quisque malesuada elit vel faucibus efficitur. Vestibulum nibh orci, tincidunt nec tellus feugiat, iaculis suscipit orci.</p>
            	
                <a href="${pageContext.request.contextPath}/blog/post" class="btn bg-thema">Continuar Lendo</a>
            </article>
            
            <article class="post">
            	<h1>Maecenas quis turpis cursus</h1>
                <figure><img src="public/image/temp/post03.jpg" width="100%" alt="titulo do post"></figure>
            	<p>Vivamus molestie dignissim tortor, sed consequat dui tempus ac. Morbi a aliquam velit. Pellentesque vitae tellus eget nunc porta rutrum ut imperdiet augue. Suspendisse laoreet finibus libero in dignissim. Sed blandit sit amet sapien ac varius. Sed gravida purus orci, eget pellentesque ex pulvinar a. Nullam consectetur augue eu ullamcorper lobortis. Nam tincidunt neque eu mauris efficitur dictum. Pellentesque non orci tincidunt, ultricies ligula eu, elementum odio. Cras consectetur eget tortor ut vehicula. Vivamus vitae dictum dolor. Nullam ultrices enim nec nunc volutpat, ac vestibulum diam iaculis. Vivamus a convallis enim.</p>
            	
                <a href="${pageContext.request.contextPath}/blog/post" class="btn bg-thema">Continuar Lendo</a>
            </article>
            
            <article class="post">
            	<h1>Maecenas quis turpis cursus</h1>
                <figure><img src="public/image/temp/post04.jpg" width="100%" alt="titulo do post"></figure>
            	<p>Cras porta lectus nec sollicitudin maximus. Nullam aliquam mi et urna sagittis, et tincidunt odio efficitur. Pellentesque sed pharetra lectus. Vivamus sagittis ex vel ipsum scelerisque, et laoreet enim vulputate. Integer vel augue nec ligula accumsan pulvinar in et orci. Proin tristique neque libero, ornare consectetur nisl accumsan a. Aliquam erat volutpat. Nam odio sapien, bibendum non metus vel, cursus suscipit eros. Pellentesque quis eros mollis, fringilla purus at, scelerisque erat. Cras ante eros, gravida eget metus vel, viverra tempor nibh. Maecenas justo neque, imperdiet non erat nec, ornare sodales nulla. Duis ultricies iaculis sem, quis fermentum dolor varius porta. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum eget risus ipsum. Morbi pulvinar tristique eleifend. Nam quis mauris ligula.</p>
            	
                <a href="${pageContext.request.contextPath}/blog/post" class="btn bg-thema">Continuar Lendo</a>
            </article>
			
            <div class="paginacao">
            	<a href="#" class="ativo">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
            </div>
            
        </div>
        
        <aside>
        	<!-- NEWSLETTER -->
			<form action="#" method="post" name="newsletter" class="newsletter bg-thema">
            	<label>Receba nas novidades</label>
                <div>
                    <input type="email" name="email" placeholder="Seu E-mail_">
                    <button type="submit"></button>
                </div>
            </form>
            <!-- FIM NEWSLETTER -->
            
            <!-- CATEGORIAS DO BLOG -->
        	<div class="categorias">
            	<h2>Categorias</h2>
                <menu>
                    <li><a href="#">Sollicitudin</a></li>
                    <li><a href="#">Pellentesque</a></li>
                    <li><a href="#">Sagittis urna</a></li>
                    <li><a href="#">Vivamus maximus</a></li>
                    <li><a href="#">Maecenas porta</a></li>
                    <li><a href="#">Maecenas urna</a></li>
                    <li><a href="#">Sollicitudin</a></li>
                    <li><a href="#">Pellentesque</a></li>
                    <li><a href="#">Sagittis urna</a></li>
                    <li><a href="#">Vivamus maximus</a></li>
                    <li><a href="#">Maecenas porta</a></li>
                    <li><a href="#">Maecenas urna</a></li>
                </menu>
            </div>
            <!-- FIM CATEGORIAS DO BLOG -->
            
        </aside>
        
    </div>
    
</section>