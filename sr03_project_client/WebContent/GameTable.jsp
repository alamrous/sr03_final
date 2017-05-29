<%@page import="beans.Jeu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!--  <form action="PanierAction" method="post"> -->
<%-- <input type="hidden" name="productId" value="<%= liste[i].getPlateforme_jeu_fk()%>"> --%>
<button class="btn btn-success AddPanier" id="<%= liste[i].getPlateforme_jeu_fk()%>">Ajouter</button>
<!-- </form>  -->
</td>
<%} %>
</tr> 
						
			
			
	</tr>
<% } %>