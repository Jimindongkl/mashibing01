package org.ld.dao;

import java.util.List;

import org.ld.model.Screen;
import org.ld.model.ScreenForm;
import org.ld.vo.ScreenJsonVo;

public interface ScreenFormDao {

	/**
	 * <pre>
	 * findScreenFormList(查询窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午3:10:02    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午3:10:02    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	List<ScreenForm> findScreenFormList(Screen screen);

	/**
	 * <pre>
	 * updateScreenForm(修改窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午3:43:22    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午3:43:22    
	 * 修改备注： 
	 * &#64;param screenForm
	 * </pre>
	 */
	void updateScreenForm(ScreenForm screenForm);

	/**
	 * <pre>
	 * addScreenForm(增加窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午3:43:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午3:43:43    
	 * 修改备注： 
	 * &#64;param screenForm
	 * </pre>
	 */
	void addScreenForm(ScreenForm screenForm);

	/**
	 * <pre>
	 * deleteBatchScreenForm(批量删除窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午4:45:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午4:45:06    
	 * 修改备注： 
	 * &#64;param list
	 * </pre>
	 */
	void deleteBatchScreenForm(List<Integer> list);

	/**
	 * <pre>
	 * findScreenFormContent(按窗体ID查询窗体的布局)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 上午10:25:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 上午10:25:56    
	 * 修改备注： 
	 * &#64;param screenForm
	 * &#64;return
	 * </pre>
	 */
	ScreenForm findScreenFormContent(ScreenForm screenForm);

	/**
	 * <pre>
	 * updateScreenFormContent(按窗体ID修改窗体的布局)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 上午10:47:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 上午10:47:12    
	 * 修改备注： 
	 * &#64;param screenForm
	 * </pre>
	 */
	void updateScreenFormContent(ScreenForm screenForm);

	/**
	 * <pre>findScreenformeventList(这里用一句话描述这个方法的作用)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月8日 下午3:13:33    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月8日 下午3:13:33    
	 * 修改备注： 
	 * @param screenJsonVo
	 * @return</pre>
	 */
	List<ScreenForm> findScreenformeventList(ScreenJsonVo screenJsonVo);
	
}
