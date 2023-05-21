package org.ld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.StaffCategoryDao;
import org.ld.dao.StaffInfoDao;
import org.ld.dao.StaffLibraryDao;
import org.ld.dao.StaffRelationDao;
import org.ld.model.StaffCategory;
import org.ld.model.StaffInfo;
import org.ld.model.StaffLibrary;
import org.ld.model.StaffRelation;
import org.ld.service.IStaffLibraryService;
import org.ld.vo.StaffInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffLibraryService")
public class StaffLibraryServiceImpl implements IStaffLibraryService{

	@Autowired
	private StaffLibraryDao staffLibraryDao;
	
	@Autowired
	private StaffInfoDao staffInfoDao;
	
	@Autowired
	private StaffCategoryDao staffCategoryDao;
	
	@Autowired
	private StaffRelationDao staffRelationDao;


	@Override
	public List queryStaffLibraryList() {
		List<StaffLibrary> staffLibraryList = staffLibraryDao.queryStaffLibraryList();
		return staffLibraryTree(staffLibraryList, 0);
	}
	
	/**
	 * <pre>staffLibraryTree(递归)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 上午10:40:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 上午10:40:54    
	 * 修改备注： 
	 * @param staffLibraryList
	 * @param pid
	 * @return</pre>
	 */
	private List<Map<String, Object>> staffLibraryTree(List<StaffLibrary> staffLibraryList, Integer pid) {
		List<Map<String, Object>> treeData = new ArrayList<Map<String, Object>>();
		for (StaffLibrary staffLibrary : staffLibraryList) {
			Map<String, Object> map = null;
			if (pid == staffLibrary.getParentID()) {
				map = new HashMap<String, Object>();
				map.put("id", staffLibrary.getId());
				map.put("name", staffLibrary.getStaffLibraryName());
				//map.put("order", memu.getSerial());
				map.put("parentID", staffLibrary.getParentID());
				map.put("children", staffLibraryTree(staffLibraryList, staffLibrary.getId()));
			}
			if (map != null) {
				treeData.add(map);
			}
		}
		return treeData;

	}

	@Override
	public List<StaffInfoVo> findStaffinfoLibraryList(Integer id) {
		List<StaffInfo> staffInfos = staffInfoDao.findStaffinfoLibraryList(id);
		List<StaffInfoVo> staffInfoVos = new ArrayList<>();
		//po转vo
		for(int i=0;i<staffInfos.size();i++) {
			StaffInfoVo staffInfoVo = new StaffInfoVo();
			staffInfoVo.setId(staffInfos.get(i).getId());
			staffInfoVo.setName(staffInfos.get(i).getName());
			staffInfoVo.setNum(staffInfos.get(i).getNum());
			staffInfoVos.add(staffInfoVo);
		}
		return staffInfoVos;
	}

	@Override
	public void addorupdateStaffinfoLibrary(StaffLibrary staffLibrary) {
		if(staffLibrary.getId()==null) {
			staffLibrary.setCreateTime(new Date());
			staffLibraryDao.addStaffinfoLibrary(staffLibrary);
		}else {
			staffLibraryDao.updateStaffinfoLibrary(staffLibrary);
		}
		
	}

	@Override
	public void deleteStaffinfoLibrary(Integer id) {
		
		staffLibraryDao.deleteStaffinfoLibrary(id);
	}

	@Override
	public Map queryStaffCategoryInfoList(String name) {
		//查询人员类别	
		List<StaffCategory> list =  staffCategoryDao.getStaffCategoryList();
		Map<String,Object> map = new HashMap<>();	
		StaffInfo staffInfo = new StaffInfo();
		for(int i=0;i<list.size();i++) {
			staffInfo.getStaffCategory().setId(list.get(i).getId());
			staffInfo.setName(name);
			map.put(list.get(i).getCategoryName(), staffInfoDao.findStaffInfoAll(staffInfo));
		}	
		return map;
	}

	@Override
	public void saveStaffCategoryInfos(Integer liIs, String infos) {
		if (StringUtils.isNotEmpty(infos)) {
			// 字符串转List
			List<StaffRelation> staffRelations = new ArrayList<>();
			String[] idArr = infos.split(",");
			for (String id : idArr) {
				StaffRelation staffRelation = new StaffRelation();
				staffRelation.setsLID(liIs);
				staffRelation.setStaffInfoID(Integer.parseInt(id));
				staffRelation.setCreateTime(new Date());
				staffRelations.add(staffRelation);
			}
		staffRelationDao.saveStaffCategoryInfos(staffRelations);
		}
	}
	
	
}
