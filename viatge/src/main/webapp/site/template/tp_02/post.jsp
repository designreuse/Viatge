<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="blog">

	<div class="container">

		<!-- POST -->
		<article class="post">
			<h1>${articleCurrent.atName}</h1>

			<figure>
				<img src="${pageContext.request.contextPath}/image/articleBlog/${articleCurrent.atName}/${articleCurrent.idArticle}" width="100%"
					alt="titulo do post">
			</figure>

			<!-- TEXTO DE POST -->
			<p>
				${articleCurrent.atContent}
			</p>

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
                	<c:forEach items="${categories}" var="category">
	                    <li><a href="${pageContext.request.contextPath}/blog/category?id=${category.idCategoryBlog}">${category.ctBgName}</a></li>
	                </c:forEach>
				</menu>
			</div>

		</aside>

	</div>

</section>