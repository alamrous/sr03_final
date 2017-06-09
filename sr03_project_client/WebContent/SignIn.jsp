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
<%@include file="js/signIn.js"%>
</script>
<title>ConnexionCompte</title>
</head>
<%@ include file="header.jsp"%>

<body style="padding: 70px">
<h1> S'authentifier</h1>
<div class="row alert alert-danger" id="EmailNotif"style="text-align: center; display: none"><strong>Email ou Pwd erronés</strong></div>
<div class="row">
<div class="col-md-3 col-md-offset-4" style="background-color: #e8e8e8;border-radius: 10px;padding-top: 30px;padding-bottom: 50px;">
<form action="ConnectClient" method="get">
<label>Email</label>
<input type="text" name="email" class="form-control"/>
<br/>
<label>Password</label>
<input type="password" name="pwd" class="form-control"/>
<br/>
<input type="submit" class="form-control btn btn-primary" value="Connexion"  style="display: none;"/>
</form>
<button class="btn btn-primary" id="Connect">Connexion</button>

</div>
</div>
</body>
</html>