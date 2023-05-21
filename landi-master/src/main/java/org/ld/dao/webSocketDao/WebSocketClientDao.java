package org.ld.dao.webSocketDao;

import org.ld.model.webSocketModel.WebSocketClientModel;

import java.util.List;

/** 根据CCU消息做相应处理*/
public interface WebSocketClientDao {
    /** 查询申请发言人列表*/
    List<WebSocketClientModel> getApplyPeople();
    /** 查询正在发言人列表*/
    List<WebSocketClientModel> getSpeakers();
    /** 增加申请发言记录*/
    void insertApplyInformation(WebSocketClientModel webSocketClientModel);

    /** 根据seatid 查询表中是否存在当前发言人 */
    Integer isAlreadySpeakOrNot(String seatId);
    /** 增加开始发言时间*/
    void insertStartTime(WebSocketClientModel webSocketClientModel);
    /** 更新开始发言时间*/
    void updateStartTime(WebSocketClientModel webSocketClientModel);
    /** 更新结束发言时间*/
    void updateEndTime(WebSocketClientModel webSocketClientModel);

    /** 是否二次发言，根据人员id查询，有记录则为二次发言*/
    Integer isAginSpeak(String seatId);

    /** 根据坐席id和议题号 删除发言人记录*/
    void deleteSpeakRecordBySrId(WebSocketClientModel webSocketClientModel);

    /** 获取当前会议议程*/
    String selectIsAlreadyAgenda();

    Integer searchFirstSpeakPower(String StaffID);
}
