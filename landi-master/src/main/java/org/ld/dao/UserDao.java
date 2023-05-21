package org.ld.dao;

import org.ld.model.User;

public interface UserDao {
	
	/**
	 * <pre>selectByUserName(按名字检验人员是否存在)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:41:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:41:27    
	 * 修改备注： 
	 * @param USERNAME
	 * @return</pre>
	 */
	 User selectByUserName(String USERNAME);


}