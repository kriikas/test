$(document).ready(function() {
	
	$("#email").textbox({
		required: true,
		validType:['email']
	});
	
	$("#username").textbox({
		required: true
	});
	
	$("#password").passwordbox({
		required: true
	});
	
	$("#signupBoton").linkbutton({
		onClick: function() {
			$("#signupForm").form("submit");
		}
	});
});