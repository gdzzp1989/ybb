package cn.ybb.gof.decorator;

public class ConcreteDecoratorB extends Decoator{
	@Override
	public void operation() {
		super.operation();
		BBB() ;
		System.out.println("ConcreteDecoratorB is operating");		
	}
	public void BBB() {
		System.out.println("BBB 自定义操作");		
	}

}
