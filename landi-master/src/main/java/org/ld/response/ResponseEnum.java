package org.ld.response;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：ResponseEnum    
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:46:05    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:46:05    
 * 修改备注：       
 * @version </pre>
 */
public enum ResponseEnum {
	
			//code ：200-300为正常（成功）
			SUCCESS_ALL(201,"成功！！"),
			SUCCESS_LOGIN(200,"登陆成功！！"),
			SUCCESS_UPLOAD(202,"上传成功！！"),
			SYSTEM_ERROR(-1,"系统错误！！"),
			UPLOAD_ERROR(-2,"上传失败！！"),
			DELETE_ERROR(-3,"删除失败！！"),
			ADDORUPDATE_ERROR(-4,"编辑失败！！"),
			USERPASSWORD_ERROR(1002,"密码错误,请核对后在输入！！"),
			USERNAME_NULL(1001,"用户名不存在,请注册！！"),
			INFO_NULL(1004,"信息不存在"),
			NAME_NULL(1005,"不能为空"),
			CORRELATION_YES(1006,"有关联关系,删除失败"),
			BINDING_ERROR(1007,"绑定失败！"),
			MEET_ING(1008,"已有会议正在召开！"),
			ROOT_ING(1010,"有会议室引用,不允许删除！"),
			USERNAME_USERPASSWORD_EMPTY(1000,"用户名或密码为空！！");
			
			
	//code码
	private Integer	code;
	//提示信息
	private String	message;
	
	//无参构造
	private ResponseEnum(){
		
	}
	
	//有参构造
	private ResponseEnum(Integer code,String message){
		
		this.code=code;
		this.message=message;
	}
	
	

	public Integer getCode() {
		return code;
	}

	

	public String getMessage() {
		return message;
	}



	

	
	

}
