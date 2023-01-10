package com.example.demo.util;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TableSubmeterUtils {

    /**
     * 根据查询时间查询动态年份表/试图
     *
     * @param tableName 查询表
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     * @throws MyException
     */
    public static String getSearchTable(String tableName, String startDate, String endDate) throws MyException {
        if (isSameYear(startDate, endDate)) {
            throw new MyException(ResultCodeJoin.INSIDE_ERROR, "系统不支持作业跨年查询！");
        }
        if (StringUtils.isEmpty(tableName)) {
            throw new MyException(ResultCodeJoin.INSIDE_ERROR, "系统错误，请联系管理员！");
        }
        String strYear = "_" + DateUtils.getDateYear(startDate);
        if (!StringUtils.contains(tableName, strYear)) {
            return tableName + strYear;
        }
        return tableName;
    }

    /**
     * 根据单个日期查询动态生成表/试图
     *
     * @param tableName 表名
     * @param workDate  日期
     * @return
     * @throws MyException
     */
    public static String getWorkDateTable(String tableName, String workDate) throws MyException {
        if (StringUtils.isEmpty(tableName)) {
            throw new MyException(ResultCodeJoin.INSIDE_ERROR, "系统错误，请联系管理员！");
        }
        String strYear = "_" + DateUtils.getDateYear(workDate);
        if (!StringUtils.contains(tableName, strYear)) {
            return tableName + strYear;
        }
        return tableName;
    }

    /**
     * 根据String日期获取当前年份
     *
     * @param getDate
     * @return
     */
    public static int getDateYear(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFromString(date));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 判断开始时间和结束时间是否跨年
     *
     * @param startDate
     * @param endDate
     * @return false 没有跨年，true跨年
     */
    public static boolean isSameYear(String startDate, String endDate) throws MyException {
        if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
            throw new IllegalArgumentException("开始时间结束时间不能为空!");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dateFromString(startDate));
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dateFromString(endDate));

        if (cal1.get(Calendar.YEAR) < 2016) {
            throw new MyException(ResultCodeJoin.INSIDE_ERROR, "系統不支持查询2016之前数据，如有需求请联系管理员！");
        }
        if (cal1.getTimeInMillis() > Calendar.getInstance().getTimeInMillis()) {
            throw new MyException(ResultCodeJoin.INSIDE_ERROR, "开始时间大于当前时间！");
        }
        if (cal2.getTimeInMillis() > Calendar.getInstance().getTimeInMillis()) {
            throw new MyException(ResultCodeJoin.INSIDE_ERROR, "结束时间大于当前时间！");
        }
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) ? false : true;
    }

    /**
     * String类型日期转换城Date日期
     *
     * @param date
     * @return
     */
    public static Date dateFromString(String date) {
        SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormatDateTime.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
