package org.ld.model;

import java.io.Serializable;

public class RoomPart implements Serializable{

	private static final long serialVersionUID = 2204256580254962437L;

	//会议室分区id
	private Integer id;
	//会议室id
	private Integer roomID; 
	//分区名称
	private String partName;
	//分区描述
	private String partDescribe;
	//分区号
	private Integer paretNum;
	//颜色
	private Integer color;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartDescribe() {
		return partDescribe;
	}
	public void setPartDescribe(String partDescribe) {
		this.partDescribe = partDescribe;
	}
	public Integer getParetNum() {
		return paretNum;
	}
	public void setParetNum(Integer paretNum) {
		this.paretNum = paretNum;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "RoomPart [id=" + id + ", roomID=" + roomID + ", partName=" + partName + ", partDescribe=" + partDescribe
				+ ", paretNum=" + paretNum + ", color=" + color + "]";
	}
	
	
	
	
}
