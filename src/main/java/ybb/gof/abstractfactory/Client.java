package ybb.gof.abstractfactory;
//抽象工厂模式//P159
public class Client {
	public static void main(String[] args) {
		IFactory sfactory =new SqlServerFactory();
		sfactory.createUser().insertUser();
		
		IFactory ofactory =new OracleFactory();
		ofactory.createUser().insertUser();
	}
}
