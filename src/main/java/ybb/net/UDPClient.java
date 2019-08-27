package ybb.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {
	public static void main(String[] args) throws Exception{
        DatagramSocket ds=null;
        byte[] buf=new byte[1024];
        DatagramPacket dp=null;
        
        ds=new DatagramSocket(9000);
        dp=new DatagramPacket(buf, 1024);//指定接收数据长度为1024
        
        System.out.println("等待接收数据");
        ds.receive(dp);
        String msg=new String(dp.getData(), 0, dp.getLength());
        System.out.println(dp.getAddress()+"/"+dp.getPort()+":"+msg);
        ds.close();
     }
}
