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
<script type="text/javascript">
<%@include file="js/signUp.js"%>
</script>
<title>Création de Compte</title>
</head>
<body style="padding: 70px">

<%@ include file="header.jsp"%>
<h1>Création de compte</h1>
<div class="row">
<div class="col-md-5 col-md-offset-3">
<span style="color : red"> * Champs Obligatoires</span>
<br/>
<form action="AddClient" method="GET">
<label>Email<span style="color : red">*</span>
<span style="color :green;visibility: hidden" id="emailOk">Email Ok</span>
</label>
<input type="text" name="email" class="form-control"/>
<span style="color :red; visibility: hidden"  id="emailUsed"> Email déjà utilisée</span>
<br/>
<span style="color :red;visibility: hidden" id="email"> Format incorrect de l'email</span>

<br/>
<label>Password<span style="color : red">*</span>
<span style="color :green;visibility: hidden" id="pwdOk">Password Ok </span>

</label>
<input type="password" name="pwd" class="form-control"/>
<span style="color :red;visibility: hidden" id="pwd"> Le mot de passe doit contenir au moins une majuscule et un chiffre </span>

<br/>
<label>Name<span style="color : red">*</span>
<span style="color :green;visibility: hidden" id="nameOk">Name Ok</span>
</label>
<input type="text" name="name" class="form-control"/>

<br/>
<label>FirstName<span style="color : red">*</span>
<span style="color :green;visibility: hidden" id="firstnameOk">FirstName Ok</span>

</label>
<input type="text" name="firstname" class="form-control"/>

<br/>
<label>Pseudo</label>
<input type="text" name="pseudo" class="form-control"/>
<br/>
<label>Address</label>
<input type="text" name="adress" class="form-control"/>
<br/>
<label>Birthdate</label>
<input type="text" name="birthdate" class="form-control"/>
<br/>
<label>Gender</label>
<div class="form-check">
  <label class="form-check-label">
    <input class="form-check-input" type="radio" name="gender" value="M" checked>
M
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input class="form-check-input" type="radio" name="gender" value="F">
F  </label>
</div>

<br/>
<input type="submit" value="M'enregistrer" class="btn btn-lg btn-primary btn-block" style="display: none;"/>
</form>
<button class="btn btn-lg btn-primary btn-block" id="Submit" style="display: block;">M'enregistrer</button>
<div class="row alert alert-danger" id="EmailNotif"style="text-align: center; display: none"><strong>Email deja utilisée</strong></div>
</div>
</div>
</body>
</html>