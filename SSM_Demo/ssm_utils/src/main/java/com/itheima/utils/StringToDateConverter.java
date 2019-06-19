package com.itheima.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
    /**
     * @DateTimeFomate("yyyy-MM-dd HH-mm");注解实现
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        DateFormat df;
        try {
            if (StringUtils.isEmpty(source)){
                throw new RuntimeException("请输入您的日期");
            }
            df = new SimpleDateFormat("yyyy-MM-dd HH-mm");
            Date date = df.parse(source);
            return date;
        } catch (ParseException e) {
            throw  new RuntimeException("日期格式错误");
        }
    }
}
