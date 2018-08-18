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


    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>

    <!--顶部栏和右上角个人中心-->
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
                    <a href="PersonalInfo.html">
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
                    <a href="ModiManagePwd.jsp"><i class="fa fa-fw fa-twitter"></i>修改密码</a>-->
                </li>
            </ul>
        </nav>

        <p style="color: #000000;position: relative;left: 1000px;">当前位置：新闻管理->新增新闻</p>
        <!--中间的三个输入框-->
        <form onsubmit="return submitFun(this);" action="http://localhost:8080/zijinbao/n_add">
	        <p style="color: #000000; position: relative; left:380px; top:50px">标题</p>
	        <textarea name="n_title" id="title" style="position: relative; top: 50px;left: 380px;"></textarea>
	        <p style="color: #000000; position: relative; left:380px; top:90px">正文内容</p>
	        <div style="position: relative; top: 90px;left: 380px;">
	            <textarea name="n_message" id="message" onkeyUp="textLimitCheck(this, 255);" style="height: 250px; width: 500px;"></textarea>
	            <br>
	            <font color=#666666>限 255 个字符  已输入 <font color="#CC0000"><span id="messageCount">0</span></font> 个字</font>
	        </div>
	        <button type="submit" class="btn btn-default" style="position: relative;top: 150px;left: 570px; width: 100px;">确定</button><br><br><br>
		        <script type="text/javascript">
						            function submitFun(obj){
						                var input = document.getElementById("title").value;
						                var input2 = document.getElementById("message").value;
										if(input.length <= 0 || (input2.length <=0)) { //若输入的验证码长度为0
						                    alert("请完善新闻信息！"); //则弹出请输入验证码
						                    return false;
						                }
						          	}
		         </script>
			</form>


        <!--左上角的汉堡-->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
                <span class="hamb-top"></span>
                <span class="hamb-middle"></span>
                <span class="hamb-bottom"></span>
            </button>

        </div>
    </div>



    <!--输入框的js代码-->
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

    <!--左侧导航栏的js代码-->
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

    <!--字数限制的js代码-->
    <script>
    function textLimitCheck(thisArea, maxLength){
        if (thisArea.value.length > maxLength){
            alert(maxLength + ' 个字限制. \r超出的将自动去除.');
            thisArea.value = thisArea.value.substring(0, 20);
            thisArea.focus();    }    /*回写span的值，当前填写文字的数量*/
        messageCount.innerText = thisArea.value.length;
    }


    </script>
</body>
</html>