package org.ld.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：User    
 * 类描述：    登录实体-----测试用
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:45:35    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:45:35    
 * 修改备注：       
 * @version </pre>
 */
public class User implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	
	//主键id
	private Integer id;
	//用户名
    private String userName;
    //密码
    private String password;
    //真实名字
    private String trueName;
    //性别
  	private String sex;
  	//邮箱
  	private String email;
  	//用户组
  	private Integer groupId;
    //部门
    private Integer departId;
    //角色
    private Integer roleId;
    //是否禁止登录 1是 0否
    private Integer isDisabled;
    //登录次数
    private Integer loginNumbers;
    //上次登录时间
    private Date lastLoginTime;
    //上次修改密码的时间
    private Date laseModPwdTime;
    //是否删除的标识 1删除  0未删除
    private Integer isDeleted;
    //创建用户ID
    private Integer createUserId;
    //创建时间
    private Date createTime;
    //修改用户
    private Integer modifyUserId;
    //修改时间
	private Date modifyTime;
	//删除用户
	private Date deleteUserId;
	//删除时间
	private Date deleteTime;
	//最后登录ip
	private String lastLoginIp;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getIsDisabled() {
		return isDisabled;
	}
	public void setIsDisabled(Integer isDisabled) {
		this.isDisabled = isDisabled;
	}
	public Integer getLoginNumbers() {
		return loginNumbers;
	}
	public void setLoginNumbers(Integer loginNumbers) {
		this.loginNumbers = loginNumbers;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getLaseModPwdTime() {
		return laseModPwdTime;
	}
	public void setLaseModPwdTime(Date laseModPwdTime) {
		this.laseModPwdTime = laseModPwdTime;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getModifyUserId() {
		return modifyUserId;
	}
	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Date getDeleteUserId() {
		return deleteUserId;
	}
	public void setDeleteUserId(Date deleteUserId) {
		this.deleteUserId = deleteUserId;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", trueName=" + trueName
				+ ", sex=" + sex + ", email=" + email + ", groupId=" + groupId + ", departId=" + departId + ", roleId="
				+ roleId + ", isDisabled=" + isDisabled + ", loginNumbers=" + loginNumbers + ", lastLoginTime="
				+ lastLoginTime + ", laseModPwdTime=" + laseModPwdTime + ", isDeleted=" + isDeleted + ", createUserId="
				+ createUserId + ", createTime=" + createTime + ", modifyUserId=" + modifyUserId + ", modifyTime="
				+ modifyTime + ", deleteUserId=" + deleteUserId + ", deleteTime=" + deleteTime + ", lastLoginIp="
				+ lastLoginIp + "]";
	}
	
	
   

   
}