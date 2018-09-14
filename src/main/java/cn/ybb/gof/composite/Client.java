package cn.ybb.gof.composite;
//组合模式//P214
public class Client {

	public static void main(String[] args) {
		Composite root =new Composite("root");
		root.Add(new Leaf("Leaf A"));
		root.Add(new Leaf("Leaf B"));
		
		Composite compx =new Composite("comp X");
		compx.Add(new Leaf("Leaf XA"));
		compx.Add(new Leaf("Leaf XB"));
		root.Add(compx);
		
		Composite compy =new Composite("comp Y");
		compy.Add(new Leaf("Leaf YA"));
		compy.Add(new Leaf("Leaf YB"));
		root.Add(compy);
		
		
		root.Add(new Leaf("Leaf C"));
		root.Display(1);//显示树

	}

}
