package com.cookie.mybatis.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadList {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 5300; i++) {
            list.add("" + i);
        }
        int threadSize = 500;//每500条数据开启一个线程
        int remainder = list.size() % threadSize;
        int threadNum = 0;//线程数
        if (remainder == 0) {
            threadNum = list.size() / threadSize;
        } else {
            threadNum = list.size() / threadSize + 1;
        }

        ExecutorService eService = Executors.newFixedThreadPool(threadNum);//创建一个线程池

        List<Callable<String>> cList = new ArrayList<>();
        Callable<String> task = null;
        List<String> sList = null;

        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                sList = list.subList(i * threadSize, list.size());
            } else {
                sList = list.subList(i * threadSize, (i + 1) * threadSize);
            }
            final List<String> nowList = sList;
            task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j < nowList.size(); j++) {
                        sb.append("" + nowList.get(j));
                    }
                    return sb.toString();
                }
            };
            cList.add(task);
        }
        List<Future<String>> results = eService.invokeAll(cList);
        for (Future<String> str : results) {
            System.out.println(str.get());
        }
        eService.shutdown();
    }
}