package com.sudi.study.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob2 implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的时间，格式为2016-11-11 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is :" + sf.format(date));
		JobKey key = context.getJobDetail().getKey();
		System.out.println("My job name and group are :" + key.getName() + ":" 
		+ key.getGroup());
		TriggerKey trKey = context.getTrigger().getKey();
		System.out.println("My trigger name and group are :" + trKey.getName() + ":" 
		+ trKey.getGroup());
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		JobDataMap trDataMap = context.getTrigger().getJobDataMap();
		String jobMsg = dataMap.getString("message");
		float floatJobValue = dataMap.getFloat("FloatJobValue");
		String trJobMsg = trDataMap.getString("message");
		double doubleTriggerValue = trDataMap.getDouble("DoubleTriggerValue");
		System.out.println("jobMsg is:" + jobMsg);
		System.out.println("floatJobValue is:" + floatJobValue);
		System.out.println("trJobMsg is:" + trJobMsg);
		System.out.println("doubleTriggerValue is:" + doubleTriggerValue);
		
		
	}

}
