package org.ld.dao;

import java.util.List;

import org.ld.model.StaffCategory;

public interface StaffCategoryDao {
	
	/**
	 * <pre>getStaffCategoryList(查询人员类型列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午10:47:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午10:47:43    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<StaffCategory> getStaffCategoryList();
	
	/**
	 * <pre>updateStaffCategory(增加人员类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午10:47:36    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午10:47:36    
	 * 修改备注： 
	 * @param staffCategory</pre>
	 */
	void addStaffCategory(StaffCategory staffCategory);
	
	/**
	 * <pre>updateStaffCategory(修改人员类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午11:15:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午11:15:56    
	 * 修改备注： 
	 * @param staffCategory</pre>
	 */
	void updateStaffCategory(StaffCategory staffCategory);
	
	/**
	 * <pre>deleteStaffCategory(批量删除人员类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午11:36:19    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午11:36:19    
	 * 修改备注： 
	 * @param idList</pre>
	 */
	void deleteStaffCategory(List<Integer> idList);

	/**
	 * <pre>findStaffCategoryModel(条件查询返回对象)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月15日 上午11:31:44    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月15日 上午11:31:44    
	 * 修改备注： 
	 * @param staffCategory
	 * @return</pre>
	 */
	StaffCategory findStaffCategoryModel(StaffCategory staffCategory);

	/**
	 * <pre>findCategoryNameEqual(查看数据库中是否有相同的名字)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月6日 下午4:01:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月6日 下午4:01:16    
	 * 修改备注： 
	 * @param staffCategory
	 * @return</pre>
	 */
	List<StaffCategory> findCategoryNameEqual(StaffCategory staffCategory);
	

}
