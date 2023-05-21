package org.ld.model.congressModel;

import java.io.Serializable;

import org.ld.model.StaffInfo;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：CongressPerson     t_congressperson
 * 类描述：    会议绑定人员
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月27日 下午4:05:55    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月27日 下午4:05:55    
 * 修改备注：       
 * @version </pre>
 */
public class CongressPerson implements Serializable{

	private static final long serialVersionUID = 5313982996550473254L;

	//会议绑定人员的id
	private Integer id;
	//会议ID
	private Integer congressID;
	//基础人员ID
	private Integer staffID;
	//基础人员实体
    private StaffInfo staffInfo;
    /*******************************************/
    private Integer staffCategoryID;
    private Integer staffGroupID;
    private Integer nationID;
    private Integer dictionaryID;
    /**********************************************/
	//证件类型
	private Integer cardType;
	//人员编号
	private String codeNum;
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
	//查询权
	private Integer searchPower;
	//备注
	private String remark;
	//X坐标
	private Integer xpoint;
	//y坐标
	private Integer ypoint;
	//席位ID
	private Integer seatID;
	//坐席区域   同会议室分区
	private String seatArea;
	//人员状态  
	private Integer status;
	//签到状态（首次时间）
	private Integer checkState;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCongressID() {
		return congressID;
	}
	public void setCongressID(Integer congressID) {
		this.congressID = congressID;
	}
	public Integer getStaffID() {
		return staffID;
	}
	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public String getCodeNum() {
		return codeNum;
	}
	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
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
	public Integer getSearchPower() {
		return searchPower;
	}
	public void setSearchPower(Integer searchPower) {
		this.searchPower = searchPower;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getXpoint() {
		return xpoint;
	}
	public void setXpoint(Integer xpoint) {
		this.xpoint = xpoint;
	}
	public Integer getYpoint() {
		return ypoint;
	}
	public void setYpoint(Integer ypoint) {
		this.ypoint = ypoint;
	}
	public Integer getSeatID() {
		return seatID;
	}
	public void setSeatID(Integer seatID) {
		this.seatID = seatID;
	}
	public String getSeatArea() {
		return seatArea;
	}
	public void setSeatArea(String seatArea) {
		this.seatArea = seatArea;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCheckState() {
		return checkState;
	}
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	public StaffInfo getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}
	public Integer getStaffCategoryID() {
		return staffCategoryID;
	}
	public void setStaffCategoryID(Integer staffCategoryID) {
		this.staffCategoryID = staffCategoryID;
	}
	public Integer getStaffGroupID() {
		return staffGroupID;
	}
	public void setStaffGroupID(Integer staffGroupID) {
		this.staffGroupID = staffGroupID;
	}
	public Integer getNationID() {
		return nationID;
	}
	public void setNationID(Integer nationID) {
		this.nationID = nationID;
	}
	public Integer getDictionaryID() {
		return dictionaryID;
	}
	public void setDictionaryID(Integer dictionaryID) {
		this.dictionaryID = dictionaryID;
	}
	
	
	@Override
	public String toString() {
		return "CongressPerson [id=" + id + ", congressID=" + congressID + ", staffID=" + staffID + ", staffInfo="
				+ staffInfo + ", staffCategoryID=" + staffCategoryID + ", staffGroupID=" + staffGroupID + ", nationID="
				+ nationID + ", dictionaryID=" + dictionaryID + ", cardType=" + cardType + ", codeNum=" + codeNum
				+ ", reportPower=" + reportPower + ", votePower=" + votePower + ", speakPower=" + speakPower
				+ ", firstSpeakPower=" + firstSpeakPower + ", callPower=" + callPower + ", searchPower=" + searchPower
				+ ", remark=" + remark + ", xpoint=" + xpoint + ", ypoint=" + ypoint + ", seatID=" + seatID
				+ ", seatArea=" + seatArea + ", status=" + status + ", checkState=" + checkState + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
