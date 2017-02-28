$(document).ready(function() {
	
	$("#email").textbox({
		required: true,
		validType:['email']
	});
	
	$("#username").textbox({
		required: true
	});
	
	$("#password").textbox({
		type: "password",
		required: true
	});
	
	$("#signupBoton").linkbutton({
		onClick: function() {
			$("#signupForm").form("submit");
		}
	});
});