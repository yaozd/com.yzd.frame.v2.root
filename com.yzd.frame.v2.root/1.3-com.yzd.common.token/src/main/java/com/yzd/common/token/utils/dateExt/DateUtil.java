package com.yzd.common.token.utils.dateExt;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /***
     * 当前时间,增加N天
     * @param days
     * @return
     */
    public static Date plusDays(int days,Date dt){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, +days);
        //Date now = c.getTime();
        return c.getTime();
    }

    /***
     * 获得当前时间
     * @return
     */
    public static Date getNow(){
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }
}
