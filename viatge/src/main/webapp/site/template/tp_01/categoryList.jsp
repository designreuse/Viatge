<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="content">
	<div class="container">
		<div id="main">
			<c:forEach var="listOfDestinationByCategory" items="${listOfDestinationByCategory}">
				<div class="col-sms-6 col-sm-6 col-md-3">
					<article class="box">
						<figure class="animated" data-animation-type="fadeInDown" data-animation-delay="0">
							<a href="${pageContext.request.contextPath}/destinationDetail/${listOfDestinationByCategory.idDestination}" class="hover-effect">
								<img width="270" height="160" alt="" src="${pageContext.request.contextPath}/image/destination/${listOfDestinationByCategory.dtName}">
							</a>
						</figure>
						<div class="details text-center">
							<h4 class="box-title">
								<c:out value="${listOfDestinationByCategory.dtName}" />
							</h4>
							<p class="offers-content">${listOfDestinationByCategory.country.countryName}</p>
						</div>
					</article>
				</div>
			</c:forEach>
			<ul class="pagination clearfix">
				<li class="prev disabled"><a href="#">Previous</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li class="disabled"><span>...</span></li>
				<li><a href="#">5</a></li>
				<li class="next"><a href="#">Next</a></li>
			</ul>
		</div>
	</div>
</section>