package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDate;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/23/08:58
 * @Description:
 */
public class Z_testclass4 {
    public static void main(String[] args) {

        String postData = "{    \"account\": \"jsbdwx9481\",    \"password\": \"myPsyy\",    \"factoryId\": \"jsbdwx_hd_20211224104208324\",    \"deviceId\": \"jsbdwx_ts002\",    \"infoGuid\": \"de57592acfd64163aa48fe2f739cf332\",    \"d1\": \"1\",    \"d2\": \"2\",    \"d3\": \"3\",    \"d4\": \"4\",    \"d5\": \"5\",    \"d6\": \"1\",    \"d7\": \"2\",    \"d8\": \"2\",    \"d9\": \"2\",    \"d10\": \"2\",    \"d11\": \"2\",    \"d12\": \"2\",    \"d13\": \"2\",    \"d14\": \"2\",    \"d15\": \"2\",    \"d16\": \"2\",     \"d\":    [        {            \"d17\": \"9\",            \"d18\": \"2\",            \"d19\": \"3\",            \"d20\": \"3\",            \"d21\": \"3\",            \"d22\": \"3\",            \"d23\": \"3\",            \"d24\": \"3\",            \"d25\": \"3\",            \"d26\": \"3\",            \"d27\": \"3\"        }    ],    \"d28\": \"4\",    \"d29\": \"4\",    \"d30\": \"4\",    \"d31\": \"4\",    \"d32\": \"4\",    \"d33\": \"4\",    \"d34\": \"4\",    \"d35\": \"4\",    \"d36\": \"4\",    \"d37\": \"4\",    \"d38\": \"4\",    \"d39\": \"4\",    \"d40\": \"4\",    \"d41\": \"4\",    \"d42\": \"4\",    \"d43\": \"4\"}";
        List<Map<String, Object>> listnew = new ArrayList<>();
        List list = Arrays.asList(postData);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        String postDatajson = postData.toString().replaceAll("(?:\\[|null|\\]| +)", "");
        JSONObject returnJson = JSONObject.parseObject(postData);
        JSONArray d = returnJson.getJSONArray("d");
        System.out.println(d);
        returnJson.get("account");
        System.out.println(returnJson.get("d"));
        //去掉中括号
        String ddStr = returnJson.get("d").toString().replaceAll("(?:\\[|null|\\]| +)", "");
        System.out.println(ddStr);
        JSONObject dd = JSONObject.parseObject(ddStr);
        dd.get("d17");
        System.out.println(dd.get("d17"));
//        list.add(dd.get("d17"));
//        System.out.println(list);

        dd.put("aaa", "bbb");
        System.out.println(dd);
    }


}
