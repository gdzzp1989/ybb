package ybb.net;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLDemo {
	public static void main(String[] args) throws Exception {
		URL url=new URL("http","tx3.netease.com",80,"/forum.php");
		
		URLConnection urlCon = url.openConnection();
		
		System.out.println(urlCon.getContentLength());
		System.out.println(urlCon.getContentType());
		
		InputStream input=url.openStream();
		Scanner scan =new Scanner(input);
		scan.useDelimiter("\n"); //设置读取分隔符
		while(scan.hasNext()){
			System.out.println(scan.next());
		}
	}
}
