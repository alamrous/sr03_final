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

<div class="col-md-4" style="padding-bottom: 5%;background-color: #e8e8e8;border-radius: 10px;" id="SearchBar">
<%@ include file="SearchFields.jsp" %>
</div>
<div class="col-md-8" id="TableView">
<div class="row alert alert-success" style="display:none; text-align:center;" id="AddNotif"><strong>Ajout de l'article au Panier</strong></div>
<!-- <h2>Liste des jeux</h2> -->
  <h1 style="    padding-top: 3%;    padding-left: 2%;    color: #333; background-color: #e8e8e8;border-radius: 5px;">Liste des jeux</h1>

<!-- <table class="table" id="GameTable"> -->
<!-- </table> -->
<div class="row" id="GameTable" style="    margin-left: 1%;">

</div>
</div>
</div>
</div>
</div>
</body>
</html>