package org.ld.model.fileModel;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：FileType    会议文件类型  对应 t_FileType
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年4月13日 下午4:45:32    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年4月13日 下午4:45:32    
 * 修改备注：       
 * @version </pre>
 */
public class FileType implements Serializable{

	private static final long serialVersionUID = -7589589358738252614L;

	//主键id
	private Integer fileTypeId;
	//类型的名字
	private String typeName; 
	//编号
	private String num;
	//排序
	private Integer serial;
	//创建时间
	private Date creatTime;
	//修改时间
	private Date updateTime;
	
	
	public Integer getFileTypeId() {
		return fileTypeId;
	}
	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	@Override
	public String toString() {
		return "FileType [fileTypeId=" + fileTypeId + ", typeName=" + typeName + ", num=" + num + ", serial=" + serial
				+ ", creatTime=" + creatTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
}
