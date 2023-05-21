package org.ld.vo;

import java.io.Serializable;
import java.util.Date;

public class AgendaSeatUitStaffInfoVo implements Serializable{

	private static final long serialVersionUID = -9098609219049087166L;

	//主键
	private Integer id;
	//名字
	private String name;
	//编号
	private String num;
	//照片
	private String image;
	//工作单位
	private String workUnit;
	//性别
	private Integer sex;
	//电话
	private String phone;
	//身份证号
	private String cardNum;
	//职务
	private String job;
	//委员号
	private String wynum;
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
	//X坐标(改  行号)
	private Integer xpoint;
	//y坐标(改 列号)
	private Integer ypoint;
	//席位ID
	private Integer seatID;
	//坐席区域   同会议室分区
	private String seatArea;
	//人员状态
	private Integer status;
	//签到时间
	private Date checkInTime;
	private String checkInTimeStr;
	//迁出时间
	private Date checkOutTime;
	private String checkOutTimeStr;
	//主持人 1 主持人   0或null 不是主持人
	private Integer moderator;
	//签到状态（首次时间）
	private Integer checkState;
    //人员类别id
	private Integer staffCategoryID;
	//人员类别
	private String categoryName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getWynum() {
		return wynum;
	}
	public void setWynum(String wynum) {
		this.wynum = wynum;
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
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public Integer getModerator() {
		return moderator;
	}
	public void setModerator(Integer moderator) {
		this.moderator = moderator;
	}
	public Integer getCheckState() {
		return checkState;
	}
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	public String getCheckInTimeStr() {
		return checkInTimeStr;
	}
	public void setCheckInTimeStr(String checkInTimeStr) {
		this.checkInTimeStr = checkInTimeStr;
	}
	public String getCheckOutTimeStr() {
		return checkOutTimeStr;
	}
	public void setCheckOutTimeStr(String checkOutTimeStr) {
		this.checkOutTimeStr = checkOutTimeStr;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName=categoryName;
	}
	public Integer getStaffCategoryID() {
		return staffCategoryID;
	}
	public void setStaffCategoryID(Integer staffCategoryID) {
		this.staffCategoryID=staffCategoryID;
	}
	@Override
	public String toString() {
		return "AgendaSeatUitStaffInfoVo [id=" + id + ", name=" + name + ", num=" + num + ", image=" + image
				+ ", workUnit=" + workUnit + ", sex=" + sex + ", phone=" + phone + ", cardNum=" + cardNum + ", job="
				+ job + ", wynum=" + wynum + ", codeNum=" + codeNum + ", reportPower=" + reportPower + ", votePower="
				+ votePower + ", speakPower=" + speakPower + ", firstSpeakPower=" + firstSpeakPower + ", callPower="
				+ callPower + ", searchPower=" + searchPower + ", remark=" + remark + ", xpoint=" + xpoint + ", ypoint="
				+ ypoint + ", seatID=" + seatID + ", seatArea=" + seatArea + ", status=" + status + ", checkInTime="
				+ checkInTime + ", checkInTimeStr=" + checkInTimeStr + ", checkOutTime=" + checkOutTime
				+ ", checkOutTimeStr=" + checkOutTimeStr + ", moderator=" + moderator + ", checkState=" + checkState
				+ "]";
	}
	
	

	
	
	
	
}
