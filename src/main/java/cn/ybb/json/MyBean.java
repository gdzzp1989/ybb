package cn.ybb.json;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class MyBean implements java.io.Serializable{

	private static final long serialVersionUID = 7784169652618513259L;
	private String id;
	private String name;
	private Date date;
	private List cardNum;
	
	public MyBean(){
		
	}
	
	public MyBean(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List getCardNum() {
		return cardNum;
	}
	public void setCardNum(List cardNum) {
		this.cardNum = cardNum;
	}
	
	@Override
	public String toString() {
		return id + ":" + name;
	}
	
}
