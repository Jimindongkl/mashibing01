package org.ld.controller.congressController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.SeatModel;
import org.ld.model.congressModel.AgendaPerson;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ISeatModelService;
import org.ld.service.ISeatUnitService;
import org.ld.service.congressService.IAgendaPersonService;
import org.ld.vo.AgendaPersonResult;
import org.ld.vo.AgendaPersonResultByModelVo;
import org.ld.vo.AgendaPersonSeatUnitVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <pre>
 * 项目名称：landi-master    
 * 类名称：AgendaPersonController    
 * 类描述：    议程绑定人员
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月27日 下午5:16:55    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月27日 下午5:16:55    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("agendaPersonController")
public class AgendaPersonController {

	@Resource(name = "agendaPersonService")
	private IAgendaPersonService agendaPersonService;

	@Resource(name = "seatUnitService")
	private ISeatUnitService seatUnitService;
	
	@Resource(name = "seatModelService")
	private ISeatModelService seatModelService;

	/**
	 * <pre>
	 * getCongressPersonList(查询跟议程绑定的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 下午3:11:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 下午3:11:05    
	 * 修改备注： 
	 * &#64;param congressPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("getAgendaPersonList")
	@ResponseBody
	public ResponseServer getAgendaPersonList(AgendaPerson agendaPerson) {
		if (agendaPerson.getAgendaID() != null) {
			List<AgendaPersonSeatUnitVo> agendaPersons = agendaPersonService.getAgendaPersonList(agendaPerson);
			return ResponseServer.success(agendaPersons);
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}

	/**
	 * <pre>
	 * addAgendaPerson(增加绑定议程的参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 上午11:55:15    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 上午11:55:15    
	 * 修改备注： 
	 * &#64;param AgendaPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("addAgendaPerson")
	@ResponseBody
	public ResponseServer addAgendaPerson(AgendaPerson AgendaPerson) {
		agendaPersonService.addAgendaPerson(AgendaPerson);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * findAgendaPersonByID(回显AgendaPerson)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午12:04:26    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午12:04:26    
	 * 修改备注： 
	 * &#64;param AgendaPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("findAgendaPersonByID")
	@ResponseBody
	public ResponseServer findAgendaPersonByID(AgendaPerson AgendaPerson) {
		AgendaPersonResultByModelVo agendaPersonResultByModelVo = agendaPersonService.findAgendaPersonByID(AgendaPerson);
		return ResponseServer.success(agendaPersonResultByModelVo);
	}

	/**
	 * <pre>
	 * updateAgendaPerson(修改AgendaPerson)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午1:58:39    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午1:58:39    
	 * 修改备注： 
	 * &#64;param agendaPerson
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("updateAgendaPerson")
	@ResponseBody
	public ResponseServer updateAgendaPerson(AgendaPerson agendaPerson) {
		agendaPersonService.updateAgendaPerson(agendaPerson);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * deleteAgendaPersons(批量删除(解绑)议程绑定参会人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午2:23:01    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午2:23:01    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("deleteAgendaPersons")
	@ResponseBody
	public ResponseServer deleteAgendaPersons(String ids) {
		agendaPersonService.deleteAgendaPersons(ids);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * addCongressPersonsList(增加全部或选中参会人员到议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午3:20:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午3:20:27    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("addAgendaPersonsList")
	@ResponseBody
	public ResponseServer addAgendaPersonsList(String persons, Integer agendaID,String typeId) {
		if (StringUtils.isNotEmpty(persons) && agendaID != null) {
			String str = agendaPersonService.addAgendaPersonsList(persons, agendaID,typeId);
			return ResponseServer.success(str);
		}
		return ResponseServer.error(ResponseEnum.NAME_NULL);
	}
	
/**************************************坐席绑定人***************************************************/
	
	/**
	 * <pre>getAgendaPersonParaList(条件查询议程的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月10日 上午10:36:11    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月10日 上午10:36:11    
	 * 修改备注： 
	 * @param aendaPersonResult
	 * @return</pre>
	 */
	@RequestMapping("getAgendaPersonParaList")
	@ResponseBody
	public ResponseServer getAgendaPersonParaList(AgendaPersonResult aendaPersonResult) {
		// 查询议程下的人员
		List<AgendaPersonResult> agendaPersons = new ArrayList<>();
		if (aendaPersonResult.getAgendaID() != null) {
			agendaPersons = agendaPersonService.getAgendaPersonListInt(aendaPersonResult);
		}
		return ResponseServer.success(agendaPersons);
	}
	
	/**
	 * <pre>getAgendaPersonAndSeatUnit(查询议程下坐席跟人员的绑定图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月10日 上午9:51:33    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月10日 上午9:51:33    
	 * 修改备注： 
	 * @param roomId
	 * @return</pre>
	 */
	@RequestMapping("getAgendaPersonAndSeatUnit")
	@ResponseBody
	public ResponseServer getAgendaPersonAndSeatUnit(Integer roomId,Integer agendaID) {
		Map map = new HashMap<>();
		// 1,查询议程对应的坐席单元
		List<Map> seatUnits = seatUnitService.findRoomSeatmodelUnit(roomId,agendaID);
		//2,查询坐席图详细信息
		SeatModel seatModel=seatModelService.findRoomIdToSeatModelInfo(roomId);
		map.put("seatUnits", seatUnits);
		map.put("seatmodel", seatModel);
		return ResponseServer.success(map);
	}

	/**
	 * <pre>
	 * updateAgendaPersonBondSeatUnit(议程下的人员跟坐席绑定)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月9日 上午11:21:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月9日 上午11:21:05    
	 * 修改备注： 
	 * &#64;param agendaPersonId  议程人员id
	 * &#64;param seatUnitId		坐席id
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("updateAgendaPersonBondSeatUnit")
	@ResponseBody
	public ResponseServer updateAgendaPersonBondSeatUnit(AgendaPersonSeatUnitVo agendaPersonSeatUnitVo) {
		if (agendaPersonSeatUnitVo.getAgendaPersonId() != null && agendaPersonSeatUnitVo.getSeatUnitId() != null) {
			agendaPersonService.updateAgendaPersonBondSeatUnit(agendaPersonSeatUnitVo);
			return ResponseServer.success();
		} else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}

	/**
	 * <pre>
	 * updateAgendaPersonRemoveSeatUnit(议程下的人员跟坐席解绑 )   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月9日 下午6:23:01    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月9日 下午6:23:01    
	 * 修改备注： 
	 * &#64;param agendaPersonId
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("updateAgendaPersonRemoveSeatUnit")
	@ResponseBody
	public ResponseServer updateAgendaPersonRemoveSeatUnit(Integer agendaPersonId) {
		if (agendaPersonId != null) {
			AgendaPersonSeatUnitVo agendaPersonSeatUnitVo = new AgendaPersonSeatUnitVo();
			agendaPersonSeatUnitVo.setAgendaPersonId(agendaPersonId);
			agendaPersonService.updateAgendaPersonRemoveSeatUnit(agendaPersonSeatUnitVo);
			return ResponseServer.success();
		} else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}
	
	/**
	 * <pre>updateSwopSeatUnit(人员交换坐席)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月20日 下午3:06:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月20日 下午3:06:20    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("updateSwopSeatUnit")
	@ResponseBody
	public ResponseServer updateSwopSeatUnit(String swopSeatUnit) {
		if(!StringUtils.isEmpty(swopSeatUnit)) {
			agendaPersonService.updateSwopSeatUnit(swopSeatUnit);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.NAME_NULL);
	}
	
	
}
