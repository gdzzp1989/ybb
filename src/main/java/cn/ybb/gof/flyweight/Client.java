package cn.ybb.gof.flyweight;
//享元模式//P293
public class Client {

	public static void main(String[] args) {

		int extrinsicstate=22;
		FlyweightFactory f=new FlyweightFactory();
		
		Flyweight fx=f.getFlyweight("X");
		fx.opertion(--extrinsicstate);
		Flyweight fy=f.getFlyweight("Y");
		fy.opertion(--extrinsicstate);
		Flyweight fz=f.getFlyweight("Z");
		fz.opertion(--extrinsicstate);
		
		UnsharedConcreteFlyweight uf=new UnsharedConcreteFlyweight();
		uf.opertion(--extrinsicstate);


	}

}
