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
		// 创建一个jobDetail实例，将该实例与HelloJob.class绑定
	JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myjob", "group1").build();
	System.out.println("jobDetail's name:" + jobDetail.getKey().getName());
	System.out.println("jobDetail's group:" + jobDetail.getKey().getGroup()); // 如果未设置group，则默认为DEFAULT
	System.out.println("jobDetail's jobClass:" + jobDetail.getJobClass().getName());
	// 创建一个trigger实例，定义该job立即执行，并且每隔两秒重复执行一次，直到永远
		Trigger trigger = TriggerBuilder.newTrigger()
		.withIdentity("mytrigger", "group1")
		.startNow().withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever()
				).build();
		// 创建Scheduler实例
		StdSchedulerFactory sfact = new StdSchedulerFactory();
		Scheduler scheduler = sfact.getScheduler();
		scheduler.start();
		// 打印当前的时间，格式为2016-11-11 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is :" + sf.format(date));
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
