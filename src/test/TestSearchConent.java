package test;

import net.sf.json.JSONObject;
import solrBean.SearchContentBean;
import solrSearch.SearchContent;

/**  
 * Package: test  
 *  
 * File: TestSearchConent.java   测试搜索内容
 *  
 * Author: liujian   Date: 2016年6月17日  
 *  
 * Copyright @ 2016 Corpration Name  
 *   
 */
public class TestSearchConent {

	public static void main(String[] args) {
		
		SearchContent searContent = new SearchContent();
		SearchContentBean serConBean = searContent.serachContent("上市", 10, 1, 1);
		
		System.out.println(JSONObject.fromObject(serConBean));
	}

}
 