package org.ld.service.impl;

import org.ld.dao.RoomPartDao;
import org.ld.model.Room;
import org.ld.model.RoomPart;
import org.ld.service.IRoomPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roomPartService")
public class RoomPartServiceImpl implements IRoomPartService{

	@Autowired
	private RoomPartDao roomPartDao;
	
	@Override
	public void addRoomPart(RoomPart roomPart) {
		roomPartDao.addRoomPart(roomPart);
		
	}

	
	
	
	
	
}
