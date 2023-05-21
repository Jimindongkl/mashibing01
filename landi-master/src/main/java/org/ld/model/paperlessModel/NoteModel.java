package org.ld.model.paperlessModel;

import java.io.Serializable;
import java.util.Date;

public class NoteModel implements Serializable{

	private static final long serialVersionUID = 2152586696983641669L;
	
	//主键id
	private Integer nTId;
	//文件id
	private Integer fileId;
	//会议id
	private Integer congressID;
	//议程id
	private Integer  agendaID;
	//人员id
	private Integer staffID;
	//会议的名字
	private String meetingName;
	//议程的名字
	private String topicName;
	//议程的时间
	private String topicTimeStr;
	//笔记本的名字
	private String nTName;
	//内容
	private String nTContent;
	//文件路径(暂时不用)
	private String nTFilePath;
	//文件类别 (暂时不用)
	private Integer ntFileType;
	//文件图片路径(暂时不用)
	private String nTFilePicPath;
	//创建时间
	private Date createTime;
	//备注
	private String remark;
	
	
	public Integer getnTId() {
		return nTId;
	}
	public void setnTId(Integer nTId) {
		this.nTId = nTId;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Integer getCongressID() {
		return congressID;
	}
	public void setCongressID(Integer congressID) {
		this.congressID = congressID;
	}
	public Integer getAgendaID() {
		return agendaID;
	}
	public void setAgendaID(Integer agendaID) {
		this.agendaID = agendaID;
	}
	public Integer getStaffID() {
		return staffID;
	}
	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicTimeStr() {
		return topicTimeStr;
	}
	public void setTopicTimeStr(String topicTimeStr) {
		this.topicTimeStr = topicTimeStr;
	}
	public String getnTName() {
		return nTName;
	}
	public void setnTName(String nTName) {
		this.nTName = nTName;
	}
	public String getnTContent() {
		return nTContent;
	}
	public void setnTContent(String nTContent) {
		this.nTContent = nTContent;
	}
	public String getnTFilePath() {
		return nTFilePath;
	}
	public void setnTFilePath(String nTFilePath) {
		this.nTFilePath = nTFilePath;
	}
	public Integer getNtFileType() {
		return ntFileType;
	}
	public void setNtFileType(Integer ntFileType) {
		this.ntFileType = ntFileType;
	}
	public String getnTFilePicPath() {
		return nTFilePicPath;
	}
	public void setnTFilePicPath(String nTFilePicPath) {
		this.nTFilePicPath = nTFilePicPath;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "NoteModel [nTId=" + nTId + ", fileId=" + fileId + ", congressID=" + congressID + ", agendaID="
				+ agendaID + ", staffID=" + staffID + ", meetingName=" + meetingName + ", topicName=" + topicName
				+ ", topicTimeStr=" + topicTimeStr + ", nTName=" + nTName + ", nTContent=" + nTContent + ", nTFilePath="
				+ nTFilePath + ", ntFileType=" + ntFileType + ", nTFilePicPath=" + nTFilePicPath + ", createTime="
				+ createTime + ", remark=" + remark + "]";
	}
	
	
	
	
	
	
	
		
}
