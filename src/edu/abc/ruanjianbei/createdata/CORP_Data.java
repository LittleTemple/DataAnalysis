package edu.abc.ruanjianbei.createdata;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;
import edu.abc.ruanjianbei.model.bean.T_CORP_STOCKBean;
import edu.abc.ruanjianbei.model.dao.CreateDataDao;
import edu.abc.ruanjianbei.model.dao.CreateDataDaoImp;

public class CORP_Data {

    private int ORG;//一个公司唯一
    private int ID;//随机产业
    private int SEQ_ID;//每个总公司递增
    private String REG_NO;//每个公司唯一
    private	String CORP_NAME;
    private	String ADDR;
    private	String BELONG_ORG;
    private	String BELONG_DIST_ORG;
    private	String BELONG_TRADE;
    private	String ECON_KIND;
    private	String ADMIT_MAIN;
    private	String START_DATE;
    private	String CHECK_DATE;
    private	String OPER_MAN_IDENT_NO;
    private	String OPER_MAN_NAME;
    private	String CORP_STATUS;
    private	float REG_CAPI;
    private	String FARE_TERM_START;
    private	String FARE_TERM_END;
    private	String FARE_SCOPE;
    private	String UNI_SCID;
    private	String TEL;
    private	String WEB_URL;
    private	String EMAIL;
    private	int PRAC_PERSON_NUM;
    private	String ORG_INST_CODE;
    private	String TAXPAY_NUM;
    private	String STAFF_SIZE;
    private	String ENGLISH_NAME;
    private	String FORMER_NAME;
    private	String CREATE_DATE;
    private	int CREATE_ORG;


    private CreateDataDao dao;


    public static void main(String[] args) throws Exception {
        new CORP_Data();
    }

