/**
 * 
 */
document.addEventListener( 'DOMContentLoaded', function () {
	addButtonListener();
	showGameList();
	blockSearchButton();
	searchGame();
	 }, false );


	function blockSearchButton(){
		   document.querySelectorAll('#SearchBar')[0].addEventListener("change",function(){
			   let title = document.querySelectorAll('[name="title"]')[0].value
		       let plateforme = document.querySelectorAll('[name="plateforme"]')[0].value
//		       let year = document.querySelectorAll('[name="year"]')[0].value
		       let minPrice = document.querySelectorAll('[name="minPrice"]')[0].value
		       let maxPrice = document.querySelectorAll('[name="maxPrice"]')[0].value
		       let editeur = document.querySelectorAll('[name="editeur"]')[0].value
		       if(title != "" ||plateforme != "" ||minPrice != "" ||maxPrice != "" ||editeur != "" ){
		    	   document.querySelectorAll('#searchGame')[0].disabled = false;
		       }
		       else
		    	   {
		    	   document.querySelectorAll('#searchGame')[0].disabled = true;
		    	   document.getElementById('GameTable').innerHTML= "";
		    	   showGameList();
		    	   }
		   });
	}
	function showGameList(){
	 	 let father = document.getElementById('GameTable');
	 	 let div_father=document.getElementById('TableView');
 	   let xhr = new XMLHttpRequest();
	   xhr.open('POST', 'http://localhost:8080/sr03_project_client/getAllGame');
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	   console.log(xhr.readyState);
	 xhr.addEventListener('readystatechange', function() {
		   if (xhr.readyState === 4) { 
			   document.getElementById('GameTable').innerHTML= "";
			   father.innerHTML = father.innerHTML + xhr.responseText;
		    	 xhr.abort();
    	    }	 
		   
	 });
	   document.getElementById('GameTable').innerHTML= 
		   "<div class=\"row alert alert-info\" style=\"text-align: center\"><h3>Loading ...</h3></div>";

	   xhr.send();
	}
	function addButtonListener(){
		document.addEventListener("click",function(event){
			var element =  event.target || event.srcElement;
			console.log(element);

			if(element.classList.contains("AddPanier"))
				{
			 	 let father = document.getElementById('GameTable');
			 	 let div_father=document.getElementById('TableView');
		 	   let xhr = new XMLHttpRequest();
			   xhr.open('GET', 'http://localhost:8080/sr03_project_client/AddToPanier?gameId='+element.getAttribute("id"));
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			   console.log(xhr.readyState);
			 xhr.addEventListener('readystatechange', function() {
				   if (xhr.readyState === 4) { 
		    	    	// La constante DONE appartient à l'objet XMLHttpRequest, elle n'est pas globale
//				    	 father.innerHTML = father.innerHTML + xhr.responseText;
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
	function searchGame(){

	    document.querySelectorAll('#searchGame')[0].addEventListener("click",function(){
		 	 let father = document.getElementById('GameTable');

	       let title = document.querySelectorAll('[name="title"]')[0].value
	       let plateforme = document.querySelectorAll('[name="plateforme"]')[0].value
//	       let year = document.querySelectorAll('[name="year"]')[0].value
	       let minPrice = document.querySelectorAll('[name="minPrice"]')[0].value
	       let maxPrice = document.querySelectorAll('[name="maxPrice"]')[0].value
	       let editeur = document.querySelectorAll('[name="editeur"]')[0].value
	       let xhr = new XMLHttpRequest();
	       let query = "";
	       if(title != "") query = "?title="+title;
	       if(plateforme != "") query = (query == "")?"?plateforme="+plateforme:query+"&plateforme="+plateforme;
//	       if(year != "") query = (query == "")?"?year="+year:query+"&year="+year;
	       if(minPrice != "") query = (query == "")?"?minPrice="+minPrice:query+"&minPrice="+minPrice;
	       if(maxPrice != "") query = (query == "")?"?maxPrice="+maxPrice:query+"&maxPrice="+maxPrice;
	       if(editeur != "") query = (query == "")?"?editeur="+editeur:query+"&editeur="+editeur;
		   xhr.open('GET', 'http://localhost:8080/sr03_project_client/searchGame'+query);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		   console.log(xhr.readyState);
		 xhr.addEventListener('readystatechange', function() {
			   if (xhr.readyState === 4) { 
				   father.innerHTML = "";
	    	    	// La constante DONE appartient à l'objet XMLHttpRequest, elle n'est pas globale
				   father.innerHTML = father.innerHTML + xhr.responseText;
			    	 xhr.abort();
	    	    }	 
			   
		 });
		   xhr.send();
		   document.getElementById('GameTable').innerHTML= 
			   "<div class=\"row alert alert-info\" style=\"text-align: center\"><h3>Loading ...</h3></div>";
	       
	    });
	    }
  


