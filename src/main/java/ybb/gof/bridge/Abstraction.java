package ybb.gof.bridge;

public class Abstraction {
	 protected Implementor implementor;

	public Implementor getImplementor() {
		return implementor;
	}

	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}
	 
	public void opertion(){
		implementor.operation();
	}

}
