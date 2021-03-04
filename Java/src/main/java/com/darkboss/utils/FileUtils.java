package com.darkboss.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.nio.charset.Charset;

/**
 * <h3>读取文件</h3>
 *
 * @author Li Ang
 * @date 2021-02-26 14:31
 */
public class FileUtils {
    /**
     * 读取文件内容
     *
     * @param path 文件路径
     *
     * @return 文件内容
     */
    public static String readFile(String path) {
        File file = new File(path);
        FileReader fileReader = new FileReader(file, Charset.defaultCharset());
        return fileReader.readString();
    }

    /**
     * 保存文件内容
     *
     * @param string 内容
     * @param path   文件路径
     *
     * @return 文件内容
     */
    public static void writeFile(String string, String path) {
        FileWriter fileWriter = new FileWriter(path, Charset.defaultCharset());
        fileWriter.write(string, false);
    }
}
