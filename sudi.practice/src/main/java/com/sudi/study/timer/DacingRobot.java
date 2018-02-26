package com.sudi.study.timer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

public class DacingRobot extends TimerTask{

	@Override
	public void run() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("schedule exec time is:" + sf.format(scheduledExecutionTime()));
		System.out.println("Dancing happliy!");
		
	}

}
