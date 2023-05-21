package org.ld.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.ld.model.SeatUnit;
import org.ld.vo.AgendaPersonResult;
import org.ld.vo.SeatUnitVo;

/**
 * 席位单元 dao t_seatunit
 */
public interface SeatUnitDao {
	// 根据坐席图id查询坐席单元
	List<SeatUnitVo> getSeatUnitsByModelId(SeatUnit seatUnit);

	// 批量新增 坐席单元
	void addSeatUnits(List seatUnitList);

	// 修改 坐席单元
	void modifySeatUnits(SeatUnit seatUnit);

	// 批量修改坐席单元
	void updateSeatUnits(List<SeatUnit> updateList);

	// 批量删除坐席单元
	void deleteSeatUnits(List<Integer> idList);

	// 增加坐席单元
	int addSeatUnit(SeatUnit seatUnit);

	// 批量删除坐席单元
	void deleteModelSeatUnits(List<Integer> idList);

	// 按id查询单个坐席单元
	SeatUnitVo findSeatUnitId(SeatUnit seatUnit);

	// 修改单个座席单元
	void updateSeatUnitId(SeatUnitVo seatUnitVo);

	//按会议室的id查询出坐席单元
	List<Map> findRoomSeatUnitList(Integer roomId);
	
	//按日程下的坐席单元查询绑定的人员信息
	AgendaPersonResult getAgendaPersonSeatUnitList(@Param("seatID")Integer seatID, @Param("agendaID")Integer agendaID);

	//按无纸化的ip查询出坐席单元
	SeatUnit findPaperlessDeviceusedIP(String paperlessDeviceusedIP);

	//批量修改无纸化ip
	void updateSeatAddressIps(List<SeatUnit> seatUnits);

	//批量修改主持人ip
	void updateSeatSpareAddressIPs(List<SeatUnit> seatUnits);

	//查看坐席模板下的坐席单元的id集合
	List<Integer> getSeatUnitsIntegerByModelId(Integer in);
}
