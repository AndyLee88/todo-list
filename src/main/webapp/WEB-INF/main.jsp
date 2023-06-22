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
<%-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datepicker.js"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script> 

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
    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">TODO 추가하기</button>
        <div id="calendar"></div>
        <div class="modal" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">새로운 작업 추가</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <form action="/todo/create" method="post">
			      <div class="modal-body">
		        	<div class="mb-3">
		        		<input type="text" class="form-control" id="title" name="title" placeholder="작업이름">
		        	</div>
		        	<div class="mb-3">
		        		<textarea class="form-control" id="description" name="description" placeholder="작업내용"></textarea>
		        	</div>
		        	<div class="mb-3">
		        		<label for="importance">중요도:</label>
						<select class="form-control" id="importance" name="importance">
						  <option value="1">1</option>
						  <option value="2">2</option>
						  <option value="3">3</option>
						  <option value="4">4</option>
						</select>
		        	</div>
			        <label class="form-lable mb-2" for="todoStartAt">시작일</label>
		          	<div class="input-group date mb-3">
			            <input type="text" class="form-control datetimepicker" id="todoStartAtStr" name="todoStartAtStr" placeholder="시작일을 선택하세요" >
					</div>
					<label class="form-lable mb-2" for="todoEndAt">종료일</label>
			        <div class="input-group date mb-3">
				        <input type="text" class="form-control datetimepicker" id="todoEndAtStr" name="todoEndAtStr" placeholder="종료일을 선택하세요" >
			        </div>
			        <label class="form-lable mb-2" for="todoEndAt">종료예상일</label>
			        <div class="input-group date mb-3">
				        <input type="text" class="form-control datetimepicker" id="todoDueDateStr" name="todoDueDateStr" placeholder="예상 종료일을 선택하세요" >
			        </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
			        <button type="submit" class="btn btn-primary">작업추가</button>
			      </div>
		      </form>
		    </div>
		  </div>
		</div>
    </article>
</section>
<script type="text/javascript">
var exampleModal = document.getElementById("exampleModal")
exampleModal.addEventListener("show.bs.modal", function (event) {
  var modalTitle = exampleModal.querySelector(".modal-title")
  var modalBodyInput = exampleModal.querySelector(".modal-body input")

  modalTitle.textContent = "새로운 작업 추가 "
});
document.addEventListener("DOMContentLoaded", function() {
  var calendarEl = document.getElementById("calendar");
  var calendar = new FullCalendar.Calendar(calendarEl, {
  	initialView: "dayGridMonth",
      initialDate: new Date(),
      headerToolbar: {
        left: "prev,next today",
        center: "title",
        right: "dayGridMonth,timeGridWeek,timeGridDay"
      },
  	   events:  ${todoList}
  });
  calendar.render();
});
$(function() {
	$(".datetimepicker").datetimepicker({ 
		format: "Y-m-d H:i:00"
	});
});
</script>
</body>
</html>