package cn.ybb.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 不推荐使用Executors这种方式创建线程池
FixedThreadPool 和  SingleThread : 允许的请求队列长度为 Integer.MAX_VALUE，可 能会堆积大量的请求，从而导致 OOM
CachedThreadPool 和  ScheduledThreadPool : 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
*/
public class CacheThreadPool {  
    public static void main(String[] args) {  
        //ExecutorService exec=Executors.newCachedThreadPool();
    	ExecutorService exec=new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

         Mythread my=new Mythread();
        for(int i=0;i<5;i++) {
        	exec.execute(my); 
        }             
        exec.shutdown();//并不是终止线程的运行，而是禁止在这个Executor中添加新的任务  
        
    }  
}
