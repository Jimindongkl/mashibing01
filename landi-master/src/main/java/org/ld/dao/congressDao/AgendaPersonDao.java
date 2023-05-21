package org.ld.dao.congressDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.AgendaPerson;
import org.ld.vo.AgendaPersonResult;
import org.ld.vo.AgendaPersonResultByModelVo;
import org.ld.vo.AgendaPersonSeatUnitVo;
import org.ld.vo.AgendaSeatUitStaffInfoVo;

public interface AgendaPersonDao {

	/**
	 * <pre>
	 * addAgendaPerson(增加绑定议程的参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 下午1:39:11    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 下午1:39:11    
	 * 修改备注： 
	 * &#64;param agendaPerson
	 * </pre>
	 */
	void addAgendaPerson(AgendaPerson agendaPerson);

	/**
	 * <pre>
	 * getAgendaPersonList(查询跟议程绑定的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 下午3:23:46    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 下午3:23:46    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	List<AgendaPersonSeatUnitVo> getAgendaPersonList(AgendaPerson agendaPerson);

	/**
	 * <pre>
	 * findAgendaPersonByID(回显)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 上午11:55:01    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 上午11:55:01    
	 * 修改备注： 
	 * &#64;param agendaPerson
	 * &#64;return
	 * </pre>
	 */
	AgendaPersonResultByModelVo findAgendaPersonByID(AgendaPerson agendaPerson);

	/**
	 * <pre>
	 * updateAgendaPerson(修改AgendaPerson)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午1:39:02    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午1:39:02    
	 * 修改备注： 
	 * &#64;param agendaPerson
	 * </pre>
	 */
	void updateAgendaPerson(AgendaPerson agendaPerson);

	/**
	 * <pre>
	 * deleteAgendaPersons(批量删除(解绑)议程绑定参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午2:24:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午2:24:17    
	 * 修改备注： 
	 * &#64;param idList
	 * </pre>
	 */
	void deleteAgendaPersons(List<Integer> idList);

	/**
	 * <pre>
	 * addBatchAgendaPerson(批量绑定议程绑定参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午4:20:00    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午4:20:00    
	 * 修改备注： 
	 * &#64;param agendaPersons
	 * </pre>
	 */
	void addBatchAgendaPerson(List<AgendaPerson> agendaPersons);

	/**
	 * <pre>
	 * findAgendaPersonIDs(查询议程下的人员id集合)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月1日 上午11:35:46    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月1日 上午11:35:46    
	 * 修改备注： 
	 * &#64;param agendaID
	 * &#64;return
	 * </pre>
	 */
	List<Integer> findAgendaPersonIDs(Integer agendaID);

	/**
	 * <pre>
	 * updateAgendaPersonBondSeatUnit(议程下的人员跟坐席绑定)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月9日 上午11:25:26    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月9日 上午11:25:26    
	 * 修改备注： 
	 * &#64;param agendaPersonId
	 * &#64;param seatUnitId
	 * </pre>
	 */
	void updateAgendaPersonBondSeatUnit(AgendaPersonSeatUnitVo agendaPersonSeatUnitVo);

	/**
	 * <pre>
	 * getAgendaPersonListInt(按议程的id查询绑定的人员信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月9日 下午5:38:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月9日 下午5:38:05    
	 * 修改备注： 
	 * &#64;param aendaPersonResult
	 * &#64;return
	 * </pre>
	 */
	List<AgendaPersonResult> getAgendaPersonListInt(AgendaPersonResult aendaPersonResult);

	/**
	 * <pre>getIDSAgendaPersonList(按主键id的集合来查询AgendaPerson的详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月13日 上午11:01:15    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月13日 上午11:01:15    
	 * 修改备注： 
	 * @param idList
	 * @return</pre>
	 */
	List<AgendaPerson> getIDSAgendaPersonList(List<Integer> idList);

	/**
	 * <pre>updateBatchSwopSeatUnits(人员交换坐席)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月20日 下午3:17:21    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月20日 下午3:17:21    
	 * 修改备注： 
	 * @param agendaPersons</pre>
	 */
	void updateBatchSwopSeatUnits(List<AgendaPerson> agendaPersons);

	/**
	 * <pre>findAgendaPersonModel(按议程的id,人员的id,坐席的id找到AP_ID)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月20日 下午3:41:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月20日 下午3:41:29    
	 * 修改备注： 
	 * @param agendaId
	 * @param staffinfoId
	 * @param seatUnit
	 * @return</pre>
	 */
	AgendaPerson findAgendaPersonModel(@Param("agendaId")Integer agendaId,@Param("staffinfoId")Integer staffinfoId,@Param("seatUnit") Integer seatUnit);

