package com.darkboss;

import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSONObject;
import com.darkboss.resources.ForwardBaseBO;
import com.darkboss.resources.ForwardData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class VariousTestTest {
    @Resource
    private JSONString jsonString;


    /**
     * 时间戳转日期
     */
    @Test
    public void timeStampToDate() {
        String timeStamp = "";
        Date date = new Date();
        Date aaa = new Date(date.getTime());

        Double time = Double.valueOf(timeStamp);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd ah:mm:ss");
        String dateString = sf.format(time);
        System.out.println(dateString);
    }

    /**
     * finalTest
     */
    @Test
    public void finalTest() {
        final Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        System.out.println(map);

        String aaa = null;
        map.get(aaa);
    }

    /**
     * optional
     */
    @Test
    public void optionalTest() {
        String aa = null;
        log.info(Optional.ofNullable(aa).orElse("aa是null"));
    }

    /**
     * JsonObject
     */
    @Test
    public void jsonObjectTest() {
        ForwardData object = new ForwardData();
        object.setDealDate(new Date());
        object.setSpotDate(new Date());

        ForwardBaseBO forwardBaseBO = new ForwardBaseBO();
        forwardBaseBO.setData(object);
        forwardBaseBO.setCusNumber(757);
        HashMap<String, Object> taskMap = new HashMap<>(16);
        taskMap.put("1231", forwardBaseBO);

        log.info("远期taskMap:{}", object.toPrettyString());
        JSONObject obj = new JSONObject();
    }


    @Test
    public void equalsTest() {
        Integer day = null;
        String point = "10Y";
        String length = point.substring(0, point.length() - 1);
        String unit = point.substring(point.length() - 1);
        System.out.println("Gasda");
    }
}