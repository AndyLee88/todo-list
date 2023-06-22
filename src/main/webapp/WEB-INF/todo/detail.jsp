<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/favicon.png">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<title>What To Do</title>

<style>
    body {
        overflow-x: hidden;
    }
</style>
</head>
<body>

<jsp:include page="/include/header.jsp"/>
<section class="row">
	<article id="left" class="col-12 col-sm-4 col-md-2 bg-light">
    	<jsp:include page="/include/sidebar.jsp"/>
    </article> 
        
    <article id="midle" class="col-12 col-md-10">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">작업 수정</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="/todo/update" method="post">
			      <div class="modal-body">
			      	<input type="hidden" id="tdtino" name="tdtino" value="${e.tdtino}">
		        	<div class="mb-3">
		        		<input type="text" class="form-control" id="title" name="title" placeholder="작업이름" value="${e.title}">
		        	</div>
		        	<div class="mb-3">
		        		<textarea class="form-control" id="description" name="description" placeholder="작업내용">${e.description}</textarea>
		        	</div>
		        	<div class="mb-3">
		        		<label for="importance">중요도:</label>
						<select class="form-control" id="importance" name="importance">
						  <option value="1" <c:if test="${e.importance eq 1}">selected="selected"</c:if>>1</option>
						  <option value="2" <c:if test="${e.importance eq 2}">selected="selected"</c:if>>2</option>
						  <option value="3" <c:if test="${e.importance eq 3}">selected="selected"</c:if>>3</option>
						  <option value="4" <c:if test="${e.importance eq 4}">selected="selected"</c:if>>4</option>
						</select>
		        	</div>
			        <label class="form-lable mb-2" for="todoStartAt">시작일</label>
		          	<div class="input-group date mb-3">
			            <input type="text" class="form-control datetimepicker" id="todoStartAtStr" name="todoStartAtStr" placeholder="시작일을 선택하세요" value="${e.todoStartAtStr}">
					</div>
					<label class="form-lable mb-2" for="todoEndAt">종료일</label>
			        <div class="input-group date mb-3">
				        <input type="text" class="form-control datetimepicker" id="todoEndAtStr" name="todoEndAtStr" placeholder="종료일을 선택하세요" value="${e.todoEndAtStr}">
			        </div>
			        <label class="form-lable mb-2" for="todoEndAt">종료예상일</label>
			        <div class="input-group date mb-3">
				        <input type="text" class="form-control datetimepicker" id="todoDueDateStr" name="todoDueDateStr" placeholder="예상 종료일을 선택하세요" value="${e.todoDueDateStr}">
			        </div>
			      </div>
			      <div class="modal-footer">
			        <a href="/todo/list" class="btn btn-secondary">취소</a>
			        <button type="submit" class="btn btn-primary">작업수정</button>
			      </div>
		      </form>
		    </div>
		  </div>
    </article>
</section>
<script type="text/javascript">
$(function() {
	$(".datetimepicker").datetimepicker({ 
		format: "Y-m-d H:i:00"
	});
});
</script>
</body>
</html>