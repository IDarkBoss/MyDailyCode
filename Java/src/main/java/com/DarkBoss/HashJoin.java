package com.darkboss;

import cn.hutool.core.date.StopWatch;

import java.util.*;

/**
 * <h3>Hash Join的Test</h3>
 *
 * @author Lionel
 * @date 2020-08-16 18:32
 **/
public class HashJoin {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Map<String, Integer> map = new HashMap<>(32);
            map.put("id", i);
            map.put("name", i % 4000);
            list.add(map);
        }

        sw.start("hashTableTest");
        Hashtable<Integer, Map> result1 = hashTableTest(list);
        sw.stop();

        sw.start("setTest");
        List<Object> result2 = setTest(list);
        result2.forEach(System.out::println);
        sw.stop();

        sw.start("forTest");
        List<Integer> result3 = forTest(list);
        result3.forEach(System.out::println);
        sw.stop();

        System.out.println(sw.prettyPrint());
    }

    private static Hashtable<Integer, Map> hashTableTest(List<Map<String, Integer>> list) {
        List<Map<String, Integer>> list2 = new ArrayList<>(list);
        Hashtable<Integer, Map> table = new Hashtable<>();
        list.forEach(o1 -> {
            table.put(o1.get("id"), o1);
        });
        for (Map<String, Integer> o2 : list2) {
            if (table.containsKey(o2.get("id"))) {
                table.put(o2.get("id"), o2);
            }
        }
        return table;
    }

    private static List<Object> setTest(List<Map<String, Integer>> list) {
        List<Map<String, Integer>> list2 = new ArrayList<>(list);
        Set<Integer> set = new HashSet<>();
        for (Map<String, Integer> object : list) {
            set.add(object.get("name"));
        }
        for (Map<String, Integer> object : list2) {
            set.add(object.get("name"));
        }

        return Arrays.asList(set.toArray());
    }

    private static List<Integer> forTest(List<Map<String, Integer>> list) {
        List<Map<String, Integer>> list2 = new ArrayList<>(list);
        List<Integer> result = new ArrayList<>();

        for (Map<String, Integer> o1 : list) {
            for (Map<String, Integer> o2 : list2) {
                if (o1.get("name").equals(o2.get("name"))) {
                    result.add(o1.get("name"));
                    break;
                }
            }
        }

        return result;
    }
}
