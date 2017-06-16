<%@page import="beans.Jeu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Jeu[] liste = (Jeu[]) request.getAttribute("liste");

	int i = 0;
	for (i = 0; i < liste.length; i++) {
%>
<div class="card"
	style="border: 1px solid grey; width: 20rem;margin-left: 5%; margin-bottom: 5%; border-radius: 5%; overflow-x: hidden; display: inline-block;">
	<img class="card-img-top" src="<%=liste[i].getImg_url()%>"
		alt="Card image cap" style="width: 200px; height: 200px;">
	<div class="card-block">
		<h4 class="card-title" style="color: #286090;margin-left: 2%;"><%=liste[i].getTitle()%>
		<span class="badge badge-info" style="background-color: #286090;margin: auto 0;"><%=liste[i].getPrix()%>
				€ </span>
		</h4>
	</div>

	<ul class="list-group list-group-flush" style="display: inline;">
		<li class="list-group-item">
			<p>
				<%=liste[i].getPlateforme().getName()%>
				<span class="badge badge-warning" style="background-color: #f0ad4e;"><%=liste[i].getFk_pegi().getDescription()%></span>

			</p>
			<p>
				<%=liste[i].getFk_editeur().getDescription()%>(<%=liste[i].getFk_editeur().getCountry_fk().getNom()%>)
			</p>
		</li>


	</ul>

	<div class="card-block" style="    text-align: center;    margin-bottom: 5%;    margin-top: 5%;">
		<%
			if (request.getSession().getAttribute("client") != null) {
		%>
		<button class="btn btn-success AddPanier" style="margin-right: 10%;"
			id="<%=liste[i].getPlateforme_jeu_fk()%>">Ajouter</button>
		<form action="Game" method="GET" style="    display: inline;">
			<input type="hidden" name="id"
				value="<%=liste[i].getPlateforme_jeu_fk()%>"> 
				<input	type="submit" class="btn btn-info" value="Details">
		</form>
		<%} %>
	</div>
</div>
<% } %>