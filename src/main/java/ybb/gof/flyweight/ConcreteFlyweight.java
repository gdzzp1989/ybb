package ybb.gof.flyweight;

public class ConcreteFlyweight extends Flyweight{

	@Override
	public void opertion(int extrinsicstate) {
		System.out.println("具体的Flyweight=="+extrinsicstate);
		
	}

}
