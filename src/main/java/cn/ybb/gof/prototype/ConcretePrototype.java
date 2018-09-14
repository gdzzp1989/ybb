package cn.ybb.gof.prototype;

public class ConcretePrototype extends Propotype {
	
	public ConcretePrototype(String id,String name){
		super(id,name);
	}
	
	@Override
	public Propotype Clone() {
		Propotype prototype = new ConcretePrototype(getId(),getName());
        return prototype;

	}

}
