package com.darkboss.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>list的各种工具</h3>
 *
 * @author Li Ang
 * @date 2021-02-26 16:15
 */
public class ListUtils {
    public static <T> List<T> notCross(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        list1.forEach(item -> {
            if (!list2.contains(item)) {
                result.add(item);
            }
        });
        return result;
    }
}
