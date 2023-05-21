package org.ld.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.ld.model.fileModel.CongressFile;

public class PaperlessFile implements Serializable{

	private static final long serialVersionUID = 1119215250943787532L;

	//会议的id
	private Integer congressId;
	//会议的名字
	private String congressName;
	//议程的id
	private Integer agendaId;
	//议程的名字
	private String agendaName;
	//议题的id
	private Integer topicId;
	//议题的名字
	private String  topicName;
	//是否有子议题  大于0 有,等于0没有  
	private Integer topicLower;
	//放文件
	private List<CongressFile> childrenFile = new ArrayList<>();
	//放子议题
	private List<PaperlessFile> sunPaperlessFileList = new ArrayList<>();
	
	
	public Integer getCongressId() {
		return congressId;
	}
	public void setCongressId(Integer congressId) {
		this.congressId = congressId;
	}
	public String getCongressName() {
		return congressName;
	}
	public void setCongressName(String congressName) {
		this.congressName = congressName;
	}
	public Integer getAgendaId() {
		return agendaId;
	}
	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}
	public String getAgendaName() {
		return agendaName;
	}
	public void setAgendaName(String agendaName) {
		this.agendaName = agendaName;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Integer getTopicLower() {
		return topicLower;
	}
	public void setTopicLower(Integer topicLower) {
		this.topicLower = topicLower;
	}
	public List<CongressFile> getChildrenFile() {
		return childrenFile;
	}
	public void setChildrenFile(List<CongressFile> childrenFile) {
		this.childrenFile = childrenFile;
	}
	public List<PaperlessFile> getSunPaperlessFileList() {
		return sunPaperlessFileList;
	}
	public void setSunPaperlessFileList(List<PaperlessFile> sunPaperlessFileList) {
		this.sunPaperlessFileList = sunPaperlessFileList;
	}
	
	
	@Override
	public String toString() {
		return "PaperlessFile [congressId=" + congressId + ", congressName=" + congressName + ", agendaId=" + agendaId
				+ ", agendaName=" + agendaName + ", topicId=" + topicId + ", topicName=" + topicName + ", topicLower="
				+ topicLower + ", childrenFile=" + childrenFile + ", sunPaperlessFileList=" + sunPaperlessFileList
				+ "]";
	}
	
}
