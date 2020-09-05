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
        long compare = DateUtil.between(now, offWork, DateUnit.MINUTE, true);
        System.out.println("还有" + compare + "分钟下班！");
    }
}
