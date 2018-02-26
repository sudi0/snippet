package com.sudi.study.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// 打印当前的时间，格式为2016-11-11 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is :" + sf.format(date));
		
	}

}
