package org.ld.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonVoCW implements Serializable{

	private static final long serialVersionUID = 7782216478623724636L;

	//坐席id
	private String seatId;
	//人员id
	private Integer personId;
	//报文类型
	private String eventType;
	//签到
	private Map<String,Object> RegisterEvent =new HashMap<String, Object>();
	//表决器
	private Map<String,Object> voteEvent =new HashMap<String, Object>();
	//话筒
	private Map<String,Object>	SpeakEvent =new HashMap<String, Object>();
	//是否申请发言
	private Map<String,Object> CallServiceEvent = new HashMap<String, Object>();
	
	
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Map<String, Object> getRegisterEvent() {
		return RegisterEvent;
	}
	public void setRegisterEvent(Map<String, Object> registerEvent) {
		RegisterEvent = registerEvent;
	}
	public Map<String, Object> getVoteEvent() {
		return voteEvent;
	}
	public void setVoteEvent(Map<String, Object> voteEvent) {
		this.voteEvent = voteEvent;
	}
	public Map<String, Object> getSpeakEvent() {
		return SpeakEvent;
	}
	public void setSpeakEvent(Map<String, Object> speakEvent) {
		SpeakEvent = speakEvent;
	}
	public Map<String, Object> getCallServiceEvent() {
		return CallServiceEvent;
	}
	public void setCallServiceEvent(Map<String, Object> callServiceEvent) {
		CallServiceEvent = callServiceEvent;
	}
	
	
	@Override
	public String toString() {
		return "JsonVoCW [seatId=" + seatId + ", personId=" + personId + ", eventType=" + eventType + ", RegisterEvent="
				+ RegisterEvent + ", voteEvent=" + voteEvent + ", SpeakEvent=" + SpeakEvent + ", CallServiceEvent="
				+ CallServiceEvent + "]";
	}
	
	
	
	
	
	
	
}
