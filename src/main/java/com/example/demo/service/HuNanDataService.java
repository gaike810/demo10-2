package com.example.demo.service;

import com.example.demo.modle.DeviceIdCompanyInfo;
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
public interface HuNanDataService {

    ArrayList<Map<String, Object>> findAllDataLists();


    ArrayList<Map<String, Object>> findBochuangByLists();

    int insertDeviceIdCompany(DeviceIdCompanyInfo deviceIdCompanyInfo);

    int countDeviceId(DeviceIdCompanyInfo deviceIdCompanyInfo);


}
