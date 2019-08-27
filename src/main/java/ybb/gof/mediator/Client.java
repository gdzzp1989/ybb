package ybb.gof.mediator;
//中介者模式//P283
public class Client {

	public static void main(String[] args) {
		ConcreteMediator m =new ConcreteMediator();
		
		ConcreteColleague1 c1=new ConcreteColleague1(m);
		ConcreteColleague2 c2=new ConcreteColleague2(m);
		
		m.setColleague1(c1);
		m.setColleague2(c2);
		
		c1.Send("吃饭了没");
		c2.Send("吃了，你吃了嘛");



	}

}
