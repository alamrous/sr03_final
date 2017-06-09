<%@page import="beans.Jeu"%>
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
<script type="text/javascript">
<%@include file="js/details.js"%>
</script>
<title>Détails jeu</title>
</head>
<body style="padding: 70px">
<%@ include file="header.jsp"%>

<% Jeu jeu = (Jeu)request.getAttribute("jeu"); %>
<h1>Détails de <%= jeu.getTitle() %> (<%= jeu.getPlateforme().getName() %>)</h1>
<div class="row">
<div class="col-md-3">
<img src=""/>
</div>
<div class="col-md-5" style="    border-radius: 10px;    background-color: rgba(220, 220, 220, 0.56);">
    <table style="border-collapse: separate;border-spacing:0 10px;">
    <tr>
<th>Titre</th>
<td style="    width: 100%;    text-align: center;"> 
<%= jeu.getTitle() %>
</td>
</tr>
<tr>
<th>Résumé</th>
<td style="    width: 100%;    text-align: center;"> 
<%= jeu.getSummary() %></td>
</tr>
<tr>
<th>Editeur</th>
<td style="    width: 100%;    text-align: center;"> 
<%= jeu.getFk_editeur().getDescription() %>(<%=jeu.getFk_editeur().getCountry_fk().getNom() %>)
</td>
</tr>
<tr>
<th>Plateforme</th>
<td style="    width: 100%;    text-align: center;"> 

<%=jeu.getPlateforme().getName() %></td>
</tr>
<tr>
<th>Prix</th>
<td style="    width: 100%;    text-align: center;"> 
<%= jeu.getPrix() %>€</td>
</tr>
<tr>
<th>Note de la rédaction</th>
<td style="    width: 100%;    text-align: center;color: 
<%if(jeu.getNote()<10){ %>red<%}else if(jeu.getNote()<15){ %> orange<%}else{ %> green<%} %>" > 
<%= jeu.getNote() %> / 20
</td>
</tr>
<% if(request.getSession().getAttribute("client") != null){ %>
<tr>
<th></th>	
<td style="    width: 100%;    text-align: right;"> 
<button class="btn btn-success AddPanier" id="<%= jeu.getPlateforme_jeu_fk()%>">Ajouter</button>

</td>
</tr>
<%} %>
    </table>
    

</div>
</div>
</body>
</html>