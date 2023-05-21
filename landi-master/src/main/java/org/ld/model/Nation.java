package org.ld.model;

import java.io.Serializable;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Nation    
 * 类描述：    民族字典
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月9日 下午2:49:21    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月9日 下午2:49:21    
 * 修改备注：       
 * @version </pre>
 */
public class Nation implements Serializable{

	private static final long serialVersionUID = 1L;

	//主键
	private Integer id;
	//民族的名称
	private String nationName;
	//民族的编号
	private Integer nationValue;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public Integer getNationValue() {
		return nationValue;
	}
	public void setNationValue(Integer nationValue) {
		this.nationValue = nationValue;
	}
	
	
	@Override
	public String toString() {
		return "Nation [id=" + id + ", nationName=" + nationName + ", nationValue=" + nationValue + "]";
	}
	
	
	
	
}
