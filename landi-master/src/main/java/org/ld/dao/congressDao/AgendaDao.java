package org.ld.dao.congressDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;

public interface AgendaDao {

	/**
	 * <pre>
	 * findMaxorder(查询会议下议程的最大排序)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 上午9:37:44    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 上午9:37:44    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	Integer findMaxorder(Integer id);

	/**
	 * <pre>
	 * addAgenda(在会议下增加议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 上午10:25:30    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 上午10:25:30    
	 * 修改备注： 
	 * &#64;param agenda
	 * </pre>
	 */
	void addAgenda(Agenda agenda);

	/**
	 * <pre>
	 * updateAgenda(在会议下修改议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 上午10:52:24    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 上午10:52:24    
	 * 修改备注： 
	 * &#64;param agenda
	 * </pre>
	 */
	void updateAgenda(Agenda agenda);

	/**
	 * <pre>
	 * findAgendaAndRoom(议程中的会议室的关联)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 下午12:18:24    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 下午12:18:24    
	 * 修改备注： 
	 * &#64;param roomList
	 * &#64;return
	 * </pre>
	 */
	List<Agenda> findAgendaAndRoom(List<Integer> roomList);

	/**
	 * <pre>
	 * deleteAgenda(删除议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 下午3:48:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 下午3:48:35    
	 * 修改备注： 
	 * &#64;param idList
	 * </pre>
	 */
	void deleteAgenda(List<Integer> idList);

	/**
	 * <pre>
	 * findAllAgenda(按会议查询议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 上午9:07:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 上午9:07:12    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	List<Agenda> findAllAgenda(Integer id);

	/**
	 * <pre>
	 * findCongresAgendasList(按会议id查询议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月23日 下午7:58:25    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月23日 下午7:58:25    
	 * 修改备注： 
	 * &#64;param congress
	 * &#64;return
	 * </pre>
	 */
	List<Agenda> findCongresAgendasList(Congress congress);

	/**
	 * <pre>findPaperlessNowAgenda(查询状态下召开议程的详细信息 )   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月27日 下午4:08:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月27日 下午4:08:17    
	 * 修改备注： 
	 * @param status
	 * @return</pre>
	 */
	Agenda findPaperlessNowAgenda(Integer status);

	/**
	 * <pre>uploadStatusAgenda(修改议程的状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月7日 下午3:38:26    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月7日 下午3:38:26    
	 * 修改备注： 
	 * @param agenda</pre>
	 */
	void uploadStatusAgenda(Agenda agenda);

	/**
	 * <pre>findAgendaIdfindAgendas(查正在开始议程的同级所有议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月13日 下午3:01:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月13日 下午3:01:17    
	 * 修改备注： 
	 * @param agendaId
	 * @return</pre>
	 */
	List<Agenda> findAgendaIdfindAgendas(Integer agendaId);

	/**
	 * <pre>findNotCurrentAgendaStatus(查询正在进行中的会议有几个)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年7月6日 下午5:03:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年7月6日 下午5:03:54    
	 * 修改备注： 
	 * @param agendaId
	 * @param status
	 * @return</pre>
	 */
	List<Agenda> findNotCurrentAgendaStatus(@Param("agendaId")Integer agendaId,@Param("status") Integer status);

	/**
	 * <pre>findAgendaModel(按id查询日程的详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月5日 上午10:20:18    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月5日 上午10:20:18    
	 * 修改备注： 
	 * @param agendaId
	 * @return</pre>
	 */
	Agenda findAgendaModel(Integer agendaId);

}
