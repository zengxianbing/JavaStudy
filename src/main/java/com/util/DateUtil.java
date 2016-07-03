package com.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class DateUtil {
    private final static Logger log = LogManager.getLogger(DateUtil.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public static final String DEFAULT_DATE_FORMATE = "yyyymmddhh24mmss";

    public static final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_2 = "yyyy/MM/dd HH:mm:ss";

    /**
     * 取得某日期时间的特定表示格式的字符串
     *
     * @param format 时间格式
     * @param date   某日期（Date）
     * @return 某日期的字符串
     */
    public static synchronized String getDate2Str(String format, Date date) {
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 将特定格式的时间字符串转化为Date类型
     *
     * @param format 时间格式
     * @param str    某日期的字符串
     * @return 某日期（Date）
     */
    public static synchronized Date getStrToDate(String format, String str) {
        simpleDateFormat.applyPattern(format);
        ParsePosition parseposition = new ParsePosition(0);
        return simpleDateFormat.parse(str, parseposition);
    }

    public static String date2String(Date date) {
        return getDate2Str(DATE_FORMAT_1, date);
    }

    public static String date2String2(Date date) {
        return getDate2Str(DATE_FORMAT_2, date);
    }

    public static String date2String(Date date, String format) {
        return getDate2Str(format, date);
    }

    /**
     * 检测字符串是否为日期
     *
     * @param dateTime 时间字符串
     * @param pattern  Eg "yyyy-MM-dd"
     * @return 返回结果
     */
    public static boolean isDateTime(String dateTime, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        Date dt = df.parse(dateTime, pos);
        return !(dt == null);
    }
    public static XMLGregorianCalendar getXMLGregorianCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            DatatypeFactory dtf = DatatypeFactory.newInstance();
            xmlCalendar = dtf.newXMLGregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND), calendar.get(Calendar.MILLISECOND), calendar.get(Calendar.ZONE_OFFSET) / (1000 * 60));
        }
        catch (Exception e) {
            log.error("getXMLGregorianCalendar error!", e);
        }
        return xmlCalendar;
    }
    public boolean passTime(Date tempDate, int hour) {
        return !(tempDate == null || hour <= 0) && tempDate.before(getLimitDate(hour));
    }
    /**
     * 得到n小时前时间
     *
     * @param hour 小时数
     * @return Date
     */
    private Date getLimitDate(int hour) {
        Calendar cl = Calendar.getInstance();
        Long clTemp = cl.getTimeInMillis() - hour * 60 * 60 * 1000;
        cl.setTimeInMillis(clTemp);
        return cl.getTime();
    }
    public static long compareDate(Date d1,Date d2){
        return d1.getTime()-d2.getTime();
    }

    public static void main(String[] args) {
        System.out.println(compareDate(getStrToDate(DATE_FORMAT_1,"2011-11-12 16:00:00") ,new Date() ));
    }
}
