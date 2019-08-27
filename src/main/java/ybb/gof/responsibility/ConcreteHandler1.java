package ybb.gof.responsibility;

public class ConcreteHandler1 extends Handler{

	@Override
	public void HandleRequest(int request) {
		if (request>=0 && request<10){
			System.out.println("ConcreteHandler1处理请求=="+request);
		}else if (successor!=null){
			successor.HandleRequest(request);
		}
		
	}

}
