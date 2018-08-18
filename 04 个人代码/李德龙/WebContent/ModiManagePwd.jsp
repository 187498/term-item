<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>

    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/component.css" />


    <script src="resource/js/jquery-1.9.0.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" href="css/OtherNavstyle.css">
    <!--<style>-->
    <!--a{-->
    <!--text-decoration:none;-->
    <!--}-->
    <!--</style>-->


    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>

<nav class="navbar navbar-default" style="height: 70px; border: #000000">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>


            <form class="navbar-form navbar-left">

            </form>
            <ul class="nav navbar-nav navbar-right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="border: 0px; right:50px; top: 13px;">
                            ${manager.manager_name }  <span class="caret"></span>&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/man.png">
                        </button>
                        <ul class="dropdown-menu">
                           
                            <li><a href="loginManager.jsp">注销</a></li>
                        </ul>
                    </div>
                </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>



    <!--左侧导航栏-->
 	<div id="wrapper">
        <div class="overlay"></div>
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        <img src="img/man.png">&nbsp;&nbsp;&nbsp;${manager.manager_name }
                    </a>
                </li>
                <li>
                    <a href="http://localhost:8080/zijinbao/all_user?pageNum=1"><i class="fa fa-fw fa-home"></i>所有用户</a>
                </li>
                <li>
                    <a href="http://localhost:8080/zijinbao/f_user?pageNum=1"><i class="fa fa-fw fa-folder"></i>已冻结用户</a>
                </li>
                <li>
                    <a href="http://localhost:8080/zijinbao/uf_user?pageNum=1"><i class="fa fa-fw fa-file-o"></i>已启用用户</a>
                </li>
                <li>
                    <a href="CreateUser.jsp"><i class="fa fa-fw fa-cog"></i>开户</a>
                </li>
                <li>
                    <a href="http://localhost:8080/zijinbao/NewsMPage?pageNum=1"><i class="fa fa-fw fa-bank"></i>新闻管理</a>
                </li>
                <li>
                    <a href="ModiManagePwd.jsp"><i class="fa fa-fw fa-twitter"></i>修改密码</a>
                </li>
            </ul>
        </nav>

    <!--输入框和按钮(不要改id!!!!)-->
    <h1 style="color: #000000; text-align: center">修改管理员密码</h1>
    
    	<div class="container">
	    <div class="form row">
	        <div class="col-md-4">
	        </div>
	        <div class="col-md-4">
	          
	            <form class="form-horizontal" method="post" action="http://localhost:8080/zijinbao/ModiManagePwd">
	            <c:if test="${success != null }">
							  <div class="alert alert-success alert-dismissible" role="alert">
								  修改密码成功
							  </div>
           			 </c:if>
	            <c:if test="${errMessage!=null}">
							  <div class="alert alert-danger alert-dismissible" role="alert">
								  ${errMessage}
							  </div>
           			 </c:if>
           		
           			 
           			 <hr>
	             	 <div class="form-group">
	                    <label for="inputEmail9" class="col-sm-3 control-label">账号</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="inputEmail9" readonly name="m_account" value="${manager.manager_account }">
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="inputEmail3" class="col-sm-3 control-label">原密码</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="inputEmail3" name="oldPwd" placeholder="原密码">
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="inputPassword3" class="col-sm-3 control-label">新密码</label>
	                    <div class="col-sm-9">
	                        <input type="password" class="form-control" id="inputPassword3" name="newPwd" placeholder="新密码">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                    <label for="inputPassword4" class="col-sm-3 control-label">新密码</label>
	                    <div class="col-sm-9">
	                        <input type="password" class="form-control" id="inputPassword4" name="newPwd2" placeholder="确认新密码">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                        <button id="affirmButton" type="submit" class="btn btn-primary btn-lg btn-block" value="确认" >确认</button>
	                    </div>
	                </div>
	            </form>
	           
	        </div>
	            <div class="col-md-4">
	            </div>
	        </div>
	    </div>
    <!--<section style="position:relative; text-align: center; top: 50px">
        <form class="input input--ichiro">
           
            <input class="input__field input__field--ichiro" type="password" id="input-26" name="pwd"/>
            <label class="input__label input__label--ichiro" for="input-26">
                <span class="input__label-content input__label-content--ichiro">请输入新密码</span>
            </label>
        </form>
    </section>-->

    



    <!--左上角的汉堡-->
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>

    </div>
</div>


<!--这里控制输入框特效-->
<script src="js/classie.js"></script>
<script>
    (function() {
        // trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
        if (!String.prototype.trim) {
            (function() {
                // Make sure we trim BOM and NBSP
                var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                String.prototype.trim = function() {
                    return this.replace(rtrim, '');
                };
            })();
        }

        [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
            // in case the UserUI is already filled..
            if( inputEl.value.trim() !== '' ) {
                classie.add( inputEl.parentNode, 'input--filled' );
            }

            // events:
            inputEl.addEventListener( 'focus', onInputFocus );
            inputEl.addEventListener( 'blur', onInputBlur );
        } );

        function onInputFocus( ev ) {
            classie.add( ev.target.parentNode, 'input--filled' );
        }

        function onInputBlur( ev ) {
            if( ev.target.value.trim() === '' ) {
                classie.remove( ev.target.parentNode, 'input--filled' );
            }
        }
    })();
</script>

<!--这里控制左边的菜单的特效-->
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

<!--<script>-->
<!--function check() {-->
<!--var pwd1 = document.getElementById("input-25");-->
<!--var pwd2 = document.getElementById("input-26");-->
<!--if (pwd1.value!==pwd2.value) {-->
<!--checkPwd.style.color="red";-->
<!--checkPwd.innerHTML="密码输入不一致";-->
<!--return false;-->

<!--}-->
<!--else {-->
<!--return true;-->
<!--}-->
<!--}-->
<!--</script>-->

</body>
</html>
    