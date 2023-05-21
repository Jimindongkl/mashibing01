package org.ld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.StaffGroupDao;
import org.ld.dao.StaffInfoDao;
import org.ld.model.StaffCategory;
import org.ld.model.StaffGroup;
import org.ld.model.StaffInfo;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffGroupService")
public class StaffGroupServiceImpl implements IStaffGroupService{

	@Autowired
	private StaffGroupDao staffGroupDao;
	
	@Autowired
	private StaffInfoDao staffInfoDao;

	@Override
	public List<StaffGroup> getStaffGroupList() {
		
		return staffGroupDao.getStaffGroupList();
	}

	@Override
	public void addorupdateStaffGroup(StaffGroup staffGroup) {
		if(staffGroup.getId()!=null) {
			staffGroupDao.updateStaffGroup(staffGroup);
		}else {
			//增加人员团组时名称不能相同
			//查看数据库中是否有相同的名字
			List<StaffGroup> staffGroups=staffGroupDao.findGroupNameEqual(staffGroup);
			if(staffGroups.size()==0) {
				//增加
				staffGroupDao.addStaffGroup(staffGroup);
			}
		}
	}

	@Override
	public ResponseServer deleteStaffGroup(String ids) {
		String str = "";
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			List<Integer> idNotList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				Integer intId = Integer.parseInt(id);
				// 查看人员团组是否绑定人员
				List<StaffInfo> staffInfos = staffInfoDao.findStaffGroupIsStaffInfo(intId);
				if (staffInfos.size() > 0) {
					idNotList.add(intId);
				} else {
					idList.add(intId);
				}
			}
			if (idList.size() > 0) {
				staffGroupDao.deleteStaffGroup(idList);
			}
			if (idNotList.size() > 0) {
				str += "成功删除" + idList.size() + "条数据;" + "共" + idNotList.size() + "条数据绑定基础人员;" + "失败删除"
						+ idNotList.size() + "条数据";
			} else {
				str += "成功删除" + idList.size() + "条数据;";
			}
		}
		return ResponseServer.success(str);
	}

	@Override
	public StaffGroup findStaffGroupModel(StaffGroup staffGroup) {
		
		return staffGroupDao.findStaffGroupModel(staffGroup);
	}
	
	
	
	
}
