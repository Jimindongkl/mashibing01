package org.ld.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Memu    
 * 类描述：    菜单实体类
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:43:02    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:43:02    
 * 修改备注：       
 * @version </pre>
 */
public class Memu implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//父级Id
	private Integer parentID;
	//模块名字
	private String blockName;
	//顺序
	private Integer serial;
	//编码
	private Integer code;
	//版本号
	private Integer version;
	//备注
	private String remark;
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
	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
		return "Block [id=" + id + ", parentID=" + parentID + ", blockName=" + blockName + ", serial=" + serial
				+ ", code=" + code + ", version=" + version + ", remark=" + remark + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
	
	
}
