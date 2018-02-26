package com.sudi.study.timer;

import java.util.Timer;
import java.util.TimerTask;

public class WaterRobot extends TimerTask{
	private Timer timer;
	
	// �������Ϊ5L
	private Integer bucketCapacity = 0;
	
	public WaterRobot(Timer inputTimer) {
		timer = inputTimer;
	}
	@Override
	public void run() {
		// ��ˮֱ��Ͱ��Ϊֹ
		if (bucketCapacity > 5) {
		System.out.println("Add 1L water into the bucket!");
		bucketCapacity++;
		}else {
			// ˮ��֮���ִֹͣ��
			cancel();
			System.out.println("The waterRobot has been aborted");
			System.out.println("The number of canceled task in timer is:" + timer.purge());
			System.out.println("Current water is:" + bucketCapacity + "L");
			//�ȴ����룬��ֹtimer�������������
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timer.cancel();
		}
	}

}
