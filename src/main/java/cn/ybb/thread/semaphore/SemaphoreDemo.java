package cn.ybb.thread.semaphore;



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	// 排队总人数（请求总数）
	public static int clientTotal = 10;

	// 可同时受理业务的窗口数量（同时并发执行的线程数）
	public static int threadTotal = 2;

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			final int count = i;
			executorService.execute(() -> {
				try {
					semaphore.acquire(2);//获取2个许可,所以最多有1个线程
					resolve(count);
					semaphore.release(2);//释放2个许可
				} catch (Exception e) {
					System.out.println(e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
	}

	private static void resolve(int i) throws InterruptedException {
		System.out.println("服务号{"+i+"}，受理业务中。。。");
		Thread.sleep(5000);
	}
}
