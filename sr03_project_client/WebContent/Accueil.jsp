<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*"  %>
        <%@ page import="java.util.ArrayList"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.css" %>
    <%@include file="bootstrap/css/bootstrap-theme.css" %>    
</style>
<script type="text/javascript">
<%@include file="js/accueil.js"%>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="padding-top: 70px;">
<%@ include file="header.jsp"%>
<div class="container">
<div class="row">
<div class="col-md-12">

<div class="col-md-4" style="background-color: #e8e8e8;border-radius: 10px;" id="SearchBar">
<h3> Rechercher un jeu</h3>
<form>
<table style="border-collapse: separate;border-spacing:0 5px;">
<tr>
<th>Titre</th>
<td><input type="text" name="title" class="form-control"/></td>
</tr>
<tr>
<th>Plateforme</th>
<td>
<select name="plateforme" class="form-control">
<%= request.getAttribute("plateformes") %> %>
</select>
</td>
</tr>
<tr>
<th>Annee</th>
<td><input type="text" name="year" class="form-control"/></td>
</tr>
<tr>
<th>Editeur</th>
<td>
<select name="editeur" class="form-control">
<%= request.getAttribute("editeurs") %> %>
</select>
</td>
</tr>
<tr>
<th>Prix Minimum</th>
<td><input type="number" name="minPrice" class="form-control"/></td>
</tr>
<tr>
<th>Prix Maximum</th>
<td><input type="number" name="maxPrice"/ class="form-control"></td>
</tr>
<tr>
</tr>
</table>

</form>
<button class="btn btn-lg btn-primary btn-block" id="searchGame" disabled>Rechercher</button>

</div>
<div class="col-md-8" id="TableView">
<div class="row alert alert-success" style="display:none; text-align:center;" id="AddNotif"><strong>Ajout de l'article au Panier</strong></div>
<h2>Liste des jeux</h2>
<!-- <table class="table" id="GameTable"> -->
<!-- </table> -->
<div class="row" id="GameTable">

</div>
</div>
</div>
</div>
</div>
</body>
</html>