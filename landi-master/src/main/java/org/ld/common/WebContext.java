package org.ld.common;

import javax.servlet.http.HttpServletRequest;


public class WebContext {
	
	private static ThreadLocal<HttpServletRequest>  requestContext=new ThreadLocal<>();
	
	//以当前请求所对应的线程为key，以request作为value进行储存;将当前请求对应的线程和request进行绑定。
	public static void setRequest(HttpServletRequest request){
		requestContext.set(request);
	}
	
	//以当请求所对应的线程作为key，获取该key对应的value,及request
	public static HttpServletRequest getRequest(){
		return requestContext.get();
	}
	
	//从ThreadLocal中删除当前key对应的request;解除request和当前线程的绑定
	public static void remove(){
		requestContext.remove();
	}

	
	
}
