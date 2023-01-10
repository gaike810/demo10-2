package com.example.demo.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/10/22/05:47
 * @Description:
 */
public interface testService {
    Map<String, Object> selectTestMap(String as);

    ArrayList<Map<String, Object>> selectTestList();

}
