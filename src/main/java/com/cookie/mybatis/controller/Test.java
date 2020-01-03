package com.cookie.mybatis.controller;

import java.util.ArrayList;

public class Test {
 
    public static void main(String[] args)  {
        final InsertData insertData = new InsertData();
         
        new Thread(() -> insertData.insert(Thread.currentThread())).start();
         
         
        new Thread(() -> insertData.insert(Thread.currentThread())).start();
    }  
}
 
class InsertData {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
     
    public synchronized void insert(Thread thread){
        for(int i=0;i<5;i++){
            System.out.println(thread.getName()+"在插入数据"+i);
            arrayList.add(i);
        }
    }
}