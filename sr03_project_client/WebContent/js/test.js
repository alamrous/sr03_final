/**
 * 
 */
document.addEventListener( 'DOMContentLoaded', function () {
	addButtonListener();
	showGameList();
	 }, false );



	function showGameList(){
	 	 let father = document.getElementById('GameTable');
	 	 let div_father=document.getElementById('TableView');
 	   let xhr = new XMLHttpRequest();
	   xhr.open('POST', 'http://localhost:8080/sr03_project_client/getAllGame');
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	   console.log(xhr.readyState);
	 xhr.addEventListener('readystatechange', function() {
		   if (xhr.readyState === 4) { 
    	    	// La constante DONE appartient à l'objet XMLHttpRequest, elle n'est pas globale
		    	 father.innerHTML = father.innerHTML + xhr.responseText;
		    	 xhr.abort();
    	    }	 
		   
	 });
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
				    	 alert("Ajout effectué");

		    	    }	 
				});
//			 console.log(element.getAttribute('id'));
	    	   xhr.send();

				}
		});
	}

  

/*var query = document.querySelector("#AddPanier").

$(document).ready(function(){

	$('#AddPanier').on("click",function(){
		$('#TableView').prepend('<div class="alert alert-success"> Un nouveau jeu ajouté au Panier !</div>');
	});
	$('#searchGame').on("click",function(){
		var titre = null;
		if($('input[name="title"]').val()!="")
			{
			titre = $('input[name="title"]').val()
			}
		var plateforme = $('select[name="plateforme"] option:selected').val();
		
		var year =null;
		if ($('input[name="year"]').val() != "")
			{
			year=$('input[name="year"]').val();
			}
		var editeur = $('select[name="editeur"] option:selected').val();
		
		var priceMin =null;
		if($('input[name="minPrice"]').val() != "")
			{
			priceMin=$('input[name="minPrice"]').val();
			}
		var maxPrice = null;
		if($('input[name="maxPrice"]').val() != "")
			{
			maxPrice=$('input[name="maxPrice"]').val();
			}
console.log(maxPrice == null);
		$.get('SearchGame',{title:titre,plateforme:plateforme,year:year,editeur:editeur,priceMin:priceMin,priceMax:maxPrice},function(data){
			$('#TableView').hide(500).empty().append(data).show(100);
		});});
	});*/
