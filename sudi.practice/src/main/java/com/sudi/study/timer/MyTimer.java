package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer {
	public static void main(String[] args) {
		// 1����һ��timerʵ��
		Timer timer = new Timer();
		// 2����һ��MyTimerTaskʵ��
		MyTimerTask myTimerTask = new MyTimerTask("No.1");
		// 3ͨ��timer��ʱ��Ƶ�ʵ���myTimerTask��ҵ���߼�
		// ����һ��ִ���ǵ�ǰʱ�������֮��֮��ÿ��һ��ִ��һ��
		//timer.scheduleAtFixedRate(myTimerTask, 2000L, 1000L);
		
		/**
		 * ��ȡ��ǰʱ�䣬�����óɾ��뵱ǰʱ������֮���ʱ��
		 * �統ǰʱ����2016-11-10 23:59:57
		 * �����ú��ʱ����2016-11-11 00:00:00
		 */
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(calendar.getTime()));
		calendar.add(Calendar.SECOND, 3);
		//scheduledExecutionTime�÷�
		myTimerTask.setName("schedule");
		timer.schedule(myTimerTask, 3000L);
		System.out.println("schedule time is" 
		+ sf.format(myTimerTask.scheduledExecutionTime()));
		// schedule�÷�
		/**
		 * 1��ʱ����ڻ򳬹�time��ʱ��ִ����ִֻ��һ��task
		 * ����2016-11-11 00:00:00ִ��һ��task����ӡ���������
		 */
		//myTimerTask.setName("schedule1");
		//timer.schedule(myTimerTask, calendar.getTime());
		/**
		 * 2ʱ����ڻ򳬹�timeʱ�״�ִ��task
		 * ֮��ÿ��period����ִ��һ������task:��ӡ���������
		 * ֮��ÿ��2��ִ��һ��task
		 */
		//myTimerTask.setName("schedule2");
		//timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000L);
		/**
		 * 3�ȵ�delay�����ִ����ִ��һ��task
		 * ������2016-11-11 00:00:00
		 * ����2016-11-11 00:00:01ִ��һ��task����ӡ��������
		 */
		//myTimerTask.setName("schedule3");
		//timer.schedule(myTimerTask, 1000L);
		/**
		 * 4�ȴ�delay�����״�ִ��task
		 * ֮��ÿ��period�����ظ�ִ��һ��task
		 * ��������2016-11-11 00:00:00
		 * ����2016-11-11 00:00:01��һ��ִ��task:��ӡ��������
		 * ֮��ÿ������ִ��һ��task
		 */
		//myTimerTask.setName("schedule4");
		//timer.schedule(myTimerTask, 1000L, 2000L);
		
		//scheduleAtFixedRate���÷�
		/**
		 * 1ʱ����ڻ򳬹�timeʱ�״�ִ��task
		 * ֮��ÿ��period����ִ��һ������task:��ӡ���������
		 * ����2016-11-11 00:00:01��һ��ִ��task:��ӡ��������
		 * ֮��ÿ��2��ִ��һ��task
		 */
		//myTimerTask.setName("scheduleAtFixedRate1");
		//timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000L);
		/**
		 * 2�ȴ�delay������״�ִ��task
		 * ֮��ÿ��period�����ظ�ִ��һ��task
		 * ��������2016-11-11 00:00:00
		 * ����2016-11-11 00:00:01��һ��ִ��task:��ӡ��������
		 * ֮��ÿ������ִ��һ��task
		 */
		//myTimerTask.setName("scheduleAtFixedRate2");
		//timer.schedule(myTimerTask, 3000L,2000L);
	}
}
