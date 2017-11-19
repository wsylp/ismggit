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
    <link href="resources/bootstrap-3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="resources/layout/css/components.min.css" rel="stylesheet" id="style_components"
          type="text/css"/>
    <link href="resources/layout/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/css/custom.min.css" rel="stylesheet" type="text/css"/>
    <link href="resources/layout/datatable/css/jquery.dataTables.min.css" rel="stylesheet"
          type="text/css"/>

    <link href="resources/css/music/popMusic.css" rel="stylesheet" type="text/css"/>

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
                        <li class="dropdown dropdown-fw dropdown-fw-disabled ">
                            <a href="javascript:;" class="text-uppercase">
                                <i class="icon-home"></i> 我的博客 </a>
                            <ul class="dropdown-menu dropdown-menu-fw">
                                <li>
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
                        <li class="dropdown dropdown-fw dropdown-fw-disabled  active open selected  ">
                            <a href="javascript:;" class="text-uppercase">
                                <i class="icon-puzzle"></i> 音乐 </a>
                            <ul class="dropdown-menu dropdown-menu-fw">
                                <li class="dropdown more-dropdown-sub active">
                                    <a href="javascript:;">
                                        <i class="icon-diamond"></i> 排行榜 </a>
                                    <ul class="dropdown-menu">
                                        <li class="active">
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
            <div class="row childTitle">
                <div class="col-xs-3">
                    <div class="childTxt">音乐之家</div>
                </div>
                <div class="pull-right col-xs-2" id="breadcrumb">
                    <div class="pull-right">
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">首页</a>
                            </li>
                            <li>音乐</li>
                            <li class="active"> <a href="#">流行榜</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row action">
                <div class="pull-left">
                    <button type="button" class="btn btn-primary"><i
                            class="fa fa-plus"></i> 收藏
                    </button>
                    <button type="button" class="btn btn-danger" ><i
                            class="fa fa-heart"></i> 我喜欢
                    </button>
                </div>
                <div class="pull-right" style="width: 250px;">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="模糊查询"
                               id="fuzzy-search">
                        <a class="btn input-group-addon" id="btn-simple-search"><i
                                class="fa fa-search"></i>
                        </a>
                        <a class="btn input-group-addon" title="高级查询" data-toggle="collapse"
                           data-parent="#accordion" href="#collapseOne">
                            <i class="fa fa-angle-double-down"></i>
                        </a>
                    </div>
                </div>
            </div>

            <div class="panel-collapse collapse row" style="" id="collapseOne">
                <form class="form-inline well" role="form">
                    <span>音乐名:</span>
                    <input type="text" class="form-control" placeholder="音乐名" id="name-search">
                    <span>歌手:</span>
                    <input type="text" class="form-control" placeholder="歌手" id="position-search">
                    <button type="button" class="btn btn-primary" id="btn-advanced-search"><i
                            class="fa fa-search"></i> 查询
                    </button>
                </form>
            </div>
            <table id="musicTable" class="display" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>音乐名称</th>
                    <th>歌手</th>
                    <th>文件名</th>
                    <th>创建时间</th>
                </tr>
                </thead>
            </table>
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
<script src="resources/layout/datatable/js/jquery.dataTables.min.js"
        type="text/javascript"></script>
<script src="resources/layout/datatable/js/dataTables.bootstrap.min.js"
        type="text/javascript"></script>
<script src="resources/layout/moment/moment-with-locales.js"></script>
<script src="resources/js/music/musicPopular.js"></script>
<script>
  $(function() {
    $.ajax({
      type: 'get',
      url: 'http://localhost:8080/ismg/ws/rest/user',
      dataType: 'jsonp',
      jsonp: '_jsonp',
      jsonpCallback: 'callback',
      success: function(data) {
       console.log(data);
      }
    });
  });

</script>
</body>

</html>