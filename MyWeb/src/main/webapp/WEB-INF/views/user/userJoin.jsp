﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="../include/header.jsp" %>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                <div class="titlebox">
                    회원가입
                </div>
                <form action="">
                    <div class="form-group">
                        <!--사용자클래스선언-->
                        <label for="id">아이디</label>
                        <div class="input-group">
                            <!--input2탭의 input-addon을 가져온다 -->
                            <input type="text" class="form-control" id="userId" placeholder="아이디를 (영문포함 4~12자 이상)">
                            <div class="input-group-addon">
                                <button type="button" class="btn btn-primary" id="idCheckBtn">아이디중복체크</button>
                            </div>
                        </div>
                        <span id="msgId"></span>
                        <!--자바스크립트에서 추가-->
                    </div>
                    <div class="form-group">
                        <!--기본 폼그룹을 가져온다-->
                        <label for="password">비밀번호</label>
                        <input type="password" class="form-control" id="userPw"
                            placeholder="비밀번호 (영 대/소문자, 숫자 조합 8~16자 이상)">
                        <span id="msgPw"></span>
                        <!--자바스크립트에서 추가-->
                    </div>
                    <div class="form-group">
                        <label for="password-confrim">비밀번호 확인</label>
                        <input type="password" class="form-control" id="pwConfirm" placeholder="비밀번호를 확인해주세요.">
                        <span id="msgPw-c"></span>
                        <!--자바스크립트에서 추가-->
                    </div>
                    <div class="form-group">
                        <label for="name">이름</label>
                        <input type="text" class="form-control" id="userName" placeholder="이름을 입력하세요.">
                    </div>
                    <!--input2탭의 input-addon을 가져온다 -->
                    <div class="form-group">
                        <label for="hp">휴대폰번호</label>
                        <div class="input-group">
                            <select class="form-control phone1" id="userPhone1">
                                <option>010</option>
                                <option>011</option>
                                <option>017</option>
                                <option>018</option>
                            </select>
                            <input type="text" class="form-control phone2" id="userPhone2" placeholder="휴대폰번호를 입력하세요.">
                        </div>
                    </div>
                    <div class="form-group email-form">
                        <label for="email">이메일</label><br>
                            <div class="input-group">
                                <input type="text" class="form-control" id="userEmail1" placeholder="이메일">
                                <select class="form-control" id="userEmail2">
                                    <option>@naver.com</option>
                                    <option>@daum.net</option>
                                    <option>@gmail.com</option>
                                    <option>@hanmail.com</option>
                                    <option>@yahoo.co.kr</option>
                                </select>
                                <div class="input-group-addon">
                                	<button type="button" id="mail-check-btn" class="btn btn-primary">이메일 인증</button>
                                </div>
                            </div>
                    </div>
                    <div class="mail-check-box">
                        <input type="text" class="form-control mail-check-input" placeholder="인증번호 6자리를 입력하세요."
                            maxlength="6" disabled="disabled">
                        <span id="mail-check-warn"></span>
                    </div>


                    <!--readonly 속성 추가시 자동으로 블락-->
                    <div class="form-group">
                        <label for="addr-num">주소</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="addrZipNum" placeholder="우편번호" readonly>
                            <div class="input-group-addon">
                                <button type="button" class="btn btn-primary">주소찾기</button>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="addrBasic" placeholder="기본주소">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="addrDetail" placeholder="상세주소">
                    </div>

                    <!--button탭에 들어가서 버튼종류를 확인한다-->
                    <div class="form-group">
                        <button type="button" class="btn btn-lg btn-success btn-block">회원가입</button>
                    </div>

                    <div class="form-group">
                        <button type="button" class="btn btn-lg btn-info btn-block">로그인</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@ include file="../include/footer.jsp" %>

    <script>

        let code = ''; //이메일 전송 인증번호 저장을 위한 변수

        //아이디 중복체크
        document.getElementById('idCheckBtn').onclick = function() {

            const userId = document.getElementById('userId').value;
            if(userId === ''){
                alert('아이디는 필수값입니다');
                return;
            }
            /*
            //아이디 중복확인 비동기 요청 준비
            const xhr = new XMLHttpRequest();

            //서버 요청 정보 설정
            xhr.open('POST','${pageContext.request.contextPath}/user/idCheck');
            //요청 정보를 헤더에 설정
            xhr.setRequestHeader('content-type','text/plain');//문자라서 text/plain
            xhr.send(userId);
            //요청보냈고

            //응답받기
            xhr.onload = () => {
                console.log(xhr.status);
                console.log(xhr.response);
            }
            */
           /*
           #fetch API: 자바스크립트에서 제공하는 비동기 통신 함수.
           - Promise객체를 자동으로 리턴하여 손쉽게 통신의 응답데이터를
           소비할 수 있게 해준다. (Promise:비동기 통신의 순서를 보장하는 문법)
           - fetch함수가 리턴하는 Promise객체는 단순한 응답 JSON 데이터가 아닌 전체적이고, 포괄적인
           응답정보를 가지고 있다.
           - 따라서, 서버가 응답한 여러 정보 중 JSON 데이터만 소비하려면 json()이라는 메서드를 사용
           -문자열 데이터라면 text() 메서드를 사용.
           */

           //fetch('url',{요청관련 정보객체})
        //     fetch('${pageContext.request.contextPath}/user/idCheck', {
        //         method: 'post',
        //         headers: {
        //             'Content-type':'application/json'
        //         },
        //         body: userId

        //    })
           //Promise 객체의 상태가 요청 성공일 시 데이터 후속처리 진행.
        //    .then(res =>{
        //         //fetch 함수를 통해 비동기 통신이 실행되고,
        //         //요청이 완료된 후 then()의 매개값으로 응답에 관련된 함수를 콜백방식으로 전달.
        //         //함수의 매개변수를 선언하면 해당 매개변수로 응답에 관련된
        //         //전반적인 정보를 가진 응답 정보가 전달.
        //         // console.log(res);
        //         // console.log(res.text());
        //         return res.text()
        //    })
        //    .then(data =>{
        //         console.log(data);
        //    })
        const reqObj={
            method: 'post',
                headers: {
                    'Content-type':'application/json'
                },
                body : userId
        };
        //비동기 요청 보내기
        fetch('${pageContext.request.contextPath}/user/idCheck', reqObj)
        .then(res =>res.text())//요청 완료 후 응답 정보에서 텍스트만 빼기
            .then(data => {//텍스트만 뺀 Promise 객체로부터 data전달받음.
                    if(data ==='ok'){
                        //더 이상 아이디를 작성할 수 없도록 막아주겠다.
                        document.getElementById('userId').setAttribute('readonly',true);
                        //더 이상 버튼을 누를 수 없도록 버튼 비활성화.
                        document.getElementById('idCheckBtn').setAttribute('disabled', true);
                        //메세지 남기기
                        document.getElementById('msgId').textContent = '사용 가능한 아이디 입니다.';
                    }
                    else{
                        document.getElementById('msgId').textContent = '중복된 아이디 입니다.';
                    }
                });
    } //아이디 중복확인 끝

    //인증번호 이메일 전송
    document.getElementById('mail-check-btn').onclick = function(){
        const email = document.getElementById('userEmail1').value
                        + document.getElementById('userEmail2').value;
        
        console.log('완성된 email:' + email);   
        fetch('${pageContext.request.contextPath}/user/mailCheck?email='+email)
            .then(res => res.text())
            	.then(data => {
            		console.log('인증번호: '+data);
            		//비활성된 인증번호 입력창 활성화
                    document.querySelector('.mail-check-input').disabled = false;
                    code = data; //인증번호를 전역변수에 저장
                    alert('인증번호가 전송되었습니다. 확인후 입력란에 정확히 입력하세요.');
            	});//비동기 끝.
    }; //인증번호 이벤트 끝.

    //인증번호 검증
    //blur -> focus가 벗어나는 경우 발생.
    document.querySelector('.mail-check-input').onblur = function(e){
        //console.log('blur이벤트 발생 확인!');
        
        const inputCode = e.target.value; //사용자가 입력한 인증번호.
        const $resultMsg = document.getElementById('mail-check-warn');
        console.log('사용자가 입력한 값: ' + inputCode);
        
        if(inputCode === code){
            $resultMsg.textContent ='인증번호가 일치합니다.';
            $resultMsg.style.color = 'green';
            document.getElementById('mail-check-btn').disabled = true;
            document.getElementById('userEmail1').setAttribute('readonly',true);
            document.getElementById('userEmail2').setAttribute('readonly',true);
            e.target.style.display = 'none'; //인증번호 입력창 숨기기

            //초기값을 사용자가 선택한 값으로 무조건 설정하는 방법(select에서 readonly 대용)
            //항상 2개같이 써야한다.
            const email2 = document.getElementById('userEmail2');

            email2.setAttribute('onFocus', 'this.initialSelect = this.selectedIndex');
            email2.setAttribute('onChange', 'this.selectedIndex = this.initialSelect');
        }
        else{
            $resultMsg.textContent ='인증번호를 다시 확인해 주세요.'
            $resultMsg.style.color = 'red';
            e.target.focus(); //다시 입력할 수 있도록 포커싱 추가.
        }
    }








        /*아이디 형식 검사 스크립트*/
        var id = document.getElementById("userId");
        id.onkeyup = function() {
            /*
            	자바스크립트의 정규표현식 입니다
            	정규표현식: 문자열 내의 특정 문자 조합을 찾기 위한 패턴.
            	특정 규칙이 있는 문자열 집합을 규칙을 직접 지정하여 탐색하게 해주는 
            	메타 문자.
            */
            /*test메서드를 통해 비교하며, 매칭되면 true, 아니면 false반환*/
            var regex = /^[A-Za-z0-9+]{4,12}$/; 
            if(regex.test(document.getElementById("userId").value )) {
                document.getElementById("userId").style.borderColor = "green";
                document.getElementById("msgId").innerHTML = "아이디중복체크는 필수 입니다";

            } else {
                document.getElementById("userId").style.borderColor = "red";
                document.getElementById("msgId").innerHTML = "부적합한 아이디 입니다.";
            }
        }
        /*비밀번호 형식 검사 스크립트*/
        var pw = document.getElementById("userPw");
        pw.onkeyup = function(){
            var regex = /^[A-Za-z0-9+]{8,16}$/;
             if(regex.test(document.getElementById("userPw").value )) {
                document.getElementById("userPw").style.borderColor = "green";
                document.getElementById("msgPw").innerHTML = "사용가능합니다";
            } else {
                document.getElementById("userPw").style.borderColor = "red";
                document.getElementById("msgPw").innerHTML = "올바른 비밀번호를 입력하세요";
            }
        }
        /*비밀번호 확인검사*/
        var pwConfirm = document.getElementById("pwConfirm");
        pwConfirm.onkeyup = function() {
            var regex = /^[A-Za-z0-9+]{8,16}$/;
            if(document.getElementById("pwConfirm").value == document.getElementById("userPw").value ) {
                document.getElementById("pwConfirm").style.borderColor = "green";
                document.getElementById("msgPw-c").innerHTML = "비밀번호가 일치합니다";
            } else {
                document.getElementById("pwConfirm").style.borderColor = "red";
                document.getElementById("msgPw-c").innerHTML = "비밀번호 확인란을 확인하세요";
            }
        }        
    </script>
