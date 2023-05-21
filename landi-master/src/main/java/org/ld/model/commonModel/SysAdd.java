package org.ld.model.commonModel;

import java.io.Serializable;
import java.util.Date;
/**
 * 增加议题配制
 * <pre>项目名称：landi-master    
 * 类名称：SysAdd    t_sysAdd
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月25日 下午3:02:40    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月25日 下午3:02:40    
 * 修改备注：       
 * @version </pre>
 */
public class SysAdd implements Serializable{

	private static final long serialVersionUID = -5649008959842736864L;

	//增加议题配制的id
	private Integer id ;
	//议题类型  表决 1,发言2,审议3,报告4,选举5,打分测评6,测评7,通过会议议程8,专题询问9
	private Integer topicType;
	//发言模式  申请发言1,抢答发言2,排队发言3,自由发言4
	private Integer speakMode;
	//表决种类  单项表决1, 多项表决2
	private Integer voteSpecies;
	//表决方式    最后一次键盘有效 1    第一次按键有效2
	//		     允许修改的公开表决3   不允许修改的公开表决4
	private Integer voteMethod;
	//表决基数	以实到人数为基数1   以应到人数为基数2
	private Integer voteBaseNum;
	//通过比例标准 以1/2  1   以2/3  2
	private Integer passRate;
	//显示方式   通过,未通过 1; 满意,不满意2; 称职,不称职3; 合格,不合格4;无5;
	private Integer showMode;
	//表决按键种类  三键表决1; 五键表决2;
	private Integer buttonType;
	//按键1名称
	private String buttonOneName;
	//按键3名称
	private String buttonTwoName;
	//按键3名称
	private String buttonThreeName;
	//按键4名称
	private String buttonFourName;
	//按键5名称
	private String buttonFiveName;
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
	public Integer getTopicType() {
		return topicType;
	}
	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}
	public Integer getSpeakMode() {
		return speakMode;
	}
	public void setSpeakMode(Integer speakMode) {
		this.speakMode = speakMode;
	}
	public Integer getVoteSpecies() {
		return voteSpecies;
	}
	public void setVoteSpecies(Integer voteSpecies) {
		this.voteSpecies = voteSpecies;
	}
	public Integer getVoteMethod() {
		return voteMethod;
	}
	public void setVoteMethod(Integer voteMethod) {
		this.voteMethod = voteMethod;
	}
	public Integer getVoteBaseNum() {
		return voteBaseNum;
	}
	public void setVoteBaseNum(Integer voteBaseNum) {
		this.voteBaseNum = voteBaseNum;
	}
	public Integer getPassRate() {
		return passRate;
	}
	public void setPassRate(Integer passRate) {
		this.passRate = passRate;
	}
	public Integer getShowMode() {
		return showMode;
	}
	public void setShowMode(Integer showMode) {
		this.showMode = showMode;
	}
	public Integer getButtonType() {
		return buttonType;
	}
	public void setButtonType(Integer buttonType) {
		this.buttonType = buttonType;
	}
	public String getButtonOneName() {
		return buttonOneName;
	}
	public void setButtonOneName(String buttonOneName) {
		this.buttonOneName = buttonOneName;
	}
	public String getButtonTwoName() {
		return buttonTwoName;
	}
	public void setButtonTwoName(String buttonTwoName) {
		this.buttonTwoName = buttonTwoName;
	}
	public String getButtonThreeName() {
		return buttonThreeName;
	}
	public void setButtonThreeName(String buttonThreeName) {
		this.buttonThreeName = buttonThreeName;
	}
	public String getButtonFourName() {
		return buttonFourName;
	}
	public void setButtonFourName(String buttonFourName) {
		this.buttonFourName = buttonFourName;
	}
	public String getButtonFiveName() {
		return buttonFiveName;
	}
	public void setButtonFiveName(String buttonFiveName) {
		this.buttonFiveName = buttonFiveName;
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
		return "SysAdd [id=" + id + ", topicType=" + topicType + ", speakMode=" + speakMode + ", voteSpecies="
				+ voteSpecies + ", voteMethod=" + voteMethod + ", voteBaseNum=" + voteBaseNum + ", passRate=" + passRate
				+ ", showMode=" + showMode + ", buttonType=" + buttonType + ", buttonOneName=" + buttonOneName
				+ ", buttonTwoName=" + buttonTwoName + ", buttonThreeName=" + buttonThreeName + ", buttonFourName="
				+ buttonFourName + ", buttonFiveName=" + buttonFiveName + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
	
	
	
	
	
}
