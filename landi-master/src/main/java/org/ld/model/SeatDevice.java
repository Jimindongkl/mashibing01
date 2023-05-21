package org.ld.model;

import java.io.Serializable;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：SeatDevice     对应 t_seatdevice
 * 类描述：    坐席和设备的关联表
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月13日 下午3:20:09    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月13日 下午3:20:09    
 * 修改备注：       
 * @version </pre>
 */
public class SeatDevice implements Serializable{

	private static final long serialVersionUID = -8575608312740520831L;
	
	//主键id
	private Integer id;
	//坐席单元
	private Integer seatUnitId;
	//活动设备
	private Integer deviceUsedId;
	//席位单元编码
	private String UnitCode;
	//通道号
	private Integer PassWayCode;
	//中控机地址号
	private Integer CCUAddressCode;
	//扩展通道号
	private Integer OtherPassWayCode;
	//扩展地址号（MAC）
	private Integer OtherAddressCode;
	//摄像头预置位参数
	private String CameraSet;
	//触摸屏配置
	private String TouchScreenSet;
	//IP地址
	private String IPAddress;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeatUnitId() {
		return seatUnitId;
	}
	public void setSeatUnitId(Integer seatUnitId) {
		this.seatUnitId = seatUnitId;
	}
	public Integer getDeviceUsedId() {
		return deviceUsedId;
	}
	public void setDeviceUsedId(Integer deviceUsedId) {
		this.deviceUsedId = deviceUsedId;
	}
	public String getUnitCode() {
		return UnitCode;
	}
	public void setUnitCode(String unitCode) {
		UnitCode = unitCode;
	}
	public Integer getPassWayCode() {
		return PassWayCode;
	}
	public void setPassWayCode(Integer passWayCode) {
		PassWayCode = passWayCode;
	}
	public Integer getCCUAddressCode() {
		return CCUAddressCode;
	}
	public void setCCUAddressCode(Integer cCUAddressCode) {
		CCUAddressCode = cCUAddressCode;
	}
	public Integer getOtherPassWayCode() {
		return OtherPassWayCode;
	}
	public void setOtherPassWayCode(Integer otherPassWayCode) {
		OtherPassWayCode = otherPassWayCode;
	}
	public Integer getOtherAddressCode() {
		return OtherAddressCode;
	}
	public void setOtherAddressCode(Integer otherAddressCode) {
		OtherAddressCode = otherAddressCode;
	}
	public String getCameraSet() {
		return CameraSet;
	}
	public void setCameraSet(String cameraSet) {
		CameraSet = cameraSet;
	}
	public String getTouchScreenSet() {
		return TouchScreenSet;
	}
	public void setTouchScreenSet(String touchScreenSet) {
		TouchScreenSet = touchScreenSet;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	
	
	@Override
	public String toString() {
		return "SeatDevice [id=" + id + ", seatUnitId=" + seatUnitId + ", deviceUsedId=" + deviceUsedId + ", UnitCode="
				+ UnitCode + ", PassWayCode=" + PassWayCode + ", CCUAddressCode=" + CCUAddressCode
				+ ", OtherPassWayCode=" + OtherPassWayCode + ", OtherAddressCode=" + OtherAddressCode + ", CameraSet="
				+ CameraSet + ", TouchScreenSet=" + TouchScreenSet + ", IPAddress=" + IPAddress + "]";
	}
	
	
	
	
	
}
