package org.ld.controller.congressControlContrlller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ld.model.Room;
import org.ld.model.SeatModel;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.AgendaPerson;
import org.ld.model.congressModel.Congress;
import org.ld.model.congressModel.Topic;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IRoomService;
import org.ld.service.ISeatModelService;
import org.ld.service.congressControlService.ICongressControlService;
import org.ld.vo.AgendaSeatUitStaffInfoVo;
import org.ld.vo.ComboTree;
import org.ld.vo.ComboTreeController;
import org.ld.vo.StaffInfoAndNumVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("congressControlContrlller")
public class CongressControlContrlller {
	
	@Resource(name = "congressControlService")
	private ICongressControlService congressControlService;
	
	@Resource(name = "roomService")
	private IRoomService roomService;
	
	@Resource(name = "seatModelService")
	private ISeatModelService seatModelService;
	
	
	/**
	 * <pre>findUnpublishedCongressList(未召开,正在召开,已召开,的会议的列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月20日 上午11:34:08    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月20日 上午11:34:08    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("findUnpublishedCongressList")
	@ResponseBody
	public ResponseServer findUnpublishedCongressList(Congress congress) {
		List<ComboTree> comboTrees = congressControlService.findUnpublishedCongressList(congress);
		return ResponseServer.success(comboTrees);
	}
	
	
	//在点击开始会议,结束会议的时候
	/**
	 * <pre>uploadStatusCongress(这里用一句话描述这个方法的作用)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月13日 下午4:29:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月13日 下午4:29:29    
	 * 修改备注： 
	 * @param status
	 * @param congressId
	 * @param agendaId
	 * @return</pre>
	 */
	@RequestMapping("uploadStatusCongress")
	@ResponseBody
	public ResponseServer uploadStatusCongress(Integer status, Integer congressId, Integer agendaId) {
		//判断传过来的参数是否为空
		if (status == null && congressId == null && agendaId == null) {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		if(status==1) {
			//查agendaId对应的状态
			Agenda agenda = congressControlService.findAgendaModel(agendaId);
			if(agenda!=null) {
				if(agenda.getStatus()==1) {
					return ResponseServer.success("正在召开会议,不用修改状态直接进入");
				}
			}
		}
		//查询议程
		if(status==1) {
			//查询除了传过来的日程id的状态外还有没有正在开的会议
			List<Agenda> agendas = congressControlService.findNotCurrentAgendaStatus(agendaId,status);
			//如果有则return
			if(agendas.size()>0) {
				return ResponseServer.error(ResponseEnum.MEET_ING);
			}
			//如果没有接着执行
		}
		// 添加会议,议程的时候默认为0;只要是开始议程就变为1,结束变为2
		congressControlService.uploadStatusAgenda(agendaId, status);
		// 查正在开始议程的同级所有议程
		List<Agenda> agendas = congressControlService.findAgendaIdfindAgendas(agendaId);
		for(int i=0;i<agendas.size();i++) {
			if(agendas.get(i).getStatus()==1&&congressId!=0||agendas.get(i).getStatus()==0&&congressId!=0) {
				congressControlService.uploadStatusCongress(congressId, 1);
			}
		}
		if (status == 1) {
			boolean flag = false;
			for (int i = 0; i < agendas.size(); i++) {
				// 只要有一个议程为1,则会议为1.
				if (agendas.get(i).getStatus() == 1 && !flag) {
					// 根据修改的议程查会议的的状态
					Congress congress = congressControlService.findAgendaIdfindcongressBy(congressId);
					if (congress.getStatus() == 0 ||congress.getStatus() == 2) {
						// 修改状态为1
						congressControlService.uploadStatusCongress(congressId, 1);
						flag = true;
					}
				}
			}

		} else if (status == 2) {
			boolean flagTow = true;
			for (int i = 0; i < agendas.size(); i++) {
				if (agendas.get(i).getStatus() != 2) {
					flagTow = false;
				}
			}
			// 全部议程为2,则会议为2
			if (flagTow) {
				// 修改状态为2
				congressControlService.uploadStatusCongress(congressId, 2);
			}
		}
		return ResponseServer.success();
	}
		
	
	
	/**
	 * <pre>findSeatUnitAndPersonAndDeviceUsedList(会议控制中的坐席设备人员展示)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月27日 上午10:47:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月27日 上午10:47:54    
	 * 修改备注： 
	 * @param roomId
	 * @param agendaId
	 * @return</pre>
	 */
	@RequestMapping("findSeatUnitAndPersonAndDeviceUsedList")
	@ResponseBody
	public ResponseServer findSeatUnitAndPersonAndDeviceUsedList(Integer roomId,Integer agendaId) {
		Map map = new HashMap<>();
		//查议程属于那个坐席模板
		Room room = roomService.finRoomInfo(roomId);
		Integer seatModelId = room.getSeatModel().getId();
		List<Map> seatUnitPersonDeviceUseds = congressControlService.findSeatUnitAndPersonAndDeviceUsedList(seatModelId,agendaId);
		//2,查询坐席图详细信息
		SeatModel seatModel=seatModelService.findRoomIdToSeatModelInfo(roomId);
		map.put("seatUnits", seatUnitPersonDeviceUseds);
		map.put("seatmodel", seatModel);
		return ResponseServer.success(map);
	}
	
	/**
	 * <pre>findUnderwayMeetingPersonList(查询正在开会时签到的人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月3日 下午3:10:10    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月3日 下午3:10:10    
	 * 修改备注： 
	 * @param agendaId
	 * @return</pre>
	 */
	@RequestMapping("findUnderwayMeetingPersonList")
	@ResponseBody
	public ResponseServer findUnderwayMeetingPersonList(Integer agendaId) {
		List<AgendaSeatUitStaffInfoVo>	agendaSeatUitStaffInfos = congressControlService.findUnderwayMeetingPersonList(agendaId);
		return ResponseServer.success(agendaSeatUitStaffInfos);
	}
	
	/**
	 * <pre>updateUnderwayMeetingPersonCheckInTimeAndCheckState(修改正在签到人员的状态和时间)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月3日 下午3:46:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月3日 下午3:46:50    
	 * 修改备注： 
	 * @param seatID  坐席id
	 * @param status  签到或迁出的状态
	 * @return</pre>
	 */
	@RequestMapping("updateUnderwayMeetingPersonCheckInTimeAndCheckState")
	@ResponseBody
	public ResponseServer updateUnderwayMeetingPersonCheckInTimeAndCheckState(Integer seatID) {
		 congressControlService.updateUnderwayMeetingPersonCheckInTimeAndCheckState(seatID);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(修改正在开会的（分配坐席的）所有人员的状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月4日 下午5:12:27    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月4日 下午5:12:27    
	 * 修改备注： 
	 * @param status
	 * @return</pre>
	 */
	@RequestMapping("updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll")
	@ResponseBody
	public ResponseServer updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(Integer status) {
		 congressControlService.updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(status);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>findAgendaQueryTopics(按会议id，日程id查询议题和子议题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年10月28日 下午3:03:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年10月28日 下午3:03:56    
	 * 修改备注： 
	 * @param congressId
	 * @param agendaId
	 * @return</pre>
	 */
	@RequestMapping("findAgendaQueryTopics")
	@ResponseBody
	public ResponseServer findAgendaQueryTopics(Integer congressId,Integer agendaId) {
		Topic topic = new Topic();
		if(congressId>0&&agendaId>0) {
			Agenda agenda=new Agenda();
			Congress congress =new Congress();
			agenda.setId(agendaId);
			congress.setId(congressId);
			topic.setAgenda(agenda);
			topic.setCongress(congress);
		}
		List<ComboTreeController> comboTreeControllers = congressControlService.findAgendaQueryTopics(topic);
		return ResponseServer.success(comboTreeControllers);
	}
	
	/**
	 * <pre>findControlPersonCheckInCount(按条件查询应到，实到，未到人员信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月17日 下午5:19:04    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月17日 下午5:19:04    
	 * 修改备注： 
	 * @param agendaPerson
	 * @return</pre>
	 */
	@RequestMapping("findControlPersonCheckInCount")
	@ResponseBody
	public ResponseServer  findControlPersonCheckInCount(AgendaPerson agendaPerson) {
		List<StaffInfoAndNumVo>  staffInfoAndNumVoList=congressControlService.findControlPersonCheckInCount(agendaPerson);
		return ResponseServer.success(staffInfoAndNumVoList);
	}
	
	/**
	 * <pre>findLoadingAgendaInfo(查询正在召开的日程的信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2021年2月22日 下午2:20:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2021年2月22日 下午2:20:17    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("findLoadingAgendaInfo")
	@ResponseBody
	public ResponseServer findLoadingAgendaInfo() {
		Agenda agenda=congressControlService.findLoadingAgendaInfo();
		return ResponseServer.success(agenda);
	}
	
	
}
