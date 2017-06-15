document.addEventListener( 'DOMContentLoaded', function () {
	document.querySelectorAll("#EditPwd").addEventListener("click", function(e) {
		  let xhr = new XMLHttpRequest();
		   xhr.open('GET', 'http://localhost:8080/sr03_project_client/EditPwd?oldPwd='+
				   document.querySelectorAll("input[name='pwd_old']")+'&newPwd='+document.querySelectorAll("input[name='pwd_new']"));
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		   console.log(xhr.readyState);
		 xhr.addEventListener('readystatechange', function() {
			   if (xhr.readyState === 4) { 
	    	    	// La constante DONE appartient à l'objet XMLHttpRequest, elle n'est pas globale
//			    	 father.innerHTML = father.innerHTML + xhr.responseText;
			    	 xhr.abort();
			    	 document.querySelectorAll("#AddNotif")[0].style.display ="block";
			    	 setTimeout(function(){
				    	 document.querySelectorAll("#AddNotif")[0].style.display ="none";

			    	 }, 2000);
	    	    }	 
			});
//		 console.log(element.getAttribute('id'));
   	   xhr.send();
	});
	
});