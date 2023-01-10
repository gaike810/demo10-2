package com.example.demo.modle;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2020/12/04/06:31
 * @Description:
 */
@Data
public class SchoolOrder {

    private String order_number;
    private String order_type;
    private String order_status;
    private String pay_status;
    private String order_amount;
    private String user_id_announcer;
    private String user_id_recipient;
    private String order_receiving;
    private String gatewaytype;
    private String sys_time;
    private String is_del_announcer;
    private String is_del_recipient;
    private String school_name;
    private String subject_take_a;
    private String give_away_b;
    private String size_content_c;
    private String backup;

    private String take_name;
    private String take_phone;
    private String receive_name;
    private String receive_phone;
    private String get_phone;

    private String deviceId;
    private String regionCode;
    private String startDate;
    private String endDate;
    private String deptId;
    private String tableName;
    private String factroyId;
    private String array;
    private String machineId;
    private String carId;


    private int current_page;
    private int page_index;
    private int page_size;
}
