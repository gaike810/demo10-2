package com.example.demo;

//import org.apache.tomcat.jni.File;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/23/08:58
 * @Description:
 */
public class Z_testclass2 {

    public static void readTxtFile(String filePath) {
        try {

            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader read = new InputStreamReader(fileInputStream, encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
//                    System.out.println(lineTxt);

//                    String readtext  =  bufferedReader.readLine();
//                        String as_text = readtext.substring(readtext.indexOf("推送结果：")+1,readtext.indexOf("ResultCode"));
//                        System.out.println(as_text);

                    //手机号码格式错误
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("手机号码格式错误")) {
//                        String as_text = readtext.substring(readtext.indexOf("终端设备：")+5,readtext.indexOf(" 推送结果"));
//                        System.out.println(as_text);
//                    }

                    //区划从属关系错误
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("区划从属关系错误")) {
//                        String as_text = readtext.substring(readtext.indexOf("终端设备：")+5,readtext.indexOf(" 推送结果"));
//                        System.out.println(as_text);
//                    }

                    //车主信息不完整
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("车主信息不完整")) {
//                        String as_text = readtext.substring(readtext.indexOf("终端设备：")+5,readtext.indexOf(" 推送结果"));
//                        System.out.println(as_text);
//                    }

                    //该车辆号牌已存在
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("该车辆号牌已存在")) {
//                        String as_text = readtext.substring(readtext.indexOf("终端设备：")+5,readtext.indexOf(" 推送结果"));
//                        System.out.println(as_text);
//                    }

                    //农机类型编号错误  -----问题 拖拉机 ok
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("农机类型编号错误")) {
//                        String as_text = readtext.substring(readtext.indexOf("终端设备：")+5,readtext.indexOf(" 推送结果"));
//                        System.out.println(as_text);
//                    }

                    //所属区县信息不存在！区划从属关系错误
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("所属区县信息不存在！区划从属关系错误")) {
//                        String as_text = readtext.substring(readtext.indexOf("终端设备：")+5,readtext.indexOf(" 推送结果"));
//                        System.out.println(as_text);
//                    }

                    //不存在的终端编号
//                    String readtext  =  bufferedReader.readLine();
//                    if (readtext.contains("不存在的终端编号")) {
//                        String as_text = readtext.substring(readtext.indexOf("推送结果：")+5,readtext.indexOf("\"ResultCode\":1"));
//                        System.out.println(as_text);
//                    }


                    String readtext = bufferedReader.readLine();
                    if (readtext.contains("区域信息不正确或不存在")) {
//                        String as_text = readtext.substring(readtext.indexOf("推送结果：")+5,readtext.indexOf("\"ResultCode\":1"));
//                        System.out.println(as_text);
                        String as_text = readtext.substring(readtext.indexOf("【"), readtext.indexOf("】"));
                        System.out.println(as_text);
                    }


//                    String readtext  =  bufferedReader.readLine();

                    System.out.println("readtext");


                }


                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        Double a = 1+Math.random()*(10-1+1);
//        System.out.println(a);
//        System.out.println(a);

//        String number = "1";

        //随机省生成手机号
//        for (int i=0;i<5;i++){
//            String number = "13";//定义电话号码以139开头
//            Random random = new Random();//定义random，产生随机数
//            for (int j = 0; j < 9; j++) {
//                //生成0~9 随机数
//                number += random.nextInt(9);
//            }
//            System.out.println(number);
//        }

        System.out.println("hello~");
        String filePath = "file/aaaa.txt";
//        String filePath = "/Users/gaike/Desktop/zzzz.txt";
        readTxtFile(filePath);

    }

}
