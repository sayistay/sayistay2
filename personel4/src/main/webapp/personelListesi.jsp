<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personel Listesi</title>
</head>
<body>
<table border="1">
  <thead>
  	<tr>
  		<th>Sicil</th>
  		<th>Adı</th>
  		<th>Soyadı</th>
  	</tr>
  </thead>
  <tbody>
	<c:forEach var="personel" items="${liste}">
	  <tr>
	  	<td>${personel.id}</td>
	  	<td>${personel.adi}</td>
	  	<td>${personel.soyadi}</td>
	  </tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>