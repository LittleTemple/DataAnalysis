$(document).ready(function(){
	$(".header-search button").css("background", "none");
	
	//页面输入搜索
	$("#searchInput").bind("keypress", function(event){
		if(event.keyCode==13){
			$("#searchForm").submit();
		}
	});
	
	//导航栏输入搜索
	$(".header-search").bind("keypress", function(event){
		if(event.keyCode==13){
			$(".header-search").submit();
		}
	});
	
//=============================================================================
	
	//页面中间搜索框功能模块
	$("#searchInput").focus(function(){
		$("#searchInput").autocomplete({  
	    	minLength: 0,
	        source: function( request, response ) {  
	        $.ajax({
	           type : "POST",
	           dataType : "JSON",
	           url : 'CompanyServlet',
	           data : {
	           		"CorpName" : $("#searchInput").val(),
	           		"method":"searchName"
	           	},
	           success : function(data) {
	           		console.log(data);  
                    response( $.map( data, function( item ) {  
						return {  
							label: item.corp_NAME,  
                            value: item.corp_NAME,
                            org: item.org,
                            id: item.id,
                            seq_ID: item.seq_ID
                        }  
                     }));  
				}  
            });
          	},  
            focus: function( event, ui ) {  
            	$("#searchInput").val( ui.item.label );  
                $("#rpId").val( ui.item.value );  
                $("#ORG").val( ui.item.org );  
                $("#ID").val( ui.item.id );  
                $("#SEQ_ID").val( ui.item.seq_ID );  
                return false;  
            },  
            select: function( event, ui ) {  
                $("#searchInput").val( ui.item.label );  
                $("#rpId").val( ui.item.value );  
                $("#ORG").val( ui.item.org );  
                $("#ID").val( ui.item.id );  
                $("#SEQ_ID").val( ui.item.seq_ID );  
                return false; 
            }    
         }); 
	});
//=================================================================================
	//导航栏部分模糊匹配公司名
	$("#searchInputTop").focus(function(){
		$("#searchInputTop").autocomplete({  
	    	minLength: 0,
	        source: function( request, response ) {  
	        $.ajax({
	           type : "POST",
	           dataType : "JSON",
	           url : 'CompanyServlet',
	           data : {
	           		"CorpName" : $("#searchInputTop").val(),
	           		"method":"searchName"
	           	},
	           success : function(data) {
	           		console.log(data);  
                    response( $.map( data, function( item ) {  
						return {  
							label: item.corp_NAME,  
                            value: item.corp_NAME,
                            org: item.org,
                            id: item.id,
                            seq_ID: item.seq_ID
                        }  
                     }));  
				}  
            });
          	},  
            focus: function( event, ui ) {  
            	$("#searchInputTop").val( ui.item.label );  
                $("#rpId").val( ui.item.value ); 
                $("#ORG_top").val( ui.item.org );  
                $("#ID_top").val( ui.item.id );  
                $("#SEQ_ID_top").val( ui.item.seq_ID ); 
                return false;  
            },  
            select: function( event, ui ) {  
                $("#searchInputTop").val( ui.item.label );  
                $("#rpId").val( ui.item.value ); 
                $("#ORG_top").val( ui.item.org );  
                $("#ID_top").val( ui.item.id );  
                $("#SEQ_ID_top").val( ui.item.seq_ID ); 
                return false; 
            }    
         }); 
	});
//=================================================================================

});
//=================================================================================
//显示股权结构
function showguquanjiegou(){
	$.ajax({
		type : "POST",
		dataType : "JSON",
		url : 'CompanyServlet',
		data : {
			"CORP_NAME" :  $("#CORP_NAME").val(),
			"method" : "guquanjiegou",
		},
		success : function(result) {
			console.log(result)
			var comname=result.corpname;
			var gudongxinxi=result.gudongxinxi;
			var comxinxi=result.comxinxi;
			$("#svg_8").text(comname);//主体公司
			
			$("#svg_12").text(gudongxinxi[0].gudongming);//疑似股东名
			$("#svg_16").text(comname);//疑似公司名
			$("#svg_17").text(gudongxinxi[0].guquanbili);//疑似比例
			
			$("#svg_9").text(gudongxinxi[0].gudongming);//大股东
			$("#svg_25").text(gudongxinxi[0].guquanbili);//大股东比例
			$("#svg_27").text(gudongxinxi[0].renjiaojinge+"万元");//大股东认缴金额
			
			if(gudongxinxi[1]!=null){
				$(".ziranrenxinxi").css("visibility","visible");
				$("#svg_30").text(gudongxinxi[1].gudongming);//自然人
				$("#svg_32").text(gudongxinxi[1].guquanbili);//自然人比例
				$("#svg_34").text(gudongxinxi[1].renjiaojinge+"万元");//自然人认缴金额
			}else{
				$(".ziranrenxinxi").css("visibility","hidden");
			}
			
			if(comxinxi!=null&&comxinxi!=""){
				$(".comxinxi").css("visibility","visible");
				$("#svg_15").text(comxinxi[0].gudongming);//企业股东
				$("#svg_37").text(comxinxi[0].guquanbili);//企业股东比例
				$("#svg_39").text(comxinxi[0].renjiaojinge+"万元");//企业股东认缴金额
			}else{
				$(".comxinxi").css("visibility","hidden");
			}
//			var stocks=result.xinxi;
//			drawguquanjiegou(stocks)
		}
	});
}

