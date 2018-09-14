package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable{
	private Socket client = null;
	public EchoThread(Socket client){
		this.client=client;
	}
	
	@Override
	public void run() {
		PrintStream out = null;
		BufferedReader buf = null;
		try{
			buf=new BufferedReader(new InputStreamReader(client.getInputStream()));//得到客户端输入信息
			out=new PrintStream(client.getOutputStream());
			boolean flag=true;
			while(flag){
				String str=buf.readLine();
				if(str==null||"".equals(str)){
					flag=false;
				}else{
					if("bye".equals(str)){
						flag=false;
					}else{
						out.println("Echo "+str);//向客户端回显信息
					}
					
				}
			}
			out.close();
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
