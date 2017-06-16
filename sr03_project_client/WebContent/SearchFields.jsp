<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<!-- <tr> -->
<!-- <th>Annee</th> -->
<!-- <td><input type="text" name="year" class="form-control"/></td> -->
<!-- </tr> -->
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