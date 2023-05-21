package org.ld.dao.fileDao;

import java.util.List;

import org.ld.model.fileModel.CongressFile;

public interface CongressFileDao {

	/**
	 * <pre>
	 * getMaxCongressFileOrder(查询全部文件中最大的排序)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午1:42:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午1:42:20    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	Integer getMaxCongressFileOrder();

	/**
	 * <pre>
	 * addBatchCongressFiles(批量增加文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午1:55:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午1:55:05    
	 * 修改备注： 
	 * &#64;param congressFiles
	 * </pre>
	 */
	void addBatchCongressFiles(List<CongressFile> congressFiles);

	/**
	 * <pre>
	 * findCongressFiles(按条件查询文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午2:13:03    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午2:13:03    
	 * 修改备注： 
	 * &#64;param congressFile
	 * &#64;return
	 * </pre>
	 */
	List<CongressFile> findCongressFiles(CongressFile congressFile);

	/**
	 * <pre>
	 * updateCongressFile(修改文件的参数)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午4:34:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午4:34:37    
	 * 修改备注： 
	 * &#64;param congressFile
	 * </pre>
	 */
	void updateCongressFile(CongressFile congressFile);

	/**
	 * <pre>
	 * deleteCongresFiles(删除文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午4:45:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午4:45:06    
	 * 修改备注： 
	 * &#64;param idList
	 * </pre>
	 */
	void deleteCongresFiles(List<Integer> idList);

	/**
	 * <pre>
	 * findcongressFileName(查询文件的名字)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午4:57:58    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午4:57:58    
	 * 修改备注： 
	 * &#64;param idList
	 * &#64;return
	 * </pre>
	 */
	List<CongressFile> findCongressFileName(List<Integer> idList);

	/**
	 * <pre>
	 * updateBatchCongresFiles(批量修改会议文件的序号)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午6:27:24    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午6:27:24    
	 * 修改备注： 
	 * &#64;param congressFiles
	 * </pre>
	 */
	void updateBatchCongresFiles(List<CongressFile> congressFiles);

	/**
	 * <pre>getCongressIdFindCongressFile(按会议id查询会议所属的会议文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月24日 下午2:47:49    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月24日 下午2:47:49    
	 * 修改备注： 
	 * @param congressID
	 * @return</pre>
	 */
	List<CongressFile> getCongressIdFindCongressFile(Integer congressID);

	/**
	 * <pre>addCongressFile(单个增加文件) 
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年10月10日 上午11:46:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年10月10日 上午11:46:27    
	 * 修改备注： 
	 * @param congressFileNew</pre>
	 */
	void addCongressFile(CongressFile congressFileNew);

}
