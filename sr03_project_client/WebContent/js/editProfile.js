/**
 * 
 */

document.addEventListener( 'DOMContentLoaded', function () {
	document.querySelectorAll('input[type=submit]')[0].disabled = true;
	checkObligatoryInputs();
	 }, false );
	function checkObligatoryInputs(){
	
		document.querySelectorAll('form')[0].addEventListener("change",function(){
			if(document.getElementsByName('email')[0].value == ""
				|| document.getElementsByName('name')[0].value == ""
					||  document.getElementsByName('firstname')[0].value == "" 
						)
			{
				document.querySelectorAll('input[type=submit]')[0].disabled = true;

			}
			if( validateEmail(document.getElementsByName('email')[0].value)
				&& validateName("name")	&& validateName("firstname")
					 )
			{
			document.querySelectorAll('input[type=submit]')[0].disabled = false;
			}
		});

	}
	function validateEmail(email) {
	if(	document.getElementsByName('email')[0].value == "") 
		{
		  document.querySelectorAll('span[id="emailOk"]')[0].style.visibility ="hidden";
		  document.querySelectorAll('span[id="email"]')[0].style.visibility ="visible";
		return false; 
		}
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
