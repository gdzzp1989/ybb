package cn.ybb.gof.proxy;

public class RealSubject extends Subject {

	@Override
	public void request() {
		System.out.println("真实的请求");		
	}

}
