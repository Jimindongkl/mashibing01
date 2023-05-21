package org.ld.service.congressControlService.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ld.dao.SeatDeviceDao;
import org.ld.dao.SeatUnitDao;
import org.ld.dao.congressDao.AgendaDao;
import org.ld.dao.congressDao.AgendaPersonDao;
import org.ld.dao.congressDao.CongressDao;
import org.ld.dao.congressDao.TopicDao;
import org.ld.model.SeatDevice;
import org.ld.model.SeatUnit;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.AgendaPerson;
import org.ld.model.congressModel.Congress;
import org.ld.model.congressModel.Topic;
import org.ld.service.congressControlService.ICongressControlService;
import org.ld.vo.AgendaPersonSeatUnitVo;
import org.ld.vo.AgendaSeatUitStaffInfoVo;
import org.ld.vo.ComboTree;
import org.ld.vo.ComboTreeController;
import org.ld.vo.SeatUnitVo;
import org.ld.vo.StaffInfoAndNumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("congressControlService")
public class CongressControlServiceImpl implements ICongressControlService{

	@Autowired
	private CongressDao congressDao;
	
	@Autowired
	private AgendaDao agendaDao;
	
	@Autowired
	private SeatUnitDao seatUnitDao;
	
	@Autowired
	private SeatDeviceDao seatDeviceDao;
	
	@Autowired
	private AgendaPersonDao agendaPersondao;
	
	@Autowired
	private TopicDao topicDao;
	
	

	@Override
	public List<ComboTree> findUnpublishedCongressList(Congress congress) {
		// 类型
		Map<String, Object> meetMap = new HashMap<String, Object>();
		meetMap.put("type", "meet");
		Map<String, Object> agendaMap = new HashMap<String, Object>();
		agendaMap.put("type", "agenda");
		List<Congress> congressList = congressDao.findAllCongress(congress);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		// 2,遍历相关联的
		for (Congress meet : congressList) {
			ComboTree combotree = new ComboTree();
			combotree.setId(meet.getId());
			combotree.setText(meet.getCongressName());
			combotree.setOrder(meet.getSerial());
			combotree.setStatus(meet.getStatus());
			/*SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = ft.format(meet.getStartTime());
			combotree.setDate(time);*/
			combotree.setRoomId(meet.getRoom().getId());
			combotree.setAttributes(meetMap);
			combotree.setChildren(new ArrayList<ComboTree>());
			List<Agenda> agendas = agendaDao.findAllAgenda(meet.getId());
			// 获取全部议程
			for (Agenda agenda : agendas) {
				ComboTree comboNode = new ComboTree();
				comboNode.setId(agenda.getId());
				comboNode.setText(agenda.getAgName());
				comboNode.setOrder(agenda.getSerial());
				comboNode.setStatus(agenda.getStatus());
				comboNode.setParentId(meet.getId());
				SimpleDateFormat ftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String startDate = ftime.format(agenda.getStartTime());
				comboNode.setStartDate(startDate);
				String endDate = ftime.format(agenda.getEndTime());
				comboNode.setEndDate(endDate);
				comboNode.setAttributes(agendaMap);
				comboNode.setRoomId(agenda.getRoom().getId());
				comboNode.setChildren(new ArrayList<ComboTree>());
				combotree.getChildren().add(comboNode);
			}
			comboTrees.add(combotree);
		}
		return comboTrees;
	}


	@Override
	public void uploadStatusCongress(Integer congressId,Integer congressStatus) {
		Congress congress = new Congress();
		congress.setId(congressId);
		congress.setStatus(congressStatus);
		congressDao.uploadStatusCongress(congress);
	}


	@Override
	public void uploadStatusAgenda(Integer agendaId,Integer agendaStatus) {
		Agenda agenda = new Agenda();
		agenda.setId(agendaId);
		agenda.setStatus(agendaStatus);
		agendaDao.uploadStatusAgenda(agenda);
	}


	@Override
	public List<Agenda> findAgendaList(Integer congressId) {
		
		return agendaDao.findAllAgenda(congressId);
	}


	@Override
	public List<Agenda> findAgendaIdfindAgendas(Integer agendaId) {
		
		return agendaDao.findAgendaIdfindAgendas(agendaId);
	}


