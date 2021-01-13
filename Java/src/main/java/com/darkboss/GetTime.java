package com.darkboss;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;

/**
 * <h3>计算摸鱼时间</h3>
 *
 * @author Li Ang
 * @date 2020-4-27 15:44
 */
public class GetTime {
    public static void main(String[] args) {
        GetTime getTime = new GetTime();
        getTime.calTime();
    }

    private void calTime() {
        LocalTime now = LocalTime.now();
        LocalTime goToWork = LocalTime.parse("09:00:00");
        LocalTime offWork = LocalTime.parse("18:00:00");
        double durationGoToWork = Duration.between(now, goToWork).getSeconds();
        double durationOffWork = Duration.between(now, offWork).getSeconds();

        if (durationGoToWork > 0) {
            double minutes = Math.ceil(Math.abs(durationGoToWork) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你距离上班仅剩" + "\033[33m" + result + "\033[m" + "分钟啦，小老弟！");
        } else if (durationGoToWork == 0) {
            System.out.println("上班啦！！！");
        } else if (durationGoToWork < 0 && durationOffWork > 0) {
            double minutes = Math.ceil(Math.abs(durationOffWork) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你距离下班仅剩" + "\033[33m" + result + "\033[m" + "分钟啦，小老弟！");
        } else if (durationGoToWork < 0 && durationOffWork == 0) {
            System.out.println("下班啦！！！");
        } else {
            double minutes = Math.floor(Math.abs(durationOffWork) / 60);
            DecimalFormat df1 = new DecimalFormat("0");
            String result = df1.format(minutes);
            System.out.println("你都已经下班" + "\033[33m" + result + "\033[m" + "分钟啦，小老弟！");
        }
    }
}
