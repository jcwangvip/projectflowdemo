package com.jc.javabase.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author jcwang
 */
@Slf4j
public class DateUtils {

    public static final String DATE_FORMATE_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMATE_YYYY_MM_DD_1 = "yyyy.MM.dd";
    public static final String DATE_FORMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_FORMATE_Y_M = "y-M-d";

    public static final String DATE_FORMATE_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";



    public static final int MM_TYPE = 1;
    public static final int HH_TYPE = 2;
    public static final int DD_TYPE = 3;


    /**
     * 转换当前时间
     *
     * @param stringDate
     * @param format
     * @return
     */
    public static Date formatDate(String stringDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(stringDate);
            return date;
        } catch (ParseException e) {
            log.error("格式话时间异常{}", e);
        }
        return null;
    }

    /**
     * 格式化时间
     *
     * @param date   给定的时间
     * @param format 格式话样式
     * @return
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取两个日期相减等到不同类型的结果
     *
     * @param start
     * @param end
     * @param type  1、天/2、小时/3、分钟
     * @return
     */
    public static int dateSubtract(Date start, Date end, int type) {
        long startT = start.getTime();
        long endT = end.getTime();
        //共计秒数
        long ss = (endT - startT) / (1000);
        //共计分钟数
        int mm = (int) ss / 60;
        //共计小时数
        int hh = (int) ss / 3600;
        //共计天数
        int dd = (int) hh / 24;
        log.info("共" + dd + "天 准确时间是：" + hh + " 小时 " + mm + " 分钟" + ss + " 秒 共计：" + ss * 1000 + " 毫秒");
        switch (type) {
            case MM_TYPE:
                return dd;
            case HH_TYPE:
                return hh;
            case DD_TYPE:
                return mm;
            default:
                // 这里抛出异常是不是更好
                return 0;
        }
    }


    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static Date getDate() {
        Date newDate = new Date();
        return newDate;
    }

    public static Date getDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATE_YYYY_MM_DD_HH_MM_SS);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            log.info("获取指定时间异常{}", e);
        }
        return null;
    }

    public static String getDate(Date date) {
        return getDate(date, DATE_FORMATE_YYYY_MM_DD_HH_MM_SS);
    }


    /**
     * 格式化给定时间、格式
     *
     * @param date 入参时间
     * @return formatDate
     */
    public static String getDate(Date date, String format) {
        String stringDate = "";
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            stringDate = sdf.format(date);
        }
        return stringDate;
    }

    public static String getLastDate(String date) {
        String dates = date.substring(0, 10);
        dates = dates + " 23:59:59";
        return dates;
    }

    public static String getStartDate(String date) {
        String dates = date.substring(0, 10);
        dates = dates + " 00:00:00";
        return dates;
    }

    /**
     * 计算两个时间相差的天数
     *
     * @param endDate
     * @param startDate
     * @return
     */
    public static Long difference(Date endDate, Date startDate) {
        if (null == endDate || null == startDate) {
            return null;
        }
        Long days = (endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24);
        return days;
    }


}
