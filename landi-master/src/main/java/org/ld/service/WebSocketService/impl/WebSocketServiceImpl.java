package org.ld.service.WebSocketService.impl;

import org.ld.dao.webSocketDao.CCUFirestConnectDao;
import org.ld.dao.webSocketDao.WebSocketDao;
import org.ld.model.webSocketModel.CCUFirestConnectModel;
import org.ld.model.webSocketModel.CCUSeatUnitsModel;
import org.ld.model.webSocketModel.WebSocketModel;
import org.ld.service.WebSocketService.IWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: landi-master
 * @description: webSocket与CCU端反馈数据接口
 * @author: 魏中元
 * @create: 2020-08-04 10:29
 **/
@Service("myWebSocketService")
public class WebSocketServiceImpl implements IWebSocketService   {
    @Autowired
    WebSocketDao webSocketDao;
    @Autowired
    CCUFirestConnectDao ccuFirestConnectDao;
    @Override
    public WebSocketModel findReportResults(String toCongressID) {
        return webSocketDao.findReportResults(toCongressID);
    }

    @Override
    public WebSocketModel findVoteTopicById(String id) {
        return webSocketDao.findVoteTopicById(id);
    }

    @Override
    public List<WebSocketModel> findChildById(String id) {
        return webSocketDao.findChildById(id);
    }

    @Override
    public WebSocketModel findVoteResultById(String id) {
        return webSocketDao.findVoteResultById(id);
    }

    @Override
    public WebSocketModel getTopicContent(String id) {
        return webSocketDao.getTopicContent(id);
    }

    @Override
    public CCUFirestConnectModel findIsRunning() {
        return ccuFirestConnectDao.findIsRunning();
    }

    @Override
    public CCUFirestConnectModel findDeviceInformation(String id) {
        return ccuFirestConnectDao.findDeviceInformation(id);
    }

    @Override
    public List<CCUSeatUnitsModel> findSeatUnitsInformation(String id) {
        return ccuFirestConnectDao.findSeatUnitsInformation(id);
    }

    @Override
    public List<CCUFirestConnectModel> findIsUsedDeviceId() {
        return ccuFirestConnectDao.findIsUsedDeviceId();
    }

    @Override
    public void updateVoteByWebSocket(WebSocketModel model) {

        webSocketDao.updateVoteByWebSocket(model);
    }
    @Override
    public void doVoteNumInitialization(String agendaId){
        webSocketDao.doVoteNumInitialization(agendaId);
    }

    @Override
    public Integer countShouldNum(String topId) {
        return webSocketDao.countShouldNum(topId);
    }

    @Override
    public Integer countActualNum(String topId) {
        return webSocketDao.countActualNum(topId);
    }

    @Override
    public void updateSAnumByTopId(WebSocketModel model) {
        webSocketDao.updateSAnumByTopId(model);
    }

    @Override
    public void updateVoteResult(WebSocketModel model) {
        webSocketDao.updateVoteResult(model);
    }
}
