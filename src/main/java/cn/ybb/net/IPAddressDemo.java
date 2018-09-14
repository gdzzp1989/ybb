package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress loc=InetAddress.getLocalHost();
		InetAddress rem=InetAddress.getByName("www.baidu.com");
		System.out.println(loc.getHostAddress());
		System.out.println(rem.getHostAddress());
	}
}
