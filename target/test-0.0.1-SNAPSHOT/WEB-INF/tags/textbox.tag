<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="placeHolder" required="true"%>
<%@ attribute name="size" required="true"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="name" required="true"%>

<spring:message code="${placeHolder}" var="placeHolder" />

<div class="${size}">
	<input id="${id}" name="${name}" data-options="prompt:'${placeHolder}'" />
</div>