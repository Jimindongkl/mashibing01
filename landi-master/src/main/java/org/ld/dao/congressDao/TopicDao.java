package org.ld.dao.congressDao;

import java.util.List;
import java.util.Map;

import org.ld.model.congressModel.Topic;

public interface TopicDao {

	/**
	 * <pre>
	 * findAllTopic()   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 上午9:16:39    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 上午9:16:39    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;param integer 
	 * &#64;return
	 * </pre>
	 */
	List<Topic> findAllTopic(Integer agendaId);

	/**
	 * <pre>
	 * getTopicId(按id查询议题详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午3:06:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午3:06:35    
	 * 修改备注： 
	 * &#64;param poticId
	 * &#64;return
	 * </pre>
	 */
	Topic getTopicId(Integer poticId);

	/**
	 * <pre>
	 * findAllTopicLower(按议题id查询子议题详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月10日 下午3:56:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月10日 下午3:56:43    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	List<Topic> findAllTopicLower(Integer TopicLowerId);

	/**
	 * <pre>
	 * updateTopic(修改议题的投屏)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午3:16:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午3:16:27    
	 * 修改备注： 
	 * &#64;param topic
	 * </pre>
	 */
	void updateTopicMiracast(Topic topic);

	/**
	 * <pre>
	 * updateTopicParam(修改议题参数设置)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午4:01:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午4:01:52    
	 * 修改备注： 
	 * &#64;param topic
	 * </pre>
	 */
	void updateTopicParam(Topic topic);

	/**
	 * <pre>
	 * addTopic(增加议题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午3:16:49    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午3:16:49    
	 * 修改备注： 
	 * &#64;param topic
	 * </pre>
	 */
	void addTopic(Topic topic);

	/**
	 * <pre>
	 * findMaxorder(查询议程下议题的最大排序)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午4:30:30    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午4:30:30    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	Integer findAgendaMaxorder(Integer AgendaId);

	/**
	 * <pre>
	 * delectTopics(批量删除议题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午5:15:13    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午5:15:13    
	 * 修改备注： 
	 * &#64;param idList
	 * </pre>
	 */
	void delectTopics(List<Integer> idList);

	/**
	 * <pre>
	 * findTopicMaxorder(查询议程下子议题的最大排序)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月13日 上午10:09:36    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月13日 上午10:09:36    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	Integer findTopicMaxorder(Integer Topicid);

	/**
	 * <pre>
	 * updateBatchTopicTrees(批量修改议题的序号)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月27日 上午9:29:34    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月27日 上午9:29:34    
	 * 修改备注： 
	 * &#64;param topics
	 * </pre>
	 */
	void updateBatchTopicTrees(List<Topic> topics);

	/**
	 * <pre>findPaperlessNowTopics(查询无纸化中正在进行的议题列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月22日 上午11:44:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月22日 上午11:44:06    
	 * 修改备注： 
	 * @param status
	 * @return</pre>
	 */
	List<Map> findPaperlessNowTopics(Integer status);

	/**
	 * <pre>findAllTopics(按会议id和日程id查询议题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年10月28日 下午2:36:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年10月28日 下午2:36:38    
	 * 修改备注： 
	 * @param topic
	 * @return</pre>
	 */
	List<Topic> findAllTopics(Topic topic);

	/**
	 * <pre>queryTopictoContent(按议题的id查询议题的投屏内容)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月21日 上午10:06:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月21日 上午10:06:43    
	 * 修改备注： 
	 * @param topicId
	 * @return</pre>
	 */
	Topic queryTopictoContent(Integer topicId);

	/**
	 * <pre>updateTopicCongressAgenda(修改当前议程下所有的议题的状态为0)
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2021年1月25日 上午11:07:08    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2021年1月25日 上午11:07:08    
	 * 修改备注： 
	 * @param topic</pre>
	 */
	void updateTopicCongressAgenda(Topic topic);

	/**
	 * <pre>updateTopicStatus(修改当前议题状态为1)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2021年1月25日 上午11:14:21    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2021年1月25日 上午11:14:21    
	 * 修改备注： 
	 * @param topicId</pre>
	 */
	void updateTopicStatus(Integer topicId);

	/**
	 * <pre>updateTopicToPreStart(修改当前议题状态为-1)   
	 * 创建人：peter      
	 * 创建时间：2021年1月25日 上午11:14:21    
	 * 修改人：    
	 * 修改时间： 
	 * 修改备注： 
	 * @param topicId</pre>
	 */
	void updateTopicToPreStart(Integer topicId);
	/**
	 * <pre>updateTopicCongressAgendaTopicLower(修改当前议题下的所有子议题的状态为0)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2021年1月25日 上午11:18:30    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2021年1月25日 上午11:18:30    
	 * 修改备注： 
	 * @param topic</pre>
	 */
	void updateTopicCongressAgendaTopicLower(Topic topic);

}
