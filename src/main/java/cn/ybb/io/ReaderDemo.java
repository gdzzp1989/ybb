package cn.ybb.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

//字符输入流
public class ReaderDemo {
	public static void main(String[] args) throws Exception {		
		File f=new File("d:"+File.separator+"test.txt");
		Reader reader=new FileReader(f);		
		char c[]=new char[1024];//开辟1024字节
		//文件不存在抛异常
		int len=reader.read(c);
		reader.close();
		
		//另一种方法
		/*int len=0;
		int temp=0;
		while((temp=reader.read())!=-1){
			c[len]=(char)temp;
			len++;
		}*/
		
		System.out.println("长度为："+len);
		System.out.println("内容为："+new String(c,0,len));
	}
}
