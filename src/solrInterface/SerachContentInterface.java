package solrInterface;

import solrBean.SearchContentBean;

/**
 * 
* @ClassName: SerachContentInterface 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author liujian 
* @date 2016年6月15日 下午1:37:41
 */
public interface SerachContentInterface {
	/**
	 * 
	 * @param content 搜索内容
	 * @param pageSize	显示条数
	 * @param pageNum	当前页
	 * @param userId	当前用户ID
	 * @return 
	 */
	public SearchContentBean serachContent(String content,int pageSize,int pageNum,int userId);
}
