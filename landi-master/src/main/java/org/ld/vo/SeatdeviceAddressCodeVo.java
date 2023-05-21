package org.ld.vo;

import java.io.Serializable;

public class SeatdeviceAddressCodeVo implements Serializable{

	private static final long serialVersionUID = -1276378777797166808L;

	//坐席绑定设备的id集合
	private String ids;
	//方向  LtoR左=》右    RtoL右 =》左
	private String direction;
	//开始值
	private Integer startValue;
	//步长
	private Integer stepSize;
	//ip地址头
	private String ipHead;
	//类型 IpCode或者AddressCode
	private String type;
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getStepSize() {
		return stepSize;
	}
	public void setStepSize(Integer stepSize) {
		this.stepSize = stepSize;
	}
	public Integer getStartValue() {
		return startValue;
	}
	public void setStartValue(Integer startValue) {
		this.startValue = startValue;
	}
	public String getIpHead() {
		return ipHead;
	}
	public void setIpHead(String ipHead) {
		this.ipHead = ipHead;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
