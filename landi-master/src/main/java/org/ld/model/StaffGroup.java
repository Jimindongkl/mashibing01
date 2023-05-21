package org.ld.model;

import java.io.Serializable;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Staffgroup    
 * 类描述：    团组实体
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:44:32    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:44:32    
 * 修改备注：       
 * @version </pre>
 */
public class StaffGroup implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	//主键
	private Integer id;
	//团组名称
	private String groupName;
	//团组编号
	private String groupNum;
	//备注
	private String remarks;
	//排序
	private Integer order;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
	@Override
	public String toString() {
		return "StaffGroup [id=" + id + ", groupName=" + groupName + ", groupNum=" + groupNum + ", remarks=" + remarks
				+ ", order=" + order + "]";
	}
	
	
	
	
	
	
	

}
