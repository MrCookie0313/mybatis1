package com.cookie.mybatis.controller;
 
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
 
public class WebMagicDemo {
 
    public static void main(String[] args) {
 
        //创建爬虫
        Spider.create(new MyPageProcessor())            //将创建好的PageProcessor页面处理器交给Spider
                .addUrl("http://www.xiyou.edu.cn/xwzx/zhxw.htm")   //输入url
                .addPipeline(new FilePipeline())          //设置结果 保存到文件
                //.addPipeline(new ConsolePipeline())         //设置结果 控制台输出
//                .addPipeline(new JsonFilePipeline())        //设置结果 以Json格式输出
                            //当没有设置结果输出时 默认控制台输出
                .thread(5)                  //设置5个线程同时执行
                .run();                   //启动爬虫
 
    }
 
 
}