package solrBean;  
/**  
 * Package: solrBean  
 *  
 * File: articleBean.java   话题类
 *  
 * Author: liujian   Date: 2016年6月17日  
 *  
 * Copyright @ 2016 Corpration Name  
 *   
 */
public class ArticleBean  extends Object{
 private int id;
 private String art_name;
 private int pusher;
 private int status;
 private String art_img;
 private int count;
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getArt_name() {
	return art_name;
}
public void setArt_name(String art_name) {
	this.art_name = art_name;
}
public int getPusher() {
	return pusher;
}
public void setPusher(int pusher) {
	this.pusher = pusher;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getArt_img() {
	return art_img;
}
public void setArt_img(String art_img) {
	this.art_img = art_img;
}

}
 