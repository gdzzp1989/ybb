package cn.ybb.gof.facade;
//外观模式//P128
public class Client {

	public static void main(String[] args) {
		Facade facade=new Facade();
		facade.MethodA();
		facade.MethodB();

	}

}