	@Override
	public Congress findAgendaIdfindcongressBy(Integer congressId) {
		
		return congressDao.findAgendaIdfindcongressBy(congressId);
	}


	@Override
	public List<Map> findSeatUnitAndPersonAndDeviceUsedList(Integer seatModelId,Integer agendaId) {
		//坐席的分配图的id  Int类型    suSeatModelId       （必传）
		SeatUnit seatUnit = new SeatUnit();
		seatUnit.setSuSeatModelId(seatModelId);
		//坐席设备
		List<SeatUnitVo> seatUnits = seatUnitDao.getSeatUnitsByModelId(seatUnit);
		List<Map> seatUnitsA = new ArrayList<>();
		for (int i = 0; i < seatUnits.size(); i++) {
			List<SeatDevice> deviceUseds = new ArrayList<>();
			AgendaSeatUitStaffInfoVo  agendaSeatUitStaffInfo= new AgendaSeatUitStaffInfoVo();
			Map map = new HashMap<>();
			Integer  seatUnitId= (Integer) seatUnits.get(i).getId();
			//坐席上绑定了多种设备
			deviceUseds = seatDeviceDao.getSeatDeviceUsedList(seatUnitId);
			//坐席上绑定的人员
			agendaSeatUitStaffInfo = agendaPersondao.findAgendaAndSeatQueryStaffInfo(agendaId,seatUnitId);
			map.put("id", seatUnits.get(i).getId());
			map.put("name", seatUnits.get(i).getName());
			map.put("rowId", seatUnits.get(i).getRowId());
			map.put("columnId", seatUnits.get(i).getColumnId());
			map.put("x", seatUnits.get(i).getX());
			map.put("y", seatUnits.get(i).getY());
			map.put("z", seatUnits.get(i).getZ());
			map.put("userName", seatUnits.get(i).getUserName());
			map.put("Width", seatUnits.get(i).getWidth());
			map.put("Height", seatUnits.get(i).getHeight());
			map.put("degree", seatUnits.get(i).getDegree());
			map.put("type", seatUnits.get(i).getType());
			map.put("suUnitCode", seatUnits.get(i).getSuUnitCode());
			map.put("suAddressIP", seatUnits.get(i).getSuAddressIP());
			map.put("suHostAddressIP", seatUnits.get(i).getSuHostAddressIP());
			map.put("suSpareAddressIP", seatUnits.get(i).getSuSpareAddressIP());
			map.put("suRoomPartName", seatUnits.get(i).getSuRoomPartName());
			map.put("suRoomPartId", seatUnits.get(i).getSuRoomPartId());
			map.put("suState", seatUnits.get(i).getSuState());
			map.put("suContent", seatUnits.get(i).getSuContent());
			map.put("suControlType", seatUnits.get(i).getSuControlType());
			map.put("deviceUseds", deviceUseds);
			map.put("staffinfo", agendaSeatUitStaffInfo);
			seatUnitsA.add(map);
		}
		return seatUnitsA;
	}


	@Override
	public List<Agenda> findNotCurrentAgendaStatus(Integer agendaId, Integer status) {
		// TODO Auto-generated method stub
		return agendaDao.findNotCurrentAgendaStatus(agendaId,status);
	}


	@Override
	public List<ComboTreeController> findAgendaQueryTopics(Topic topic) {
		// TODO Auto-generated method stub
		Map<String, Object> topicMap = new HashMap<String, Object>();
		topicMap.put("type", "topic");
		Map<String, Object> topicLowerMap = new HashMap<String, Object>();
		topicLowerMap.put("type", "topicLower");
		List<ComboTreeController> comboTreeControllers = new ArrayList<ComboTreeController>();
		//查询多个议题
		List<Topic> topics=topicDao.findAllTopics(topic);
				// 获取议程下的全部议题
				for (Topic topicx : topics) {
					ComboTreeController node = new ComboTreeController();
					node.setKey(topicx.getId());
					node.setTitle(topicx.getToName());
					node.setOrder(topicx.getNum());
					node.setStatus(topicx.getStatus());
					node.setAttributes(topicMap);
					node.setChildren(new ArrayList<ComboTreeController>());
					List<Topic> topicLowers = topicDao.findAllTopicLower(topicx.getId());
					// 获取议程下的全部子议题
					for (Topic topicLower : topicLowers) {
						ComboTreeController comboTreeControllerLower = new ComboTreeController();
						comboTreeControllerLower.setKey(topicLower.getId());
						comboTreeControllerLower.setTitle(topicLower.getToName());
						comboTreeControllerLower.setOrder(topicLower.getNum());
						comboTreeControllerLower.setStatus(topicLower.getStatus());
						comboTreeControllerLower.setAttributes(topicLowerMap);
						node.getChildren().add(comboTreeControllerLower);
					}
					comboTreeControllers.add(node);
				}
		return comboTreeControllers;
	}


