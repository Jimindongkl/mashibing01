package org.ld.controller.congressController;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.congressModel.CongressPerson;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.congressService.ICongressPersonService;
import org.ld.vo.CongressPersonSeatUnitVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <pre>
 * 项目名称：landi-master    
 * 类名称：CongressPersonController    
 * 类描述：    会议绑定人员
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月27日 下午5:17:25    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月27日 下午5:17:25    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("congressPersonController")
public class CongressPersonController {

	@Resource(name = "congressPersonService")
	private ICongressPersonService congressPersonService;

	/**
	 * <pre>
	 * getCongressPersonList(查询跟会议绑定的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 下午2:07:11    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 下午2:07:11    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("getCongressPersonList")
	@ResponseBody
	public ResponseServer getCongressPersonList(CongressPerson congressPerson) {
		List<CongressPersonSeatUnitVo> congressPersons = congressPersonService.getCongressPersonList(congressPerson);
		return ResponseServer.success(congressPersons);
	}

	/**
	 * <pre>
	 * addCongressPerson(增加绑定会议的参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 上午9:57:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 上午9:57:50    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("addCongressPerson")
	@ResponseBody
	public ResponseServer addCongressPerson(CongressPerson congressPerson) {
		congressPersonService.addCongressPerson(congressPerson);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * addCongressPerson(回显)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 上午9:18:28    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 上午9:18:28    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("findCongressPersonByID")
	@ResponseBody
	public ResponseServer findCongressPersonByID(CongressPerson congressPerson) {
		Map map = congressPersonService.findCongressPersonByID(congressPerson);
		return ResponseServer.success(map);
	}

	/**
	 * <pre>
	 * updateCongressPerson(修改绑定会议的参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 上午11:36:24    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 上午11:36:24    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("updateCongressPerson")
	@ResponseBody
	public ResponseServer updateCongressPerson(CongressPerson congressPerson) {
		congressPersonService.updateCongressPerson(congressPerson);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * deleteCongressPersons(批量删除(解绑)会议绑定参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午2:08:24    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午2:08:24    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("deleteCongressPersons")
	@ResponseBody
	public ResponseServer deleteCongressPersons(String ids) {
		congressPersonService.deleteCongressPersons(ids);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>addCongressPersonsList(增加全部或选中参会人员到会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午3:20:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午3:20:27    
	 * 修改备注： 
	 * @param ids
	 * @return</pre>
	 */
	@RequestMapping("addCongressPersonsList")
	@ResponseBody
	public ResponseServer addCongressPersonsList(String persons,Integer congressID,String typeId) {
		if(StringUtils.isNotEmpty(persons) && congressID!=null) {
			String str = congressPersonService.addCongressPersonsList(persons,congressID,typeId);
			return ResponseServer.success(str);
		}
		return ResponseServer.error(ResponseEnum.NAME_NULL);
	}

	
}
