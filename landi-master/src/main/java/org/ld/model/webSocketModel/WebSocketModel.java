package org.ld.model.webSocketModel;

import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>项目名称：landi-master
 * 类描述：webSocket 与 CCU端通讯用到的数据表字段整合
 * 创建人：wzy
 * 修改人：
 * 修改时间：
 * 修改备注：       
 * @version </pre>
 */
public class WebSocketModel implements Serializable{

	private static final long serialVersionUID = 1588212682151484069L;

	//会议id
	private String toCongressID;
	//议程id
	private String toAgendaID;
	//议题id
	private String toId;
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
	//子议题
	private Integer topicLower;

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	//sql用到的字段
	private String tempSqlName;

	public String getTempSqlName() {
		return tempSqlName;
	}

	public void setTempSqlName(String tempSqlName) {
		this.tempSqlName = tempSqlName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getToCongressID() {
		return toCongressID;
	}

	public void setToCongressID(String toCongressID) {
		this.toCongressID = toCongressID;
	}

	public String getToAgendaID() {
		return toAgendaID;
	}

	public void setToAgendaID(String toAgendaID) {
		this.toAgendaID = toAgendaID;
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

	public Integer getShouldNum() {
		if(null ==shouldNum){
			shouldNum = 0;
		}
		return shouldNum;
	}

	public void setShouldNum(Integer shouldNum) {
		this.shouldNum = shouldNum;
	}

	public Integer getActualNum() {
		if(null == actualNum){
			actualNum = 0;
		}
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

	public Integer getTopicLower() {
		return topicLower;
	}

	public void setTopicLower(Integer topicLower) {
		this.topicLower = topicLower;
	}
}
