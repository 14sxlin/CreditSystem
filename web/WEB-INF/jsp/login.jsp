<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
    <link rel="stylesheet" href="<c:url value="/views/Style/login.css"/>" type="text/css" />

</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-horizontal" method="post">
            <span >用户登录</span>

            <div class="input-form">
                <input name="username" class="form-control" id="inputAccount" placeholder="账号">
            </div>
            <br>

            <div class="input-form">
                <input name="password" type="password" class="form-control" id="inputPassword" placeholder="密码">
            </div>
            <br>

            <div class="submit">
                <button class="btn btn-default" onclick="loginSuccess(); return false;">登 录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>