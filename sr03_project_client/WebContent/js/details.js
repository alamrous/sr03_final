/**
 * 
 */
document.addEventListener( 'DOMContentLoaded', function () {
	addButtonListener();
	 }, false );

function addButtonListener(){
		document.addEventListener("click",function(event){
			var element =  event.target || event.srcElement;
			console.log(element);

			if(element.classList.contains("AddPanier"))
				{
		 	   let xhr = new XMLHttpRequest();
			   xhr.open('GET', 'http://localhost:8080/sr03_project_client/AddToPanier?gameId='+element.getAttribute("id"));
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			   console.log(xhr.readyState);
			 xhr.addEventListener('readystatechange', function() {
				   if (xhr.readyState === 4) { 
				    	 xhr.abort();
				    	 document.querySelectorAll("#AddNotif")[0].style.display ="block";
				    	 setTimeout(function(){
					    	 document.querySelectorAll("#AddNotif")[0].style.display ="none";

				    	 }, 2000);
		    	    }	 
				});
//			 console.log(element.getAttribute('id'));
	    	   xhr.send();

				}
		});
	}