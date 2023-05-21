package org.ld.dao.webSocketDao;

import org.ld.model.webSocketModel.CCUFirestConnectModel;
import org.ld.model.webSocketModel.CCUSeatUnitsModel;

import java.util.List;

/**
 * CCU控制程序获取中控机信息
 * */
public interface CCUFirestConnectDao {

    /**
     * 根据设备id 获取设备基本信息
     * */
    CCUFirestConnectModel findDeviceInformation(String id);

    /**
     * 正在召开的会议信息
     * */
    CCUFirestConnectModel findIsRunning();

    /**
     * 根据当前开会的会议id 查询坐席单元信息
     * */
    List<CCUSeatUnitsModel> findSeatUnitsInformation(String id);

    /***
     * 查询当前会议用到的活动设备id
     */
    List<CCUFirestConnectModel> findIsUsedDeviceId();

}
