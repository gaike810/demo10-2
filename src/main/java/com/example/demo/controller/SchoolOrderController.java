package com.example.demo.controller;

import com.example.demo.modle.SchoolOrder;
import com.example.demo.service.SchoolOrderService;
import com.example.demo.util.KamUtil;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/04/07:13
 * @Description:
 */
@RestController
@RequestMapping(value = "/school")
public class SchoolOrderController {
    private static Logger logger = Logger.getLogger(testController.class);

    @Resource
    private SchoolOrderService sOrderService;

    /**
     * 查询发布列表
     */
    @RequestMapping(value = "/selectinfolist.do", produces = "text/html;charset=UTF-8")
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
            //不是查看发布者的和接收者的列表传
            if (schoolOrder.getUser_id_announcer() != null) {
//                schoolOrder.setOrder_status("0");
                List<Map<String, Object>> list = sOrderService.selectSchoolOrderList(schoolOrder);
                if (list.size() == 0) {
                    return KamUtil.returnNoResult();
                }
                return KamUtil.returnSuccess(list);
            }
            if (schoolOrder.getUser_id_recipient() != null) {
                schoolOrder.setOrder_status("1");
                List<Map<String, Object>> list = sOrderService.selectSchoolOrderList(schoolOrder);
                if (list.size() == 0) {
                    return KamUtil.returnNoResult();
                }
                return KamUtil.returnSuccess(list);
            }
            schoolOrder.setOrder_status("0");
            List<Map<String, Object>> list = sOrderService.selectSchoolOrderList(schoolOrder);
            if (list.size() == 0) {
                return KamUtil.returnNoResult();
            }
            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

    /**
     * 发布信息
     */
    @RequestMapping(value = "/addschoolinfolist.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addSchoolInfo(SchoolOrder schoolOrder) {
        try {
            String nickname = sOrderService.selectnickname(schoolOrder.getUser_id_announcer());
            schoolOrder.setTake_name(nickname);
            int flag = sOrderService.addSchoolInfo(schoolOrder);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }

    }

    /**
     * 领取信息
     */
    @RequestMapping(value = "/updateschoolinfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateSchoolInfo(SchoolOrder schoolOrder) {
        try {
            if (StringUtils.isEmpty(schoolOrder.getOrder_number())) {
                return KamUtil.returnParamError("订单号不能为空～");
            }
            if (StringUtils.isEmpty(schoolOrder.getUser_id_recipient())) {
                return KamUtil.returnParamError("领取者的用户id不能为空～");
            }
            //根据订单号查询是否被领取
            Map<String, Object> map = sOrderService.selectOrderinfoByNumber(schoolOrder.getOrder_number());
            String status = String.valueOf(map.get("order_status"));
            if (status.equals("1")) {
                return KamUtil.returnParamError("该订单已失效！");
            }
            int flag = sOrderService.updateSchoolInfo(schoolOrder);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }

    }

    /**
     * 查询订单详情
     */
    @RequestMapping(value = "/selectorderinfobynumber.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectOrderinfoByNumber(SchoolOrder schoolOrder) {

        try {

            if (StringUtils.isEmpty(schoolOrder.getOrder_number())) {
                return KamUtil.returnParamError("订单号不能为空～");
            }
            Map<String, Object> map = sOrderService.selectOrderinfoByNumber(schoolOrder.getOrder_number());
            if (StringUtils.isEmpty(map)) {
                return KamUtil.returnParamError(" 未查到订单该订单详情～");
            }
            return KamUtil.returnSuccess(map);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }

    }


}
