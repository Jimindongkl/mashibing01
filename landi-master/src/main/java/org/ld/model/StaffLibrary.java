package org.ld.model;

import java.io.Serializable;
import java.util.Date;

public class StaffLibrary implements Serializable{

	private static final long serialVersionUID = -4698433440055230926L;

	//人员分类的主键
	private Integer id;
	//分类名称
	private String staffLibraryName;
	//父节点
	private Integer parentID = 0;
	//创建时间
	private Date createTime;
	//备注信息
	private String remark;
	//备用字段
	private String spare;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStaffLibraryName() {
		return staffLibraryName;
	}
	public void setStaffLibraryName(String staffLibraryName) {
		this.staffLibraryName = staffLibraryName;
	}
	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "StaffLibrary [id=" + id + ", staffLibraryName=" + staffLibraryName + ", parentID=" + parentID
				+ ", createTime=" + createTime + ", remark=" + remark + ", spare=" + spare + "]";
	}
	

	
	
	
	
	
	
	
}
