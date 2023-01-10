package com.example.demo.service;

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
public interface EquipmentService {

    int countcarnum(SchoolOrder schoolOrder);

    String lelectEndDate(String deviceId);

    int countjobnum(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findCarInfoByLists(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findJobInfoByList(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findLocationByLists(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findMachineToolByList(SchoolOrder schoolOrder);

    ArrayList<Map<String, Object>> findDeptByLists(SchoolOrder schoolOrder);

    int countDeptnum(SchoolOrder schoolOrder);

}
