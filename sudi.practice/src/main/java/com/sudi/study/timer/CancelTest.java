package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class CancelTest {

	public static void main(String[] args) throws InterruptedException {
		// 创建Timer实例
		Timer timer = new Timer();
		// 创建TimerTask实例
		MyTimerTask task1 = new MyTimerTask("task1");
		MyTimerTask task2 = new MyTimerTask("task2");
		// 获取当前执行时间并打印
		Date startTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("start time is :" + sf.format(startTime));
		// task1首次执行距离现在时间3秒后执行，之后每隔2秒执行一次；
		// task2首次执行距离现在时间1秒后执行，之后每隔2秒执行一次；
		timer.schedule(task1, 3000L, 2000L);
		timer.schedule(task2, 1000L, 2000L);
		System.out.println("current canceled task number is:" + timer.purge());
		// 休眠5秒后执行
		Thread.sleep(5000);
		// 获取当前的执行时间并打印
		Date cancelTime = new Date();
		System.out.println("cancel time is:" + sf.format(cancelTime));
		
		//取消任务2
		task2.cancel();
		System.out.println("current canceled task number is:" + timer.purge());
		// 取消所有任务
		//timer.cancel();
		//System.out.println("Tasks all canceled!");
	}
}
