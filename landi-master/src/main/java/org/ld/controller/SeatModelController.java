package org.ld.controller;

import org.apache.commons.lang.StringUtils;
import org.ld.model.SeatModel;
import org.ld.model.SeatTheme;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ISeatModelService;
import org.ld.utils.FileUploadUtil;
import org.ld.utils.PropertiesUtil;
import org.ld.vo.SeatUnitVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("seatModelController")
public class SeatModelController {
	
	@Resource(name = "seatModelService")
	private ISeatModelService seatModelService;

	/**
	 * 按条件获取 坐席图
	 * */
	@RequestMapping("/getSeatingModels")
	@ResponseBody
	public ResponseServer getSeatModels(SeatModel seatModel){
		Map map = new HashMap();
		List<SeatModel> modelList = new ArrayList<>();
		modelList = seatModelService.getSeatModels(seatModel);
		map.put("modelList", modelList);
		return ResponseServer.success(map);
	}
	
	/**
	 * <pre>getSeatingModelById(按坐席模板的id查询坐席单元)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年7月8日 上午10:48:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年7月8日 上午10:48:20    
	 * 修改备注： 
	 * @param seatModel
	 * @return</pre>
	 */
	@RequestMapping("/getSeatingModelById")
	@ResponseBody
	public ResponseServer getSeatingModelById(SeatModel seatModel){
		if(seatModel.getId()!=null) {
			Map map = new HashMap();
			String array = "";
			List<SeatUnitVo> list=seatModelService.getSeatUnitsByModelId(seatModel);
			if(list.size()>0) {
				 array= JSONArray.parseArray(JSON.toJSONString(list,SerializerFeature.
						WriteNullStringAsEmpty)).toString();
			}
			map.put("fileXML", array);
			return ResponseServer.success(map);
		}else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}
	
	/**
	 * 添加坐席图和增加坐席图单元  或 修改坐席图
	 * */
	@RequestMapping("/addOrUpdateSeatModel")
	@ResponseBody		
	public ResponseServer addOrUpdateSeatModel(SeatModel seatModel){
		seatModelService.addOrUpdateSeatModel(seatModel);
		return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
	}
	
	/**
	 * 批量修改坐席图单元
	 * */
	@RequestMapping("/updateSeatUnit")
	@ResponseBody
	public ResponseServer updateSeatUnit(SeatModel seatModel){
		ResponseServer rs=seatModelService.updateSeatUnits(seatModel);
		return rs;
	}

	/**
	 * <pre>updateFilexmlById(根据id修改坐席图矩阵(不用))   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月6日 下午2:48:31    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月6日 下午2:48:31    
	 * 修改备注： 
	 * @param seatModel
	 * @return</pre>
	 */
	@RequestMapping("/updateFileById")
	@ResponseBody
	public ResponseServer updateFilexmlById(SeatModel seatModel){
		seatModelService.updateFilexmlById(seatModel);
		return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
	}
	/**
	 * 删除 坐席图
	 * */
	@RequestMapping("/deleteSeatModel")
	@ResponseBody
	public ResponseServer deleteSeatModel(String Ids){
		  if (StringUtils.isNotEmpty(Ids)) {
			  ResponseServer responseServer= seatModelService.deleteSeatModel(Ids);
			  return responseServer;
		  }
		  return ResponseServer.error(ResponseEnum.DELETE_ERROR);
		
	}

	/**
	 * 坐席图图片上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/seatimageUpload")
	@ResponseBody
	public ResponseServer fileUpload(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap<>();
		try {
			//获取会议文件目录
			String fileDirName = "seatimage" ;
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
	
	/**
	 * <pre>getSeatThemes(查看席位图标主题套图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月1日 下午1:50:32    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月1日 下午1:50:32    
	 * 修改备注： 
	 * @param seatModel
	 * @return</pre>
	 */
	@RequestMapping("/getSeatThemes")
	@ResponseBody
	public ResponseServer getSeatThemes(){
		List<SeatTheme> seatThemes= seatModelService.getSeatThemes();
		return ResponseServer.success(seatThemes);
	}
	
	/**
	 * <pre>updateSeatTheme(修改席位图标主题套图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月1日 下午4:39:04    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月1日 下午4:39:04    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/updateSeatTheme")
	@ResponseBody
	public ResponseServer updateSeatTheme(SeatTheme seatTheme){
		if(seatTheme.getId()!=null&&!StringUtils.isEmpty(seatTheme.getImagePath())) {
			 seatModelService.updateSeatTheme(seatTheme);
			 return ResponseServer.success();
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		
	}
	
	/**
	 * <pre>seatThemeImageUpload(上传席位图标主题套图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月1日 下午4:49:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月1日 下午4:49:51    
	 * 修改备注： 
	 * @param request
	 * @param response
	 * @return</pre>
	 */
	@RequestMapping("/seatThemeImageUpload")
	@ResponseBody
	public ResponseServer seatThemeImageUpload(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap<>();
		try {
			//获取会议文件目录
			String fileDirName = "seatThemeImage" ;
			//上传文件
			List<Map<String, Object>> result=FileUploadUtil.upload(request, fileDirName);
			if(result.size()>0){
				//获取上传后的图片路径
				map.put("imagePath","/upload"+"/" + result.get(0).get("realPath"));
			}else {
				return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
			return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
		}
		return ResponseServer.success(ResponseEnum.SUCCESS_UPLOAD,map);
	}
	
	/**
	 * <pre>findRoomIdToSeatModelInfo(按会议室的id查询坐席图的详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 上午11:41:41    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 上午11:41:41    
	 * 修改备注： 
	 * @param roomId
	 * @return</pre>
	 */
	@RequestMapping("/findRoomIdToSeatModelInfo")
	@ResponseBody
	public ResponseServer findRoomIdToSeatModelInfo(Integer roomId) {
		SeatModel  seatModel= seatModelService.findRoomIdToSeatModelInfo(roomId);
		return ResponseServer.success(seatModel);
	}
}
