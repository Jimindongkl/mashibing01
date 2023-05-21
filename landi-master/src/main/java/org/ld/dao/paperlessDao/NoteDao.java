package org.ld.dao.paperlessDao;

import java.util.List;

import org.ld.model.paperlessModel.NoteModel;

public interface NoteDao {

	/**
	 * <pre>findStaffInfoNoteModel(查看当前会议下的日程人员的笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年6月8日 下午2:08:59    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年6月8日 下午2:08:59    
	 * 修改备注： 
	 * @param note
	 * @return</pre>
	 */
	List<NoteModel> findStaffInfoNoteModel(NoteModel note);

	/**
	 * <pre>updateNoteModel(修改笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年6月8日 下午5:01:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年6月8日 下午5:01:35    
	 * 修改备注： 
	 * @param note</pre>
	 */
	void updateNoteModel(NoteModel note);

	/**
	 * <pre>addModel(增加笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年6月8日 下午5:01:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年6月8日 下午5:01:56    
	 * 修改备注： 
	 * @param note</pre>
	 */
	void addNoteModel(NoteModel note);

	/**
	 * <pre>deleteNoteModel(删除笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年7月2日 下午4:12:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年7月2日 下午4:12:52    
	 * 修改备注： 
	 * @param idList</pre>
	 */
	void deleteNoteModel(List<Integer> idList);

	

	
}
