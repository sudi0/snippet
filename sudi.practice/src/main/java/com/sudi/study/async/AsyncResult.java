package com.sudi.study.async;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.xml.internal.ws.api.message.Message;

public class AsyncResult {

	private byte[] result_;
	private AtomicBoolean done_ = new AtomicBoolean(false);
	private Lock lock_ = new ReentrantLock();
	private Condition condition_;
	private long startTime_;
	public AsyncResult() {
		condition_ = lock_.newCondition();
		startTime_ = System.currentTimeMillis();
	}
	/**检查需要的数据是否已经返回，如果没有返回,阻塞*/
	public byte[] get() {
		lock_.lock();
		try {
			if (!done_.get()) {condition_.await();}
		} catch (InterruptedException ex) {
			throw new AssertionError(ex);
		}finally {
			lock_.unlock();
		}
		return result_;
	}
	/**检查需要的数据是否已经返回*/
	public boolean isDone() {return done_.get();}
	/**检查在指定的时间内需要的数据是否已经返回，如果没有返回，跑出超时异常
	 * @throws TimeoutException */
	public byte[] get(long timeout, TimeUnit tu) throws TimeoutException {
		lock_.lock();
		try {
			boolean bVal = true;
			try {
				if (!done_.get()) {
					long overall_timeout = timeout - (System.currentTimeMillis()-startTime_);
					if (overall_timeout > 0) { // 设置等待超时的时间
						bVal = condition_.await(overall_timeout, TimeUnit.MILLISECONDS);
					}else {
						bVal = false;
					}
				}
			} catch (InterruptedException e) {
				throw new AssertionError(e);
			}
			if (!bVal && !done_.get()) { // 抛出超时异常
				throw new TimeoutException("Operation timed out.");
				}
			
		}finally {
			lock_.unlock();
		}
		return result_;
		}
	/**该函数供另外一个线程设置要返回的数据，并唤醒在阻塞的线程*/
	public void result(Message response) {
		try {
			lock_.lock();
			if (!done_.get()) {
				//response.getDocument(); 获取不到正确的message对象
				done_.set(true);
				condition_.signal(); // 唤醒阻塞的线程
			}
		} finally {
			lock_.unlock();
		}
	}
}
