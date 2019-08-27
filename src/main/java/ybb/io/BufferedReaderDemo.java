package ybb.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//键盘输入标准代码
public class BufferedReaderDemo {
	public static void main(String[] args) {
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		System.out.print("请输入内容：");
		try {
			str=buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("输入内容为："+str);
	}
}
