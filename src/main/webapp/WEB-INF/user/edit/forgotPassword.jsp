<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/favicon.png">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<title>TODO List</title>
<style>
    .margin-60 {
      margin-top: 60px;
      margin-bottom: 60px;
    }
  </style>
</head>
<body>
<h1><a href="/" style="text-decoration: none;">TODO</a></h1>
<hr>
<h1>회원 정보 찾기</h1>
<hr>
<section class="container">
	<div class="row justify-content-center">
		<div class="col-lg-5">
				<div class="mb-10 row">
				</div>
				<div class="mb-10 d-flex justify-content-center">
					<c:choose>
						<c:when test="${error eq 'success'}"><label class="form-lable mb-100 center-label margin-60" >${users.username} 님 환영합니다</label></c:when>
						<c:when test="${error eq 'error'}"><label class="form-lable mb-100 center-label margin-60" >비정상접근입니다.</label></c:when>
					</c:choose>
				</div>
				<div class="mb-10">
				</div>
				<hr>
				<div class="d-flex justify-content-center">
					<a href="/" class="btn btn-primary">로그인하기</a>
				</div>
				<input type="hidden" id="valcheck">
		</div>
	</div>
</section>
<hr>
</body>
</html>