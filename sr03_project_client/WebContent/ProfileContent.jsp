<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Client client = (Client) request.getSession().getAttribute("client"); %>

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
<td><% if(client.getBirthdate() != null)%><%=client.getBirhtdateInStringFormat()%><%else {%>Non défini<%}%></td>
</tr>
<tr>
<th>Adresse</th>
<td><% if(client.getAddress() != null && client.getAddress().equals("") == false)%><%=client.getAddress()%><%else {%>Non défini<%}%></td>
</tr>
</table>