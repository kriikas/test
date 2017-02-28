<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:importAttribute name="titulo" />
<tiles:importAttribute name="javascripts" ignore="true" />

<!DOCTYPE html>
<html>
	<head>
		<title>Home Test</title>
		<link rel="stylesheet" type="text/css" href="resources/css/libs/easyui/easyui.css">
		<link rel="stylesheet" type="text/css" href="resources/css/libs/easyui/icon.css">
		<link rel="stylesheet" type="text/css" href="resources/css/libs/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="resources/css/test.css">
		<script type="text/javascript" src="resources/js/libs/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/libs/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="resources/js/libs/easyui/locale/easyui-lang-en.js"></script>
		<script type="text/javascript" src="resources/js/libs/easyui/locale/easyui-lang-es.js"></script>
		<script type="text/javascript" src="resources/js/libs/bootstrap/bootstrap.min.js"></script>
		<script type="text/javascript" src="resources/js/easyui-defaults/textbox-defaults.js"></script>
		<c:forEach var="javascript" items="${javascripts}">
			<script type="text/javascript" src="resources/js/views/${javascript}"></script>			
		</c:forEach>
		<title><spring:message code="${titulo}" /></title>
	</head>
	<body>
		<div class="container">
			<header>
				<tiles:insertAttribute name="cabecera" />
			</header>
			<nav>
				<tiles:insertAttribute name="menu" />
			</nav>
			<section>
				<tiles:insertAttribute name="contenido" />
			</section>
			<footer>
				<tiles:insertAttribute name="pie" />
			</footer>
		</div>
	</body>
</html>