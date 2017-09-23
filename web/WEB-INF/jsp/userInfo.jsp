<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>个人信息</title>
    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <link href="<c:url value="/views/Style/StudentStyle.css"/>" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/js/user.js"/>"></script>
    <script>
        var jq = jQuery.noConflict();
        jq(document).ready(function(){
            var gender = isGenderFalse("${sessionScope.user.sex}");
            console.info(gender);
            jq("#sex").text(gender)
        })
    </script>
</head>


<body>

<div class="cztable">
    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="right" width="80">姓名：</td>
            <td id="name">${sessionScope.user.name}&nbsp;</td>
            <td align="right" width="90">学号：</td>
            <td id="studentNum">${sessionScope.user.name}&nbsp;</td>

            <!--<td rowspan="9"><div align="center"><img id="pic_face"  height="160" width="120" src="Images/user.png"/ style="padding:0px 0px;"></div>&nbsp;</td>-->
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td id="sex"></td>
            <td align="right">专业：</td>
            <td id="major">计算机科学与技术&nbsp;</td>
        </tr>
        <tr>
            <td align="right">出生日期：</td>
            <td id="birthDate">20170101&nbsp;</td>
            <td align="right">入学年度：</td>
            <td id="enrolYear">${sessionScope.user.year}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">籍贯：</td>
            <td id="nativePlace">安徽合肥&nbsp;</td>
            <td align="right">住宿学院：</td>
            <td id="dormitory">知行123A&nbsp;</td>
        </tr>
        <tr>
            <td align="right">培养层次：</td>
            <td id="cultivateLevel">${sessionScope.user.type}&nbsp;</td>

            <td align="right">当前状态：</td>
            <td id="status" >在读&nbsp;</td>
        </tr>

        <tr>
            <td colspan="4" align="left" style="color: red">联系方式（请输入正确的联系方式，以便能及时联系到你。谢谢！）</td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td id="phoneNum" >15111141999</td>
            <td align="right">电子邮箱：</td>
            <td id="email">${sessionScope.user.name}@stu.edu.cn</td>

        </tr>
        <tr>
            <td align="right">QQ:</td>
            <td id="QQNum" >123456</td>
            <td align="right">微信：</td>
            <td id="wechatNum">余强2333</td>


        </tr>
        <tr>
            <td align="right">联系地址：</td>
            <td id="address" colspan="4">广东省汕头市金平区汕头大学</td>
        </tr>

    </table>
</div>
	


</body>
</html>