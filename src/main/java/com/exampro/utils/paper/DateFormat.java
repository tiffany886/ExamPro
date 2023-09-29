package com.exampro.utils.paper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 字符串————日期类型
 */
public class DateFormat {
    // 输出Date类型
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 输出String类型
    static SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date stringToDate(String time) throws ParseException {
            // 创建一个新的 SimpleDateFormat 对象，指定输出日期时间的格式
            // SimpleDateFormat outputDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

            // 设置时区为 CST（中国标准时间）
            // outputDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return dateFormat.parse(time);
    }
    public static String dateToString(Date time) {
        return outputDateFormat.format(time);
    }
    public DateFormat(){}
    public static void main(String[] args) throws ParseException {
        String a = "2023-1-1 15:00:00";
        // System.out.println(stringToDate(a));
        // System.out.println(dateToString(stringToDate(a)));
    }
}

/**
 *         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 *         // 创建一个新的 SimpleDateFormat 对象，指定输出日期时间的格式
 *         SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 *         String data="2023-1-1 15:00:00";
 *         Date a = dateFormat.parse(data);
 *         System.out.println(a);
 *         // 格式化日期为所需的格式
 *         String b = outputDateFormat.format(a);
 *         System.out.println(a);
 *         System.out.println(b);
 */
