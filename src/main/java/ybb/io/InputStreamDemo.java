package ybb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

//字节输入流
public class InputStreamDemo {
	public static void main(String[] args) throws Exception {		
		File f=new File("d:"+File.separator+"test.txt");
		InputStream in=new FileInputStream(f);		
		byte b[]=new byte[1024];//开辟1024字节
		//文件不存在抛异常
		int len=in.read(b);
		in.close();
		
		//另一种方法
		/*int len=0;
		int temp=0;
		while((temp=in.read())!=-1){
			b[len]=(byte)temp;
			len++;
		}*/
		
		System.out.println("长度为："+len);
		System.out.println("内容为："+new String(b,0,len));
	}
}
