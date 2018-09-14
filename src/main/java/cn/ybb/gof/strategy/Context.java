package cn.ybb.gof.strategy;

public class Context {
	Strategy strategy;

	public  Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void ContextInterface() {
		strategy.algorithmInterface();
	}
	
	
	
}
