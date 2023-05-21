package org.ld.vo;

import java.util.ArrayList;
import java.util.List;

public class StaffInfoAndNumVo {
	
	//人数
	private Integer num;
	//数据
	private List<AgendaSeatUitStaffInfoVo> agendaPersonSeatUnitVoList = new ArrayList<>();
	//标记
	private String flag;
	//说明
	private String remark;
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<AgendaSeatUitStaffInfoVo> getAgendaPersonSeatUnitVoList() {
		return agendaPersonSeatUnitVoList;
	}

	public void setAgendaPersonSeatUnitVoList(List<AgendaSeatUitStaffInfoVo> agendaPersonSeatUnitVoList) {
		this.agendaPersonSeatUnitVoList = agendaPersonSeatUnitVoList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	

}
