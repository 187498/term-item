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
    <!--右上角的按钮-->
    <nav class="navbar navbar-default" style="height: 70px; border: #000000">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header"></div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav"></ul>
                <form class="navbar-form navbar-left"></form>
                <ul class="nav navbar-nav navbar-right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="border: 0px; right:50px; top: 13px;">
                            ${user.user_name }  <span class="caret"></span>&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/man.png">
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="http://localhost:8080/zijinbao/Display?account=${user.user_account }&password=${user.password}">查看个人信息</a></li>
                            <li><a href="ModiPerInfo.jsp">修改个人信息</a></li>
                            <li><a href="ModiPwd.jsp">修改密码</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">注销</a></li>
                        </ul>
                    </div>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>


    <!--<h2 style="position: relative; top: 50px; left: 520px; font-family: 微软雅黑; color: #000000">查询转账记录</h2>-->
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


        <!--查询表格-->
        <div class="container">
            <table class="table" style="position: relative; width: 800px; left: 140px;">
	            <tr style="font-family: 'Microsoft Sans Serif', Tahoma, Arial, Verdana, Sans-Serif">
	                <td>序号</td>
	                <td>对方账户</td>
	                <td>交易金额</td>
	                <td>交易类型</td>
	                <td>交易日期</td>
	            </tr>
                <c:forEach items="${pageBean.list }" var="f" varStatus="status">
	                <tr style="font-family: 'Microsoft Sans Serif', Tahoma, Arial, Verdana, Sans-Serif">
	                    <td>${status.count }</td>
	                    <td>${f.in_account == user.user_account ? f.out_account : f.in_account }</td>
	                    <td>${f.funds }</td>
	                    <td>${f.in_account == user.user_account ? '转入' : '转出' }</td>
	                    <td>${f.date }</td>
	                </tr>
                </c:forEach>

            </table>
        </div>
        <!--翻页按钮-->
        <p>
        </p>
        <p>
        </p>
        <p>
        </p>
        <div class="container">
	    	<div class="form row">
	        	<div class="col-md-4"></div>
	        	<div class="col-md-4">
			共有${requestScope.pageBean.totalRecord}条记录，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
            <br/>
            
            <!-- 如果只有一页 -->
            <c:if test="${requestScope.pageBean.totalPage == 0}">                  
            </c:if>
            <c:if test="${requestScope.pageBean.pageNum == 1 && requestScope.pageBean.totalPage == 1}">
            1
            </c:if>

            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum == 1 && requestScope.pageBean.totalPage != 1 && requestScope.pageBean.totalPage != 0}">
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=1&user_account=${user.user_account }">首页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                	
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="http://localhost:8080/zijinbao/t_r?pageNum=${i}&user_account=${user.user_account }">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.pageNum+1}&user_account=${user.user_account }">下一页</a>   
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.totalPage}&user_account=${user.user_account }">尾页</a>                 
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">
            	<a href="http://localhost:8080/zijinbao/t_r?pageNum=1&user_account=${user.user_account }">首页</a>
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.pageNum-1}&user_account=${user.user_account }">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="http://localhost:8080/zijinbao/t_r?pageNum=${i}&user_account=${user.user_account }">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.pageNum+1}&user_account=${user.user_account }">下一页</a>   
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.totalPage}&user_account=${user.user_account }">尾页</a> 
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage && requestScope.pageBean.totalPage != 1 && requestScope.pageBean.totalPage != 0}">
            	<a href="http://localhost:8080/zijinbao/t_r?pageNum=1&user_account=${user.user_account }">首页</a>
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.pageNum-1}&user_account=${user.user_account }">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="http://localhost:8080/zijinbao/t_r?pageNum=${i}&user_account=${user.user_account }">${i}</a>                                        
                    </c:if>                
                </c:forEach>
                <a href="http://localhost:8080/zijinbao/t_r?pageNum=${requestScope.pageBean.totalPage}&user_account=${user.user_account }">尾页</a>
            </c:if>
            <%--尾页 --%>
            
		    </div>
           	<div class="col-md-4"></div>
           	</div>
         </div>

    <!--左侧导航栏-->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
                <span class="hamb-top"></span>
                <span class="hamb-middle"></span>
                <span class="hamb-bottom"></span>
            </button>

        </div>
    </div>



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