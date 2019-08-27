package ybb.gof.state;

public class Context {
	private State state;
	
	public Context(State state){
		this.state=state;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
		System.out.println(state.getName()) ; // 输出房子价格  
	}
	public void Request(){
		state.Handle(this);
	}
 
}
