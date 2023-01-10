package com.example.demo.controller;

import com.example.demo.util.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/excel")
public class ExcelController {

//    @PostMapping(value = "/look",produces="text/html;charset=UTF-8")
//    public void look(@RequestParam("excelFile") MultipartFile file,int a, HttpServletResponse response){
////    public void look(String devicId,int a, HttpServletResponse response){
//        try {
//
//            PrintWriter out = response.getWriter();
//
//            List<String> list = POIUtils.readExcel(file);
////            list.removeIf(Objects::isNull);去掉null值
//            //去掉空字符串
//            Iterator<String> iterator = list.iterator();
//            while (iterator.hasNext()){
//                if (iterator.next() == ""){
//                    iterator.remove();
//                }
//            }
//            //遍历list,查看数据
//            for (String s : list) {
//                System.out.println(s);
//                System.out.println(a);
//                String url = "http://data.linkio.cn/v1/deviceManage/jilin-device-action";
//                String param = "deviceId="+s+"&action="+a;
//                HttpRequest.sendGet(url,param);
//            }
//            //创建map对象或者pojo类存入所需的数据，
////            Map<String,Object> map = new HashMap<>();
////            map.put("plan",list.get(0));
////            map.put("er",list.get(2));
////            map.put("date",list.get(4));
////            System.out.println(map);
//
//            out.println("ok!~");
//            out.flush();
//            out.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @PostMapping(value = "/look", produces = "text/html;charset=UTF-8")
    public String look(String deviceId, int a, HttpServletResponse response) {

        try {
            PrintWriter out = response.getWriter();
            System.out.println(deviceId);
            System.out.println(a);
            String[] p = deviceId.split(",");
            for (int i = 0; i < p.length; i++) {

                String url = "http://data.linkio.cn/v1/deviceManage/jilin-device-action";
                String param = "deviceId=" + p[i] + "&action=" + a;
                HttpRequest.sendGet(url, param);
            }
            out.println("ok!~");
            out.flush();
            out.close();
//            response.getWriter().write("ok~");//写入到返回结果中
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }


    // 崔的小工具 reboot
    @PostMapping(value = "/look2", produces = "text/html;charset=UTF-8")
    public String look2(String deviceId, int a, HttpServletResponse response) {

        try {
            PrintWriter out = response.getWriter();
            System.out.println(deviceId);
            System.out.println(a);
            String[] p = deviceId.split(",");
            for (int i = 0; i < p.length; i++) {

                String url = "http://data.linkio.cn/v1/deviceManage/jilin-device-action-reboot";
                String param = "deviceId=" + p[i] + "&action=" + a;
                HttpRequest.sendGet(url, param);
            }
            out.println("ok!~");
            out.flush();
            out.close();
//            response.getWriter().write("ok~");//写入到返回结果中
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    /**
     * 根据文章id获取信息  jsonp格式返回
     */
    @PostMapping(value = "/upload_jsonp", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void getArticleById_jsonp(HttpServletResponse response) {
        try {
//            EasyExcel.read(file.getInputStream(), Subject.class,new ExcelListener()).sheet().doRead();
            PrintWriter out = response.getWriter();
            out.println("okokok");
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping(value = "/login", produces = "text/html;charset=UTF-8")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从前端传递的request中取值
        System.out.println("前端传递过来的名字是" + request.getParameter("name"));
        //构造json字符串传递回前端，\为java转义符号为了转义双引号
        //注意这里格式要求很严格，不能用单引号，建议使用第三方框架自动生成json字符串
        String s = "{\"name\":\"张三\",\"password\":\"123456\"}";
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");//返回的格式必须设置为application/json
        response.getWriter().write(s);//写入到返回结果中
        //完成，执行到这里就会返回数据给前端，前端结果为success，调用success里面的内容
    }


}

