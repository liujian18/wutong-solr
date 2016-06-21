package solrSearch;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import solrBean.ArticleBean;

/**
 * Package: solrSearch
 * 
 * File: SerachArticle.java 搜索话题
 * 
 * Author: liujian Date: 2016年6月17日
 * 
 * Copyright @ 2016 Corpration Name
 * 
 */
public class SearchArticle extends Exception {
	/**
	 * @Fields serialVersionUID : TODO 通过关键词查询话题
	 */
	private static final long serialVersionUID = 1L;

	private ArticleBean articleBean;

	public ArticleBean serachArticle(String content) {

		// if (content == null || content == "")
		// content = "*";
		// else
		// content = "\"" + content + "\"";

		// 创建HttpSolrServer对象，建立Solr连接
		SolrClient solr = new HttpSolrClient("http://192.168.1.188:8080/solr/article");
		try {
			// 创建SolrQuery对象
			SolrQuery query = new SolrQuery();
			// 设置查询条件
			query.setQuery("art_name:" + content);
			// 设置符合条件的第一个话题对象
			query.setStart(0);
			query.setRows(1);
			

			// 调用Server的方法查询索引库
			QueryResponse response = solr.query(query);
			// 查询结果
			SolrDocumentList results = response.getResults();
			// 查询总数
			long cnt = results.getNumFound();
			System.out.println("查询话题总数：" + cnt);
			// 结果列表
			for (SolrDocument solrDocument : results) {
				articleBean = new ArticleBean();
				articleBean.setId(Integer.parseInt(solrDocument.get("id").toString()));
				System.out.println(solrDocument.get("id"));
				if (solrDocument.get("art_name") == null)
					articleBean.setArt_name("");
				else
					articleBean.setArt_name(solrDocument.get("art_name").toString());

				articleBean.setStatus(Integer.parseInt(solrDocument.get("status").toString()));

				if (solrDocument.get("art_img") == null)
					articleBean.setArt_img("");
				else
					articleBean.setArt_img(solrDocument.get("art_img").toString());

				articleBean.setCount(Integer.parseInt(solrDocument.get("attention_count").toString()));

			}
			solr.close();
			return articleBean;
		} catch (Exception ex) {
			try {
				solr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		return null;
	}
}
