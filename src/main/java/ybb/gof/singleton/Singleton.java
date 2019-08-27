package ybb.gof.singleton;

public class Singleton {
	private Singleton(){
    }
    //在第一次被引用时被加载
    private static class SingletonHolder
 	{
 		private static Singleton instance = new Singleton();
 	}
    
	public static Singleton getInstance()
	{
		return SingletonHolder.instance;		
	}
}
