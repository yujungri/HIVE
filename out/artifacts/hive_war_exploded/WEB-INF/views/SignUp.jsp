<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
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
    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/SignUp_ok.do">
        <input type="text" name="name" placeholder="이름을 입력하세요.">
        <input type="text" name="email" placeholder="메일을 입력하세요.">
        <button type="submit" id="btn_submit" class="btn_block">
            등록
        </button>
    </form>
</div>
</body>
</html>