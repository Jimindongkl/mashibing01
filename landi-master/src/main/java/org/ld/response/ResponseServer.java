package org.ld.response;

/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：ResponseServer    
 * 类描述：    
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年1月8日 下午3:46:30    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年1月8日 下午3:46:30    
 * 修改备注：       
 * @version </pre>
 */
public class ResponseServer {
	
	
	//code码
	private Integer code;
	//提示信息
	private String message;
	//数据的存放
	private Object data;
	
	
	//无参构造
	private ResponseServer(){
		
	}
	//有参构造(有传递的数据)
	private  ResponseServer(Integer code,String message,Object data){
		
		this.code=code;
		this.message=message;
		this.data=data;
	}

	//把枚举放入到实体了
	public static ResponseServer error(ResponseEnum responseEnum){
		
		return new ResponseServer(responseEnum.getCode(),responseEnum.getMessage(),null);
	}
	//把数据放入到ResponseServer
	public static ResponseServer success(Object data){
		
		return new ResponseServer(ResponseEnum.SUCCESS_ALL.getCode(),ResponseEnum.SUCCESS_ALL.getMessage(),data);
	}
	
	public static ResponseServer success(){
		
		return new ResponseServer(ResponseEnum.SUCCESS_ALL.getCode(),ResponseEnum.SUCCESS_ALL.getMessage(),null);
	}
	
	public static ResponseServer success(ResponseEnum responseEnum,Object data){
		
		return new ResponseServer(responseEnum.getCode(),responseEnum.getMessage(),data);
	}
	
	public static ResponseServer success(ResponseEnum responseEnum){
		
		return new ResponseServer(responseEnum.getCode(),responseEnum.getMessage(),null);
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Object getData() {
		return data;
	}
	
	

}
