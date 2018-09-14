package cn.ybb.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {  
    public static void main(String[] args) {  
        ExecutorService exec=Executors.newCachedThreadPool();
         Mythread my=new Mythread();
        for(int i=0;i<5;i++) {
        	exec.execute(my); 
        }             
        exec.shutdown();//并不是终止线程的运行，而是禁止在这个Executor中添加新的任务  
        
    }  
}