	@Override
	public List<AgendaSeatUitStaffInfoVo> findUnderwayMeetingPersonList(Integer agendaId) {
		// TODO Auto-generated method stub
		List<AgendaSeatUitStaffInfoVo> agendaSeatUitStaffInfos = agendaPersondao.findUnderwayMeetingPersonList(agendaId);
		for(int i=0;i<agendaSeatUitStaffInfos.size();i++) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date checkInTime = agendaSeatUitStaffInfos.get(i).getCheckInTime();
			Date checkOutTime = agendaSeatUitStaffInfos.get(i).getCheckOutTime();
			if(checkInTime!=null) {
			String checkInTimeStr = formatter.format(checkInTime);
			agendaSeatUitStaffInfos.get(i).setCheckInTimeStr(checkInTimeStr);
			}
			if(checkOutTime!=null) {
			String checkOutTimeStr = formatter.format(checkOutTime);
			agendaSeatUitStaffInfos.get(i).setCheckOutTimeStr(checkOutTimeStr);
			}
		}
		return agendaSeatUitStaffInfos;
	}


	@Override
	public void updateUnderwayMeetingPersonCheckInTimeAndCheckState(Integer seatID) {
		Integer status = 1;
		// TODO Auto-generated method stub
		//1,查询当前开会的日程id
		Integer statusIng = 1;
	    Agenda agenda = agendaDao.findPaperlessNowAgenda(statusIng);
	    AgendaPerson agendaPerson = new AgendaPerson();
	    if(seatID>0 && agenda.getId()>0) {
	    	agendaPerson.setSeatID(seatID);
	    	agendaPerson.setAgendaID(agenda.getId());
	    	agendaPerson.setCheckState(status);
	    	//1是签到
    		agendaPerson.setCheckInTime(new Date());
    		agendaPersondao.updateUnderwayMeetingPersonCheckInTimeAndCheckState(agendaPerson);
	    }
	    
	}
	
	
	
	public void updateUnderwayMeetingPersonCheckInTimeAndCheckStateOut(Integer seatID) {
		// TODO Auto-generated method stub
		Integer status = 2;
		//1,查询当前开会的日程id
		Integer statusIng = 1;
	    Agenda agenda = agendaDao.findPaperlessNowAgenda(statusIng);
	    AgendaPerson agendaPerson = new AgendaPerson();
	    if(seatID>0 && agenda.getId()>0) {
	    	agendaPerson.setSeatID(seatID);
	    	agendaPerson.setAgendaID(agenda.getId());
	    	agendaPerson.setCheckState(status);
	    	//2是迁出
    		agendaPerson.setCheckOutTime(new Date());
    		agendaPersondao.updateUnderwayMeetingPersonCheckOutTimeAndCheckState(agendaPerson);
	    	
	    }
	    
	}


	@Override
	public void updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(Integer status) {
		 // TODO Auto-generated method stub
		 //1,查询当前日程
		Integer statusIng = 1;
	    Agenda agenda = agendaDao.findPaperlessNowAgenda(statusIng);
	    Integer agendaID = null;
	    if(agenda!=null) {
	    	 agendaID = agenda.getId();
	    }
		//2，查询绑定坐席的人员
	    List<AgendaPerson> agendaPersons = agendaPersondao.findNowAgendaSeatPersons(agendaID);
	    //3，修改所有人员的状态和时间
	    //全部重置为初始状态
	    if(status == 0) {
	    	for(int i=0;i<agendaPersons.size();i++) {
		    	agendaPersons.get(i).setCheckState(status);
		    	agendaPersons.get(i).setCheckInTime(null);
		    	agendaPersons.get(i).setCheckOutTime(null);
		    }
	    	//全部重置为签到状态
	    }else if(status == 1) {
	    	Date d =new Date();
	    	for(int i=0;i<agendaPersons.size();i++) {
		    	agendaPersons.get(i).setCheckState(status);
		    	agendaPersons.get(i).setCheckInTime(d);
		    	agendaPersons.get(i).setCheckOutTime(null);
		    }
	    	//全部重置为迁出状态
	    }else if(status == 2) {
	    	Date d =new Date();
	    	for(int i=0;i<agendaPersons.size();i++) {
		    	agendaPersons.get(i).setCheckState(status);
		    	agendaPersons.get(i).setCheckOutTime(d);
		    }
	    }
	    if(agendaPersons.size()>0) {
	    	agendaPersondao.updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(agendaPersons);
	    }
	    
	}


	@Override
	public Agenda findAgendaModel(Integer agendaId) {
		// TODO Auto-generated method stub
		return agendaDao.findAgendaModel(agendaId);
	}


	@Override
	public List<StaffInfoAndNumVo> findControlPersonCheckInCount(AgendaPerson agendaPerson) {
		 //1,查询当前正在进行的日程
		Integer statusIng = 1;
	    Agenda agenda = agendaDao.findPaperlessNowAgenda(statusIng);
	    List<StaffInfoAndNumVo> staffInfoAndNumVoList = new ArrayList<>();
	    if(agenda!=null) {
	    	agendaPerson.setAgendaID(agenda.getId());
	    	//2,应到人员信息及人数
	    	StaffInfoAndNumVo shouldVo = new StaffInfoAndNumVo();
	    	List<AgendaSeatUitStaffInfoVo>  agendaPersonSeatUnitVoList=agendaPersondao.findControlPersonCheckInList(agendaPerson);
	    	Integer shouldNum=agendaPersonSeatUnitVoList.size();
	    	shouldVo.setAgendaPersonSeatUnitVoList(agendaPersonSeatUnitVoList);
	    	shouldVo.setNum(shouldNum);
	    	shouldVo.setFlag("should");
	    	shouldVo.setRemark("应到人员信息及人数");
	    	staffInfoAndNumVoList.add(shouldVo);
	    	//3,实到人员信息及人数
	    	StaffInfoAndNumVo actualVo = new StaffInfoAndNumVo();
	    	agendaPerson.setCheckState(1);
	    	List<AgendaSeatUitStaffInfoVo> agendaPersonSeatUnitVoListStatus=agendaPersondao.findControlPersonCheckInList(agendaPerson);
	    	Integer actualNum = agendaPersonSeatUnitVoListStatus.size();
	    	actualVo.setAgendaPersonSeatUnitVoList(agendaPersonSeatUnitVoListStatus);
	    	actualVo.setNum(actualNum);
	    	actualVo.setFlag("actual");
	    	actualVo.setRemark("实到人员信息及人数");
	    	staffInfoAndNumVoList.add(actualVo);
	    	//4,未到人员信息及人数
	    	StaffInfoAndNumVo notVo = new StaffInfoAndNumVo();
	    	agendaPerson.setCheckState(0);
	    	List<AgendaSeatUitStaffInfoVo> agendaPersonSeatUnitVoListStatusZ=agendaPersondao.findControlPersonCheckInList(agendaPerson);
	    	Integer notNum = agendaPersonSeatUnitVoListStatusZ.size();
	    	notVo.setAgendaPersonSeatUnitVoList(agendaPersonSeatUnitVoListStatusZ);
	    	notVo.setNum(notNum);
	    	notVo.setFlag("not");
	    	notVo.setRemark("未到人员信息及人数");
	    	staffInfoAndNumVoList.add(notVo);
	    }
		return staffInfoAndNumVoList;
	}


	@Override
	public Agenda findLoadingAgendaInfo() {
		//正在召开的日程状态为1
		Integer status= 1;
		return agendaDao.findPaperlessNowAgenda(status);
	}
	
	
}
