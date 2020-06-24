package com.darkboss;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <h3>计算日期间隔</h3>
 *
 * @author Li Ang
 * @date 2020-06-19 15:54
 */
public class DateCompare {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        DateCompare dateCompare = new DateCompare();
        dateCompare.calDuration("20200101", "20200606");
    }

    /**
     * 计算间隔
     *
     * @param fromDay 起始日
     * @param toDay   目标日
     */
    public void calDuration(final String fromDay, final String toDay) {
        try {
            String today = dateFormat.format(new Date());
            if (fromDay.compareTo(toDay) > 0) {
                System.out.println("起始日期必须小于等于结束日期");
            }
            if (toDay.compareTo(today) >= 0) {
                System.out.println("结束日期必须小于当前日期");
            }

            Date beforeDay = toDate(fromDay);
            Date afterDay = toDate(toDay);

            assert beforeDay != null;
            assert afterDay != null;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(afterDay);
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            Date before7days = calendar.getTime();

            if (beforeDay.getTime() < before7days.getTime()) {
                System.out.println("日期间隔不能大于7天");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 日期 String 转 Date
     *
     * @param inputDate String
     * @return Date
     */
    public static Date toDate(final String inputDate) {
        try {
            return dateFormat.parse(inputDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
