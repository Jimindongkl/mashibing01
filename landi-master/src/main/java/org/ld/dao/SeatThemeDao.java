package org.ld.dao;

import java.util.List;

import org.ld.model.SeatTheme;

public interface SeatThemeDao {

	/**
	 * <pre>getSeatThemes(查询席位图标主题套图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月1日 下午2:02:14    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月1日 下午2:02:14    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<SeatTheme> getSeatThemes();

	/**
	 * <pre>updateSeatTheme(修改席位图标主题套图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月1日 下午4:42:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月1日 下午4:42:29    
	 * 修改备注： 
	 * @param seatTheme</pre>
	 */
	void updateSeatTheme(SeatTheme seatTheme);

}
