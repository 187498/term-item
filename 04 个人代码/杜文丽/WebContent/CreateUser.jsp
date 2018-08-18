<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <script src="resource/js/jquery-1.9.0.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">

    <!--下拉框样式-->
    <style type="text/css">
        select{
            padding: 5px;
            border-radius: 5px;
            outline: none;
        }
    </style>

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
        
        
        
        <div class="container">
	    <div class="form row">
	        <div class="col-md-4">
	        </div>
	        <div class="col-md-4">
	            <form onsubmit="return submitFun(this);" method="post" class="form-horizontal" action="http://localhost:8080/zijinbao/CreateUser">
	                 <c:if test="${success != null }">
							  <div class="alert alert-success alert-dismissible" role="alert">
								 ${success }
							  </div>
           			 </c:if>
	                
	                <c:if test="${fail != null}">
							  <div class="alert alert-danger alert-dismissible" role="alert">
								  ${fail}
							  </div>
           			 </c:if>
	                
	                
	                
	                <div class="form-group">
	                    <label for="u_name" class="col-sm-3 control-label">用户姓名</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="u_name" name="name" placeholder="姓名">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                    <label for="u_account" class="col-sm-3 control-label">账户名</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="u_account" name="account" placeholder="账户名">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                    <label for="u_pwd1" class="col-sm-3 control-label">密码</label>
	                    <div class="col-sm-9">
	                        <input type="password" class="form-control" id="u_pwd1" name="pwd1"  placeholder="密码">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                    <label for="u_pwd2" class="col-sm-3 control-label">确认密码</label>
	                    <div class="col-sm-9">
	                        <input type="password" class="form-control" id="u_pwd2" name="pwd2" placeholder="确认密码">
	                    </div>
	                </div>
	                
	                
	                 <div class="form-group">
	                    <label for="u_id" class="col-sm-3 control-label">身份证号</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="u_id" name="user_id" placeholder="身份证号">
	                    </div>
	                </div>
	                
	                
	                 <div class="form-group">
	                    <label for="u_phone" class="col-sm-3 control-label">手机号</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="u_phone" name="phone" placeholder="手机号">
	                    </div>
	                </div>
	                
	                 <div class="form-group">
	                    <label for="u_addr" class="col-sm-3 control-label">家庭地址</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="u_addr" name="address" placeholder="家庭地址">
	                    </div>
	                </div>
	                
	                
	                 <div class="form-group">
	                    <label for="u_money" class="col-sm-3 control-label">开户金额</label>
	                    <div class="col-sm-9">
	                        <input type="number" class="form-control" id="u_money" name="money" " placeholder="开户金额" >
	                    </div>
	                </div>
	            
	            
	            <div class="form-group">
	                    <label for="u_email" class="col-sm-3 control-label">邮箱</label>
	                    <div class="col-sm-9">
	                        <input type="email" class="form-control" id="u_email" name="email" " placeholder="邮箱">
	                    </div>
	                </div>
	                
	          
	                  <div class="form-group">
	                    <label for="u_birth" class="col-sm-3 control-label">生日</label>
	                    <div class="col-sm-9">
	                        <input type="date" class="form-control" id="birth" name="u_birth" " placeholder="生日" >
	                    </div>
	                </div>
	                
	                
	                
	                        <!--性别选择下拉框-->
			         <div class="form-group">
			                    <label for="gender" class="col-sm-3 control-label">性别</label>
			                    <div class="col-sm-9">
			                        <input type="radio" name="gender" value="男" checked>男
			                        <input type="radio" name="gender" value="女" >女
			                    </div>
			         </div>
	                
	                
	                
	              
	                <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                        <button id="loginButton" type="submit" class="btn btn-primary btn-lg btn-block" >确认</button>
	                    </div>
	                </div>
	            </form>
	            
	            <!-- 判断用户输入的信息是否完整 -->
<script type="text/javascript">
function submitFun(obj){
	var u_Pwd1 = document.getElementsByName('u_pwd1').value;
	var u_Pwd2=document.getElementsByName('u_pwd2').value;
	var u_account =document.getElementsByName('u_account').value;
	var u_money =document.getElementsByName('u_money').value;
	var u_name =document.getElementsByName('u_name').value;
	var u_addr =document.getElementsByName('u_addr').value;
	var u_phone =document.getElementsByName('u_phone').value;
	var u_id =document.getElementsByName('u_id').value;
	var u_email =document.getElementsByName('u_email').value;
	var u_gender =document.getElementsByName('u_gender').value;
	var u_birth =document.getElementsByName('u_birth').value;
	if(u_Pwd1.length<=0 || u_Pwd2.length<=0 || u_account.length<=0  || u_money.length<=0  || u_name.length<=0  || u_addr.length<=0  || u_phone.length<=0  || u_id.length<=0  || u_email.length<=0  || u_gender.length<=0  || u_birth.length<=0  )
	{
		alert("请填写完整信息");
		return false;
	}
	
}


</script>
	        </div>
	            <div class="col-md-4">
	            </div>
	        </div>
	    </div>
        


	   <!-- <section style="position:relative; text-align:center; top: 35px">
        <p style="position: relative;top: 95px;color: red;left: 850px;">*</p>
        <h5 style="position: relative;top: 30px">出生日期</h5> -->

        <!--出生日期下拉框-->
       <!--  <div id="date" style="margin-left: 430px;margin-top: 50px;">
            <select name="year" id="year">
                <option value="year">选择年份</option>
            </select>
            <select name="month" id="month">
                <option value="month">选择月份</option>
            </select>
            <select id="days" class="day">
                <option value="day">选择日期</option>
            </select>
        </div>
       </section>
        -->

      
       
       
     

       
        <!--左上角汉堡-->
        <div id="page-content-wrapper" class="form-group">
            <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
                <span class="hamb-top"></span>
                <span class="hamb-middle"></span>
                <span class="hamb-bottom"></span>
            </button>

        </div>
    



    <!--控制出生日期下拉框联动-->
   <!--  <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/select.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#date").selectDate()

            $("#days").focusout(function(){
                var year = $("#year option:selected").html()
                var month = $("#month option:selected").html()
                var day = $("#days option:selected").html()
                console.log(year+month+day)
            })

        })

    </script>
     -->



   
    <!--控制左侧导航栏特效-->
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