<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${tittel}</title>

<script type="text/javascript">
	window.menu = "${page}";
	window.contextRoot = "${contextRoot}";
</script>
<!-- Bootstrap core CSS -->
<link href="${contextRoot}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextRoot}/resources/css/r-theme.css" rel="stylesheet">

<link href="${contextRoot}/resources/css/jquery.dataTables.css"
	rel="stylesheet">
<link href="${contextRoot}/resources/css/dataTables.bootstrap.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${contextRoot}/resources/css/shop-homepage.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<!-- Navigation -->

		<div class="container">
			<a class="navbar-brand" href="${contextRoot}/home">Galaxy shoping</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item" id="home"><a class="nav-link"
						href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
					</a></li>

				</ul>
			</div>
		</div>

		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<div class="jumbotron">
					<h1>${errorTittel}</h1>
					<hr/>
					<blockquote>
						${errorDescreption}
					</blockquote>
				</div>
				
			</div>
		</div>
		<!-- /.container -->

		<%@include file="public/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->

		<script src="${contextRoot}/resources/js/jquery.min.js"></script>
		<script src="${contextRoot}/resources/js/bootstrap.bundle.min.js"></script>
		<script src="${contextRoot}/resources/js/jquery.dataTables.js"></script>
		<script src="${contextRoot}/resources/js/dataTables.bootstrap.js"></script>
		<!-- self coded JavaScript -->
		<script src="${contextRoot}/resources/js/myapp.js"></script>
	</div>
</body>
</html>