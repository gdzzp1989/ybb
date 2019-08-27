package ybb.gof.visitor;

public class ConcreteVisitor2 extends Visitor{

	@Override
	public void VisitConcreteElementA(ConcreteElementA concreteElementA) {
		// TODO Auto-generated method stub
		System.out.println("ConcreteElementA 被 ConcreteVisitor2 访问");
	}

	@Override
	public void VisitConcreteElementB(ConcreteElementB concreteElementB) {
		// TODO Auto-generated method stub
		System.out.println("ConcreteElementB 被 ConcreteVisitor2 访问");
	}

}
