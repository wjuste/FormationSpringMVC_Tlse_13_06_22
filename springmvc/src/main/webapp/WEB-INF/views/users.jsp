<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des utilisateurs</title>
<!--  context est utilisé pour sépcifier l'application (ou le nom du projet)-->
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" context="/springmvc"/>"/>
</head>
<body>
	<h1 class="mb-5">Liste des utilisateurs</h1>
	
	<table class="table table-hover col-xl-6 col-lg-6" style="margin-left:20px">
		<thead class="card-header" style="background-color:#C887D">
			<tr>
				<th>Prenom</th>
				<th>Nom</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
			</tr>
		</thead>
		<tbody  style="background-color:#F5F6F2">
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.prenom}</td>
				<td>${u.nom}</td>
				<td>${u.email}</td>
				<td>${u.role}</td>
				
				<!-- var: Nom de la variable pour stocker l'url formatée (url résultante) 
				"/admin/users/delete/1"  dont ${u.id} = 1
				-->
				<td>
					<c:url  value="/admin/users/delete/${u.id}"  context="/springmvc" var="urldelete" />
					<a href="${urldelete}"  onclick="return confirm('Are you sure?')"> Delete</a>
				</td>
			</tr>
			
		</c:forEach>
		</tbody>
	</table>
</body>
</html>