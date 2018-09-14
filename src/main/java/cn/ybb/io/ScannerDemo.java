package cn.ybb.io;

import java.util.Scanner;

//键盘输入标准代码
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("请输入内容：");
		String str=scan.next();
		//可用hasNextXXX对数据进行验证
		System.out.println("输入内容为："+str);
	}
}
