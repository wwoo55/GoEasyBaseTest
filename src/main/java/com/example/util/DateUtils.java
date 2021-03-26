package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: demo_xy
 * @className: DateUtils
 * @description:
 * @author: xy
 * @time: 2021/3/26 16:37
 */
public class DateUtils {

    public static Date convertDate(String str) throws ParseException {
        SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(str);
    }
}
