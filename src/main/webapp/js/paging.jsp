<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/page.css">
<ul class="list-group list-group-horizontal" id="pageBar">
	<c:set var="nowPage" value="${paging.pageNum}"/>
	<c:set var="isEnd" value="${paging.pages}"/>
	<c:choose>
		<c:when test="${nowPage eq 1}">
			<li><a href="" class="list-group-item disabled" aria-disabled="true">First</a></li>
			<li><a href="" class="list-group-item disabled" aria-disabled="true">Previous</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/language/page/${paging.navigateFirstPage-isEnd}/${paging.pageSize}" class="list-group-item">First</a></li>
			<li><a href="/language/page/${paging.navigateFirstPage-1}/${paging.pageSize}" class="list-group-item">Previous</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="n" items="${paging.navigatepageNums}">
		<c:choose>
			<c:when test="${n eq paging.pageNum}">
				<li class="list-group-item active"><a href="/language/page/${n}/${paging.pageSize}" class="text-white">${n}</a></li>
				
			</c:when>
			<c:when test="${n ne paging.pageNum}">
				<li class="list-group-item       "><a href="/language/page/${n}/${paging.pageSize}">${n}</a></li>
			</c:when>
		</c:choose>
	</c:forEach>
	
	<c:choose>
		<c:when test="${nowPage eq isEnd}">
			<li><a href="" class="list-group-item disabled" aria-disabled="true">Next</a></li>
			<li><a href="" class="list-group-item disabled" aria-disabled="true">End</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/language/page/${paging.navigateLastPage+1}/${paging.pageSize}" class="list-group-item">Next</a></li>
			<li><a href="/language/page/${isEnd}/${paging.pageSize}" class="list-group-item">End</a></li>
		</c:otherwise>
	</c:choose>
</ul>