package cn.ybb.gof.factorymethod;

public class SubFactory implements IFactory {
	public Operation createOperation(){
		return new OperSub();
	}
}
