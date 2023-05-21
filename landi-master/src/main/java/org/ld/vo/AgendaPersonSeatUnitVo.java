package org.ld.vo;

import java.io.Serializable;

public class AgendaPersonSeatUnitVo implements Serializable{

	private static final long serialVersionUID = 9144206362710394858L;
	//人员id
	private Integer agendaPersonId;
	//坐席id
	private Integer seatUnitId;
	//行号
	private Integer rowId;
	//列号
	private Integer columnId;
	//分区
	private String seatArea;
	//主键id
	private Integer id;
	//序号
	private String num;
	//名字
	private String name;
	//人员状态
	private Integer status;
	//团组id
	private Integer staffGroupID;
	//团组名字
	private String staffGroupName;
	//人员类别 id
	private Integer staffCategoryID;
	//人员类别名字
	private String categoryName;
	//主卡卡号
	private String  viceCardNum;
	//人主持人 1 主持人   0或null 不是主持人
	private Integer moderator;
	//报到权
	private Integer reportPower;
	//表决权
	private Integer votePower;
	//发言权
	private Integer speakPower;
	//优先发言权
	private Integer firstSpeakPower;
	//呼叫权
	private Integer callPower;
	
	
	public Integer getAgendaPersonId() {
		return agendaPersonId;
	}
	public void setAgendaPersonId(Integer agendaPersonId) {
		this.agendaPersonId = agendaPersonId;
	}
	public Integer getSeatUnitId() {
		return seatUnitId;
	}
	public void setSeatUnitId(Integer seatUnitId) {
		this.seatUnitId = seatUnitId;
	}
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	public Integer getColumnId() {
		return columnId;
	}
	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}
	public String getSeatArea() {
		return seatArea;
	}
	public void setSeatArea(String seatArea) {
		this.seatArea = seatArea;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStaffGroupID() {
		return staffGroupID;
	}
	public void setStaffGroupID(Integer staffGroupID) {
		this.staffGroupID = staffGroupID;
	}
	public Integer getStaffCategoryID() {
		return staffCategoryID;
	}
	public void setStaffCategoryID(Integer staffCategoryID) {
		this.staffCategoryID = staffCategoryID;
	}
	public String getViceCardNum() {
		return viceCardNum;
	}
	public void setViceCardNum(String viceCardNum) {
		this.viceCardNum = viceCardNum;
	}
	public Integer getModerator() {
		return moderator;
	}
	public void setModerator(Integer moderator) {
		this.moderator = moderator;
	}
	public Integer getReportPower() {
		return reportPower;
	}
	public void setReportPower(Integer reportPower) {
		this.reportPower = reportPower;
	}
	public Integer getVotePower() {
		return votePower;
	}
	public void setVotePower(Integer votePower) {
		this.votePower = votePower;
	}
	public Integer getSpeakPower() {
		return speakPower;
	}
	public void setSpeakPower(Integer speakPower) {
		this.speakPower = speakPower;
	}
	public Integer getFirstSpeakPower() {
		return firstSpeakPower;
	}
	public void setFirstSpeakPower(Integer firstSpeakPower) {
		this.firstSpeakPower = firstSpeakPower;
	}
	public Integer getCallPower() {
		return callPower;
	}
	public void setCallPower(Integer callPower) {
		this.callPower = callPower;
	}
	public String getStaffGroupName() {
		return staffGroupName;
	}
	public void setStaffGroupName(String staffGroupName) {
		this.staffGroupName = staffGroupName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	@Override
	public String toString() {
		return "AgendaPersonSeatUnitVo [agendaPersonId=" + agendaPersonId + ", seatUnitId=" + seatUnitId + ", rowId="
				+ rowId + ", columnId=" + columnId + ", seatArea=" + seatArea + ", id=" + id + ", num=" + num
				+ ", name=" + name + ", status=" + status + ", staffGroupID=" + staffGroupID + ", staffGroupName="
				+ staffGroupName + ", staffCategoryID=" + staffCategoryID + ", categoryName=" + categoryName
				+ ", viceCardNum=" + viceCardNum + ", moderator=" + moderator + ", reportPower=" + reportPower
				+ ", votePower=" + votePower + ", speakPower=" + speakPower + ", firstSpeakPower=" + firstSpeakPower
				+ ", callPower=" + callPower + "]";
	}
	
	
	
	
	

	
	
	
	
	
	
}
