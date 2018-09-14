package net;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server=null;
		Socket client=null;
		
		server=new ServerSocket(8888);
		boolean f=true;
		while(f){//无限制接受客户端连接
			System.out.println("服务器运行，等待客户端连接");
			client=server.accept();//接受客户端连接
			new Thread(new EchoThread(client)).start();
		}
		
		server.close();
	}
}
