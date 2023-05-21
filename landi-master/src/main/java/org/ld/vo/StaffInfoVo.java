package org.ld.vo;

public class StaffInfoVo {
	
	//主键
	private Integer id;
	//名字
	private String name;
	//编号
	private String num;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	
	@Override
	public String toString() {
		return "StaffInfoVo [id=" + id + ", name=" + name + ", num=" + num + "]";
	}
	
	

}
