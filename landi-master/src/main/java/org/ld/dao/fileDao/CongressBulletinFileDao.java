package org.ld.dao.fileDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ld.model.fileModel.CongressBulletinFile;

public interface CongressBulletinFileDao {
	
	/**
	 * <pre>findCongressIDToCongressBulletinFiles(按会议的id查询会议下的全部文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 上午11:13:22    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 上午11:13:22    
	 * 修改备注： 
	 * @param congressBulletinFile
	 * @return</pre>
	 */
	List<CongressBulletinFile> findCongressIDToCongressBulletinFiles(CongressBulletinFile congressBulletinFile);
	
	/**
	 * <pre>getMaxCongressBulletinFileOrder(查询最大排序)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午1:52:23    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午1:52:23    
	 * 修改备注： 
	 * @return</pre>
	 */
	Integer getMaxCongressBulletinFileOrder();

	/**
	 * <pre>addBatchCongressBulleFiles(批量增加会议文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午1:55:13    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午1:55:13    
	 * 修改备注： 
	 * @param congressBulletinFiles</pre>
	 */
	void addBatchCongressBulleFiles(List<CongressBulletinFile> congressBulletinFiles);

	/**
	 * <pre>findCongressBulletinFileName(查询文件的名字)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午3:28:00    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午3:28:00    
	 * 修改备注： 
	 * @param idList
	 * @return</pre>
	 */
	List<CongressBulletinFile> findCongressBulletinFileName(List<Integer> idList);

	/**
	 * <pre>deleteCongresBulletinFiles(删除数据库中的数据)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午3:31:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午3:31:37    
	 * 修改备注： 
	 * @param idList</pre>
	 */
	void deleteCongresBulletinFiles(List<Integer> idList);

	/**
	 * <pre>updateBatchCongresBulletinFiles(文件排序上移下移)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午4:57:42    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午4:57:42    
	 * 修改备注： 
	 * @param congressBulletinFiles</pre>
	 */
	void updateBatchCongresBulletinFiles(List<CongressBulletinFile> congressBulletinFiles);

	/**
	 * <pre>findPaperlessNowCongressScheduleFile(查询当前的会议的日程及分组文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月29日 下午4:06:21    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月29日 下午4:06:21    
	 * 修改备注： 
	 * @param congressId
	 * @param status
	 * @return</pre>
	 */
	List<CongressBulletinFile> findPaperlessNowCongressScheduleFile(@Param("congressId")Integer congressId, @Param("fileType")Integer fileType);

	/**
	 * <pre>addCongressBulleFile(单个增加会议文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月10日 上午9:45:42    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月10日 上午9:45:42    
	 * 修改备注： 
	 * @param congressBulletinFileNew</pre>
	 */
	void addCongressBulleFile(CongressBulletinFile congressBulletinFileNew);

}
