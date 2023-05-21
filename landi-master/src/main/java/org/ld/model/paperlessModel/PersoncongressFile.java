package org.ld.model.paperlessModel;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：PersoncongressFile    对应 t_personcongressfile
 * 类描述：    手写批注
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年9月2日 下午2:32:14    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年9月2日 下午2:32:14    
 * 修改备注：       
 * @version </pre>
 */
public class PersoncongressFile implements Serializable{

	private static final long serialVersionUID = 514076266151472017L;
	
	//主键id
	private Integer pFID;
	//会议id
	private Integer congressID;
	//议程id
	private Integer agendaID;
	//议题id
	private Integer topicID;
	//文件id
	private Integer fileID;
	//人员id
	private Integer staffID;
	//文件路径
	private String filePath;
	//批注文件路径
	private String picPath;
	//x轴
	private double x;
	//y轴
	private double y;
	//页码
	private Integer pageNum;	
	//字体颜色
	private String fontColor;
	//粗细
	private String fontWeight;
	//坐标点
	private String listArr;
	//伪ID
	private String falseID;
	//创建时间
	private Date  createTime;
	//备注
	private String  remark;
	
	
	public Integer getpFID() {
		return pFID;
	}
	public void setpFID(Integer pFID) {
		this.pFID = pFID;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
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
	public String getListArr() {
		return listArr;
	}
	public void setListArr(String listArr) {
		this.listArr = listArr;
	}
	public String getFalseID() {
		return falseID;
	}
	public void setFalseID(String falseID) {
		this.falseID = falseID;
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
	
	
	@Override
	public String toString() {
		return "PersoncongressFile [pFID=" + pFID + ", congressID=" + congressID + ", agendaID=" + agendaID
				+ ", topicID=" + topicID + ", fileID=" + fileID + ", staffID=" + staffID + ", filePath=" + filePath
				+ ", picPath=" + picPath + ", x=" + x + ", y=" + y + ", pageNum=" + pageNum + ", fontColor=" + fontColor
				+ ", fontWeight=" + fontWeight + ", listArr=" + listArr + ", falseID=" + falseID + ", createTime="
				+ createTime + ", remark=" + remark + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
