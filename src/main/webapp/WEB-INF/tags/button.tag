<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="size" required="true"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="text" required="true"%>

<div class="${size}">
	<a id="${id}" href="#">
		<spring:message code="${text}" />
	</a>
</div>