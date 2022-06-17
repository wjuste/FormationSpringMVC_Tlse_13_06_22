<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajouter un User</title>
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" context="/springmvc"/>"/>
</head>
<body>
	
	<!-- 
		Dans le formulaire il faut associer un modelAttribut qui est formuser 
		modelAttribut : Les données qu'on va saisir ici, seront stockées dans l'objet formuser 
		Les données qui s'affiche dans le formulaire correspond à l'objet formuser qui represente un user 
		
		form:label  ==> on affiche le label ==>  Prénom
		form:input  ===> On affiche un champs de saisie 
		path : la donnée qui va être saisie correspond à un attribut de la classe User (ici prenom) 
		form:errors ==> Les méssages d'erreurs seront affiché 
						Le message d'erreur va être affiché en rouge
		
	 -->
	<c:url value="/admin/users/add" context="/springmvc" var="urladd" />
	<form:form method="post" action="${urladd}" modelAttribute="formuser">
		<div class="form-group col-md-8 offset-md-2">
			<div class="mt-2">
				<form:label path="prenom">Prénom</form:label>
				<form:input path="prenom" class="form-control"/>
				<form:errors path="prenom" class="small text-danger"/>
			</div>
		</div>
		<div class="form-group col-md-8 offset-md-2">
			<div class="mt-2">
				<form:label path="nom">Nom</form:label>
				<form:input path="nom" class="form-control"/>
				<form:errors path="nom" class="small text-danger"/>
			</div>
		</div>
		<div class="form-group col-md-8 offset-md-2">
			<div class="mt-2">
				<form:label path="email">Email</form:label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="small text-danger"/>
			</div>
		</div>
		<div class="form-group col-md-8 offset-md-2">
			<div class="mt-2">
				<form:label path="password">Mot de passe</form:label>
				<form:input path="password" class="form-control"/>
				<form:errors path="password" class="small text-danger"/>
			</div>
		</div>
		
		<div class="form-group col-md-8 offset-md-2">
			<button type="submit" class="btn btn-success btn-lg float-right btn-block">Ajouter</button>
		</div>
	</form:form>
	
</body>
</html>