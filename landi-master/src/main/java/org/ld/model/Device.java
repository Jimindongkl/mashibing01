package org.ld.model;

import java.io.Serializable;
import java.util.Date;

import org.ld.vo.ComboTree;

/**
 * 设备库(t_device)
 * */
public class Device extends ComboTree  implements Serializable {
    private static final long serialVersionUID = 66L;
    //主键id
    private Integer devID;
    //设备名称
    private String devName;
    //通讯类型
    private int devConnType;
    //设备类型
    private String devTypeID;
    //设备名称
    private String devTypeName;
    //网络地址
    private String devNetIPAddress;
    //接收端口
    private int devNetRecvPort;
    //发送端口
    private int devNetSendPort;
    //串口号
    private int devSerialPortCode;
    //通道起始号
    private int devPassWayStartNum;
    //通道数量
    private int devPassWayCount;
    //通道单元
    private int devPassWayUnit;
    //波特率
    private int devRate;
    //字节位
    private int devBite;
    //奇偶校验(0无1有）
    private int devParitycheck;
    //停止位
    private int devStopBit;
    //类文件名称
    private  String  devClassFileName;
    //类名称
    private String  devClassName;
    //类文件
    private String devClassFile;
    //序号
    private  int  devSerial;
    //备注说明
    private String devRemark;
    //创建时间
    private Date devCreateTime;
    //修改时间
    private Date devUpdateTime;

    public String getDevTypeName() {
		return devTypeName;
	}

	public void setDevTypeName(String devTypeName) {
		this.devTypeName = devTypeName;
	}

	public Integer getDevID() {
        return devID;
    }

    public void setDevID(Integer devID) {
        this.devID = devID;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public int getDevConnType() {
        return devConnType;
    }

    public void setDevConnType(int devConnType) {
        this.devConnType = devConnType;
    }

    public String getDevTypeID() {
        return devTypeID;
    }

    public void setDevTypeID(String devTypeID) {
        this.devTypeID = devTypeID;
    }

    public String getDevNetIPAddress() {
        return devNetIPAddress;
    }

    public void setDevNetIPAddress(String devNetIPAddress) {
        this.devNetIPAddress = devNetIPAddress;
    }

    public int getDevNetRecvPort() {
        return devNetRecvPort;
    }

    public void setDevNetRecvPort(int devNetRecvPort) {
        this.devNetRecvPort = devNetRecvPort;
    }

    public int getDevNetSendPort() {
        return devNetSendPort;
    }

    public void setDevNetSendPort(int devNetSendPort) {
        this.devNetSendPort = devNetSendPort;
    }

    public int getDevSerialPortCode() {
        return devSerialPortCode;
    }

    public void setDevSerialPortCode(int devSerialPortCode) {
        this.devSerialPortCode = devSerialPortCode;
    }

    public int getDevPassWayStartNum() {
        return devPassWayStartNum;
    }

    public void setDevPassWayStartNum(int devPassWayStartNum) {
        this.devPassWayStartNum = devPassWayStartNum;
    }

    public int getDevPassWayCount() {
        return devPassWayCount;
    }

    public void setDevPassWayCount(int devPassWayCount) {
        this.devPassWayCount = devPassWayCount;
    }

    public int getDevPassWayUnit() {
        return devPassWayUnit;
    }

    public void setDevPassWayUnit(int devPassWayUnit) {
        this.devPassWayUnit = devPassWayUnit;
    }

    public int getDevRate() {
        return devRate;
    }

    public void setDevRate(int devRate) {
        this.devRate = devRate;
    }

    public int getDevBite() {
        return devBite;
    }

    public void setDevBite(int devBite) {
        this.devBite = devBite;
    }

    public int getDevParitycheck() {
        return devParitycheck;
    }

    public void setDevParitycheck(int devParitycheck) {
        this.devParitycheck = devParitycheck;
    }

    public int getDevStopBit() {
        return devStopBit;
    }

    public void setDevStopBit(int devStopBit) {
        this.devStopBit = devStopBit;
    }

    public String getDevClassFileName() {
        return devClassFileName;
    }

    public void setDevClassFileName(String devClassFileName) {
        this.devClassFileName = devClassFileName;
    }

    public String getDevClassName() {
        return devClassName;
    }

    public void setDevClassName(String devClassName) {
        this.devClassName = devClassName;
    }

    public int getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(int devSerial) {
        this.devSerial = devSerial;
    }

    public String getDevRemark() {
        return devRemark;
    }

    public void setDevRemark(String devRemark) {
        this.devRemark = devRemark;
    }

    public Date getDevCreateTime() {
        return devCreateTime;
    }

    public void setDevCreateTime(Date devCreateTime) {
        this.devCreateTime = devCreateTime;
    }

    public Date getDevUpdateTime() {
        return devUpdateTime;
    }

    public void setDevUpdateTime(Date devUpdateTime) {
        this.devUpdateTime = devUpdateTime;
    }

    public String getDevClassFile() {
        return devClassFile;
    }

    public void setDevClassFile(String devClassFile) {
        this.devClassFile = devClassFile;
    }

    @Override
	public String toString() {
		return "Device [devID=" + devID + ", devName=" + devName + ", devConnType=" + devConnType + ", devTypeID="
				+ devTypeID + ", devTypeName=" + devTypeName + ", devNetIPAddress=" + devNetIPAddress
				+ ", devNetRecvPort=" + devNetRecvPort + ", devNetSendPort=" + devNetSendPort + ", devSerialPortCode="
				+ devSerialPortCode + ", devPassWayStartNum=" + devPassWayStartNum + ", devPassWayCount="
				+ devPassWayCount + ", devPassWayUnit=" + devPassWayUnit + ", devRate=" + devRate + ", devBite="
				+ devBite + ", devParitycheck=" + devParitycheck + ", devStopBit=" + devStopBit + ", devClassFileName="
				+ devClassFileName + ", devClassName=" + devClassName + ", devClassFile=" + devClassFile
				+ ", devSerial=" + devSerial + ", devRemark=" + devRemark + ", devCreateTime=" + devCreateTime
				+ ", devUpdateTime=" + devUpdateTime + "]";
	}
}
