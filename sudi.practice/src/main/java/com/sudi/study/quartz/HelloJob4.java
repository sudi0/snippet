package com.sudi.study.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob4 implements Job{
	private String message;
	private Float floatJobValue;
	private Double doubleTriggerValue;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Float getFloatJobValue() {
		return floatJobValue;
	}

	public void setFloatJobValue(Float floatJobValue) {
		this.floatJobValue = floatJobValue;
	}

	public Double getDoubleTriggerValue() {
		return doubleTriggerValue;
	}

	public void setDoubleTriggerValue(Double doubleTriggerValue) {
		this.doubleTriggerValue = doubleTriggerValue;
	}

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
		System.out.println("jobMsg is:" + message);
		System.out.println("floatJobValue is:" + floatJobValue);
		System.out.println("doubleTriggerValue is:" + doubleTriggerValue);
		
		
	}

}
