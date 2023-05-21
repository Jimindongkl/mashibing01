package org.ld.model;

import java.io.Serializable;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Dictionary    
 * 类描述：  通用字典  
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月9日 下午2:55:54    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月9日 下午2:55:54    
 * 修改备注：       
 * @version </pre>
 */
public class Dictionary implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//类别
	private String sort;
	//名称
	private String dicName;
	//父级id
	private Integer parentID;
	//排序
	private Integer order;
	//备注
	private String describe;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	
	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", sort=" + sort + ", dicName=" + dicName + ", parentID=" + parentID
				+ ", order=" + order + ", describe=" + describe + "]";
	}

	
	
	
	
	

}
