package ybb.gof.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subject {
	List <Observer> observerlist=new ArrayList<Observer>();
	 public void add(Observer ob){
		 observerlist.add(ob);
	 }
	 public void remove(Observer ob){
		 observerlist.remove(ob);
	 }
	 public void notifyob(){
		 Iterator it=observerlist.iterator();
		 while(it.hasNext()){
			 ((Observer)it.next()).update();
		 }
	 }
}
