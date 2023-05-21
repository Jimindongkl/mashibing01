package org.ld.dao;

import java.util.List;

import org.ld.model.Nation;

public interface NationDao {
	
	/**
	 * <pre>getNationList(民族列表展示)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午10:28:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午10:28:27    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<Nation> getNationList();

	/**
	 * <pre>findNationId(按条件查询)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月11日 下午4:35:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月11日 下午4:35:38    
	 * 修改备注： 
	 * @param nation
	 * @return</pre>
	 */
	Nation findNationId(Nation nation);

	

}
