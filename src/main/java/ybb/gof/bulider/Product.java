package ybb.gof.bulider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Product {
	 List <String> parts=new ArrayList<String>();
	 public void add(String part){
		 parts.add(part);
	 }
	 public void shows(){
		 Iterator it=parts.iterator();
		 while(it.hasNext()){
			 System.out.println(it.next());
		 }
	 }

}
