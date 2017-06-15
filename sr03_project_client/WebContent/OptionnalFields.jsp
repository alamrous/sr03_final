<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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