package ybb.thread;

public class NotifyTest {
	private String[] flag = {"false"};

	class MainThread extends Thread {
		public MainThread(String name) {
			super(name);
		}

		public void run() {
			
			synchronized (flag) {
				for(int i=0;i<10;i++){
				
				if (flag[0] != "true") {
					try {
						flag.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=0;j<1;j++){
				 System.out.println(Thread.currentThread().getName()+" "+j);
				}
				flag[0] = "false";
				flag.notify();
				}
			}
		}
	};

	class SubThread extends Thread {
		public SubThread(String name) {
			super(name);
		}

		public void run() {
			synchronized (flag) {
				for(int i=0;i<10;i++){
				
				if (flag[0] != "false") {
					try {
						flag.wait();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=0;j<2;j++){
					 System.out.println(Thread.currentThread().getName()+" "+j);
					}
				flag[0] = "true";
				flag.notify();
			}
			}
		}
	};

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Begin!");
		NotifyTest test = new NotifyTest();
		MainThread mainThread = test.new MainThread("mainThread");
		SubThread subThread = test.new SubThread("subThread");
		mainThread.start();
		subThread.start();

	}

}