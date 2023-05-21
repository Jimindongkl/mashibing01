package org.ld.dao;

import java.util.List;

import org.ld.model.BasicsEvent;

public interface BasicsEventDao {

	/**
	 * <pre>
	 * findBasicsEventList(查询所有事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月27日 下午2:11:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月27日 下午2:11:05    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	List<BasicsEvent> findBasicsEventList();

}
