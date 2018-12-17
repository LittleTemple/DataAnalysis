//=================================================================================
//搜索栏查询
jQuery(function ($) {
    $(function () {
        $("#searchInput").focus(function () {
            $("#searchInput").autocomplete({
                minLength: 0,
                source: function (request, response) {
                    $.ajax({
                        type: "POST",
                        dataType: "JSON",
                        url: 'CompanyServlet',
                        data: {
                            "CorpName": $("#searchInput").val(),
                            "method": "searchName"
                        },
                        success: function (data) {
                            console.log(data);
                            response($.map(data, function (item) {
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
                focus: function (event, ui) {
                    $("#searchInput").val(ui.item.label);
                    $("#rpId").val(ui.item.value);
                    $("#ORG").val(ui.item.org);
                    $("#ID").val(ui.item.id);
                    $("#SEQ_ID").val(ui.item.seq_ID);
                    return false;
                },
                select: function (event, ui) {
                    $("#searchInput").val(ui.item.label);
                    $("#rpId").val(ui.item.value);
                    $("#ORG").val(ui.item.org);
                    $("#ID").val(ui.item.id);
                    $("#SEQ_ID").val(ui.item.seq_ID);
                    return false;
                }
            });

        });

    })

});


//=================================================================================
//显示股权结构

// document.write("<script type='text/javascript' src='echarts.js'></script>");
function showguquanjiegou(socket){
    var SOption = {
        title: {
            text: '股权结构图',
            left: 'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            top: 'middle',
            bottom: 10,
            left: 'center',
            data: ['企业股东','自然人']
        },
        series : [
            {
                type: 'pie',
                radius : '65%',
                center: ['50%', '50%'],
                data:[]
            }
        ]
    };
    socket.setOption(SOption);


    $.ajax({
        type : "POST",
        dataType : "JSON",
        url : 'CompanyServlet',
        data : {
            "CORP_NAME" :  $("#CORP_NAME").val(),
            "method" : "guquanjiegou",
        },
        success : function(result) {
            console.log(result);
            var comname=result.corpname;
            var gudongxinxi=result.gudongxinxi;
            var comxinxi=result.comxinxi;
            var data = [];
            for(var i = 0;i<gudongxinxi.length;i++){
                data.push({
                    name:gudongxinxi[i].gudongming,
                    value:gudongxinxi[i].renjiaojinge
                })
            }

            for(var i = 0;i<comxinxi.length;i++){
                data.push({
                    name:comxinxi[i].gudongming,
                    value:comxinxi[i].renjiaojinge
                })
            }

            socket.setOption({
                title: {
                    text: comname+'股权结构图',
                    left: 'center'
                },

                series : [
                    {
                        data:data
                    }
                ]
            });


        }
    });
}



//=================================================================================
//显示公司投资族谱
function showzupu(myChart) {
//	var company=$(".companyInput").text();
//	var stock=$(".stockInput").text();

    //数据加载完之前先显示一段简单的loading动画
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
            drawTouziTree(result);
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

var option = {
    tooltip: {
        showContent: true, //是否显示提示框浮层
        trigger: 'item',//触发类型，默认数据项触发
    },

    legend: { //=========圖表控件
        show: true,
        data: [
            {
                name: '公司',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '股东',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '对外投资',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '股东分支',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '对外投资分支',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            }
        ]
    },
    series: [{
        type: 'graph', //关系图
        name: "投资族谱", //系列名称，用于tooltip的显示，legend 的图例筛选，在 setOption 更新数据和配置项时用于指定对应的系列。
        layout: 'force', //图的布局，类型为力导图，'circular' 采用环形布局，见示例 Les Miserables
        force: { //力引导图基本配置
            //initLayout: ,//力引导的初始化布局，默认使用xy轴的标点
            repulsion: 100,//节点之间的斥力因子。支持数组表达斥力范围，值越大斥力越大。
            gravity: 0.03,//节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。
            edgeLength: 80,//边的两个节点之间的距离，这个距离也会受 repulsion。[10, 50] 。值越小则长度越长
            layoutAnimation: true
            //因为力引导布局会在多次迭代后才会稳定，这个参数决定是否显示布局的迭代动画，在浏览器端节点数据较多（>100）的时候不建议关闭，布局过程会造成浏览器假死。
        },
        draggable: true,//节点是否可拖拽，只在使用力引导布局的时候有用。
        itemStyle: {//===============图形样式，有 normal 和 emphasis 两个状态。normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
            normal: { //默认样式
                label: {
                    show: true
                },
                borderType: 'solid', //图形描边类型，默认为实线，支持 'solid'（实线）, 'dashed'(虚线), 'dotted'（点线）。
                borderColor: 'rgba(255,215,0,0.4)', //设置图形边框为淡金色,透明度为0.4
                borderWidth: 2, //图形的描边线宽。为 0 时无描边。
                opacity: 1
                // 图形透明度。支持从 0 到 1 的数字，为 0 时不绘制该图形。默认0.5

            },
            emphasis: {//高亮状态

            }
        },
        label: { //=============图形上的文本标签
            normal: {
                show: true,//是否显示标签。
                position: 'inside',//标签的位置。['50%', '50%'] [x,y]
                textStyle: { //标签的字体样式
                    color: '#cde6c7', //字体颜色
                    fontStyle: 'normal',//文字字体的风格 'normal'标准 'italic'斜体 'oblique' 倾斜
                    fontWeight: 'bolder',//'normal'标准'bold'粗的'bolder'更粗的'lighter'更细的或100 | 200 | 300 | 400...
                    fontFamily: 'sans-serif', //文字的字体系列
                    fontSize: 12 //字体大小
                }
            },
            emphasis: {//高亮状态

            }
        },
        //别名为nodes   name:影响图形标签显示,value:影响选中后值得显示,category:所在类目的index,symbol:类目节点标记图形,symbolSize:10图形大小
        //label:标签样式。
        data: [],
        categories: [
            {
                name: '公司',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '股东',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '对外投资',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '股东分支',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            },
            {
                name: '对外投资分支',
                icon: 'circle'//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'

            }
        ]

    }]
};


function drawTouziTree(result) {
    // 指定图表的配置项和数据

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    var node = [];
    var link = [];
    for(var i = 0;i<result.length;i++){
        var category = 0;
        if(result[i].id == "股东"){
            category = 1;
        }else if(result[i].id == "对外投资"){
            category = 2;
        }else if(result[i].parentId == "股东"){
            category = 3;
        }else if(result[i].parentId == "对外投资"){
            category = 4;
        }




        node.push({
            name:result[i].id,
            value:result[i].value,
            category:category,
            symbolSize:50,
            symbol:'circle'
        });
        if(result[i].parentId!=""){
            link.push({
                source:result[i].id,
                target:result[i].parentId
            })
        }
    }
        myChart.setOption({
            series:[{
                data:node,
                links:link
            }]
        })

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

var option2 = {
    tooltip: {
        showContent: true, //是否显示提示框浮层
        trigger: 'item',//触发类型，默认数据项触发
    },

    legend: { //=========圖表控件
        show: true,
        data: [
            {
                name:'公司',
                icon:'circle'
            },
            {
                name:'关系',
                icon:'circle'
            },
            {
                name:'叶子',
                icon:'circle'
            }

        ]
    },
    series: [{
        type: 'graph', //关系图
        name: "投资族谱", //系列名称，用于tooltip的显示，legend 的图例筛选，在 setOption 更新数据和配置项时用于指定对应的系列。
        layout: 'force', //图的布局，类型为力导图，'circular' 采用环形布局，见示例 Les Miserables
        force: { //力引导图基本配置
            //initLayout: ,//力引导的初始化布局，默认使用xy轴的标点
            repulsion: 100,//节点之间的斥力因子。支持数组表达斥力范围，值越大斥力越大。
            gravity: 0.03,//节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。
            edgeLength: 80,//边的两个节点之间的距离，这个距离也会受 repulsion。[10, 50] 。值越小则长度越长
            layoutAnimation: true
            //因为力引导布局会在多次迭代后才会稳定，这个参数决定是否显示布局的迭代动画，在浏览器端节点数据较多（>100）的时候不建议关闭，布局过程会造成浏览器假死。
        },
        draggable: true,//节点是否可拖拽，只在使用力引导布局的时候有用。
        itemStyle: {//===============图形样式，有 normal 和 emphasis 两个状态。normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
            normal: { //默认样式
                label: {
                    show: true
                },
                borderType: 'solid', //图形描边类型，默认为实线，支持 'solid'（实线）, 'dashed'(虚线), 'dotted'（点线）。
                borderColor: 'rgba(255,215,0,0.4)', //设置图形边框为淡金色,透明度为0.4
                borderWidth: 2, //图形的描边线宽。为 0 时无描边。
                opacity: 1
                // 图形透明度。支持从 0 到 1 的数字，为 0 时不绘制该图形。默认0.5

            },
            emphasis: {//高亮状态

            }
        },
        label: { //=============图形上的文本标签
            normal: {
                show: true,//是否显示标签。
                position: 'inside',//标签的位置。['50%', '50%'] [x,y]
                textStyle: { //标签的字体样式
                    color: '#cde6c7', //字体颜色
                    fontStyle: 'normal',//文字字体的风格 'normal'标准 'italic'斜体 'oblique' 倾斜
                    fontWeight: 'bolder',//'normal'标准'bold'粗的'bolder'更粗的'lighter'更细的或100 | 200 | 300 | 400...
                    fontFamily: 'sans-serif', //文字的字体系列
                    fontSize: 12 //字体大小
                }
            },
            emphasis: {//高亮状态

            }
        },
        //别名为nodes   name:影响图形标签显示,value:影响选中后值得显示,category:所在类目的index,symbol:类目节点标记图形,symbolSize:10图形大小
        //label:标签样式。
        data: [],
        categories: [
            {
                name:'公司',
                icon:'circle'
            },
            {
                name:'关系',
                icon:'circle'
            },
            {
                name:'叶子',
                icon:'circle'
            }
        ]

    }]
};

//=================================================================================
//显示企业族谱信息
function corpzupu(corp){
    corp.showLoading();
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
            corp.hideLoading();
            drawCorp(result,corp);
        }
    });
}

function drawCorp(result,corp) {
    // 指定图表的配置项和数据

    // 使用刚指定的配置项和数据显示图表。
    corp.setOption(option2);

    var node = [];
    var link = [];
    var name = $("#CORP_NAME").val();

    for(var i = 0;i<result.length;i++){
        var category = 0;
        if(result[i].parentId == name){
            category = 1;
        }else if(result[i].parentId == ""){
            category = 0;
        }else{
            category = 2;
        }

        if(result[i].id != null){
            node.push({
                name:result[i].id,
                symbolSize:50,
                symbol:'circle',
                category:category
            });
        }

        if(result[i].parentId!=""){
            link.push({
                source:result[i].id,
                target:result[i].parentId
            })
        }else if(result[i].parentId==null){
            link.push({
                source:result[i].id,
                target:name
            })
        }
    }

    corp.setOption({
        series:[{
            data:node,
            links:link
        }]
    })

}

//=================================================================================
//疑似关系

var option3 = {
    tooltip: {
        showContent: true, //是否显示提示框浮层
        trigger: 'item',//触发类型，默认数据项触发
    },

    legend: { //=========圖表控件
        show: true,
        data: [
            {
                name:'股东',
                icon:'circle'
            },
            {
                name:'公司',
                icon:'circle'
            },
            {
                name:'高管',
                icon:'circle'
            }

        ]
    },
    series: [{
        type: 'graph', //关系图
        name: "投资族谱", //系列名称，用于tooltip的显示，legend 的图例筛选，在 setOption 更新数据和配置项时用于指定对应的系列。
        layout: 'force', //图的布局，类型为力导图，'circular' 采用环形布局，见示例 Les Miserables
        force: { //力引导图基本配置
            //initLayout: ,//力引导的初始化布局，默认使用xy轴的标点
            repulsion: 100,//节点之间的斥力因子。支持数组表达斥力范围，值越大斥力越大。
            gravity: 0.03,//节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。
            edgeLength: 80,//边的两个节点之间的距离，这个距离也会受 repulsion。[10, 50] 。值越小则长度越长
            layoutAnimation: true
            //因为力引导布局会在多次迭代后才会稳定，这个参数决定是否显示布局的迭代动画，在浏览器端节点数据较多（>100）的时候不建议关闭，布局过程会造成浏览器假死。
        },
        draggable: true,//节点是否可拖拽，只在使用力引导布局的时候有用。
        itemStyle: {//===============图形样式，有 normal 和 emphasis 两个状态。normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
            normal: { //默认样式
                label: {
                    show: true
                },
                borderType: 'solid', //图形描边类型，默认为实线，支持 'solid'（实线）, 'dashed'(虚线), 'dotted'（点线）。
                borderColor: 'rgba(255,215,0,0.4)', //设置图形边框为淡金色,透明度为0.4
                borderWidth: 2, //图形的描边线宽。为 0 时无描边。
                opacity: 1
                // 图形透明度。支持从 0 到 1 的数字，为 0 时不绘制该图形。默认0.5

            },
            emphasis: {//高亮状态

            }
        },
        label: { //=============图形上的文本标签
            normal: {
                show: true,//是否显示标签。
                position: 'inside',//标签的位置。['50%', '50%'] [x,y]
                textStyle: { //标签的字体样式
                    color: '#cde6c7', //字体颜色
                    fontStyle: 'normal',//文字字体的风格 'normal'标准 'italic'斜体 'oblique' 倾斜
                    fontWeight: 'bolder',//'normal'标准'bold'粗的'bolder'更粗的'lighter'更细的或100 | 200 | 300 | 400...
                    fontFamily: 'sans-serif', //文字的字体系列
                    fontSize: 12 //字体大小
                }
            },
            emphasis: {//高亮状态

            }
        },
        //别名为nodes   name:影响图形标签显示,value:影响选中后值得显示,category:所在类目的index,symbol:类目节点标记图形,symbolSize:10图形大小
        //label:标签样式。
        data: [],
        categories: [
            {
                name:'股东',
                icon:'circle'
            },
            {
                name:'公司',
                icon:'circle'
            },
            {
                name:'高管',
                icon:'circle'
            }
        ]

    }]
};
function yisiguanxi(chart){
    chart.showLoading();
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
            chart.hideLoading();
            chart.setOption(option3);
            option3 = {
                series:[{
                    symbolSize:60,
                    data:result[1],
                    links:result[0]
                }]
            };

            chart.setOption(option3);

        }
    });
}

