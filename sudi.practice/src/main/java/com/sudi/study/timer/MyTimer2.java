package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer2 {
	public static void main(String[] args) {
		// 1����һ��timerʵ��
		Timer timer = new Timer();
		// 2����һ��MyTimerTaskʵ��
		MyTimerTask2 myTimerTask1 = new MyTimerTask2("No.1", 2000L);
		MyTimerTask2 myTimerTask2 = new MyTimerTask2("No.2", 2000L);
		// 3ͨ��timer��ʱ��Ƶ�ʵ���myTimerTask��ҵ���߼�
		// ����һ��ִ���ǵ�ǰʱ�������֮��֮��ÿ��һ��ִ��һ��
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��ӡ��ǰ��ʱ��
		System.out.println("current exec time is:" + sf.format(calendar.getTime()));
		//timer.schedule(myTimerTask1, calendar.getTime());
		//timer.schedule(myTimerTask2, calendar.getTime());
		timer.scheduleAtFixedRate(myTimerTask1, calendar.getTime() ,2000L);
		timer.scheduleAtFixedRate(myTimerTask2, calendar.getTime() ,2000L);
	}
}
