package org.ld.service.paperlessService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.paperlessDao.NoteDao;
import org.ld.model.paperlessModel.NoteModel;
import org.ld.service.paperlessService.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noteService")
public class NoteServiceImpl implements INoteService{

	@Autowired
	private NoteDao noteDao;

	@Override
	public List<NoteModel> findStaffInfoNoteModel(NoteModel note) {
		
		return noteDao.findStaffInfoNoteModel(note);
	}

	@Override
	public void addOrUpdateNoteModel(NoteModel note) {
		//修改
		if(note.getnTId()!=null) {
			noteDao.updateNoteModel(note);
		}else {
		//增加
			note.setCreateTime(new Date());
			noteDao.addNoteModel(note);
		}
	}

	@Override
	public void deleteNoteModel(String ids) {
		List<Integer> idList= new ArrayList<>();
		if(!StringUtils.isEmpty(ids)) {
		String[] idlist = ids.split(",");
		for(String id :idlist) {
			Integer idInt = Integer.valueOf(id);
			idList.add(idInt);
			}	
		}
		noteDao.deleteNoteModel(idList);
	}
}
