package org.ld.vo;

import java.io.Serializable;

public class AgendaPersonResultByModelVo implements Serializable{
	
	
	
	private static final long serialVersionUID = -2326126733172800753L;
	
	//基础人员的id
	private Integer  staffinfoID;
	//编号
	private String num;
	//类型
	private Integer categoryID;
	////团组
	private Integer groupID;
	//工作单位
	private String workUnit;
	//电话
	private String phone;
	//主卡
	private String viceCardNum;
	//副卡
	private String viceCardNumA;
	//(上)备注
	private String stRemarks;
	//是否可用
	private Integer enabled;
	//党派
	private Integer partyID;
	//照片
	private String image;
	//姓名
	private String name;
	//性别
	private Integer sex;
	//民族
	private Integer nationID;
	//职位
	private String job;
	//身份证号码
	private String cardNum;
	//议程绑定的id
	private Integer agendaPersonID;
	//会议绑定的id
	private Integer congressPersonID;
	//(下)备注
	private String apRemark;
	 //人员状态     
	private Integer status;
	//主持人	0否1是
	private Integer moderator;
	//报到权	0不可用  1可用
	private Integer reportPower;
	//表决权	0不可用  1可用
	private Integer votePower;
	//发言权	0不可用  1可用
	private Integer speakPower;
	//优先发言权	0不可用  1可用
	private Integer firstSpeakPower;
	//呼叫权	0不可用  1可用
	private Integer callPower;
	//查询权	0不可用  1可用
	private Integer searchPower;
	
	
	public Integer getStaffinfoID() {
		return staffinfoID;
	}
	public void setStaffinfoID(Integer staffinfoID) {
		this.staffinfoID = staffinfoID;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getViceCardNum() {
		return viceCardNum;
	}
	public void setViceCardNum(String viceCardNum) {
		this.viceCardNum = viceCardNum;
	}
	public String getViceCardNumA() {
		return viceCardNumA;
	}
	public void setViceCardNumA(String viceCardNumA) {
		this.viceCardNumA = viceCardNumA;
	}
	public String getStRemarks() {
		return stRemarks;
	}
	public void setStRemarks(String stRemarks) {
		this.stRemarks = stRemarks;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public Integer getPartyID() {
		return partyID;
	}
	public void setPartyID(Integer partyID) {
		this.partyID = partyID;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getNationID() {
		return nationID;
	}
	public void setNationID(Integer nationID) {
		this.nationID = nationID;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Integer getAgendaPersonID() {
		return agendaPersonID;
	}
	public void setAgendaPersonID(Integer agendaPersonID) {
		this.agendaPersonID = agendaPersonID;
	}
	public Integer getCongressPersonID() {
		return congressPersonID;
	}
	public void setCongressPersonID(Integer congressPersonID) {
		this.congressPersonID = congressPersonID;
	}
	public String getApRemark() {
		return apRemark;
	}
	public void setApRemark(String apRemark) {
		this.apRemark = apRemark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getSearchPower() {
		return searchPower;
	}
	public void setSearchPower(Integer searchPower) {
		this.searchPower = searchPower;
	}
	
	
	

}
