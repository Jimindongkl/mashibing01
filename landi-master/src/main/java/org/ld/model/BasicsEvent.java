package org.ld.model;

import java.io.Serializable;
import java.util.Date;

public class BasicsEvent implements Serializable{

	private static final long serialVersionUID = 4757702935108236850L;

	//基础事件的id
	private Integer id;
	//基础事件的名字
	private String basName;
	//基础事件的描述
	private String basDescribe;
	//基础事件的类型名
	private String basTypeName;
	//基础事件的排序编号
	private Integer serial;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBasName() {
		return basName;
	}
	public void setBasName(String basName) {
		this.basName = basName;
	}
	public String getBasDescribe() {
		return basDescribe;
	}
	public void setBasDescribe(String basDescribe) {
		this.basDescribe = basDescribe;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
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
	public String getBasTypeName() {
		return basTypeName;
	}
	public void setBasTypeName(String basTypeName) {
		this.basTypeName = basTypeName;
	}
	
	
	@Override
	public String toString() {
		return "BasicsEvent [id=" + id + ", basName=" + basName + ", basDescribe=" + basDescribe + ", basTypeName="
				+ basTypeName + ", serial=" + serial + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
	
	
	
	
}
