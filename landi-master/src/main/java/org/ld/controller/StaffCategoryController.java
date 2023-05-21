package org.ld.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.StaffCategory;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：StaffCategoryController    
 * 类描述：    人员类别
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年4月15日 上午11:18:08    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年4月15日 上午11:18:08    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("staffCategoryController")
public class StaffCategoryController {
	
	@Resource(name = "staffCategoryService")
	private IStaffCategoryService staffCategoryService;
	
	/**
	 * <pre>staffCategoryList(查询人员类别列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月9日 上午10:10:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月9日 上午10:10:38    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/staffCategoryList")
	@ResponseBody
	public  ResponseServer staffCategoryList() {
		List<StaffCategory> staffCategorys=staffCategoryService.getStaffCategoryList();
		return ResponseServer.success(staffCategorys);
	}
	
	/**
	 * <pre>addStaffCategory(增加或修改人员类别)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午11:03:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午11:03:38    
	 * 修改备注： 
	 * @param staffCategory
	 * @return</pre>
	 */
	@RequestMapping("/addorupdateStaffCategory")
	@ResponseBody
	public  ResponseServer addorupdateStaffCategory(StaffCategory staffCategory) {
		if(StringUtils.isNotEmpty(staffCategory.getCategoryName())) {
			staffCategoryService.addorupdateStaffCategory(staffCategory);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}
	
	/**
	 * <pre>deleteStaffCategory(批量删除人员类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午11:39:15    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午11:39:15    
	 * 修改备注： 
	 * @param Ids
	 * @return</pre>
	 */
	@RequestMapping("/deleteStaffCategory")
	@ResponseBody
	public  ResponseServer deleteStaffCategory(String Ids) {
		if (StringUtils.isNotEmpty(Ids)) {
			ResponseServer responseServer = staffCategoryService.deleteStaffCategory(Ids);
			return responseServer;
		}
		return ResponseServer.error(ResponseEnum.NAME_NULL);
	}
	
	/**
	 * <pre>findStaffCategoryModel(条件查询返回对象)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月15日 上午11:30:04    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月15日 上午11:30:04    
	 * 修改备注： 
	 * @param staffCategory
	 * @return</pre>
	 */
	@RequestMapping("/findStaffCategoryModel")
	@ResponseBody
	public  ResponseServer findStaffCategoryModel(StaffCategory staffCategory) {
		staffCategory = staffCategoryService.findStaffCategoryModel(staffCategory);
		return ResponseServer.success(staffCategory);
	}
	
	
	
	
}
