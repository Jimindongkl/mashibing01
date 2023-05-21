package org.ld.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ld.model.Room;
import org.ld.model.RoomPart;

public interface RoomPartDao {

	void addRoomPartBatch(List<RoomPart> list);

	void addRoomPart(RoomPart roomPart);

	void updateRoom(RoomPart roomPart);

	List<RoomPart> findRoomParts(Integer id);

	void deleteNotPart(@Param("integer") Integer integer ,@Param("ids") List<Integer> ids);

	void deleteRoomParts(List<Integer> roomPartList);
	
	

}
