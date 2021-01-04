package demo.springboot.common.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuYingJie
 * @version 1.0
 * @date 2020/11/1
 **/

public class Guid {
    public static String get() {
        StringBuffer now = new StringBuffer(new SimpleDateFormat(
                "yyyyMMddHHmmssSSS").format(new Date()));
        int n = (int) (Math.random() * 90000.0D + 10000.0D);
        return now.append(n).toString();
    }
}
