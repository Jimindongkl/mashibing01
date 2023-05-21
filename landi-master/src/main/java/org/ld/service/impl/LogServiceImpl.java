package org.ld.service.impl;

import org.ld.dao.LogDao;
import org.ld.dao.UserDao;
import org.ld.model.Log;
import org.ld.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl implements ILogService{

	@Autowired
	private LogDao Logdao;
	
	@Override
	public void saveLog(Log log) {
		
		Logdao.saveLog(log);
	}

	
	
}
