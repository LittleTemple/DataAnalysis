<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home</title>

		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Style.css -->
		<link href="css/style.css" rel="stylesheet">
		<!--添加的css-->
		<link href="css/company.css" rel="stylesheet" type="text/css">
		<!-- 百度地图 -->
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SON6KvLZWp3esBheB31afbDaDPhXK1Ll"></script>
	</head>
	<body>
		<%@include file="pageheader.jsp" %>
		<div class="section large transparent dark text-center" style="background-image: url('images/background01.jpg');">
			<div class="inner" >
				<div class="container" >
					<h1>企业信息族谱分析</h1>
					<p class="lead">Analysis of enterprise information genealogy.</p>
					<form action="${pageContext.request.contextPath }/CompanyServlet?method=searchAll"  class="newsletter-form" method="post">
						<input type="text" id="searchInput" name="CorpName" placeholder="What are you looking for ?">
						<input type="hidden" name="rpId" id="rpId" />
						<input type="hidden" name="ORG"  id="ORG" />
						<input type="hidden" name="ID"  id="ID"/>
						<input type="hidden" name="SEQ_ID"  id="SEQ_ID"/>
						<button type="submit" name="subscribe" class="button">搜    索 ···</button>
					</form>
				</div> <!-- end .container -->
				
				
				<!-- 选项卡切换模块 -->
				<!-- 基本信息 -->
				<div class="page1" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>基本信息</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
				
					<div id="outStruct">
						<c:if test="${not empty requestScope.companymeg}">
						<div id="tableWrapper">
							<table id="table_1">
								<tr>
									<td rowspan="4" style="width:18%;border: 1px solid #f1f2f6;">
										<img alt="" src="images/corpLogo.jpg" style="width:127px;height:165px"/>
									</td>
									<td colspan="2" style="font-size:18px;">公司名称：${requestScope.companymeg.CORP_NAME }</td>
								</tr>
								<tr>
									<td>电话：${requestScope.companymeg.TEL }</td>
									<td></td>
								</tr>
								<tr>
									<td>官网：${requestScope.companymeg.WEB_URL }</td>
									<td>邮箱：${requestScope.companymeg.EMAIL }</td>
								</tr>
								<tr>
									<td>地址:${requestScope.companymeg.ADDR }</td>
									<td>
										<a href="javascript:void(0)" id="updateMarker"  onclick="showLocation()">公司地图</a>
										<a href="javascript:void(0)" id="updateNear"  onclick="showNearLocation()">附近公司</a>
									</td>
								</tr>
							</table>
							
							<table id="table_2">
								<tr>
									<td>注册资本：</td>
									<td>${requestScope.companymeg.REG_CAPI } 万元</td>
									<td>成立日期：</td>
									<td>${requestScope.companymeg.START_DATE }</td>
								</tr>
								<tr>
									<td>经营状态：</td>
									<td>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '01'}">在业</c:if>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '02'}">注销</c:if>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '03'}">吊销</c:if>
										<c:if test="${requestScope.companymeg.CORP_STATUS eq '04'}">迁出</c:if>
									</td>
									<td>统一社会信用代码：</td>
									<td>${requestScope.companymeg.REG_NO }</td>
								</tr>
								<tr>
									<td>纳税人识别号：</td>
									<td>${requestScope.companymeg.TAXPAY_NUM }</td>
									<td>注册号：</td>
									<td>${requestScope.companymeg.UNI_SCID }</td>
								</tr>
								<tr>
									<td>组织机构代码：</td>
									<td>${requestScope.companymeg.ORG_INST_CODE }</td>
									<td>公司类型：</td>
									<td>${requestScope.companymeg.ECON_KIND }</td>
								</tr>
								<tr>
									<td>人员规模：</td>
									<td>${requestScope.companymeg.STAFF_SIZE }</td>
									<td>营业期限：</td>
									<td>${requestScope.companymeg.FARE_TERM_START }至${requestScope.companymeg.FARE_TERM_END }</td>
								</tr>
								<tr>
									<td>登记机关：</td>
									<td>${requestScope.companymeg.BELONG_ORG }</td>
									<td>核准日期：</td>
									<td>${requestScope.companymeg.CHECK_DATE }</td>
								</tr>
								<tr>
									<td>英文名：</td>
									<td>${requestScope.companymeg.ENGLISH_NAME }</td>
									<td>曾用名：</td>
									<td>${requestScope.companymeg.FORMER_NAME }</td>
								</tr>
								<tr>
									<td>所属地区：</td>
									<td>${requestScope.companymeg.BELONG_DIST_ORG }</td>
									<td>所属行业：</td>
									<td>${requestScope.companymeg.BELONG_TRADE }</td>
								</tr>
								<tr>
									<td>企业地址：</td>
									<td colspan="3">${requestScope.companymeg.ADDR}</td>
								</tr>
								<tr style="height:100px;">
									<td>经营范围：</td>
									<td colspan="3">${requestScope.companymeg.FARE_SCOPE }</td>
								</tr>
							</table>
						</div>
						</c:if>
					</div><!-- outStruct结束 -->
					<!-- 百度地图模块 -->
					<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
					  	<div class="modal-dialog" role="document">
							<div class="modal-content">
								  <div class="modal-header">
									  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									  <h5 class="modal-title" id="address">地址</h5>
								  </div>
								  <div class="modal-body" style="padding:none">
									 <div id="allmap" style="width:100%; height:400px;"></div>
								  </div>
								  <div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">退出</button>
								  </div>
							</div><!-- /.modal-content -->
					 	 </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
				</div>
				
				<!-- 股权结构 -->
				<div class="page2" style="display: none; margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>股权结构</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<div id="guquanjiegou" style="width:1000px;height:600px;padding-left:200px;">
							<div style="width: 10px;height:40px"></div>
							
							<svg width="1000" height="600" xmlns="http://www.w3.org/2000/svg">
								<g>
									<title>background</title>
							  		<rect x="-1" y="-1" width="652" height="502" id="canvas_background" fill="#fff"/>
							  		<g id="canvasGrid" display="none">
							   		<rect id="svg_3" width="100%" height="100%" x="0" y="0" stroke-width="0" fill="url(#gridpattern)"/>
							 		</g>
							 	</g>
							 	<text xml:space="preserve" text-anchor="start" font-family="Helvetica, Arial, sans-serif" font-size="24" id="svg_11" y="40" x="44.5" stroke-width="0" stroke="#000" fill="#000000">疑似实际控制人：</text>
							  	<text stroke="#000" transform="matrix(0.8367347121238708,0,0,0.7777777910232544,40.408158749341965,3.7777775526046753) " xml:space="preserve" text-anchor="start" font-family="Helvetica, Arial, sans-serif" font-size="24" id="svg_12" y="42.85714" x="230.96341" stroke-width="0" fill="#ea1919">XX</text>
							  	<line stroke="#000" stroke-linecap="null" stroke-linejoin="null" id="svg_14" y2="33" x2="360.5" y1="33" x1="293.5" fill-opacity="null" stroke-opacity="null" stroke-width="1.5" fill="none"/>
							  	<path fill="#fff" stroke="#000" stroke-width="1.5" d="m362.88755,32.86997l-3.89314,-7l7,7l-7,7l3.89314,-7z" id="svg_13"/>
							  	<text fill="#000000" stroke-width="0" x="371.45082" y="30.75" id="svg_16" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.7624999880790709,0,0,0.8888888955116272,88.26875463128088,11.2222221493721) " stroke="#000">XXX有限公司</text>
							  	<text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="306.92082" y="30.17647" id="svg_17" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.8381798157647964,0,0,0.6492140910363486,34.558682887319854,6.9659420227440165) " stroke="#000">80.88%</text>
							  	<rect fill="#15eded" stroke="#000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="119.5" y="60" width="19" height="14" id="svg_18"/>
							  	<rect fill="#aa56ff" stroke="#000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="218.5" y="59" width="19" height="14" id="svg_20"/>
							  	<rect fill="#ea1919" stroke="#000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="297.5" y="60" width="19" height="14" id="svg_21"/>
							  	<text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="198.05357" y="86" id="svg_22" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.4628099203109741,0,0,0.6666666865348816,51.838842689991,14.333332479000092) " stroke="#000">自然人股东</text>
							  	<text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="290.84801" y="84.89474" id="svg_35" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.40078598364932816,0,0,0.7037037014961243,127.73435796659706,12.740740835666656) " stroke="#000">企业股东</text>
							  	<text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="328.18421" y="84.63158" id="svg_36" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.5205479264259338,0,0,0.7037037014961243,153.6643895804882,13.92592602968216) " stroke="#000">大股东</text>
							
							  	<rect fill="#fff" stroke="#e5e5e5" stroke-width="1.5" x="114.5" y="94" width="333" height="50" id="svg_1"/>
							  	<text fill="#000000" stroke="#000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="177.5" y="127" id="svg_8" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve">江苏星网软件有限公司</text>
							  	<rect fill="#0000ff" stroke-width="1.5" stroke-opacity="null" fill-opacity="null" x="114.5" y="93" width="10" height="51" id="svg_5" stroke="#e5e5e5"/>
							  
								<g class="gudongcontent" style="opacity:1;">
								  <g>
								  <rect fill="#fff" stroke="#e5e5e5" stroke-width="1.5" x="145.5" y="169" width="333" height="50" id="svg_2"/>
								  <rect fill="#ea1919" stroke-width="1.5" stroke-opacity="null" fill-opacity="null" x="145.5" y="169" width="10" height="51" id="svg_6" stroke="#e5e5e5"/>
								  <text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="183.89055" y="202.53006" id="svg_9" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.6950605967339597,0,0,0.7118910979968902,64.83423914068378,46.37912216292612) " stroke="#000">XX</text>
								  <text fill="#b2b2b2" stroke-width="0" stroke-opacity="null" x="159.83549" y="232" id="svg_10" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.44770904136946754,0,0,0.6666666865348816,120.09123621516585,55.99999666213989) " stroke="#000">股权比例：</text>
								  <text fill="#ff7f00" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="271.7966" y="214.08081" id="svg_25" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.587061421479916,0,0,0.6766188636611759,88.35345609279665,67.38242777760415) " stroke="#000">50%</text>
								  <text fill="#b2b2b2" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="324.26191" y="212.5" id="svg_26" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.43298968672752375,0,0,0.6666666865348816,161.08763007819653,68.99999678134918) " stroke="#000">认缴金额：</text>
								  <text fill="#ff7f00" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="402.05681" y="215.07018" id="svg_27" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.4380552919084693,0,0,0.7179846620973365,176.7295903841338,57.21241098847371) " stroke="#000">XX万元</text>
								  <path fill="#fff" stroke="#ea1919" stroke-width="1.5" stroke-opacity="null" fill-opacity="null" opacity="0.5" d="m114.5,123c-54,36 31,71 31,71" id="svg_23"/>
								  </g>
								  
								  <g class="ziranrenxinxi" style="visibility:hidden">
								  <rect fill="#fff" stroke="#e5e5e5" stroke-width="1.5" x="145.5" y="229" width="333" height="50" id="svg_28"/>
								  <rect fill="#15eded" stroke-width="1.5" stroke-opacity="null" fill-opacity="null" x="145.5" y="229" width="10" height="51" id="svg_29" stroke="#e5e5e5"/>
								  <text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="183.89055" y="286.8126" id="svg_30" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.6950605967339597,0,0,0.7118910979968902,64.83423914068378,46.37912216292612) " stroke="#000">XX</text>
								  <text fill="#b2b2b2" stroke-width="0" stroke-opacity="null" x="159.83549" y="322" id="svg_31" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.44770904136946754,0,0,0.6666666865348816,120.09123621516585,55.99999666213989) " stroke="#000">股权比例：</text>
								  <text fill="#ff7f00" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="271.7966" y="302.75702" id="svg_32" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.587061421479916,0,0,0.6766188636611759,88.35345609279665,67.38242777760415) " stroke="#000">30%</text>
								  <text fill="#b2b2b2" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="324.26191" y="302.5" id="svg_33" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.43298968672752375,0,0,0.6666666865348816,161.08763007819653,68.99999678134918) " stroke="#000">认缴金额：</text>
								  <text fill="#ff7f00" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="402.05681" y="298.63742" id="svg_34" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.4380552919084693,0,0,0.7179846620973365,176.7295903841338,57.21241098847371) " stroke="#000">XX万元</text>
								  <path fill="#fff" stroke="#15eded" stroke-width="1.5" stroke-opacity="null" fill-opacity="null" opacity="0.5" d="m112.5,127c-23,114 29,128 29,128" id="svg_24"/>
								 </g>
								 
								 <g class="comxinxi" style="visibility:hidden">
								 <rect fill="#fff" stroke="#e5e5e5" stroke-width="1.5" x="145.5" y="290" width="333" height="50" id="svg_4"/>
								 <rect fill="#aa56ff" stroke-width="1.5" stroke-opacity="null" fill-opacity="null" x="145.5" y="290" width="10" height="51" id="svg_7" stroke="#e5e5e5"/>
								 <text fill="#000000" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="183.89055" y="372.49986" id="svg_15" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.6950605967339597,0,0,0.7118910979968902,64.83423914068378,46.37912216292612) " stroke="#000">XX</text>
								 <text fill="#b2b2b2" stroke-width="0" stroke-opacity="null" x="159.83549" y="413.5" id="svg_19" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.44770904136946754,0,0,0.6666666865348816,120.09123621516585,55.99999666213989) " stroke="#000">股权比例：</text>
								 <text fill="#ff7f00" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="271.7966" y="392.91117" id="svg_37" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.587061421479916,0,0,0.6766188636611759,88.35345609279665,67.38242777760415) " stroke="#000">20%</text>
								 <text fill="#b2b2b2" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="324.26191" y="394" id="svg_38" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.43298968672752375,0,0,0.6666666865348816,161.08763007819653,68.99999678134918) " stroke="#000">认缴金额：</text>
								 <text fill="#ff7f00" stroke-width="0" stroke-opacity="null" fill-opacity="null" x="402.05681" y="383.59745" id="svg_39" font-size="24" font-family="Helvetica, Arial, sans-serif" text-anchor="start" xml:space="preserve" transform="matrix(0.4380552919084693,0,0,0.7179846620973365,176.7295903841338,57.21241098847371) " stroke="#000">XX万元</text>
								 <path id="svg_41" d="m113.5,121c-50,146 32,196 31.5,196" opacity="0.5" fill-opacity="null" stroke-opacity="null" stroke-width="1.5" stroke="#aa56ff" fill="#fff"/>
								 </g>
								</g>
							 
							</svg>
						</div>
						<!-- outStruct-end -->
					</div>					
				</div>
				
				<!-- 投资族谱 -->
				<div class="page3" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>投资族谱</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<!-- 选择层级 -->
						<div class="content">
							<div class="content1 pull-right">
								<div class="fangxiang pull-right">
									<span class="glyphicon glyphicon-triangle-top tfx" onclick="shang()"></span>
									<span class="glyphicon glyphicon-triangle-bottom bfx" onclick="xia()"></span>
								</div>
					    		<div class="stockInput">一层</div>
					    	</div>
					   		<span class="desc pull-right">股东层级：</span>
    
    
						    <div class="content1 pull-right">
						    	<div class="fangxiang pull-right">
									<span class="glyphicon glyphicon-triangle-top tfx" onclick="shang1()"></span>
									<span class="glyphicon glyphicon-triangle-bottom bfx" onclick="xia1()"></span>
						    	</div>
						    	<div class="companyInput">一层</div>
						    </div>
						    <span class="desc pull-right">对外投资层级：</span>
						</div>
						<div style="height:5px;width:100%;"></div>
						<!-- 投资族谱图显示位置 -->
						<div id="showzupu" style="width:1000px;height:600px;"></div>
						
						<div>
							<input type="hidden" value="${requestScope.companymeg.CORP_NAME }" id="CORP_NAME"/>
						</div>
					</div>	
					
				</div>
				
				<!-- 企业族谱 -->
				<div class="page4" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>企业族谱</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<!-- 企业族谱图显示位置 -->
						<div id="corpzupu" style="width:1000px;height:600px;"></div>
						
						<div>
							<input type="hidden" value="${requestScope.companymeg.ORG }" id="CORP_ORG"/>
							<input type="hidden" value="${requestScope.companymeg.ORG }" id="CORP_ID"/>
							<input type="hidden" value="${requestScope.companymeg.SEQ_ID }" id="CORP_SEQ_ID"/>
						</div>
					</div>	
					
				</div>
				
				<!-- 疑似关系 -->
				<div class="page5" style="display: none;margin-top:-150px;">
					<div class="page-header">
						<div class="breadcrumbs" >
							<ul >
								<li><a href="#" onclick="changePage(this)">Home</a></li>
								<li>疑似关系</li>
							</ul>
						</div> <!-- end .breadcrumbs -->
					</div> <!-- end .page-header -->
					
					<div id="outStruct">
						<!-- 疑似关系图显示位置 -->
						<div id="yisiguanxi" style="width:1000px;height:600px;"></div>
					</div>	
					
				</div>
				
				
			</div> <!-- end .inner -->
		</div> <!-- end .section -->
		
		<!-- <button type="button" class="btn btn-primary" data-toggle="modal" onclick="tanchu('错误提示！')">小模态框</button> -->
		<!-- 错误提示框 -->
		<div id="myModal1" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		    <div class="modal-dialog modal-sm" role="document">
		    	<div class="modal-content">
		
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			          <h5 class="modal-title text-danger" id="mySmallModalLabel">警告</h5>
			        </div>
			        <div class="modal-body">
			          ...
			        </div>
		      
		      </div><!-- /.modal-content -->
		    </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<%@include file="loginandregister.jsp" %>
				
		
		<!-- jQuery -->
		<script src="js/jquery-3.1.0.min.js"></script>
		 <!--Scripts.js--> 
		<script src="js/scripts.js"></script>
		<!--bootstrap-->
		<script src="js/bootstrap.min.js"></script>
		<!-- 处理搜索栏部分 ，用了jquery ui部件-->
		<script src="js/jquery-ui.js"></script>
		<link rel="stylesheet" href="js/jquery-ui.css">
		<!-- 数据可视化画图 -->
		<script src="js/echarts.js"></script>
		<!--自己编写的数据库-->
		<script src="js/company.js"></script>
		

<c:if test="${not empty requestScope.companymeg}">
	<script>
		window.onload=changestatus('none','block','none','none','none','none');
	</script>
</c:if>

	</body>
</html>
<% if(request.getAttribute("loginResultInfo")!=null&&request.getAttribute("loginResultInfo").toString().equals("registerError")){ %>
	<script type="text/javascript">
		tanchu('注册失败!')
	</script>
	<%}
	if(request.getAttribute("loginResultInfo")!=null&&request.getAttribute("loginResultInfo").toString().equals("userError")){ %>
	<script type="text/javascript">
		tanchu('登录失败！');
	</script>
	<%}
%> 