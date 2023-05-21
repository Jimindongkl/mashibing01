package org.ld.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Log    日志管理  t_log
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年4月15日 下午3:06:38    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年4月15日 下午3:06:38    
 * 修改备注：       
 * @version </pre>
 */
public class Log implements Serializable{

	private static final long serialVersionUID = -5982540449790590055L;

	//主键id
	private Integer logID;
	//日志类型
	private Integer logTypeID;
	//时间戳
	private Integer logTimestamp;
	//用户的名字
	private String logUserName;
	//日志内容
	private String logCount;
	//登录电脑的id
	private String logIP;
	//日志的排序
	private Integer logSerial;
	//是否可见  1可见  0不可见
	private Integer logIsEnabled;
	//创建时间
	private Date logCreateTime;
	
	
	public Integer getLogID() {
		return logID;
	}
	public void setLogID(Integer logID) {
		this.logID = logID;
	}
	public Integer getLogTypeID() {
		return logTypeID;
	}
	public void setLogTypeID(Integer logTypeID) {
		this.logTypeID = logTypeID;
	}
	public Integer getLogTimestamp() {
		return logTimestamp;
	}
	public void setLogTimestamp(Integer logTimestamp) {
		this.logTimestamp = logTimestamp;
	}
	public String getLogUserName() {
		return logUserName;
	}
	public void setLogUserName(String logUserName) {
		this.logUserName = logUserName;
	}
	public String getLogCount() {
		return logCount;
	}
	public void setLogCount(String logCount) {
		this.logCount = logCount;
	}
	public String getLogIP() {
		return logIP;
	}
	public void setLogIP(String logIP) {
		this.logIP = logIP;
	}
	public Integer getLogSerial() {
		return logSerial;
	}
	public void setLogSerial(Integer logSerial) {
		this.logSerial = logSerial;
	}
	public Integer getLogIsEnabled() {
		return logIsEnabled;
	}
	public void setLogIsEnabled(Integer logIsEnabled) {
		this.logIsEnabled = logIsEnabled;
	}
	public Date getLogCreateTime() {
		return logCreateTime;
	}
	public void setLogCreateTime(Date logCreateTime) {
		this.logCreateTime = logCreateTime;
	}
	
	
	@Override
	public String toString() {
		return "Log [logID=" + logID + ", logTypeID=" + logTypeID + ", logTimestamp=" + logTimestamp + ", logUserName="
				+ logUserName + ", logCount=" + logCount + ", logIP=" + logIP + ", logSerial=" + logSerial
				+ ", logIsEnabled=" + logIsEnabled + ", logCreateTime=" + logCreateTime + "]";
	}
	
	
	
	
}
