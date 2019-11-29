function validateRegisterUser() {
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var emailAddress = document.getElementById("inputEmail");
	var password = document.getElementById("inputPassword");
	var confirmPassword = document.getElementById("confirmPassword");
	
	var emailCheck = document.getElementById("emailCheck");
	var message = document.getElementById('message');
	
	if(password.value!==confirmPassword.value){
		message.innerHTML = "<font color='red'>Password does not match</font>";
	}else{
		message.innerHTML = "";
	}
	
	if (firstName.value !== ""
		&& lastName.value !== ""
		&& emailAddress.value !== ""
		&& password.value !== ""
		&& confirmPassword.value !== "") {
		
		if(password.value===confirmPassword.value){
			document.getElementById("submitButton").disabled = false;
			message.innerHTML = "";
		}else{
			document.getElementById("submitButton").disabled = true;
			message.innerHTML = "<font color='red'>Password does not match</font>";
		}
	} else {
		document.getElementById("submitButton").disabled = true;
	}
}

function submitForm(){
	document.getElementById("submitButton").disabled = true;
	
	var spinner = document.getElementById("spinner");
	var formReg = document.getElementById("formReg");
	
	formReg.style.display = "none";
	spinner.style.display = "block";
	
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var emailAddress = document.getElementById("inputEmail");
	var password = document.getElementById("inputPassword");
	var confirmPassword = document.getElementById("confirmPassword");
	
	var emailCheck = document.getElementById("emailCheck");
	var message = document.getElementById('message');
	
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "http://localhost:8080/validateEmail/"+emailAddress.value, true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if (xmlhttp.responseText == "true") {
				emailCheck.innerHTML = "<font color='green'>&nbsp;E-mail Valid</font>";
				//submit form code
				var xmlhttp1 = new XMLHttpRequest();
				xmlhttp1.open("GET", "http://localhost:8080/signUp?firstName="+firstName.value+"&lastName="+lastName.value+"&userEmail="+emailAddress.value+"&userPassword="+password.value, true);
				xmlhttp1.send();
				xmlhttp1.onreadystatechange = function() {
					if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
						firstName.value="";
						lastName.value="";
						emailAddress.value=""; 
						password.value=""; 
						confirmPassword.value=""; 
						emailCheck.innerHTML="";
						formReg.style.display = "block";
						spinner.style.display = "none";
						message.innerHTML="<font color='green'><b>User Registered. </b> Please login <a href='http://localhost:8080/'>click here</a></font>";
					}else{
						formReg.style.display = "block";
						spinner.style.display = "none";
						message.innerHTML="<font color='red'>Something went wrong.!!!</font>";
					}
				};
				
			} else {
				emailCheck.innerHTML = "<font color='red'>&nbsp;E-mail already registered</font>";
			}
		}
	};
}