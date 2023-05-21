package org.ld.model.fileModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：CongressFile    对应  t_congressfile
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月24日 上午10:42:21    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月24日 上午10:42:21    
 * 修改备注：       
 * @version </pre>
 */
public class CongressFile implements Serializable{

	private static final long serialVersionUID = 6789775293383937490L;

	//附件id
	private Integer id;
	//会议id
	private Integer congressID;
	//议程id
	private Integer agendaID;
	//议题id
	private Integer topicID;
	//附件类型
	private Integer cfType;
	//附件名称
	private String cfName;
	//附件内容
	private String cfContent;
	//附件路径
	private String cfPath;
	//附件图片路径
	private String cfPicPath;
	//真实的文件路径
	private String trueFilePath;
	//附件关键字
	private String cfSource;
	//附件大小
	private float cfSize;
	//附件排序
	private long cfSerial;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//是否为主文件 0 为非  1 为是
	private Integer cfIsEnabled;
	//备注信息
	private String remark;
	//附件类型的名字
	private String typeName;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getTopicID() {
		return topicID;
	}
	public void setTopicID(Integer topicID) {
		this.topicID = topicID;
	}
	public Integer getCfType() {
		return cfType;
	}
	public void setCfType(Integer cfType) {
		this.cfType = cfType;
	}
	public String getCfName() {
		return cfName;
	}
	public void setCfName(String cfName) {
		this.cfName = cfName;
	}
	public String getCfContent() {
		return cfContent;
	}
	public void setCfContent(String cfContent) {
		this.cfContent = cfContent;
	}
	public String getCfPath() {
		return cfPath;
	}
	public void setCfPath(String cfPath) {
		this.cfPath = cfPath;
	}
	public String getCfPicPath() {
		return cfPicPath;
	}
	public void setCfPicPath(String cfPicPath) {
		this.cfPicPath = cfPicPath;
	}
	public String getCfSource() {
		return cfSource;
	}
	public void setCfSource(String cfSource) {
		this.cfSource = cfSource;
	}
	public float getCfSize() {
		return cfSize;
	}
	public void setCfSize(float cfSize) {
		this.cfSize = cfSize;
	}
	public long getCfSerial() {
		return cfSerial;
	}
	public void setCfSerial(long cfSerial) {
		this.cfSerial = cfSerial;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getCfIsEnabled() {
		return cfIsEnabled;
	}
	public void setCfIsEnabled(Integer cfIsEnabled) {
		this.cfIsEnabled = cfIsEnabled;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTrueFilePath() {
		return trueFilePath;
	}
	public void setTrueFilePath(String trueFilePath) {
		this.trueFilePath = trueFilePath;
	}
	
	
	@Override
	public String toString() {
		return "CongressFile [id=" + id + ", congressID=" + congressID + ", agendaID=" + agendaID + ", topicID="
				+ topicID + ", cfType=" + cfType + ", cfName=" + cfName + ", cfContent=" + cfContent + ", cfPath="
				+ cfPath + ", cfPicPath=" + cfPicPath + ", trueFilePath=" + trueFilePath + ", cfSource=" + cfSource
				+ ", cfSize=" + cfSize + ", cfSerial=" + cfSerial + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", cfIsEnabled=" + cfIsEnabled + ", remark=" + remark + ", typeName=" + typeName + "]";
	}
	
	
	
	
}
