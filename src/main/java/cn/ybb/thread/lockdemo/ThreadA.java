package cn.ybb.thread.lockdemo;

public class ThreadA extends Thread {

	private MyService service;

	public ThreadA(MyService service) {
		this.service = service;
	}
	public void run(){
		for(int i=0;i<10;i++){
			service.set();
		}
	}
}
