package org.ld.service;

import java.util.List;
import java.util.Map;

import org.ld.model.StaffInfo;
import org.ld.model.StaffLibrary;
import org.ld.vo.StaffInfoVo;

public interface IStaffLibraryService {

	List queryStaffLibraryList();

	List<StaffInfoVo> findStaffinfoLibraryList(Integer id);

	void addorupdateStaffinfoLibrary(StaffLibrary staffLibrary);

	void deleteStaffinfoLibrary(Integer id);

	Map queryStaffCategoryInfoList(String name);

	void saveStaffCategoryInfos(Integer liIs, String infos);

	
}
