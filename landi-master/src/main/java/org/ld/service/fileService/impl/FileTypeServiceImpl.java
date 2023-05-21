package org.ld.service.fileService.impl;

import java.util.List;

import org.ld.dao.fileDao.FileTypeDao;
import org.ld.model.fileModel.FileType;
import org.ld.service.fileService.IFileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileTypeService")
public class FileTypeServiceImpl implements IFileTypeService{

	@Autowired
	private FileTypeDao fileTypeDao;

	@Override
	public List<FileType> findFileTypes() {
		// TODO Auto-generated method stub
		return fileTypeDao.findFileTypes();
	}
	
	
}
