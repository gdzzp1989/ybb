package ybb.gof.factorymethod;

public class AddFactory implements IFactory {
	public Operation createOperation(){
		return new OperAdd();
	}
}
