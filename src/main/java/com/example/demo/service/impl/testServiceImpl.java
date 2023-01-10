package com.example.demo.service.impl;

import com.example.demo.dao.testDao;
import com.example.demo.service.testService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/10/22/05:48
 * @Description:
 */
@Service
public class testServiceImpl implements testService {

    @Resource
    private testDao testdao;

    @Override
    public Map<String, Object> selectTestMap(String as) {
        return testdao.selectTestMap(as);
    }

    @Override
    public ArrayList<Map<String, Object>> selectTestList() {
        return testdao.selectTestList();
    }
}
