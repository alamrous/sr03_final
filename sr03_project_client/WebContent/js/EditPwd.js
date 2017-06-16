document.addEventListener( 'DOMContentLoaded', function () {
	document.querySelectorAll("#EditPwd")[0].addEventListener("click", function(e) {
		console.log("ici");
		  let xhr = new XMLHttpRequest();
		   xhr.open('GET', 'http://localhost:8080/sr03_project_client/EditPwd?oldPwd='+
				   document.querySelectorAll("input[name='pwd_old']")[0].value+'&newPwd='+
				   document.querySelectorAll("input[name='pwd_new']")[0].value);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		   console.log(xhr.readyState);
		 xhr.addEventListener('readystatechange', function() {
			   if (xhr.readyState === 4) { 
	    	    	// La constante DONE appartient à l'objet XMLHttpRequest, elle n'est pas globale
//			    	 father.innerHTML = father.innerHTML + xhr.responseText;
				   if(xhr.responseText != 'false')
					   {
					   document.querySelectorAll("a[href='Profile.jsp']")[0].click();
					   }
				   else
					   {
					   document.querySelectorAll("#PwdError")[0].style.display = " block";
					   }
			    console.log(xhr.responseText);
	    	    }	 
			});
//		 console.log(element.getAttribute('id'));
   	   xhr.send();
	});
	
});