package org.ld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ld.model.Screen;
import org.ld.model.ScreenForm;
import org.ld.model.ScreenFormEvent;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IScreenService;
import org.ld.utils.FileUploadUtil;
import org.ld.utils.PropertiesUtil;
import org.ld.vo.ScreenJsonVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <pre>
 * 项目名称：landi-master    
 * 类名称：ScreenController    
 * 类描述：    屏幕管理
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年2月25日 上午10:00:03    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年2月25日 上午10:00:03    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("screenController")
public class ScreenController {

	@Resource(name = "screenService")
	private IScreenService screenService;

	/**
	 * <pre>
	 * findScreenList(查询屏幕详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午10:26:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午10:26:50    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findScreenList")
	@ResponseBody
	public ResponseServer findScreenList() {
		List<Screen> screenList = screenService.findScreenList();
		return ResponseServer.success(screenList);
	}

	/**
	 * <pre>
	 * findScreenEventList(按大屏幕的id查事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月27日 下午4:14:26    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月27日 下午4:14:26    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findScreenEventList")
	@ResponseBody
	public ResponseServer findScreenEventList(Screen screen) {
		List<ScreenFormEvent> screenFormEventList = new ArrayList<>();
		if (screen.getId() != null) {
			screenFormEventList = screenService.findScreenEventList(screen);
		} else {
			screenFormEventList = new ArrayList<>();
		}
		return ResponseServer.success(screenFormEventList);
	}
	
	/**
	 * <pre>findScreenExistEventList(查询多块屏幕绑定的不为空的事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月7日 上午11:23:47    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月7日 上午11:23:47    
	 * 修改备注： 
	 * @param ids  大屏id的拼接
	 * @return</pre>
	 */
	@RequestMapping("/findScreenExistEventList")
	@ResponseBody
	public ResponseServer findScreenExistEventList(String ids) {
		List<ScreenFormEvent> screenFormEventList=screenService.findScreenExistEventList(ids);
		return ResponseServer.success(screenFormEventList);
	}
	

	/**
	 * <pre>
	 * addScreen(增加和修改屏幕)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午10:28:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午10:28:54    
	 * 修改备注： 
	 * &#64;param screen
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/addOrupdateScreen")
	@ResponseBody
	public ResponseServer addOrupdateScreen(Screen screen) {
		screenService.addOrupdateScreen(screen);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * deleteBatchScreen(批量删除屏幕)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 上午11:15:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 上午11:15:54    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deleteBatchScreen")
	@ResponseBody
	public ResponseServer deleteBatchScreen(String ids) {
		screenService.deleteBatchScreen(ids);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * findScreenFormList(按大屏幕的id查窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午3:07:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午3:07:05    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findScreenFormList")
	@ResponseBody
	public ResponseServer findScreenFormList(Screen screen) {
		List<ScreenForm> screenFormList = new ArrayList<>();
		if (screen.getId() != null) {
			screenFormList = screenService.findScreenFormList(screen);
		} else {
			screenFormList = new ArrayList<>();
		}
		return ResponseServer.success(screenFormList);
	}

	/**
	 * <pre>
	 * addOrupdateScreenForm(增加和修改窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午3:39:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午3:39:37    
	 * 修改备注： 
	 * &#64;param screenForm
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/addOrupdateScreenForm")
	@ResponseBody
	public ResponseServer addOrupdateScreenForm(ScreenForm screenForm) {
		if (screenForm.getScreen().getId() != null) {
			screenService.addOrupdateScreenForm(screenForm);
			return ResponseServer.success();
		} else {
			return ResponseServer.error(ResponseEnum.ADDORUPDATE_ERROR);
		}
	}

	/**
	 * <pre>
	 * deleteBatchScreen(批量删除窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月25日 下午4:42:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月25日 下午4:42:20    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deleteBatchScreenForm")
	@ResponseBody
	public ResponseServer deleteBatchScreenForm(String ids) {
		ResponseServer st = screenService.deleteBatchScreenForm(ids);
		return st;
	}

	/**
	 * <pre>
	 * findScreenFormList(按窗体的id查询窗体的布局)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 上午10:13:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 上午10:13:12    
	 * 修改备注： 
	 * &#64;param screenForm
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findScreenFormContent")
	@ResponseBody
	public ResponseServer findScreenFormContent(ScreenForm screenForm) {
		if (screenForm.getId() != null) {
			screenForm = screenService.findScreenFormContent(screenForm);
			return ResponseServer.success(screenForm);
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}

	/**
	 * <pre>
	 * updateScreenFormContent(按窗体的id修改窗体的布局)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 上午10:58:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 上午10:58:12    
	 * 修改备注： 
	 * &#64;param screenForm
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateScreenFormContent")
	@ResponseBody
	public ResponseServer updateScreenFormContent(ScreenForm screenForm) {
		if (screenForm.getId() != null) {
			screenService.updateScreenFormContent(screenForm);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.ADDORUPDATE_ERROR);
	}

	/**
	 * <pre>
	 * updateFormEvent(绑定事件和窗体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月28日 上午9:31:09    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月28日 上午9:31:09    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateFormEvent")
	@ResponseBody
	public ResponseServer updateFormEvent(ScreenFormEvent screenFormEvent) {
		if (screenFormEvent.getScreenForm() != null && screenFormEvent.getId() != null) {
			screenService.updateFormEvent(screenFormEvent);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.BINDING_ERROR);
	}
	
	/**
	 * <pre>findScreenformeventList(按找屏幕的id和窗体id查找事件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月8日 上午11:09:47    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月8日 上午11:09:47    
	 * 修改备注： 
	 * @param list
	 * @return</pre>
	 */
	@RequestMapping("/findScreenformeventList")
	@ResponseBody
	public ResponseServer findScreenformeventList(String strJson) {
		List<ScreenForm> screenFormList = screenService.findScreenformeventList(strJson);
		return ResponseServer.success(screenFormList);
	}
	
	
	
	@RequestMapping("/fileUpload")
	@ResponseBody
	public ResponseServer fileUpload(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap<>();
		try {
			//获取会议文件目录
			String fileDirName = "screenImage" ;
		    //上传文件
		    List<Map<String, Object>> result=FileUploadUtil.upload(request, fileDirName);
		    if(result.size()>0){
		    	//获取上传后的图片路径
		    	String basePath = new PropertiesUtil("config.properties").readProperty("realPath");
				map.put("imagePath",basePath+"/" + result.get(0).get("realPath"));
			}else {
				return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
			return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
		}
		return ResponseServer.success(ResponseEnum.SUCCESS_UPLOAD,map);
	}	
	

}
