package org.ld.service.commonService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.commonDao.SysAddDao;
import org.ld.dao.commonDao.SysSetDao;
import org.ld.model.commonModel.SysAdd;
import org.ld.model.commonModel.SysSet;
import org.ld.service.commonService.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commonService")
public class CommonServiceImpl implements ICommonService{

	@Autowired
	private SysAddDao sysAddDao;
	
	@Autowired
	private SysSetDao sYSSetDao;

	@Override
	public SysAdd findSysAddModel() {
		
		return sysAddDao.findSysAddModel();
	}

	@Override
	public void updateSysAddModel(SysAdd sysAdd) {
		Date d = new Date();
		sysAdd.setUpdateTime(d);
		sysAddDao.updateSysAddModel(sysAdd);
	}

	@Override
	public List findSysSetList() {
		List<SysSet> sysSetList = sYSSetDao.findSysSetList();
		return sysSetTree(sysSetList, 0);
	}
	
	
	/**
	 * <pre>sysSetTree(递归)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月17日 下午4:07:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月17日 下午4:07:20    
	 * 修改备注： 
	 * @param sysSetList
	 * @param pid
	 * @return</pre>
	 */
	private List<Map<String, Object>> sysSetTree(List<SysSet> sysSetList, Integer pid) {
		List<Map<String, Object>> treeData = new ArrayList<Map<String, Object>>();
		for (SysSet sysSet : sysSetList) {
			Map<String, Object> map = null;
			if (pid.toString().equals(sysSet.getsYSPID().toString())) {
				map = new HashMap<String, Object>();
				map.put("id", sysSet.getsYSID());
				map.put("key", sysSet.getsYSKey());
				map.put("order", sysSet.getsYSOrder());
				map.put("parentID", sysSet.getsYSPID());
				map.put("memo", sysSet.getsYSMemo());
				map.put("title", sysSet.getsYSTitle());
				map.put("type", sysSet.getsYSType());
				map.put("value", sysSet.getsYSValue());
				map.put("children", sysSetTree(sysSetList, sysSet.getsYSID()));
			}
			if (map != null) {
				treeData.add(map);
			}
		}
		return treeData;

	}

	@Override
	public void updateSysSetModel(SysSet sysSet) {
		sYSSetDao.updateSysSetModel(sysSet);
		
	}

	@Override
	public List<Map<String, Object>> findTopicNumSetting() {
		List<SysSet> sysSetList = sYSSetDao.findSysSetList();
		return sysSetTreeSetting(sysSetList, 1);
	}

	private List<Map<String, Object>> sysSetTreeSetting(List<SysSet> sysSetList, Integer pid) {
		List<Map<String, Object>> treeData = new ArrayList<Map<String, Object>>();
		for (SysSet sysSet : sysSetList) {
			Map<String, Object> map = null;
			if (pid.toString().equals(sysSet.getsYSPID().toString())) {
				map = new HashMap<String, Object>();
				map.put("id", sysSet.getsYSID());
				map.put("key", sysSet.getsYSKey());
				map.put("order", sysSet.getsYSOrder());
				map.put("parentID", sysSet.getsYSPID());
				map.put("memo", sysSet.getsYSMemo());
				map.put("title", sysSet.getsYSTitle());
				map.put("type", sysSet.getsYSType());
				map.put("value", sysSet.getsYSValue());
				map.put("children", sysSetTree(sysSetList, sysSet.getsYSID()));
			}
			if (map != null) {
				treeData.add(map);
			}
		}
		return treeData;

	}

	@Override
	public List<SysSet> queryKeyNameList(String value) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(value)) {
		Integer in = Integer.valueOf(value);	
		return sYSSetDao.queryKeyNameList(in);
		}
		return new ArrayList<SysSet>();
	}

}
