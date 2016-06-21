package util;

import java.util.List;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;


/**  
 * Package: util  
 *  
 * File: JsonUtil.java   JSON工具类
 *  
 * Author: liujian   Date: 2016年6月17日  
 *  
 * Copyright @ 2016 Corpration Name  
 *   
 */
public class JsonUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   // Java object to JSON String
	     public static String getJsonStrFromObj(Object obj) {
	         JSONSerializer serializer = new JSONSerializer();
	         return serializer.serialize(obj);
	     }
	
	     // Java object to JSON String
	     public static String getJsonStrFromObj(Object obj, String... params) {
	         JSONSerializer serializer = new JSONSerializer();
	         serializer = serializer.include(params);
	         return serializer.serialize(obj);
	     }
	 
	     // List to JSON String
	     public static String getJsonStrFromList(List<Object> objs, String rootName,
	             String... params) {
	         JSONSerializer serializer = new JSONSerializer();
	         serializer = serializer.include(params);
	         serializer.rootName(rootName);
	         return serializer.serialize(objs);
	     }
	 
	     // Json String to Java object
	     public static <T> T getObjFromJsonStr(String source, Class<T> bean) {
	         return new JSONDeserializer<T>().deserialize(source, bean);
	     }




	     	

}
 