function checkEmailValidation(event) {
	alert('HIIII');
}

function validateRegisterUser() {
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var emailAddress = document.getElementById("inputEmail");
	var password = document.getElementById("inputPassword");
	var confirmPassword = document.getElementById("confirmPassword");

	var message = document.getElementById('message');
	if (firstName.value !== "" && lastName.value !== ""
			&& emailAddress.value !== "" && password.value !== ""
			&& confirmPassword.value !== "") {
		if(confirmPassword.value!==password.value){
			document.getElementById("submitButton").disabled = true;
			message.innerHTML = "<font color='red'>Password does not match</font>";
		}
		else{
			message.innerHTML = "";
		document.getElementById("submitButton").disabled = false;
		}
	}
}