package org.ld.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：ScreenFormEvent    对应 t_screenformevent
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年2月26日 下午3:22:21    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年2月26日 下午3:22:21    
 * 修改备注：       
 * @version </pre>
 */
public class ScreenFormEvent implements Serializable{

	private static final long serialVersionUID = -2232987067760476412L;
	
	//事件ID
	private Integer id;
	//大屏
	private Screen screen;
	//大屏id
	private Integer screenId;
	//窗体
	private ScreenForm screenForm;
	//事件的名字
	private String sfeName;
	//基础事件的类型名字
	private String sfeTypeName;
	//事件的描述
	private String sfeDescribe;
	//停留时间 （单位：s）
	private Integer stopTime;
	//跳转事件
	private Integer nextFormID;
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
	public Integer getScreenId() {
		return screenId;
	}
	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}
	public ScreenForm getScreenForm() {
		return screenForm;
	}
	public void setScreenForm(ScreenForm screenForm) {
		this.screenForm = screenForm;
	}
	public String getSfeName() {
		return sfeName;
	}
	public void setSfeName(String sfeName) {
		this.sfeName = sfeName;
	}
	public String getSfeDescribe() {
		return sfeDescribe;
	}
	public void setSfeDescribe(String sfeDescribe) {
		this.sfeDescribe = sfeDescribe;
	}
	public Integer getStopTime() {
		return stopTime;
	}
	public void setStopTime(Integer stopTime) {
		this.stopTime = stopTime;
	}
	public Integer getNextFormID() {
		return nextFormID;
	}
	public void setNextFormID(Integer nextFormID) {
		this.nextFormID = nextFormID;
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
	public String getSfeTypeName() {
		return sfeTypeName;
	}
	public void setSfeTypeName(String sfeTypeName) {
		this.sfeTypeName = sfeTypeName;
	}
	
	
	@Override
	public String toString() {
		return "ScreenFormEvent [id=" + id + ", screen=" + screen + ", screenId=" + screenId + ", screenForm="
				+ screenForm + ", sfeName=" + sfeName + ", sfeTypeName=" + sfeTypeName + ", sfeDescribe=" + sfeDescribe
				+ ", stopTime=" + stopTime + ", nextFormID=" + nextFormID + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
	
	
	
	
	
	
	

}
