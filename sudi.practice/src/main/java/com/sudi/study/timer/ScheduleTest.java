package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTest {

	public static void main(String[] args) {
		// �涨ʱ���ʽ
		final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��ȡ��ǰ�ľ���ʱ��
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current time is :" + sf.format(calendar.getTime()));
		// ���ó�6��ǰ��ʱ�䣬����ǰʱ����2016-12-28 00:00:06
		// ��ô����֮���ʱ����2016-12-28 00:00:00
		//calendar.add(Calendar.SECOND, -6);
		Timer timer = new Timer();
		// ��һ��ִ��ʱ��Ϊ6��ǰ��֮��ÿ������ִ��һ��
		timer.scheduleAtFixedRate(new TimerTask() {
			//timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//��ӡ���һ�εļƻ�ִ��ʱ��
				System.out.println("scheduled exec time is:" + sf.format(scheduledExecutionTime()));
				System.out.println("Task executes!");
				// ��ӡ��ǰ�ļƻ�ִ��ʱ��
				//System.out.println("Scheduled exec time is" + sf.format(scheduledExecutionTime()));
				//System.out.println("Task is being execued!");
			}
		}, calendar.getTime(), 2000L);
	}
}
