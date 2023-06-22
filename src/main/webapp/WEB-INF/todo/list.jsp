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

<title>What To Do</title>

<style>
    body {
        overflow-x: hidden;
    }
</style>
</head>
<body>

<jsp:include page="/include/header.jsp"/>
<hr>
<section class="container">
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr><th></th>
				<th>작업이름</th>
				<th>작업내용</th>
				<th>중요도</th>
				<th>시작일</th>
				<th>종료일</th>
				<th>종료예상일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${todolist}">
			<tr><td style="text-align: center;"><input type="checkbox" value="${e.tdtino}"></td>
				<td><a href="/todo/detail/${e.tdtino}"> ${e.title}</a></td>
				<td>${e.description}</td>
				<td>${e.importance}</td>
				<td>${e.todoStartAtStr}</td>
				<td>${e.todoEndAtStr}</td>
				<td>${e.todoDueDateStr}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</section>
</body>
</html>