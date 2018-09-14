package cn.ybb.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//输出重定向
public class SystemOutDemo {
	public static void main(String[] args) {
		String str="hello";
		try{
			System.out.println(Integer.parseInt(str));
		}catch(Exception e){
			try{
				System.setOut(new PrintStream(new FileOutputStream("d:"+File.separator+"log.txt")));;
			}catch(FileNotFoundException ex){
				ex.printStackTrace();
			}
			System.out.println(e);//重定向输出到了配置文件
		}
	}
}