	/**
	 * <pre>findStaffinfoBondSeatUnitIsPower(按议程的id,人员的id,查询人员绑定坐席后的权限)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月21日 下午6:18:59    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月21日 下午6:18:59    
	 * 修改备注： 
	 * @param staffinfoId
	 * @param agendaId
	 * @return</pre>
	 */
	AgendaPerson findStaffinfoBondSeatUnitIsPower(@Param("staffinfoId")String staffinfoId, @Param("agendaId")Integer agendaId);

	/**
	 * <pre>findAgendaAndSeatQueryStaffInfo(按议程的id和坐席的id查询人员的信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月27日 下午4:20:15    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月27日 下午4:20:15    
	 * 修改备注： 
	 * @param agendId
	 * @param suId
	 * @return</pre>
	 */
	AgendaSeatUitStaffInfoVo findAgendaAndSeatQueryStaffInfo(@Param("agendId")Integer agendId, @Param("suId")Integer suId);

	/**
	 * <pre>findPersonIsAgenda(查看人员是否与日程绑定)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月6日 上午8:53:11    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月6日 上午8:53:11    
	 * 修改备注： 
	 * @param intId
	 * @return</pre>
	 */
	List<Agenda> findPersonIsAgenda(Integer intId);
	
	/**
	 * <pre>findagendaPersonIdSelectAgendaId(按agendaPersonId查询agendaId)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月27日 下午3:44:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月27日 下午3:44:35    
	 * 修改备注： 
	 * @param agendaPersonId
	 * @return</pre>
	 */
	AgendaPerson findagendaPersonIdSelectAgendaId(Integer agendaPersonId);

	/**
	 * <pre>findSumSeatID(按照ag和seatUnitId查询List<AgendaPerson>)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月27日 下午3:45:13    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月27日 下午3:45:13    
	 * 修改备注： 
	 * @param ag
	 * @param seatUnitId
	 * @return</pre>
	 */
	List<AgendaPerson> findSumSeatID(@Param("ag")Integer ag,@Param("seatUnitId")Integer seatUnitId);

	/**
	 * <pre>findUnderwayMeetingPersonList(按日程id查询签到的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月3日 下午3:06:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月3日 下午3:06:50    
	 * 修改备注： 
	 * @param agendaId
	 * @return</pre>
	 */
	List<AgendaSeatUitStaffInfoVo> findUnderwayMeetingPersonList(Integer agendaId);

	/**
	 * <pre>updateUnderwayMeetingPersonCheckInTimeAndCheckState(按坐席id和当前日程的id修改人员的状态和签到时间)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月3日 下午3:51:40    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月3日 下午3:51:40    
	 * 修改备注： 
	 * @param agendaPerson</pre>
	 */
	void updateUnderwayMeetingPersonCheckInTimeAndCheckState(AgendaPerson agendaPerson);

	/**
	 * <pre>updateUnderwayMeetingPersonCheckOutTimeAndCheckState(按坐席id和当前日程的id修改人员的状态和迁出时间)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月3日 下午4:04:18    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月3日 下午4:04:18    
	 * 修改备注： 
	 * @param agendaPerson</pre>
	 */
	void updateUnderwayMeetingPersonCheckOutTimeAndCheckState(AgendaPerson agendaPerson);

	/**
	 * <pre>findNowAgendaSeatPersons(查询当前会议日程绑定坐席人员的集合)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月4日 下午5:24:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月4日 下午5:24:56    
	 * 修改备注： 
	 * @param agenda
	 * @return</pre>
	 */
	List<AgendaPerson> findNowAgendaSeatPersons(Integer agendaID);

	/**
	 * <pre>updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(批量修改当前会议日程绑定坐席人员的状态和时间)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月4日 下午5:42:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月4日 下午5:42:16    
	 * 修改备注： 
	 * @param agendaPersons</pre>
	 */
	void updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(List<AgendaPerson> agendaPersons);

	/**
	 * <pre>findControlPersonCheckInList(条件查询跟会议绑定的人员)  
	 * 创建人：姬民东 15539277254@163.com     
	 * 创建时间：2020年12月17日 下午2:57:25    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月17日 下午2:57:25    
	 * 修改备注： 
	 * @param agendaPerson
	 * @return</pre>
	 */
	List<AgendaSeatUitStaffInfoVo> findControlPersonCheckInList(AgendaPerson agendaPerson);

	

}
