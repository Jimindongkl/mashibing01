package org.ld.service.WebSocketService.impl;

import org.ld.dao.webSocketDao.WebSocketClientDao;
import org.ld.model.webSocketModel.WebSocketClientModel;
import org.ld.service.WebSocketService.IWebSocketClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: landi-master
 * @description: 接收CCU消息，需要进行数据库交互的部分接口
 * @author: 魏中元
 * @create: 2020-11-17 11:30
 **/
@Service("WebSocketClientService")
public class WebSocketClientServiceImpl implements IWebSocketClientService {
    @Autowired
    private WebSocketClientDao webSocketClientDao;
    /** 获取申请发言人列表*/
    public List<WebSocketClientModel> getApplyPeople(){
        List<WebSocketClientModel> modelList ;
        modelList =  webSocketClientDao.getApplyPeople();
        return modelList;
    }
    /** 增加申请发言人信息*/
    public void insertApplyInformation(String SeatID){
    	 System.out.println("insertApplyInformation SeatID："+SeatID);
        Integer isTrueOrNot = webSocketClientDao.isAlreadySpeakOrNot(SeatID);
        if(isTrueOrNot == 0){
            WebSocketClientModel model = new WebSocketClientModel();
            model.setSR_ApplyTime(new Date());
            model.setSR_CreateTime(new Date());
            model.setSR_AginSpeak(0);
            model.setSR_SeatID(SeatID);
            model.setSR_AgendaStaffID(Integer.valueOf(SeatID));//根据seatId 传入对应的会议人员id
            webSocketClientDao.insertApplyInformation(model);
        }

    }
    /** 获取正在发言人列表 */
    public List<WebSocketClientModel> getSpeakers(){
        List<WebSocketClientModel> modelList ;
        modelList =  webSocketClientDao.getSpeakers();
        return modelList;
    }
    /** 根据坐席id 修改或插入 正在发言人信息 */
    public void insertOrUpdateApplyInformation(String SeatID){
    	 System.out.println("insertOrUpdateApplyInformation SeatID："+SeatID);
        WebSocketClientModel model = new WebSocketClientModel();
        Integer isTrueOrNot ;//判断当前人员 是否存在开始发言时间记录
        Integer isAginSpeak;
        model.setSR_StartTime(new Date());
        model.setSR_AgendaStaffID(Integer.valueOf(SeatID));
        model.setSR_SeatID(SeatID);
        isTrueOrNot = webSocketClientDao.isAlreadySpeakOrNot(SeatID);
        if(isTrueOrNot == 1){
            model.setSR_AginSpeak(0);
            webSocketClientDao.updateStartTime(model);
        }else{
            isAginSpeak = webSocketClientDao.isAginSpeak(SeatID);
            if(isAginSpeak == 0 ){
                model.setSR_AginSpeak(0);
                webSocketClientDao.insertStartTime(model);
            }else {
                model.setSR_AginSpeak(1);//是二次发言
                webSocketClientDao.updateStartTime(model);
            }
        }

    }
    //根据坐席id 修改对应人 结束发言时间
    public void updateEndTime(WebSocketClientModel model){
        model.setSR_EndTime(new Date());
        webSocketClientDao.updateEndTime(model);
    }

    @Override
    public void deleteSpeakRecordBySrId(WebSocketClientModel model) {
        String Agenda = webSocketClientDao.selectIsAlreadyAgenda();
        model.setSR_AgendaID(Integer.valueOf(Agenda));
        webSocketClientDao.deleteSpeakRecordBySrId(model);
    }

    @Override
    public String selectIsAlreadyAgenda() {

        return webSocketClientDao.selectIsAlreadyAgenda();
    }

    @Override
    public Integer searchFirstSpeakPower(String StaffID) {

        return webSocketClientDao.searchFirstSpeakPower(StaffID);
    }


}
