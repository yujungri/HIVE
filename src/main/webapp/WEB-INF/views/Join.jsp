<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
</head>

<body>

<div class="signup">
    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/Join_ok.do">
        <input type="text" name="password" placeholder="비밀번호를 입력하세요."><br/>
        <input type="text" name="email" placeholder="메일을 입력하세요."><br/>
        <input type="text" name="name" placeholder="이름을 입력하세요."><br/>
        <input type="text" name="contact" placeholder="연락처를 입력하세요."><br/>
        <select name="department_cd" id="department_cd"><br/>
            <option value="">--- 선택하세요 ---</option>
            <option value="A">관리자</option>
            <option value="C">콘텐츠관리팀</option>
            <option value="I">인사팀</option>
        </select>
        <button type="submit" id="btn_submit" class="btn_block">
            등록
        </button>

        <!-- 선택결과를 표시할 div -->
        <div id="result"></div>
    </form>
</div>

<!-- Javascript -->
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#btn_submit").click(function () {
            var department = $("#department_cd").val();
            if (!department) {
                alert("부서를 선택하세요.");
                $("department_cd").focus();
                return  false;
            }

            $('.form-horizontal').submit();
        });
    });
</script>
</body>
</html>