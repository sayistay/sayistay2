<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yazar Listesi</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body class="m-4">

<form action="<c:url value="/yazarYarat.jsp" />" method="post">
	<button type="submit" class="btn btn-primary">Yazar Yarat</button>
</form>
<table class="table table-striped mt-4">
	<tr>
	   <th>Sicil</th>
	   <th>Adı</th>
	   <th>Soyadı</th> 
	   <th>Doğum Tarihi</th>
	   <th>Kitap Sayısı</th>
	</tr>
	<c:forEach items="${yazarListesi}" var="yazar">
		<tr>
		  <td>${yazar.id}</td>
		  <td>${yazar.adi}</td>
		  <td>${yazar.soyadi}</td>
		  <td>${yazar.dogumTarihi}</td>
		  <td>${fn:length(yazar.kitaplar)}</td>
		</tr> 
	</c:forEach>
</table>
</body>
</html>