package org.ld.dao.fileDao;

import java.util.List;

import org.ld.model.fileModel.FileType;

public interface FileTypeDao {

	/**
	 * <pre>findFileTypes(查询文件的所有类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月13日 下午5:08:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月13日 下午5:08:56    
	 * 修改备注： 
	 * @return</pre>
	 */
	List<FileType> findFileTypes();

	
}
