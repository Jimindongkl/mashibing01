package org.ld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.RoomDao;
import org.ld.dao.RoomPartDao;
import org.ld.dao.SeatModelDao;
import org.ld.dao.congressDao.AgendaDao;
import org.ld.dao.congressDao.CongressDao;
import org.ld.model.Room;
import org.ld.model.RoomPart;
import org.ld.model.SeatModel;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IRoomService;
import org.ld.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("roomService")
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private SeatModelDao seatModelDao;

	@Autowired
	private RoomPartDao roomPartDao;

	@Autowired
	private CongressDao congressDao;
	
	@Autowired
	private AgendaDao agendaDao;
	

	@Override
	public List<Room> findRoomList(Room room) {

		return roomDao.findRoomList(room);
	}

	@Override
	public void addRoom(Room room, String json) {
		int roomId = roomDao.addRoom(room);
		Integer id = room.getId();
		JSONArray ay = JSONArray.fromObject(json);
		List<RoomPart> list = new ArrayList<>();
		if (ay.size() > 0) {
			for (int i = 0; i < ay.size(); i++) {
				RoomPart roomPart = new RoomPart();
				// 遍历 jsonarray 数组，把每一个对象转成 json 对象
				JSONObject job = ay.getJSONObject(i);
				roomPart.setRoomID(id);
				roomPart.setParetNum(Integer.valueOf((String) job.get("paretNum")));
				roomPart.setPartName((String) job.get("partName"));
				roomPart.setPartDescribe((String) job.get("partDescribe"));
				list.add(roomPart);
			}
			roomPartDao.addRoomPartBatch(list);
		}

	}

	@Override
	public void updateRoom(Room room, String json) {
		// 修改会议室
		roomDao.updateRoom(room);
		// 1，修改会议室分区
		JSONArray ay = JSONArray.fromObject(json);
		// 1.1 增加会议室分区的lsit
		List<RoomPart> addlist = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();
		if (ay.size() > 0) {
			for (int i = 0; i < ay.size(); i++) {
				JSONObject job = ay.getJSONObject(i);
				RoomPart roomPart = new RoomPart();
				Object istr =  job.get("id");
				if (!Util.isEmpty(istr)) {
					roomPart.setId(Integer.parseInt(String.valueOf(istr)));
					ids.add(Integer.parseInt(String.valueOf(istr)));
					roomPart.setRoomID(room.getId());
					Object paretNumtr =  job.get("paretNum");
					roomPart.setParetNum(Integer.parseInt(String.valueOf(paretNumtr)));
					roomPart.setPartName((String) job.get("partName"));
					roomPart.setPartDescribe((String) job.get("partDescribe"));
					roomPartDao.updateRoom(roomPart);
				} else {
					roomPart.setRoomID(room.getId());
					roomPart.setParetNum(job.getInt("paretNum"));
					roomPart.setPartName((String) job.get("partName"));
					roomPart.setPartDescribe((String) job.get("partDescribe"));
					addlist.add(roomPart);
				}
			}		//先删除
					if (ids != null && ids.size() > 0) {
					roomPartDao.deleteNotPart(room.getId(),ids);
				}
					//在增加
					if (addlist != null && addlist.size() > 0) {
					roomPartDao.addRoomPartBatch(addlist);
				}
		}
	}

	@Override
	public List<SeatModel> findSeatModel() {

		return seatModelDao.findSeatModel();
	}

	@Override
	public ResponseServer deleteRooms(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> roomList = new ArrayList<>();
			List<Integer> roomPartList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				roomList.add(Integer.parseInt(id));
				// 查会议室分区
				List<RoomPart> roomParts = roomPartDao.findRoomParts(Integer.parseInt(id));
				if (roomParts != null && roomParts.size() > 0) {
					for (int i = 0; i < roomParts.size(); i++) {
						roomPartList.add(roomParts.get(i).getId());
					}
				}
			}
			// 1，查询会议是否关联会议室
			List<Congress> congressList = congressDao.findCongressAndRoom(roomList);
			if(congressList != null && !congressList.isEmpty()) {
				return ResponseServer.error(ResponseEnum.CORRELATION_YES);
			}
			// 2，查询议题是否关联会议室
			List<Agenda> agendaList = agendaDao.findAgendaAndRoom(roomList);
			if(agendaList != null && !agendaList.isEmpty()) {
				return ResponseServer.error(ResponseEnum.CORRELATION_YES);
			}
			// 3,删除会议室分区
			if (roomPartList != null && !roomPartList.isEmpty()) {
				roomPartDao.deleteRoomParts(roomPartList);
			}
			// 4,删除会议室
			roomDao.deleteRooms(roomList);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.DELETE_ERROR);
	}

	@Override
	public List<RoomPart> finRoomtoRoomParts(Room room) {
		if (room.getId() != null) {
			return roomPartDao.findRoomParts(room.getId());
		} else {
			return new ArrayList<>();
		}

	}

	@Override
	public Long getCount(Room room) {

		return roomDao.getCount(room);
	}

	@Override
	public List<Room> findRooms() {

		return roomDao.findRooms();
	}

	@Override
	public Room finRoomInfo(Integer roomId) {
		
		return roomDao.finRoomInfo(roomId);
	}

}
