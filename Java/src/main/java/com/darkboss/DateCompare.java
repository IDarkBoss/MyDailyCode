package com.darkboss;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * <h3>计算日期间隔</h3>
 *
 * @author Li Ang
 * @date 2020-06-19 15:54
 */
public class DateCompare {

    public static void main(String[] args) {
        DateCompare dateCompare = new DateCompare();

        dateCompare.calDuration("20200111", "20200606");
    }

    /**
     * 计算间隔
     *
     * @param fromDay   起始日
     * @param targetDay 目标日
     */
    private void calDuration(String fromDay, String targetDay) {
        try {
            // 方法一
            Date fromDate = Convert.toDate(fromDay);
            Date targetDate = Convert.toDate(targetDay);

            // 方法二
            // Date fromDate = new DateTime(fromDay, DatePattern.PURE_DATE_FORMAT);
            // Date targetDate = new DateTime(targetDay, DatePattern.PURE_DATE_FORMAT);

            Date today = new Date();
            if (DateUtil.compare(fromDate, today) > 0) {
                System.out.println("起始日期必须小于等于结束日期");
            }
            if (DateUtil.compare(fromDate, targetDate) >= 0) {
                System.out.println("结束日期必须小于当前日期");
            }

            Calendar calendar = DateUtil.calendar(targetDate);
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            Date before7days = calendar.getTime();

            if (DateUtil.compare(fromDate, before7days) < 0) {
                System.out.println("日期间隔不能大于7天");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
