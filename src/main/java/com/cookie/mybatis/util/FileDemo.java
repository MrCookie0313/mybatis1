package com.cookie.mybatis.util;

import java.io.File;
import java.io.IOException;

/**
 * @author Sunbing
 * @date 2020/1/13 10:59
 * @Version 1.0
 */
public class FileDemo {
    public static void main(String[] args) {
//        createFile("D:/aa/bb");
        mkdirs("D:/aa/bb/cc/dd");
    }
    /**
     * 创建文件顺便创建父目录
     *
     * @param path 文件字符串路径例如d:/fulld/why/ass/a/asd
     */
    public static void createFile(String path) {
        createFile(new File(path));
    }

    /**
     * 创建文件顺便创建父目录
     *
     * @param file file类
     */
    private static void createFile(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            if (parentFile.isFile()) {
                parentFile.delete();
                parentFile.mkdirs();
            }
        } else {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件夹顺便创建父目录
     *
     * @param path 文件夹的路径字符串例如d:/fulld/why/ass/a/asd/
     * @return 如果本来就存在或者创建成功，那么就返回true
     */
    public static void mkdirs(String path) {
        mkdirs(new File(path));
    }

    /**
     * 创建文件夹顺便创建父目录
     *
     * @param file file类
     */
    public static void mkdirs(File file) {
        if (file.exists()) {
            file.delete();
            file.mkdirs();
        } else {
            file.mkdirs();
        }
    }
}
