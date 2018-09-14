package cn.ybb.gof.observer;

public class ConcreteObserver extends Observer {
    private String name;
    private String observerstate;
    private ConcreteSubject subject;
    
	public ConcreteSubject getSubject() {
		return subject;
	}
	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}

	public ConcreteObserver (ConcreteSubject subject, String name){
		this.subject=subject;
		this.name=name;
		
	}
	public void update() {
		observerstate=subject.getSubjectstate();
		System.out.println("观察者"+name+"看到新状态 是==:"+observerstate);
		
	}

}
