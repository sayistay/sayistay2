<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yazar Güncelle</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body class="m-4">

<form action="<c:url value="/yazarGuncelle" />" method="post">
    <input type="hidden" name="id" value="${yazar.id}" />
	<div class="mb-3 row">
    <label for="adi" class="col-sm-2 col-form-label">Adı</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="adi" name="adi" value="${yazar.adi}">
    </div>
  	</div>
	<div class="mb-3 row">
    <label for="soyadi" class="col-sm-2 col-form-label">Soyadı</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="soyadi" name="soyadi" value="${yazar.soyadi}">
    </div>
  	</div>
	<div class="mb-3 row">
    <label for="dtarihi" class="col-sm-2 col-form-label">Doğum Tarihi</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="dtarihi" name="dtarihi" value="${yazar.dogumTarihi}">
    </div>
  	</div>
	<button type="submit" class="btn btn-outline-primary">Yazar Güncelle</button>
</form>
<form action="<c:url value="/" />">
	<button type="submit" class="btn btn-outline-warning mt-2">Geri</button>
</form>
</body>
</html>