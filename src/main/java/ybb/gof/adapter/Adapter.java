package ybb.gof.adapter;

public class Adapter extends Target {
	private Adaptee adaptee = new Adaptee();
	public void Request(){
		adaptee.Request();
	}
}
