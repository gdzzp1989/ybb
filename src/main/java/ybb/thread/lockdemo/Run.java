package ybb.thread.lockdemo;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService service=new MyService();
		/*ThreadA a=new ThreadA(service);
		a.start();
		ThreadB b=new ThreadB(service);
		b.start();*/

		
		ThreadA[] a=new ThreadA[10];
		ThreadB[] b=new ThreadB[10];
		for(int i=0;i<10;i++){
			a[i]=new ThreadA(service);
			a[i].start();
			b[i]=new ThreadB(service);
			b[i].start();
		}
	}

}
