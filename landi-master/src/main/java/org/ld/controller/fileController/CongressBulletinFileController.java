package org.ld.controller.fileController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.ld.model.fileModel.CongressBulletinFile;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.fileService.ICongressBulletinFileService;
import org.ld.service.fileService.IFileService;
import org.ld.utils.FileUploadUtil;
import org.ld.vo.MoveVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("congressBulletinFileController")
public class CongressBulletinFileController {

	@Resource(name = "congressBulletinFileService")
	private ICongressBulletinFileService congressBulletinFileService;
	
	@Resource(name = "fileService")
	private IFileService fileService;

	/**
	 * <pre>
	 * findCongressIDToCongressBulletinFiles(按会议的id查询会议下的全部文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 上午11:11:29    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 上午11:11:29    
	 * 修改备注： 
	 * &#64;param congressBulletinFile
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("findCongressIDToCongressBulletinFiles")
	@ResponseBody
	public ResponseServer findCongressIDToCongressBulletinFiles(CongressBulletinFile congressBulletinFile) {
		List<CongressBulletinFile> congressBulletinFiles = congressBulletinFileService
				.findCongressIDToCongressBulletinFiles(congressBulletinFile);
		return ResponseServer.success(congressBulletinFiles);
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
	@RequestMapping("/uploadCongressBulletinFile")
	@ResponseBody
	public ResponseServer uploadCongressBulletinFile(CongressBulletinFile congressBulletinFile, HttpServletRequest request) throws Exception {
		congressBulletinFile.setCongressID(Integer.valueOf(request.getParameter("CongressID")));
		congressBulletinFile.setCbType(Integer.valueOf(request.getParameter("TypeID")));
		Map map = new HashMap<>();
		try {
			// 获取会议文件目录
			String fileDirName = "CongressBulletin";
			// 上传文件
			List<Map<String, Object>> result = fileService.upload(request, fileDirName);
			if (result.size() > 0) {
				congressBulletinFileService.saveCongressBulletinFile(congressBulletinFile, result);
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
	 * <pre>deleteCongresBulletinFiles(批量删除文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午3:25:10    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午3:25:10    
	 * 修改备注： 
	 * @param ids
	 * @return</pre>
	 */
	@RequestMapping("/deleteCongresBulletinFiles")
	@ResponseBody
	public ResponseServer deleteCongresBulletinFiles(String ids) {
		if(StringUtils.isNotEmpty(ids)) {
			congressBulletinFileService.deleteCongresBulletinFiles(ids);
			return ResponseServer.success();
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
	}

	/**
	 * <pre>MoveCongresBulletinFilesOrder(上移下移)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 下午4:52:36    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 下午4:52:36    
	 * 修改备注： 
	 * @param moveVo
	 * @return</pre>
	 */
	@RequestMapping("/MoveCongresBulletinFilesOrder")
	@ResponseBody
	public ResponseServer MoveCongresBulletinFilesOrder(MoveVo moveVo) {
		congressBulletinFileService.UpdateCongresBulletinFilesOrder(moveVo);
		return ResponseServer.success();
	}
}
