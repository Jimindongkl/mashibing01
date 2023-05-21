package org.ld.model.paperlessModel;

import java.io.Serializable;
import java.util.Date;

import org.apache.poi.ss.formula.eval.BlankEval;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：PersoncongressText     对应  t_personcongressText
 * 类描述：    文字批注
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年9月1日 下午2:29:15    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年9月1日 下午2:29:15    
 * 修改备注：       
 * @version </pre>
 */
public class PersoncongressText implements Serializable{

	private static final long serialVersionUID = -415022005142587017L;
	
	//主键id
	private Integer pPID;
	//会议id
	private Integer congressID;
	//日程id
	private Integer agendaID;
	//议题id
	private Integer topicID;
	//文件id
	private Integer fileID;
	//人员id
	private Integer staffID;
	//打开状态
	private boolean isOpen;
	//手写批注内容
	private String text;
	//x坐标
	private double x;
	//y坐标
	private double y;
	//字体大小
	private Integer fontSize;
	//页码
	private Integer pageNum;
	//字体颜色
	private String fontColor;
	//字体粗细
	private String fontWeight;
	//行数
	private Integer lineAmount;
	//伪ID
	private String falseID;
	//修改时间
	private Date updateTime;
	//创建时间
	private Date createTime;
	//备注
	private String remark;
	
	
	public Integer getpPID() {
		return pPID;
	}
	public void setpPID(Integer pPID) {
		this.pPID = pPID;
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
	public Integer getFileID() {
		return fileID;
	}
	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}
	public Integer getStaffID() {
		return staffID;
	}
	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Integer getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	public String getFontWeight() {
		return fontWeight;
	}
	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}
	public Integer getLineAmount() {
		return lineAmount;
	}
	public void setLineAmount(Integer lineAmount) {
		this.lineAmount = lineAmount;
	}
	public String getFalseID() {
		return falseID;
	}
	public void setFalseID(String falseID) {
		this.falseID = falseID;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	
	@Override
	public String toString() {
		return "PersoncongressText [pPID=" + pPID + ", congressID=" + congressID + ", agendaID=" + agendaID
				+ ", topicID=" + topicID + ", fileID=" + fileID + ", staffID=" + staffID + ", isOpen=" + isOpen
				+ ", text=" + text + ", x=" + x + ", y=" + y + ", fontSize=" + fontSize + ", pageNum=" + pageNum
				+ ", fontColor=" + fontColor + ", fontWeight=" + fontWeight + ", lineAmount=" + lineAmount
				+ ", falseID=" + falseID + ", updateTime=" + updateTime + ", createTime=" + createTime + ", remark="
				+ remark + "]";
	}
	
	
	
	
	
	
	
	
	
}
