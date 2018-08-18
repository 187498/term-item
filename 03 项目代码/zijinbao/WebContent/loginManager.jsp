<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%

//el表达式:${变量名}
String names="";
String pwd="";
//取出Cookie
Cookie [] c=request.getCookies();
for(int i=0;i<c.length;i++){
    if(c[i].getName().equals("users")){
        //存着数据（用户名+密码）
        names=c[i].getValue().split("-")[0];
        pwd=c[i].getValue().split("-")[1];
        
        //再一次的存起来（备用）
        request.setAttribute("xingming",names);
        request.setAttribute("mima", pwd);
    }
}

 %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员登陆</title>
    <script src="resource/js/jquery-1.9.0.min.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">
    
    <style type="text/css">
        body{
            background: url("img/1.jpg");
            animation-name:myfirst;
            animation-duration:12s;
            /*变换时间*/
            animation-delay:2s;
            /*动画开始时间*/
            animation-iteration-count:infinite;
            /*下一周期循环播放*/
            animation-play-state:running;
            /*动画开始运行*/
        }
        @keyframes myfirst
        {
            0%   {background:url("img/1.jpg");}
            34%  {background:url("img/2.jpg");}
            67%  {background:url("img/3.jpg");}
            100% {background:url("img/1.jpg");}
        }
        .form{
            background: rgba(255,255,255,0.2);width:1000px;margin:200px auto;
        }
        /*阴影*/
        .fa{
            display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;
        }
        /*input[type="text"],input[type="password"]{padding-left:26px;}
        .checkbox{
         	padding-left:21px;
        }*/
       /*  h3{display:inline;} */
    </style>
    <script>
        //产生验证码
        window.onload = function() {
            createCode()
        }
        var code; //在全局定义验证码
        function createCode() {
            code = "";
            var codeLength = 4; //验证码的长度
            var checkCode = document.getElementById("code");
            var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数
            for(var i = 0; i < codeLength; i++) { //循环操作
                var index = Math.floor(Math.random() * 36); //取得随机数的索引（0~35）
                code += random[index]; //根据索引取得随机数加到code上
            }
            checkCode.value = code; //把code值赋给验证码
        }
        //校验验证码

 
        	
    </script>
</head>
<body>
<!-- <form action="login_handler.jsp" method="post"> -->
	<div class="container">
	    <div class="form row">
	        <div class="col-md-4">
	        </div>
	        <div class="col-md-4">
	            <h3>管理员登录</h3><br>
	            	 <c:if test="${errmsg != null }">
							  <div class="alert alert-danger alert-dismissible" role="alert">
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  ${errmsg }
							  </div>
           			 </c:if>
	            <form onsubmit="return submitFun(this);" method="post" class="form-horizontal" action="http://localhost:8080/zijinbao/loginManager">
	                <div class="form-group">
	                    <label for="inputEmail3" class="col-sm-3 control-label">账户名</label>
	                    <div class="col-sm-9">
	                        <input type="text" class="form-control" id="inputEmail3" name="account" value="${xingming}" placeholder="账户名">
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="inputPassword3" class="col-sm-3 control-label">密码</label>
	                    <div class="col-sm-9">
	                        <input type="password" class="form-control" id="inputPassword3" name="pwd" value="${mima }" placeholder="密码">
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="inputPassword3" class="col-sm-3 control-label">验证码</label>
	                            <div class="col-sm-5">
	                                <input type="text" class="form-control" id="ctl00_txtcode" />
	                            </div>
	                            <div class="col-sm-4">
	                                <input type="button" class="btn btn-default" id="code" onclick="createCode()" />
	                            </div>
	                </div>
	                <div class="form-group">
	                    <div class="col-sm-offset-3 col-sm-10">
	                        <div class="checkbox" >
	                            <label>
	                                <input type="checkbox" name="ck">记住我
	                            </label><br>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <div class="col-sm-offset-2 col-sm-10">
	                        <button id="loginButton" type="submit" class="btn btn-primary btn-lg btn-block" value="登录" >登录</button>
	                    </div>
	                </div>
	                <a href="loginUser.jsp" class="col-sm-offset-4">&nbsp;&nbsp;&nbsp;用户登录</a><br><br><br><br>
	            </form>
	            <script type="text/javascript">
	            function submitFun(obj){
	
	                var inputCode = document.getElementById("ctl00_txtcode").value.toUpperCase(); //获取输入框内验证码并转化为大写
	                var inputAccount = document.getElementById("inputEmail3").value;
	                var inputPassword = document.getElementById("inputPassword3").value;
					if(inputCode.length <= 0) { //若输入的验证码长度为0
	                    alert("请输入验证码！"); //则弹出请输入验证码
	                    return false;
	                }
	                else if(inputCode != code) { //若输入的验证码与产生的验证码不一致时
	                    alert("验证码输入错误!"); //则弹出验证码输入错误
	                    createCode(); //刷新验证码
	                    document.getElementById("ctl00_txtcode").value = "";//清空文本框
	                    return false;
	                }
					//return true;
	          }
	            </script>
	        </div>
	            <div class="col-md-4">
	            </div>
	        </div>
	    </div>
    <!-- </form> -->
</body>
</html>