package com.example.demo.service.impl;

import com.example.demo.dao.EquipmentMapper;
import com.example.demo.dao.HuNanDataMapper;
import com.example.demo.modle.DeviceIdCompanyInfo;
import com.example.demo.modle.SchoolOrder;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.HuNanDataService;
import com.example.demo.util.TableSubmeterUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2022/03/01/13:13
 * @Description:
 */
@Service
public class HuNanDataServiceImpl implements HuNanDataService {

    private static final String TABLE_NAME = "v_workplotitem";

    @Resource
    private HuNanDataMapper huNanDataMapper;


    @Override
    public ArrayList<Map<String, Object>> findAllDataLists() {
        return huNanDataMapper.findAllDataLists();
    }

    @Override
    public ArrayList<Map<String, Object>> findBochuangByLists() {
        return huNanDataMapper.findBochuangByLists();
    }

    @Override
    public int insertDeviceIdCompany(DeviceIdCompanyInfo deviceIdCompanyInfo) {
        return huNanDataMapper.insertDeviceIdCompany(deviceIdCompanyInfo);
    }

    @Override
    public int countDeviceId(DeviceIdCompanyInfo deviceIdCompanyInfo) {
        return huNanDataMapper.countDeviceId(deviceIdCompanyInfo);
    }
}
