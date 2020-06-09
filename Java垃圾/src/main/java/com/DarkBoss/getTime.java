package com.darkboss;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;

/**
 * @author Li Ang
 * @date 2020/4/27 下午 3:44
 */
public class getTime {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime target = LocalTime.parse("18:00:00");
        double duration = Duration.between(now, target).getSeconds();

        if (duration > 0) {
            double minutes = Math.ceil(Math.abs(duration) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你距离下班仅剩" + "\033[32m" + result + "\033[m" + "分钟啦，小老弟！");
        } else if (duration == 0) {
            System.out.println("下班啦！");
        } else {
            double minutes = Math.floor(Math.abs(duration) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你都已经下班" + "\033[32m" + result + "\033[m" + "分钟啦，小老弟！");
        }


    }

}
