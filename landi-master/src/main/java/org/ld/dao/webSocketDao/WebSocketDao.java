package org.ld.dao.webSocketDao;

import org.ld.model.webSocketModel.WebSocketModel;

import java.util.List;

public interface WebSocketDao {
    /**
     * 根据会议id 查询报道结果
     * */
    WebSocketModel findReportResults(String toCongressID);
    /**
     * 根据id查询当前表决议题信息
     * */
    WebSocketModel findVoteTopicById(String id);
    /**
     * 根据议题id查询 该议题是否包含子议题
     * */
    List<WebSocketModel> findChildById(String id);

    /**
     * 根据议题id 查询表决结果
     * */
    WebSocketModel findVoteResultById(String id);

    /**
     * 根据议题id 查询议题内容
     * */
    WebSocketModel getTopicContent(String id);

    /** 表决前初始化按键人数*/
    void doVoteNumInitialization(String agendaId);

    /** 表决持久化*/
    void updateVoteByWebSocket(WebSocketModel model);
    /** 应到人数*/
    Integer countShouldNum(String topId);

    /** 实到人数*/
    Integer countActualNum(String topId);

    /** 更新应到、实到人数*/
    void updateSAnumByTopId(WebSocketModel model);

    /** 更新表决结果 1为no 0为yes*/
    void updateVoteResult(WebSocketModel model);

}
