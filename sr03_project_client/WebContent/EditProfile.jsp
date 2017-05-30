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
<title>Edition Compte</title>
</head>
<body style="padding: 70px">
<%@ include file="header.jsp"%>

<% Client client = (Client)request.getSession().getAttribute("client"); %>

<h1>Edition de votre compte</h1>
<div class="row">
<div class="col-md-5 col-md-offset-3">
<form action="EditProfile" method="GET">
<label>Name</label>
<input type="text" name="name" 
<%if(client.getName().equals("") == false){%>value="<%= client.getName()%>"<%} %>class="form-control"/>
<br/>
<label>FirstName</label>
<input type="text" name="firstname"
<%if(client.getFirstname().equals("") == false){%>value="<%= client.getFirstname()%>"<%} %> class="form-control" />
<br/>
<label>Pseudo</label>
<input type="text" name="pseudo" <%if(client.getPseudo().equals("") == false){%>value="<%= client.getPseudo()%>"<%} %>
class="form-control"/>
<br/>
<label>Adresse</label>
<input type="text" name="adress" 
<%if(client.getAddress().equals("") == false){%>value="<%= client.getAddress()%>"<%} %>
class="form-control"/>
<br/>
<label>Email</label>
<input type="text" name="email" value="<%=client.getEmail()%>" class="form-control"/>
<br/>
<label>Date de naissance</label>
<input type="text" name="birthdate" <%if(client.getBirthdate() != null){%>value="<%= client.getBirthdate()%>"<%} %> class="form-control"/>
<br/>
<label>Sexe</label>
<label>M</label>
<div class="form-check">
  <label class="form-check-label">
    <input class="form-check-input" type="radio" name="gender" value="M" <% if (client.getGender() == 'M') { %> checked="checked"<%} %>>
M
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input class="form-check-input" type="radio" name="gender" value="F"<% if (client.getGender() == 'F') { %> checked="checked"<%} %>>
F  </label>
</div>

<input type="submit" class="form-control btn btn-primary" value="Editer"/>
</form>
</div>
</div>
</body>
</html>