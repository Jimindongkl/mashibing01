package org.ld.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ld.model.StaffRelation;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffRelationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("staffRelationController")
public class StaffRelationController {
	
	@Resource(name = "staffRelationService")
	private IStaffRelationService staffRelationService;
	
	/**
	 * <pre>queryStaffRelationList(按人员分类id查询)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 下午5:10:31    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 下午5:10:31    
	 * 修改备注： 
	 * @param sLID
	 * @return</pre>
	 */
	@RequestMapping("queryStaffRelationList")
	@ResponseBody
	public ResponseServer queryStaffRelationList(Integer sLID){
		List<StaffRelation> staffRelations = staffRelationService.queryStaffRelationList(sLID);             
		return ResponseServer.success(staffRelations);
	}

}
