package org.ld.service.congressService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.DictionaryDao;
import org.ld.dao.RoomDao;
import org.ld.dao.congressDao.AgendaDao;
import org.ld.dao.congressDao.CongressDao;
import org.ld.model.Dictionary;
import org.ld.model.Room;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.model.congressModel.Topic;
import org.ld.service.congressService.ICongressService;
import org.ld.utils.LowcaseToUppercase;
import org.ld.vo.ComboTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("congressService")
public class CongressServiceImpl implements ICongressService {

	@Autowired
	private CongressDao congressDao;

	@Autowired
	private DictionaryDao dictionaryDao;

	@Autowired
	private AgendaDao agendaDao;

	@Autowired
	private RoomDao roomDao;

	@Override
	public List<Congress> findCongressList() {

		return congressDao.findCongressList();
	}

	@Override
	public List<Dictionary> findCheckInType(String str) {

		return dictionaryDao.getDictionaryByStr(str);
	}

	@Override
	public List<Dictionary> findSeatMode(String str) {

		return dictionaryDao.getDictionaryByStr(str);
	}

	@Override
	public List<Dictionary> findCongressType(String str) {

		return dictionaryDao.getDictionaryByStr(str);
	}
	
	@Override
	public List<Dictionary> findPersonStatus(String str) {
		
		return dictionaryDao.getDictionaryByStr(str);
	}

	@Override
	public void addorupdateCongress(Congress congress) {
		Date d = new Date();
		if (congress.getId() != null) {
			congress.setUpdateTime(d);
			congressDao.updateCongress(congress);
		} else {
			// 查询所有会议中最大的排序
			Integer oeder = 1;
			Integer roomValue = 0;
			Integer maxCongressOrder = congressDao.getMaxCongressOrder();
			if (maxCongressOrder != null) {
				oeder = maxCongressOrder + 1;
			}
			// 会议室
			List<Room> rooms = roomDao.findRooms();
			Integer roomId = rooms.get(0).getId();
			if (roomId != null) {
				roomValue = roomId;
			}
			// 会议室id
			Room room = new Room();
			room.setId(roomValue);
			congress.setRoom(room);
			// 会议名称
			congress.setCongressName("会议" + oeder);
			// 会议排序
			congress.setSerial(oeder);
			congress.setStartTime(d);
			congress.setEndTime(d);
			// 47：会议类型 ：党代会（默认）
			congress.setTypeID(47);
			// 38：报到方式 ： 按键报到（默认）
			congress.setCheckInType(38);
			// 44：就坐方式：指定就坐 （默认）
			congress.setSeatMode(44);
			//会议得状态  0未召开 1正在召开 2 已经召开
			congress.setStatus(0);
			congress.setUpdateTime(d);
			congress.setCreateTime(d);
			congressDao.addCongress(congress);
		}

	}

	@Override
	public void deleteCongress(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			congressDao.deleteCongress(idList);
		}

	}

	@Override
	public void addorupdateAgenda(Agenda agenda) {
		if (agenda.getId() != null) {
			// 修改
			agenda.setUpdateTime(new Date());
			agendaDao.updateAgenda(agenda);
		} else {
			// 增加
			Integer max = null;
			Integer value = 1;
			Integer roomId = null;
			// 查询会议下排序最大的议程
			// 查询属于会议的会议室
			if (agenda.getCongress().getId() != null) {
				max = agendaDao.findMaxorder(agenda.getCongress().getId());
				roomId = congressDao.findRoomId(agenda.getCongress().getId());
				if (max != null && max != 0) {
					value = max + 1;
				}
			}
			String num = LowcaseToUppercase.numberToZH(value, false);
			// 拼接议程的名称
			String AgName = "第" + num + "次全体会议";
			agenda.setAgName(AgName);
			// 47：会议类型 ：党代会（默认）
			agenda.setAgType(47);
			// 38：报到方式 ： 按键报到（默认）
			agenda.setCheckInType(38);
			// 44：就坐方式：指定就坐 （默认）
			agenda.setSeatType(44);
			//未召开
			agenda.setStatus(0);
			agenda.setSerial(value);
			if (roomId != null) {
				Room room = new Room();
				room.setId(roomId);
				agenda.setRoom(room);
			}
			Date d = new Date();
			agenda.setStartTime(d);
			agenda.setEndTime(d);
			agenda.setUpdateTime(d);
			agenda.setCreateTime(d);
			agendaDao.addAgenda(agenda);
		}
	}

	@Override
	public void deleteAgenda(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			agendaDao.deleteAgenda(idList);
		}
	}

	@Override
	public List<Agenda> findCongresAgendasList(Congress congress) {

		return agendaDao.findCongresAgendasList(congress);
	}

	@Override
	public List<ComboTree> findAgendaTree(Congress congress) {
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
			combotree.setAttributes(meetMap);
			combotree.setChildren(new ArrayList<ComboTree>());
			List<Agenda> agendas = agendaDao.findAllAgenda(meet.getId());
			// 获取全部议程
			for (Agenda agenda : agendas) {
				ComboTree comboNode = new ComboTree();
				comboNode.setId(agenda.getId());
				comboNode.setText(agenda.getAgName());
				comboNode.setOrder(agenda.getSerial());
				comboNode.setAttributes(agendaMap);
				comboNode.setChildren(new ArrayList<ComboTree>());
				combotree.getChildren().add(comboNode);
			}
			comboTrees.add(combotree);
		}
		return comboTrees;
	}

	

}
