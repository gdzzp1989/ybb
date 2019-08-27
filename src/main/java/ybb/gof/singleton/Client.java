package ybb.gof.singleton;
//单例模式//P235
public class Client {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2);
		

	}

}
