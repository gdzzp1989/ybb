package cn.ybb.gof.facade;

public class Facade {
	SubSystem1 ss1;
	SubSystem2 ss2;
	public Facade(){
		ss1=new SubSystem1();
		ss2=new SubSystem2();		
	}
	
	
	public void MethodA(){
		System.out.println("方法组A");	
		ss1.Method1();
		ss2.Method2();
		ss1.Method1();
		
	}
	public void MethodB(){
		System.out.println("方法组B");	
		ss2.Method2();
		ss1.Method1();
		ss2.Method2();

	}
}
