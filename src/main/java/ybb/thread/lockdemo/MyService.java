package ybb.thread.lockdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue=false;
	
	public void set() {
		try {
			lock.lock();
			while(hasValue==true){
				//System.out.println("连续生产");
				condition.await();
			}
			System.out.println("生产");
			hasValue=true;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//System.out.println("释放set锁");
			lock.unlock();
		}
	}

	public void get() {
		try {
			lock.lock();
			while(hasValue==false){
				//System.out.println("连续消費");
				condition.await();
			}
			System.out.println("消費");
			hasValue=false;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//System.out.println("释放get锁");
			lock.unlock();
		}
	}

}
