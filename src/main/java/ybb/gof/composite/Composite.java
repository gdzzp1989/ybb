package ybb.gof.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite  extends Component{
	
	private List<Component> children =new ArrayList<Component>();

	public Composite(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Add(Component c) {
		children.add(c);
		
	}

	@Override
	public void Remove(Component c) {
		children.remove(c);
		
	}

	@Override
	public void Display(int depth) {
		System.out.println("-"+depth+" "+name);
		Iterator it=children.iterator();
		while(it.hasNext()){
			((Component)it.next()).Display(depth+1);
		}
		
	}

}
