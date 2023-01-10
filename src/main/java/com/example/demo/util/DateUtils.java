package com.example.demo.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date convertDateFromString(String date) {
        SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormatDateTime.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取昨天的日期
     *
     * @return
     */
    public static String yesterDayToString() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    public static Date convertTimeFromString(String date) {
        SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormatDateTime.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean compareToDateTime(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static Date convertDateFromString(String date, String format) {
        SimpleDateFormat dateFormatDateTime = new SimpleDateFormat(format);
        try {
            return dateFormatDateTime.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String dateFormat(Date date) {
        return date == null ? " " : new SimpleDateFormat("yyyy-MM-dd").format(date);
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

    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern) {
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 在日期上加减天数
     */
    public static Date addDay(Date date, int n) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        return date;
    }

    /**
     * 在日期上加减月数
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    public static String getLastDayOfMonth(String year, String month) {
        Calendar cal = Calendar.getInstance();
        // 年
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        // 月，因为Calendar里的月是从0开始，所以要-1
        // cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        // 日，设为一号
        cal.set(Calendar.DATE, 1);
        // 月份加一，得到下个月的一号
        cal.add(Calendar.MONTH, 1);
        // 下一个月减一为本月最后一天
        cal.add(Calendar.DATE, -1);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));// 获得月末是几号
    }

    public static String currentStringTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(calendar.getTime());
    }

    public static String currentStringDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }

    public static Date currentDateTime() {
        return Calendar.getInstance().getTime();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
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

//    /**
//     * 字符串时间比较大小
//     *
//     * @param time
//     * @return
//     */
//    public static Boolean compareToTime(String time1, String time2) {
//        if (StringUtils.isEmpty(time1) || StringUtils.isEmpty(time1)) {
//            System.out.println(time1 + "--------------时间为空--------------" + time2);
//            return true;
//        }
//        DateFormat df = new SimpleDateFormat("HH:mm:ss");
//        try {
//            Date dt1 = df.parse(time1);
//            Date dt2 = df.parse(time2);
//            if (dt1.getTime() > dt2.getTime()) {
//                return true;
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return false;
//    }
}
