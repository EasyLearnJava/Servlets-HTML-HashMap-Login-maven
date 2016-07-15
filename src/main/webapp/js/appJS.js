/**
 * 
 */

function validateData() {
	var userNameValue = document.getElementById('userid').value.trim();
	if (userNameValue == "") {
		alert('please enter valid username');
		document.getElementById('userid').focus();
		return false;
	}
	var passwordField = document.getElementById('password').value.trim();
	if (passwordField == "") {
		alert('please enter valid password');
		document.getElementById('password').focus();
		return false;
	}
}
