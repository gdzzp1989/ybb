package cn.ybb.gof.templatemethod;
//模版方法模式//P115
public class Client {
	public static void main(String[] args) {
		AbstractClass c;
		c=new ConcreteClassA();
		c.TemplateMethod();
		
		c=new ConcreteClassB();
		c.TemplateMethod();
	}

}
