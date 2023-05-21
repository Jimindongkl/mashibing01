package org.ld.model;

import java.io.Serializable;
import java.util.Date;

import org.ld.utils.PageBean;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：StaffInfo    
 * 类描述：    参会人员的基本信息实体
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:45:04    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:45:04    
 * 修改备注：       
 * @version </pre>
 */
public class StaffInfo extends PageBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//名字
	private String name;
	//编号
	private String num;
	// 人员类别实体
	private StaffCategory staffCategory = new StaffCategory();
	// 团组实体
	private StaffGroup staffGroup = new StaffGroup();
	//照片
	private String image;
	//工作单位
	private String workUnit;
	//性别
	private Integer sex;
	//电话
	private String phone;
	//身份证号
	private String cardNum;
	//主卡
	private String viceCardNum;
	//副卡1
	private String viceCardNumA;
	//副卡2
	private String viceCardNumB;
	//民族实体
	private Nation nation = new Nation();
	//党派  通用实体
	private Dictionary dictionary = new Dictionary();
	//职务
	private String job;
	//是否可用	0不可用  1可用
	private Integer enabled;
	//备注
	private String remarks;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updatetime;
	//用户名
	private String account;
	//密码
	private String password;
	//委员号
	private String wynum;
	//排序
	private Integer order;
	//备用字段A
	private String spareA;
	//备用字段B
	private String spareB;
	
	/***********批量增加***************/
	//民族id
	private Integer nationId;
	//党派id
	private Integer dictionaryId;
	//人员类别id
	private Integer staffCategoryId;
	//团组id
	private Integer staffGroupId;
	
	/**********会议控制中需要的字段******************/
	//议程人员id
	private Integer agendaPersonId;
	/**********************************************/
	
	
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
	public StaffCategory getStaffCategory() {
		return staffCategory;
	}
	public void setStaffCategory(StaffCategory staffCategory) {
		this.staffCategory = staffCategory;
	}
	public StaffGroup getStaffGroup() {
		return staffGroup;
	}
	public void setStaffGroup(StaffGroup staffGroup) {
		this.staffGroup = staffGroup;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getViceCardNum() {
		return viceCardNum;
	}
	public void setViceCardNum(String viceCardNum) {
		this.viceCardNum = viceCardNum;
	}
	public String getViceCardNumA() {
		return viceCardNumA;
	}
	public void setViceCardNumA(String viceCardNumA) {
		this.viceCardNumA = viceCardNumA;
	}
	public String getViceCardNumB() {
		return viceCardNumB;
	}
	public void setViceCardNumB(String viceCardNumB) {
		this.viceCardNumB = viceCardNumB;
	}
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public Dictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWynum() {
		return wynum;
	}
	public void setWynum(String wynum) {
		this.wynum = wynum;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getSpareA() {
		return spareA;
	}
	public void setSpareA(String spareA) {
		this.spareA = spareA;
	}
	public String getSpareB() {
		return spareB;
	}
	public void setSpareB(String spareB) {
		this.spareB = spareB;
	}
	public Integer getNationId() {
		return nationId;
	}
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	public Integer getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(Integer dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public Integer getStaffCategoryId() {
		return staffCategoryId;
	}
	public void setStaffCategoryId(Integer staffCategoryId) {
		this.staffCategoryId = staffCategoryId;
	}
	public Integer getStaffGroupId() {
		return staffGroupId;
	}
	public void setStaffGroupId(Integer staffGroupId) {
		this.staffGroupId = staffGroupId;
	}
	public Integer getAgendaPersonId() {
		return agendaPersonId;
	}
	public void setAgendaPersonId(Integer agendaPersonId) {
		this.agendaPersonId = agendaPersonId;
	}
	
	
	@Override
	public String toString() {
		return "StaffInfo [id=" + id + ", name=" + name + ", num=" + num + ", staffCategory=" + staffCategory
				+ ", staffGroup=" + staffGroup + ", image=" + image + ", workUnit=" + workUnit + ", sex=" + sex
				+ ", phone=" + phone + ", cardNum=" + cardNum + ", viceCardNum=" + viceCardNum + ", viceCardNumA="
				+ viceCardNumA + ", viceCardNumB=" + viceCardNumB + ", nation=" + nation + ", dictionary=" + dictionary
				+ ", job=" + job + ", enabled=" + enabled + ", remarks=" + remarks + ", createTime=" + createTime
				+ ", updatetime=" + updatetime + ", account=" + account + ", password=" + password + ", wynum=" + wynum
				+ ", order=" + order + ", spareA=" + spareA + ", spareB=" + spareB + ", nationId=" + nationId
				+ ", dictionaryId=" + dictionaryId + ", staffCategoryId=" + staffCategoryId + ", staffGroupId="
				+ staffGroupId + ", agendaPersonId=" + agendaPersonId + "]";
	}
	
	
	
	

}
