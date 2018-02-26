package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer2 {
	public static void main(String[] args) {
		// 1创建一个timer实例
		Timer timer = new Timer();
		// 2创建一个MyTimerTask实例
		MyTimerTask2 myTimerTask1 = new MyTimerTask2("No.1", 2000L);
		MyTimerTask2 myTimerTask2 = new MyTimerTask2("No.2", 2000L);
		// 3通过timer定时定频率调用myTimerTask的业务逻辑
		// 即第一次执行是当前时间的两秒之后，之后每隔一秒执行一次
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 打印当前的时间
		System.out.println("current exec time is:" + sf.format(calendar.getTime()));
		//timer.schedule(myTimerTask1, calendar.getTime());
		//timer.schedule(myTimerTask2, calendar.getTime());
		timer.scheduleAtFixedRate(myTimerTask1, calendar.getTime() ,2000L);
		timer.scheduleAtFixedRate(myTimerTask2, calendar.getTime() ,2000L);
	}
}
