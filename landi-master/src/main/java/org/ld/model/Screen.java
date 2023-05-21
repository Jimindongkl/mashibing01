package org.ld.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Screen   对应表  t_screen 
 * 类描述：    大屏
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年2月25日 上午9:47:31    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年2月25日 上午9:47:31    
 * 修改备注：       
 * @version </pre>
 */
public class Screen implements Serializable{

	private static final long serialVersionUID = -852512770273372244L;
	
	//屏幕ID
	private Integer id;
	//屏幕分类ID
	private Integer sortID;
	//屏幕名称
	private String scrName;
	//屏幕描述
	private String scrDescribe;
	//屏幕宽
	private Integer width;
	//屏幕高
	private Integer height;
	//屏幕X坐标
	private Integer xpoint;
	//屏幕Y坐标
	private Integer ypoint;
	//是否显示  0不显示 1显示
	private Integer isEnabled;
	//排序编号
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
	public Integer getSortID() {
		return sortID;
	}
	public void setSortID(Integer sortID) {
		this.sortID = sortID;
	}
	public String getScrName() {
		return scrName;
	}
	public void setScrName(String scrName) {
		this.scrName = scrName;
	}
	public String getScrDescribe() {
		return scrDescribe;
	}
	public void setScrDescribe(String scrDescribe) {
		this.scrDescribe = scrDescribe;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getXpoint() {
		return xpoint;
	}
	public void setXpoint(Integer xpoint) {
		this.xpoint = xpoint;
	}
	public Integer getYpoint() {
		return ypoint;
	}
	public void setYpoint(Integer ypoint) {
		this.ypoint = ypoint;
	}
	public Integer getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
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
	
	
	@Override
	public String toString() {
		return "Screen [id=" + id + ", sortID=" + sortID + ", scrName=" + scrName + ", scrDescribe=" + scrDescribe
				+ ", width=" + width + ", height=" + height + ", xpoint=" + xpoint + ", ypoint=" + ypoint
				+ ", isEnabled=" + isEnabled + ", serial=" + serial + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
	
	
	
	
	

}
