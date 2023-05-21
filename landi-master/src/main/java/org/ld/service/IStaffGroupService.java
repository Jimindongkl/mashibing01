package org.ld.service;

import java.util.List;

import org.ld.model.StaffGroup;
import org.ld.response.ResponseServer;

public interface IStaffGroupService {

	List<StaffGroup> getStaffGroupList();

	void addorupdateStaffGroup(StaffGroup staffGroup);

	ResponseServer deleteStaffGroup(String ids);

	StaffGroup findStaffGroupModel(StaffGroup staffGroup);

	
}
