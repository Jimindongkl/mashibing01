package org.ld.poi;

import java.io.Serializable;

public class StaffInfoPoi implements Serializable {

	private static final long serialVersionUID = 2803319993127510274L;
	// 编号 姓名 性别 人员类别 团组 电话 工作单位 职务
	// 民族 党派 身份证号 备注信息

	// 编号
	private String num;
	// 名字
	private String name;
	// 性别
	private String sex;
	// 人员类别
	private String staffCategoryName;
	// 团组
	private String staffGroupName;
	// 电话
	private String phone;
	// 工作单位
	private String workUnit;
	// 职务
	private String job;
	// 民族
	private String nationName;
	// 党派
	private String dpName;
	// 身份证号
	private String cardNum;
	// 备注
	private String remarks;

	public StaffInfoPoi(Object[] values) {
		// 编号 姓名 性别 人员类别 团组 电话 工作单位 职务
		// 民族 党派 身份证号 备注信息
		this.num = values[0].toString();
		this.name = values[1].toString();
		this.sex = values[2].toString();
		this.staffCategoryName = values[3].toString();
		this.staffGroupName = values[4].toString();
		this.phone = values[5].toString();
		this.workUnit = values[6].toString();
		this.job = values[7].toString();
		this.nationName = values[8].toString();
		this.dpName = values[9].toString();
		this.cardNum = values[10].toString();
		this.remarks = values[11].toString();
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStaffCategoryName() {
		return staffCategoryName;
	}

	public void setStaffCategoryName(String staffCategoryName) {
		this.staffCategoryName = staffCategoryName;
	}

	public String getStaffGroupName() {
		return staffGroupName;
	}

	public void setStaffGroupName(String staffGroupName) {
		this.staffGroupName = staffGroupName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	@Override
	public String toString() {
		return "StaffInfoPoi [num=" + num + ", name=" + name + ", sex=" + sex + ", staffCategoryName="
				+ staffCategoryName + ", staffGroupName=" + staffGroupName + ", phone=" + phone + ", workUnit="
				+ workUnit + ", job=" + job + ", nationName=" + nationName + ", dpName=" + dpName + ", cardNum="
				+ cardNum + ", remarks=" + remarks + "]";
	}
	
	

}
