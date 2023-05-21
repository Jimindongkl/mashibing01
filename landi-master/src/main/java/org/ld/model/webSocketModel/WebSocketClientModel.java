package org.ld.model.webSocketModel;

import java.util.Date;

/**
 * @program: landi-master
 * @description: 根据ccu消息做数据库交互所用的
 * @author: 魏中元
 * @create: 2020-11-17 11:42
 **/
public class WebSocketClientModel {
    /** t_speakrecord 发言记录*/
    //记录ID
    private Integer SR_ID;
    //议程ID
    private Integer SR_AgendaID;
    //会议人员ID
    private Integer SR_AgendaStaffID;
    //议题ID
    private Integer SR_TopicID;
    //开始申请时间
    private Date SR_ApplyTime;
    //开始发言时间
    private Date SR_StartTime;
    //结束发言时间
    private Date SR_EndTime;
    //是否二次发言 0否 1是
    private Integer SR_AginSpeak;
    //创建时间
    private Date SR_CreateTime;
    //备注
    private String SR_Remark;
    //坐席id
    private String SR_SeatID;
    /** t_speakrecord 发言记录  end*/
    public String getSR_SeatID() {
    	return  SR_SeatID;
    }
    public void setSR_SeatID(String SR_SeatID) {
    	this.SR_SeatID=SR_SeatID;
    }
    public Integer getSR_ID() {
        return SR_ID;
    }

    public void setSR_ID(Integer SR_ID) {
        this.SR_ID = SR_ID;
    }

    public Integer getSR_AgendaID() {
        return SR_AgendaID;
    }

    public void setSR_AgendaID(Integer SR_AgendaID) {
        this.SR_AgendaID = SR_AgendaID;
    }

    public Integer getSR_AgendaStaffID() {
        return SR_AgendaStaffID;
    }

    public void setSR_AgendaStaffID(Integer SR_AgendaStaffID) {
        this.SR_AgendaStaffID = SR_AgendaStaffID;
    }

    public Integer getSR_TopicID() {
        return SR_TopicID;
    }

    public void setSR_TopicID(Integer SR_TopicID) {
        this.SR_TopicID = SR_TopicID;
    }

    public Date getSR_ApplyTime() {
        return SR_ApplyTime;
    }

    public void setSR_ApplyTime(Date SR_ApplyTime) {
        this.SR_ApplyTime = SR_ApplyTime;
    }

    public Date getSR_StartTime() {
        return SR_StartTime;
    }

    public void setSR_StartTime(Date SR_StartTime) {
        this.SR_StartTime = SR_StartTime;
    }

    public Date getSR_EndTime() {
        return SR_EndTime;
    }

    public void setSR_EndTime(Date SR_EndTime) {
        this.SR_EndTime = SR_EndTime;
    }

    public Integer getSR_AginSpeak() {
        return SR_AginSpeak;
    }

    public void setSR_AginSpeak(Integer SR_AginSpeak) {
        this.SR_AginSpeak = SR_AginSpeak;
    }

    public Date getSR_CreateTime() {
        return SR_CreateTime;
    }

    public void setSR_CreateTime(Date SR_CreateTime) {
        this.SR_CreateTime = SR_CreateTime;
    }

    public String getSR_Remark() {
        return SR_Remark;
    }

    public void setSR_Remark(String SR_Remark) {
        this.SR_Remark = SR_Remark;
    }
}
