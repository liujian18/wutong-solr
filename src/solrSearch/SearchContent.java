package solrSearch;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import solrBean.ArticleBean;
import solrBean.SearchAnswerBean;
import solrBean.SearchContentBean;
import solrBean.SearchQuestionBean;
import solrBean.SearchUserBean;
import solrInterface.SerachContentInterface;

/**
 * 
 * @ClassName: SearchContent
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liujian
 * @date 2016年6月15日 下午1:59:15
 */
public class SearchContent implements SerachContentInterface {

	private ArticleBean articleBean;

	private SearchContentBean searchConentBean;

	private List<SearchQuestionBean> questionList;

	private SearchQuestionBean searQuestionBean;

	private SearchAnswerBean searAnswerBean;

	private List<SearchAnswerBean> searAnswerBeanList;

	private SearchUserBean searUserBean;

	private List<SearchUserBean> searUserList;

	@Override
	public SearchContentBean serachContent(String content, int pageSize, int pageNum, int userId) {
		if (content == null || content == "")
			content = "*";
//		else
//			content = "\"" + content + "\"";
		// 通过关键字找匹配话题
		SearchArticle searchArticle = new SearchArticle();
		try {

			articleBean = searchArticle.serachArticle(content);

		} catch (Exception ex) {
			articleBean = null;
		}

		// 创建HttpSolrServer对象，建立Solr连接
		SolrClient solr = new HttpSolrClient("http://192.168.1.188:8080/solr/question");
		try {
			// 创建SolrQuery对象
			SolrQuery query = new SolrQuery();
			// 设置查询条件
			query.setQuery("question:" + content);
			// 设置分页，start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
			query.setStart((pageNum - 1) * pageSize);
			query.setRows(pageSize);

			// 调用Server的方法查询索引库
			QueryResponse response = solr.query(query);
			// 查询结果
			SolrDocumentList results = response.getResults();
			// 查询总数
			long cnt = results.getNumFound();
			System.out.println("查询总数：" + cnt);

			//String json = JsonUtil.getJsonStrFromObj(articleBean);
			//话题转换成Map对象
			searchConentBean =new SearchContentBean();
			questionList = new ArrayList<SearchQuestionBean>();
			searAnswerBeanList = new ArrayList<SearchAnswerBean>();
			searchConentBean.setArticle(articleBean);
			searUserList = new ArrayList<SearchUserBean>();
			// 结果列表
			for (SolrDocument solrDocument : results) {
				// 问题
				searQuestionBean = new SearchQuestionBean();
				searQuestionBean.setId(Integer.parseInt((String) solrDocument.get("id")));
				searQuestionBean.setQuestions((solrDocument.get("question")).toString());
				// 答案
				searAnswerBean = new SearchAnswerBean();
				if(solrDocument.get("answer_content")!=null)
				searAnswerBean.setContent( (solrDocument.get("answer_content")).toString());
				if(solrDocument.get("answer_agree") ==null) 
					searAnswerBean.setAgree(0);
				else
					searAnswerBean.setAgree(Integer.parseInt((solrDocument.get("answer_agree")).toString()));
				searAnswerBean.setQuestions((solrDocument.get("question")).toString());
				searAnswerBeanList.add(searAnswerBean);
				searQuestionBean.setAnswerList(searAnswerBeanList);

				questionList.add(searQuestionBean);

				// 用户
				searUserBean = new SearchUserBean();
				searUserBean.setId(Integer.parseInt(( solrDocument.get("user_id")).toString()));
				if(solrDocument.get("users_nickname") == null)
					searUserBean.setNickname("");
				else
					searUserBean.setNickname(solrDocument.get("users_nickname").toString());
				if(solrDocument.get("users_head_img") == null)
					searUserBean.setHead_img("");
				else
					searUserBean.setHead_img( solrDocument.get("users_head_img").toString());
				if(solrDocument.get("users_sign") == null)
					searUserBean.setSign("");
				else
					searUserBean.setSign( solrDocument.get("users_sign").toString());
				
				searUserList.add(searUserBean);
			}

			searchConentBean.setQuestionList(questionList);
			searchConentBean.setUserList(searUserList);
			searchConentBean.setResultCode("1000");
			searchConentBean.setResultMsg("成功");
			solr.close();
			return searchConentBean;
		} catch (Exception ex) {
			try {
				solr.close();
				searchConentBean.setResultCode("1001");
				searchConentBean.setResultMsg("暂无相关内容");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
			return null;
		}
	}

}
