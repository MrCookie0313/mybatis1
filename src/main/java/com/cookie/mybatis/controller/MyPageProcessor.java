package com.cookie.mybatis.controller;

import org.springframework.stereotype.Indexed;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Sunbing
 * @date 2019/12/13 17:13
 * @Version 1.0
 */
@Indexed
public class MyPageProcessor implements PageProcessor {

    private Site site= new Site().setCharset("utf-8")
            .setSleepTime(1)
            .setTimeOut(10)
            .setRetrySleepTime(3)
            .setRetryTimes(3);
    @Override
    public void process(Page page) {
        page.putField("title",page.getHtml().css(".c44380").all());
    }

    @Override
    public Site getSite() {
        return this.site;
    }


}
