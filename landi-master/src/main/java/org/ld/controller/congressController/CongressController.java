package org.ld.controller.congressController;

import java.util.List;

import javax.annotation.Resource;

import org.ld.model.Dictionary;
import org.ld.model.Room;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.response.ResponseServer;
import org.ld.service.IRoomService;
import org.ld.service.congressService.ICongressService;
import org.ld.vo.ComboTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <pre>
 * 项目名称：landi-master    
 * 类名称：CongressController    
 * 类描述：    会议
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月11日 下午1:41:50    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月11日 下午1:41:50    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("congressController")
public class CongressController {

	@Resource(name = "congressService")
	private ICongressService congressService;

	@Resource(name = "roomService")
	private IRoomService roomService;

	/**
	 * <pre>
	 * findCongressList(查询所有的会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 下午4:00:59    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 下午4:00:59    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findCongressList")
	@ResponseBody
	public ResponseServer findCongressList() {
		List<Congress> congress = congressService.findCongressList();
		return ResponseServer.success(congress);
	}

	/**
	 * <pre>
	 * findCongresTopicsList(按会议的id查询所属议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月23日 下午7:35:39    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月23日 下午7:35:39    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findCongresAgendasList")
	@ResponseBody
	public ResponseServer findCongresAgendasList(Congress congress) {
		List<Agenda> agendas = congressService.findCongresAgendasList(congress);
		return ResponseServer.success(agendas);
	}

	/**
	 * <pre>
	 * findCheckInType(查询报到方式)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 下午4:33:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 下午4:33:29    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findCheckInType")
	@ResponseBody
	public ResponseServer findCheckInType() {
		String str = "报到方式";
		List<Dictionary> dictionarys = congressService.findCheckInType(str);
		return ResponseServer.success(dictionarys);
	}

	/**
	 * <pre>
	 * findSeatMode(查询就坐方式)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 下午5:13:07    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 下午5:13:07    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findSeatMode")
	@ResponseBody
	public ResponseServer findSeatMode() {
		String str = "就坐方式";
		List<Dictionary> dictionarys = congressService.findSeatMode(str);
		return ResponseServer.success(dictionarys);
	}

	/**
	 * <pre>
	 * findCongressType(查询会议类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 下午5:18:03    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 下午5:18:03    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findCongressType")
	@ResponseBody
	public ResponseServer findCongressType() {
		String str = "会议类型";
		List<Dictionary> dictionarys = congressService.findCongressType(str);
		return ResponseServer.success(dictionarys);
	}
	
	/**
	 * <pre>findPersonStatus(查询人员状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午4:54:57    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午4:54:57    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/findPersonStatus")
	@ResponseBody
	public ResponseServer findPersonStatus() {
		String str = "人员状态";
		List<Dictionary> personStatus = congressService.findPersonStatus(str);
		return ResponseServer.success(personStatus);
	}

	/**
	 * <pre>
	 * findRooms(查询所有的会议室)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 下午5:24:18    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 下午5:24:18    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findRooms")
	@ResponseBody
	public ResponseServer findRooms() {
		List<Room> rooms = roomService.findRooms();
		return ResponseServer.success(rooms);
	}

	/**
	 * <pre>
	 * addorupdateCongress(增加和修改会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月2日 下午3:22:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月2日 下午3:22:37    
	 * 修改备注： 
	 * &#64;param congress
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/addorupdateCongress")
	@ResponseBody
	public ResponseServer addorupdateCongress(Congress congress) {
		congressService.addorupdateCongress(congress);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * deleteCongress(删除会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月2日 下午3:29:02    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月2日 下午3:29:02    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deleteCongress")
	@ResponseBody
	public ResponseServer deleteCongress(String ids) {
		congressService.deleteCongress(ids);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * addorupdateAgenda(增加和修改议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 上午8:56:08    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 上午8:56:08    
	 * 修改备注： 
	 * &#64;param agenda
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/addorupdateAgenda")
	@ResponseBody
	public ResponseServer addorupdateAgenda(Agenda agenda) {
		congressService.addorupdateAgenda(agenda);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * deleteAgenda(删除议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月3日 下午3:42:22    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月3日 下午3:42:22    
	 * 修改备注： 
	 * &#64;param agenda
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deleteAgenda")
	@ResponseBody
	public ResponseServer deleteAgenda(String ids) {
		congressService.deleteAgenda(ids);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>findAgendaTree(参会人员模块的左侧树的展示)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月30日 上午9:23:58    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月30日 上午9:23:58    
	 * 修改备注： 
	 * @param 
	 * @return</pre>
	 */
	@RequestMapping("/findAgendaTree")
	@ResponseBody
	public ResponseServer findAgendaTree(Congress congress) {
		List<ComboTree> comboTrees = congressService.findAgendaTree(congress);
		return ResponseServer.success(comboTrees);
	}

}
