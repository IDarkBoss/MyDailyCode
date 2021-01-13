package com.darkboss;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <h3>各种测试</h3>
 * <p>瞎写的</p>
 *
 * @author Lionel
 * @date 2020-08-16 18:22
 **/
@Slf4j
public class VariousTest {
    public static void main(String[] args) {
        // timeStampToDate("1603728000000");
        // finalTest();
        // optionalTest();
        jsonObjectTest();
    }

    /**
     * 时间戳转日期
     *
     * @param timeStamp 时间戳
     */
    public static void timeStampToDate(String timeStamp) {
        Double time = Double.valueOf(timeStamp);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String dateString = sf.format(time);
        System.out.println(dateString);
    }

    /**
     * finalTest
     */
    public static void finalTest() {
        Map<String, String> map = new HashMap<>(1);
        map.put("1", "1");
        map.put("2", "2");
        System.out.println(map);
    }

    /**
     * optional
     */
    public static void optionalTest() {
        String aa = null;
        log.info(Optional.ofNullable(aa).orElse("aa是null"));
    }

    /**
     * JsonObject
     */
    private static void jsonObjectTest() {
        ForwardData object = new ForwardData();
        object.setDealDate(new Date());
        object.setSpotDate(new Date());

        ForwardBaseBO forwardBaseBO = new ForwardBaseBO();
        forwardBaseBO.setData(object);
        forwardBaseBO.setCusNumber(757);
        HashMap<String, Object> taskMap = new HashMap<>(16);
        taskMap.put("1231", forwardBaseBO);

        log.info("远期taskMap:{}", JSON.toJSONString(taskMap));
    }

    @Data
    private static class ForwardBaseBO implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer cusNumber;
        private Date valuationDate;
        private ForwardData data;
    }

    private static class ForwardData {
        private Date dealDate;
        private Date spotDate;

        void setDealDate(Date dealDate) {
            this.dealDate = dealDate;
        }

        void setSpotDate(Date spotDate) {
            this.spotDate = spotDate;
        }
    }
}
