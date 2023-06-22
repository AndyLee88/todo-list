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
</head>
<body>
<h1><a href="/" style="text-decoration: none;">TODO</a></h1>
<hr>
<h1>로그인</h1>
<hr>
<section class="container">
    <div class="row justify-content-center">
	    <div class="col-lg-4">
	        <form action="/user/login" method="post">
	            <div class="mb-3">
	                <label class="form-lable mb-2" for="username">ID<span>*</span></label>
	                <input class="form-control" id="username" name="username" placeholder="ID" maxlength="20" />
	            </div>
	            <div class="mb-3">
	                <label class="form-lable mb-2" for="password">password<span>*</span></label>
	                <input class="form-control" id="password" name="password" placeholder="password" type="password" maxlength="30" />
	            </div>
	            <input name="remember-me" id="remember-me" type="checkbox" checked="checked"><label for="remember-me">&nbsp;하루동안 기억하기</label>
	            <hr>
	            <div class="d-flex justify-content-center">
	                <button type="submit" class="btn btn-primary">로그인</button>&nbsp;
	                <a href="/user/signup" class="btn btn-secondary">회원가입</a>
	            </div>
	            <div class="mt-2 text-center">
	                <a href="/user/forgot-password" class="text-muted" style="font-size: small; text-decoration: none;">비밀번호가 기억나지 않으신가요?</a>
	            </div>
	        </form>
	    </div>
	</div>
</section>
<hr>
<c:if test="${exception != null}">
<h2>${exception.message}</h2>
</c:if>
</body>
</html>