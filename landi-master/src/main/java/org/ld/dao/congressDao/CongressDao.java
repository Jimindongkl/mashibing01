package org.ld.dao.congressDao;

import java.util.List;

import org.ld.model.congressModel.Congress;
import org.ld.model.paperlessModel.StaffInfoSelfModel;

public interface CongressDao {

	/**
	 * <pre>
	 * findCongressList(查询所有会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月2日 下午3:25:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月2日 下午3:25:06    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	List<Congress> findCongressList();

	/**
	 * <pre>
	 * addCongress(增加会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月2日 下午3:25:19    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月2日 下午3:25:19    
	 * 修改备注： 
	 * &#64;param congress
	 * </pre>
	 */
	void addCongress(Congress congress);

	/**
	 * <pre>
	 * updateCongress(修改会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月2日 下午3:25:28    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月2日 下午3:25:28    
	 * 修改备注： 
	 * &#64;param congress
	 * </pre>
	 */
	void updateCongress(Congress congress);

	/**
	 * <pre>
	 * deleteCongress(删除会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月2日 下午3:27:18    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月2日 下午3:27:18    
	 * 修改备注： 
	 * &#64;param idList
	 * </pre>
	 */
	void deleteCongress(List<Integer> idList);

	/**
	 * <pre>
	 * findRoomId(查询属于会议的会议室id)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 上午10:16:08    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 上午10:16:08    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	Integer findRoomId(Integer id);

	/**
	 * <pre>
	 * findCongressAndRoom(查询会议关联的会议室)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 上午11:37:57    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 上午11:37:57    
	 * 修改备注： 
	 * &#64;param roomList
	 * </pre>
	 * 
	 * @return
	 */
	List<Congress> findCongressAndRoom(List<Integer> roomList);

	/**
	 * <pre>
	 * findAllCongress(查询全部会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月4日 下午4:58:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月4日 下午4:58:51    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	List<Congress> findAllCongress(Congress congress);

	/**
	 * <pre>
	 * getMaxCongressOrder(查询全部会议中最大的排序)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月11日 下午1:53:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月11日 下午1:53:35    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	Integer getMaxCongressOrder();

	/**
	 * <pre>findPaperlessNowCongressModel(查询当前的会议详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月29日 下午3:20:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月29日 下午3:20:43    
	 * 修改备注： 
	 * @param status
	 * @param fileType
	 * @return</pre>
	 */
	Congress findPaperlessNowCongressModel(Integer status);

	/**
	 * <pre>uploadStatusCongress(修改会议状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月7日 下午3:33:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月7日 下午3:33:27    
	 * 修改备注： 
	 * @param congress</pre>
	 */
	void uploadStatusCongress(Congress congress);

	/**
	 * <pre>findAgendaIdfindcongressBy(根据修改的议程查会议的的状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月13日 下午4:01:55    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月13日 下午4:01:55    
	 * 修改备注： 
	 * @param agendaId
	 * @return</pre>
	 */
	Congress findAgendaIdfindcongressBy(Integer congressId);

	/**
	 * <pre>findOneselfCongress(查询各自参加过的会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月28日 下午3:49:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月28日 下午3:49:52    
	 * 修改备注： 
	 * @param staffInfoSelf
	 * @return</pre>
	 */
	List<Congress> findOneselfCongress(StaffInfoSelfModel staffInfoSelf);

}
