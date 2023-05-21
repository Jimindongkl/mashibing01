package org.ld.service.paperlessService;

import java.util.List;

import org.ld.model.paperlessModel.NoteModel;

public interface INoteService {

	//查看当前会议下的日程人员的笔记
	List<NoteModel> findStaffInfoNoteModel(NoteModel note);

	//修改,增加笔记
	void addOrUpdateNoteModel(NoteModel note);

	//删除笔记
	void deleteNoteModel(String ids);
	

}
