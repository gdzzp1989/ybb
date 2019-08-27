package ybb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

//输入重定向
public class SystemInDemo {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("d:"+File.separator+"log.txt"));
		InputStream input=System.in;
		byte b[]=new byte[1024];
		int len=input.read(b);
		System.out.println("内容为："+new String(b,0,len));
		input.close();
	}
}
