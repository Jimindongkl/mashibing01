package org.ld.service;

import java.util.List;

import org.ld.model.Room;
import org.ld.model.RoomPart;
import org.ld.model.SeatModel;
import org.ld.response.ResponseServer;

public interface IRoomService {

	List<Room> findRoomList(Room room);

	void addRoom(Room room, String json);

	List<SeatModel> findSeatModel();

	ResponseServer deleteRooms(String ids);

	void updateRoom(Room room, String json);

	List<RoomPart> finRoomtoRoomParts(Room room);

	Long getCount(Room room);

	List<Room> findRooms();

	Room finRoomInfo(Integer roomId);

	

}
