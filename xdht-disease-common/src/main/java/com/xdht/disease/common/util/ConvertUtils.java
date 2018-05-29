package com.xdht.disease.common.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lzf on 2017/11/7.
 */
public class ConvertUtils {

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

    public static String DateToStr(Date date, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StrToDate(String str, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
   * 将时间戳转换为时间
   */
    public static Date StampToDate(String s) {
        long lt = new Long(s);
        Date date = new Date(lt);
        return date;
    }

    public static long StrToStamp(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Long stamp = 0L;
        try {
            Date date = format.parse(s);
            stamp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stamp;
    }

    public static long StrToStamp(String s, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Long stamp = 0L;
        try {
            Date date = format.parse(s);
            stamp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stamp;
    }

    public static String StampToStr(long stamp) {
        Date date = new Date(stamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

    public static String StampToStr(long stamp, String dateFormat) {
        Date date = new Date(stamp);
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String str = format.format(date);
        return str;
    }

    public static Double FormatDouble(double number) {
        BigDecimal b = new BigDecimal(number);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double FormatDouble(double number, int decimalLength) {
        BigDecimal b = new BigDecimal(number);
        return b.setScale(decimalLength, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Date FormatDate(String s, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);

        try {
            Date date = format.parse(s);

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
