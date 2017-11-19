<%@ page language="Java" import="java.util.*" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <link href="resources/layout/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="resources/layout/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="resources/layout/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="resources/layout/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="resources/layout/css/components.min.css" rel="stylesheet" id="style_components"
          type="text/css"/>
    <link href="resources/layout/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/css/custom.min.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo">
<!-- BEGIN CONTAINER -->
<div class="wrapper">
    <!-- BEGIN HEADER -->
    <header class="page-header">
        <nav class="navbar mega-menu" role="navigation">
            <div class="container-fluid">
                <%@ include file="comm/header.jsp" %>
                <!-- BEGIN HEADER MENU -->
                <div class="nav-collapse collapse navbar-collapse navbar-responsive-collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown dropdown-fw dropdown-fw-disabled  active open selected">
                            <a href="javascript:;" class="text-uppercase">
                                <i class="icon-home"></i> 我的博客 </a>
                            <ul class="dropdown-menu dropdown-menu-fw">
                                <li class="active">
                                    <a href="index.html">
                                        <i class="icon-bar-chart"></i> 首页 </a>
                                </li>
                                <li>
                                    <a href="dashboard_2.html">
                                        <i class="icon-bulb"></i> 新闻 </a>
                                </li>
                                <li>
                                    <a href="dashboard_3.html">
                                        <i class="icon-graph"></i> 技术 </a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown dropdown-fw dropdown-fw-disabled  ">
                            <a href="javascript:;" class="text-uppercase">
                                <i class="icon-puzzle"></i> 音乐 </a>
                            <ul class="dropdown-menu dropdown-menu-fw">
                                <li class="dropdown more-dropdown-sub">
                                    <a href="javascript:;">
                                        <i class="icon-diamond"></i> 排行榜 </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="music_popular.html">流行榜</a>
                                        </li>
                                        <li>
                                            <a href="music_new.html">新歌榜 </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown more-dropdown-sub">
                                    <a href="javascript:;">
                                        <i class="icon-settings"></i> 收藏 </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="form_controls.html">最新收藏</a>
                                        </li>
                                        <li>
                                            <a href="form_controls_md.html"> 我喜爱的</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- END HEADER MENU -->
            </div>
            <!--/container-->
        </nav>
    </header>
    <!-- END HEADER -->
    <div class="container-fluid">
        <div class="page-content">
        </div>
        <!-- BEGIN FOOTER -->
        <p class="copyright"> 2017 &copy; WSYLP BLOB 版权所有 </p>
        <a href="#index" class="go2top">
            <i class="icon-arrow-up"></i>
        </a>
        <!-- END FOOTER -->
    </div>
</div>

<script src="resources/bootstrap-3.7/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/js/my.js" type="text/javascript"></script>
</body>

</html>