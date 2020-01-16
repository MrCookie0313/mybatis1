package com.cookie.mybatis.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.cookie.mybatis.model.Employee;
import com.cookie.mybatis.service.FileUtil;
import org.apache.commons.io.FileUtils;

import static org.apache.catalina.startup.ExpandWar.deleteDir;

public class DownloadURLFile {

    /**
     * @param args
     */
    public static void main(String[] args) {

//        String res = downloadFromUrl("http://49.235.5.82:8090/upload/2019/9/Image%201-39139776253343e28d1f89ee465031e1.png","D:/aa/bb/cc");
//        System.out.println(res);
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId("bb");
        employee.setUsername("test");
        employee.setPassword("http://49.235.5.82:8090/upload/2019/9/Image%201-39139776253343e28d1f89ee465031e1.png");
        Employee employee1 = new Employee();
        employee1.setId("cc");
        employee1.setUsername("test2");
        employee1.setPassword("http://49.235.5.82:8090/upload/2019/9/Image%201-39139776253343e28d1f89ee465031e1.png");
        Employee employee2 = new Employee();
        employee2.setId("dd");
        employee2.setUsername("头像");
        employee2.setPassword("https://file.qqtouxiang.com/gexing/2019-10-21/c38c5ce3d48f09126200a8087d1a40b6.jpg");
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        for (Employee emp : employeeList) {
            try {
                downloadPhotos(emp.getId(), emp.getUsername(), emp.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = com.cookie.mybatis.util.FileUtils.compressToZip("images", "imagesZip", "工牌照片.zip");
//        File file1 = new File("imagesZip");
//        delete(file1);
    }


    public static String downloadFromUrl(String url, String dir) {

        try {
            URL httpurl = new URL(url);
            String fileName = getFileNameFromUrl(url);
            System.out.println(fileName);
            File f = new File(dir + fileName);
            FileUtils.copyURLToFile(httpurl, f);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fault!";
        }
        return "Successful!";
    }

    public static String getFileNameFromUrl(String url) {
        String name = new Long(System.currentTimeMillis()).toString() + ".X";
        int index = url.lastIndexOf("/");
        if (index > 0) {
            name = url.substring(index + 1);
            if (name.trim().length() > 0) {
                return name;
            }
        }
        return name;
    }

    /**
     * 通过url下载文件
     *
     * @param fileName    下载的后文件的名字
     * @param downloadUrl url一定要有http://
     * @param savePath    下载到哪个路径
     */
    public static boolean downloadFileFromUrl(String fileName, String downloadUrl, String savePath) {

        boolean result = false;
        try {

            //先判断文件是否存在
            File file1 = new File(savePath + fileName);
            if (file1.exists()) {
                System.out.println("删除已存在的文件");
                file1.delete();
            }
            long begin = System.currentTimeMillis();
            URL url = new URL(downloadUrl);
            File file = new File(savePath + fileName);
            org.apache.commons.io.FileUtils.copyURLToFile(url, file);
            long end = System.currentTimeMillis();
            System.out.println("文件下载耗时：" + (end - begin) / 1000 + "s");
            //执行到此，说明文件下载完毕
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void downloadPhotos(String USERID, String OID, String urlString) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流

        String downloadDir = "images\\" + USERID;
        File downloadFilePath = new File(downloadDir);
        if (downloadFilePath.exists() == false)              // 如果该目录不存在,则创建之
            downloadFilePath.mkdirs();

        String FILENAME = downloadDir + "\\" + OID + ".jpg";      //生成新的照片名
        System.out.println(FILENAME);

        OutputStream os = new FileOutputStream(FILENAME);  // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

    /**
     * 删除文件下所有文件和文件夹
     *
     * @param file
     */
    public static void delete(File file) {
        //判断是否存在此文件
        if (file.exists()) {
            //判断是否是文件夹
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                //判断文件夹里是否有文件
                if (files.length >= 1) {
                    //遍历文件夹里所有子文件
                    for (File file1 : files) {
                        //是文件，直接删除
                        if (file1.isFile()) {
                            file1.delete();
                            System.out.println("成功删除：" + file1.getAbsolutePath());
                        } else {
                            //是文件夹，递归
                            delete(file1);
                        }
                    }
                    //file此时已经是空文件夹
                    file.delete();
                    System.out.println("成功删除：" + file.getAbsolutePath());
                } else {
                    //是空文件夹，直接删除
                    file.delete();
                    System.out.println("成功删除：" + file.getAbsolutePath());
                }
            } else {
                //是文件，直接删除
                file.delete();
                System.out.println("成功删除：" + file.getAbsolutePath());
            }
        } else {
            System.out.println("文件不存在");
        }
    }

}