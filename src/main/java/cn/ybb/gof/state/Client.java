package cn.ybb.gof.state;
//状态模式//P176
public class Client {

	public static void main(String[] args) {
		Context c =new Context(new ConcreteStateA());
		c.Request();
		c.Request();
		c.Request();
		c.Request();
		
	}

}
