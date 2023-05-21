package org.ld.dao;

import java.util.List;

import org.ld.model.Room;

public interface RoomDao {

	List<Room> findRoomList(Room room);

	int addRoom(Room room);

	void updateRoom(Room room);

	void deleteRooms(List<Integer> idList);

	Long getCount(Room room);

	List<Room> findRooms();
	//按主键id查询会议室的详细信息
	Room finRoomInfo(Integer roomId);
	//查询是否有会议室使用坐席SeatModel
	List<Room> findRoomIsSeatModelList(Integer in);

	
}
