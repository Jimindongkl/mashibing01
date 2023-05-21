package org.ld.vo;

import java.io.Serializable;

public class SwopSeatUnitVo implements Serializable{

	private static final long serialVersionUID = -5651922300081564485L;

	private Integer agendaId;
	
	private Integer seatUnitA;
	
	private Integer staffInfoA;
	
	private Integer seatUnitB;
	
	private Integer staffInfoB;

	public Integer getSeatUnitA() {
		return seatUnitA;
	}

	public void setSeatUnitA(Integer seatUnitA) {
		this.seatUnitA = seatUnitA;
	}

	public Integer getStaffInfoA() {
		return staffInfoA;
	}

	public void setStaffInfoA(Integer staffInfoA) {
		this.staffInfoA = staffInfoA;
	}

	public Integer getSeatUnitB() {
		return seatUnitB;
	}

	public void setSeatUnitB(Integer seatUnitB) {
		this.seatUnitB = seatUnitB;
	}

	public Integer getStaffInfoB() {
		return staffInfoB;
	}

	public void setStaffInfoB(Integer staffInfoB) {
		this.staffInfoB = staffInfoB;
	}

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

	@Override
	public String toString() {
		return "SwopSeatUnitVo [agendaId=" + agendaId + ", seatUnitA=" + seatUnitA + ", staffInfoA=" + staffInfoA
				+ ", seatUnitB=" + seatUnitB + ", staffInfoB=" + staffInfoB + "]";
	}

	
	
	
	
	
	
}
