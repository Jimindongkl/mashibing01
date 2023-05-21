package org.ld.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ld.model.Dictionary;
import org.ld.response.ResponseServer;
import org.ld.service.IPoliticalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：PoliticalController    
 * 类描述：    党派
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月9日 下午5:08:02    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月9日 下午5:08:02    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("politicalController")
public class PoliticalController {

	@Resource(name="politicalService")
	private IPoliticalService politicalService;
	
	/**
	 * <pre>politicalList(查询党派列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月9日 下午5:20:49    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月9日 下午5:20:49    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/politicalList")
	@ResponseBody
	public ResponseServer politicalList() {
		List<Dictionary> dictionarys=politicalService.politicalList();
		return ResponseServer.success(dictionarys);
	}
	
	
}
