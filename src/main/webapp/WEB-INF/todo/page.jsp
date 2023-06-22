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
<section class="container table-responsive">
	<hr>
	
	<hr>
	
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
		<c:forEach var="e" items="${list}">
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
	<button type="button"onclick="deleteTodo();" id="deleteButton" class="btn btn-primary">항목 삭제</button>
	<hr>
	<div>
	</div>
	<jsp:include page="/js/paging.jsp"/>
	<hr>
</section>
<script>
    async function deleteTodo() {
        // 체크박스에서 선택된 항목들의 값을 배열로 저장
        var confirmation = confirm("정말로 삭제하시겠습니까?");
    	if (confirmation) {
        var idxs = [];
        document.querySelectorAll("input[type='checkbox']:checked").forEach(function(checkbox) {
            idxs.push(checkbox.value);
        });

        // 선택된 항목이 없다면 함수를 종료
        if (idxs.length === 0) {
            alert("삭제할 항목을 선택하세요.");
            return;
        }

        // 선택된 항목들의 값들을 공백으로 이어붙임
        var idxsStr = idxs.join(" ");

        // Fetch API를 사용한 POST 요청
        try {
            let response = await fetch("/todo/deleteIdxs", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    'idxs': idxsStr
                })
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            // 성공적으로 요청이 처리되었을 때의 로직
            // 예: 페이지 새로고침
            location.reload();
        } catch(error) {
            // 에러가 발생했을 때의 로직
            // 예: 에러 메시지 표시
            console.error("Error: ", error);
        }
    	}
    }
</script>
</body>
</html>