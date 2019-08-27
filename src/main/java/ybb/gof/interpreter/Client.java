package ybb.gof.interpreter;

import java.util.ArrayList;
import java.util.List;

//解释器模式//P305
public class Client {

	public static void main(String[] args) {
		
		Context context=new Context();
		List <AbstractExpression> list=new ArrayList<AbstractExpression>();
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		list.add(new TerminalExpression());
		
		for(AbstractExpression ext:list){
			ext.Interpreter(context);
		}
		
		
		System.out.println("---");


	}

}
