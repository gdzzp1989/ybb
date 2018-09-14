package cn.ybb.gof.decorator;

public class ConcreteDecoratorA extends Decoator {
	@Override
	public void operation() {
		super.operation();
		AAA();
		System.out.println("ConcreteDecoratorA is operating");		
	}
	public void AAA() {
		System.out.println("AAA 自定义操作");		
	}


}
