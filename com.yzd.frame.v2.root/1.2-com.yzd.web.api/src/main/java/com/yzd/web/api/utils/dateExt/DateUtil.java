package com.yzd.web.api.utils.dateExt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 获取系统当前时间字符串（"yyyy-MM-dd HH:mm:ss"）
     *
     * @return
     */
    public static String nowToString() {
        return nowToString("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取系统当前时间，指定格式
     *
     * @return
     */
    public static String nowToString(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }
}
