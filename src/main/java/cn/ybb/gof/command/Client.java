package cn.ybb.gof.command;
//命令模式//P260
public class Client {

	public static void main(String[] args) {
		Receiver r = new Receiver();
		Command c = new ConcreteCommand(r);
		Invoker i=new Invoker();
		i.setCommand(c);
		i.executeCommand();


	}

}
