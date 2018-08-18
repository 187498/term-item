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

    <!--顶部导航栏和右上角个人中心-->
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
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
          <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
          </button>


        </div>


        <!-- /#page-content-wrapper -->

    </div>

        <!--输入框和按钮-->
			<div class="container">
				<div class="row">
						<form class="form-horizontal" action="http://localhost:8080/zijinbao/query_user">
							<div class="col-md-4">
									<div class="form-group">
					                    <label for="inputEmail3" class="col-sm-3 control-label">姓名</label>
					                    <div class="col-sm-9">
					                    	<section>
					                        	<input type="text" class="form-control" id="inputEmail3" name="u_name" placeholder="姓名">
					                        </section>
					                    </div>
					                </div>
							</div>
							<div class="col-md-4">
					                <div class="form-group">
					                    <label for="inputEmail3" class="col-sm-3 control-label">账户</label>
					                    <div class="col-sm-9">
					                    	<section>
					                        	<input type="text" class="form-control" id="inputEmail3" name="u_account" placeholder="账户">
					                        </section>
					                    </div>
					                </div>
					                <div class="form-group">
					                    <div class="col-sm-offset-2 col-sm-10">
					                        <button id="newsSerch" type="submit" class="btn btn-primary btn-lg btn-block" value="查询" >查询</button>
					                    </div>
					                
					                </div>
					        </div>
							<div class="col-md-4">
									<div class="form-group">
					                    <label for="inputEmail3" class="col-sm-3 control-label">身份证</label>
					                    <div class="col-sm-9">
					                    	<section>
					                        	<input type="text" class="form-control" id="inputEmail3" name="u_id" placeholder="身份证">
					                        </section>
					                    </div>
					                </div>

							</div>
					    </form>
				</div>
			</div>
        <!--个人信息表格-->
        <div class="container" style="positon:relative; top: 1000px;">
            <table class="table" style="position: relative; width: 800px; left: 140px;">
                <tr style="font-family: 'Microsoft Sans Serif', Tahoma, Arial, Verdana, Sans-Serif">
                    <td>序号</td>
                    <td>账户</td>
                    <td>账户余额</td>
                    <td>姓名</td>
                    <td>详细地址</td>
                    <td>身份证号</td>
                    <td>电话</td>
                    <td>状态</td>
                    <td>冻结/启用</td>
                    <td>删除用户</td>
                </tr>
                <c:forEach items="${pageBean.list }" var="f" varStatus="status">
	                <tr>
	                    <td>${status.count }</td>
	                    <td>${f.user_account }</td>
	                    <td>${f.user_fund }</td>
	                    <td>${f.user_name }</td>
	                    <td>${f.user_addr }</td>
	                    <td>${f.user_id }</td>
	                    <td>${f.user_phone }</td>
	                    <td>${f.user_state == '1' ? '正常' : '冻结' }</td>
	                    <td><a style="color: blue" href="http://localhost:8080/zijinbao/change_user?u_account=${f.user_account }&u_state=${f.user_state}">${f.user_state == '1' ? '冻结' : '启用' }</a></td>
	                    <td><a style="color: blue" href="http://localhost:8080/zijinbao/delete_user?u_account=${f.user_account }">删除</a></td>
	                </tr>
				</c:forEach>
            </table>
        </div>

        <!--分页-->
                <div class="container">
	    	<div class="form row">
	        	<div class="col-md-4"></div>
	        	<div class="col-md-4">
			共有${requestScope.pageBean.totalRecord}个用户，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
            <br/>
            <a href="http://localhost:8080/zijinbao/all_user?pageNum=1">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum == 1}">
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="http://localhost:8080/zijinbao/all_user?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="http://localhost:8080/zijinbao/all_user?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">
                <a href="http://localhost:8080/zijinbao/all_user?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="http://localhost:8080/zijinbao/all_user?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="http://localhost:8080/zijinbao/all_user?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">
                <a href="http://localhost:8080/zijinbao/all_user?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="http://localhost:8080/zijinbao/all_user?pageNum=${i}">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="http://localhost:8080/zijinbao/all_user?pageNum=${requestScope.pageBean.totalPage}">尾页</a>
       		</div>
           		<div class="col-md-4"></div>
           	</div>
         </div>
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

</body>
</html>