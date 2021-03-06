<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>资金宝</title>
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
	<link rel="stylesheet" href="css/MainUINavstyle.css">
    <link rel="stylesheet" href="css/lunbostyle.css">
</head>
<body>

    <!--左侧导航栏-->
	<div id="wrapper">
        <div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="http://localhost:8080/zijinbao/Display?account=${user.user_account }&password=${user.password}">
                        <img src="img/man2.png">&nbsp;&nbsp;&nbsp;${user.user_name }
                    </a>
                </li>
               <li>
                    <a href="http://localhost:8080/zijinbao/t_r?pageNum=1&user_account=${user.user_account }"><i class="fa fa-fw fa-home"></i>查询交易记录</a>
                </li>
                <li>
                    <a href="Deposit.jsp"><i class="fa fa-fw fa-folder"></i>存款</a>
                </li>
                <li>
                    <a href="Withdraw.jsp"><i class="fa fa-fw fa-file-o"></i>取款</a>
                </li>
                <li>
                    <a href="Transfer.jsp"><i class="fa fa-fw fa-cog"></i>转账</a>
                </li>
                <li>
                    <a href="http://localhost:8080/zijinbao/NewsPage?pageNum=1"><i class="fa fa-fw fa-bank"></i>查看新闻</a>
                </li>
                <li>
                    <a href="ModiPwd.jsp"><i class="fa fa-fw fa-twitter"></i>修改密码</a>
                </li>
                <li>
                    <a href="loginUser.jsp"><i class="fa fa-fw fa-dropbox"></i>注销</a>
                </li>
                
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- 左上角汉堡 -->
        <div id="page-content-wrapper">
          <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
          </button>
        </div>
    </div>



    <!--中间的导播-->
    <div class="cont">
        <div class="mouse"></div>
        <div class="app">
            <div class="app__bgimg">
                <div class="app__bgimg-image app__bgimg-image--1"> </div>
                <div class="app__bgimg-image app__bgimg-image--2"> </div>
            </div>
            <div class="app__img"> <img onmousedown="return false" src="img/whiteTest4.png" alt="city" /> </div>
            <div class="app__text app__text--1">
                <div class="app__text-line app__text-line--4">欢迎${user.user_name } </div>
                <div class="app__text-line app__text-line--3">资金宝</div>
                <div class="app__text-line app__text-line--2">您身边的好帮手</div>
                <div class="app__text-line app__text-line--1"><img src="img/opus-attachment.png" alt="" /></div>
            </div>
            <div class="app__text app__text--2">
                <div class="app__text-line app__text-line--4">欢迎使用资金宝</div>
                <div class="app__text-line app__text-line--3">点击左侧菜单</div>
                <div class="app__text-line app__text-line--2">祝您使用愉快</div>
                <div class="app__text-line app__text-line--1"><img src="img/opus-attachment.png" alt="" /></div>
            </div>
        </div>
        <div class="pages">
            <ul class='pages__list'>
                <li data-target='1' class='pages__item pages__item--1 page__item-active'></li>
                <li data-target='2' class='pages__item pages__item--2'></li>
            </ul>
        </div>
    </div>

    <!--导播的特效-->
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script  src="js/index.js"></script>

    <!--左侧下拉框的特效-->
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
	<script type="text/javascript">


		$(document).ready(function () {
		  var trigger = $('.hamburger'),
		      overlay = $('.overlay'),
		     isClosed = false;

		    trigger.click(function () {
		      hamburger_cross();      
		    });

		    function hamburger_cross() {

		      if (isClosed == true) {          
		        overlay.hide();
		        trigger.removeClass('is-open');
		        trigger.addClass('is-closed');
		        isClosed = false;
		      } else {   
		        overlay.show();
		        trigger.removeClass('is-closed');
		        trigger.addClass('is-open');
		        isClosed = true;
		      }
		  }
		  
		  $('[data-toggle="offcanvas"]').click(function () {
		        $('#wrapper').toggleClass('toggled');
		  });  
		});
	</script>

</body>
</html>
    