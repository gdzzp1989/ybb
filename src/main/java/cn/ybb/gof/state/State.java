package cn.ybb.gof.state;

public abstract class State {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void Handle(Context context);

}
