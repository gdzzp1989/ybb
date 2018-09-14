package cn.ybb.thread.lockdemo;

public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		this.service = service;
	}
	public void run(){
		for(int i=0;i<10;i++){
			service.get();
		}
	}
}
