package solrBean;

import java.util.List;

/**  
 * Package: solrBean  搜索内容类
 *  
 * File: SearchConent.java   
 *  
 * Author: liujian   Date: 2016年6月17日  
 *  
 * Copyright @ 2016 Corpration Name  
 *   
 */
public class SearchContentBean {
	private ArticleBean article;
	private List<SearchQuestionBean> questionList;
	private List<SearchUserBean> userList;
	private String resultCode;
	private String resultMsg;
	

	public ArticleBean getArticle() {
		return article;
	}
	public void setArticle(ArticleBean article) {
		this.article = article;
	}
	public List<SearchQuestionBean> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<SearchQuestionBean> questionList) {
		this.questionList = questionList;
	}
	public List<SearchUserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<SearchUserBean> userList) {
		this.userList = userList;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
}
 