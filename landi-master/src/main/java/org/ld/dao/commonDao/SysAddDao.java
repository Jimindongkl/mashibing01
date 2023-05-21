package org.ld.dao.commonDao;

import org.ld.model.commonModel.SysAdd;

public interface SysAddDao {

	/**
	 * <pre>findSysAddModel(查询议题追加状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午3:38:48    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午3:38:48    
	 * 修改备注： 
	 * @return</pre>
	 */
	SysAdd findSysAddModel();

	/**
	 * <pre>updateSysAddModel(修改议题追加状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午4:11:18    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午4:11:18    
	 * 修改备注： 
	 * @param sysAdd</pre>
	 */
	void updateSysAddModel(SysAdd sysAdd);

	
}
