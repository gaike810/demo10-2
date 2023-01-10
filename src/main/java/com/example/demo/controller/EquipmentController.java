package com.example.demo.controller;

import com.example.demo.modle.SchoolOrder;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.SchoolOrderService;
import com.example.demo.util.KamUtil;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2022/03/01/13:13
 * @Description:
 */
@RestController
@RequestMapping(value = "/equipment")
public class EquipmentController {
    private static Logger logger = Logger.getLogger(testController.class);

    @Resource
    private EquipmentService equipmentService;

    /**
     * 设备查询
     */
    @RequestMapping(value = "/findCarByList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectSchoolOrderList(SchoolOrder schoolOrder, String pager) {

        try {
            //页码不能为空
            if (StringUtils.isEmpty(pager)) {
                return KamUtil.returnParamError("pager不能为空");
            }
            int a = Integer.parseInt(pager);
            schoolOrder.setCurrent_page(a);
            schoolOrder.setPage_size(10);
            schoolOrder.setPage_index((schoolOrder.getCurrent_page() - 1) * 10);
            int num_car = equipmentService.countcarnum(schoolOrder);
            List<Map<String, Object>> list = equipmentService.findCarInfoByLists(schoolOrder);
            return KamUtil.returnSuccess_hds(list, num_car);
//            return KamUtil.returnSuccess_hd(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }


    /**
     * 作业查询
     */
    @RequestMapping(value = "/findJobInfoByList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findJobInfoByLists(SchoolOrder schoolOrder, String pager) {

        try {
            //页码不能为空
            if (StringUtils.isEmpty(pager)) {
                return KamUtil.returnParamError("pager不能为空");
            }
            int a = Integer.parseInt(pager);
            schoolOrder.setCurrent_page(a);
            schoolOrder.setPage_size(10);
            schoolOrder.setPage_index((schoolOrder.getCurrent_page() - 1) * 10);

            //设备号不能为空
            if (StringUtils.isEmpty(schoolOrder.getDeviceId())) {
                return KamUtil.returnParamError("deviceId不能为空");
            }
            if (StringUtils.isEmpty(schoolOrder.getStartDate())) {
                return KamUtil.returnParamError("开始时间不能为空");
            }
            if (StringUtils.isEmpty(schoolOrder.getEndDate())) {
                return KamUtil.returnParamError("结束时间不能为空");
            }
            int num_job = equipmentService.countjobnum(schoolOrder);
            List<Map<String, Object>> list = equipmentService.findJobInfoByList(schoolOrder);
            return KamUtil.returnSuccess_hds(list, num_job);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

    /**
     * 位置查询
     */
    @RequestMapping(value = "/findLocationByLists", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findLocationByLists(SchoolOrder schoolOrder, String pager) {

        try {
            //页码不能为空
            if (StringUtils.isEmpty(pager)) {
                return KamUtil.returnParamError("pager不能为空");
            }
            int a = Integer.parseInt(pager);
            schoolOrder.setCurrent_page(a);
            schoolOrder.setPage_size(10);
            schoolOrder.setPage_index((schoolOrder.getCurrent_page() - 1) * 10);

            //设备号不能为空
            if (StringUtils.isEmpty(schoolOrder.getDeviceId())) {
                return KamUtil.returnParamError("deviceId不能为空");
            }

            List<Map<String, Object>> list = equipmentService.findLocationByLists(schoolOrder);
            return KamUtil.returnSuccess_hd(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }


    /**
     * 机具信息查询
     */
    @RequestMapping(value = "/findMachineToolByList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findMachineToolByList(SchoolOrder schoolOrder, String pager) {

        try {
            //页码不能为空
//            if (StringUtils.isEmpty(pager)) {
//                return KamUtil.returnParamError("pager不能为空");
//            }
//            int a = Integer.parseInt(pager);
//            schoolOrder.setCurrent_page(a);
//            schoolOrder.setPage_size(10);
//            schoolOrder.setPage_index((schoolOrder.getCurrent_page() - 1) * 10);

            //设备号不能为空
            if (StringUtils.isEmpty(schoolOrder.getDeviceId())) {
                return KamUtil.returnParamError("deviceId不能为空");
            }

            List<Map<String, Object>> list = equipmentService.findMachineToolByList(schoolOrder);
            return KamUtil.returnSuccess_hd(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }


    /**
     * 单位信息查询
     */
    @RequestMapping(value = "/findDeptByLists", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findDeptByLists(SchoolOrder schoolOrder, String pager) {

        try {
            //页码不能为空
            if (StringUtils.isEmpty(pager)) {
                return KamUtil.returnParamError("pager不能为空");
            }
            int a = Integer.parseInt(pager);
            schoolOrder.setCurrent_page(a);
            schoolOrder.setPage_size(10);
            schoolOrder.setPage_index((schoolOrder.getCurrent_page() - 1) * 10);

            //设备号不能为空
//            if (StringUtils.isEmpty(schoolOrder.getDeviceId())) {
//                return KamUtil.returnParamError("deviceId不能为空");
//            }
            int dept_num = equipmentService.countDeptnum(schoolOrder);
            List<Map<String, Object>> list = equipmentService.findDeptByLists(schoolOrder);
            return KamUtil.returnSuccess_hds(list, dept_num);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }


    /**
     * 根据设备号查询到期时间
     */
    @RequestMapping(value = "/lelectEndDate", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String lelectEndDate(String deviceId) {

        try {

            String enddate = equipmentService.lelectEndDate(deviceId);
            return KamUtil.returnSuccess_hd(enddate);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }


}
