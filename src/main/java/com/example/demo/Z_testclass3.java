package com.example.demo;


import java.io.*;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;


public class Z_testclass3 {

    /**
     * 通过解析器将test.json转换成JsonObject
     * 读取json文件
     */
    public static void readTxtFile(String filePath) {
        JSONObject reqData = new JSONObject();
        String encoding = "UTF-8";
        File file = new File(filePath);
        String jsonStr = "";
        try {
            Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8");

            int ch = 0;

            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();

            jsonStr = sb.toString();

            System.out.println(jsonStr);

//            JSONObject jso = JSONObject.fromObject(file);
//            String aa = String.valueOf(jso.get("type"));
//            System.out.println(aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filePath = "file/zaaa.json";
        readTxtFile(filePath);
    }

}
