package cn.ybb.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

//字节输出流
public class OutputStreamDemo {
	public static void main(String[] args) throws Exception {
		//文件不存在自动创建
		File f=new File("d:"+File.separator+"test.txt");
		OutputStream out=new FileOutputStream(f);		
		//OutputStream out=new FileOutputStream(f,true);
		//true表示在结尾增加内容 \r\n换行	
		String str="Hello World";
		byte b[]=str.getBytes();
		out.write(b);
		out.close();
	}
}
