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
<c:if test="${not empty mesaj}">
<div class="alert alert-primary">
  ${mesaj}
</div>
</c:if>

<form action="<c:url value="/yazarYarat.jsp" />" method="post">
	<button type="submit" class="btn btn-outline-success">Yazar Yarat</button>
</form>
<form action="<c:url value="/yazarGuncelle" />" method="get">
	<table class="table table-striped mt-4">
		<tr>
		   <th></th>
		   <th><div class="text-center">Sicil</div></th>
		   <th><div class="">Adı</div></th>
		   <th><div class="">Soyadı</div></th> 
		   <th><div class="text-center">Doğum Tarihi</div></th>
		   <th><div class="text-center">Kitap Sayısı</div></th>
		</tr>
		<c:forEach items="${yazarListesi}" var="yazar">
			<tr>
			  <td>
			    <div class="form-check">
				  <input class="form-check-input" type="radio" name="seciliYazar" value="${yazar.id}">
				</div>
			  </td>
			  <td><div class="text-center">${yazar.id}</div></td>
			  <td>${yazar.adi}</td>
			  <td>${yazar.soyadi}</td>
			  <td><div class="text-center">${yazar.dogumTarihi}</div></td>
			  <td><div class="text-center"><a href="<c:url value="/kitaplar" />?id=${yazar.id}">${fn:length(yazar.kitaplar)}</a></div></td>
			</tr> 
		</c:forEach>
	</table>
	<button type="submit" class="btn btn-outline-danger" name="islem" value="sil">Sil</button>
	<button type="submit" class="btn btn-outline-primary" name="islem" value="guncelle">Güncelle</button>
</form>
</body>
</html>