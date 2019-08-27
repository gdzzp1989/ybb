package ybb.gof.state;

public class ConcreteStateA extends State{
	
	public  ConcreteStateA() {
		setName("ConcreteStateA");
	}

	@Override
	public void Handle(Context context) {
		context.setState(new ConcreteStateB());//设置A的下一状态是B
		
	}

}
