package cn.ybb.gof.bulider;

public class ConcreteBuilder1 extends Builder{
   private Product product=new Product();
	@Override
	public void builderPartA() {
		product.add("部件A");
		
	}

	@Override
	public void builderPartB() {
		product.add("部件B");
		
	}

	@Override
	public Product getResult() {
		// TODO Auto-generated method stub
		return product;
	}

}
