package ybb.gof.responsibility;
//职责链模式//P271
public class Client {

	public static void main(String[] args) {
		Handler h1=new ConcreteHandler1();
		Handler h2=new ConcreteHandler2();
		
		h1.setSuccessor(h2);
		
		int[] requests={2,5,15,14,4};
		
		for(int i=0;i<requests.length;i++){
			h1.HandleRequest(requests[i]);
		}

	}

}
