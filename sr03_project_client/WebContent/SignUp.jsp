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
	<form action="AddClient" method="GET">
		<div class="row">
			<div class="col-md-5 col-md-offset-1">
<!-- 				<span style="color: red"> * Champs Obligatoires</span> <br /> -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Champs Obligatoires</h3>
					</div>
					<div class="panel-body">
						<%@ include file="OptionnalFields.jsp"%>
					</div>
				</div>

			
			</div>
			<div class="col-md-5 col-md-offset-1">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Champs Optionnels</h3>
					</div>
					<div class="panel-body">
						<%@ include file="ObligatoryFields.jsp"%>
					</div>
				</div>
			</div>
			</div>
			
			<div class="row" style="    text-align: -webkit-center;">
				<input type="submit" value="M'enregistrer"
					class="btn btn-lg btn-primary btn-block" style="display: none;" />
				<button class="btn btn-lg btn-primary btn-block" id="Submit" style="display: block;width: 20%;">M'enregistrer</button>
				<div class="row alert alert-danger" id="EmailNotif"
					style="text-align: center; display: none">
					<strong>Email deja utilisée</strong>
				</div>
			</div>
	</form>
</body>
</html>