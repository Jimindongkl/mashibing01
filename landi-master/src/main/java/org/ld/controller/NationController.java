package org.ld.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ld.model.Nation;
import org.ld.model.StaffCategory;
import org.ld.response.ResponseServer;
import org.ld.service.INationService;
import org.ld.service.IStaffCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("nationController")
public class NationController {
	
	@Resource(name = "nationService")
	private INationService nationService;
	
	/**
	 * <pre>nationList(民族展示)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月13日 上午10:27:49    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月13日 上午10:27:49    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/nationList")
	@ResponseBody
	public  ResponseServer nationList() {
		List<Nation> nations=nationService.getNationList();
		return ResponseServer.success(nations);
	}
	
	
	
	
}
