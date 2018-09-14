package cn.ybb.reflect;

import java.lang.reflect.Method ;
//反射调用setter和getter方法
public class InvokeSetGetDemo{
	public static void main(String args[]){
		Class<?> c1 = null ;
		Object obj = null ;
		try{
			c1 = Class.forName("algorithm.reflect.Person") ;// 实例化Class对象
			obj = c1.newInstance() ;
		}catch(Exception e){
			e.printStackTrace();
		}
		setter(obj,"name","zzp",String.class) ;	// 调用setter方法
		setter(obj,"age",30,int.class) ;	// 调用setter方法
		
		System.out.print("姓名：") ;
		getter(obj,"name") ;
		
		System.out.print("年龄：") ;
		getter(obj,"age");
	}

	public static void setter(Object obj,String att,Object value,Class<?> type){
		try{
			Method met = obj.getClass().getMethod("set"+initStr(att),type) ;	// 得到setter方法
			met.invoke(obj,value) ;	// 设置setter的内容
		}catch(Exception e){
			e.printStackTrace() ;
		}
	}
	public static void getter(Object obj, String att){  
        try {  
            Method met = obj.getClass().getMethod("get" + initStr(att));  
            System.out.println(met.invoke(obj));  
        }catch (Exception e){  
            e.printStackTrace();  
        }  
	}  
	public static String initStr(String old){//将单词的首字母大写  
		String str = old.substring(0,1).toUpperCase() + old.substring(1) ;  
        return str ;  
	}
}
