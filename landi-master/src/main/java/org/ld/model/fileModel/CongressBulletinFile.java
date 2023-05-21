package org.ld.model.fileModel;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：CongressBulletinFile    对应 t_congressbulletin
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年4月14日 上午9:59:33    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年4月14日 上午9:59:33    
 * 修改备注：       
 * @version </pre>
 */
public class CongressBulletinFile implements Serializable{

	private static final long serialVersionUID = -1656601815485323114L;

	//主键id
	private Integer cbID;
	//会议主键
	private Integer congressID;
	//文件类型
	private Integer cbType;
	//文件名称
	private String cbName;
	//文件路径
	private String cbPath;
	//文件图片路径
	private String cbPicPath;
	//真实的文件路径
	private String trueFilePath;
	//文件的大小
	private float cbSize;
	//文件的排序
	private long cbSerial;
	//创建时间
	private Date cbCreateTime;
	//是否显示
	private Integer cbIsEnabled;
	//备注
	private String cbRemark;
	//类型的名字
	private String typeName;
	
	
	public Integer getCbID() {
		return cbID;
	}
	public void setCbID(Integer cbID) {
		this.cbID = cbID;
	}
	public Integer getCongressID() {
		return congressID;
	}
	public void setCongressID(Integer congressID) {
		this.congressID = congressID;
	}
	public Integer getCbType() {
		return cbType;
	}
	public void setCbType(Integer cbType) {
		this.cbType = cbType;
	}
	public String getCbName() {
		return cbName;
	}
	public void setCbName(String cbName) {
		this.cbName = cbName;
	}
	public String getCbPath() {
		return cbPath;
	}
	public void setCbPath(String cbPath) {
		this.cbPath = cbPath;
	}
	public String getCbPicPath() {
		return cbPicPath;
	}
	public void setCbPicPath(String cbPicPath) {
		this.cbPicPath = cbPicPath;
	}
	public float getCbSize() {
		return cbSize;
	}
	public void setCbSize(float cbSize) {
		this.cbSize = cbSize;
	}
	public long getCbSerial() {
		return cbSerial;
	}
	public void setCbSerial(long cbSerial) {
		this.cbSerial = cbSerial;
	}
	public Date getCbCreateTime() {
		return cbCreateTime;
	}
	public void setCbCreateTime(Date cbCreateTime) {
		this.cbCreateTime = cbCreateTime;
	}
	public Integer getCbIsEnabled() {
		return cbIsEnabled;
	}
	public void setCbIsEnabled(Integer cbIsEnabled) {
		this.cbIsEnabled = cbIsEnabled;
	}
	public String getCbRemark() {
		return cbRemark;
	}
	public void setCbRemark(String cbRemark) {
		this.cbRemark = cbRemark;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTrueFilePath() {
		return trueFilePath;
	}
	public void setTrueFilePath(String trueFilePath) {
		this.trueFilePath = trueFilePath;
	}
	
	
	@Override
	public String toString() {
		return "CongressBulletinFile [cbID=" + cbID + ", congressID=" + congressID + ", cbType=" + cbType + ", cbName="
				+ cbName + ", cbPath=" + cbPath + ", cbPicPath=" + cbPicPath + ", trueFilePath=" + trueFilePath
				+ ", cbSize=" + cbSize + ", cbSerial=" + cbSerial + ", cbCreateTime=" + cbCreateTime + ", cbIsEnabled="
				+ cbIsEnabled + ", cbRemark=" + cbRemark + ", typeName=" + typeName + "]";
	}
	
	
	
	
	

	
}
