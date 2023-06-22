<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-md bg-light navbar-light">
	<div class="navbar-brand"><a href="/" style="text-decoration: none;">&nbsp;TODO</a></div>
	<div class="collapse navbar-collapse justify-content-end">
	    <ul class="navbar-nav">
	        <sec:authorize access="isAuthenticated()">
	            <div class="nav-item">
	                환영합니다, <sec:authentication property="name"/> 님!
	                <a href="/user/edit" class="btn btn-secondary btn-md">회원수정</a>
	                <a href="/user/logout" class="btn btn-secondary btn-md">로그아웃</a>
	            </div>
	        </sec:authorize>
	
	        <sec:authorize access="isAnonymous()">
	            <div class="nav-item">
	                이용하시려면 로그인 해주세요.
	                <a href="/user/login" class="btn btn-secondary btn-md">로그인</a>
	                <a href="/user/signup" class="btn btn-secondary btn-md">회원가입</a>
	            </div>
	        </sec:authorize>
	    </ul>
	</div>
</nav>