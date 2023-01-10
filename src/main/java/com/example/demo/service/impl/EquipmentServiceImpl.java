package com.example.demo.service.impl;

import com.example.demo.dao.EquipmentMapper;
import com.example.demo.dao.SchoolOrderDao;
import com.example.demo.modle.SchoolOrder;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.SchoolOrderService;
import com.example.demo.util.DateUtils;
import com.example.demo.util.KamUtil;
import com.example.demo.util.TableSubmeterUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

import static jdk.nashorn.internal.objects.Global.undefined;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2022/03/01/13:13
 * @Description:
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    private static final String TABLE_NAME = "v_workplotitem";

    @Resource
    private EquipmentMapper equipmentMapper;


    @Override
    public int countcarnum(SchoolOrder schoolOrder) {
        return equipmentMapper.countcarnum(schoolOrder);
    }

    @Override
    public String lelectEndDate(String deviceId) {
        return equipmentMapper.lelectEndDate(deviceId);
    }

    @Override
    public int countjobnum(SchoolOrder schoolOrder) {

        String tableName = TableSubmeterUtils.getSearchTable(TABLE_NAME, schoolOrder.getStartDate(), schoolOrder.getEndDate());
        schoolOrder.setTableName(tableName);
        return equipmentMapper.countjobnum(schoolOrder);
    }

    @Override
    public ArrayList<Map<String, Object>> findCarInfoByLists(SchoolOrder schoolOrder) {
        ArrayList<Map<String, Object>> arrlist = equipmentMapper.findCarInfoByLists(schoolOrder);
//        for (Map<String, Object> map : arrlist) {
//            map.get("d1");
//        }
//        Collections.sort(arrlist, new Comparator<Map<String, Object>>() {
//            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//                Integer name1 = Integer.valueOf(o1.get("d1").toString()) ;
//                Integer name2 = Integer.valueOf(o2.get("d1").toString()) ;
//                return name2.compareTo(name1);
//            }
//        });
//        for (Map<String, Object> map : arrlist) {
//            map.get("d1");
//        }
//        return arrlist;
        return equipmentMapper.findCarInfoByLists(schoolOrder);
    }

    // 实现Comparator接口
    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            /*
             * 如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值， 这样颠倒一下，就可以实现降序排序了,反之即可自定义升序排序了
             */
            return o2 - o1;
        }
    }

    @Override
    public ArrayList<Map<String, Object>> findJobInfoByList(SchoolOrder schoolOrder) {

        String tableName = TableSubmeterUtils.getSearchTable(TABLE_NAME, schoolOrder.getStartDate(), schoolOrder.getEndDate());
        schoolOrder.setTableName(tableName);
        return equipmentMapper.findJobInfoByLists1(schoolOrder);
    }

    @Override
    public ArrayList<Map<String, Object>> findLocationByLists(SchoolOrder schoolOrder) {
        return equipmentMapper.findLocationByLists(schoolOrder);
    }

    @Override
    public ArrayList<Map<String, Object>> findMachineToolByList(SchoolOrder schoolOrder) {
        return equipmentMapper.findMachineToolByList(schoolOrder);
    }

    @Override
    public ArrayList<Map<String, Object>> findDeptByLists(SchoolOrder schoolOrder) {
        return equipmentMapper.findDeptByLists(schoolOrder);
    }

    @Override
    public int countDeptnum(SchoolOrder schoolOrder) {
        return equipmentMapper.countDeptnum(schoolOrder);
    }


}
