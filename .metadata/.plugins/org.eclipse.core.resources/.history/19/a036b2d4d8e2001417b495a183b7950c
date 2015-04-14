<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="content">
	<div class="container">
		<div class="row">
			<div id="main" class="col-md-9">
				<div class="tabset1">
					<div data-pws-tab="tab1" data-pws-tab-name="Imagens">
						<div class="photo-gallery style3">
							<ul class="bxslider">
								<c:forEach var="image" items="${destinationDetail.images}">
									<li><img src="${pageContext.request.contextPath}/image/destinationDetail/${image.id}">
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>

					<div data-pws-tab="tab2" data-pws-tab-name="Tour Virtual">
						<iframe width="840" height="342" frameborder="0" scrolling="no"
							marginheight="0" marginwidth="0"
							src="${destinationDetail.streetView.src}"></iframe>

					</div>
					<div data-pws-tab="tab3" data-pws-tab-name="Video">
						<iframe title="YouTube video player" class="youtube-player"
							type="text/html" width="840" height="342"
							src="${destinationDetail.video.code}" frameborder="0"
							allowFullScreen></iframe>
					</div>


				</div>

				<div class="main-content">
					<div class="long-description">
						<h2>
							Descrição sobre
							<c:out value="${destinationDetail.dtName}" />
						</h2>
						<div class="comment">
							${destinationDetail.dtDescription}
						</div>
					</div>

					<a href="#" style="margin-bottom: 20px;"
						class="button btn-small green pull-left">Realizar Orçamento</a>
				</div>
			</div>
			<div class="sidebar col-md-3">
				<div class="travelo-box contact-box">
					<h4>Entre em Contato</h4>
					<p>Fale com um agente de viagens especializado.</p>
					<address class="contact-details">
						<span class="contact-phone"> <i class="soap-icon-phone"></i>
							<c:out value="${agencyDetail.agencyPhone}" />
						</span> <br> <a class="contact-email" href="#"><c:out
								value="${agencyDetail.email}" /></a>
						<button class="icon-check full-width">REALIZAR ORÇAMENTO</button>
					</address>

				</div>

			</div>
		</div>
	</div>
</section>