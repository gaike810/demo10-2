package com.example.demo.dao;

import com.example.demo.modle.SchoolOrder;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface EquipmentMapper {

    int countcarnum(SchoolOrder schoolOrder);

    String lelectEndDate(String deviceId);

    int countjobnum(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findCarInfoByLists(SchoolOrder schoolOrder);

//    ArrayList<Map<String, Object>> findJobInfoByLists(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findJobInfoByLists1(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findLocationByLists(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findMachineToolByList(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findDeptByLists(SchoolOrder schoolOrder);

    int countDeptnum(SchoolOrder schoolOrder);

}
