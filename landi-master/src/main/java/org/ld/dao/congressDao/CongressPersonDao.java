package org.ld.dao.congressDao;

import java.util.List;
import java.util.Map;

import org.ld.model.congressModel.CongressPerson;
import org.ld.vo.CongressPersonSeatUnitVo;

public interface CongressPersonDao {

	/**
	 * <pre>
	 * getCongressPersonList(查询跟会议绑定的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 下午2:10:40    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 下午2:10:40    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	List<CongressPersonSeatUnitVo> getCongressPersonList(CongressPerson congressPerson);

	/**
	 * <pre>
	 * addCongressPerson(增加绑定会议的参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 上午10:01:59    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 上午10:01:59    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * </pre>
	 */
	void addCongressPerson(CongressPerson congressPerson);

	/**
	 * <pre>
	 * findCongressPersonByID(会议人员的回显)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 上午9:24:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 上午9:24:05    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	Map findCongressPersonByID(CongressPerson congressPerson);

	/**
	 * <pre>
	 * updateCongressPerson(修改CongressPerson)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 上午11:29:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 上午11:29:37    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * </pre>
	 */
	void updateCongressPerson(CongressPerson congressPerson);

	/**
	 * <pre>
	 * deleteCongressPersons(批量删除(解绑)会议绑定参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午2:18:13    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午2:18:13    
	 * 修改备注： 
	 * &#64;param idList
	 * </pre>
	 */
	void deleteCongressPersons(List<Integer> idList);

	/**
	 * <pre>addBatchCongressPerson(批量绑定会议绑定参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午3:30:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午3:30:52    
	 * 修改备注： 
	 * @param congressPersons</pre>
	 */
	void addBatchCongressPerson(List<CongressPerson> congressPersons);

	/**
	 * <pre>findCongressPersonIDs(查询会议下的人员id集合)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午5:10:21    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午5:10:21    
	 * 修改备注： 
	 * @param congressID
	 * @return</pre>
	 */
	List<Integer> findCongressPersonIDs(Integer congressID);

	/**
	 * <pre>getIDSCongressPersonList(按主键id的集合查询CongressPerson)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月13日 下午2:20:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月13日 下午2:20:06    
	 * 修改备注： 
	 * @param idList
	 * @return</pre>
	 */
	List<CongressPerson> getIDSCongressPersonList(List<Integer> idList);

}
