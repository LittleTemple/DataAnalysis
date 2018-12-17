<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>资讯列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资讯管理 <span
        class="c-gray en">&gt;</span> 资讯列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
        <span class="select-box inline">
            <form action="${pageContext.request.contextPath }/CompanyServlet?method=searchAll" class="newsletter-form" method="post">
				<input type="text" name="CorpName" id="searchInput" placeholder=" 企业名称" style="width:400px" class="input-text">
				<input type="hidden" name="rpId" id="rpId"/>
                <input type="hidden" name="ORG" id="ORG"/>
                <input type="hidden" name="ID" id="ID"/>
                <input type="hidden" name="SEQ_ID" id="SEQ_ID"/>
                <input type="hidden" id="sender" value="search" />
                <button name="subscribe" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜一搜</button>
			</form>
        </span>
    </div>
    <div id="outStruct">
        <c:if test="${not empty requestScope.companymeg}">
            <div id="tableWrapper">
                <div class="page-container">
                    <table class="table table-border table-bordered table-bg">
                        <tr>
                            <th>公司名称：</td>
                            <td>${requestScope.companymeg.CORP_NAME }</td>
                            <th>电话：</td>
                            <td>${requestScope.companymeg.TEL }</td>
                        </tr>

                        <tr>
                            <th>官网：</td>
                            <td>${requestScope.companymeg.WEB_URL }</td>
                            <th>邮箱：</td>
                            <td>${requestScope.companymeg.EMAIL }</td>
                        </tr>

                        <tr>
                            <th>注册资本：</td>
                            <td>${requestScope.companymeg.REG_CAPI } 万元</td>
                            <th>成立日期：</td>
                            <td>${requestScope.companymeg.START_DATE }</td>
                        </tr>
                        <tr>
                            <th>经营状态：</td>
                            <td>
                                <c:if test="${requestScope.companymeg.CORP_STATUS eq '01'}">在业</c:if>
                                <c:if test="${requestScope.companymeg.CORP_STATUS eq '02'}">注销</c:if>
                                <c:if test="${requestScope.companymeg.CORP_STATUS eq '03'}">吊销</c:if>
                                <c:if test="${requestScope.companymeg.CORP_STATUS eq '04'}">迁出</c:if>
                            </td>
                            <th>统一社会信用代码：</td>
                            <td>${requestScope.companymeg.REG_NO }</td>
                        </tr>
                        <tr>
                            <th>纳税人识别号：</td>
                            <td>${requestScope.companymeg.TAXPAY_NUM }</td>
                            <th>注册号：</td>
                            <td>${requestScope.companymeg.UNI_SCID }</td>
                        </tr>
                        <tr>
                            <th>组织机构代码：</td>
                            <td>${requestScope.companymeg.ORG_INST_CODE }</td>
                            <th>公司类型：</td>
                            <td>${requestScope.companymeg.ECON_KIND }</td>
                        </tr>
                        <tr>
                            <th>人员规模：</td>
                            <td>${requestScope.companymeg.STAFF_SIZE }</td>
                            <th>营业期限：</td>
                            <td>${requestScope.companymeg.FARE_TERM_START }至${requestScope.companymeg.FARE_TERM_END }</td>
                        </tr>
                        <tr>
                            <th>登记机关：</td>
                            <td>${requestScope.companymeg.BELONG_ORG }</td>
                            <th>核准日期：</td>
                            <td>${requestScope.companymeg.CHECK_DATE }</td>
                        </tr>
                        <tr>
                            <th>英文名：</td>
                            <td>${requestScope.companymeg.ENGLISH_NAME }</td>
                            <th>曾用名：</td>
                            <td>${requestScope.companymeg.FORMER_NAME }</td>
                        </tr>
                        <tr>
                            <th>所属地区：</td>
                            <td>${requestScope.companymeg.BELONG_DIST_ORG }</td>
                            <th>所属行业：</td>
                            <td>${requestScope.companymeg.BELONG_TRADE }</td>
                        </tr>
                        <tr>
                            <th>企业地址：</td>
                            <td>${requestScope.companymeg.ADDR}</td>
                            <th>经营范围：</td>
                            <td>${requestScope.companymeg.FARE_SCOPE }</td>
                        </tr>
                    </table>
                </div>
            </div>
        </c:if>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script src="js/tmp.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" href="js/jquery-ui.css">
</body>
</html>