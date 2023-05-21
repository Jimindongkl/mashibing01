package org.ld.service.impl;

import java.util.List;

import org.ld.dao.PoliticalDao;
import org.ld.model.Dictionary;
import org.ld.service.IPoliticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("politicalService")
public class PoliticalServiceImpl implements IPoliticalService{

	@Autowired
	private PoliticalDao politicalDao;

	@Override
	public List<Dictionary> politicalList() {
		
		return politicalDao.politicalList();
	}
	
	
	
}
