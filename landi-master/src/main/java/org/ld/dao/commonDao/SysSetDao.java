package org.ld.dao.commonDao;

import java.util.List;

import org.ld.model.commonModel.SysSet;

public interface SysSetDao {

	List<SysSet> findSysSetList();

	void updateSysSetModel(SysSet sysSet);
	
	List<SysSet> findTopicNumSetting();

	List<SysSet> queryKeyNameList(Integer in);

}
