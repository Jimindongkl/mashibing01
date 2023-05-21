package org.ld.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：ScreenForm    对应 t_screenform
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年2月25日 下午3:49:31    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年2月25日 下午3:49:31    
 * 修改备注：       
 * @version </pre>
 */
public class ScreenForm implements Serializable{

	private static final long serialVersionUID = -1137796377908483305L;

	//窗体ID
	private Integer id;
	//ScreenID  大屏实体
	private Screen screen;
	//投屏窗体类型ID
	private Integer typeID;
	//投屏窗体名称
	private String sfName;
	//投屏窗体描述
	private String sfDescribe;
	//投屏窗体内容
	private String sfContent;
	//窗体的背景色
	private String sfBgcolor;
	//窗体的背景图路径
	private String sfScreenPath;
	//宽
	private Integer sfWidth;
	//高
	private Integer sfHeight;
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
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getSfName() {
		return sfName;
	}
	public void setSfName(String sfName) {
		this.sfName = sfName;
	}
	public String getSfDescribe() {
		return sfDescribe;
	}
	public void setSfDescribe(String sfDescribe) {
		this.sfDescribe = sfDescribe;
	}
	public String getSfContent() {
		return sfContent;
	}
	public void setSfContent(String sfContent) {
		this.sfContent = sfContent;
	}
	public Integer getSfWidth() {
		return sfWidth;
	}
	public void setSfWidth(Integer sfWidth) {
		this.sfWidth = sfWidth;
	}
	public Integer getSfHeight() {
		return sfHeight;
	}
	public void setSfHeight(Integer sfHeight) {
		this.sfHeight = sfHeight;
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
	public String getSfBgcolor() {
		return sfBgcolor;
	}
	public void setSfBgcolor(String sfBgcolor) {
		this.sfBgcolor = sfBgcolor;
	}
	public String getSfScreenPath() {
		return sfScreenPath;
	}
	public void setSfScreenPath(String sfScreenPath) {
		this.sfScreenPath = sfScreenPath;
	}
	
	
	@Override
	public String toString() {
		return "ScreenForm [id=" + id + ", screen=" + screen + ", typeID=" + typeID + ", sfName=" + sfName
				+ ", sfDescribe=" + sfDescribe + ", sfContent=" + sfContent + ", sfBgcolor=" + sfBgcolor
				+ ", sfScreenPath=" + sfScreenPath + ", sfWidth=" + sfWidth + ", sfHeight=" + sfHeight + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
	
	
	
	
	
}
