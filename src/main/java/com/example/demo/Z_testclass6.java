package com.example.demo;


import com.example.demo.util.KamUtil;
import org.apache.log4j.Logger;

import java.util.*;

import static com.example.demo.util.KamUtil.MD5;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2022/02/19/16:09
 * @Description:
 */
public class Z_testclass6 {

    private static Logger logger = Logger.getLogger(Z_testclass6.class);
//    private static Logger logger = LoggerFactory.getLogger(Z_testclass5.class);

    //Java Map根据键值按ASCII 码从小到大排序并用&连接，值为空的不拼接
    public static String getAsciiSort(Map<String, Object> map) {
        // 移除值为空的
        map.entrySet().removeIf(entry -> Objects.isNull(entry.getValue()) || "".equals(entry.getValue()));

        List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        infoIds.sort((o1, o2) -> o1.getKey().compareToIgnoreCase(o2.getKey()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> infoId : infoIds) {
            sb.append(infoId.getKey());
            sb.append("=");
            sb.append(infoId.getValue());
            sb.append("&");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
//        int [] numbers = {10,20,30,40,50};
//        for (int x: numbers){
//            System.out.println( x );
//        }

//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
//        KamUtil.returnError();
//        System.out.println(KamUtil.returnError());
//        System.out.println("hello world!");


//        SortedMap<String, Object> params = new TreeMap<>();
//        params.put("ZKK", "15");
//        params.put("AT", "1525524700740");
//        params.put("NONCESTR", "1522115166482");
//        params.put("PASSWORD", "123456");
//        params.put("PHONEID", "android");
//        params.put("PHONEIP", "PHONEIP");
//        params.put("USERNAME", "13800000001");
//        params.put("APPID", "A80C1A90A90C4260B52CB8FE559F70BD");
//        System.out.println(params);


        Map<String, Object> map = new HashMap<>();
        map.put("appid", "Q5F7A8e5va0ayfCg");
        map.put("titile", "32");
        map.put("content", "33");
        Z_testclass6.getAsciiSort(map);
        String keys = "key=" + "keyvalue";
        String all = Z_testclass6.getAsciiSort(map) + keys;
//        String sign = ToUpperCase(MD5(all));
        System.out.println(all);
        System.out.println(Z_testclass6.getAsciiSort(map));

    }

    public void map1() {

        Map<String, Object> map = new HashMap<>();
        map.put("appid", "Q5F7A8e5va0ayfCg");
        map.put("titile", "");
        map.put("content", "");
        this.getAsciiSort(map);
        System.out.println(this.getAsciiSort(map));
    }

}
