package org.ld.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.StaffCategory;
import org.ld.model.StaffLibrary;
import org.ld.model.StaffRelation;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffCategoryService;
import org.ld.service.IStaffLibraryService;
import org.ld.service.IStaffRelationService;
import org.ld.vo.StaffInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("staffLibraryController")
public class StaffLibraryController {

	@Resource(name = "staffLibraryService")
	private IStaffLibraryService staffLibraryfoService;
	
	@Resource(name = "staffRelationService")
	private IStaffRelationService staffRelationService;
	
	
	/**
	 * <pre>staffLibraryList(查询人员分类)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 上午11:16:58    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 上午11:16:58    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/staffLibraryList")
	@ResponseBody 
	public ResponseServer staffLibraryList() {
		List staffLibrarys=staffLibraryfoService.queryStaffLibraryList();
		return ResponseServer.success(staffLibrarys);
	}
	
	/**
	 * <pre>staffLibraryList(按人员类别查询人员类型和人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 上午11:26:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 上午11:26:54    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/findStaffinfoLibraryList")
	@ResponseBody 
	public ResponseServer findStaffinfoLibraryList(Integer id) {
		List<StaffInfoVo> list=staffLibraryfoService.findStaffinfoLibraryList(id);
		return ResponseServer.success(list);
	}
	
	/**
	 * <pre>addStaffinfoLibrary(增加或修改类别)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 下午1:01:22    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 下午1:01:22    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/addorupdateStaffinfoLibrary")
	@ResponseBody 
	public ResponseServer addorupdateStaffinfoLibrary(StaffLibrary staffLibrary) {
		if(!StringUtils.isEmpty(staffLibrary.getStaffLibraryName())) {
			staffLibraryfoService.addorupdateStaffinfoLibrary(staffLibrary);
		}else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
		return ResponseServer.success();
	}
	
	/**
	 * <pre>deleteStaffinfoLibrary(删除人员分类)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月17日 下午4:26:30    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月17日 下午4:26:30    
	 * 修改备注： 
	 * @param id
	 * @return</pre>
	 */
	@RequestMapping("/deleteStaffinfoLibrary")
	@ResponseBody 
	public ResponseServer deleteStaffinfoLibrary(Integer id) {
		List<StaffRelation> staffRelations=staffRelationService.queryStaffRelationList(id);
		if(staffRelations.size()>0) {
			return ResponseServer.error(ResponseEnum.CORRELATION_YES);
		}else {
			staffLibraryfoService.deleteStaffinfoLibrary(id);
			return ResponseServer.success();
		}
	}
	
	/**
	 * <pre>queryStaffCategoryInfoList(按照人员类型查询基础人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月18日 下午6:00:34    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月18日 下午6:00:34    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/queryStaffCategoryInfoList")
	@ResponseBody
	public  ResponseServer queryStaffCategoryInfoList(String name) {
		Map map=staffLibraryfoService.queryStaffCategoryInfoList(name);
		return ResponseServer.success(map);
	}
	
	/**
	 * <pre>saveStaffCategoryInfos(增加基础人员与人员类别的关系)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月19日 上午9:25:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月19日 上午9:25:12    
	 * 修改备注： 
	 * @param liIs
	 * @param infos
	 * @return</pre>
	 */
	@RequestMapping("/saveStaffCategoryInfos")
	@ResponseBody
	public  ResponseServer saveStaffCategoryInfos(Integer liIs,String infos) {
		staffLibraryfoService.saveStaffCategoryInfos(liIs,infos);
		return ResponseServer.success();
	}
	
	
	
	
	
	
}
