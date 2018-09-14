package cn.ybb.gof.abstractfactory;

public class SqlServerUser implements IUser{

	@Override
	public void insertUser() {
		System.out.println("insert SqlServerUser");
		
	}

}
