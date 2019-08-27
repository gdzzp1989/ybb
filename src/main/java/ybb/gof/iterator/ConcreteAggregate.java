package ybb.gof.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate{
   private List<Object> items= new ArrayList<Object>();
	
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new ConcreteIterator(this);
	}
	public int count(){
		return items.size();
	}
	public Object getItem(int index){
		// TODO Auto-generated method stub
		return items.get(index);
	}
	public void addItem(Object object){
		items.add(object);
	}

}
