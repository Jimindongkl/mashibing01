package org.ld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.StaffCategoryDao;
import org.ld.dao.StaffInfoDao;
import org.ld.model.StaffCategory;
import org.ld.model.StaffInfo;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffCategoryService")
public class StaffCategoryServiceImpl implements IStaffCategoryService{

	@Autowired
	private StaffCategoryDao staffCategoryDao;
	
	@Autowired
	private StaffInfoDao staffInfoDao;

	@Override
	public List<StaffCategory> getStaffCategoryList() {
		
		return staffCategoryDao.getStaffCategoryList();
	}

	@Override
	public void addorupdateStaffCategory(StaffCategory staffCategory) {
		if(staffCategory.getId()!=null) {
			//修改
			staffCategoryDao.updateStaffCategory(staffCategory);
		}else {
			//增加人员类别时名称不能相同
			//查看数据库中是否有相同的名字
			List<StaffCategory> staffCategorys=staffCategoryDao.findCategoryNameEqual(staffCategory);
			if(staffCategorys.size()==0) {
				//增加
				staffCategoryDao.addStaffCategory(staffCategory);
			}
			
		}
		
	}

	@Override
	public ResponseServer deleteStaffCategory(String ids) {
		String str = "";
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			List<Integer> idNotList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				Integer intId = Integer.parseInt(id);
				// 判断人员类别是否绑定人员
				List<StaffInfo> staffInfos = staffInfoDao.findstaffCategoryIsStaffInfo(intId);
				if (staffInfos.size() > 0) {
					idNotList.add(intId);
				} else {
					idList.add(intId);
				}
			}
			if (idList.size() > 0) {
				staffCategoryDao.deleteStaffCategory(idList);
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
	public StaffCategory findStaffCategoryModel(StaffCategory staffCategory) {
		
		return staffCategoryDao.findStaffCategoryModel(staffCategory);
	}

	
	
	
	
	
}
