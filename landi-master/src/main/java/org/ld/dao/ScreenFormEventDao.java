package org.ld.dao;

import java.util.List;

import org.ld.model.Screen;
import org.ld.model.ScreenFormEvent;
import org.ld.vo.ScreenJsonVo;

public interface ScreenFormEventDao {

	/**
	 * <pre>
	 * addBasicsEvent(大屏下增加事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月27日 下午3:18:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月27日 下午3:18:51    
	 * 修改备注： 
	 * &#64;param e 
	 * &#64;param list
	 * </pre>
	 */
	void addBasicsEvent(List<String> list);

	/**
	 * <pre>
	 * deleteBatchScreenFormEvent(按大屏的id删除绑定事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月27日 下午4:00:39    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月27日 下午4:00:39    
	 * 修改备注： 
	 * &#64;param list
	 * </pre>
	 */
	void deleteBatchScreenFormEvent(List<Integer> list);

	/**
	 * <pre>
	 * findScreenEventList(按大屏的id查询事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月27日 下午4:20:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月27日 下午4:20:16    
	 * 修改备注： 
	 * &#64;param screen
	 * &#64;return
	 * </pre>
	 */
	List<ScreenFormEvent> findScreenEventList(Screen screen);

	/**
	 * <pre>
	 * fidscreenForm(按窗体的集合查询绑定事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月27日 下午5:52:46    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月27日 下午5:52:46    
	 * 修改备注： 
	 * &#64;param list
	 * &#64;return
	 * </pre>
	 */
	List<ScreenFormEvent> fidscreenForm(List<Integer> list);

	/**
	 * <pre>
	 * updateFormEvent(绑定事件和窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 上午9:45:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 上午9:45:06    
	 * 修改备注： 
	 * &#64;param screenFormEvent
	 * </pre>
	 */
	void updateFormEvent(ScreenFormEvent screenFormEvent);

	/**
	 * <pre>findScreenExistEventList(查询多块屏幕绑定的不为空的事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月7日 上午11:35:10    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月7日 上午11:35:10    
	 * 修改备注： 
	 * @param list
	 * @return</pre>
	 */
	List<ScreenFormEvent> findScreenExistEventList(List<Integer> ids);

	

}
