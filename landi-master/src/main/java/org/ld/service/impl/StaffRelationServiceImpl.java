package org.ld.service.impl;

import java.util.List;

import org.ld.dao.StaffLibraryDao;
import org.ld.dao.StaffRelationDao;
import org.ld.model.StaffRelation;
import org.ld.service.IStaffRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffRelationService")
public class StaffRelationServiceImpl implements IStaffRelationService{

	@Autowired
	private StaffRelationDao staffRelationDao;

	@Override
	public List<StaffRelation> queryStaffRelationList(Integer sLID) {
		
		return staffRelationDao.queryStaffRelationList(sLID);
	}
	
	
	
}
