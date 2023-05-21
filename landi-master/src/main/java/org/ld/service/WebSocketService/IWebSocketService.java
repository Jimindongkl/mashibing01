package org.ld.service.WebSocketService;

import org.ld.model.webSocketModel.CCUFirestConnectModel;
import org.ld.model.webSocketModel.CCUSeatUnitsModel;
import org.ld.model.webSocketModel.WebSocketModel;

import java.util.List;

public interface IWebSocketService {
    WebSocketModel findReportResults(String toCongressID);

    WebSocketModel findVoteTopicById(String id);

    List<WebSocketModel> findChildById(String id);

    WebSocketModel findVoteResultById(String id);

    WebSocketModel getTopicContent(String id);

    CCUFirestConnectModel findIsRunning();

    CCUFirestConnectModel findDeviceInformation(String id);

    List<CCUSeatUnitsModel> findSeatUnitsInformation(String id);

    List<CCUFirestConnectModel> findIsUsedDeviceId();

    void updateVoteByWebSocket(WebSocketModel model);

    void doVoteNumInitialization(String agendaId);

    Integer countShouldNum(String topId);

    Integer countActualNum(String topId);

    void updateSAnumByTopId(WebSocketModel model);

    void updateVoteResult(WebSocketModel model);
}
