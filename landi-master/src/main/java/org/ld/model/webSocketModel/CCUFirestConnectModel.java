package org.ld.model.webSocketModel;

/**
 * @program: landi-master
 * @description: en
 * @author: 魏中元
 * @create: 2020-08-04 12:34
 **/
public class CCUFirestConnectModel {

    /**************************t_device************************/
        /*//设备id
        private String devID;
        //设备ip
        private String devNetIPAddress;
        //设备端口(发送端口）
        private String devNetSendPort;
        //最小通道号（通道起始号）
        private String devPassWayStartNum;
        //通道数量
        private String devPassWayCount;*/
    /**************************t_device************************/
    /**************************t_deviceused************************/
        //设备id
        private String DU_ID;
        //设备ip
        private String DU_NetIPAddress;
        //设备端口(发送端口）
        private String DU_NetSendPort;
        //最小通道号（通道起始号）
        private String DU_PassWayStartNum;
        //通道数量
        private String DU_PassWayCount;

        public String getDU_ID() {
            return DU_ID;
        }

        public void setDU_ID(String DU_ID) {
            this.DU_ID = DU_ID;
        }

        public String getDU_NetIPAddress() {
            return DU_NetIPAddress;
        }

        public void setDU_NetIPAddress(String DU_NetIPAddress) {
            this.DU_NetIPAddress = DU_NetIPAddress;
        }

        public String getDU_NetSendPort() {
            return DU_NetSendPort;
        }

        public void setDU_NetSendPort(String DU_NetSendPort) {
            this.DU_NetSendPort = DU_NetSendPort;
        }

        public String getDU_PassWayStartNum() {
            return DU_PassWayStartNum;
        }

        public void setDU_PassWayStartNum(String DU_PassWayStartNum) {
            this.DU_PassWayStartNum = DU_PassWayStartNum;
        }

        public String getDU_PassWayCount() {
            return DU_PassWayCount;
        }

        public void setDU_PassWayCount(String DU_PassWayCount) {
            this.DU_PassWayCount = DU_PassWayCount;
        }

    /**************************t_deviceused************************/
    /**************************t_congress***********************/
        //会议id
        private String CongressId;
        //报到模式
        private Integer coCheckInType;
        //就坐模式
        private Integer coSeatMode;
    /**************************t_congress***********************/

    /**************************t_topic***********************/
        //发言模式
        private Integer toSpeakMode;
        //表决模式
        private Integer toVoteMethod;
        //表决结果显示模式
        private Integer toShowMode;
    /**************************t_topic***********************/
   /* public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getDevNetIPAddress() {
        return devNetIPAddress;
    }

    public void setDevNetIPAddress(String devNetIPAddress) {
        this.devNetIPAddress = devNetIPAddress;
    }

    public String getDevNetSendPort() {
        return devNetSendPort;
    }

    public void setDevNetSendPort(String devNetSendPort) {
        this.devNetSendPort = devNetSendPort;
    }

    public String getDevPassWayStartNum() {
        return devPassWayStartNum;
    }

    public void setDevPassWayStartNum(String devPassWayStartNum) {
        this.devPassWayStartNum = devPassWayStartNum;
    }

    public String getDevPassWayCount() {
        return devPassWayCount;
    }

    public void setDevPassWayCount(String devPassWayCount) {
        this.devPassWayCount = devPassWayCount;
    }*/

    public Integer getCoCheckInType() {
        return coCheckInType;
    }

    public void setCoCheckInType(Integer coCheckInType) {
        this.coCheckInType = coCheckInType;
    }

    public Integer getCoSeatMode() {
        return coSeatMode;
    }

    public void setCoSeatMode(Integer coSeatMode) {
        this.coSeatMode = coSeatMode;
    }

    public Integer getToSpeakMode() {
        return toSpeakMode;
    }

    public void setToSpeakMode(Integer toSpeakMode) {
        this.toSpeakMode = toSpeakMode;
    }

    public Integer getToVoteMethod() {
        return toVoteMethod;
    }

    public void setToVoteMethod(Integer toVoteMethod) {
        this.toVoteMethod = toVoteMethod;
    }

    public Integer getToShowMode() {
        return toShowMode;
    }

    public void setToShowMode(Integer toShowMode) {
        this.toShowMode = toShowMode;
    }

    public String getCongressId() {
        return CongressId;
    }

    public void setCongressId(String CongressId) {
        this.CongressId = CongressId;
    }
}
