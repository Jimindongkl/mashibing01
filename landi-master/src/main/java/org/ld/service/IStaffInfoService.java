package org.ld.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.ld.model.StaffInfo;
import org.ld.poi.StaffInfoPoi;
import org.ld.response.ResponseServer;

public interface IStaffInfoService {

	Long getCount(StaffInfo staffInfo);

	List<StaffInfo> getStaffInfoPageList(StaffInfo staffInfo);

	void addOrUpdateStaffInfo(StaffInfo staffInfo);

	ResponseServer deleteStaffInfo(String ids);

	void exportExcelStaffInfo(StaffInfo staffInfo, HttpServletResponse response);

	void addBatch(List<StaffInfoPoi> list);

	List<StaffInfo> getStaffInfoList(StaffInfo staffInfo);

	StaffInfo getUserByUserName(String userName);
	 

	
}
