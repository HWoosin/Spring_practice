<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox">
                        로그인
                    </div>
                    <form method="post" name="loginForm">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <input type="text" name="userId" class="form-control" id="id" placeholder="아이디">
                         </div>
                         <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" name="userPw" class="form-control" id="pw" placeholder="비밀번호">
                         </div>
                         <div class="form-group">
                            <button type="button" id="LoginBtn" class="btn btn-info btn-block">로그인</button>
                            <button type="button" id="joinBtn" class="btn btn-primary btn-block">회원가입</button>
                         </div>
                          <div class="col-lg-12 text-center mt-3">
                         	<button type="button" onclick="location.href='${urlKakao}'">
                         		<img alt="카카오로그인" src="${pageContext.request.contextPath}/img/kakao_login_medium_narrow.png">
                         	</button>
                         </div>
                    </form>                
                </div>
            </div>
        </div>
    </section>
    
<%@ include file="../include/footer.jsp" %>

<script>
    //회원 가입 완료 후 add FlashAttibute로 msg데이터가 전달되는 지 확인
    const msg = '${msg}';
    if(msg === 'joinSuccess'){
        alert('회원 가입 정상 처리되었습니다.');
    }
    else if(msg === 'loginFail'){
    	alert('로그인에 실패했습니다. ');
    }
    //입력란이 공백인지 아니지 확인한 수, 공백이 아니라면 Submit
    //요청 url은 //user/userLogin -> post로 간다.
    
    document.getElementById('LoginBtn').onclick =function(){
        const id = document.getElementById("id").value;
        const pw = document.getElementById("pw").value;

        if(id === ''){
            alert('아이디를 입력해주세요');
            return;
        }
        if(pw === ''){
            alert("비밀번호를 입력해주세요")
            return
        }
        
        document.loginForm.submit();
        
    }
    document.getElementById('joinBtn').onclick = () =>{
        location.href='${pageContext.request.contextPath}/user/join';
    }


</script>