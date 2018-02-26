package com.sudi.study.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException {
		// ����һ��jobDetailʵ��������ʵ����HelloJob.class��
	JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myjob", "group1").build();
	System.out.println("jobDetail's name:" + jobDetail.getKey().getName());
	System.out.println("jobDetail's group:" + jobDetail.getKey().getGroup()); // ���δ����group����Ĭ��ΪDEFAULT
	System.out.println("jobDetail's jobClass:" + jobDetail.getJobClass().getName());
	// ����һ��triggerʵ���������job����ִ�У�����ÿ�������ظ�ִ��һ�Σ�ֱ����Զ
		Trigger trigger = TriggerBuilder.newTrigger()
		.withIdentity("mytrigger", "group1")
		.startNow().withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever()
				).build();
		// ����Schedulerʵ��
		StdSchedulerFactory sfact = new StdSchedulerFactory();
		Scheduler scheduler = sfact.getScheduler();
		scheduler.start();
		// ��ӡ��ǰ��ʱ�䣬��ʽΪ2016-11-11 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is :" + sf.format(date));
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
