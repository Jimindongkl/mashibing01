package org.ld.model;

import java.io.Serializable;

/**
 * 坐席单元表
 * t_seatunit
 * */
public class SeatUnit implements Serializable {
	
    private static final long serialVersionUID = -8921601114151100922L;
    
	//座位Id-------id
    private Integer suId;
    //坐席图Id-------suSeatModelId*********************另传
    private Integer suSeatModelId;
    //设备Id
    private Integer suDeviceId;
    //席位单元编码
    private Integer suUnitCode;
    //席位名称----------name
    private String suName;
    //行号-------------rowId
    private Integer suRow;
    //列号------------columnId
    private Integer suColumn;
    //X坐标-------------X
    private double suXpoint;
    //Y坐标-------------Y
    private double suYpoint;
    /**************应前端需求增加的字段****start****/
    //Z坐标-------------Z
    private double suZpoint;
    //角度
    private double angle;
    //用户名----------userName
    private String userName;
    //类型
    private String type;
    /***********************************end****/
    //状态
    private Integer suState;
    //方向 null或0为 向北  1为东北 2向东 3向东南
    private Integer suSerial;
    //宽---------------Width
    private Integer suWidth;
    //高---------------Heigh
    private Integer suHeight;
    //分区Id
    private Integer suRoomPartId;
    //分区名称
    private String suRoomPartName;
    //无纸化IP地址
    private String suAddressIP;
    //备用IP地址
    private String suHostAddressIP;
    //主持屏IP地址
    private String suSpareAddressIP;
    //文字内容
    private String suContent;
    //控制类型   0  座位   1 文本
    private Integer suControlType;
    //
    private String suContentStyle;
    //
    private String suSpare;
    //
    private Integer suAgendaPersonId;
    
    
	public Integer getSuId() {
		return suId;
	}
	public void setSuId(Integer suId) {
		this.suId = suId;
	}
	public Integer getSuSeatModelId() {
		return suSeatModelId;
	}
	public void setSuSeatModelId(Integer suSeatModelId) {
		this.suSeatModelId = suSeatModelId;
	}
	public Integer getSuDeviceId() {
		return suDeviceId;
	}
	public void setSuDeviceId(Integer suDeviceId) {
		this.suDeviceId = suDeviceId;
	}
	public Integer getSuUnitCode() {
		return suUnitCode;
	}
	public void setSuUnitCode(Integer suUnitCode) {
		this.suUnitCode = suUnitCode;
	}
	public String getSuName() {
		return suName;
	}
	public void setSuName(String suName) {
		this.suName = suName;
	}
	public Integer getSuRow() {
		return suRow;
	}
	public void setSuRow(Integer suRow) {
		this.suRow = suRow;
	}
	public Integer getSuColumn() {
		return suColumn;
	}
	public void setSuColumn(Integer suColumn) {
		this.suColumn = suColumn;
	}
	public double getSuXpoint() {
		return suXpoint;
	}
	public void setSuXpoint(double suXpoint) {
		this.suXpoint = suXpoint;
	}
	public double getSuYpoint() {
		return suYpoint;
	}
	public void setSuYpoint(double suYpoint) {
		this.suYpoint = suYpoint;
	}
	public double getSuZpoint() {
		return suZpoint;
	}
	public void setSuZpoint(double suZpoint) {
		this.suZpoint = suZpoint;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSuState() {
		return suState;
	}
	public void setSuState(Integer suState) {
		this.suState = suState;
	}
	public Integer getSuSerial() {
		return suSerial;
	}
	public void setSuSerial(Integer suSerial) {
		this.suSerial = suSerial;
	}
	public Integer getSuWidth() {
		return suWidth;
	}
	public void setSuWidth(Integer suWidth) {
		this.suWidth = suWidth;
	}
	public Integer getSuHeight() {
		return suHeight;
	}
	public void setSuHeight(Integer suHeight) {
		this.suHeight = suHeight;
	}
	public Integer getSuRoomPartId() {
		return suRoomPartId;
	}
	public void setSuRoomPartId(Integer suRoomPartId) {
		this.suRoomPartId = suRoomPartId;
	}
	public String getSuRoomPartName() {
		return suRoomPartName;
	}
	public void setSuRoomPartName(String suRoomPartName) {
		this.suRoomPartName = suRoomPartName;
	}
	public String getSuAddressIP() {
		return suAddressIP;
	}
	public void setSuAddressIP(String suAddressIP) {
		this.suAddressIP = suAddressIP;
	}
	public String getSuHostAddressIP() {
		return suHostAddressIP;
	}
	public void setSuHostAddressIP(String suHostAddressIP) {
		this.suHostAddressIP = suHostAddressIP;
	}
	public String getSuSpareAddressIP() {
		return suSpareAddressIP;
	}
	public void setSuSpareAddressIP(String suSpareAddressIP) {
		this.suSpareAddressIP = suSpareAddressIP;
	}
	public String getSuContent() {
		return suContent;
	}
	public void setSuContent(String suContent) {
		this.suContent = suContent;
	}
	public Integer getSuControlType() {
		return suControlType;
	}
	public void setSuControlType(Integer suControlType) {
		this.suControlType = suControlType;
	}
	public String getSuContentStyle() {
		return suContentStyle;
	}
	public void setSuContentStyle(String suContentStyle) {
		this.suContentStyle = suContentStyle;
	}
	public String getSuSpare() {
		return suSpare;
	}
	public void setSuSpare(String suSpare) {
		this.suSpare = suSpare;
	}
	public Integer getSuAgendaPersonId() {
		return suAgendaPersonId;
	}
	public void setSuAgendaPersonId(Integer suAgendaPersonId) {
		this.suAgendaPersonId = suAgendaPersonId;
	}
	
	
	@Override
	public String toString() {
		return "SeatUnit [suId=" + suId + ", suSeatModelId=" + suSeatModelId + ", suDeviceId=" + suDeviceId
				+ ", suUnitCode=" + suUnitCode + ", suName=" + suName + ", suRow=" + suRow + ", suColumn=" + suColumn
				+ ", suXpoint=" + suXpoint + ", suYpoint=" + suYpoint + ", suZpoint=" + suZpoint + ", angle=" + angle
				+ ", userName=" + userName + ", type=" + type + ", suState=" + suState + ", suSerial=" + suSerial
				+ ", suWidth=" + suWidth + ", suHeight=" + suHeight + ", suRoomPartId=" + suRoomPartId
				+ ", suRoomPartName=" + suRoomPartName + ", suAddressIP=" + suAddressIP + ", suHostAddressIP="
				+ suHostAddressIP + ", suSpareAddressIP=" + suSpareAddressIP + ", suContent=" + suContent
				+ ", suControlType=" + suControlType + ", suContentStyle=" + suContentStyle + ", suSpare=" + suSpare
				+ ", suAgendaPersonId=" + suAgendaPersonId + "]";
	}
  
    
}
