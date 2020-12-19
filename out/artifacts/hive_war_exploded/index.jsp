<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8" />
</head>
<body>
<h1>Hello world!</h1>
<div>
    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/SignUp_ok.do">
        <input type="text" name="name" placeholder="이름을 입력하세요.">
        <input type="text" name="email" placeholder="메일을 입력하세요.">
        <button type="submit" id="btn_submit" class="btn_block">
            등록
        </button>
    </form>
</div>

    <!-- Javascript -->
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function() {
                $("#btn_submit").click(function () {
                    $('.form-horizontal').submit();
                });
            });
    </script>
</body>
</html>