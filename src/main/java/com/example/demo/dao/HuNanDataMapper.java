package com.example.demo.dao;

import com.example.demo.modle.DeviceIdCompanyInfo;
import com.example.demo.modle.SchoolOrder;

import java.util.ArrayList;
import java.util.Map;

public interface HuNanDataMapper {


    ArrayList<Map<String, Object>> findAllDataLists();


    ArrayList<Map<String, Object>> findBochuangByLists();

    int insertDeviceIdCompany(DeviceIdCompanyInfo deviceIdCompanyInfo);

    int countDeviceId(DeviceIdCompanyInfo deviceIdCompanyInfo);


}
