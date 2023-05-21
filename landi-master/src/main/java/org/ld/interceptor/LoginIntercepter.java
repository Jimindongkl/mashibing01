package org.ld.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.ld.common.SystemConstants;
import org.ld.controller.StaffInfoController;
import org.ld.model.User;

/* 用户登录拦截器  */
public class LoginIntercepter implements HandlerInterceptor {

	// 进入Controller(Handler)方法前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws Exception {
		// 获取请求的URL
		String url = request.getServletPath();
		//如果是登录得请求放过
		if(url.startsWith("/loginController")) {
			return true;
		}
		// 判断session，用户是否登录
		HttpSession session = request.getSession();
		User curUser = (User) session.getAttribute("user");
		if (curUser == null) {
			// 如果获取的是公开地址（登录），则放行
			List ip= SystemConstants.WHITE_URLS;
			for(int i=0;i<ip.size();i++) {
				if(url.startsWith((String) ip.get(i))) {
					return true;
				}
			}
			// 没有登录,路径还错误
			System.out.println("没有登录或者路径错误");
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
			return false;
		}else {
			return true;
		} 
	}

	// 进入Handler方法之后，返回modelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// System.out.println("LoginInterceptor...postHandle");

	}

	// 执行Handler完成执行此方法
	// 应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		// System.out.println("LoginInterceptor...afterCompletion");
	}

}
