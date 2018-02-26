package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class CancelTest {

	public static void main(String[] args) throws InterruptedException {
		// ����Timerʵ��
		Timer timer = new Timer();
		// ����TimerTaskʵ��
		MyTimerTask task1 = new MyTimerTask("task1");
		MyTimerTask task2 = new MyTimerTask("task2");
		// ��ȡ��ǰִ��ʱ�䲢��ӡ
		Date startTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("start time is :" + sf.format(startTime));
		// task1�״�ִ�о�������ʱ��3���ִ�У�֮��ÿ��2��ִ��һ�Σ�
		// task2�״�ִ�о�������ʱ��1���ִ�У�֮��ÿ��2��ִ��һ�Σ�
		timer.schedule(task1, 3000L, 2000L);
		timer.schedule(task2, 1000L, 2000L);
		System.out.println("current canceled task number is:" + timer.purge());
		// ����5���ִ��
		Thread.sleep(5000);
		// ��ȡ��ǰ��ִ��ʱ�䲢��ӡ
		Date cancelTime = new Date();
		System.out.println("cancel time is:" + sf.format(cancelTime));
		
		//ȡ������2
		task2.cancel();
		System.out.println("current canceled task number is:" + timer.purge());
		// ȡ����������
		//timer.cancel();
		//System.out.println("Tasks all canceled!");
	}
}
