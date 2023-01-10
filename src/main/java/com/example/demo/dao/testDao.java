package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/10/22/05:45
 * @Description:
 */
public interface testDao {
    Map<String, Object> selectTestMap(String as);

    ArrayList<Map<String, Object>> selectTestList();
}
