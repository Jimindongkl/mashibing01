package org.ld.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ld.model.fileModel.CongressFile;

public class ComboTreeController implements Serializable{
	
	
	private static final long serialVersionUID = -42947415149849578L;
	
	
	private Integer key;
	private String title;// 树节点名称
	private String iconCls;// 前面的小图标样式
	private Boolean checked = false;// 是否勾选状态
	private Integer order;//排序
	private Map<String, Object> attributes;// 其他参数
	private List<ComboTreeController> children = new ArrayList<>();// 子节点
	private String state = "closed";// 是否展开(open,closed)
	private Integer status;
	private String date;
	private String startDate;
	private String endDate;
	private Integer roomId;
	private Integer parentId;
	private String checkInType; //报道方式
	private List<CongressFile> files = new ArrayList<>();
	
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<ComboTreeController> getChildren() {
		return children;
	}
	public void setChildren(List<ComboTreeController> children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getCheckInType() {
		return checkInType;
	}
	public void setCheckInType(String checkInType) {
		this.checkInType = checkInType;
	}
	public List<CongressFile> getFiles() {
		return files;
	}
	public void setFiles(List<CongressFile> files) {
		this.files = files;
	}
	
	
	@Override
	public String toString() {
		return "ComboTreeController [key=" + key + ", title=" + title + ", iconCls=" + iconCls + ", checked=" + checked
				+ ", order=" + order + ", attributes=" + attributes + ", children=" + children + ", state=" + state
				+ ", status=" + status + ", date=" + date + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", roomId=" + roomId + ", parentId=" + parentId + ", checkInType=" + checkInType + ", files=" + files
				+ "]";
	}
	
	
	
	
	
	

}
