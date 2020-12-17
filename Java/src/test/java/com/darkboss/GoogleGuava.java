package com.darkboss;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <h2>Google-Guava测试</h2>
 *
 * @author Ang Li
 * @date 2020/12/15 下午 12:38
 */
@Slf4j
public class GoogleGuava {
    private static final Joiner joiner = Joiner.on(",").skipNulls();
    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    private static final CharMatcher charMatcherDigit = CharMatcher.digit();
    private static final CharMatcher charMatcherAny = CharMatcher.any();

    /**
     * 拼接分割
     */
    @Test
    public void joinSplit() {
        // 拼接
        String string = joiner.join(Lists.newArrayList("a", null, "b"));
        System.out.println(string);
        // 分割
        Iterable<String> list = splitter.split(string);
        System.out.println(list);
    }

    /**
     * 正则匹配
     */
    @Test
    public void matcher() {
        // 保留匹配的字符
        System.out.println(charMatcherDigit.retainFrom("zgbnans1651b6dd1a6"));
        // 移除匹配的字符
        System.out.println(charMatcherAny.removeFrom("zgbnans1651b6dd1a6"));
        // 替换a-f的字符为*
        System.out.println(CharMatcher.inRange('a', 'f').or(CharMatcher.is('n')).replaceFrom("datagram1651", "*"));
    }


}
