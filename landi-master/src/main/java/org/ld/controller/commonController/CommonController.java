package org.ld.controller.commonController;

import java.util.List;

import javax.annotation.Resource;

import org.ld.model.commonModel.SysAdd;
import org.ld.model.commonModel.SysSet;
import org.ld.response.ResponseServer;
import org.ld.service.commonService.ICommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：CommonController    
 * 类描述：     公共Controller
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月25日 下午3:30:15    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月25日 下午3:30:15    
 * 修改备注：       
 * @version </pre>
 */
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("commonController")
public class CommonController {

	@Resource(name = "commonService")
	private ICommonService commonService;
	
	/**
	 * <pre>findSysAddModel(查询议题追加状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午4:00:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午4:00:51    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("findSysAddModel")
	@ResponseBody
	public ResponseServer findSysAddModel() {
		 SysAdd sysAdd = commonService.findSysAddModel();
		return ResponseServer.success(sysAdd);
	}
	
	/**
	 * <pre>updateSysAddModel(修改议题追加状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午4:10:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午4:10:17    
	 * 修改备注： 
	 * @param sysAdd
	 * @return</pre>
	 */
	@RequestMapping("updateSysAddModel")
	@ResponseBody
	public ResponseServer updateSysAddModel(SysAdd sysAdd) {
		if(sysAdd.getId()!=null) {
			 commonService.updateSysAddModel(sysAdd);
		}
		return ResponseServer.success();
	}
	
	/**
	 * <pre>findSysSetList(查询系统设置的列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月17日 下午4:04:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月17日 下午4:04:29    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("findSysSetList")
	@ResponseBody
	public ResponseServer findSysSetList() {
		List d=commonService.findSysSetList();
		return ResponseServer.success(d);
	}
	
	
	/**
	 * <pre>updateSysSetModel(单个修改系统设置)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月17日 下午4:16:55    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月17日 下午4:16:55    
	 * 修改备注： 
	 * @param sysSet
	 * @return</pre>
	 */
	@RequestMapping("updateSysSetModel")
	@ResponseBody
	public ResponseServer updateSysSetModel(SysSet sysSet) {
		if(sysSet.getsYSID()!=null&&sysSet.getsYSID()>0) {
			commonService.updateSysSetModel(sysSet);
		}
		return ResponseServer.success();
	}
	
	
}
