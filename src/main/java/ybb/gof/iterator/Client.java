package ybb.gof.iterator;
//迭代器模式//P226
public class Client {

	public static void main(String[] args) {
		ConcreteAggregate a =new ConcreteAggregate();
		a.addItem("A");
		a.addItem("B");
		a.addItem("C");
		a.addItem("D");
		
		Iterator i=new ConcreteIterator(a);
		while(!i.isDone()){			
			System.out.println(i.currentItem());
			i.next();
		}

	}

}
