package org.ld.dao;

import java.util.List;

import org.ld.model.Screen;

public interface ScreenDao {

	/**
	 * <pre>
	 * findScreenList(查询屏幕详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午10:27:44    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午10:27:44    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	List<Screen> findScreenList();

	/**
	 * <pre>
	 * addScreen(增加屏幕)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午10:29:57    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午10:29:57    
	 * 修改备注： 
	 * &#64;param screen
	 * </pre>
	 * 
	 * @return
	 */
	int addScreen(Screen screen);

	/**
	 * <pre>
	 * updateScreen(修改屏幕参数)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午10:38:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午10:38:51    
	 * 修改备注： 
	 * &#64;param screen
	 * </pre>
	 */
	void updateScreen(Screen screen);

	/**
	 * <pre>
	 * deleteBatchScreen(批量删除屏幕)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午11:08:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午11:08:52    
	 * 修改备注： 
	 * &#64;param lists
	 * </pre>
	 */
	void deleteBatchScreen(List<Integer> lists);

}
