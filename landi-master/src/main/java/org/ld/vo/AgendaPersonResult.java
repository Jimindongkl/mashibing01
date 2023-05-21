package org.ld.vo;

import java.io.Serializable;

public class AgendaPersonResult implements Serializable{

	private static final long serialVersionUID = -2561293771980561724L;

	//人员的id
	private Integer id;
	//主键id
	private Integer staffinfoId;
	//编号
	private String num;
	//姓名
	private String name;
	//分区
	private String seatArea ;
	//行号
	private Integer rowId;
	//列号
	private Integer columnId;
	//议程的id
	private Integer agendaID;
	//人员类型的id
	private Integer staffCategoryID;
	//团组
	private Integer staffGroupID;
	//工作单位
	private String workUnit;
	//职务
	private String job;
	//包含   -1全部  0已分配  1未分配  
	private Integer ISallot;
	//解绑的id
	private Integer agendaPersonId;
	
	
	public Integer getStaffinfoId() {
		return staffinfoId;
	}
	public void setStaffinfoId(Integer staffinfoId) {
		this.staffinfoId = staffinfoId;
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
	public String getSeatArea() {
		return seatArea;
	}
	public void setSeatArea(String seatArea) {
		this.seatArea = seatArea;
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
	public Integer getAgendaID() {
		return agendaID;
	}
	public void setAgendaID(Integer agendaID) {
		this.agendaID = agendaID;
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
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getISallot() {
		return ISallot;
	}
	public void setISallot(Integer iSallot) {
		ISallot = iSallot;
	}
	public Integer getAgendaPersonId() {
		return agendaPersonId;
	}
	public void setAgendaPersonId(Integer agendaPersonId) {
		this.agendaPersonId = agendaPersonId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "AgendaPersonResult [id=" + id + ", staffinfoId=" + staffinfoId + ", num=" + num + ", name=" + name
				+ ", seatArea=" + seatArea + ", rowId=" + rowId + ", columnId=" + columnId + ", agendaID=" + agendaID
				+ ", staffCategoryID=" + staffCategoryID + ", staffGroupID=" + staffGroupID + ", workUnit=" + workUnit
				+ ", job=" + job + ", ISallot=" + ISallot + ", agendaPersonId=" + agendaPersonId + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
