package cn.ybb.gof.command;

public class Invoker {
   private Command command;
	public Command getCommand() {
		return command;
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void executeCommand() {
		System.out.println("记录执行请求");
		command.execute();
	}
 
}
