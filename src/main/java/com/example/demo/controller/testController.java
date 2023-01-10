package com.example.demo.controller;

import com.example.demo.TokenUtils;
import com.example.demo.service.testService;
import com.example.demo.util.KamUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Chris Gaike
 * @Date: 2020/10/22/05:52
 * @Description:
 */
@RestController
@RequestMapping(value = "/mg/advertising")
public class testController {

    @Resource
    private testService testservice;

    @RequestMapping(value = "/selectestmap.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectTestMap(String token) {

//        boolean toke1 = TokenUtils.verify(token);
//        if (toke1 == true){
//            return "ok!~";
//        }
//            Map<String, Object> map = testservice.selectTestMap(id);

        ArrayList<Map<String, Object>> list = testservice.selectTestList();

        return KamUtil.returnSuccess(list);
//        return "xxxxx";
    }

    @RequestMapping(value = "/paht.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void path() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(path);
        String path3 = this.getClass().getResource("/").getPath();
        System.out.println(path3);
    }
}
