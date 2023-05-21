package org.ld.model.congressModel;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：Topic    对应 t_topic
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月4日 上午11:17:29    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月4日 上午11:17:29    
 * 修改备注：       
 * @version </pre>
 */
public class Topic implements Serializable{

	private static final long serialVersionUID = 1588212682151484069L;
	
	//议题的id
	private Integer id;
	//会议
	private Congress congress;
	//议程
	private Agenda agenda;
	//议题名字
	private String toName;
	//议题内容
	private String toContent;
	//打印格式
	private String printFormat;
	//议题类型    表决 1,发言2,审议3,报告4,选举5,打分测评6,测评7,通过会议议程8,专题询问9
	private Integer type;
	//表决方式    最后一次键盘有效 1    第一次按键有效2
	//		     允许修改的公开表决3   不允许修改的公开表决4
	private Integer voteMethod;
	//表决基数	以实到人数为基数1   以应到人数为基数2
	private Integer voteBaseNum;
	//表决按键类型  三键表决1; 五键表决2;
	private Integer buttonType;
	//表决种类  单项表决1, 多项表决2
	private Integer voteSpecies;
	//表决结果
	private Integer voteResult;
	//通过比例标准   以1/2  1   以2/3  2
	private Integer passRate;
	//通过按键
	private Integer passButton;
	//发言模式 申请发言1,抢答发言2,排队发言3,自由发言4
	private Integer speakMode;
	//显示方式  通过,未通过 1; 满意,不满意2; 称职,不称职3; 合格,不合格4;无5;
	private Integer showMode;
	//幻灯片文件
	private String image;
	//应到人数
	private Integer shouldNum;
	//实到人数
	private Integer actualNum;
	//按键1人数
	private Integer buttonOneNum;
	//按键1名称
	private String buttonOneName;
	//按键2人数
	private Integer buttonTwoNum;
	//按键2名称
	private String buttonTwoName;
	//按键3人数
	private Integer buttonThreeNum;
	//按键3名称
	private String buttonThreeName;
	//按键4人数
	private Integer buttonFourNum;
	//按键4名称
	private String buttonFourName;
	//按键5人数
	private Integer buttoFiveNum;
	//按键5名称
	private String buttonFiveName;
	//未按人数
	private Integer buttonNotNum;
	//议程开始时间
	private Date agendaStartTime; 
	//议程结束时间
	private Date agendaEndTime;
	//表决开始时间
	private Date voteStartTime;
	//表决结束时间
	private Date voteEndTime;
	//发言开始时间
	private Date speakStartTime;
	//发言结束时间
	private Date speakEndTime;
	//报到开始时间
	private Date reportStartTime;
	//报到结束时间
	private Date reportEndTime;
	//序号
	private Integer num;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//备注
	private String remark;
	//父级
	private Integer parentGUID;
	//背景色
	private String agendaBgcolor;
	//议程HTML
	private String agendaHtml;
	//子议题
	private Integer topicLower;
	
	/**********************************/
	//增加子议题需要
	private Integer topicId;
	/**********************************/
	//议题的状态
	private Integer status;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Congress getCongress() {
		return congress;
	}

