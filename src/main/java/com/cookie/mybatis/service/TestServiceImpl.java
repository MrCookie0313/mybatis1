package com.cookie.mybatis.service;

import com.cookie.mybatis.model.Student;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class TestServiceImpl {
	
	private ExecutorService executor = Executors.newFixedThreadPool(10);//给定线程池数量
	
	private static final int MAX_DEAL = 50;//对多数据进行分组，50条一组，一组使用一个线程进行执行
	

	public void addList(List<Student> list) {
		//判断数据是否为空
		if(list == null || list.isEmpty()){
			return;
		}
		int times = (list.size() + MAX_DEAL - 1) / MAX_DEAL;
        CountDownLatch countDownLatch = new CountDownLatch(times);//一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
        try {
        	 for (int i = 0; i < times; i++) {
                 if (i == times - 1) {
                 	executor.execute(new addListRunnable(list.subList(i * MAX_DEAL, list.size()), countDownLatch));//调用业务逻辑
                 } else {
                 	executor.execute(new addListRunnable(list.subList(i * MAX_DEAL, (i + 1) * MAX_DEAL), countDownLatch));
                 }
             }
             countDownLatch.await();//一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
	
	private class addListRunnable implements Runnable{
 
		private List<Student> list;
		private CountDownLatch countDownLatch;
		
		public addListRunnable(List<Student> list,CountDownLatch countDownLatch){
			super();
			this.list = list;
			this.countDownLatch = countDownLatch;
		}
		
		
		@Override
		public void run() {
			try {
				//模拟业务执行，这里并没有对list进行操作
				Thread.sleep(1000);
				System.out.println("当前线程为"+Thread.currentThread().getId());//输出当前线程id
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
                countDownLatch.countDown();//完成一次操作，计数减一  
            }
			
		}
		
	}
}