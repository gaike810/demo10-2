package com.example.demo.dao;

import com.example.demo.modle.SchoolOrder;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/04/07:13
 * @Description:
 */
public interface SchoolOrderDao {
    //    Map<String ,Object> selectTestMap(String as);
    int addSchoolInfo(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> selectSchoolOrderList(SchoolOrder schoolOrder);

    Map<String, Object> selectOrderinfoByNumber(String order_number);

    String selectnickname(String user_id);

    int updateSchoolInfo(SchoolOrder schoolOrder);
}
