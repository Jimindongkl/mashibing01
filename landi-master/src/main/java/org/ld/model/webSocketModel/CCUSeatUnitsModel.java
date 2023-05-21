package org.ld.model.webSocketModel;

/**
 * @program: landi-master
 * @description: 拼接坐席单元数据模型
 * @author: 魏中元
 * @create: 2020-08-06 09:58
 **/
public class CCUSeatUnitsModel {
    /**************************t_agendaperson************************/
    //坐席id
    private Integer AP_SeatID;
    //报道权
    private Integer AP_ReportPower;
    //表决权
    private Integer AP_VotePower;
    //发言权
    private Integer AP_SpeakPower;
    //优先发言权
    private Integer AP_FirstSpeakPower;
    //呼叫权
    private Integer AP_CallPower;
    //查询权（搜索权）
    private Integer AP_SearchPower;
    //基础人员id 用来查卡号
    private Integer AP_StaffID;
    /**************************t_agendaperson************************/
    /**************************t_seatdevice***********************/
    //设备id
    private Integer SD_DeviceID;
    //设备通道号
    private Integer SD_PassWayCode;
    //设备地址号
    private Integer SD_CCUAddressCode;
    /**************************t_seatdevice***********************/

    /**************************st_ViceCardNum***********************/
    //卡号（主卡卡号）
    private Integer st_ViceCardNum;
    /**************************st_ViceCardNum***********************/

    public Integer getAP_SeatID() {
        return AP_SeatID;
    }

    public void setAP_SeatID(Integer AP_SeatID) {
        this.AP_SeatID = AP_SeatID;
    }

    public Integer getAP_ReportPower() {
        return AP_ReportPower;
    }

    public void setAP_ReportPower(Integer AP_ReportPower) {
        this.AP_ReportPower = AP_ReportPower;
    }

    public Integer getAP_VotePower() {
        return AP_VotePower;
    }

    public void setAP_VotePower(Integer AP_VotePower) {
        this.AP_VotePower = AP_VotePower;
    }

    public Integer getAP_SpeakPower() {
        return AP_SpeakPower;
    }

    public void setAP_SpeakPower(Integer AP_SpeakPower) {
        this.AP_SpeakPower = AP_SpeakPower;
    }

    public Integer getAP_FirstSpeakPower() {
        return AP_FirstSpeakPower;
    }

    public void setAP_FirstSpeakPower(Integer AP_FirstSpeakPower) {
        this.AP_FirstSpeakPower = AP_FirstSpeakPower;
    }

    public Integer getAP_CallPower() {
        return AP_CallPower;
    }

    public void setAP_CallPower(Integer AP_CallPower) {
        this.AP_CallPower = AP_CallPower;
    }

    public Integer getAP_SearchPower() {
        return AP_SearchPower;
    }

    public void setAP_SearchPower(Integer AP_SearchPower) {
        this.AP_SearchPower = AP_SearchPower;
    }

    public Integer getAP_StaffID() {
        return AP_StaffID;
    }

    public void setAP_StaffID(Integer AP_StaffID) {
        this.AP_StaffID = AP_StaffID;
    }

    public Integer getSD_DeviceID() {
        return SD_DeviceID;
    }

    public void setSD_DeviceID(Integer SD_DeviceID) {
        this.SD_DeviceID = SD_DeviceID;
    }

    public Integer getSD_PassWayCode() {
        return SD_PassWayCode;
    }

    public void setSD_PassWayCode(Integer SD_PassWayCode) {
        this.SD_PassWayCode = SD_PassWayCode;
    }

    public Integer getSD_CCUAddressCode() {
        return SD_CCUAddressCode;
    }

    public void setSD_CCUAddressCode(Integer SD_CCUAddressCode) {
        this.SD_CCUAddressCode = SD_CCUAddressCode;
    }

    public Integer getSt_ViceCardNum() {
        return st_ViceCardNum;
    }

    public void setSt_ViceCardNum(Integer st_ViceCardNum) {
        this.st_ViceCardNum = st_ViceCardNum;
    }
}
