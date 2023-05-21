package org.ld.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ld.service.IMemuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("memuController")
public class MemuController {

	@Resource(name = "memuService")
	private IMemuService memuService;
	
	/**
	 * <pre>getMemuList(查询菜单列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:35:22    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:35:22    
	 * 修改备注： 
	 * @param response</pre>
	 */
	@RequestMapping("/getMemuList")
	public void getMemuList(HttpServletResponse response) {
		List memus=memuService.queryMenuList();
		 String s=JSON.toJSONString(memus);
		 System.out.println(s);
		  try {
			response.setContentType("text/html; charset=utf-8");  
			PrintWriter out = response.getWriter();
			out.write(s);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	
	
	
}
