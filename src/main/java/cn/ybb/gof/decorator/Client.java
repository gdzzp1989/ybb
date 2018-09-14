package cn.ybb.gof.decorator;
//装饰者//P66
public class Client {

	public static void main(String[] args) {
		ConcreteComponent c=new ConcreteComponent();
		ConcreteDecoratorA da=new ConcreteDecoratorA();
		ConcreteDecoratorB db=new ConcreteDecoratorB();
		da.setComponent(c);
		db.setComponent(da);
		db.operation();
	}

}
