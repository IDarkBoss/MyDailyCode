package com.darkboss;

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
            System.out.println("距离下班还有" + minutes + "分钟啦");
        } else if (duration == 0) {
            System.out.println("下班啦！");
        } else {
            double minutes = Math.floor(Math.abs(duration) / 60);
            System.out.println("已经下班" + minutes + "分钟啦");
        }


    }

}
