package org.ld.dao;

import java.util.List;

import org.ld.model.SeatModel;

public interface SeatModelDao {

	List<SeatModel> findSeatModel();

	List<SeatModel> getSeatModels(SeatModel seatModel);

	int addSeatModel(SeatModel seatModel);

	void updateSeatModel(SeatModel seatModel);

	void updateFilexmlById(SeatModel seatModel);

	void deleteSeatModel(List<Integer> str);

	SeatModel findRoomIdToSeatModelInfo(Integer roomId);

}
