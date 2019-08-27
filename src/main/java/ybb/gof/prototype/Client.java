package ybb.gof.prototype;
//原型模式//P101
public class Client {

	public static void main(String[] args) {
		ConcretePrototype c1 = new ConcretePrototype("a","AAAA");
		ConcretePrototype c2 = (ConcretePrototype)c1.Clone();
		System.out.println(c1.getId()+"---"+c1.getName());
		c2.setName("AAAAAAA");
		System.out.println(c2.getId()+"---"+c2.getName());

	}

}
