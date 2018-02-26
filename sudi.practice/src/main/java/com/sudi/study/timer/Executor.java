package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class Executor {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//获取当前时间
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 打印当前的时间
		System.out.println("Current exec time is:" + sf.format(calendar.getTime()));
		
		DacingRobot dr = new DacingRobot();
		WaterRobot wr = new WaterRobot(timer);
		
		timer.scheduleAtFixedRate(dr, calendar.getTime(), 2000L);
		timer.scheduleAtFixedRate(wr, calendar.getTime(), 1000L);
		
	}
}
 	