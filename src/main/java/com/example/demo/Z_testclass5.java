package com.example.demo;


import com.example.demo.controller.testController;
import com.example.demo.util.KamUtil;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/23/08:58
 * @Description:
 */
public class Z_testclass5 {

    //    private static Logger logger = Logger.getLogger(Z_testclass5.class);
    private static Logger logger = LoggerFactory.getLogger(Z_testclass5.class);

    public static void main(String[] args) {
        String devicId = "jsbdwx_ts001";
        String infoGuid = "de57592acfd64163aa48fe2f739cf332";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6Im15UHN5eSIsImV4cCI6MTY0MDkzNzExMywidXNlcm5hbWUiOiJqc2Jkd3g5NDgxIn0.-VZodU0ERiYXXgjTwsT2-uOgC6xRvvQjZXwF-ATGah0";
//        String timestamp = System.currentTimeMillis()+"";
        String timestamp = "1640830331239";
        System.out.println(timestamp);

        String sign = devicId + "+" + infoGuid + "+" + token + "+" + timestamp;
        System.out.println(sign);
        String sss = KamUtil.MD5(sign);
        System.out.println(sss);
        sss.length();
        System.out.println(sss.length());
        String bigs = sss.toUpperCase(Locale.ROOT);
        System.out.println(bigs);
        System.out.println(sss.toUpperCase(Locale.ROOT));

        String onlines = "A61279A8B7A37035D1E749C36C3C95C8";
        String locals = "A61279A8B7A37035D1E749C36C3C95C8";

        logger.info("devicId:" + locals + " " + onlines);
    }


}
