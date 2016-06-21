package solrBean;

import java.util.Date;

/**
 * 
* @ClassName: AnswerBean 
* @Description: TODO 回答类
* @author liujian 
* @date 2016年6月17日 上午11:07:22
 */
public class AnswerBean {
	private int id;
	private int question_id;
	private int user_id;
	private String content;
	private Date discuss_time;
	private int agree;
	private int disagree;
	private int flag;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDiscuss_time() {
		return discuss_time;
	}
	public void setDiscuss_time(Date discuss_time) {
		this.discuss_time = discuss_time;
	}
	public int getAgree() {
		return agree;
	}
	public void setAgree(int agree) {
		this.agree = agree;
	}
	public int getDisagree() {
		return disagree;
	}
	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
