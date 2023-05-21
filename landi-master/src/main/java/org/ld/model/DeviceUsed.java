package org.ld.model;

import java.io.Serializable;
/**
 * 活动设备信息表
 * t_deviceused
 * */
public class DeviceUsed implements Serializable {
    //活动设备id
    private Integer duId;
    //设备id
    private Integer duDeviceID;
    //设备名称
    private String devName;
    //设备类型名称
    private String duName;
    //网络地址
    private String duNetIPAddress;
    //接收端口
    private int duNetRecvPort;
    //发送端口
    private int duNetSendPort;
    //串口号
    private int duSerialPortCode;
    //通道起始号
    private int duPassWayStartNum;
    //通道数量
    private int duPassWayCount;
    //通道单元
    private int duPassWayUnit;
    //翻译通道单元
    private int zdPassWayUnit;
    //关联 设备类型
    private Integer devConnType;
    //波特率
    private int duRate;
    //字节位
    private int duBite;
    //奇偶校验(0无1有）
    private int duParitycheck;
    //停止位
    private int duStopBit;
    //系统编号
    private Integer duTypeID;
    //席位单元
    private int duSeatUnitCount;
    //说明
    private String duRemark;
	public Integer getDuId() {
		return duId;
	}
	public void setDuId(Integer duId) {
		this.duId = duId;
	}
	public Integer getDuDeviceID() {
		return duDeviceID;
	}
	public void setDuDeviceID(Integer duDeviceID) {
		this.duDeviceID = duDeviceID;
	}
	public String getDuName() {
		return duName;
	}
	public void setDuName(String duName) {
		this.duName = duName;
	}
	public String getDuNetIPAddress() {
		return duNetIPAddress;
	}
	public void setDuNetIPAddress(String duNetIPAddress) {
		this.duNetIPAddress = duNetIPAddress;
	}
	public int getDuNetRecvPort() {
		return duNetRecvPort;
	}
	public void setDuNetRecvPort(int duNetRecvPort) {
		this.duNetRecvPort = duNetRecvPort;
	}
	public int getDuNetSendPort() {
		return duNetSendPort;
	}
	public void setDuNetSendPort(int duNetSendPort) {
		this.duNetSendPort = duNetSendPort;
	}
	public int getDuSerialPortCode() {
		return duSerialPortCode;
	}
	public void setDuSerialPortCode(int duSerialPortCode) {
		this.duSerialPortCode = duSerialPortCode;
	}
	public int getDuPassWayStartNum() {
		return duPassWayStartNum;
	}
	public void setDuPassWayStartNum(int duPassWayStartNum) {
		this.duPassWayStartNum = duPassWayStartNum;
	}
	public int getDuPassWayCount() {
		return duPassWayCount;
	}
	public void setDuPassWayCount(int duPassWayCount) {
		this.duPassWayCount = duPassWayCount;
	}
	public int getDuPassWayUnit() {
		return duPassWayUnit;
	}
	public void setDuPassWayUnit(int duPassWayUnit) {
		this.duPassWayUnit = duPassWayUnit;
	}
	public int getZdPassWayUnit() {
		return zdPassWayUnit;
	}
	public void setZdPassWayUnit(int zdPassWayUnit) {
		this.zdPassWayUnit = zdPassWayUnit;
	}
	public Integer getDevConnType() {
		return devConnType;
	}
	public void setDevConnType(Integer devConnType) {
		this.devConnType = devConnType;
	}
	public int getDuRate() {
		return duRate;
	}
	public void setDuRate(int duRate) {
		this.duRate = duRate;
	}
	public int getDuBite() {
		return duBite;
	}
	public void setDuBite(int duBite) {
		this.duBite = duBite;
	}
	public int getDuParitycheck() {
		return duParitycheck;
	}
	public void setDuParitycheck(int duParitycheck) {
		this.duParitycheck = duParitycheck;
	}
	public int getDuStopBit() {
		return duStopBit;
	}
	public void setDuStopBit(int duStopBit) {
		this.duStopBit = duStopBit;
	}
	public Integer getDuTypeID() {
		return duTypeID;
	}
	public void setDuTypeID(Integer duTypeID) {
		this.duTypeID = duTypeID;
	}
	public int getDuSeatUnitCount() {
		return duSeatUnitCount;
	}
	public void setDuSeatUnitCount(int duSeatUnitCount) {
		this.duSeatUnitCount = duSeatUnitCount;
	}
	public String getDuRemark() {
		return duRemark;
	}
	public void setDuRemark(String duRemark) {
		this.duRemark = duRemark;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}

}
