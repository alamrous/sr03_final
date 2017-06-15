<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editer Mon MDP</title>
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.css" %>
    <%@include file="bootstrap/css/bootstrap-theme.css" %>    
</style>
<script type="text/javascript">
<%@include file="js/EditPwd.js"%>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="padding-top: 70px;">
<%@ include file="header.jsp"%>
<div class="well well-md col col-md-5 col-md-offset-3">
<p style="color: red; display: none;" id="PwdError">Mot de passe incorrect</p>
<label>Ancien Mot de Passe</label>
<input type="password" name="pwd_old" class="form-control" placeholder="Entrer l'ancien mot de passe" />
<br/>
<label>Nouveau Mot de Passe</label>
<input type="password" name="pwd_new" class="form-control" placeholder="Entrer le nouveau mot de passe"/>
<br/>
<button class="form-control btn btn-primary" id="EditPwd"> Modifier</button>
</div>
</body>
</html>