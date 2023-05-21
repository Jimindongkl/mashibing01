package org.ld.service;

import java.util.List;

import org.ld.model.StaffCategory;
import org.ld.response.ResponseServer;

public interface IStaffCategoryService {

	List<StaffCategory> getStaffCategoryList();

	void addorupdateStaffCategory(StaffCategory staffCategory);

	ResponseServer deleteStaffCategory(String ids);

	StaffCategory findStaffCategoryModel(StaffCategory staffCategory);

}
