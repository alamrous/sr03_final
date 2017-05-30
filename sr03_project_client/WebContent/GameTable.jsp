<%@page import="beans.Jeu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <tr>
<th>Titre</th>
<th>Pegi</th>
<th>Note</th>
<th>Editeur</th>	
<th>Pays</th>
<th>Plateforme</th>
<th>Prix</th>
<% if(request.getSession().getAttribute("client") != null){ %>
<th> Action </th>
<%} %>
</tr> 
<% 
try{
Jeu[] liste = (Jeu[])request.getAttribute("liste"); 
}

catch(Exception e){
 System.out.print(e.toString());	
}
Jeu[] liste = (Jeu[])request.getAttribute("liste"); 
%>
<% int  i = 0; 
for (i=0; i<liste.length; i++){
	%><tr>
	<td>
	<%=
	liste[i].getTitle()
	%>
	</td>
	<td><%=  liste[i].getFk_pegi().getDescription()%></td>
	<td><%=  liste[i].getNote()%></td>
	<td><%=  liste[i].getFk_editeur().getDescription()%></td>
	<td><%=  liste[i].getFk_editeur().getCountry_fk().getNom()%></td>
	<td><%=  liste[i].getPlateforme().getName()%></td>
	<td><%=  liste[i].getPrix()%></td>
	<% if(request.getSession().getAttribute("client") != null){ %>
<td>
<div class="col col-md-5">
<button class="btn btn-success AddPanier" id="<%= liste[i].getPlateforme_jeu_fk()%>">Ajouter</button>
</div>
<div class="col col-md-5">

 <form action="Game" method="GET">
<input type="hidden" name="id" value="<%= liste[i].getPlateforme_jeu_fk()%>">
<input type="submit" class="btn btn-info" value="Details"></button>
</form> 
</div>

</td>
<%} %>
</tr> 
						
			
			
	</tr>
<% } %>