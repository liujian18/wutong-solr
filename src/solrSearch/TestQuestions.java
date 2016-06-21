package solrSearch;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class TestQuestions {

	public static void main(String[] args) throws SolrServerException, IOException {

		//创建HttpSolrServer对象，建立Solr连接
		HttpSolrClient solr = new HttpSolrClient("http://localhost:8080/solr/collection1");
//		solr.setParser(new XMLResponseParser());  
//		solr.setSoTimeout(1000); // socket read timeout  
//		solr.setDefaultMaxConnectionsPerHost(100);  
//		solr.setMaxTotalConnections(100);  
//		solr.setFollowRedirects(false); // defaults to false    
//		solr.setAllowCompression(true);  
				//创建SolrQuery对象
				SolrQuery query = new SolrQuery();
				//设置查询条件
				query.setQuery( "id:3");
				//用于调试程序  
				System.out.println(query);
				//调用Server的方法查询索引库
				QueryResponse response= solr.query(query);
				//查询结果
				SolrDocumentList results= response.getResults();
				//查询总数
				long cnt= results.getNumFound();
				System.out.println("查询总数："+ cnt);
				//结果列表
				for (SolrDocument solrDocument : results){
					System.out.println(solrDocument.get("id"));
					System.out.println(solrDocument.get("question"));
					System.out.println(solrDocument.get("user_id"));
					System.out.println(solrDocument.get("create_time"));
					System.out.println(solrDocument.get("flag"));
					System.out.println(solrDocument.get("status"));
					System.out.println(solrDocument.get("describe"));
				}
				solr.close();
	}

}
