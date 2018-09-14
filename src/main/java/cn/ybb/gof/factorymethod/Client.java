package cn.ybb.gof.factorymethod;
//工厂方法模式//p90
public class Client {

	public static void main(String[] args) {
		IFactory operfactory =new AddFactory();
		Operation op= operfactory.createOperation();
		op.setNumer1(2);
		op.setNumer2(4);
		System.out.println(op.cal());
	}

}
