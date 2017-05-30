<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.css" %>
    <%@include file="bootstrap/css/bootstrap-theme.css" %>    
</style>
<title>Mon Compte</title>
</head>
<%@ include file="header.jsp"%>
<body style="padding-top: 70px;">
<% Client client = (Client) request.getSession().getAttribute("client"); %>
<!-- <a href="ClientPanierShow">Mes achats</a> -->
<!-- <a href="ClientPanierShow">Mon Panier</a> -->
<h1> Mes informations</h1>
<div class="row">
<div class="col-md-5 col-md-offset-6">
<a href="ChangePwd" method="POST">
<button class="btn btn-primary">
Modifier le mot de passe
</button>
</a>
<a href="EditProfile.jsp">
<button class="btn btn-info">
Editer Mon Profil
</button>
</a>
</div>
</div>
<div class="row">
<div class="col-md-3 col-md-offset-3" style="
    border-radius: 10px;
    background-color: rgba(220, 220, 220, 0.56);">
<table style="border-collapse: separate;border-spacing:0 5px;">
<tr>
<th>Nom</th>
<td><% if(client.getName().equals("") == false)%><%=client.getName()%><%else {%>Non défini<%}%></td>
</tr>
<tr>
<th>Prénom</th>
<td><% if(client.getFirstname().equals("") == false)%><%=client.getFirstname()%><%else {%>Non défini<%}%></td>
</tr>
<tr>
<th>Email</th>
<td><%= client.getEmail() %></td>
</tr>
<tr>
<th>Pseudo</th>
<td><% if(client.getPseudo() != null && client.getPseudo().equals("") == false)%><%=client.getPseudo()%><%else {%>Non défini<%}%></td>
</tr>
<tr>
<th>Sexe</th>
<td><%= client.getGender() %></td>
</tr>
<tr>
<th>Date de naissance</th>
<td><% if(client.getBirthdate() != null)%><%=client.getBirthdate()%><%else {%>Non défini<%}%></td>
</tr>
<tr>
<th>Adresse</th>
<td><% if(client.getAddress() != null && client.getAddress().equals("") == false)%><%=client.getAddress()%><%else {%>Non défini<%}%></td>
</tr>
</table>

</div>
</div>
</body>
</html>