	public void setCongress(Congress congress) {
		this.congress = congress;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getToContent() {
		return toContent;
	}

	public void setToContent(String toContent) {
		this.toContent = toContent;
	}

	public String getPrintFormat() {
		return printFormat;
	}

	public void setPrintFormat(String printFormat) {
		this.printFormat = printFormat;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Integer getButtonType() {
		return buttonType;
	}

	public void setButtonType(Integer buttonType) {
		this.buttonType = buttonType;
	}

	public Integer getVoteSpecies() {
		return voteSpecies;
	}

	public void setVoteSpecies(Integer voteSpecies) {
		this.voteSpecies = voteSpecies;
	}

	public Integer getVoteResult() {
		return voteResult;
	}

	public void setVoteResult(Integer voteResult) {
		this.voteResult = voteResult;
	}

	public Integer getPassRate() {
		return passRate;
	}

	public void setPassRate(Integer passRate) {
		this.passRate = passRate;
	}

	public Integer getPassButton() {
		return passButton;
	}

	public void setPassButton(Integer passButton) {
		this.passButton = passButton;
	}

	public Integer getSpeakMode() {
		return speakMode;
	}

	public void setSpeakMode(Integer speakMode) {
		this.speakMode = speakMode;
	}

	public Integer getShowMode() {
		return showMode;
	}

	public void setShowMode(Integer showMode) {
		this.showMode = showMode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getShouldNum() {
		return shouldNum;
	}

	public void setShouldNum(Integer shouldNum) {
		this.shouldNum = shouldNum;
	}

	public Integer getActualNum() {
		return actualNum;
	}

	public void setActualNum(Integer actualNum) {
		this.actualNum = actualNum;
	}

	public Integer getButtonOneNum() {
		return buttonOneNum;
	}

	public void setButtonOneNum(Integer buttonOneNum) {
		this.buttonOneNum = buttonOneNum;
	}

	public String getButtonOneName() {
		return buttonOneName;
	}

	public void setButtonOneName(String buttonOneName) {
		this.buttonOneName = buttonOneName;
	}

	public Integer getButtonTwoNum() {
		return buttonTwoNum;
	}

	public void setButtonTwoNum(Integer buttonTwoNum) {
		this.buttonTwoNum = buttonTwoNum;
	}

	public String getButtonTwoName() {
		return buttonTwoName;
	}

	public void setButtonTwoName(String buttonTwoName) {
		this.buttonTwoName = buttonTwoName;
	}

	public Integer getButtonThreeNum() {
		return buttonThreeNum;
	}

	public void setButtonThreeNum(Integer buttonThreeNum) {
		this.buttonThreeNum = buttonThreeNum;
	}

	public String getButtonThreeName() {
		return buttonThreeName;
	}

	public void setButtonThreeName(String buttonThreeName) {
		this.buttonThreeName = buttonThreeName;
	}

	public Integer getButtonFourNum() {
		return buttonFourNum;
	}

	public void setButtonFourNum(Integer buttonFourNum) {
		this.buttonFourNum = buttonFourNum;
	}

	public String getButtonFourName() {
		return buttonFourName;
	}

	public void setButtonFourName(String buttonFourName) {
		this.buttonFourName = buttonFourName;
	}

	public Integer getButtoFiveNum() {
		return buttoFiveNum;
	}

	public void setButtoFiveNum(Integer buttoFiveNum) {
		this.buttoFiveNum = buttoFiveNum;
	}

	public String getButtonFiveName() {
		return buttonFiveName;
	}

	public void setButtonFiveName(String buttonFiveName) {
		this.buttonFiveName = buttonFiveName;
	}

	public Integer getButtonNotNum() {
		return buttonNotNum;
	}

	public void setButtonNotNum(Integer buttonNotNum) {
		this.buttonNotNum = buttonNotNum;
	}

	public Date getAgendaStartTime() {
		return agendaStartTime;
	}

	public void setAgendaStartTime(Date agendaStartTime) {
		this.agendaStartTime = agendaStartTime;
	}

	public Date getAgendaEndTime() {
		return agendaEndTime;
	}

	public void setAgendaEndTime(Date agendaEndTime) {
		this.agendaEndTime = agendaEndTime;
	}

	public Date getVoteStartTime() {
		return voteStartTime;
	}

	public void setVoteStartTime(Date voteStartTime) {
		this.voteStartTime = voteStartTime;
	}

	public Date getVoteEndTime() {
		return voteEndTime;
	}

	public void setVoteEndTime(Date voteEndTime) {
		this.voteEndTime = voteEndTime;
	}

	public Date getSpeakStartTime() {
		return speakStartTime;
	}

	public void setSpeakStartTime(Date speakStartTime) {
		this.speakStartTime = speakStartTime;
	}

	public Date getSpeakEndTime() {
		return speakEndTime;
	}

	public void setSpeakEndTime(Date speakEndTime) {
		this.speakEndTime = speakEndTime;
	}

	public Date getReportStartTime() {
		return reportStartTime;
	}

	public void setReportStartTime(Date reportStartTime) {
		this.reportStartTime = reportStartTime;
	}

	public Date getReportEndTime() {
		return reportEndTime;
	}

	public void setReportEndTime(Date reportEndTime) {
		this.reportEndTime = reportEndTime;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getParentGUID() {
		return parentGUID;
	}

	public void setParentGUID(Integer parentGUID) {
		this.parentGUID = parentGUID;
	}

	public String getAgendaHtml() {
		return agendaHtml;
	}

	public void setAgendaHtml(String agendaHtml) {
		this.agendaHtml = agendaHtml;
	}

	public Integer getTopicLower() {
		return topicLower;
	}

	public void setTopicLower(Integer topicLower) {
		this.topicLower = topicLower;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getAgendaBgcolor() {
		return agendaBgcolor;
	}

	public void setAgendaBgcolor(String agendaBgcolor) {
		this.agendaBgcolor = agendaBgcolor;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", congress=" + congress + ", agenda=" + agenda + ", toName=" + toName
				+ ", toContent=" + toContent + ", printFormat=" + printFormat + ", type=" + type + ", voteMethod="
				+ voteMethod + ", voteBaseNum=" + voteBaseNum + ", buttonType=" + buttonType + ", voteSpecies="
				+ voteSpecies + ", voteResult=" + voteResult + ", passRate=" + passRate + ", passButton=" + passButton
				+ ", speakMode=" + speakMode + ", showMode=" + showMode + ", image=" + image + ", shouldNum="
				+ shouldNum + ", actualNum=" + actualNum + ", buttonOneNum=" + buttonOneNum + ", buttonOneName="
				+ buttonOneName + ", buttonTwoNum=" + buttonTwoNum + ", buttonTwoName=" + buttonTwoName
				+ ", buttonThreeNum=" + buttonThreeNum + ", buttonThreeName=" + buttonThreeName + ", buttonFourNum="
				+ buttonFourNum + ", buttonFourName=" + buttonFourName + ", buttoFiveNum=" + buttoFiveNum
				+ ", buttonFiveName=" + buttonFiveName + ", buttonNotNum=" + buttonNotNum + ", agendaStartTime="
				+ agendaStartTime + ", agendaEndTime=" + agendaEndTime + ", voteStartTime=" + voteStartTime
				+ ", voteEndTime=" + voteEndTime + ", speakStartTime=" + speakStartTime + ", speakEndTime="
				+ speakEndTime + ", reportStartTime=" + reportStartTime + ", reportEndTime=" + reportEndTime + ", num="
				+ num + ", createTime=" + createTime + ", updateTime=" + updateTime + ", remark=" + remark
				+ ", parentGUID=" + parentGUID + ", agendaBgcolor=" + agendaBgcolor + ", agendaHtml=" + agendaHtml
				+ ", topicLower=" + topicLower + ", topicId=" + topicId + ", status=" + status + "]";
	}

	

	
	

	
	
	
	
}
