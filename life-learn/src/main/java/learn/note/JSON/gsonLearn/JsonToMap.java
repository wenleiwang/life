package learn.note.JSON.gsonLearn;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author WangWenLei
 * @DATE: 2021/6/22
 **/
public class JsonToMap {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .serializeNulls()// 当字段值为空或null时，依然对该字段进行转换
                .setLenient()// json宽松
                .setPrettyPrinting()//变得更好看
                .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
                .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
                .disableHtmlEscaping() //防止特殊字符出现乱码。默认是GSON把HTML，转义用的

                ;
        gsonBuilder.registerTypeAdapter(Student.class,new StudentAdapter());
        Gson gson =        gsonBuilder.create();
        String json1 = "{\"message\":\"SUCCESS\",\"errorCode\":null,\"code\":\"1\",\"data\":[{\"boaid\":100006212,\"bname\":\"张霞\",\"bofficeemail\":\"zhangxiacf@cf.com11\",\"soaid\":100005619,\"sname\":\"张霞\",\"sofficeemail\":\"zhangxia@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006215,\"bname\":\"刘峻熙\",\"bofficeemail\":\"liujunxicf@cf.com11\",\"soaid\":90236313,\"sname\":\"刘峻熙\",\"sofficeemail\":\"liujunxi@3385.com11\",\"sperformstandard\":\"直营中心负责人\"},{\"boaid\":100006208,\"bname\":\"兰天舒\",\"bofficeemail\":\"lantianshucf@cf.com11\",\"soaid\":90236827,\"sname\":\"兰天舒\",\"sofficeemail\":\"lantianshu@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006211,\"bname\":\"王东杰\",\"bofficeemail\":\"wangdongjiecf@cf.com11\",\"soaid\":100005437,\"sname\":\"王东杰\",\"sofficeemail\":\"wangdongjie@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006210,\"bname\":\"冯荣博\",\"bofficeemail\":\"451517516@qq.com\",\"soaid\":90236534,\"sname\":\"冯荣博\",\"sofficeemail\":\"451517516@qq.com\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006223,\"bname\":\"雷鹏轶\",\"bofficeemail\":\"leipengyicf@cf.com11\",\"soaid\":90236047,\"sname\":\"雷鹏轶\",\"sofficeemail\":\"leipengyi@3385.com11\",\"sperformstandard\":\"后台主管\"},{\"boaid\":100006216,\"bname\":\"陶自豪\",\"bofficeemail\":\"taozihaocf@cf.com11\",\"soaid\":90236230,\"sname\":\"陶自豪\",\"sofficeemail\":\"taozihao@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006218,\"bname\":\"黄皓然\",\"bofficeemail\":\"huanghaorancf@cf.com11\",\"soaid\":100003739,\"sname\":\"黄皓然\",\"sofficeemail\":\"huanghaoran@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006205,\"bname\":\"马涛\",\"bofficeemail\":\"mataocf@cf.com11\",\"soaid\":90236366,\"sname\":\"马涛\",\"sofficeemail\":\"liutingting.bj@fang.com\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006204,\"bname\":\"李恭杰\",\"bofficeemail\":\"ligongjiecf@cf.com11\",\"soaid\":100003143,\"sname\":\"李恭杰\",\"sofficeemail\":\"ligongjie@3385.com11\",\"sperformstandard\":\"团队负责人\"},{\"boaid\":100006207,\"bname\":\"张雅\",\"bofficeemail\":\"zhangyacf@cf.com11\",\"soaid\":90236241,\"sname\":\"张雅\",\"sofficeemail\":\"zhangya@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006206,\"bname\":\"贾乐\",\"bofficeemail\":\"lichaobj@fang.com\",\"soaid\":90236257,\"sname\":\"贾乐\",\"sofficeemail\":\"lichaobj@fang.com\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006201,\"bname\":\"唐洋\",\"bofficeemail\":\"tangyangcf@cf.com11\",\"soaid\":100003120,\"sname\":\"唐洋\",\"sofficeemail\":\"tangyang@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006203,\"bname\":\"杨小兵\",\"bofficeemail\":\"yangxiaobingcf@cf.com11\",\"soaid\":100003366,\"sname\":\"杨小兵\",\"sofficeemail\":\"yangxiaobing@3385.com11\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006202,\"bname\":\"吕应伟\",\"bofficeemail\":\"lvyingweicf@cf.com11\",\"soaid\":90236840,\"sname\":\"吕应伟\",\"sofficeemail\":\"liutingting.bj@famg.com\",\"sperformstandard\":\"销售个人\"},{\"boaid\":100006803,\"bname\":\"武英杰\",\"bofficeemail\":\"20017198@aos.com\",\"soaid\":100005189,\"sname\":\"武英杰\",\"sofficeemail\":\"wuyingjie@fang.com\",\"sperformstandard\":\"销售个人\"}],\"total\":null,\"totalPage\":null,\"success\":true}";
        Map<String, Object> o = gson.fromJson(json1, new TypeToken<TreeMap<String, Object>>() {}.getType());
        System.out.println(o.toString());

        System.out.println();
    }
}
