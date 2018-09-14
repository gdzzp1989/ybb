package cn.ybb.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//字符输出流
public class WriterDemo {

	public static void main(String[] args) throws IOException {
		//文件不存在自动创建
		File f=new File("d:"+File.separator+"test.txt");
		Writer out=new FileWriter(f);
		//Writer out=new FileWriter(f,true);
		//true表示在结尾增加内容
		String str="Hello World";
		out.write(str);
		out.close();
	}
}
