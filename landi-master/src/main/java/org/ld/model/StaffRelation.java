package org.ld.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：StaffRelation    
 * 类描述： 人员分类关系   
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年2月17日 下午4:31:42    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年2月17日 下午4:31:42    
 * 修改备注：       
 * @version </pre>
 */
public class StaffRelation implements Serializable{

	private static final long serialVersionUID = 5044416139701226465L;

	//主键
	private Integer id;
	//分类ID
	private Integer sLID;
	//人员ID
	private Integer staffInfoID;
	//备用字段
	private String spare;
	//创建时间
	private Date createTime;
	//备注信息
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getsLID() {
		return sLID;
	}
	public void setsLID(Integer sLID) {
		this.sLID = sLID;
	}
	public Integer getStaffInfoID() {
		return staffInfoID;
	}
	public void setStaffInfoID(Integer staffInfoID) {
		this.staffInfoID = staffInfoID;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
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
	
	
	
}
