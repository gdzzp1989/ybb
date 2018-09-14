package cn.ybb.gof.visitor;

public class ConcreteElementA extends Element{

	@Override
	public void Accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.VisitConcreteElementA(this);
	}
	
	public void opertion(){
		
	}

}
