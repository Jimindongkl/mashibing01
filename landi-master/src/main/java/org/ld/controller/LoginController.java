package org.ld.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.ld.model.StaffInfo;
import org.ld.model.User;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffInfoService;
import org.ld.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("loginController")
public class LoginController {

	@Autowired
	private IUserService userService;
	
	@Resource(name = "staffInfoService")
	private IStaffInfoService staffInfoService;

	/**
	 * <pre>login(登录)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:37:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:37:50    
	 * 修改备注： 
	 * @param userName
	 * @param userPassword
	 * @param request
	 * @return</pre>
	 */
	@RequestMapping("/tologin")
	@ResponseBody
	public ResponseServer login(String userName,String userPassword ,HttpServletRequest request){
				// 判断用户名或密码为空
				if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPassword )) {
					return ResponseServer.error(ResponseEnum.USERNAME_USERPASSWORD_EMPTY);
				}
				// 调用service进行用户身份验证
				User user = userService.getUserByUserName(userName);
				// 判断户名不存在
				if (user == null) {
					return ResponseServer.error(ResponseEnum.USERNAME_NULL);
				}
				// 判断密码是否正确
				if (!userPassword.equals(user.getPassword())) {
					return ResponseServer.error(ResponseEnum.USERPASSWORD_ERROR);
				}
				// 成功
				request.getSession().setAttribute("user",user);
				return ResponseServer.error(ResponseEnum.SUCCESS_LOGIN);
	}
	/**
	 * <pre>toPaperlesslogin(无纸化测试登录)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月27日 下午2:36:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月27日 下午2:36:35    
	 * 修改备注： 
	 * @param userName
	 * @param userPassword
	 * @param request
	 * @return</pre>
	 */
	@RequestMapping("/toPaperlesslogin")
	@ResponseBody
	public ResponseServer toPaperlesslogin(String userName,String userPassword ,HttpServletRequest request){
				// 判断用户名或密码为空
				if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPassword )) {
					return ResponseServer.error(ResponseEnum.USERNAME_USERPASSWORD_EMPTY);
				}
				// 调用service进行用户身份验证
				//User user = userService.getUserByUserName(userName);
				//应该是基础人员信息
				StaffInfo staffInfo=staffInfoService.getUserByUserName(userName);
				// 判断户名不存在
				if (staffInfo == null) {
					return ResponseServer.error(ResponseEnum.USERNAME_NULL);
				}
				// 判断密码是否正确
				if (!userPassword.equals(staffInfo.getPassword())) {
					return ResponseServer.error(ResponseEnum.USERPASSWORD_ERROR);
				}
				// 成功
				return ResponseServer.success(staffInfo);
	}

	
}
