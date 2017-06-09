/**
 * 
 */

document.addEventListener( 'DOMContentLoaded', function () {

	checkObligatoryInputs();
	verifyEmail();
}, false );
function checkObligatoryInputs(){

	if(document.getElementsByName('email')[0].value == ""
		|| document.getElementsByName('name')[0].value == ""
			||  document.getElementsByName('firstname')[0].value == "" 
				|| document.getElementsByName('pwd')[0].value == "")
	{
//		document.querySelectorAll('input[type=submit]')[0].disabled = true;
		document.querySelectorAll('#Submit')[0].disabled = true;

	}
	document.querySelectorAll('form')[0].addEventListener("change",function(){
		document.querySelectorAll("#EmailNotif")[0].style.display = "none";

		if( validateEmail(document.getElementsByName('email')[0].value)
				&& validatePwd(document.getElementsByName('pwd')[0].value)
				&& validateName("name")	&& validateName("firstname")
		)
		{
//			document.querySelectorAll('input[type=submit]')[0].disabled = false;
			document.querySelectorAll('#Submit')[0].disabled = false;

		}
	});

}
function validateEmail(email) {
	if(	document.getElementsByName('email')[0].value == "") {
		document.querySelectorAll('span[id="emailOk"]')[0].style.visibility ="hidden";
		document.querySelectorAll('span[id="email"]')[0].style.visibility ="visible";
		return false;} 
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if( re.test(email) == false && email != ""){
		document.querySelectorAll('span[id="emailOk"]')[0].style.visibility ="hidden";
		document.querySelectorAll('span[id="email"]')[0].style.visibility ="visible";
	}
	if( re.test(email) && email != "")
	{
		document.querySelectorAll('span[id="email"]')[0].style.visibility ="hidden";
		document.querySelectorAll('span[id="emailOk"]')[0].style.visibility ="visible";


	}
	return re.test(email);
}
function validatePwd(password){
	if( document.getElementsByName('pwd')[0].value == ""){
		document.querySelectorAll('span[id="pwdOk"]')[0].style.visibility ="hidden";
		document.querySelectorAll('span[id="pwd"]')[0].style.visibility ="visible";
		return false;
	} 

	console.log("ici");
	var allLetters = /^[a-zA-Z]+$/;
	var letter = /[a-zA-Z]/;
	var number = /[0-9]/;
	if (password.length < 4 || !letter.test(password) || !number.test(password)) {
		document.querySelectorAll('span[id="pwdOk"]')[0].style.visibility ="hidden";
		document.querySelectorAll('span[id="pwd"]')[0].style.visibility ="visible";
		return false;
	}
	document.querySelectorAll('span[id="pwd"]')[0].style.visibility ="hidden";
	document.querySelectorAll('span[id="pwdOk"]')[0].style.visibility ="visible";


	return true;
}
function validateName(name)
{
	if( document.getElementsByName(name)[0].value != "" ) 
	{

		document.querySelectorAll('span[id="'+name+'Ok"]')[0].style.visibility ="visible";
		return true;
	}
	else
	{
		document.querySelectorAll('span[id="'+name+'Ok"]')[0].style.visibility ="hidden";
		return false;

	}
}
function verifyEmail(){
	document.querySelectorAll('#Submit')[0].addEventListener("click",function(){

		let xhr = new XMLHttpRequest();
		xhr.open('GET', 'http://localhost:8080/sr03_project_server/Email?email='+document.getElementsByName('email')[0].value);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		console.log(xhr.readyState);
		xhr.addEventListener('readystatechange', function() {
			if (xhr.readyState === 4) { 

				if (xhr.responseText == 'true')
				{
					document.querySelectorAll("#EmailNotif")[0].style.display = "block";
				}
				else
				{
					document.querySelectorAll('input[type=submit]')[0].click();
				}
				xhr.abort();

			}	 
		});
//		console.log(element.getAttribute('id'));
		xhr.send();

	});
}
