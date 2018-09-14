package cn.ybb.gof.responsibility;

public class ConcreteHandler2 extends Handler{

	@Override
	public void HandleRequest(int request) {
		if (request>=10 && request<20){
			System.out.println("ConcreteHandler2处理请求=="+request);
		}else if (successor!=null){
			successor.HandleRequest(request);
		}
		
	}

}