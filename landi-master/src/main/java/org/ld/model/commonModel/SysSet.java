package org.ld.model.commonModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：SysSet    对应 t_sysset
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年11月17日 下午3:12:13    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年11月17日 下午3:12:13    
 * 修改备注：       
 * @version </pre>
 */
public class SysSet implements Serializable{

	private static final long serialVersionUID = 4690039522279592215L;

	//主键
	private Integer sYSID;
	//名称
	private String sYSKey;
	//标题
	private String sYSTitle;
	//类型
	private String sYSType;
	//值
	private String sYSValue;
	//父级id
	private Integer sYSPID;
	//排序
	private Integer sYSOrder;
	//名称说明
	private String sYSMemo;
	//创建时间
	private Date sYSCreatTime;
	
	
	public Integer getsYSID() {
		return sYSID;
	}
	public void setsYSID(Integer sYSID) {
		this.sYSID = sYSID;
	}
	public String getsYSKey() {
		return sYSKey;
	}
	public void setsYSKey(String sYSKey) {
		this.sYSKey = sYSKey;
	}
	public String getsYSTitle() {
		return sYSTitle;
	}
	public void setsYSTitle(String sYSTitle) {
		this.sYSTitle = sYSTitle;
	}
	public String getsYSValue() {
		return sYSValue;
	}
	public void setsYSValue(String sYSValue) {
		this.sYSValue = sYSValue;
	}
	public Integer getsYSPID() {
		return sYSPID;
	}
	public void setsYSPID(Integer sYSPID) {
		this.sYSPID = sYSPID;
	}
	public Integer getsYSOrder() {
		return sYSOrder;
	}
	public void setsYSOrder(Integer sYSOrder) {
		this.sYSOrder = sYSOrder;
	}
	public String getsYSMemo() {
		return sYSMemo;
	}
	public void setsYSMemo(String sYSMemo) {
		this.sYSMemo = sYSMemo;
	}
	public Date getsYSCreatTime() {
		return sYSCreatTime;
	}
	public void setsYSCreatTime(Date sYSCreatTime) {
		this.sYSCreatTime = sYSCreatTime;
	}
	public String getsYSType() {
		return sYSType;
	}
	public void setsYSType(String sYSType) {
		this.sYSType = sYSType;
	}
	
	
	@Override
	public String toString() {
		return "SysSet [sYSID=" + sYSID + ", sYSKey=" + sYSKey + ", sYSTitle=" + sYSTitle + ", sYSType=" + sYSType
				+ ", sYSValue=" + sYSValue + ", sYSPID=" + sYSPID + ", sYSOrder=" + sYSOrder + ", sYSMemo=" + sYSMemo
				+ ", sYSCreatTime=" + sYSCreatTime + "]";
	}
	
	
	

	
	
	
	
	
	
	
}
