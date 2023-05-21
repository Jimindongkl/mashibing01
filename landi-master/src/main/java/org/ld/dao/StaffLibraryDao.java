package org.ld.dao;

import java.util.List;

import org.ld.model.StaffInfo;
import org.ld.model.StaffLibrary;

public interface StaffLibraryDao {

	/**
	 * <pre>queryStaffLibraryList(查询人员类别)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 下午1:39:53    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 下午1:39:53    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<StaffLibrary> queryStaffLibraryList();

	 /**
	   * \<pre>addStaffinfoLibrary(增加人员类别)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年2月17日 下午1:05:57    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年2月17日 下午1:05:57    
	   * 修改备注： 
	   * @param staffLibrary</pre>
	   */
	  void addStaffinfoLibrary(StaffLibrary staffLibrary);

	  /**
	   * <pre>updateStaffinfoLibrary(修改人员类别)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年2月17日 下午1:06:21    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年2月17日 下午1:06:21    
	   * 修改备注： 
	   * @param staffLibrary</pre>
	   */
	  void updateStaffinfoLibrary(StaffLibrary staffLibrary);

	  /**
	   * <pre>deleteStaffinfoLibrary(删除人员类别)   
	   * 创建人：姬民东 15539277254@163.com      
	   * 创建时间：2020年2月17日 下午4:17:10    
	   * 修改人：姬民东 15539277254@163.com      
	   * 修改时间：2020年2月17日 下午4:17:10    
	   * 修改备注： 
	   * @param id</pre>
	   */
	  void deleteStaffinfoLibrary(Integer id);
	
}
