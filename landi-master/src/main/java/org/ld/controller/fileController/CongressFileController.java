package org.ld.controller.fileController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ld.model.fileModel.CongressFile;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.fileService.ICongressFileService;
import org.ld.service.fileService.IFileService;
import org.ld.vo.MoveVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("congressFileController")
public class CongressFileController {

	@Resource(name = "congressFileService")
	private ICongressFileService congressFileService;
	
	@Resource(name = "fileService")
	private IFileService fileService;
	
	
	/**
	 * <pre>
	 * findCongressFiles(按条件查询会议文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月25日 下午2:26:04    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月25日 下午2:26:04    
	 * 修改备注： 
	 * &#64;param congressFile
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findCongressFiles")
	@ResponseBody
	public ResponseServer findCongressFiles(CongressFile congressFile) {
		List<CongressFile> congressFiles = new ArrayList<CongressFile>();
		if (congressFile.getCongressID() != null && congressFile.getAgendaID() != null) {
			congressFiles = congressFileService.findCongressFiles(congressFile);
		}
		return ResponseServer.success(congressFiles);
	}

	/**
	 * <pre>
	 * imageUpload(多文件上传)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月24日 下午4:25:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月24日 下午4:25:54    
	 * 修改备注： 
	 * &#64;param request
	 * &#64;return
	 * &#64;throws Exception
	 * </pre>
	 */
	@RequestMapping("/uploadCongressFile")
	@ResponseBody
	public ResponseServer uploadCongressFile(CongressFile congressFile, HttpServletRequest request,HttpServletResponse response) throws Exception {
		congressFile.setCongressID(Integer.valueOf(request.getParameter("CongressID")));
		congressFile.setAgendaID(Integer.valueOf(request.getParameter("AgendaID")));
		if(request.getParameter("topicID")!=null&&request.getParameter("topicID")!="") {
			congressFile.setTopicID(Integer.valueOf(request.getParameter("topicID")));
		}
		Map map = new HashMap<>();
		try {
			// 获取会议文件目录
			String fileDirName = "Congress";
			// 上传文件
			List<Map<String, Object>> result = fileService.upload(request, fileDirName);
			if (result.size() > 0) {
				congressFileService.saveCongressFile(congressFile, result);
			} else {
				return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
		}
		return ResponseServer.success(ResponseEnum.SUCCESS_UPLOAD, map);
	}

	/**
	 * <pre>
	 * updateCongressFile(修改文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午4:30:20    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午4:30:20    
	 * 修改备注：
	 * </pre>
	 */
	@RequestMapping("/updateCongressFile")
	@ResponseBody
	public ResponseServer updateCongressFile(CongressFile congressFile) {
		// 要修改的字段 是否为主文件 关键字
		congressFileService.updateCongressFile(congressFile);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * deleteCongresFiles(删除会议文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午4:51:31    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午4:51:31    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/deleteCongresFiles")
	@ResponseBody
	public ResponseServer deleteCongresFiles(String ids) {
		// 要修改的字段 是否为主文件 关键字
		congressFileService.deleteCongresFiles(ids);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * MoveCongresFilesOrder(会议文件的上下移动)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午6:16:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午6:16:51    
	 * 修改备注： 
	 * &#64;param moveVo
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/MoveCongresFilesOrder")
	@ResponseBody
	public ResponseServer MoveCongresFilesOrder(MoveVo moveVo) {
		// 要修改的字段 是否为主文件 关键字
		congressFileService.UpdateCongresFilesOrder(moveVo);
		return ResponseServer.success();
	}

}
