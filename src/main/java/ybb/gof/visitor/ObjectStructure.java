package ybb.gof.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
	private List<Element> list = new ArrayList<Element>();
	
	public void Attach(Element element){
		list.add(element);
	}
	
	public void Detach(Element element){
		list.remove(element);
	}
	
	public void Accept(Visitor visitor){
		for(Element element:list){
			element.Accept(visitor);
		}
	}

}
