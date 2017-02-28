<%@ taglib prefix="test" tagdir="/WEB-INF/tags" %>

<form id="signupForm" method="post" action="/test/rest/signup">
	<test:textbox size="col-xs-12" placeHolder="signup.email" id="email" name="email" />
	<test:textbox size="col-xs-12" placeHolder="signup.username" id="username" name="username" />
	<test:textbox size="col-xs-12" placeHolder="signup.password" id="password" name="password" />
	<test:button size="col-xs-12" text="signup.boton.signup" id="signupBoton" />
</form>