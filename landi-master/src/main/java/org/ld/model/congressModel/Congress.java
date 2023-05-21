package org.ld.model.congressModel;

import java.io.Serializable;
import java.util.Date;

import org.ld.model.Room;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Congress    对应 t_Congress
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年2月28日 上午11:51:58    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年2月28日 上午11:51:58    
 * 修改备注：       
 * @version </pre>
 */
public class Congress implements Serializable{

	private static final long serialVersionUID = -7145637014632377323L;
	
	//会议主键
	private Integer id;
	//会议类型
	private Integer typeID;
	//会议名称
	private String congressName;
	//会议主题
	private String subject;
	//会议室
	private Room room;
	//会议状态  0未召开 1正在召开 2 已经召开
	private Integer status;
	//开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	//结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	//自动开始    单位分钟，提前开始时间
	private Integer AheadTime;
	//开始报到时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkInStartTime;
	//结束报到时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkInEndTime;
	//报到方式 :
	//38 按键报到 
	//2f864f41278640c2b582c78f60bfb77f 刷卡报到 
	//33 报道门 646ab471147f4625bf78ad564faf6b8a发言报到 
	//822a2e9af3a545f2aaf658c61354f7d1 唤醒报到
	private  Integer checkInType;
	//报道方式
	private String dicName;
	//就坐方式   43自由就坐  44指定就坐
	private Integer seatMode;
	//是否自动开始 	0不 1自动开始
	private Integer autoRun;
	//是否自动结束 0不 1自动结束
	private Integer autoClose;
	//修改时间
	private Date updateTime;
	//创建时间
	private Date createTime;
	//创建人ID
	private Integer creatorID;
	//主办单位
	private String hostUnit;
	//排序
	private Integer serial;
	//是否归档  0没有归档 1归档
	private Integer  isFile;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getCongressName() {
		return congressName;
	}
	public void setCongressName(String congressName) {
		this.congressName = congressName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getAheadTime() {
		return AheadTime;
	}
	public void setAheadTime(Integer aheadTime) {
		AheadTime = aheadTime;
	}
	public Date getCheckInStartTime() {
		return checkInStartTime;
	}
	public void setCheckInStartTime(Date checkInStartTime) {
		this.checkInStartTime = checkInStartTime;
	}
	public Date getCheckInEndTime() {
		return checkInEndTime;
	}
	public void setCheckInEndTime(Date checkInEndTime) {
		this.checkInEndTime = checkInEndTime;
	}
	public Integer getCheckInType() {
		return checkInType;
	}
	public void setCheckInType(Integer checkInType) {
		this.checkInType = checkInType;
	}
	public Integer getSeatMode() {
		return seatMode;
	}
	public void setSeatMode(Integer seatMode) {
		this.seatMode = seatMode;
	}
	public Integer getAutoRun() {
		return autoRun;
	}
	public void setAutoRun(Integer autoRun) {
		this.autoRun = autoRun;
	}
	public Integer getAutoClose() {
		return autoClose;
	}
	public void setAutoClose(Integer autoClose) {
		this.autoClose = autoClose;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreatorID() {
		return creatorID;
	}
	public void setCreatorID(Integer creatorID) {
		this.creatorID = creatorID;
	}
	public String getHostUnit() {
		return hostUnit;
	}
	public void setHostUnit(String hostUnit) {
		this.hostUnit = hostUnit;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public Integer getIsFile() {
		return isFile;
	}
	public void setIsFile(Integer isFile) {
		this.isFile = isFile;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	
	
	@Override
	public String toString() {
		return "Congress [id=" + id + ", typeID=" + typeID + ", congressName=" + congressName + ", subject=" + subject
				+ ", room=" + room + ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", AheadTime=" + AheadTime + ", checkInStartTime=" + checkInStartTime + ", checkInEndTime="
				+ checkInEndTime + ", checkInType=" + checkInType + ", dicName=" + dicName + ", seatMode=" + seatMode
				+ ", autoRun=" + autoRun + ", autoClose=" + autoClose + ", updateTime=" + updateTime + ", createTime="
				+ createTime + ", creatorID=" + creatorID + ", hostUnit=" + hostUnit + ", serial=" + serial
				+ ", isFile=" + isFile + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
