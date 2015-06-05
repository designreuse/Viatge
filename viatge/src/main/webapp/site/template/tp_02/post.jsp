<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="blog">

	<div class="container">

		<!-- POST -->
		<article class="post">
			<h1>Maecenas quis turpis cursus</h1>

			<figure>
				<img src="public/image/temp/post03.jpg" width="100%"
					alt="titulo do post">
			</figure>

			<!-- TEXTO DE POST -->
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Maecenas quis turpis cursus, sagittis arcu eu, condimentum mi. Donec
				mollis lacus arcu, a tincidunt orci euismod tempor. Etiam viverra
				nulla nec justo eleifend tristique tincidunt et dolor. Donec eu
				ullamcorper purus. Integer sed ullamcorper velit, et rhoncus turpis.
				Sed tempor nunc malesuada, scelerisque mauris ut, efficitur felis.
				Ut ut metus eu sapien faucibus condimentum. Vivamus quis suscipit
				neque, nec placerat velit.</p>
			<p>Integer semper dolor vitae lacus convallis, eget eleifend nisi
				pulvinar. Phasellus volutpat dictum fringilla. Etiam non risus nisl.
				Mauris tempor malesuada faucibus. Praesent sem nisi, imperdiet in
				ultrices blandit, porta sed quam. Integer rutrum elementum ligula,
				sit amet lobortis diam finibus vel. Praesent eget mauris tempor,
				commodo enim id, sagittis dui. Mauris volutpat elit sit amet
				suscipit convallis. Mauris orci odio, faucibus nec ante non, laoreet
				volutpat diam. Suspendisse a lobortis turpis. Sed sollicitudin velit
				odio, eget posuere turpis iaculis et. Quisque malesuada elit vel
				faucibus efficitur. Vestibulum nibh orci, tincidunt nec tellus
				feugiat, iaculis suscipit orci.</p>
			<p>Vivamus molestie dignissim tortor, sed consequat dui tempus
				ac. Morbi a aliquam velit. Pellentesque vitae tellus eget nunc porta
				rutrum ut imperdiet augue. Suspendisse laoreet finibus libero in
				dignissim. Sed blandit sit amet sapien ac varius. Sed gravida purus
				orci, eget pellentesque ex pulvinar a. Nullam consectetur augue eu
				ullamcorper lobortis. Nam tincidunt neque eu mauris efficitur
				dictum. Pellentesque non orci tincidunt, ultricies ligula eu,
				elementum odio. Cras consectetur eget tortor ut vehicula. Vivamus
				vitae dictum dolor. Nullam ultrices enim nec nunc volutpat, ac
				vestibulum diam iaculis. Vivamus a convallis enim.</p>

			<!-- COMPARTILHAMENTO -->
			<div class="compartilhamento">
				<span>COMPARTILHE:</span>

				<!-- facebook -->
				<div id="fb-root"></div>
				<script>(function(d, s, id) {
                  var js, fjs = d.getElementsByTagName(s)[0];
                  if (d.getElementById(id)) return;
                  js = d.createElement(s); js.id = id;
                  js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.3";
                  fjs.parentNode.insertBefore(js, fjs);
                }(document, 'script', 'facebook-jssdk'));</script>

				<div class="fb-share-button" data-href="http://linkdapagina.com.br"
					data-layout="button_count"></div>

				<!-- twitter -->
				<a href="https://twitter.com/share" class="twitter-share-button">Tweet</a>
				<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
			</div>

			<div class="comentarios">
				<!-- COMENTÁRIO -->
				<h2>
					<strong>77</strong> COMENTÁRIO
				</h2>
				<p>Onec mollis lacus arcu, a tincidunt orci euismod tempor.
					Etiam viverra nulla nec justo eleifend tristique tincidunt et
					dolor.</p>

				<ul class="list-comentarios">
					<li>
						<h3>Consectetur Adipiscing</h3>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing
							elit. Maecenas quis turpis cursus, sagittis arcu eu, condimentum
							mi. Donec mollis lacus arcu, a tincidunt orci euismod tempor.</div>
					</li>


					<li class="resposta">
						<!-- CLASS PARA RESPOSTA DE COMENTÁRIO -->
						<h3>Modelador : Maicon Cesar</h3>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing
							elit. Maecenas quis turpis cursus, sagittis arcu eu, condimentum
							mi. Donec mollis lacus arcu, a tincidunt orci euismod tempor.</div>
					</li>

					<li class="resposta">
						<h3>Modelador : Maicon Cesar</h3>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing
							elit. Maecenas quis turpis cursus, sagittis arcu eu, condimentum
							mi. Donec mollis lacus arcu, a tincidunt orci euismod tempor.</div>
					</li>

					<li>
						<h3>Consectetur Adipiscing</h3>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing
							elit. Maecenas quis turpis cursus, sagittis arcu eu, condimentum
							mi. Donec mollis lacus arcu, a tincidunt orci euismod tempor.</div>
					</li>
				</ul>
				<!-- FIM COMENTÁRIO -->

				<!-- ADICIONAR COMENTÁRIO -->
				<form action="#" method="post" name="form-comentarios"
					class="form-comentarios">
					<h2>DEIXE O SEU COMENTÁRIO</h2>
					<div>
						<label for="nome">*Nome</label> <input type="text" class="input01"
							id="nome" name="nome">
					</div>

					<div>
						<label for="email">*E-mail</label> <input type="email"
							class="input01" id="email" name="email">
					</div>

					<div>
						<label for="comentario">*Comentário</label>
						<textarea name="comentario" cols="5" rows="5" class="textarea01"
							id="comentario" name="comentario"></textarea>
					</div>

					<div>
						<button type="submit" class="submit01 btn" name="enviar">
							<i></i> ENVIAR COMENTÁRIO
						</button>
					</div>
				</form>
				<!-- FIM ADICIONAR COMENTÁRIO -->
			</div>

		</article>

		<!-- POST -->

		<aside>

			<form action="#" method="post" name="newsletter"
				class="newsletter bg-thema">
				<label>Receba nas novidades</label>
				<div>
					<input type="email" name="email" placeholder="Seu E-mail_">
					<button type="submit"></button>
				</div>
			</form>

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

		</aside>

	</div>

</section>