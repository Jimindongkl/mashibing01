package org.ld.model.congressModel;

import java.io.Serializable;
import java.util.Date;

import org.ld.model.Room;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Agenda    对应 t_agenda
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月3日 上午9:32:22    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月3日 上午9:32:22    
 * 修改备注：       
 * @version </pre>
 */
public class Agenda implements Serializable{

	private static final long serialVersionUID = 7456701319191229816L;

	//会议议程id
	private Integer id;
	//会议
	private Congress congress;
	//议程名称
	private String agName;
	//会议室
	private Room room;
	//议程内容
	private String content;
	//议程开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date startTime;
	//议程结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date endTime;
	//议程类型
	private Integer agType;
	//报到开始时间
	private Date checkInTime;
	//报到结束时间
	private Date checkOverTime;
	//排序
	private Integer serial;
	//人员坐席图
	private String seatGraph;
	//报到方式
	private Integer checkInType;
	//就坐方式
	private Integer seatType;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态  0未召开 1正在召开 2 已经召开
	private Integer status;
	//备注
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Congress getCongress() {
		return congress;
	}
	public void setCongress(Congress congress) {
		this.congress = congress;
	}
	public String getAgName() {
		return agName;
	}
	public void setAgName(String agName) {
		this.agName = agName;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getAgType() {
		return agType;
	}
	public void setAgType(Integer agType) {
		this.agType = agType;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOverTime() {
		return checkOverTime;
	}
	public void setCheckOverTime(Date checkOverTime) {
		this.checkOverTime = checkOverTime;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public String getSeatGraph() {
		return seatGraph;
	}
	public void setSeatGraph(String seatGraph) {
		this.seatGraph = seatGraph;
	}
	public Integer getCheckInType() {
		return checkInType;
	}
	public void setCheckInType(Integer checkInType) {
		this.checkInType = checkInType;
	}
	public Integer getSeatType() {
		return seatType;
	}
	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", congress=" + congress + ", agName=" + agName + ", room=" + room + ", content="
				+ content + ", startTime=" + startTime + ", endTime=" + endTime + ", agType=" + agType
				+ ", checkInTime=" + checkInTime + ", checkOverTime=" + checkOverTime + ", serial=" + serial
				+ ", seatGraph=" + seatGraph + ", checkInType=" + checkInType + ", seatType=" + seatType
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", status=" + status + ", remark="
				+ remark + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