/*点击隐藏和显示*/
$("#svg_1").click(function(){
	if($(".gudongcontent").css("opacity")==1){
		$(".gudongcontent").fadeTo("slow",0);
	}else{
		$(".gudongcontent").fadeTo("opacity",1)
	}
});
//=================================================================================
//显示公司投资族谱  
var myChart = echarts.init(document.getElementById('showzupu'));
function showzupu() {
//	var company=$(".companyInput").text();
//	var stock=$(".stockInput").text();
	//数据加载完之前先显示一段简单的loading动画
	myChart.showLoading();
	$.ajax({
		type : "POST",
		dataType : "JSON",
		url : 'CompanyServlet',
		data : {
			"CORP_NAME" :  $("#CORP_NAME").val(),
			"method" : "touzizupu",
			"companyLevel" : j,
			"stockLevel" : i
		},
		success : function(result) {
			console.log(result);
			var r=getJsonTree(result,"");
			myChart.hideLoading(); 
			drawTouziTree(r);
			//遍历json数组
			$.each(result,function(n){
				//在返回的数据中取出判断是否还有更多的关系
				if(result[n].id=="stockLevelWarning"){
					//保持之前的层级不变
					i=i-1;
					$(".stockInput").text(step[i]);
					tanchu(result[n].value);
				}
				if(result[n].id=="companyLevelWarning"){
					j=j-1;
					$(".companyInput").text(step[j]);
					tanchu(result[n].value);
				}
			});
		}
	})

} 
//显示投资族谱树
function drawTouziTree(treeData) {
	var model=myChart.getModel();
	myChart.setOption({
		toolbox: {
		      show: true,
		      right:15,
		      itemSize:20,
		      feature: {
		        dataView: {
		          show: true,
		          readOnly: true,
		          optionToContent: function (opt) {
		            var series = opt.series[0].data;
		            var data = opt.series[0].data[0];
		            var tbody = '';

		            function getNode(node) {
		              tbody += '<tr>'
		                + '<td style="color:black;">' + node.name + '</td>'
		                + '<td style="color:black;">' + node.value + '</td>'
		                + '</tr>';
		            }

		            function recursiveTree(node) {
		              if (!node) {
		                return;
		              }
		              getNode(node);
		              if (node.children && node.children.length > 0) {
		                for (var i = 0; i < node.children.length; i++) {
		                  recursiveTree(node.children[i]);
		                }
		              }
		            }

		            recursiveTree(data);

		            var table = '<table style="width: 100%;text-align: center"><tbody><tr>'
		              + '<td style="color:red;">主体公司：</td>'
		              + '<td style="color:red;">' + series[0].name + '</td>'
		              + '</tr>' +
		              tbody + '</tbody></table>';
		            return table;
		          }

		        },
		        saveAsImage: {show: true},
		        restore:{show: true},
		      }
		    },
		tooltip : {
			trigger : 'item',
			triggerOn : 'mousemove'
		},
		series : [ {
			type : 'tree',
			data : treeData,
			top : '5%',
			layout : 'radial',
			symbol : 'circle',
			symbolSize : 15,
			itemStyle : {//树图中每个节点的样式
				normal : {
					// 径向渐变，前三个参数分别是圆心 x, y 和半径，取值同线性渐变
					color: {
					    type: 'radial',
					    x: 0.5,
					    y: 0.5,
					    r: 0.5,
					    colorStops: [{
					        offset: 0, color: '#f1f2f6' // 0% 处的颜色
					    }, {
					        offset: 1, color: '#00b0ff' // 100% 处的颜色
					    }],
					    globalCoord: false // 缺省为 false
					},
					borderColor : '#00b0ff',
					borderWidth : 2
				},
				emphasis : {
					color: {
					    type: 'radial',
					    x: 0.5,
					    y: 0.5,
					    r: 0.5,
					    colorStops: [{
					        offset: 0, color: '#f1f2f6' // 0% 处的颜色
					    }, {
					        offset: 1, color: '#00b0ff' // 100% 处的颜色
					    }],
					    globalCoord: false // 缺省为 false
					},
					borderColor : '#00b0ff',
					borderWidth : 5
				}
			},
			label: {
				show:true,
				position: 'left',
				formatter: function(params) {
		              var result = "";
		              	if(params.name!=undefined){
		              		result+=params.name+"\n";
		              }
		              	if(params.value!=undefined){
		              		result+=params.value+"\n";
		              }
		              return result;
		           },
			},
			initialTreeDepth : 9,
			animationDurationUpdate : 750
		} ]

	});
}
//=================================================================================
//处理ajax返回的字符串为符合echarts规范的树状串
var getJsonTree=function(data,parentId){
  var itemArr=[];
  for(var i=0;i<data.length;i++){ 
      var node=data[i];
      //data.splice(i, 1)
       if(node.parentId==parentId ){ 
    	  var name=node.id;
    	  var value=node.value;
          var newNode={name:node.id,value:node.value,children:getJsonTree(data,node.id)};
          itemArr.push(newNode);              
       }
  }
  return itemArr;
}
//=================================================================================
//显示企业族谱信息
var corpChart = echarts.init(document.getElementById('corpzupu'));
function corpzupu(){
	corpChart.showLoading();
	$.ajax({
		type : "POST",
		dataType : "JSON",
		url : "CompanyServlet",
		data : {
			"method" : "corpzupu",
			"CORP_ORG" : $("#CORP_ORG").val(),
			"CORP_SEQ_ID" : $("#CORP_SEQ_ID").val(),
			"CORP_NAME" :  $("#CORP_NAME").val(),
			
		},
		success : function(result){
			console.log(result);
			var res=getJsonTree(result,"");
			console.log(res);
			corpChart.hideLoading();
			drawCorpTree(res);
		}
	});
}

