package org.ld.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.StaffGroup;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("staffGroupController")
public class StaffGroupController {
	
	@Resource(name="staffGroupService")
	private IStaffGroupService staffGroupService;
	
	/**
	 * <pre>staffGroupList(查询团组列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月9日 上午10:24:28    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月9日 上午10:24:28    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/staffGroupList")
	@ResponseBody
	public  ResponseServer staffGroupList() {
		List<StaffGroup> staffGroups=staffGroupService.getStaffGroupList();
		return ResponseServer.success(staffGroups);
	}
	
	/**
	 * <pre>addorupdateStaffGroup(增加和修改团组)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 下午2:24:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 下午2:24:43    
	 * 修改备注： 
	 * @param staffGroup
	 * @return</pre>
	 */
	@RequestMapping("/addorupdateStaffGroup")
	@ResponseBody
	public  ResponseServer addorupdateStaffGroup(StaffGroup staffGroup) {
		if(StringUtils.isNotEmpty(staffGroup.getGroupName())) {
			staffGroupService.addorupdateStaffGroup(staffGroup);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}
	
	/**
	 * <pre>deleteStaffGroup(删除团组)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 下午2:26:10    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 下午2:26:10    
	 * 修改备注： 
	 * @param Ids
	 * @return</pre>
	 */
	@RequestMapping("/deleteStaffGroup")
	@ResponseBody
	public  ResponseServer deleteStaffGroup(String Ids) {
		if (StringUtils.isNotEmpty(Ids)) {
			ResponseServer responseServer = staffGroupService.deleteStaffGroup(Ids);
			return responseServer;
		}
		return ResponseServer.error(ResponseEnum.NAME_NULL);
	}
	
	/**
	 * <pre>findStaffGroupModel(条件查询返回对象)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月15日 上午11:49:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月15日 上午11:49:29    
	 * 修改备注： 
	 * @param staffGroup
	 * @return</pre>
	 */
	@RequestMapping("/findStaffGroupModel")
	@ResponseBody
	public  ResponseServer findStaffGroupModel(StaffGroup staffGroup) {
		staffGroup = staffGroupService.findStaffGroupModel(staffGroup);
		return ResponseServer.success(staffGroup);
	}
}
