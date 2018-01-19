package com.bidostar.testkotlin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author 创建人 张松河
 * @date 创建时间
 * @Description 日期转换工具类
 * @Version
 */
public class DateFormatUtils {

    /**
     * 一分钟的毫秒值
     */
    public static final long ONE_MINUTE = 60 * 1000;

    /**
     * 一小时的毫秒值
     */
    public static final long ONE_HOUR = 60 * ONE_MINUTE;

    /**
     * 一天的毫秒值
     */
    public static final long ONE_DAY = 24 * ONE_HOUR;

    /**
     * 两天的毫秒值
     */
    public static final long TWO_DAY = 2 * ONE_DAY;

    /**
     * 一周的毫秒值
     */
    public static final long ONE_WEEK = 7 * ONE_DAY;

    /**
     * 一月的毫秒值
     */
    public static final long ONE_MONTH = 30 * ONE_DAY;

    /**
     * 一年的毫秒值
     */
    public static final long ONE_YEAR = 12 * ONE_MONTH;

    /**
     * 年-月-日 时:分:秒(2014-4-16 19:14:51)
     */
    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_FULL_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_FULL_DOT = "yyyy.MM.dd HH:mm";
    public static final String PATTERN_MILL = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 年-月-日
     */
    public static final String PATTERN_YEAR_MONTH_DAY = "yyyy-MM-dd";
    /**
     * 年月日
     */
    public static final String PATTERN_YEAR_MONTH_DAY_COMPACT = "yyyyMMdd";
    /**
     * 年/月/日
     */
    public static final String PATTERN_YEAR_MONTH_DAY_SLASH = "yyyy/MM/dd";
    /**
     * xxxx年xx月x日
     */
    public static final String PATTERN_YEAR_MONTH_DAY_SLASH_HAN = "yyyy年MM月dd日";
    /**
     * 年-月(2014-4)
     */
    public static final String PATTERN_YEAR_MONTH = "yyyy-M";
    /**
     * 年
     */
    public static final String PATTERN_YEAR = "yyyy";
    /**
     * 月
     */
    public static final String PATTERN_MONTH = "MM";
    /**
     * 月日
     */
    public static final String PATTERN_MONTH_DAY = "MM-dd";
    /**
     * 月-日 时:分
     */
    public static final String PATTERN_MONTH_DAY_HOUR_MINUTE = "MM-dd HH:mm";
    /**
     * 时:分
     */
    public static final String PATTERN_HOUR_MINUTE = "HH:mm";
    /**
     * 时:分:秒
     */
    public static final String PATTERN_HOUR_MINUTE_SECOND = "HH:mm:ss";
    /**
     * 分:秒
     */
    public static final String PATTERN_MINUTE_SECOND = "mm:ss";
    /**
     * 月/日
     */
    public static final String PATTERN_MONTH_DAY1 = "M/d";

