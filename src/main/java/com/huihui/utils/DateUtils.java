package com.huihui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
* 日期工具类
* */
public class DateUtils {

    private final static  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static  String formateMysqlDateToString(Date date){
        return simpleDateFormat.format(date) ;
    }

}
