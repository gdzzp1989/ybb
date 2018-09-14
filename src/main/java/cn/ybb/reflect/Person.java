package cn.ybb.reflect;

public class Person implements IPerson{
	
	private String name ;  
    private int age ;
    
    public Person(){
    }  
    public Person(String name){  
        this.name = name ;
    }  
    public Person(String name,int age){  
        this(name) ;  
        this.age = age ;  
    }
    
    public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String say(String name,int age){
        return ("姓名：" + name + "，年龄：" + age) ;  
    }  
}
