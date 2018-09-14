package cn.ybb.gof.abstractfactory;

public class SqlServerFactory implements IFactory {

	@Override
	public IUser createUser() {
		// TODO Auto-generated method stub
		return new SqlServerUser();
	}

}
