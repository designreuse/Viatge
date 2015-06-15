<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="blog">
	
    <div class="container">
    	
        <h1>Blog</h1>
        
        <div class="posts">
        	
        	<c:forEach items="${articlesBlog}" var="article">
            <article class="post">
            	<h1>${article.atName}</h1>
                <figure><img src="${pageContext.request.contextPath}/image/articleBlog/${article.atName}/${article.idArticle}" width="100%" alt="titulo do post"></figure><!-- IMAGEM 650PX POR ALT. AUTO -->
            	<p>
            		${article.reducedContent}
				</p>

                <a href="${pageContext.request.contextPath}/blog/post/${article.idArticle}" class="btn bg-thema">Continuar Lendo</a>
            </article>
            </c:forEach>
            <!-- FIM DE POST -->
			
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
                	<c:forEach items="${categories}" var="category">
	                    <li><a href="${pageContext.request.contextPath}/blog/category?id=${category.idCategoryBlog}">${category.ctBgName}</a></li>
	                </c:forEach>
                </menu>
            </div>
            <!-- FIM CATEGORIAS DO BLOG -->
            
        </aside>
        
    </div>
    
</section>