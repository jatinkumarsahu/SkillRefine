function validateRegisterUser() {
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var emailAddress = document.getElementById("inputEmail");
	var password = document.getElementById("inputPassword");
	var confirmPassword = document.getElementById("confirmPassword");
	var emailCheck = document.getElementById("emailCheck");

	console.log('VVVVRR');

	var message = document.getElementById('message');
	console.log("MMMM "+message.innerHTML);
	if (firstName.value !== ""
			&& lastName.value !== ""
			&& emailAddress.value !== ""
			&& password.value !== ""
			&& confirmPassword.value !== ""
			&& message.innerHTML == "") {
			console.log('11 '+emailCheck.innerHTML);
			if (emailCheck.innerHTML == '<font color="green">&nbsp;E-mail Valid</font>') {
				console.log('22');
				document.getElementById("submitButton").disabled = false;
			}
		
	} else {
		document.getElementById("submitButton").disabled = true;
	}
}

function validatePassword(){
	var password = document.getElementById("inputPassword");
	var confirmPassword = document.getElementById("confirmPassword");
	
	if(password.value!==confirmPassword.value){
		message.innerHTML = "<font color='red'>Password does not match</font>";
	}
	else
		message.innerHTML = "";
}

function checkEmailValidation() {
	var emailCheck = document.getElementById("emailCheck");
	var emailAddress = document.getElementById("inputEmail");
	if (emailAddress.value !== "") {
		// emailCheck.innerHTML = "<font color='red'>&nbsp;Checking email
		// validity...</font>";
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", "http://localhost:8080/validateEmail/"
				+ emailAddress.value, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText == "true") {
					emailCheck.innerHTML = "<font color='green'>&nbsp;E-mail Valid</font>";
				} else {
					emailCheck.innerHTML = "<font color='red'>&nbsp;E-mail already registered</font>";
				}
			}
		};
	} else {
		emailCheck.innerHTML = "";
	}
}