package com.example.demo.service.impl;

import com.example.demo.dao.SchoolOrderDao;
import com.example.demo.dao.testDao;
import com.example.demo.modle.SchoolOrder;
import com.example.demo.service.SchoolOrderService;
import com.example.demo.service.testService;
import com.example.demo.util.KamUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/04/07:13
 * @Description:
 */
@Service
public class SchoolOrderServiceImpl implements SchoolOrderService {

    @Resource
    private SchoolOrderDao schoolOrderDao;


    @Override
    public int addSchoolInfo(SchoolOrder schoolOrder) {
        schoolOrder.setOrder_number(KamUtil.getOrderNum());
        schoolOrder.setOrder_status("0");
        schoolOrder.setPay_status("0");

        return schoolOrderDao.addSchoolInfo(schoolOrder);
    }

    @Override
    public ArrayList<Map<String, Object>> selectSchoolOrderList(SchoolOrder schoolOrder) {
        return schoolOrderDao.selectSchoolOrderList(schoolOrder);
    }

    @Override
    public Map<String, Object> selectOrderinfoByNumber(String order_number) {
        return schoolOrderDao.selectOrderinfoByNumber(order_number);
    }

    @Override
    public int updateSchoolInfo(SchoolOrder schoolOrder) {
        return schoolOrderDao.updateSchoolInfo(schoolOrder);
    }

    @Override
    public String selectnickname(String user_id) {
        return schoolOrderDao.selectnickname(user_id);
    }


}
