package cn.ybb.gof.iterator;

public class ConcreteIterator extends Iterator{
	
	private ConcreteAggregate aggragate;
	private int current =0 ;

	public ConcreteIterator(ConcreteAggregate aggragate){
		this.aggragate=aggragate;
	}
	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return aggragate.getItem(0);
	}

	@Override
	public Object next() {
		Object ret=null;
		current++;
		if(current<aggragate.count()){
			ret=aggragate.getItem(current);
		}
		return ret;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return current>=aggragate.count()?true:false;
	}

	@Override
	public Object currentItem() {
		// TODO Auto-generated method stub
		return aggragate.getItem(current);
	}
	
	

}
