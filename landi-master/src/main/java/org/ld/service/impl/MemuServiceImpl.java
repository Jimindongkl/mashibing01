package org.ld.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ld.dao.MemuDao;
import org.ld.model.Memu;
import org.ld.service.IMemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memuService")
public class MemuServiceImpl implements IMemuService{

	@Autowired
	private MemuDao memuDao;
	
	@Override
	public List queryMenuList() {
		List<Memu> menuList = memuDao.queryMenuList();
		return menuTree(menuList, 0);
	}
	
	/**
	 * <pre>menuTree(递归)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:46:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:46:52    
	 * 修改备注： 
	 * @param menuList
	 * @param pid
	 * @return</pre>
	 */
	private List<Map<String, Object>> menuTree(List<Memu> menuList, Integer pid) {
		List<Map<String, Object>> treeData = new ArrayList<Map<String, Object>>();
		for (Memu memu : menuList) {
			Map<String, Object> map = null;
			if (pid == memu.getParentID()) {
				map = new HashMap<String, Object>();
				map.put("id", memu.getId());
				map.put("name", memu.getBlockName());
				map.put("order", memu.getSerial());
				map.put("parentID", memu.getParentID());
				map.put("children", menuTree(menuList, memu.getId()));
			}
			if (map != null) {
				treeData.add(map);
			}
		}
		return treeData;

	}

	

	
	
}
