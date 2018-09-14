package cn.ybb.gof.simplefactory;

public class OperFactory {

	 public static Operation createOpertion(String operate){
		 Operation op=null;
	     switch(operate){
	     case "+":
	    	 op=new OperAdd();
	    	 break;
	     case "-":
	    	 op=new OperSub();
	    	 break;
	     default:
	    	op=new Operation();    
	     }
		return  op;		 
	 }
}
