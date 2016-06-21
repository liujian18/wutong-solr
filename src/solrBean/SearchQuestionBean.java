package solrBean;

import java.util.List;


/**  
 * Package: solrBean  
 *  
 * File: SearchQuestion.java  搜索内容－问题类 
 *  
 * Author: liujian   Date: 2016年6月17日  
 *  
 * Copyright @ 2016 Corpration Name  
 *   
 */
public class SearchQuestionBean extends Object {
 private String questions;
 private int id;
 private List<SearchAnswerBean> answerList;


public List<SearchAnswerBean> getAnswerList() {
	return answerList;
}
public void setAnswerList(List<SearchAnswerBean> answerList) {
	this.answerList = answerList;
}
public String getQuestions() {
	return questions;
}
public void setQuestions(String questions) {
	this.questions = questions;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 
}
 