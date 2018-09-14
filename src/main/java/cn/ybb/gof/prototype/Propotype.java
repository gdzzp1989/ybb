package cn.ybb.gof.prototype;

public abstract class Propotype {
	private String id;
	private String name;
	
	public Propotype(){
	}
	public Propotype(String id,String name){
		this.id=id;
		this.name=name;	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract Propotype Clone();

}
