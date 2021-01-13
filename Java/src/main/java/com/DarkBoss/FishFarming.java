package com.darkboss;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

/**
 * <h3>摸鱼计算器</h3>
 *
 * @author Lionel
 * @date 2020-09-05 23:52
 **/
public class FishFarming {
    public static void main(String[] args) {
        fishFarming();
    }

    private static void fishFarming() {
        DateTime now = DateUtil.date();
        DateTime offWork = DateUtil.parse(DateUtil.today() + " 18:00:00");
        long compare = DateUtil.between(now, offWork, DateUnit.SECOND, true);
        double minutes = Math.ceil(compare / 60.0);
        System.out.println("还有" + (int) minutes + "分钟下班！");
    }
}
