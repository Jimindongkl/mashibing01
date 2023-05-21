package org.ld.service.impl;

import java.util.List;

import org.ld.dao.NationDao;
import org.ld.model.Nation;
import org.ld.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("nationService")
public class NationServiceImpl implements INationService{

	@Autowired
	private NationDao nationDao;
	
	@Override
	public List<Nation> getNationList() {
		
		return nationDao.getNationList();
	}

	
	
}
