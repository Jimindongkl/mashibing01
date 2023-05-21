package org.ld.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：SeatModel    对应t_seatmodel
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月9日 上午9:16:40    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月9日 上午9:16:40    
 * 修改备注：       
 * @version </pre>
 */
public class SeatModel implements Serializable{
	private static final long serialVersionUID = -1529100806282649962L;

	//坐席模板ID
	private Integer id;
	//模板名称
	private String modelName; 
	//会场
	private Room room;  
	//席位图标主题套图
	private SeatTheme seatTheme;
	//宽度
	private Integer width; 
	//高度
	private Integer height;
	//行
	private Integer row;
	//列
	private Integer column;
	//XML模板文件
	private String fileXML;
	//背景图片
	private String background;
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
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public SeatTheme getSeatTheme() {
		return seatTheme;
	}
	public void setSeatTheme(SeatTheme seatTheme) {
		this.seatTheme = seatTheme;
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
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public String getFileXML() {
		return fileXML;
	}
	public void setFileXML(String fileXML) {
		this.fileXML = fileXML;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
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
		return "SeatModel [id=" + id + ", modelName=" + modelName + ", room=" + room + ", seatTheme=" + seatTheme
				+ ", width=" + width + ", height=" + height + ", row=" + row + ", column=" + column + ", fileXML="
				+ fileXML + ", background=" + background + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
}
