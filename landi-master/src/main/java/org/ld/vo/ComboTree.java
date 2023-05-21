package org.ld.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ld.model.fileModel.CongressFile;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：ComboTree    
 * 类描述：    树形实体
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月4日 下午4:43:13    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月4日 下午4:43:13    
 * 修改备注：       
 * @version </pre>
 */
public class ComboTree implements Serializable{

	private static final long serialVersionUID = -5580713903453800164L;

	private Integer id;
	private String text;// 树节点名称
	private String iconCls;// 前面的小图标样式
	private Boolean checked = false;// 是否勾选状态
	private Integer order;//排序
	private Map<String, Object> attributes;// 其他参数
	private List<ComboTree> children = new ArrayList<>();// 子节点
	private String state = "closed";// 是否展开(open,closed)
	private Integer status;
	private String date;
	private String startDate;
	private String endDate;
	private Integer roomId;
	private Integer parentId;
	private String checkInType; //报道方式
	private List<CongressFile> files = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<ComboTree> getChildren() {
		return children;
	}
	public void setChildren(List<ComboTree> children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
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
	public List<CongressFile> getFiles() {
		return files;
	}
	public void setFiles(List<CongressFile> files) {
		this.files = files;
	}
	public String getCheckInType() {
		return checkInType;
	}
	public void setCheckInType(String checkInType) {
		this.checkInType = checkInType;
	}
	
	
	@Override
	public String toString() {
		return "ComboTree [id=" + id + ", text=" + text + ", iconCls=" + iconCls + ", checked=" + checked + ", order="
				+ order + ", attributes=" + attributes + ", children=" + children + ", state=" + state + ", status="
				+ status + ", date=" + date + ", startDate=" + startDate + ", endDate=" + endDate + ", roomId=" + roomId
				+ ", parentId=" + parentId + ", checkInType=" + checkInType + ", files=" + files + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
