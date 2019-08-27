package ybb.reflect;

import java.lang.reflect.Field;

public class InvokeFieldDemo {
	public static void main(String args[]){
		Class<?> c1 = null ;
		Object obj = null ;
		try{
			c1 = Class.forName("algorithm.reflect.Person") ;// 实例化Class对象
			obj = c1.newInstance() ;
			Field nameField=c1.getDeclaredField("name");
			Field ageField=c1.getDeclaredField("age");
			nameField.setAccessible(true);//将name属性设置可外部访问
			nameField.set(obj, "zzp");
			ageField.setAccessible(true);
			ageField.set(obj, 30);
			
			System.out.println("姓名："+nameField.get(obj)) ;
			System.out.println("年龄："+ageField.get(obj)) ;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
