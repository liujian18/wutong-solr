package solrBean;

import javax.xml.crypto.Data;

/**  
 * Package: solrBean  
 *  
 * File: attentionBean.java  关注类 
 *  
 * Author: liujian   Date: 2016年6月17日  
 *  
 * Copyright @ 2016 Corpration Name  
 *   
 */
public class AttentionBean {
	private int id;
	private int attent_user;
	private int attent;
	private int type;
	private Data create_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAttent_user() {
		return attent_user;
	}
	public void setAttent_user(int attent_user) {
		this.attent_user = attent_user;
	}
	public int getAttent() {
		return attent;
	}
	public void setAttent(int attent) {
		this.attent = attent;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Data getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Data create_time) {
		this.create_time = create_time;
	}
	
}
 