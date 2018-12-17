<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 登陆模块 -->
<div class="login-wrapper">
	<div class="login">
		<form action="${pageContext.request.contextPath }/UserServlet?method=login" method="post">
			<div class="form-group">
				<input type="text" placeholder="账号 *" name="account">
			</div>
			<!-- end .form-group -->
			<div class="form-group">
				<input type="password" placeholder="密码 *" name="password">
			</div>
			<!-- end .form-group -->
			<div class="clearfix">
				<div class="checkbox">
					<label> <input type="checkbox" name="rememberMe"> 记住我
					</label>
				</div>
				<a href="" class="lost-password">忘记密码 ?</a>
			</div>
			<!-- end .clearfix -->
			<div class="button-wrapper">
				<button type="submit" class="button">登录</button>
			</div>
			<div class="text-center">
				<p>
					注册新账户 ? <a href="" class="signup-open">注册</a>
				</p>
				<div class="social">
					<p>第三方平台登录</p>
					<a href=""><img src="images/facebook.png" alt="facebook"></a>
					<a href=""><img src="images/twitter.png" alt="twitter"></a> <a
						href=""><img src="images/google-plus.png" alt="google plus"></a>
				</div>
				<!-- end .social -->
			</div>
		</form>
	</div>
	<!-- end .login -->
</div>
<!-- end .login-wrapper -->

<!-- 注册模块 -->
<div class="signup-wrapper">
	<div class="signup">
		<form action="${pageContext.request.contextPath }/UserServlet?method=register" method="post">
			<div class="form">
				<input type="text" placeholder="账户*" id="account" name="account">
				<div id="userexist" style="height:30px"></di'v>
			</div>
			<!-- end .form-group -->
			<div class="form">
				<input type="password" placeholder="密码*" id="password" name="password" >
				<div id="passwordresult" style="height:30px"></div>
			</div>
			<!-- end .form-group -->
			<div class="form">
				<input type="password" placeholder="验证密码*" id="password1" name="password1">
				<div id="passwordresult1" style="height:30px"></div>
			</div>
			<!-- end .form-group -->
			<div class="button-wrapper">
				<button type="submit" class="button">注册</button>
			</div>
			<div class="text-center">
				<p>
					已经注册账户? <a href="" class="login-open">登录</a>
				</p>
				<div class="social">
					<p>第三方平台登录</p>
					<a href=""><img src="images/facebook.png" alt="facebook"></a>
					<a href=""><img src="images/twitter.png" alt="twitter"></a> <a
						href=""><img src="images/google-plus.png" alt="google plus"></a>
				</div>
				<!-- end .social -->
			</div>
		</form>
	</div>
	<!-- end .signup -->
</div>
<!-- end .signup-wrapper -->
