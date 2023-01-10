package com.example.demo;

import redis.clients.jedis.Jedis;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/23/08:58
 * @Description:
 */
public class Z_testclass {
    public static void main(String[] args) {

        //日期相差天数
        LocalDate localDate1 = LocalDate.of(2020, 11, 6);
        LocalDate localDate2 = LocalDate.of(2021, 10, 27);
        System.out.println("日期相差天数 ：" + (localDate2.toEpochDay() - localDate1.toEpochDay()));

//        //redis study demo
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
//        // jedis.auth("123456");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());


    }


}
