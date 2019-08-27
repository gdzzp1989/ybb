package ybb.gof.abstractfactory;

public class OracleFactory implements IFactory {

	@Override
	public IUser createUser() {
		// TODO Auto-generated method stub
		return new OracleUser();
	}


}
