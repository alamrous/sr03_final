/**
 * 
 */

document.addEventListener( 'DOMContentLoaded', function () {
//	let email = document.querySelectorAll('input[name="email"]')[0].value;
//	let pwd = document.querySelectorAll('input[name="pwd"]')[0].value;
	document.querySelectorAll('#Connect')[0].addEventListener("click",function(){

	let xhr = new XMLHttpRequest();
	xhr.open('GET', "http://localhost:8080/sr03_project_server/Client?email="+document.querySelectorAll('input[name="email"]')[0].value+"&pwd="+document.querySelectorAll('input[name="pwd"]')[0].value);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	console.log(xhr.readyState);
	xhr.addEventListener('readystatechange', function() {
		if (xhr.readyState === 4) { 
			console.log(xhr.responseText);
			if (xhr.responseText == 'null')
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
//	console.log(element.getAttribute('id'));
	xhr.send();
	});
});