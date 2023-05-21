package org.ld.vo;

import java.io.Serializable;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：MoveVo    
 * 类描述：    上下移动的Model
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月26日 下午6:14:57    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月26日 下午6:14:57    
 * 修改备注：       
 * @version </pre>
 */
public class MoveVo implements Serializable{

	private static final long serialVersionUID = -266392667500171672L;

	//选中的id
	private Integer pitchOnId;
	//选中的的编号
	private long pitchOnOrder;
	//紧挨的id
	private Integer borderId;
	//紧挨的编号
	private long borderOrder;
	
	
	public Integer getPitchOnId() {
		return pitchOnId;
	}
	public void setPitchOnId(Integer pitchOnId) {
		this.pitchOnId = pitchOnId;
	}
	public long getPitchOnOrder() {
		return pitchOnOrder;
	}
	public void setPitchOnOrder(long pitchOnOrder) {
		this.pitchOnOrder = pitchOnOrder;
	}
	public Integer getBorderId() {
		return borderId;
	}
	public void setBorderId(Integer borderId) {
		this.borderId = borderId;
	}
	public long getBorderOrder() {
		return borderOrder;
	}
	public void setBorderOrder(long borderOrder) {
		this.borderOrder = borderOrder;
	}
	
	
	@Override
	public String toString() {
		return "MoveVo [pitchOnId=" + pitchOnId + ", pitchOnOrder=" + pitchOnOrder + ", borderId=" + borderId
				+ ", borderOrder=" + borderOrder + "]";
	}
	
	
}
