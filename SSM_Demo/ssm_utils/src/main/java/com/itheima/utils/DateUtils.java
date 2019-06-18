package com.itheima.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dateToString(Date date){
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        return format;
    }
}
