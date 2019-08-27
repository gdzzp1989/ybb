package ybb.gof.simplefactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*简单工厂模式:实现了算法和界面的分离，也就是将业务逻辑和界面逻辑分开了，降低了耦合度
工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类
抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。*/

//简单工厂//P21
public class Client {

	public static void main(String[] args) throws ParseException {
		String method="+";
		Operation op= OperFactory.createOpertion(method);
		op.setNumer1(2);
		op.setNumer2(4);
		
		System.out.println(op.cal());
	}
 
}
