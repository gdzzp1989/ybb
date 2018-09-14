package cn.ybb.json; 
  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import net.sf.ezmorph.object.DateMorpher;  
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject; 
import net.sf.json.util.JSONUtils;

  
import org.apache.commons.beanutils.PropertyUtils; 
 
  
@SuppressWarnings("unchecked")  
public class JsonTest {
	
	public static void main(String[] args) {
		JsonTest jsonTest =new JsonTest();
		jsonTest.testJsonArrToArray();
	}
	
	
      
    private static void setDataFormat2JAVA(){  
        //设定日期转换格式  
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));  
    }   

    public void testJsonToObj(){  
        String json = "{id:'1001',name:'张三'}";  
        MyBean bean = null;  
        setDataFormat2JAVA();  
        JSONObject obj = JSONObject.fromObject(json);  
        bean = (MyBean)JSONObject.toBean(obj, MyBean.class);  
        System.out.println(bean);  
    }  
      
    //从一个JSON数组得到一个java对象数组     
    public void testJsonArrToArray(){  
        String jsonStus = "[{id:1,name:'jack'},{id:2,name:'rose'},{id:3,name:'admin'}]";  
        JSONArray array = JSONArray.fromObject(jsonStus);  
        MyBean[] bean = new MyBean[array.size()];  
        for(int i = 0; i < array.size(); i++){  
            JSONObject jsonObject = array.getJSONObject(i);  
            bean[i] = (MyBean)JSONObject.toBean(jsonObject, MyBean.class);  
        }  
        System.out.println(bean[0]);  
        System.out.println(bean[1]);  
        System.out.println(bean[2]);
    }  
       
    //从json数组中得到相应java数组   
    public void testArrayForJson(){  
        String jsonString = "['q','c','d']";  
        JSONArray jsonArray = JSONArray.fromObject(jsonString);  
        Object[] strs = jsonArray.toArray();  
        System.out.print(strs[0]);  
        System.out.print(strs[1]);  
        System.out.print(strs[2]);  
    }  
      
    //字符串转换成json      
    public void testJsonStrToJSON(){  
        String json = "['json','is','easy']";  
        JSONArray jsonArray = JSONArray.fromObject( json );    
        System.out.println( jsonArray );  
    }  
      
    //Map转换成json    
    public void testMapToJSON(){  
        Map map = new HashMap();    
        map.put( "name", "jack" );    
        map.put( "bool", Boolean.TRUE );    
        map.put( "int", new Integer(1) );    
        map.put( "arr", new String[]{"a","b"} );    
        map.put( "func", "function(i){ return this.arr[i]; }" );    
          
        JSONObject jsonObject = JSONObject.fromObject( map );    
        System.out.println( jsonObject );  
    }  
      
    //java对象转换为json格式    
    public void testObjToJson(){  
        JSONObject obj2=new JSONObject();  
        obj2.put("phone","123456");  
        obj2.put("zip","7890");  
        obj2.put("contact",obj2);  
        System.out.print(obj2);  
    }  
      
    //复合类型bean转成成json      
    public void testBeadToJSON(){  
        MyBean bean = new MyBean();  
        bean.setId("001");  
        bean.setName("银行卡");  
        bean.setDate(new Date());  
          
        List cardNum = new ArrayList();  
        cardNum.add("农行");  
        cardNum.add("工行");  
        cardNum.add("建行");  
        cardNum.add(new MyBean("new"));  
          
        bean.setCardNum(cardNum);  
          
        JSONObject jsonObject = JSONObject.fromObject(bean);  
        System.out.println(jsonObject);  
          
    }  
      
    //一般数组转换成JSON   
    public void testArrayToJSON(){  
        boolean[] boolArray = new boolean[]{true,false,true};    
        JSONArray jsonArray = JSONArray.fromObject( boolArray );    
        System.out.println( jsonArray );    
    }  
      
    //Collection对象转换成JSON     
    public void testListToJSON(){  
        List list = new ArrayList();    
        list.add( "first" );  
        list.add( "second" );  
        JSONArray jsonArray = JSONArray.fromObject( list );    
        System.out.println( jsonArray );    
        // prints ["first","second"]    
    }  
      
    //普通类型的json转换成对象    
    public void testJsonToObject() throws Exception{  
        String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";    
        JSONObject jsonObject = JSONObject.fromObject( json );   
        System.out.println(jsonObject);  
        Object bean = JSONObject.toBean( jsonObject );   
        System.out.println(PropertyUtils.getProperty(bean, "name"));  
        System.out.println(PropertyUtils.getProperty(bean, "bool"));  
        System.out.println(PropertyUtils.getProperty(bean, "int"));  
        System.out.println(PropertyUtils.getProperty(bean, "double"));  
        System.out.println(PropertyUtils.getProperty(bean, "func"));  
        System.out.println(PropertyUtils.getProperty(bean, "array"));  
          
        List arrayList = (List)JSONArray.toCollection(jsonObject.getJSONArray("array"));  
        for(Object object : arrayList){  
            System.out.println(object);  
        }  
          
    }  
      
}  