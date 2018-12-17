<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 头部导航栏 -->  
<header class="header fixed clearfix">
	<div class="left">
		<div class="logo"><a href="index.jsp"><img src="images/logo.png" class="img-responsive"></a></div> 
		<!-- end .logo -->
		<form class="header-search" action="${pageContext.request.contextPath }/CompanyServlet?method=searchAll" id="searchForm" method="post">
			<input type="text" placeholder="搜索"  id="searchInputTop" name="CorpName">
			<input type="hidden" name="ORG"  id="ORG_top" />
			<input type="hidden" name="ID"  id="ID_top"/>
			<input type="hidden" name="SEQ_ID"  id="SEQ_ID_top"/>
			<button type="submit" class="btn btn-default"  style="outline: none;">
				<span class="glyphicon glyphicon-search"></span>
			</button>
		</form>
	</div> 
	<!-- end .left -->
			
	<div class="navigation clearfix">
		<nav class="main-nav">
			<ul class="list-unstyled">
				<li class="menu-item-has-children">
					<a href="#" id="card1" class="tip" onclick="changePage(this)">基本信息</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card2" class="tip" onclick="changePage(this)">股权结构</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card3" class="tip" onclick="changePage(this)">投资族谱</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card4" class="tip" onclick="changePage(this)">企业族谱</a>
				</li>
				<li class="menu-item-has-children">
					<a href="#" id="card5" class="tip" onclick="changePage(this)">疑似关系</a>
				</li>
			</ul>
		</nav> <!-- end .main-nav -->
	</div> <!-- end .navigation -->
		
	<div class="right">
		
		<c:if test="${sessionScope.loginedUser != null }">
		<div style='background-color:#00b0ff;font-size:15px;position:relative;top:40px;height:40px;border-radius:3px;line-height:40px;'>
			<a href="#" style="color:white;">欢迎您！${sessionScope.loginedUser.account}
				<img alt="" src="${sessionScope.loginedUser.headImg}" style="width:25px;height:25px;margin-top:-5px;">
			</a>
			<a href="UserServlet?method=loginOff" style="color:white;">注销</a>
		</div>
		</c:if>
		<c:if test="${sessionScope.loginedUser == null }">
			<a href="" class="button login-open">登录</a>
		</c:if>
		
	</div> <!-- end .left -->
		
</header> <!-- end .header -->
		

				