    /**
     * 将一个日期字串按照指定模式格式化
     *
     * @param date        日期字串
     * @param fromPattern 日期的原始格式
     * @param toPattern   要显示的格式
     * @return 格式化后的字串
     */
    public static String format(String date, String fromPattern, String toPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(fromPattern, Locale.getDefault());
        try {
            Date d = sdf.parse(date);
            return format(d, toPattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将一个日期字串按照指定模式格式化
     *
     * @param date    日期
     * @param pattern 要显示的格式
     * @return 格式化后的字串
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * 获取昨日   yyyy-MM-dd
     *
     * @return
     */
    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }


    /**
     * 将一个日期格式的字符串转成Date对象
     *
     * @param date    日期格式的字串
     * @param pattern 字串的格式
     * @return Date对象
     */
    public static Date parse(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();

    }

    /**
     * 获取当前时间和指定时间的间隔
     *
     * @param context  上下文
     * @param lastTime 要比较的时间
     * @return 时间间隔
     */
    public static String getPassedTime(Context context, long lastTime) {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - lastTime;
        long timeIntoFormat;
        Resources res = context.getResources();
        String passedTime;
        if (timePassed < ONE_MINUTE) {
            passedTime = res.getString(R.string.time_just_now);
        } else if (timePassed < ONE_HOUR) {
            timeIntoFormat = timePassed / ONE_MINUTE;
            passedTime = String.format(res.getString(R.string.time_minute), timeIntoFormat);
        } else if (timePassed < ONE_DAY) {
            timeIntoFormat = timePassed / ONE_HOUR;
            passedTime = String.format(res.getString(R.string.time_hour), timeIntoFormat);
        } else if (timePassed < ONE_MONTH) {
            timeIntoFormat = timePassed / ONE_DAY;
            passedTime = String.format(res.getString(R.string.time_day), timeIntoFormat);
        } else if (timePassed < ONE_YEAR) {
            timeIntoFormat = timePassed / ONE_MONTH;
            passedTime = String.format(res.getString(R.string.time_month), timeIntoFormat);
        } else {
            timeIntoFormat = timePassed / ONE_YEAR;
            passedTime = String.format(res.getString(R.string.time_year), timeIntoFormat);
        }
        return passedTime;
    }

    public static String getPassedTime1(Context context, long lastTime) {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - lastTime;
        long timeIntoFormat;
        Resources res = context.getResources();
        String passedTime;
        if (timePassed < ONE_MINUTE) {
            passedTime = res.getString(R.string.time_just_now);
        } else if (timePassed < ONE_HOUR) {
            timeIntoFormat = timePassed / ONE_MINUTE;
            passedTime = String.format(res.getString(R.string.time_minute), timeIntoFormat);
        } else if (timePassed < ONE_DAY) {
            timeIntoFormat = timePassed / ONE_HOUR;
            passedTime = String.format(res.getString(R.string.time_hour), timeIntoFormat);
        } else if (timePassed < TWO_DAY) {
            String time = format(new Date(lastTime), PATTERN_HOUR_MINUTE);
            passedTime = String.format(res.getString(R.string.time_yesterday_hour_minute), time);
        } else if (timePassed < ONE_YEAR) {
            passedTime = format(new Date(lastTime), PATTERN_MONTH_DAY_HOUR_MINUTE);
        } else {
            passedTime = format(new Date(lastTime), PATTERN_YEAR_MONTH_DAY);
        }
        return passedTime;
    }

    public static String getPassedTime2(Context context, long lastTime) {

        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - lastTime;
        Calendar oldCalendar = Calendar.getInstance();

        oldCalendar.setTimeInMillis(lastTime);
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTimeInMillis(currentTime);
        int year = oldCalendar.get(Calendar.YEAR);
        Log.d("DateFormatUtils", "year:" + year);
        int nowYear = nowCalendar.get(Calendar.YEAR);
        Log.d("DateFormatUtils", "nowYear:" + nowYear);
        long timeIntoFormat;
        Resources res = context.getResources();
        String passedTime;

        if (timePassed < ONE_MINUTE) {
            passedTime = res.getString(R.string.time_just_now);
        } else if (timePassed < ONE_HOUR) {
            timeIntoFormat = timePassed / ONE_MINUTE;
            passedTime = String.format(res.getString(R.string.time_minute), timeIntoFormat);
        } else if (timePassed < ONE_DAY) {
            timeIntoFormat = timePassed / ONE_HOUR;
            passedTime = String.format(res.getString(R.string.time_hour), timeIntoFormat);
        } else if (timePassed < TWO_DAY) {
            String time = format(new Date(lastTime), PATTERN_HOUR_MINUTE);
            passedTime = String.format(res.getString(R.string.time_yesterday_hour_minute), time);
        }  else if (nowYear > year) {
            passedTime = format(new Date(lastTime), PATTERN_YEAR_MONTH_DAY);
        }else if (timePassed < ONE_YEAR) {
            passedTime = format(new Date(lastTime), PATTERN_MONTH_DAY_HOUR_MINUTE);
        } else {
            passedTime = format(new Date(lastTime), PATTERN_YEAR_MONTH_DAY);
        }
        return passedTime;
    }


    /**
     * 获取某月的第一天
     *
     * @param currentDate 当前日期
     * @param pattern     返回的日期格式
     * @param offset      相对与当前的月份。负值表示之前几个月，正值表示之后几个月
     * @return 某月的第一天
     */
    public static Calendar getMonthStart(Date currentDate, String pattern, int offset) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, offset);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar;
    }

