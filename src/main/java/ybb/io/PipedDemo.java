package ybb.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//管道流
class Send implements Runnable{
	private PipedOutputStream pos=new PipedOutputStream();
	
	public PipedOutputStream getPos(){
		return pos;
	}
	
	public void run(){
		String str="Hello World";
		try{
			this.pos.write(str.getBytes());
			this.pos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
	
class Receive implements Runnable{
	private PipedInputStream pis=new PipedInputStream();
	
	public PipedInputStream getPis(){
		return pis;
	}
	
	public void run(){
		byte b[]=new byte[1024];
		int len=0;				
		try{
			len=this.pis.read(b);
			this.pis.close();
		}catch(IOException e){
			e.printStackTrace();
		}			
		System.out.println("内容为："+new String(b,0,len));
	}		
}

public class PipedDemo {
	public static void main(String[] args) {
		Send s=new Send();
		Receive r =new Receive();
		try{
			s.getPos().connect(r.getPis());//连接管道
		}catch(IOException e){
			e.printStackTrace();
		}
		new Thread(s).start();
		new Thread(r).start();
	}
}
