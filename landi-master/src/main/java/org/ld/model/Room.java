package org.ld.model;

import java.io.Serializable;

import org.ld.utils.PageBean;

public class Room extends PageBean implements Serializable{

	private static final long serialVersionUID = -4084416550327343226L;

	//会场id
	private Integer id;
	//会场名称
	private String roomName;
	//会场地址
	private String address;
	//容纳人数
	private Integer contain;
	//联系人
	private String linkman;
	//联系电话
	private String phone;
	//坐席图
	private String seatGraph;
	//中控机IP
	private String centerControlIP;
	//投影IP
	private String projectiveIP;
	//文件服务IP
	private String fileTransportIP;
	//会务服务IP
	private String serviceIP;
	//坐席模板信息
	private SeatModel seatModel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getContain() {
		return contain;
	}
	public void setContain(Integer contain) {
		this.contain = contain;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSeatGraph() {
		return seatGraph;
	}
	public void setSeatGraph(String seatGraph) {
		this.seatGraph = seatGraph;
	}
	public String getCenterControlIP() {
		return centerControlIP;
	}
	public void setCenterControlIP(String centerControlIP) {
		this.centerControlIP = centerControlIP;
	}
	public String getProjectiveIP() {
		return projectiveIP;
	}
	public void setProjectiveIP(String projectiveIP) {
		this.projectiveIP = projectiveIP;
	}
	public String getFileTransportIP() {
		return fileTransportIP;
	}
	public void setFileTransportIP(String fileTransportIP) {
		this.fileTransportIP = fileTransportIP;
	}
	public String getServiceIP() {
		return serviceIP;
	}
	public void setServiceIP(String serviceIP) {
		this.serviceIP = serviceIP;
	}
	public SeatModel getSeatModel() {
		return seatModel;
	}
	public void setSeatModel(SeatModel seatModel) {
		this.seatModel = seatModel;
	}
	
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", address=" + address + ", contain=" + contain
				+ ", linkman=" + linkman + ", phone=" + phone + ", seatGraph=" + seatGraph + ", centerControlIP="
				+ centerControlIP + ", projectiveIP=" + projectiveIP + ", fileTransportIP=" + fileTransportIP
				+ ", serviceIP=" + serviceIP + ", seatModel=" + seatModel + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