    public CORP_Data() throws Exception {

        String[] zimu= {"A","B,","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String xiaozimu= "abcdefghijklmnopqrstuvwxyz";

        String[] sheng= {"北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","广西","海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆","台湾","香港","澳门",};
        String[] city876 = {"东城区","西城区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","怀柔区","平谷区","密云区","延庆区"};
        String[] city877 = {"和平区","河东区","河西区","南开区","河北区","红桥区","东丽区","西青区","津南区","北辰区","武清区","宝坻区","滨海新区","宁河区","静海区","蓟州区"};
        String[] city878 = {"石家庄","唐山","秦皇岛","邯郸","邢台","保定","张家口","承德","沧州","廊坊","衡水"};
        String[] city879 = {"太原","大同","阳泉","长治","晋城","朔州","晋中","运城","忻州","临汾","吕梁"};
        String[] city880 = {"呼和浩特","包头","乌海","赤峰","通辽","鄂尔多斯","呼伦贝尔","巴彦卓尔","乌兰察布","兴安盟","锡林郭勒盟","阿拉善盟"};
        String[] city881 = {"沈阳","鞍山","抚顺","本溪","丹东","锦州","营口","阜新","辽阳","盘锦","铁岭","朝阳","葫芦岛"};
        String[] city882 = {"长春","吉林","四平","辽源","通化","白山","松原","白城","延边"};
        String[] city883 = {"哈尔滨","齐齐哈尔","鸡西","鹤岗","双鸭山","大庆","伊春","佳木斯","七台河","牡丹江","黑河","绥化","大兴安岭"};
        String[] city884 = {"黄浦区","徐汇区","长宁区","静安区","普陀区","虹口区","杨浦区","闵行区","宝山区","嘉定区","浦东新区","金山区","松江区","青浦区","奉贤区","崇明区"};
        String[] city885 = {"南京","无锡","徐州","常州","苏州","南通","连云港","淮安","盐城","扬州","镇江","秦州","宿迁"};
        String[] city886 = {"杭州","宁波","温州","湖州","绍兴","金华","衢州","舟山","台州","丽水"};
        String[] city887 = {"合肥","芜湖","蚌埠市","淮南","马鞍","淮北","铜陵","安庆","黄山","滁州","阜阳","宿州","六安","毫州","池州","宣称"};
        String[] city888 = {"福州","厦门","莆田","三明","泉州","漳州","南平","龙岩","宁德"};
        String[] city889 = {"南昌","景德镇","萍乡","九江","新余","鹰潭","赣州","吉安","宜春","抚州","上饶"};
        String[] city890 = {"济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照","莱芜","临沂","德州","聊城","滨州","菏泽"};
        String[] city891 = {"郑州","开封","洛阳","平顶山","安阳","鹤壁","新乡","焦作","濮阳","许昌","漯河","三门峡","南阳","商丘","信阳","周口","驻马店","济源"};
        String[] city892 = {"武汉","黄石","十堰","襄阳","宜昌","鄂州","荆门","孝感","荆州","黄冈","咸宁","随州","恩施","仙桃","潜江","天门","神农架"};
        String[] city893 = {"长沙","株洲","湘潭","衡阳","邵阳","岳阳","常德","张家界","益阳","郴州","永州","怀化","娄底","湘西州"};
        String[] city894 = {"广州","韶关","深圳","珠海","汕头","佛山","江门","湛江","茂名","肇庆","惠州","梅州","汕尾","河源","阳江","东莞","中山","潮州","揭阳","云浮"};
        String[] city895 = {"南宁","柳州","桂林","梧州","北海","防城港","钦州","贵港","玉林","百色","贺州","河池","来宾","崇左"};
        String[] city896 = {"海口","三亚","五指山","琼海","儋州","文昌","万宁","东方","定安","屯昌","澄迈","临高","白沙","昌江","乐东","陵水","保亭","琼中","三沙"};
        String[] city897 = {"万州区","涪陵区","渝中区","大渡口区","江北区","沙坪坝区","九龙坡区","南岸区","北碚区","綦江区","大足区","渝北区","巴南区","黔江区","长寿区","江津区","合川区","永川区","南川区","铜梁区","璧山区","潼南区","荣昌区","开州区","梁平区","武隆区","城口县","丰都县","垫江县","忠县","云阳县","奉节县","巫山县","巫溪县","石柱县","秀山县","酉阳县","彭水县"};
        String[] city898 = {"成都","攀枝花","广元","遂宁","宜宾", "广安","绵阳", "德阳", "自贡", "内江", "乐山", "南充", "雅安", "眉山", "甘孜", "凉山", "泸州","达州","巴中","资阳","阿坝","甘孜","凉山州"};
        String[] city899 = {"贵阳","六盘水","遵义","安顺","毕节","铜仁","黔西南州","黔东南州","黔南州"};
        String[] city900 = {"昆明","曲靖","玉溪","保山","昭通","丽江","普洱","临沧","楚雄州","红河州","文山州","西双版纳州","大理州","德宏州","怒江州","迪庆州"};
        String[] city901 = {"拉萨","昌都","林芝","山南","那曲","阿里","日喀则市"};
        String[] city902 = {"西安","铜川","宝鸡","咸阳","渭南","延安","汉中","榆林","安康","商洛"};
        String[] city903 = {"兰州","嘉峪关","金昌","白银","天水","武威","张掖","平凉","酒泉","庆阳","定西","陇南","临夏州","甘南州"};
        String[] city904 = {"西宁","海东","海北州","黄南州","海南州","果洛州","玉树州","海西州"};
        String[] city905 = {"银川","石嘴山","吴忠","固原","中卫"};
        String[] city906 = {"乌鲁木齐","克拉玛依","吐鲁番","哈密","昌吉","博尔塔拉州","巴音郭楞州","阿克苏地区","克孜勒苏州","喀什地区","和田地区","伊犁州","塔城地区","阿勒泰地区","石河子","阿拉尔","图木舒克","五家渠","北屯","铁门关","双河","可克达拉","昆玉"};
        String[] city907 = {"澎湖县","彰化县","宜兰县","台东县","桃园县","屏东县","花莲县","基隆","苗栗县","云林县","新北","台北","南投","台南县","嘉义县","台中市","高雄市"};
        String[] city908 = {"荃湾区","湾仔区","东区","南区","油尖旺区","深水埗区","九龙城区","中西区","观塘区","离岛区","屯门区","元朗区","北区","大埔区","西贡区","沙田区","葵青区","黄大仙区"};
        String[] city909 = {"花地玛堂区","圣安多尼堂区","大堂区","望德堂区","风顺堂区","嘉模堂区","圣方济各堂区"};

        String[] shi= {"成都市","杭州市","武汉市","重庆市","南京市","天津市",
                "苏州市","西安市","长沙市","沈阳市","青岛市","郑州市","大连市","东莞市","宁波市"};
        String[] qv= {"渝中区","江北区","沙坪坝区","九龙坡区","南岸区","大渡口区","渝北区","巴南区",
                "北碚区","涪陵区","万州区","长寿区","黔江区","大足区","綦江区","南川区","永川区","江津区","合川区"};
        String[] jiedao= {"长安街","南京路","淮海路","王府井大街","中央大街","转经路","平江路","南大街","屯溪老街","老街",
                "北大街","滨海路","衡山路"};

        String[] hangye2= {"居民服务","其他服务","修理和服务","专业技术服务","技术检测","租赁"};
        String[] hangye1= {"保险","采矿","能源","餐饮","电讯","房地产","广告","建筑","服饰","航天航空","教育","计算机","美容","娱乐","出版","零售","造纸","旅游","设计","银行","快递","运输","机械制造","农业","咨询","医疗","住宿","电力","热力","纺织"};

        String corpName1[]={"进","合","干","尚","西","庆","邦","迈","元","晶","优","升","元","鼎","协","升","巨","满","云","集","铭","弘","华","宝","吉","奥","亚","富","寿","如","贵","巨","和","义","贵","华"};
        String corpName2[]={"华","祥","亨","协","耀","盛","信","宏","成","东","生","正","茂","汇","洪","鸿","义","伟","禄","千","玉","金","康","谦","卿","庆","美","昌","寿","安","昊","浩","豪","干","本","久"};

        String[] jingyingfanwei1= {"计算机软件开发、","销售及相关产品培训，","计算机应用服务，","线路、","管道、","设备安装，","电子产品及通信设备技术服务，","电子仪器的生产与销售，","电子计算机及配件、"};
        String[] jingyingfanwei2= {"五金、","交电、","百货、","化工原料及产品、","汽车、","建筑材料销售，","商品信息咨询，"};
        String[] jingyingfanwei3= {"互联网科技,","医疗器械，","本地生活，","广告文化，","游戏，","金融服务，","商贸，","建筑"};

        String[] gongsidalei= {"内资公司","外资公司","合资公司"};
        String guanlijv="工商管理局";

        String country[]= {"中国","美国","中国","法国","中国","中国","英国","中国","日本","中国","俄罗斯","中国","加拿大","中国"};//国家
        String firstname[]= {"赵","钱","孙","李","周","吴","郑","王","蒋","沈","韩","杨","曹","马","陈","苏","姜","宋"};
        String lastname1[]= {"浩","豪","好","昊","点","雷","虹","腾","彬","诺","曼","耀","瑞","虎","宝","倩","帆","朗","鹿","洲","轩","俊","雅","霞"};
        String lastname2[]= {"平","","展","睿","威","舟","","","","桐","彤","念","农","","星","倩","华","彰","","","","龙","雅","景"};

        String[] certificate_type= {"身份证"};
        String[] person_type= {"董事","监事","董事","经理","董事","监事","董事","监事","监事",};

        dao=new CreateDataDaoImp();
        //存储生成的公司个数
        int CorpNum=0;

        Random random=new Random();
        int num=0;
        //存储行业分类信息
        Map<Integer, String> map=new HashMap<Integer, String>();
        for(int i=0;i<hangye1.length;i++) {
            for(int j=0;j<hangye2.length;j++)
                map.put(num+1000, hangye1[i]+"和"+hangye2[j]+"业");
            num++;
        }
        int shengIndex=0;
        for(shengIndex=0;shengIndex<sheng.length;shengIndex++)//省份
        {
            ORG=876+shengIndex;

            int corpIndex=random.nextInt(1)+1;
            //使用Set组合公司名字避免重复
            Set cropName=new HashSet();
            for(int i=0;i<=corpIndex+10;i++) {
                int name1=random.nextInt(corpName1.length);
                int name2=random.nextInt(corpName2.length);
                int name3=random.nextInt(hangye1.length);
                cropName.add(corpName1[name1]+corpName2[name2]+hangye1[name3]);
            }
            Iterator it=cropName.iterator();
            for(int index=0;index<corpIndex;index++)//每个省下有多少公司
            {
                CorpNum++;
                Integer[] keys = map.keySet().toArray(new Integer[0]);
                Integer randomkey=keys[random.nextInt(keys.length)];
                String randomvalue=map.get(randomkey);

                ID=randomkey;
                //所属行业
                BELONG_TRADE=randomvalue;

                SEQ_ID=index+1;
                //System.out.println("公司序号："+SEQ_ID);

                //信用代码
                int creditnum1=random.nextInt(10);
                int creditnum2=random.nextInt(10);
                int creditnum3=(int)((Math.random()*9+1)*100000);
                int creditnum4=(int)((Math.random()*9+1)*100000000);
                String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char creditnum5=chars.charAt((int)(Math.random() * 26));
                REG_NO=""+creditnum1+creditnum2+creditnum3+creditnum4+creditnum5;
                //System.out.println("信用代码："+REG_NO);

                //公司名称
                String name=it.next().toString();
                CORP_NAME=sheng[shengIndex]+name+"有限公司";
                //System.out.println("企业名称："+CORP_NAME);

                //公司地址
                int shiindex=random.nextInt(shi.length);
                int qvindex=random.nextInt(qv.length);
                int jiedaoindex=random.nextInt(jiedao.length);
                int qvhao=random.nextInt(500);
                ADDR=sheng[shengIndex]+shi[shiindex]+qv[qvindex]+jiedao[jiedaoindex]+qvhao+"号";
                //System.out.println("企业地址："+ADDR);

                //登记机关
                BELONG_ORG=shi[shiindex]+guanlijv;
                //System.out.println("登记机关："+BELONG_ORG);

                //所属地区
                BELONG_DIST_ORG=shi[shiindex]+qv[qvindex];
                //System.out.println("所属地区:"+BELONG_DIST_ORG);
                int hangye2index=random.nextInt(hangye2.length);

                //公司类型
                ECON_KIND="有限责任公司";
                //System.out.println("公司类型："+ECON_KIND);

                //公司大类
                int gongsidaleiindex=random.nextInt(gongsidalei.length);
                ADMIT_MAIN=gongsidalei[gongsidaleiindex];
                //System.out.println("公司大类："+ADMIT_MAIN);

                //日期
                int chenglinian=random.nextInt(55)+1960;
                int chengliyue=random.nextInt(12)+1;
                int chengliri=random.nextInt(28)+1;
                String yue,ri;
                if(chengliyue<10) {
                    yue="0"+chengliyue;
                }else {
                    yue=""+chengliyue;
                }
                if(chengliri<10) {
                    ri="0"+chengliri;
                }else {
                    ri=""+chengliri;
                }
                START_DATE=chenglinian+"/"+yue+"/"+ri;
                //System.out.println("成立日期："+START_DATE);

                REG_CAPI=0;
                CREATE_DATE=chenglinian+"/"+yue+"/"+ri;

                //法人
                int x=random.nextInt(firstname.length);
                int y=random.nextInt(lastname1.length);
                int z=random.nextInt(lastname2.length);
                OPER_MAN_NAME=firstname[x]+lastname1[y]+lastname2[z];

                int s1=(int)((Math.random()*9+1)*100000);
                int s2=random.nextInt(80)+1918;
                int s3=random.nextInt(12)+1;
                int s4=random.nextInt(28)+1;

                if(s3<10) {
                    yue="0"+s3;
                }else {
                    yue=""+s3;
                }
                if(s4<10) {
                    ri="0"+s4;
                }else {
                    ri=""+s4;
                }
                int s5=Math.round((random.nextFloat()+1)*1000);
                OPER_MAN_IDENT_NO=""+s1+s2+yue+ri+s5;
                //System.out.println("法人编号："+OPER_MAN_IDENT_NO);
                //System.out.println("法人名称："+OPER_MAN_NAME);

                //经营状态
                CORP_STATUS="0"+(random.nextInt(4)+1);
                //System.out.println("经营状态："+CORP_STATUS);

                FARE_TERM_END="长期";
                //System.out.println("经营期限止："+FARE_TERM_END);

                //经营范围
                int jingyingfanwei1index=random.nextInt(jingyingfanwei1.length);
                int jingyingfanwei2index=random.nextInt(jingyingfanwei2.length);
                int jingyingfanwei3index=random.nextInt(jingyingfanwei3.length);
                int hangye1index=random.nextInt(hangye1.length);
                FARE_SCOPE=hangye1[hangye1index]+"，"+jingyingfanwei1[jingyingfanwei1index]+jingyingfanwei2[jingyingfanwei2index]+jingyingfanwei3[jingyingfanwei3index];
                FARE_SCOPE=FARE_SCOPE.substring(0, FARE_SCOPE.length()-1)+"等";
//                System.out.println("经营范围："+FARE_SCOPE);

                //注册号
                Double dd=Math.random();
                String q1=dd.toString().substring(2, 13);
                String q2=dd.toString().substring(2, 6);
                UNI_SCID=q1+q2;
                //System.out.println("注册号："+UNI_SCID);

                //电话
                dd=Math.random();
                String q3=dd.toString().substring(2, 5);
                String q4=dd.toString().substring(2, 9);
                TEL=q3+"-"+q4;
                //System.out.println("电话："+TEL);

                //官网/邮箱
                StringBuffer zhongjianzifu = new StringBuffer();
                for(int zhongjian=0;zhongjian<(random.nextInt(10)+5);zhongjian++)
                {
                    zhongjianzifu.append(xiaozimu.charAt(random.nextInt(xiaozimu.length())));
                }
                WEB_URL="www."+zhongjianzifu.toString()+".com.cn";
                //System.out.println("官网:"+WEB_URL);
                EMAIL="jxsw@"+zhongjianzifu+".com.cn";
                //System.out.println("邮箱："+EMAIL);

                //从业人数
                PRAC_PERSON_NUM=random.nextInt(400)+100;
                //System.out.println("从业人数："+PRAC_PERSON_NUM);

                //组织机构代码
                dd=Math.random();
                String q5=dd.toString().substring(2, 10);
                ORG_INST_CODE=q5+"-"+random.nextInt(10);
                //System.out.println("组织机构代码:"+ORG_INST_CODE);

                //纳税人识别号
                TAXPAY_NUM=REG_NO;
                //System.out.println("纳税人识别号："+TAXPAY_NUM);

                //人员规模
                int q6=random.nextInt(1000)+200;
                STAFF_SIZE="100-"+q6+"人";
                //System.out.println("人员规模："+STAFF_SIZE);

                StringBuffer danci = new StringBuffer();
                //英文名
                for(int dancishuliang=0;dancishuliang<random.nextInt(3)+3;dancishuliang++)
                {
                    for(int zhongjian=0;zhongjian<(random.nextInt(5)+5);zhongjian++)
                    {
                        danci.append(xiaozimu.charAt(random.nextInt(xiaozimu.length())));
                    }
                    danci.append(' ');
                }
                ENGLISH_NAME=danci.toString();
                //System.out.println("英文名："+ENGLISH_NAME);

                //曾用名
                FORMER_NAME="null";
                //System.out.println("曾用名："+FORMER_NAME);

                String time=CREATE_DATE;
                String[] caifen1=time.split(" ");

                String[] caifen2=caifen1[0].split("/");
                int shengheinian=Integer.parseInt(caifen2[0]);
                int shengheiyue=Integer.parseInt(caifen2[1]);
                int shengheiri=Integer.parseInt(caifen2[2]);

                START_DATE=caifen1[0];
//                System.out.println("成立日期"+START_DATE);

                CHECK_DATE=shengheinian+(random.nextInt(15)+1)+"/"+yue+"/"+ri;
//                System.out.println("核准日期："+CHECK_DATE);

                FARE_TERM_START=caifen1[0];
//                System.out.println("经营期限起："+FARE_TERM_START);

                CREATE_ORG=ORG;
                //System.out.println("创建机构代码："+CREATE_ORG);
                String sql="insert into T_CORP values("+ORG+", "+ID+", "+SEQ_ID+", '"+REG_NO+"', '"+CORP_NAME+"', '"+ADDR+"', '"+BELONG_ORG+"', '"+BELONG_DIST_ORG+"', '"+BELONG_TRADE+"', '"+ECON_KIND+"', '"+ADMIT_MAIN+"', to_date('"+START_DATE+"','yyyy-mm-dd hh24:mi'), to_date('"+CHECK_DATE+"','yyyy-mm-dd hh24:mi'), '"+OPER_MAN_IDENT_NO+"', '"+OPER_MAN_NAME+"', '"+CORP_STATUS+"', "+REG_CAPI+", to_date('"+FARE_TERM_START+"','yyyy-mm-dd hh24:mi'), '"+FARE_TERM_END+"', '"+UNI_SCID+"', '"+TEL+"', '"+WEB_URL+"', '"+EMAIL+"', "+PRAC_PERSON_NUM+", '"+ORG_INST_CODE+"', '"+TAXPAY_NUM+"', '"+STAFF_SIZE+"', '"+ENGLISH_NAME+"', "+FORMER_NAME+", to_date('"+CREATE_DATE+"','yyyy-mm-dd hh24:mi'), '"+CREATE_ORG+"','"+FARE_SCOPE+"')";
//                String sql="insert into T_CORP values("+ORG+", "+ID+", "+SEQ_ID+", '"+REG_NO+"', '"+CORP_NAME+"', '"+ADDR+"', '"+BELONG_ORG+"', '"+BELONG_DIST_ORG+"', '"+BELONG_TRADE+"', '"+ECON_KIND+"', '"+ADMIT_MAIN+"', to_date('"+START_DATE+"','yyyy-mm-dd hh24:mi'), to_date('"+CHECK_DATE+"','yyyy-mm-dd hh24:mi'), '"+OPER_MAN_IDENT_NO+"', '"+OPER_MAN_NAME+"', '"+CORP_STATUS+"', "+REG_CAPI+", to_date('"+FARE_TERM_START+"','yyyy-mm-dd hh24:mi'), '"+FARE_TERM_END+"', "+"'"+FARE_SCOPE+"', '"+UNI_SCID+"', '"+TEL+"', '"+WEB_URL+"', '"+EMAIL+"', "+PRAC_PERSON_NUM+", '"+ORG_INST_CODE+"', '"+TAXPAY_NUM+"', '"+STAFF_SIZE+"', '"+ENGLISH_NAME+"', "+FORMER_NAME+", to_date('"+CREATE_DATE+"','yyyy-mm-dd hh24:mi'), "+CREATE_ORG+")";
                System.out.println(sql);

                //向公司表插入数据
                dao.insertData(sql);
            }
        }
        System.out.println("公司总数"+CorpNum);
        for(int i=1;i<CorpNum-1;i++) {
            int j=i-1;
            //System.out.println("i:"+i+"  j:"+j);
            T_CORPBean company=dao.searchOneCorp("SELECT * from T_CORP WHERE rownum<="+i+" minus (SELECT * from T_CORP WHERE rownum<="+j+")");
            System.out.println("查询到的添加其他表的公司信息："+company);


            int STOCK_ORG;
            int STOCK_ID;//同一个公司不一样
            int STOCK_SEQ_ID;
            String STOCK_TYPE;
            String COUNTRY;
            String CERTIFICATE_TYPE;
            String CERTIFICATE_NO;
            String STOCK_NAME;
            String STOCK_CAPI_TYPE;
            float STOCK_CAPI;
            float STOCK_CAPI_DOLLAR;
            float STOCK_CAPI_RMB;
            String STOCK_PERCENT;
            float STOCK_RATE_RMB=1.0f;
            float STOCK_RATE_DOLLAR=0.1579f;
            String CREATE_DATE;

            float renjiaozonge=0;
            //存储一个公司所有股东信息
            ArrayList<T_CORP_STOCKBean> AllStock=new ArrayList<>();

            STOCK_ORG=company.getORG();
            STOCK_SEQ_ID=company.getSEQ_ID();

            CREATE_DATE=company.getCREATE_DATE().substring(0, 10);



            //控制股东个数
            int number=random.nextInt(8)+1;
            //随机查询公司表随机生成股东为公司
            //存储生成的股东名称
            ArrayList<String> stock_Corp=dao.searchData();
            //去除和主公司名字一样的名字
            for(int b=0;b<stock_Corp.size();b++) {
                if(stock_Corp.get(b).equals(company.getCORP_NAME())||stock_Corp.get(b)==company.getCORP_NAME()) {
                    stock_Corp.remove(b);
                }
            }

            //生成一个公司的股东
            for(int index=0;index<number;index++) {
                //主键股东序号
                STOCK_ID=index+1000;
                //System.out.println("股东主键："+STOCK_ORG+","+STOCK_ID+","+STOCK_SEQ_ID);

                //股东名
                if(stock_Corp.size()<=index) {
                    int x=random.nextInt(firstname.length);
                    int y=random.nextInt(lastname1.length);
                    int z=random.nextInt(lastname2.length);
                    STOCK_NAME=firstname[x]+lastname1[y]+lastname2[z];
                    STOCK_TYPE="自然人";
                    CERTIFICATE_TYPE="身份证";
                    //身份证号
                    int s1=(int)((Math.random()*9+1)*100000);
                    int s2=random.nextInt(80)+1918;
                    int s3=random.nextInt(12)+1;
                    int s4=random.nextInt(28)+1;
                    String yue;
                    String ri;
                    if(s3<10) {
                        yue="0"+s3;
                    }else {
                        yue=""+s3;
                    }
                    if(s4<10) {
                        ri="0"+s4;
                    }else {
                        ri=""+s4;
                    }
                    int s5=Math.round((random.nextFloat()+1)*1000);
                    CERTIFICATE_NO=""+s1+s2+yue+ri+s5;
                }else {
                    STOCK_NAME=stock_Corp.get(index);
                    STOCK_TYPE="公司";
                    CERTIFICATE_TYPE="null";
                    CERTIFICATE_NO="null";
                }
                //System.out.println("股东名称："+STOCK_NAME);
                //System.out.println("身份证号："+CERTIFICATE_NO);
                //国家
                int n=random.nextInt(country.length);
                COUNTRY=country[n];
                //System.out.println("国家："+COUNTRY);

                STOCK_CAPI_TYPE="人民币";

                //股东认缴
                int renjiaoe=random.nextInt(500)+20;
                //保留两位小数
                DecimalFormat   fnum  =   new  DecimalFormat("#.00");
                String   dd=fnum.format(renjiaoe*0.1579);
                float renjiaoedollor=Float.parseFloat(dd);

                STOCK_CAPI=renjiaoe*1.0f;
                STOCK_CAPI_RMB=renjiaoe*STOCK_RATE_RMB;
                STOCK_CAPI_DOLLAR=renjiaoedollor;

                renjiaozonge=renjiaozonge+renjiaoe;

                T_CORP_STOCKBean STOCK=new T_CORP_STOCKBean();//存储一个公司生成的股东信息
                STOCK.setORG(STOCK_ORG);
                STOCK.setSEQ_ID(STOCK_SEQ_ID);
                STOCK.setID(STOCK_ID);
                STOCK.setCERTIFICATE_NO(CERTIFICATE_NO);
                STOCK.setCERTIFICATE_TYPE(CERTIFICATE_TYPE);
                STOCK.setCOUNTRY(COUNTRY);
                STOCK.setCREATE_DATE(CREATE_DATE);
                STOCK.setSTOCK_CAPI(STOCK_CAPI);
                STOCK.setSTOCK_CAPI_DOLLAR(STOCK_CAPI_DOLLAR);
                STOCK.setSTOCK_CAPI_RMB(STOCK_CAPI_RMB);
                STOCK.setSTOCK_CAPI_TYPE(STOCK_CAPI_TYPE);
                STOCK.setSTOCK_NAME(STOCK_NAME);
                STOCK.setSTOCK_RATE_DOLLAR(STOCK_RATE_DOLLAR);
                STOCK.setSTOCK_RATE_RMB(STOCK_RATE_RMB);
                STOCK.setSTOCK_TYPE(STOCK_TYPE);

                AllStock.add(STOCK);

            }
            //更新公司表中的投资金额
            dao.update("update T_CORP set REG_CAPI="+renjiaozonge+" where ORG="+company.getORG()+" and SEQ_ID="+company.getSEQ_ID()+" ");

            for(int o=0;o<number;o++)
            {
                T_CORP_STOCKBean t=AllStock.get(o);
                float bili=t.getSTOCK_CAPI()/renjiaozonge;
                //System.out.println("总额："+renjiaozonge);
                //System.out.println("个人金额："+t.getSTOCK_CAPI());
                //System.out.println("比例"+bili);

                DecimalFormat   fnum  =   new  DecimalFormat("#0.00");
                String dd=fnum.format(bili*100);

                t.setSTOCK_PERCENT(dd+"%");
                //System.out.println("转化为百分比:"+t.getSTOCK_PERCENT());


                String sql="insert into T_CORP_STOCK values("+t.getORG()+", "+t.getID()+", "+t.getSEQ_ID()+", "+"'"+t.getSTOCK_TYPE()+"', "+"'"+t.getCOUNTRY()+"', "+"'"+t.getCERTIFICATE_TYPE()+"', "+"'"+t.getCERTIFICATE_NO()+"', "+"'"+t.getSTOCK_NAME()+"', "+"'"+t.getSTOCK_CAPI_TYPE()+"', "+t.getSTOCK_CAPI()+", "+t.getSTOCK_CAPI_DOLLAR()+", "+t.getSTOCK_CAPI_RMB()+", "+"'"+t.getSTOCK_PERCENT()+"', "+t.getSTOCK_RATE_RMB()+", "+t.getSTOCK_RATE_DOLLAR()+", "+"to_date('"+t.getCREATE_DATE()+"','yyyy-mm-dd hh24:mi'))";

                System.out.println(sql);
                dao.insertData(sql);
                //向公司和股东的中间表插入数据
                String stockSql="insert into T_M_CORP_CORP_STOCK values("+company.getORG()+", "+company.getID()+", "+company.getSEQ_ID()+","+t.getORG()+", "+t.getID()+", "+t.getSEQ_ID()+")";
                System.out.println("股东中间表："+stockSql);
                dao.insertData(stockSql);
            }
            System.out.println("-----------------------------------------------------------------");

            //生成主要成员信息
            int PERTAIN_ORG;
            int PERTAIN_ID;
            int PERTAIN_SEQ_ID;
            String PERTAIN_CERTIFICATE_TYPE;//证件类型
            String PERSON_NAME;//成员姓名
            String PERSON_TYPE;//成员职务
            String PERTAIN_CERTIFICATE_NO;//证件编号
            String SELECT_TYPE="选举";//产生方式
            String HOLDPOST_START;//任职期限起
            String HOLDPOST_END="2222/12/12 12:12";//任职期限止
            String SEX;//性别
            int AGE;//年龄
            String PERTAIN_COUNTRY;//国籍
            String PERTAIN_CREATE_DATE;//创建日期

            PERTAIN_ORG=company.getORG();
            PERTAIN_SEQ_ID=company.getSEQ_ID();
            PERTAIN_CREATE_DATE=company.getCREATE_DATE().substring(0, 10);
            int personnum=random.nextInt(10);
            for(int z=0;z<personnum;z++) {//每个公司的成员
                PERTAIN_ID=z+1000;//主键成员序号
                System.out.println("主要成员主键："+PERTAIN_ORG+","+PERTAIN_ID+","+PERTAIN_SEQ_ID);
                //证件类型
                int cert=random.nextInt(certificate_type.length);
                CERTIFICATE_TYPE=certificate_type[cert];
                //System.out.println(CERTIFICATE_TYPE);

                //成员姓名
                int x1=random.nextInt(firstname.length);
                int y1=random.nextInt(lastname1.length);
                int z1=random.nextInt(lastname2.length);
                PERSON_NAME=firstname[x1]+lastname1[y1]+lastname2[z1];
                //System.out.println("成员姓名："+PERSON_NAME);

                //职务
                int person=random.nextInt(person_type.length);
                PERSON_TYPE=person_type[person];
                //System.out.println(PERSON_TYPE);

                //身份证号
                int s1=(int)((Math.random()*9+1)*100000);
                int s2=random.nextInt(80)+1918;
                int s3=random.nextInt(12)+1;
                int s4=random.nextInt(28)+1;
                String yue,ri;
                if(s3<10) {
                    yue="0"+s3;
                }else {
                    yue=""+s3;
                }
                if(s4<10) {
                    ri="0"+s4;
                }else {
                    ri=""+s4;
                }
                int s5=Math.round((random.nextFloat()+1)*1000);
                CERTIFICATE_NO=""+s1+s2+yue+ri+s5;
                //System.out.println("证件号："+CERTIFICATE_NO);

                //性别
                int sex=random.nextInt(2);
                if(sex==0) {
                    SEX="女";
                }else {
                    SEX="男";
                }
                //System.out.println(SEX);

                //年龄
                int age=random.nextInt(40)+30;
                AGE=age;
                //System.out.println("年龄"+AGE);

                //国籍
                int coun=random.nextInt(country.length);
                COUNTRY=country[coun];
                //System.out.println("国家："+COUNTRY);

                //日期
                int s6=random.nextInt(80)+1880;//成立年份
                int s7=random.nextInt(24);//成立小时
                int s8=random.nextInt(60);//成立分
                HOLDPOST_START=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;

                String sql="insert into T_CORP_PERTAINS values("+PERTAIN_ORG+", "+PERTAIN_ID+", "+PERTAIN_SEQ_ID+", '"+CERTIFICATE_TYPE+"', '"+PERSON_NAME+"', '"+PERSON_TYPE+"', '"+CERTIFICATE_NO+"', '"+SELECT_TYPE+"', to_date('"+HOLDPOST_START+"','yyyy-mm-dd hh24:mi'),  to_date('"+HOLDPOST_END+"','yyyy-mm-dd hh24:mi'), '"+SEX+"', "+AGE+", '"+COUNTRY+"', to_date('"+PERTAIN_CREATE_DATE+"', 'yyyy-mm-dd hh24:mi'))";
                System.out.println("主要成员："+sql);
                dao.insertData(sql);
                String pertainSql="insert into T_M_CORP_CORP_PERTAINS values("+company.getORG()+", "+company.getID()+", "+company.getSEQ_ID()+", "+PERTAIN_ORG+", "+PERTAIN_ID+", "+PERTAIN_SEQ_ID+")";
                System.out.println("主要成员中间表"+pertainSql);
                dao.insertData(pertainSql);
            }

            int DIST_ORG;//主键机关代码
            int DIST_ID;//代表分公司序列
            int DIST_SEQ_ID;//主公司序列
            String DIST_REG_NO;//分支机构统一社会信用代码
            String DIST_NAME;//分支机构名称
            String DIST_BELONG_ORG;
            int DIST_CORP_ORG;
            int DIST_CORP_ID;
            int DIST_CORP_SEQ_ID;
            String FARE_PLACE;//营业场所
            String OPER_MAN_IDENT_NO;//负责人证件编号
            String OPER_MAN_NAME;//负责人姓名
            String FARE_SCOPE;//经营范围
            String START_DATE;//成立日期
            String CHECK_DATE;//核准日期
            String DIST_CREATE_DATE;//创建时间

            DIST_ORG=company.getORG();
            DIST_SEQ_ID=company.getSEQ_ID();
            DIST_CREATE_DATE=company.getCREATE_DATE().substring(0, 10);

            DIST_CORP_ORG=company.getORG();
            DIST_CORP_ID=company.getID();
            DIST_CORP_SEQ_ID=company.getSEQ_ID();

            int creditnum1=random.nextInt(10);
            int creditnum2=random.nextInt(10);
            int creditnum3=(int)((Math.random()*9+1)*100000);

            int distnum=random.nextInt(10);
            for(int z=0;z<distnum;z++) {//每个公司分公司个数
                //主键公司序号
                DIST_ID=z+1000;

                //分支机构统一社会信用代码
                /*   统一社会信用代码设计为18位，使用阿拉伯数字或英文字母表示，由五个部分组成。
                 * 第一部分（第1位）：为登记管理部门代码；
                 * 第二部分（第2位）：为企业等纳税人类别代码；
                 * 第三部分（第3-8位）：为登记管理机关行政区划码；
                 * 第四部分（第9-17位）：为主体标识码；
                 * 第五部分（第18位）：为校验码，由系统自动生成。*/
                int creditnum4=(int)((Math.random()*9+1)*100000000);
                String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char creditnum5=chars.charAt((int)(Math.random() * 26));
                DIST_REG_NO=""+creditnum1+creditnum2+creditnum3+creditnum4+creditnum5;
                //System.out.println("信用代码："+DIST_REG_NO);

                //负责人证件编号
                int s1=(int)((Math.random()*9+1)*100000);
                int s2=random.nextInt(80)+1918;
                int s3=random.nextInt(12)+1;
                int s4=random.nextInt(28)+1;
                String yue,ri;
                if(s3<10) {
                    yue="0"+s3;
                }else {
                    yue=""+s3;
                }
                if(s4<10) {
                    ri="0"+s4;
                }else {
                    ri=""+s4;
                }
                int s5=Math.round((random.nextFloat()+1)*1000);
                OPER_MAN_IDENT_NO=""+s1+s2+yue+ri+s5;
                //System.out.println("证件号："+OPER_MAN_IDENT_NO);

                //负责人
                int x1=random.nextInt(firstname.length);
                int y1=random.nextInt(lastname1.length);
                int z1=random.nextInt(lastname2.length);
                OPER_MAN_NAME=firstname[x1]+lastname1[y1]+lastname2[z1];
                //System.out.println("负责人："+OPER_MAN_NAME);

                //日期
                int s6=random.nextInt(55)+1960;//公司成立年份
                int s7=random.nextInt(24);//公司成立小时
                int s8=random.nextInt(60);//公司成立分
                START_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
                CHECK_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;

                //System.out.println("分公司表创立日期"+CREATE_DATE);

                //营业场所
                int shiindex=random.nextInt(shi.length);
                int qvindex=random.nextInt(qv.length);
                int jiedaoindex=random.nextInt(jiedao.length);
                int menpaihao=random.nextInt(500);
                FARE_PLACE=shi[shiindex]+qv[qvindex]+jiedao[jiedaoindex]+menpaihao+"号";
                //System.out.println("营业场所："+FARE_PLACE);

                //分支机构名称
                DIST_NAME=company.getCORP_NAME()+shi[shiindex]+"分公司";

                //分支机构登记机关
                DIST_BELONG_ORG=shi[shiindex]+"工业园区市场监督管理局";

                //经营范围
                int jingyingfanwei1index=random.nextInt(jingyingfanwei1.length);
                int jingyingfanwei2index=random.nextInt(jingyingfanwei2.length);
                int jingyingfanwei3index=random.nextInt(jingyingfanwei3.length);
                int hangye1index=random.nextInt(hangye1.length);
                FARE_SCOPE=hangye1[hangye1index]+"，"+jingyingfanwei1[jingyingfanwei1index]+jingyingfanwei2[jingyingfanwei2index]+jingyingfanwei3[jingyingfanwei3index];
                FARE_SCOPE=FARE_SCOPE.substring(0, FARE_SCOPE.length()-1)+"等";

                String sql="insert into T_CORP_DIST values("+DIST_ORG+", "+DIST_ID+", "+DIST_SEQ_ID+", '"+DIST_REG_NO+"', '"+DIST_NAME+"', '"+DIST_BELONG_ORG+"', "+DIST_CORP_ORG+", "+DIST_CORP_ID+", "+DIST_CORP_SEQ_ID+", '"+FARE_PLACE+"', '"+OPER_MAN_IDENT_NO+"', '"+OPER_MAN_NAME+"', '"+FARE_SCOPE+"', "+"to_date('"+START_DATE+"','yyyy-mm-dd hh24:mi')"+", "+"to_date('"+CHECK_DATE+"','yyyy-mm-dd hh24:mi')"+", "+"to_date('"+CREATE_DATE+"','yyyy-mm-dd hh24:mi')"+")";
                System.out.println("分公司："+sql);
                dao.insertData(sql);
            }

        }//公司结束
    }
}