//显示企业族谱树
function drawCorpTree(treeData) {
	var model=corpChart.getModel();
	corpChart.setOption({
		tooltip : {
			trigger : 'item',
			triggerOn : 'mousemove'
		},
		toolbox: {
		    show: true,
		    right:15,
		    itemSize:20,
		    feature:{
		    	dataview:{show: true},
		    	restore:{show: true},
		    	saveAsImage: {show: true},
		    	datazoom:{show: true}
		    }
		        
		},
		series : [ {
			type : 'tree',
			data : treeData,
			top : '5%',
			layout : 'radial',
			symbolSize : 15,
			itemStyle : {//树图中每个节点的样式
				normal : {
					color: {
					    type: 'radial',
					    x: 0.5,
					    y: 0.5,
					    r: 0.5,
					    colorStops: [{
					        offset: 0, color: '#f1f2f6' // 0% 处的颜色
					    }, {
					        offset: 1, color: '#00b0ff' // 100% 处的颜色
					    }],
					    globalCoord: false // 缺省为 false
					},
					borderColor : '#00b0ff',
					borderWidth : 2
				},
				emphasis : {
					color: {
					    type: 'radial',
					    x: 0.5,
					    y: 0.5,
					    r: 0.5,
					    colorStops: [{
					        offset: 0, color: '#f1f2f6' // 0% 处的颜色
					    }, {
					        offset: 1, color: '#00b0ff' // 100% 处的颜色
					    }],
					    globalCoord: false // 缺省为 false
					},
					borderColor : '#00b0ff',
					borderWidth : 5
				}
			},
			label: {
				show:true,
				formatter: function(params) {
		              var result = "";
		              	if(params.name!=undefined){
		              		result+=params.name+"\n";
		              }
		              	if(params.value!=undefined){
		              		result+=params.value+"\n";
		              }
		              return result;
		           },
			},
			leaves: {
                label: {
                    normal: {
                        position: 'top',
                    }
                }
            },
			
			initialTreeDepth : 2,
			animationDurationUpdate : 750,
			animationDuration:550
		} ]

	});
}
//=================================================================================
//疑似关系
var yisiguanxiChart = echarts.init(document.getElementById('yisiguanxi'));
function yisiguanxi(){
	yisiguanxiChart.showLoading();
	$.ajax({
		type : "POST",
		dataType : "JSON",
		url : "CompanyServlet",
		data : {
			"method" : "yisiguanxi",
			"CORP_NAME" :  $("#CORP_NAME").val(),
			
		},
		success : function(result){
			console.log(result);
			yisiguanxiChart.hideLoading();
			treeDatadata=result[1]
			treeDatalinks=result[0]
			drawGraphTree(treeDatadata,treeDatalinks);
		}
	});
}
//画疑似关系图
function drawGraphTree(treeDatadata,treeDatalinks) {
	yisiguanxiChart.setOption({
		    title: {
		        text: '疑似关系'
		    },
		    tooltip: {},
		    animationDurationUpdate: 1500,
		    animationEasingUpdate: 'quinticInOut',
		    label: {
		        normal: {
		            show: true,
		            textStyle: {
		                fontSize: 12
		            },
		        }
		    },
		    legend: {
		        x: "center",
		        show: true,
		        data: ["股东", "公司", "高管"]
		    },
		    toolbox: {
		        show : true,
		        right:15,
			    itemSize:20,
		        feature : {
		            dataView : {
		            	show: true,
		            	readOnly: true,
		            	optionToContent: function (opt) {
		            var linkdata = opt.series[0].links;
		            var table = '<table style="width:100%;text-align:center"><tbody><tr>'
		                 + '<td style="color:red;">人物</td>'
		                 + '<td style="color:red;">' + "公司" + '</td>'
		                 + '<td style="color:red;">' + "关系" + '</td>'
		                 + '</tr>'
		                 +'<tr></tr><tr></tr>';
		            	for (var i = 0; i < linkdata.length; i++) {
		            		table += '<tr>'
		            				+ '<td style="color:black;">' + linkdata[i].source + '</td>'
		            				+ '<td style="color:black;">' + linkdata[i].target + '</td>'
		            				+ '<td style="color:black;">' + linkdata[i].value + '</td>'
		            				+ '</tr>';
		    }
		    table += '</tbody></table>';
		    return table;
		    }

		        },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    series: [

		        {
		            type: 'graph',
		            layout: 'force',
		            symbolSize: 45,
		            focusNodeAdjacency: true,
		            roam: true,
		            categories: [{
		                name: '股东',
		                itemStyle: {
		                    normal: {
		                        color: "#009800",
		                    }
		                }
		            }, {
		                name: '公司',
		                itemStyle: {
		                    normal: {
		                        color: "#4592FF",
		                    }
		                }
		            }, {
		                name: '高管',
		                itemStyle: {
		                    normal: {
		                        color: "#e90502",
		                    }
		                }
		            }],
		            label: {
		                normal: {
		                    show: true,
		                    textStyle: {
		                        fontSize: 12
		                    },
		                }
		            },
		            force: {
		                repulsion: 1000
		            },
		            edgeSymbol: ['circle', 'arrow'],
		            edgeSymbolSize: [0, 8],
		            edgeLabel: {
		                normal: {
		                    show: true,
		                    textStyle: {
		                        fontSize: 10
		                    },
		                    formatter: "{c}",
		                    color:'#000',
		                    fontWeight:'bold'
		                }
		            },
		            data: treeDatadata,
		            links: treeDatalinks,
		            lineStyle: {
		                normal: {
		                    opacity: 0.9,
		                    width: 1,
		                    curveness: 0
		                }
		            }
		        }
		    ]
		});
}
//=================================================================================
//投资族谱中的层级切换
var step= ['一层','二层','三层','四层','五层','六层','七层','八层','九层','十层'];
var stockInput = $(".stockInput");
var conpanyInput = $(".companyInput");
var i = 0;
var j = 0;
function shang(){
  i++;
  stockInput.text(step[i]);
  if(i>=9) i=9;
  
  showzupu();
}
function xia(){
  i--;
  stockInput.text(step[i]);
  if(i<=0) i=0;
  
  showzupu();
}
function shang1(){
  j++;
  conpanyInput.text(step[j]);
  if(j>=9) j=9;
  
  showzupu();
}
function xia1(){
  j--;
  conpanyInput.text(step[j]);
  if(j<=0) j=0;
  
  showzupu();
}

//=================================================================================
//用户登录/注册
var xhr;//ajax变量
//处理Ajax返回结果的函数
function proccessResult(){
	//发送的结果为响应
	if(xhr.readyState==4){
		if(xhr.status=200){
			var result=xhr.responseText;
			if(result=="true") {
				 $("#userexist").html("<b style='color:red;font-size:10px;'>用户已存在</b>");
			}else{
				 $("#userexist").html("<b style='color:green;font-size:10px;'>OK</b>");
			}
		}	
	}
}
//账户输入不能为空
$("#account").blur(function(){   
	if($(this).val() == ""||$.trim($(this).val()).length == 0){
		 $("#userexist").html("<b style='color:red;font-size:10px;'>账号 不能为空！</b>");
	}else{
	//Ajax验证账户是否已存在
	
	var account=$(this).val();
	if(window.ActiveXObject) {
		xhr=new XMLHttpRequest("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		tanchu("can't create xhr object");
	}
	//准备回调函数
	xhr.onreadystatechange=proccessResult;
	//发起请求
	xhr.open("get","UserServlet?method=checkUserExists&account="+account);
	xhr.send(null);
	}
});

$("#password").blur(function(){   
	if($(this).val() == ""||$.trim($(this).val()).length == 0){
		$("#passwordresult").html("<b style='color:red;font-size:10px;'>密码 不能为空！</b>");
	}else{
		 $("#passwordresult").html("<b style='color:green;font-size:10px;'>OK</b>");
	}
});

$("#password1").blur(function(){   
	if($(this).val() == ""||$.trim($(this).val()).length == 0){
		$("#passwordresult1").html("<b style='color:red;font-size:10px;'>密码 不能为空！</b>");
	}else if($(this).val() != $("#password").val() ){
		$("#passwordresult1").html("<b style='color:red;font-size:10px;'>密码不一致！！</b>");
	}else{
		 $("#passwordresult1").html("<b style='color:green;font-size:10px;'>OK</b>");
	}
});
//=================================================================================
//修改错误提示框消息
function tanchu(tip){
	$('#myModal1').modal();
	$(".modal-body").text(tip);
}
//=================================================================================
//页面选项卡切换
function changestatus(a,b,c,d,e,f){
	$(".container").css('display', a)
	$(".page1").css('display', b);
	$(".page2").css('display', c);
	$(".page3").css('display', d);
	$(".page4").css('display', e);
	$(".page5").css('display', f);
}
function changePage(obj){
	$(".tip").click(function(){
		if($("#CORP_NAME").val()==null||$("#CORP_NAME").val()==""){
			tanchu("请进行搜索...");
			windows.location.href="index.jsp";
		}else{
			if(obj.innerHTML=="基本信息"){
				changestatus("none","block","none","none","none","none");
			}if(obj.innerHTML=="股权结构"){
				showguquanjiegou();
				changestatus("none","none","block","none","none","none");
			}if(obj.innerHTML=="投资族谱"){
				showzupu();
				changestatus("none","none","none","block","none","none");
			}if(obj.innerHTML=="企业族谱"){
				corpzupu();
				changestatus("none","none","none","none","block","none");
			}if(obj.innerHTML=="疑似关系"){
				changestatus("none","none","none","none","none","block");
				yisiguanxi();
			}
		}
	});
	if(obj.innerHTML=="Home"){
		changestatus("block","none","none","none","none","none");
	}
}

//=================================================================================
//百度地图API功能
var map = new BMap.Map("allmap");
var point = new BMap.Point(112.048098,32.006678);
map.centerAndZoom(point,12);
map.enableScrollWheelZoom(true);

//城市列表控件
var size = new BMap.Size(10, 20);
map.addControl(new BMap.CityListControl({
 anchor: BMAP_ANCHOR_TOP_RIGHT,
 offset: size,
 // 切换城市之间事件
 // onChangeBefore: function(){
 //    alert('before');
 // },
 // 切换城市之后事件
 // onChangeAfter:function(){
 //   alert('after');
 // }
}));

//添加带有定位的导航控件
var navigationControl = new BMap.NavigationControl({
// 靠左上角位置
anchor: BMAP_ANCHOR_TOP_LEFT,
// LARGE类型
type: BMAP_NAVIGATION_CONTROL_LARGE,
// 启用显示定位
enableGeolocation: true
});
map.addControl(navigationControl);

//添加定位控件
var geolocationControl = new BMap.GeolocationControl();
geolocationControl.addEventListener("locationSuccess", function(e){
// 定位成功事件
var address = '';
address += e.addressComponent.province;
address += e.addressComponent.city;
address += e.addressComponent.district;
address += e.addressComponent.street;
address += e.addressComponent.streetNumber;
tanchu("当前定位地址为：" + address);
});
geolocationControl.addEventListener("locationError",function(e){
// 定位失败事件
tanchu(e.message);
});
map.addControl(geolocationControl);

//创建地址解析器实例
var myGeo = new BMap.Geocoder();
//将地址解析结果显示在地图上,并调整地图视野

var value=$("#CORP_NAME").val();
var address=value.substring(0,4);
myGeo.getPoint(address, function(point){
	if (point) {
		map.centerAndZoom(point, 12);
		map.addOverlay(new BMap.Marker(point));
	}else{
		tanchu("您选择地址没有解析到结果!");
	}
}, address);


function showLocation(){
 $('#myModal').modal();
 
	var value=$("#CORP_NAME").val();
	$("#address").text('地址：'+value);

}
function showNearLocation(){
	$('#myModal').modal();
	var value=$("#CORP_NAME").val();
	$("#address").text('地址：'+value);
}

