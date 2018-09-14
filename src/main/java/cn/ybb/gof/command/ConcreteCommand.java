package cn.ybb.gof.command;

public class ConcreteCommand extends Command{
	
	public ConcreteCommand(Receiver receiver){		
		super(receiver);	
	}

	@Override
	public void execute() {
		receiver.Action();	
	}
}
