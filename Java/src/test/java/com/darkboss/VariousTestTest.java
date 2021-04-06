package com.darkboss;

import cn.hutool.core.date.StopWatch;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.darkboss.resources.ForwardBaseBO;
import com.darkboss.resources.ForwardData;
import com.darkboss.utils.FileUtils;
import com.darkboss.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.opentracing.SkywalkingSpan;
import org.apache.skywalking.apm.toolkit.opentracing.SkywalkingSpanBuilder;
import org.apache.skywalking.apm.toolkit.opentracing.SkywalkingTracer;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class VariousTestTest {


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

    @Test
    public void mergeTest() {
        List<String> currencies = Arrays.asList("CNY", "USD", "CNY", "EUR", "AAA");
        List<Integer> values = Arrays.asList(100, 100, 100, 100, 100);
        Map<String, Integer> resultMap = new HashMap<>(16);
        for (int i = 0; i <= 4; i++) {
            String currency = currencies.get(i);
            Integer value = values.get(i);

            resultMap.merge(currency, value, Integer::sum);
        }

        System.out.println(resultMap);
    }

    @Test
    public void subString() {
        String serialNumber = "2202102015000800044";
        if (serialNumber.length() == 19 && serialNumber.startsWith("2")) {
            String string = serialNumber.substring(9, 2000);
            if (string.endsWith("0")) {
                string = string.substring(0, 1);
            }
            int productId = Integer.parseInt(string);
            System.out.println(string);
            System.out.println(productId);
        }
    }

    @Test
    public void stopWatchTest() {
        StopWatch sw1 = new StopWatch("1层");
        StopWatch sw2 = new StopWatch("2层");
        sw1.start("sw测试");
        for (int i = 0; i < 100; i++) {
            sw2.start("测试" + i);
            sw2.stop();
        }
        sw1.stop();
        log.info(sw1.prettyPrint());
        log.info(sw2.prettyPrint());
    }

    @Test
    public void skyWalkingTest() {
        SkywalkingTracer tracer = new SkywalkingTracer();
        SkywalkingSpanBuilder builder = (SkywalkingSpanBuilder) tracer.buildSpan("SkyWalking测试");
        SkywalkingSpan span = (SkywalkingSpan) builder.startManual();

        span.setTag("1节点", 1);
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < 10000; i++) {
            BigDecimal decimal = BigDecimal.valueOf(i);
            sum = sum.add(decimal.remainder(new BigDecimal("3")));
        }
        span.setTag("2节点", 2);
        span.finish();
    }

    @Test
    public void FutureTest() {
        List<String> result = new ArrayList<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Callable<List<String>> callable = () -> {
            try {
                log.info("交易编号查占额");
                // do something
                return new ArrayList<>();
            } catch (Exception e) {
                log.error("交易编号查占额时出错", e);
                return null;
            }
        };
        Future<List<String>> futureResult = executor.submit(callable);
        try {
            result = futureResult.get(90, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("交易编号查占额时出错", e);
        }
    }

    @Test
    public void readFileTest() {
        String yesterday = FileUtils.readFile("C:\\Users\\Lionel\\Desktop\\1.txt");
        String today = FileUtils.readFile("C:\\Users\\Lionel\\Desktop\\2.txt");
        String occupyString = FileUtils.readFile("C:\\Users\\Lionel\\Desktop\\今天.txt");

        List<String> yesList = Arrays.asList(yesterday.split(","));
        List<String> todayList = Arrays.asList(today.split(","));

        List<String> aaa = ListUtils.notCross(yesList, todayList);
        List<String> bbb = ListUtils.notCross(todayList, yesList);
        FileUtils.writeFile(aaa.toString(), "C:\\Users\\Lionel\\Desktop\\今天少的.txt");
        FileUtils.writeFile(bbb.toString(), "C:\\Users\\Lionel\\Desktop\\今天多的.txt");
        Map<String, JSONArray> occupy = JSON.parseObject(occupyString, Map.class);

        BigDecimal total = BigDecimal.ZERO;
        // for (Map.Entry<String, JSONArray> entry : occupy.entrySet()) {
        //     String number = entry.getKey();
        //     if (!allList.contains(number)) {
        //         System.out.println(number);
        //     }
        //
        //     JSONArray array = entry.getValue();
        //     BigDecimal value = (BigDecimal) ((JSONObject) array.get(0)).get("value");
        //     total = total.add(value);
        // }
        System.out.println(total);
    }

    @Test
    public void intersection() {
        List<String> todaySerialNumber = Arrays.asList("XMS:FX_FORWARD:2202103172000800002",
                                                       "XMS:FX_FORWARD:2202103172000800004",
                                                       "XMS:FX_OPTION:2202103174000800009",
                                                       "XMS:FX_OPTION:2202103174000800010",
                                                       "XMS:FX_FORWARD:2202103172000800008");
        List<String> list = new ArrayList<>();

        List<String> tradeTypes = Collections.singletonList("FX_OPTION");
        for (String serialNumber : todaySerialNumber) {
            String tradeType = Arrays.asList(serialNumber.split(":")).get(1);
            if (tradeTypes.contains(tradeType)) {
                list.add(serialNumber);
            }
        }
        System.out.println(list);


    }


}