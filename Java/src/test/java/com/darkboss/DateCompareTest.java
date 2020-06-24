package com.darkboss;

import org.junit.jupiter.api.Test;

import java.util.Date;

class DateCompareTest {
    @Test
    void calDuration() {
        Date date = DateCompare.toDate("20200511");
        System.out.println(date);
    }
}