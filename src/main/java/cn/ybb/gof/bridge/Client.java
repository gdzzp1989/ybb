package cn.ybb.gof.bridge;
//桥接模式//P246
public class Client {

	public static void main(String[] args) {
		Abstraction ab=new RefinedAbstraction();
		ab.setImplementor(new ConcreteImplementorA());
		ab.opertion();
		ab.setImplementor(new ConcreteImplementorB());
		ab.opertion();


	}

}
