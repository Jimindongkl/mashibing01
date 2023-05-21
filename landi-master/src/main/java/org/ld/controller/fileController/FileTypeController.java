package org.ld.controller.fileController;

import java.util.List;

import javax.annotation.Resource;

import org.ld.model.fileModel.FileType;
import org.ld.response.ResponseServer;
import org.ld.service.fileService.IFileTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fileTypeController")
public class FileTypeController {

	@Resource(name = "fileTypeService")
	private IFileTypeService fileTypeService;

	/**
	 * <pre>findFileTypes(查询文件的所有类型)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月13日 下午5:09:41    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月13日 下午5:09:41    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("findFileTypes")
	@ResponseBody
	public ResponseServer findFileTypes() {
		List<FileType> fileTypes = fileTypeService.findFileTypes();
		return ResponseServer.success(fileTypes);
	}
	
}
