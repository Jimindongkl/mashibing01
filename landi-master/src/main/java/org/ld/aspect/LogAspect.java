package org.ld.aspect;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.ld.common.WebContext;
import org.ld.model.Log;
import org.ld.model.User;
import org.ld.service.ILogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAspect {

	@Resource(name="logService")
	private ILogService logService;
	
	private static final  Logger LOG=LoggerFactory.getLogger(LogAspect.class); 
	
	public Object  loginfo(ProceedingJoinPoint pjp){
		//获取方法名
		String method=pjp.getSignature().getName();
		//获取类名
		String className=pjp.getTarget().getClass().getName();
		Object result=null;
		String userName=null;
		long currentTimeMillis = System.currentTimeMillis();
		try {
			//真正的业务代码
			result=pjp.proceed();
			long currentTimeMillisA=System.currentTimeMillis();
			long time=currentTimeMillisA-currentTimeMillis;
			LOG.info("{}进入{}的{}()--成功 ,耗费时间为{}ms",userName,className,method,time);
			// 判断session，用户是否登录
			User user = (User) WebContext.getRequest().getSession().getAttribute("user");
			if(user!=null) {
				 userName=user.getUserName();
			}
			Log log=new Log();
			log.setLogTypeID(1);
			log.setLogTimestamp((int)new Date().getTime());
			log.setLogSerial((int)new Date().getTime());
			log.setLogUserName(userName);
			log.setLogCount(userName+"进入"+className+"的"+method+"()"+"成功,"+"耗费时间为"+time+"ms");
			log.setLogIsEnabled(1);
			String ip = getIpAddr(WebContext.getRequest());
			if(!StringUtils.isEmpty(ip)) {
				log.setLogIP(ip);
			}
			log.setLogCreateTime(new Date());
			logService.saveLog(log);
		} catch (Throwable e) {
			e.printStackTrace();
			long currentTimeMillisAE=System.currentTimeMillis();
			long time=currentTimeMillisAE-currentTimeMillis;
			Log log=new Log();
			log.setLogTypeID(1);
			log.setLogTimestamp((int)new Date().getTime());
			log.setLogSerial((int)new Date().getTime());
			User user = (User) WebContext.getRequest().getSession().getAttribute("user");
			if(user!=null) {
				 userName=user.getUserName();
			}
			log.setLogUserName(userName);
			log.setLogCount(userName+"进入"+className+"的"+method+"()"+"失败");
			log.setLogIsEnabled(1);
			log.setLogCreateTime(new Date());
			logService.saveLog(log);
			LOG.error("{}进入{}的{}()--失败{}",userName,className,method,e.getMessage());
			return "error/error";
		}
		return result;
	}
	
	//获取ip
	public String getIpAddr(HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;
	}
	
}
