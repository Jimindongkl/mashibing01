package org.ld.dao;

import java.util.List;

import org.ld.model.StaffInfo;
import org.ld.model.StaffLibrary;

public interface StaffInfoDao {

	/**
	 * <pre>getCount(查询人员的总人数)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:40:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:40:38    
	 * 修改备注： 
	 * @param staffInfo
	 * @return</pre>
	 */
	 Long getCount(StaffInfo staffInfo);
	 
	 /**
	  * <pre>getStaffInfoPageList(分页查询)   
	  * 创建人：姬民东 15539277254@163.com      
	  * 创建时间：2020年1月8日 下午3:40:55    
	  * 修改人：姬民东 15539277254@163.com      
	  * 修改时间：2020年1月8日 下午3:40:55    
	  * 修改备注： 
	  * @param staffInfo
	  * @return</pre>
	  */
	 List<StaffInfo> getStaffInfoPageList(StaffInfo staffInfo);
	 
	 /**
	  * <pre>addStaffInfo(增加参会人员)   
	  * 创建人：姬民东 15539277254@163.com      
	  * 创建时间：2020年1月10日 下午2:43:35    
	  * 修改人：姬民东 15539277254@163.com      
	  * 修改时间：2020年1月10日 下午2:43:35    
	  * 修改备注： 
	  * @param staffInfo
	  * @return</pre>
	  */
	  void addStaffInfo(StaffInfo staffInfo);
	  
	  /**
		  * <pre>addStaffInfo(修改参会人员)   
		  * 创建人：姬民东 15539277254@163.com      
		  * 创建时间：2020年1月10日 下午2:43:35    
		  * 修改人：姬民东 15539277254@163.com      
		  * 修改时间：2020年1月10日 下午2:43:35    
		  * 修改备注： 
		  * @param staffInfo
		  * @return</pre>
		  */
	  void updateStaffInfo(StaffInfo staffInfo);

	  /**
	   * <pre>deleteStaffInfo(删除参会人员)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年1月11日 下午3:14:17    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年1月11日 下午3:14:17    
	   * 修改备注： 
	   * @param idList</pre>
	   */
	  void deleteStaffInfo(List<Integer> idList);

	  /**
	   * <pre>findStaffInfoAll(无分页的有条件的查询参会人员)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年1月14日 上午11:56:39    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年1月14日 上午11:56:39    
	   * 修改备注： 
	   * @param staffInfo
	   * @return</pre>
	   */
	  List<StaffInfo> findStaffInfoAll(StaffInfo staffInfo);

	  /**
	   * <pre>addBatch(批量增加)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年2月11日 下午4:55:54    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年2月11日 下午4:55:54    
	   * 修改备注： 
	   * @param staffInfos</pre>
	   */
	  void addBatch(List staffInfos);

	  /**
	   * <pre>findStaffinfoLibraryList(按人员类别查询人员类型和人员)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年2月17日 上午11:48:47    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年2月17日 上午11:48:47    
	   * 修改备注： 
	   * @param id
	   * @return</pre>
	   */
	  List<StaffInfo> findStaffinfoLibraryList(Integer id);

	  /**
	   * <pre>addStaffInfoResultID(增加参会人员有返回值)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年3月30日 上午10:32:31    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年3月30日 上午10:32:31    
	   * 修改备注： 
	   * @param staffInfo
	   * @return</pre>
	   */
	  int addStaffInfoResultID(StaffInfo staffInfo);

	  /**
	   * <pre>getStaffInfoList(无分页的条件查询)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年3月31日 下午2:58:29    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年3月31日 下午2:58:29    
	   * 修改备注： 
	   * @param staffInfo
	   * @return</pre>
	   */
	  List<StaffInfo> getStaffInfoList(StaffInfo staffInfo);

	  /**
	   * <pre>findstaffCategoryIsStaffInfo(查询人员类别绑定基础人员)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年8月6日 上午10:18:24    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年8月6日 上午10:18:24    
	   * 修改备注： 
	   * @param intId
	   * @return</pre>
	   */
	  List<StaffInfo> findstaffCategoryIsStaffInfo(Integer intId);

	  /**
	   * <pre>findStaffGroupIsStaffInfo(查看人员团组是否绑定人员)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年8月6日 上午10:56:51    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年8月6日 上午10:56:51    
	   * 修改备注： 
	   * @param intId
	   * @return</pre>
	   */
	  List<StaffInfo> findStaffGroupIsStaffInfo(Integer intId);

	  /**
	   * <pre>getUserByUserName(查看密码是否正确)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年8月28日 下午2:01:29    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年8月28日 下午2:01:29    
	   * 修改备注： 
	   * @param userName
	   * @return</pre>
	   */
	  StaffInfo getUserByUserName(String userName);

	 
	  
		
	
	

}
