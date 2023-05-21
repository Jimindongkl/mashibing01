package org.ld.dao;

import java.util.List;

import org.ld.model.StaffGroup;

public interface StaffGroupDao {

	/**
	 * <pre>getStaffGroupList(查询团组列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 下午2:12:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 下午2:12:20    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<StaffGroup> getStaffGroupList();

	/**
	 * <pre>addorupdateStaffGroup(增加团组)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 下午2:12:40    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 下午2:12:40    
	 * 修改备注： 
	 * @param staffGroup</pre>
	 */
	void addStaffGroup(StaffGroup staffGroup);

	/**
	 * <pre>updateStaffGroup(修改团组)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 下午2:14:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 下午2:14:16    
	 * 修改备注： 
	 * @param staffGroup</pre>
	 */
	void updateStaffGroup(StaffGroup staffGroup);
	
	/**
	 * <pre>deleteStaffGroup(删除团组)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 下午2:28:49    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 下午2:28:49    
	 * 修改备注： 
	 * @param idList</pre>
	 */
	void deleteStaffGroup(List<Integer> idList);

	/**
	 * <pre>findStaffGroupModel(条件查询返回对象)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月15日 上午11:51:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月15日 上午11:51:38    
	 * 修改备注： 
	 * @param staffGroup
	 * @return</pre>
	 */
	StaffGroup findStaffGroupModel(StaffGroup staffGroup);

	/**
	 * <pre>findGroupNameEqual(查看数据库中是否有相同的名字)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月6日 下午4:10:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月6日 下午4:10:16    
	 * 修改备注： 
	 * @param staffGroup
	 * @return</pre>
	 */
	List<StaffGroup> findGroupNameEqual(StaffGroup staffGroup);
	
	

	
}
