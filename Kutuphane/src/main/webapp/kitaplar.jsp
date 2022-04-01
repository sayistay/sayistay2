<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kitap Listesi</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body class="m-4">
<h3>${yazar.adi} ${yazar.soyadi}</h3> 
<table class="table table-striped mt-4">
	<tr>
	   <th>Adı</th>
	   <th>Sayfa Sayısı</th>
	</tr>
	<c:forEach items="${kitapListesi}" var="kitap">
		<tr>
		  <td>${kitap.adi}</td>
		  <td>${kitap.sayfaSayisi}</td>
		</tr> 
	</c:forEach>
</table>
<form action="<c:url value="/" />">
	<button type="submit" class="btn btn-outline-warning mt-2">Geri</button>
</form>
</body>
</html>