<%@page import="beans.Client"%>
<%@page import="java.text.DateFormat"%>
<%@page import="beans.Panier"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="js/test.js"></script> -->
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.css" %>
    <%@include file="bootstrap/css/bootstrap-theme.css" %>    
</style>
<title>Mon panier</title>
</head>
<body style="padding: 70px">
<%@ include file="header.jsp"%>

<h1>Mon panier</h1>
<div class="row">
<div class="col col-8 col-md-offset-2">
<%Panier[] panier = null; 	
Client client= (Client) request.getSession().getAttribute("client");
request.getSession().removeAttribute("isConnected");
Panier[] achats= null;
if ((panier =(Panier[]) request.getSession().getAttribute("panier")) != null){ %>
<table class="table">
<tr>
<th>Id</th>
<th> Jeu </th>
<th> Plateforme </th>
<th> Date d'ajout </th>
<th> Prix </th>
<th>Actions</th>
</tr>
<% for(int i=0; i<panier.length; i++){ %>
<tr>
<td> <%= panier[i].getId() %> </td>
<td> <%= panier[i].getJeu().getTitle() %> </td>
<td> <%= panier[i].getJeu().getPlateforme().getName() %> </td>
<td> <%= panier[i].getDate_creation() %> </td>
<td> <%= panier[i].getJeu().getPrix() %> </td>
<td> <form action="RemoveFromPanier" method="GET">
<input type="hidden" name="item_id" value="<%= panier[i].getId() %>">
 <input type="submit" class="btn btn-danger" value="Supprimer"></form></td>
</tr>

<%} %>

</tr>
</table>

</div>
</div>
<div class="row">
<div class="col-md-offset-3 col-md-3">
 <h3>Total</h3> 
</div>
<div class="col-md-offset-3 col-md-1">
<h3>
<%= request.getSession().getAttribute("total") %>€
</h3>
</div>
<div class="col-md-2">
<form action="BuyPanier" method="POST"><input type="submit" value="Acheter" class="btn btn-success"></form>
</div>
</div>
<%} %>

<h2> Achats effectués</h2>
<% if((achats =(Panier[]) request.getSession().getAttribute("achats")) !=null){ %>
<div class="row">
<div class="col-md-9 col-md-offset-2">
<table class="table">
<tr>
<th> Jeu </th>
<th> Plateforme </th>
<th> Date d'achat </th>
<th> Prix </th>
</tr>
<% for(int i=0; i<achats.length; i++){ %>
<tr>
<td> <%= achats[i].getJeu().getTitle() %> </td>
<td> <%= achats[i].getJeu().getPlateforme().getName() %> </td>
<td> <%= achats[i].getDate_achat() %> </td>
<td> <%= achats[i].getJeu().getPrix() %> </td>
</tr>

<%} %>
</tr>
</table>

</div>
</div>
<% } %>
</body>
</html>