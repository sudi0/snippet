package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{

	public MyTimerTask(String inputName) {
		name = inputName;
	}
	private String name;
	private Integer count = 0;
		
	@Override
	public void run() {
		if (count < 3) {
		// ��yyyy-MM-dd HH:mm:ss�ĸ�ʽ��ӡ��ǰִ��ʱ��
		// ��2016-11-11 00:00:00
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��ӡ��ǰ��ʱ��
		System.out.println("Current exec time is:" + sf.format(calendar.getTime()));
		// ��ӡ��ǰname����ֵ
		System.out.println("Current exec name is :" + name);	
		count ++;
		}else{
		cancel();
		System.out.println("Task Cancel!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
