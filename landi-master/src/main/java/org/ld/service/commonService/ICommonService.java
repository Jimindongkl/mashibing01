package org.ld.service.commonService;

import java.util.List;
import java.util.Map;

import org.ld.model.commonModel.SysAdd;
import org.ld.model.commonModel.SysSet;

public interface ICommonService {

	SysAdd findSysAddModel();

	void updateSysAddModel(SysAdd sysAdd);

	//查询系统设置的列表
	List findSysSetList();
	//单个修改系统设置
	void updateSysSetModel(SysSet sysSet);
	//查询添加（追加）议题设置
	List<Map<String, Object>> findTopicNumSetting();

	//按条件查询信息
	List<SysSet> queryKeyNameList(String value);

}
