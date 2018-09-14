package cn.ybb.gof.visitor;
//访问者模式//P317
public class Client {

	public static void main(String[] args) {
		ObjectStructure o=new ObjectStructure();
		o.Attach(new ConcreteElementA());
		o.Attach(new ConcreteElementB());
		
		ConcreteVisitor1 v1=new ConcreteVisitor1();
		ConcreteVisitor2 v2=new ConcreteVisitor2();
        o.Accept(v1);
        o.Accept(v2);
	}

}
