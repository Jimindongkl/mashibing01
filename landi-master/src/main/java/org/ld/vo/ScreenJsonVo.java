package org.ld.vo;

public class ScreenJsonVo {
	
	private Integer screenID;
	
	private String seventContent;

	public Integer getScreenID() {
		return screenID;
	}

	public void setScreenID(Integer screenID) {
		this.screenID = screenID;
	}

	public String getSeventContent() {
		return seventContent;
	}

	public void setSeventContent(String seventContent) {
		this.seventContent = seventContent;
	}

	@Override
	public String toString() {
		return "ScreenJsonVo [screenID=" + screenID + ", seventContent=" + seventContent + "]";
	}

	
	

}
