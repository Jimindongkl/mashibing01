package org.ld.service.WebSocketService;

import org.ld.model.webSocketModel.WebSocketClientModel;

import java.util.List;

public interface IWebSocketClientService {

    List<WebSocketClientModel> getApplyPeople();

    void insertApplyInformation(String SeatID);

    List<WebSocketClientModel> getSpeakers();

    void insertOrUpdateApplyInformation(String SeatID);

    void updateEndTime(WebSocketClientModel model);

    void deleteSpeakRecordBySrId(WebSocketClientModel model);

    String selectIsAlreadyAgenda();

    Integer searchFirstSpeakPower(String StaffID);
}
