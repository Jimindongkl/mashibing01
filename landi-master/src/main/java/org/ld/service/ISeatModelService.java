package org.ld.service;

import java.util.List;

import org.ld.model.SeatModel;
import org.ld.model.SeatTheme;
import org.ld.response.ResponseServer;
import org.ld.vo.SeatUnitVo;

public interface ISeatModelService {
    //按条件查询 坐席图
    List<SeatModel> getSeatModels(SeatModel seatModel );
    //添加 或 修改 坐席图
    void addOrUpdateSeatModel(SeatModel seatModel );
    //根据id 修改 坐席图矩阵
    void updateFilexmlById(SeatModel seatModel);
    //删除坐席图
    ResponseServer  deleteSeatModel(String str);
    //根据坐席图id 修改 坐席图单元
    ResponseServer updateSeatUnits(SeatModel seatModel);
    //查看席位图标主题套图
	List<SeatTheme> getSeatThemes();
	//修改席位图标主题套图
	void updateSeatTheme(SeatTheme seatTheme);
	//按会议室的id查询坐席图的详细信息
	SeatModel findRoomIdToSeatModelInfo(Integer roomId);
	//按坐席模板的id查询坐席单元
	List<SeatUnitVo> getSeatUnitsByModelId(SeatModel seatModel);

}
