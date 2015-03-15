<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Main content -->
<section class="page-error">

	<div class="error-page">
		<h2 class="headline text-info">500</h2>
		<div class="error-content">
			<h3>
				<i class="fa fa-warning text-yellow"></i> Oops! Page not found.
			</h3>
			<p>
				We could not find the page you were looking for. Meanwhile, you may
				<a class="error-link" href='index.html'>return to dashboard</a> or
				try using the search form.
			</p>
			<form class='search-form'>
				<input type="text" name="search" class='form-control'
					placeholder="Search" />
			</form>
		</div>
		<!-- /.error-content -->
	</div>
	<!-- /.error-page -->

</section>

<!--  END OF PAPER WRAP -->