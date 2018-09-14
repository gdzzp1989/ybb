package cn.ybb.gof.adapter;
//适配器模式//P189
public class Client {

	public static void main(String[] args) {
		 Target  target=new Adapter();
		 target.Request();
	}

}
