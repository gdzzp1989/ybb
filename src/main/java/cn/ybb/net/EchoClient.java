package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
//TCP协议  实例
public class EchoClient {
	public static void main(String[] args) throws Exception {
		Socket client=new Socket("localhost",8888);
		BufferedReader buf=null;
		PrintStream out=null;
		BufferedReader input=null;
		
		input=new BufferedReader(new InputStreamReader(System.in));
		out=new PrintStream(client.getOutputStream());//向服务器输入消息
		buf=new BufferedReader(new InputStreamReader(client.getInputStream()));//接收服务端发送的消息
		
	    boolean flag=true;
		while(flag){//不断发送和接收消息
			System.out.print("输入信息：");
			String str=input.readLine();
			out.println(str);//向服务器输入消息
			if("bye".equals(str)){
				flag=false;
			}else{
				String echo=buf.readLine();//接收消息
				System.out.println(echo);
			}
		}
		client.close();
		buf.close();
	}
}
