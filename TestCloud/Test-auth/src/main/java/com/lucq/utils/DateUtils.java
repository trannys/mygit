package com.lucq.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期时间工具类
 */
public class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 格式:yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 格式:yyyy/MM/dd
     */
    public static final String FORMAT_DATE_BACK_SLANT = "yyyy/MM/dd";

    /**
     * 格式:HH:mm:ss
     */
    public static final String FORMAT_TIME = "HH:mm:ss";

    /**
     * 格式:yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式:yyyy-MM-dd HH:mm
     */
    public static final String FORMAT_DATETIME_SS = "yyyy-MM-dd HH:mm";

    /**
     * 格式:yy-MM-dd HH:mm:ss
     */
    public static final String SIMPLE_FORMAT_DATETIME = "yy-MM-dd HH:mm:ss";

    /**
     * 格式:yyyyMMddHHmmss
     */
    public static final String FORMAT_DATETIME2 = "yyyyMMddHHmmss";

    /**
     * 格式:yyyyMMddHHmmssSSS
     */
    public static final String FORMAT_DATETIME3 = "yyyyMMddHHmmssSSS";

    /**
     * 格式:yyyy年MM月dd日
     */
    public static final String CHINESE_DATE_FORMAT = "(yyyy年MM月dd日)";

    /**
     * 格式:yyyy年MM月dd日
     */
    public static final String CHINESE_DATE_FORMAT_A = "yyyy年MM月dd日";

    /**
     * 格式:HH:mm
     */
    public static final String FORMAT_TIME_SHORT = "HH:mm";

    public static final long day_seconds = 24 * 60 * 60;

    public static final long hour_seconds = 60 * 60;

    public static final long minute_seconds = 60;


    /**
     * 根据秒数转换为天/时/分钟/秒的格式
     *
     * @param seconds
     * @return
     */
    public static String getDhmFormatBySeconds(long seconds) {
        StringBuilder stringBuilder = new StringBuilder();
        if (seconds / day_seconds > 0) {
            stringBuilder.append(seconds / day_seconds + "天");
            seconds %= day_seconds;
        }
        if (seconds / hour_seconds > 0) {
            stringBuilder.append(seconds / hour_seconds + "小时");
            seconds %= hour_seconds;
        }
        if (seconds / minute_seconds > 0) {
            stringBuilder.append(seconds / minute_seconds + "分钟");
            seconds %= minute_seconds;
        }
        stringBuilder.append(seconds + "秒");
        return stringBuilder.toString();
    }

    /**
     * 计算当天的剩余时间（秒数）
     *
     * @return
     */
    public static int getTodayTime() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(calendar.SECOND, 0);
        return (int) ((calendar.getTimeInMillis() - now.getTime()) / 1000);
    }

    /**
     * 取得当前月份和偏离月份
     *
     * @return eg:2015/4~2015/6
     * @throws ParseException
     */
    public static String getFutureMonth(int diverge) {
        return getYearAfter(Calendar.MONTH, diverge) + "-" + getMonthAfter(Calendar.MONTH, diverge);
    }

    /**
     * 取得当前日期（只有日期，没有时间，或者可以说是时间为0点0分0秒）
     *
     * @return
     * @throws ParseException
     */
    public static Date getCurrentDate() throws ParseException {
        return getCurrentDate(DEFAULT_DATE_FORMAT);
    }

    /**
     * 取得当前日期（只有日期，没有时间，或者可以说是时间为0点0分0秒）
     *
     * @return
     * @throws ParseException
     */
    public static Date getCurrentDate(String pattern) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        return f.parse(f.format(new Date()));
    }

    /**
     * 取得当前时间（包括日期和时间）
     *
     * @return 当前时间
     */
    public static Long getCurrentDateTime() {
        return new Date().getTime();
    }

    /**
     * 获取指定格式的当前系统日期时间
     *
     * @param format 自定义日期格式器
     * @return 前系统日期时间
     */
    public static String getCurrentDateTime(String format) {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    /**
     * 用默认的日期格式，格式化一个Date对象
     *
     * @param date 待被格式化日期
     * @return “yyyy-MM-dd”格式的日期字符串
     */
    public static String formatDate(Date date) {
        return null == date ? null : new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    /**
     * 根据传入的格式，将日期对象格式化为日期字符串
     *
     * @param date   待被格式化日期
     * @param format 自定义日期格式器
     * @return 格式后的日期字符串
     */
    public static String formatDate(Date date, String format) {
        if (null == date)
            return null;

        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 用默认的日期时间格式，格式化一个Date对象
     *
     * @param date 待被格式化日期
     * @return “yyyy-MM-dd HH:mm:ss”格式的日期时间字符串
     */
    public static String formatTime(Date date) {
        return null == date ? null : new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    /**
     * 根据传入的格式，将日期对象格式化为时间字符串
     *
     * @param date   待被格式化日期
     * @param format 自定义日期格式器
     * @return 格式后的日期时间字符串
     */
    public static String formatTime(Date date, String format) {
        if (null == date)
            return null;

        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取指定天数后的日期
     *
     * @param baseDate 基准日期
     * @param day      后推天数
     * @return 后推后的天数
     */
    public static Date getDateAfter(Date baseDate, int day) {
        if (day == 0) {
            return baseDate;
        }
        Calendar now = Calendar.getInstance();
        now.setTime(baseDate);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    public static Date getMinuteAfter(Date baseDate, int minute) {
        Calendar now = Calendar.getInstance();
        now.setTime(baseDate);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);
        return now.getTime();
    }

    public static Date getMonthAfter(Date baseDate, int month) {
        Calendar now = Calendar.getInstance();
        now.setTime(baseDate);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);
        return now.getTime();
    }

    public static Date getHourAfter(Date baseDate, int hour) {
        Calendar now = Calendar.getInstance();
        now.setTime(baseDate);
        now.set(Calendar.HOUR, now.get(Calendar.HOUR) + hour);
        return now.getTime();
    }


    /**
     * 利用默认的格式（yyyy-MM-dd）将一个表示日期的字符串解析为日期对象
     *
     * @param dateStr 待格式化日期字符串
     * @return 格式化后日期对象
     * @throws RuntimeException
     */
    public static Date parseDate(String dateStr) throws ParseException {
        return parseDateOrNull(dateStr, DEFAULT_DATE_FORMAT);
    }

    public static Date parseDateOrNull(String dateStr, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateStr);
    }

    /**
     * 利用默认的格式（yyyy-MM-dd HH:mm:ss）将一个表示时间的字符串解析为日期对象
     *
     * @param timeStr 时间字符串
     * @return 格式化后的日期对象
     * @throws ParseException
     */
    public static Date parseTime(String timeStr) throws ParseException {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(timeStr);
    }

    /**
     * 将一个字符串，按照特定格式，解析为日期对象
     *
     * @param datetimeStr 日期、时间、日期时间字符串
     * @param format      自定义日期格式器
     * @return 格式化后的日期对象
     * @throws ParseException
     */
    public static Date parseDateTime(String datetimeStr, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(datetimeStr);
    }

    /**
     * 得到当前年份
     *
     * @return 当前年份
     */
    public static int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 得到年份
     *
     * @return
     */
    public static int getYearAfter(int field, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(field, amount);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 得到当前月份（1至12）
     *
     * @return 当前月份（1至12）
     */
    public static int getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到年份
     *
     * @return
     */
    public static int getMonthAfter(int field, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(field, amount);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取yyyy-MM-dd格式的当前系统日期
     *
     * @return 当前系统日期
     */
    public static String getCurrentDateAsString() {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(new Date());
    }

    public static String getCurrentDateAsStringByBackSlant() {
        return new SimpleDateFormat(FORMAT_DATE_BACK_SLANT).format(new Date());
    }

    /**
     * 获取指定格式的当前系统日期
     *
     * @param format 自定义日期格式器
     * @return 当前系统日期
     */
    public static String getCurrentDateAsString(String format) {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    /**
     * 获取HH:mm:ss格式的当前系统时间
     *
     * @return 当前系统时间
     */
    public static String getCurrentTimeAsString() {
        return new SimpleDateFormat(FORMAT_TIME).format(new Date());
    }

    /**
     * 获取指定格式的当前系统时间
     *
     * @param format 自定义日期格式器
     * @return 当前系统时间
     */
    public static String getCurrentTimeAsString(String format) {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    /**
     * 获取格式为yyyy-MM-dd HH:mm:ss的当前系统日期时间
     *
     * @return 当前系统日期时间
     */
    public static String getCurrentDateTimeAsString() {
        return getCurrentDateTime(FORMAT_DATETIME);
    }

    /**
     * 获取当前为星期几,从星期日~星期六对应的值是1~7
     *
     * @return 星期几
     */
    public static int getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取指定日期为星期几,从星期日~星期六对应的值是1~7
     *
     * @param date 指定日期
     * @return 星期几
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取星期几的中文名称
     * <p/>
     * 指定日期
     *
     * @return 星期几
     */
    public static String getChineseDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        return getChineseDayOfWeek(cal.getTime());
    }

    /**
     * 获取星期几的中文名称
     *
     * @param date 指定日期
     * @return 星期几
     */
    public static String getChineseDayOfWeek(String date) throws ParseException {
        return getChineseDayOfWeek(parseDate(date));
    }

    /**
     * 获取星期几的中文名称
     *
     * @param date 指定日期
     * @return 星期几
     */
    public static String getChineseDayOfWeek(Date date) {
        int dateOfWeek = getDayOfWeek(date);
        if (dateOfWeek == Calendar.MONDAY) {
            return "星期一";
        } else if (dateOfWeek == Calendar.TUESDAY) {
            return "星期二";
        } else if (dateOfWeek == Calendar.WEDNESDAY) {
            return "星期三";
        } else if (dateOfWeek == Calendar.THURSDAY) {
            return "星期四";
        } else if (dateOfWeek == Calendar.FRIDAY) {
            return "星期五";
        } else if (dateOfWeek == Calendar.SATURDAY) {
            return "星期六";
        } else if (dateOfWeek == Calendar.SUNDAY) {
            return "星期日";
        }
        return null;
    }

    /**
     * 获取当前日期为一年中的第几周
     *
     * @return
     * @throws ParseException
     */
    public static int getCurrentWeekNum() {
        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        return cl.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当天为几号
     *
     * @return 几号
     * @date: 2013年12月31日下午3:50:11
     */
    public static int getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期为几号
     *
     * @param date 指定的日期
     * @return 几号
     */
    public static int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期所在月份的最后一天是几号
     *
     * @param date 指定日期
     * @return 指定日期所在月份的最后一天是几号
     */
    public static int getMaxDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期所在月份的第一天
     *
     * @param date 指定日期
     * @return 指定日期所在月份的第一天
     * @throws ParseException
     */
    public static String getFirstDayOfMonth(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(cal.getTime());
    }


    /**
     * 获取指定日期所在月份的第一天
     *
     * @param date 指定日期
     * @return 指定日期所在月份的最后一天
     * @throws ParseException
     */
    public static String getLastDayOfMonth(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        int dayOfMonth = getMaxDayOfMonth(cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(cal.getTime());
    }

    /**
     * 获取当天为一年中第几天
     *
     * @return 一年中第几天
     */
    public static int getDayOfYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取指定日期为一年中第几天
     *
     * @param date 指定日期
     * @return 一年中第几天
     */
    public static int getDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取指定日期为星期几,从星期日~星期六对应的值是1~7
     *
     * @param date 指定日期
     * @return 星期几
     * @throws ParseException
     */
    public static int getDayOfWeek(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取指定日期为几号
     *
     * @param date 指定的日期
     * @return 几号
     * @throws ParseException
     */
    public static int getDayOfMonth(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期为一年中第几天
     *
     * @param date 指定日期
     * @return 一年中第几天
     * @throws ParseException
     */
    public static int getDayOfYear(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 时间戳转换:把距离GMT时间的毫秒数转为日期，中国处在东八区，所以是：GMT时间+8小时
     *
     * @param time 距离GTM时刻的毫秒数
     * @return 获取到的北京时区日期时间字符串
     */
    public static String longTimeToDateTimeString(Long time) {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATETIME);
        String d = format.format(time);
        return d;
    }

    /**
     * 时间戳转换:把距离GMT时间的毫秒数转为日期，中国处在东八区，所以是：GMT时间+8小时
     *
     * @param time 距离GTM时刻的毫秒数
     * @return 获取到的北京时区日期时间对象
     */
    public static Date longTimeToDateTime(Long time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATETIME);
        String d = format.format(time);
        return parseTime(d);
    }

    /**
     * 将日期转化为指定格式的字符串形式
     *
     * @param @param  date
     * @param @param  pattern
     * @param @return
     */
    public static String dateToString(Date date, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


    /**
     * 是否是日期
     *
     * @param date
     * @return
     */
    public static boolean isDate(String date) {

        if (date == null || date.equals(""))
            return false;
        date = date.replace("/", "-");
        if (date.indexOf("-") == -1)
            return false;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {

            newDate = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @SuppressWarnings("static-access")
    public static String[] dateMaker(String date) {
        String[] str = null;
        if (date == null) {
            return null;
        } else if (!"all".equals(date)) {
            str = new String[2];
            Calendar cal = Calendar.getInstance();
            str[1] = cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1) + "-"
                    + cal.get(cal.DATE) + " 23:59:59";
            if ("today".equals(date)) {
                str[0] = cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1)
                        + "-" + cal.get(cal.DATE) + " 00:00:01";
            } else if ("yesterday".equals(date)) {
                str[0] = cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1)
                        + "-" + (cal.get(cal.DATE) - 1) + " 00:00:01";
            } else if ("week".equals(date)) {
                str[0] = cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1)
                        + "-" + (cal.get(cal.DATE) - 1) + " 00:00:01";
            } else if ("month".equals(date)) {
            } else if ("year".equals(date)) {
            }
        }
        return str;
    }

    /**
     * 获取日期和时间 yyyy-MM-dd HH:mm:ss
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取自定义日期和时间格式
     *
     * @return pattern
     */
    public static String getCustomTime(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取日期和时间 yyyy-MM-dd HH:mm:ss.SSS
     *
     * @return yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String getNowTimeWithMilliSec() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    /**
     * 获取日期和时间 yyyy-MM-dd HH:mm:ss...
     *
     * @return yyyy-MM-dd HH:mm:ss...
     */
    public static String getNowTimeWithNanoSec() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + "." + System.nanoTime();
    }

    /**
     * 获取日期和时间，没有秒 yyyy-MM-dd HH:mm
     *
     * @return yyyy-MM-dd HH:mm
     */
    public static String getNowTimeNoSec() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date());
    }

    /**
     * 获取日期和时间
     *
     * @return 日期和时间
     */
    public static String getCustomerDay(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间 HH:mm:ss
     *
     * @return HH:mm:ss
     */
    public static String getSimpleTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期 yyyy-MM-dd
     *
     * @return yyyy-MM-dd
     */
    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String getTodayAdd(int year, int month, int day) {
        String tmpstr = "";
        GregorianCalendar calendar = new GregorianCalendar();
        int yearnow = calendar.get(Calendar.YEAR) + year;
        int monthnow = calendar.get(Calendar.MONTH) + month;
        int daynow = calendar.get(Calendar.DAY_OF_MONTH) + day;
        tmpstr += yearnow + "-";
        if (monthnow < 10) {
            tmpstr += "0" + monthnow + "-";
        } else {
            tmpstr += monthnow + "-";
        }
        if (daynow < 10) {
            tmpstr += "0" + daynow;
        } else {
            tmpstr += daynow;
        }
        return tmpstr;
    }

    public static String changeEncode(String source)
            throws UnsupportedEncodingException {
        if (source != null) {
            return new String(source.getBytes("ISO-8859-1"), "GBK");
        } else {
            return null;
        }
    }

    public static String changeEncode(String source, String fromEncode,
                                      String toEncode) throws UnsupportedEncodingException {
        if (source != null) {
            return new String(source.getBytes(fromEncode), toEncode);
        } else {
            return source;
        }
    }

    public static String buildString(String source)
            throws UnsupportedEncodingException {
        if (source != null) {
            return new String(source.trim().getBytes("ISO-8859-1"), "UTF-8");
        } else {
            return source;
        }
    }

    /**
     * 验证时间前后
     *
     * @param time      标准时间
     * @param timeCheck 比较时间
     * @return true timeCheck在time之前，false timeCheck在time之后
     */
    public static boolean checkTime(String time, String timeCheck) {
        if (time.length() == 5) {
            time += ":00";
        }
        if (timeCheck.length() == 5) {
            timeCheck += ":00";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return dateFormat.parse(timeCheck).before(dateFormat.parse(time));
        } catch (ParseException e) {
            logger.error("时间比较出错：", e);
            return false;
        }
    }

    /**
     * 验证日期前后
     *
     * @param time      标准时间
     * @param timeCheck 比较时间
     * @return true timeCheck在time之前，false timeCheck在time之后
     */
    public static boolean checkDayBySF(String time, String timeCheck,
                                       SimpleDateFormat sf) {
        try {
            return sf.parse(timeCheck).before(sf.parse(time));
        } catch (ParseException e) {
            logger.error("时间比较出错：", e);
            return false;
        }
    }

    /**
     * 验证日期前后
     *
     * @param time      标准时间
     * @param timeCheck 比较时间
     * @return true timeCheck在time之前，false timeCheck在time之后
     */
    public static boolean checkDay(String time, String timeCheck) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(timeCheck).before(dateFormat.parse(time));
        } catch (ParseException e) {
            logger.error("时间比较出错：", e);
            return false;
        }
    }

    /**
     * 验证日期时间前后
     *
     * @param time      标准时间
     * @param timeCheck 比较时间
     * @return true timeCheck在time之前，false timeCheck在time之后
     */
    public static boolean checkDate(String time, String timeCheck) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
        try {
            return dateFormat.parse(timeCheck).before(dateFormat.parse(time));
        } catch (ParseException e) {
            logger.error("时间比较出错：" ,e);
            return false;
        }
    }

    /**
     * 验证日期时间前后
     *
     * @return true timeCheck在time之前，false timeCheck在time之后
     */
    public static String termChange(int term) {
        switch (term) {
            case 1:
                return "<";
            case 2:
                return ">";
            case 3:
                return "<=";
            case 4:
                return ">=";
            case 5:
                return "<>";
            case 6:
                return "=";
            default:
                return "=";
        }
    }

    /**
     * 取当月的首个日期
     */
    public static String getFirstDateOfMonth() {
        Calendar currentCal = Calendar.getInstance();
        currentCal.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        int currentday = currentCal.get(Calendar.DAY_OF_MONTH);
        int currentyear = currentCal.get(Calendar.YEAR);
        int currentmonth = currentCal.get(Calendar.MONTH) + 1;
        String currentDate = getYearAndMonthAndDay(currentyear, currentmonth,
                currentday);
        return currentDate;
    }

    /**
     * 取当月的末日期
     */
    public static String getEndDateOfMonth() {
        Calendar currentCal = Calendar.getInstance();
        currentCal.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        currentCal.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int MaxDate = currentCal.get(Calendar.DATE);
        int currentyear = currentCal.get(Calendar.YEAR);
        int currentmonth = currentCal.get(Calendar.MONTH) + 1;
        String currentDate = getYearAndMonthAndDay(currentyear, currentmonth,
                MaxDate);
        return currentDate;
    }

    private static String getYearAndMonthAndDay(int year, int month, int day) {
        String m = String.valueOf(month < 10 ? "0" + month : month);
        String d = String.valueOf(day < 10 ? "0" + day : day);
        String tmp = year + "-" + m + "-" + d;
        return tmp;
    }

    public static String getTodayZeroPoint() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd 00:00:00");
        return dateFormat.format(new Date());
    }

    @SuppressWarnings("deprecation")
    public static String getNextDayZeroPoint() {
        Date date = new Date();
        date.setDate(date.getDate() + 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd 00:00:00");
        return dateFormat.format(date);
    }

    /**
     * 根据传进来的年月（yyyy-MM）获取该月有多少天
     *
     * @param ym
     * @return
     */
    public static int getMaxDayByYearMonth(String ym) {
        int day = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = new GregorianCalendar();
            Date date = sdf.parse(ym);
            calendar.setTime(date);
            day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            day = 0;
        }
        return day;
    }

    /**
     * 获取指定年月从开始至结束的日期
     *
     * @param ym
     * @return
     */
    public static List<String> getDaysByYearMonth(String ym) {
        List<String> list = new ArrayList<String>();
        int maxDate = getMaxDayByYearMonth(ym);
        for (int i = 1; i <= maxDate; i++) {
            String d = String.valueOf(i < 10 ? "0" + i : i);
            list.add(ym + "-" + d);
        }
        return list;
    }

    /**
     * 获取当前日期至月底之间的日期
     *
     * @param iscurrentdate 是否包含当天
     * @return
     */
    public static List<String> getDayToMonthEnd(boolean iscurrentdate) {
        List<String> list = new ArrayList<String>();
        Calendar calendar = new GregorianCalendar();
        int cday = calendar.get(Calendar.DAY_OF_MONTH);
        int currentyear = calendar.get(Calendar.YEAR);
        int currentmonth = calendar.get(Calendar.MONTH) + 1;
        if (iscurrentdate) {
            list.add(getYearAndMonthAndDay(currentyear, currentmonth, cday));
        }
        int maxDate = getMaxDayByYearMonth(getCustomerDay("yyyy-MM"));
        for (int i = cday + 1; i <= maxDate; i++) {
            list.add(getYearAndMonthAndDay(currentyear, currentmonth, i));
        }
        Collections.sort(list);
        return list;
    }

    /**
     * 计算时间差
     *
     * @param a
     * @param b
     * @return
     */
    public static String getBetweenDayNumber(String a, String b) {
        double number = 0;
        double DAY = 24L * 60L * 60L * 1000L;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date ad = df.parse(a);
            Date bd = df.parse(b);
            number = (bd.getTime() - ad.getTime()) / DAY;
        } catch (ParseException e) {
            logger.error("时间格式化出错：" + e.getMessage());
        }

        DecimalFormat nf = new DecimalFormat("#.##");

        return nf.format(number);
    }

    /**
     * 格式化日期时间 yyyy-MM-dd HH:mm:ss.SSS
     *
     * @return yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String parseDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


    /**
     * 构建时间序号 yyyyMMddHHmmssSSS
     *
     * @return yyyyMMddHHmmssSSS
     */
    public static String getTimeOrderNo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        try {
            int random = SecureRandom.getInstance("SHA1PRNG", "SUN").nextInt();
            random = random > 0 ? random : -random;
            return StringFormat.format("{0}{1}", format.format(new Date()),
                    String.valueOf(random));
        } catch (Exception ex) {
            logger.error("The getTimeOrderNo is start {}", ex);
            return format.format(new Date());
        }
    }

    /**
     * 判断2个日期是否相等
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isSameDate(Date startDate, Date endDate) {

        return formatDate(startDate).equals(formatDate(endDate));

    }

    /**
     * 获取星期几 星期天则返回7
     * @param date 输入日期
     * @return
     *
     */
    public static int getWeekOfDate(Date date) {
        int wd;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        wd = cd.get(Calendar.DAY_OF_WEEK) - 1;

        if (0 == wd) {//如果是0 则为星期天，则直接返回7
            return 7;
        }
        return wd;
    }

    /**
     * 计算日期隔天数
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getNumDiffDay(Date startDate, Date endDate) throws ParseException {

        Date dateStart = parseDate(formatDate(startDate));
        Date dateEnd = parseDate(formatDate(endDate));
        return (int)(Math.abs(dateEnd.getTime() - dateStart.getTime())/(day_seconds*1000));

    }

    /**
     * 计算相差多少个小时
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getNumDiffHour(Date startDate, Date endDate){
        if (startDate == null || endDate == null) {
            return -1;
        }
        return (int)((endDate.getTime() - startDate.getTime())/(hour_seconds*1000));
    }

    /**
     * 计算相差多少分钟
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getNumDiffMin(Date startDate, Date endDate){
        if (startDate == null || endDate == null) {
            return -1;
        }
        return (int)((endDate.getTime() - startDate.getTime())/(minute_seconds*1000));
    }

    /**
     * 获取上午下午
     * @param date
     * @return
     */
    public static String getMorningAfternoon (Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(date.getTime());

        if (Calendar.AM == ca.get(GregorianCalendar.AM_PM) ) {
            return "上午";
        } else {
            return "下午";
        }
    }


}
