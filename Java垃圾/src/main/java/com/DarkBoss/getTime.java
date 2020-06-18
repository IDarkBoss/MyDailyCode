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
        LocalTime goToWork = LocalTime.parse("09:00:00");
        LocalTime offWork = LocalTime.parse("18:00:00");
        double duration_GoToWork = Duration.between(now, goToWork).getSeconds();
        double duration_OffWork = Duration.between(now, offWork).getSeconds();

        if (duration_OffWork > 0) {
            double minutes = Math.ceil(Math.abs(duration_OffWork) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你距离下班仅剩" + "\033[33m" + result + "\033[m" + "分钟啦，小老弟！");
        } else if (duration_OffWork == 0) {
            System.out.println("下班啦！");
        } else {
            double minutes = Math.floor(Math.abs(duration_OffWork) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你都已经下班" + "\033[33m" + result + "\033[m" + "分钟啦，小老弟！");
        }


    }

}
