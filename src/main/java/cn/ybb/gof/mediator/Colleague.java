package cn.ybb.gof.mediator;

public abstract class Colleague {
 protected Mediator mediator;
 
 public Colleague( Mediator mediator){
	 this.mediator=mediator;
 }

}
