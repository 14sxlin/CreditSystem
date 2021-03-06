<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>学习信息管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <!--<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">-->
    <link rel="stylesheet" href="<c:url value="/views/Style/tabs.css"/>" type="text/css">

    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>

    <script  src="<c:url value="/js/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/views/Script/tabs.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/views/Script/demo.js"/>"></script>

    <style type="text/css">
        div.menuSideBar {
        }

        div.menuSideBar li.nav-header {
            font-size: 14px;
            padding: 3px 15px;
        }

        div.menuSideBar .nav-list > li > a, div.menuSideBar .dropdown-menu li a {
            -webkit-border-radius: 0px;
            -moz-border-radius: 0px;
            -ms-border-radius: 0px;
            border-radius: 0px;
        }
    </style>

    <script>
        //退出
        function loginOut() {
            if (confirm("确定退出吗？"))
                window.location = "login.html";
        }
    </script>

</head>

<body>

    <div class="content">
        <div class="container">
            <h3 class="page-header">${user.name}-${user.type}</h3>
            <a class="quit" onclick="loginOut()" href="javascript:">退出</a>

            <div class="">
                <div class="row-fluid">
                    <div class="col-md-2" style="padding-left: 0px;">
                        <div class="well menuSideBar" style="padding: 8px 0px;">
                            <ul class="nav nav-list" id="menuSideBar">
                                <li class="nav-header">导航栏</li>
                                <li class="nav-divider"></li>
                                <li mid="tab1" funurl="<c:out value="info"/>"><a tabindex="-1" href="<c:out value="info"/>">个人信息</a>
                                </li>
                                <li mid="tab2" funurl="myCourse.html"><a tabindex="-1" href="javascript:void(0);">我的课程</a>
                                </li>
                                <li mid="tab3" funurl="courseList.html"><a tabindex="-1" href="javascript:void(0);">我要选课</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-10" id="mainFrameTabs" style="padding : 0px;">

                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active noclose"><a href="#bTabs_navTabsMainPage"
                                                                              data-toggle="tab">首页</a></li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div class="tab-pane active" id="bTabs_navTabsMainPage">
                                <div class="page-header">
                                    <h2 style="font-size: 31.5px;text-align: center;font-weight: normal;">欢迎使用</h2>
                                </div>
                                <div style="text-align: center;font-size: 20px;line-height: 20px;"> Welcome to use !</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>