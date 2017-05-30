/**
 * 
 */

document.addEventListener( 'DOMContentLoaded', function () {
	checkObligatoryInputs();
	 }, false );
	function checkObligatoryInputs(){
		let email = document.getElementsByName('email')[0].value;
		let name = document.getElementsByName('name')[0].value;
		let firstname = document.getElementsByName('firstname')[0].value;
		let pwd = document.getElementsByName('pwd')[0].value;
		if(email == "" || name == "" || firstname == "" || pwd == "")
			{
			document.querySelectorAll('input[type=submit]')[0].disabled = true;
			}
		document.querySelectorAll('form')[0].addEventListener("change",function(){
			console.log("changement");
			if( validateEmail(document.getElementsByName('email')[0].value)
					&& validatePwd(document.getElementsByName('pwd')[0].value)
				&& validateName("name")	&& validateName("firstname")
					 )
			{
			document.querySelectorAll('input[type=submit]')[0].disabled = false;
			}
		});

	}
	function validateEmail(email) {
	if(	document.getElementsByName('email')[0].value == "") return false; 
		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		  if( re.test(email) == false && email != ""){
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
		if( document.getElementsByName('pwd')[0].value == "") return false;
		console.log("ici");
	    var allLetters = /^[a-zA-Z]+$/;
	    var letter = /[a-zA-Z]/;
	    var number = /[0-9]/;
	    if (password.length < 4 || !letter.test(password) || !number.test(password)) {
			  document.querySelectorAll('span[id="pwd"]')[0].style.visibility ="visible";
			  console.log("probleme");
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
