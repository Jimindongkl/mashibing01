package org.ld.model;

import java.io.Serializable;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：SeatTheme    坐席小图标
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月6日 上午11:50:10    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月6日 上午11:50:10    
 * 修改备注：       
 * @version </pre>
 */
public class SeatTheme implements Serializable{

	private static final long serialVersionUID = 559409271701539603L;

	//主题套图ID
	private Integer id;
	//分类说明ID
	private Integer sortID;
	//名称
	private String name;
	//描述
	private String describe;
	//图片路径
	private String imagePath;
	//序号
	private Integer ints;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getInts() {
		return ints;
	}
	public void setInts(Integer ints) {
		this.ints = ints;
	}
	
	
	@Override
	public String toString() {
		return "SeatTheme [id=" + id + ", sortID=" + sortID + ", name=" + name + ", describe=" + describe
				+ ", imagePath=" + imagePath + ", ints=" + ints + "]";
	}
	
	
	
	
	
	
}
