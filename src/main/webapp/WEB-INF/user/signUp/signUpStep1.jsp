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
<style type="text/css">
.error-message {
    color: red;
}
.pass-message {
    color: green;
}
.error {
    border: 2px solid red;
}
.pass {
    border: 2px solid green;
}
input::-webkit-input-placeholder {
        /* WebKit browsers */
        font-size: 11px;
    }
    input:-moz-placeholder {
        /* Mozilla Firefox 4 to 18 */
        font-size: 11px;
    }
    input::-moz-placeholder {
        /* Mozilla Firefox 19+ */
        font-size: 11px;
    }
    input:-ms-input-placeholder {
        /* Internet Explorer 10+ */
        font-size: 11px;
    }
</style>
</head>
<body>
<h1><a href="/" style="text-decoration: none;">TODO</a></h1>
<hr>
<h1>회원 가입</h1>
<hr>
<section class="container">
		<div class="row justify-content-center">
			<div class="col-lg-5">
				<form id="signupForm" action="/user/signup" method="post">
					<div class="mb-3 row">
						<label class="form-lable mb-2" for="username">아이디<span>*</span></label>
						<div class="col">
							<input class="form-control" id="username" name="username"
								placeholder="아이디 입력후 중복조회를 눌러주세요" value="${param.username}" />
							<small id="idError" class="error-message"></small>
						</div>
						<div class="col-auto">
							<button type="button"onclick="duplicateId();" id="duplicateButton" class="btn btn-primary">중복조회</button>
							<input type="hidden" id="idcheck" name="idcheck" value="false">
						</div>
					</div>
					<div class="mb-3">
						<label class="form-lable mb-2" for="password">암호<span>*</span></label>
						<input class="form-control" id="password" name="password"
							placeholder="암호는 8자리이상 입력해주세요" value="${param.password}"
							maxlength="20" type="password" />
							<small id="passwordError" class="error-message"></small>
					</div>
					<div class="mb-3">
						<label class="form-lable mb-2" for="password2">암호 재입력<span>*</span></label>
						<input class="form-control" id="password2" name="password2"
							placeholder="암호 재입력" value="${param.password2}"
							maxlength="20" type="password" />
							<small id="password2Error" class="error-message"></small>
							<small id="password2Pass" class="pass-message"></small>
					</div>
					<div class="mb-3">
						<label class="form-lable mb-2" for="nickname">닉네임<span>*</span></label>
						<input class="form-control" id="nickname" name="nickname"
							placeholder="띄어쓰기및 특수기호(-,_포함)는 사용하실수 없습니다" maxlength="16" value="${param.nickname}" />
							<small id="nicknameError" class="error-message"></small>
					</div>
					<div class="mb-3">
						<label class="form-lable mb-2" for="email">이메일<span>*</span></label>
						<input class="form-control" id="email" name="email"
							placeholder="가입요청 후 인증받으실 메일 주소를 입력해주세요 example@mail.com" maxlength="30" value="${param.email}" />
							<small id="emailError" class="error-message"></small>
					</div>
					<div class="mb-3 row">
						<label class="form-lable mb-2" for="mob">휴대전화</label>
						<div class="col">
							<input class="form-control" id="mob1" name="mob1"
								placeholder="010" value="${param.mob1}" maxlength="3" />
						</div>
						-
						<div class="col auto">
							<input class="form-control" id="mob2" name="mob2"
								placeholder="0000" value="${param.mob2}" maxlength="4" />
						</div>
						-
						<div class="col auto">
							<input class="form-control" id="mob3" name="mob3"
								placeholder="0000" value="${param.mob3}" maxlength="4" />
						</div>
						<small id="mobError" class="error-message"></small>
					</div>
					<input id="SignOffOn" type="checkbox"><label for="SignOffOn" class="text-muted" style="font-size: small; text-decoration: none;">&nbsp;위 개인정보 처리에 동의&nbsp;(탈퇴시까지 정보유지)&nbsp;</label>
					<hr>
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-primary">가입신청</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/" class="btn btn-secondary">&nbsp;취소&nbsp;</a>
					</div>
					<input type="hidden" id="valcheck" value="false">
					<input type="hidden" id="pcheck" value="false">
				</form>
			</div>
		</div>
	</section>
<hr>
<c:if test="${exception != null}">
<h2>${exception.message}</h2>
</c:if>
<script src="/js/signUp.js"></script>
</body>
</html>