    /**
     * 获取某月的最后一天
     *
     * @param currentDate 当前日期
     * @param pattern     返回的日期格式
     * @param offset      相对与当前的月份。负值表示之前几个月，正值表示之后几个月
     * @return 某月的最后一天
     */
    public static Calendar getMonthEnd(Date currentDate, String pattern, int offset) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, offset);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar;
    }

    /**
     * 获取某月的第一天
     *
     * @param currentDate 当前日期
     * @param pattern     返回的日期格式
     * @param offset      相对与当前的月份。负值表示之前几个月，正值表示之后几个月
     * @return 某月的第一天
     */
    public static String getStartDateOfMonth(Date currentDate, String pattern, int offset) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, offset);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return format(calendar.getTime(), pattern);
    }

    /**
     * 获取某月的最后一天
     *
     * @param currentDate 当前日期
     * @param pattern     返回的日期格式
     * @param offset      相对与当前的月份。负值表示之前几个月，正值表示之后几个月
     * @return 某月的最后一天
     */
    public static String getLastDateOfMonth(Date currentDate, String pattern, int offset) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, offset);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format(calendar.getTime(), pattern);
    }

    public static Date[] getWeekStartAndEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date[] dates = new Date[2];
        Date firstDateOfWeek, lastDateOfWeek;
        // 得到当天是这周的第几天
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // 减去dayOfWeek,得到第一天的日期，因为Calendar用０－６代表一周七天，所以要减一
        calendar.add(Calendar.DAY_OF_WEEK, -(dayOfWeek - 2));
        firstDateOfWeek = calendar.getTime();
        // 每周7天，加６，得到最后一天的日子
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        lastDateOfWeek = calendar.getTime();

        dates[0] = firstDateOfWeek;
        dates[1] = lastDateOfWeek;
        return dates;
    }

    @SuppressLint("SimpleDateFormat")
    public static String getNetCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        URL url;
        try {
            // url = new URL("http://www.bjtime.cn");
            url = new URL("210.72.145.44");
            URLConnection uc = url.openConnection();
            uc.setConnectTimeout(2000);
            uc.connect();
            long time = uc.getDate();
            System.out.println("current time:" + currentDate);
            Date date = new Date(time);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
        } catch (Exception e) {
            e.printStackTrace();
            currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return currentDate;
    }


    /**
     * String 转换 long
     *
     * @param strTime
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static long stringToLong(String strTime, String formatType) throws ParseException {
        Date date = stringToDate(strTime, formatType);
        if (date == null) {
            return 0;
        } else {
            return date.getTime();
        }
    }

    public static long stringToLong1(String strTime, String formatType) {
        Date date = stringToDate1(strTime, formatType);
        if (date == null) {
            return 0;
        } else {
            return date.getTime();
        }
    }

    public static Date stringToDate1(String strTime, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            date = formatter.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date stringToDate(String strTime, String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = formatter.parse(strTime);
        return date;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate, String pattern)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String data1, String data2, String pattern) throws ParseException {
        String bdate = "";
        String smdate = "";
        if (DateFormatUtils.compareDate(data1, data2, DateFormatUtils.PATTERN_YEAR_MONTH_DAY) == 1) {//date1 > date2
            bdate = data1;
            smdate = data2;
        } else if (DateFormatUtils.compareDate(data1, data2, DateFormatUtils.PATTERN_YEAR_MONTH_DAY) == -1) {
            bdate = data2;
            smdate = data1;
        } else {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 比较两个日期大小
     *
     * @param DATE1
     * @param DATE2
     * @param pattern
     * @return 1：dt1>dt2
     */
    public static int compareDate(String DATE1, String DATE2, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            Log.e("DateFormatUtils", "exception --->" + exception.toString());
        }
        return 0;
    }


    public static String getDetailTime(long time) {
        float time1 = (float) time;
        if (time / 1000 / 60 < 60) {
            return Math.round(time1 / 1000 / 60) + "分钟";
        } else if (time / 1000 / 60 / 60 < 24) {
            return Math.round(time1 / 1000 / 60 / 60) + "小时";
        } else if (time / 1000 / 60 / 60 / 24 < 365) {
            return Math.round(time1 / 1000 / 60 / 60 / 24f) + "天";
        } else if (time / 1000 / 60 / 60 / 24 / 365 < 100) {
            return Math.round(time1 / 1000 / 60 / 60 / 24 / 365f) + "年";
        }
        return null;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(String date) {
        Date dt = DateFormatUtils.parse(date, DateFormatUtils.PATTERN_YEAR_MONTH_DAY);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        if (w == 1) {
            return "周一";
        }
        return DateFormatUtils.format(date, DateFormatUtils.PATTERN_YEAR_MONTH_DAY, DateFormatUtils.PATTERN_MONTH_DAY1);
    }

    /**
     * 根据日期获取当前是周几
     *
     * @param date 日期
     * @return 星期几
     */
    public static String getWeekOfDate1(String date) {
        Date dt = DateFormatUtils.parse(date, DateFormatUtils.PATTERN_YEAR_MONTH_DAY);
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        Log.d("DateFormatUtils", "getWeekOfDate1w:" + w);

        return weekDays[w];

    }

    public static boolean isToday(String date) {
        String currentDate = DateFormatUtils.format(new Date(), PATTERN_YEAR_MONTH_DAY);
        return date.equals(currentDate);
    }


    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static int getDistanceTime(String str1, String str2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String result = "";
        /*if(day>0){
            result += day+"天";
        }
        if(hour > 0){
            result += hour+"小时";
        }*/
        int secord = 0;
        if (min > 0) {
            secord += min * 60;

            result += min + "分";
        }
        if (sec > 0) {
            secord += sec;
            result += sec + "秒";
        }
        //        day + "天" + hour + "小时" + min + "分" + sec + "秒"
        return secord;
    }
}
