package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask2 extends TimerTask{

	private String name;
	private long costTime;
	public MyTimerTask2(String inputName,long inputCostTime) {
		name = inputName;
		costTime = inputCostTime;
	}
	
		
	@Override
	public void run() {
	
		// 以yyyy-MM-dd HH:mm:ss的格式打印当前执行时间
		// 如2016-11-11 00:00:00
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 打印当前的时间
		System.out.println(name+"'s current exec time is:" + sf.format(calendar.getTime()));	
		try {
			Thread.sleep(costTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"'s finish time is:" + sf.format(calendar.getTime()));
		throw new RuntimeException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
