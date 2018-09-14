package cn.ybb.gof.decorator;

public abstract class Decoator extends Component {
	protected Component component;

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	
	@Override
	public void operation() {
		if(component!=null)
			component.operation();	
	}

}
