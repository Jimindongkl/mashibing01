package org.ld.vo;

import com.alibaba.fastjson.annotation.JSONField;

public class SeatUnitVo {
	
	//主键id
	private Integer id;
	//名字
	private String name;
	//用户名字
	private String userName;
	//x 坐标
	private double x;
	//y 坐标
	private double y;
	//z 坐标
	private double z;
	//角度
	private double degree;
	//高
	@JSONField(name = "Height")
	private Integer Height;
	//宽
	@JSONField(name = "Width")
	private Integer Width;
	//行号
	private Integer rowId;
	//列号
	private Integer columnId;
	//类型
	private String type;
	//无纸化IP地址
    private String suAddressIP;
    //备用IP地址
    private String suHostAddressIP;
    //主持屏IP地址
    private String suSpareAddressIP;
    //设备Id
    private Integer suDeviceId;
    //席位单元编码
    private Integer suUnitCode;
    //状态
    private Integer suState;
    //方向 null或0为 向北  1为东北 2向东 3向东南
    private Integer suSerial;
    //分区Id
    private Integer suRoomPartId;
    //分区名称
    private String suRoomPartName;
    //文字内容
    private String suContent;
    //控制类型   0  座位   1 文本
    private Integer suControlType;
    //
    private String suSpare;
    //
    private Integer suAgendaPersonId;
    //坐席图Id
    private Integer suSeatModelId;
    
    
    
    
    
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double getDegree() {
		return degree;
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}
	@JSONField(name = "Height")
	public Integer getHeight() {
		return Height;
	}
	@JSONField(name = "Height")
	public void setHeight(Integer Height) {
		this.Height = Height;
	}
	@JSONField(name = "Width")
	public Integer getWidth() {
		return Width;
	}
	@JSONField(name = "Width")
	public void setWidth(Integer Width) {
		this.Width = Width;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Integer getSuSeatModelId() {
		return suSeatModelId;
	}
	public void setSuSeatModelId(Integer suSeatModelId) {
		this.suSeatModelId = suSeatModelId;
	}
	
	
	@Override
	public String toString() {
		return "SeatUnitVo [id=" + id + ", name=" + name + ", userName=" + userName + ", x=" + x + ", y=" + y + ", z="
				+ z + ", degree=" + degree + ", Height=" + Height + ", Width=" + Width + ", rowId=" + rowId
				+ ", columnId=" + columnId + ", type=" + type + ", suAddressIP=" + suAddressIP + ", suHostAddressIP="
				+ suHostAddressIP + ", suSpareAddressIP=" + suSpareAddressIP + ", suDeviceId=" + suDeviceId
				+ ", suUnitCode=" + suUnitCode + ", suState=" + suState + ", suSerial=" + suSerial + ", suRoomPartId="
				+ suRoomPartId + ", suRoomPartName=" + suRoomPartName + ", suContent=" + suContent + ", suControlType="
				+ suControlType + ", suSpare=" + suSpare + ", suAgendaPersonId=" + suAgendaPersonId + ", suSeatModelId="
				+ suSeatModelId + "]";
	}
	
	
	
	
	
	
    
    
    

}
