package ybb.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds=null;
		DatagramPacket dp=null;
		 
		ds=new DatagramSocket(3000);//服务器在3000端口监听
		String str="hello";
		
		dp=new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),9000);  
		System.out.println("发送消息");
		ds.send(dp);
		ds.close();

	}

}
