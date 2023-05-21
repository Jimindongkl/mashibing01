package org.ld.model.paperlessModel;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StaffInfoSelfModel implements Serializable{

	private static final long serialVersionUID = 588198590793892759L;

	//基础人员的id
	private Integer staffInfoId;
	//搜索开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	//搜索结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	
	public Integer getStaffInfoId() {
		return staffInfoId;
	}
	public void setStaffInfoId(Integer staffInfoId) {
		this.staffInfoId = staffInfoId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	@Override
	public String toString() {
		return "StaffInfoSelfModel [staffInfoId=" + staffInfoId + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
	
	
	
	
}
