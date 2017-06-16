<%@page import="java.text.SimpleDateFormat"%>
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
<!-- <a href="ClientPanierShow">Mes achats</a> -->
<!-- <a href="ClientPanierShow">Mon Panier</a> -->
<h1> Mes informations</h1>

<div class="row" >
<div class="col-md-3">
<img src="http://www.slate.com/content/dam/slate/blogs/moneybox/2014/12/15/the_russian_ruble_is_in_freefall_thanks_north_dakota/145536434-russian-president-vladimir-putin-speaks-during-a-press.jpg.CROP.promo-mediumlarge.jpg" style="width: 200px;height: 200px;margin-left: 5%;border-radius: 50%;">
</div>
<div class="col-md-3" style="
    border-radius: 10px;
    background-color: rgba(220, 220, 220, 0.56);" id="ProfilDiv">
    <%@include file="ProfileContent.jsp" %>

</div>
<div class="col-md-5" style="display: flex;flex-direction: column-reverse;">
<a href="EditPwd.jsp" method="POST" style="margin-top: 10px;">
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
</body>
</html>