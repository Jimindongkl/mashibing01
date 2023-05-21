package org.ld.model;

import java.io.Serializable;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Staffcategory    
 * 类描述：    人员类别信息实体
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:43:20    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:43:20    
 * 修改备注：       
 * @version </pre>
 */
public class StaffCategory implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	//主键
	private Integer id;
	//类别名称
	private String categoryName;
	//类别编号
	private String categoryNum;
	//报到权
	private Integer reportPower;
	//表决权
	private Integer votePower;
	//发言权
	private Integer speakPower;
	//优先表决权
	private Integer firstSpeakPower;
	//呼叫权
	private Integer callPower;
	//查询权
	private Integer searchPower;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}
	public Integer getReportPower() {
		return reportPower;
	}
	public void setReportPower(Integer reportPower) {
		this.reportPower = reportPower;
	}
	public Integer getVotePower() {
		return votePower;
	}
	public void setVotePower(Integer votePower) {
		this.votePower = votePower;
	}
	public Integer getSpeakPower() {
		return speakPower;
	}
	public void setSpeakPower(Integer speakPower) {
		this.speakPower = speakPower;
	}
	public Integer getFirstSpeakPower() {
		return firstSpeakPower;
	}
	public void setFirstSpeakPower(Integer firstSpeakPower) {
		this.firstSpeakPower = firstSpeakPower;
	}
	public Integer getCallPower() {
		return callPower;
	}
	public void setCallPower(Integer callPower) {
		this.callPower = callPower;
	}
	public Integer getSearchPower() {
		return searchPower;
	}
	public void setSearchPower(Integer searchPower) {
		this.searchPower = searchPower;
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
		return "StaffCategory [id=" + id + ", categoryName=" + categoryName + ", categoryNum=" + categoryNum
				+ ", reportPower=" + reportPower + ", votePower=" + votePower + ", speakPower=" + speakPower
				+ ", firstSpeakPower=" + firstSpeakPower + ", callPower=" + callPower + ", searchPower=" + searchPower
				+ ", remarks=" + remarks + ", order=" + order + "]";
	}
	
	
	
	
	
	
	

}
