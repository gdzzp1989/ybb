package ybb.gof.strategy;
//策略模式//P38
public class Client {

	public static void main(String[] args) {
		Context context=new Context(new ConcreteStrategy());
		context.ContextInterface();
	}

}
