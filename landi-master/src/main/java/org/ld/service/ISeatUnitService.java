package org.ld.service;

import java.util.List;
import java.util.Map;

import org.ld.model.SeatModel;
import org.ld.model.SeatUnit;
import org.ld.vo.SeatUnitVo;
import org.ld.vo.SeatdeviceAddressCodeVo;

/**
 * 坐席单元
 */
public interface ISeatUnitService {
	// 根据坐席图id查询坐席单元
	List<SeatUnitVo> getSeatUnitsByModelId(SeatUnit seatUnit);

	// 新增 坐席单元
	void addSeatUnits(SeatUnit seatUnit, String str);

	// 修改 坐席单元
	void modifyUnits(SeatUnit seatUnit);

	// 批量删除坐席单元
	void deleteSeatUnits(String ids);

	// 增加单个坐席单元
	SeatUnit addSeatUnit(SeatModel seatModel);

	// 查询单个坐席单元
	SeatUnitVo findSeatUnitId(SeatUnit seatUnit);

	// 修改单个坐席单元
	void updateSeatUnitId(SeatUnitVo seatUnitVo);

	// 按会议室的id查询坐席图的id查询出坐席单元
	List<Map> findRoomSeatmodelUnit(Integer roomId,Integer agendaID);

	//按无纸化的ip查询出坐席单元 
	SeatUnit findPaperlessDeviceusedIP(String paperlessDeviceusedIP);

	//批量修改无纸化的ip和主持人ip
	List<SeatUnit> updateSeatAddressIpsOrSpareAddressIP(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo);
	
}
