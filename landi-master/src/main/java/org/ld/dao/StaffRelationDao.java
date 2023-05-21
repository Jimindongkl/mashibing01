package org.ld.dao;

import java.util.List;

import org.ld.model.StaffRelation;

public interface StaffRelationDao {

	/**
	 * <pre>queryStaffRelationList(按人员类型id查询)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 下午5:01:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 下午5:01:37    
	 * 修改备注： 
	 * @param id
	 * @return</pre>
	 */
	List<StaffRelation> queryStaffRelationList(Integer sLID);

	/**
	 * <pre>saveStaffCategoryInfos(增加基础人员与人员分类的关系)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月18日 下午6:43:45    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月18日 下午6:43:45    
	 * 修改备注： 
	 * @param liIs
	 * @param infos</pre>
	 */
	void saveStaffCategoryInfos(List<StaffRelation> staffRelations);


	
}
