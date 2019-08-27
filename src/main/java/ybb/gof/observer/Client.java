package ybb.gof.observer;
//观察者模式//P141
public class Client {

	public static void main(String[] args) {
		ConcreteSubject s=new ConcreteSubject();
		s.add(new ConcreteObserver(s,"X"));
		s.add(new ConcreteObserver(s,"Y"));
		
		s.setSubjectstate("change");
		s.notifyob();
	}

}
