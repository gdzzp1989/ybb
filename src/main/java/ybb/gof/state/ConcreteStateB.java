package ybb.gof.state;

public class ConcreteStateB  extends State{
	
	public ConcreteStateB() {
		setName("ConcreteStateB");
	}
	@Override
	public void Handle(Context context) {
		context.setState(new ConcreteStateA());//设置B的下一状态是A
		
	}
}
