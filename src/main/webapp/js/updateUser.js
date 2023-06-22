/**
 * 
 */
//비밀번호 에러 핸들러
	window.onload = function() {
	    var passwordInput = document.getElementById('password');
	    var passwordError = document.getElementById('passwordError');
	    var passwordcheck = document.getElementById('pcheck');
	    var password2Input = document.getElementById('password2');
	    var password2Error = document.getElementById('password2Error');
	    var valcheck = document.getElementById('valcheck');
	    var emailInput = document.getElementById('email');
	    var emailError = document.getElementById('emailError');
	    var nickInput = document.getElementById('nickname');
	    var nickError = document.getElementById('nicknameError');
	    
	    passwordInput.addEventListener('input', function() {
	    	if(/[\>\<\(\)\%\;\\\ ]/.test(this.value)){
	            this.classList.add('error');
	            passwordError.textContent = "암호에 > < ( ) % ; \ 공백 등의 특수문자를 포함할 수 없습니다.";
	            passwordcheck.value = 'false';
	            valcheck.value='false';
	            this.value = this.value.replace(/[\>\<\(\)\%\;\\\ ]/g, '');  // 특수문자와 공백 제거
	        } else{
	            this.classList.remove('error');
	            passwordError.textContent = "";
	            valcheck.value='true';
	        }
	    });
	
	    passwordInput.addEventListener('blur', function() {
	        var valid = this.value;
	        if (valid.length < 8) {
	        	this.classList.remove('pass');
	            this.classList.add('error');
	            passwordError.textContent = "암호는 8자리 이상 쓰셔야 합니다";
	            passwordcheck.value = 'false';
	            valcheck.value='false';
	        } else {
	            this.classList.remove('error');
	            this.classList.add('pass');
	            passwordError.textContent = "";
	            valcheck.value='true';
	        }
	    });
	    
	    password2Input.addEventListener('blur', function() {
	        var valid = this.value;
	        var password = passwordInput.value;
	        if (valid === password && password != '' && passwordInput.classList.contains('pass')) {
	        	this.classList.remove('error');
	            this.classList.add('pass');
	            password2Error.textContent = "";
	            password2Pass.textContent = "암호 확인완료";
	            passwordcheck.value = 'true';
	            valcheck.value='true';
	        } else {
	        	this.classList.remove('pass');
	            this.classList.add('error');
	            password2Pass.textContent = "";
	            if(password == '')
	            	password2Error.textContent = "먼저 암호를 입력해주세요";
	            else if(!passwordInput.classList.contains('pass'))
	            	password2Error.textContent = "위의 암호입력을 완료하셔야 합니다";
	            else
	            	password2Error.textContent = "위의 암호와 동일하게 입력해주세요";
	            passwordcheck.value = 'false';
	            valcheck.value='false';
	        }
	    });
	    
	    nickInput.addEventListener('blur', function() {
	        var valid = this.value;
	        if (valid.length < 1) {
	        	this.classList.remove('pass');
	            this.classList.add('error');
	            nickError.textContent = "닉네임은 필수입니다";
	            valcheck.value='false';
	        } else {
	            this.classList.remove('error');
	            this.classList.add('pass');
	            nickError.textContent = "";
	            valcheck.value='true';
	        }
	    });
	    
	    emailInput.addEventListener('blur', function() {
		  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
		  if (emailPattern.test(this.value)) {
		    this.classList.remove('error');
		    this.classList.add('pass');
		    emailError.textContent = "";
		    valcheck.value = 'true';
		  } else {
			this.classList.remove('pass');
		    this.classList.add('error');
		    emailError.textContent = "올바른 이메일 형식을 입력해주세요.";
		    valcheck.value = 'false';
		  }
		});
	    
	    function checkMobInput(e){
			var mobError = document.getElementById('mobError');
	    	var regEx = /\D/g;
			if(regEx.test(this.value)){
				this.value='';
				mobError.textContent="숫자만 입력해주세요";
				this.classList.add('error');
				valcheck.value='false';
			}else{
				mobError.textContent="";
				this.classList.remove('error');
				valcheck.value='true';
			}
		}
	    
	    document.getElementById('mob1').addEventListener('input', checkMobInput);
	    document.getElementById('mob2').addEventListener('input', checkMobInput);
	    document.getElementById('mob3').addEventListener('input', checkMobInput);
	}
	function submitForm() {
		let inputs = document.querySelectorAll('input');
		let isPass = true;
	    for(var i = 0; i < inputs.length; i++) {
	        if(inputs[i].classList.contains('error')) {
	            isPass=false;
	            break;
	        }
	    }
	    if(isPass == true){
			var form = document.getElementById('updateForm');
			    if (document.getElementById('SignOffOn').checked) {
			        let formData = new FormData(form);
			        fetch('/user/update', {
			            method: 'POST',
			            body: formData
			        })
			        .then(response => {
			            if (response.ok) {
			                // 업데이트 성공
			                alert('정보수정 완료!');
			                window.location.href = '/user/edit'; // 프로필 페이지로 리다이렉트
			            } else {
			                // 업데이트 실패
			                alert('정보 갱신에 실패했습니다');
			            }
			        })
			        .catch(error => {
			            alert('통신 오류');
			        });
			    } else {
			        alert('잘못된 요청입니다.');
			    }
		}else{
			alert("필수 항목을 모두 입력해주세요");	
		}
	}
	