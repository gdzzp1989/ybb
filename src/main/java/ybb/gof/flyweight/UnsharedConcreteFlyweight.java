package ybb.gof.flyweight;

public class UnsharedConcreteFlyweight extends Flyweight{

	@Override
	public void opertion(int extrinsicstate) {
		System.out.println("不共享的具体的Flyweight=="+extrinsicstate);		
	}

}
