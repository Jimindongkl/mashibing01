package org.ld.controller.fileController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.ld.dao.commonDao.CommonDao;
import org.ld.service.fileService.IFileService;
import org.ld.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("fileController")
public class FileController {
	
	@Resource(name = "fileService")
	private IFileService fileService;
	
	
	/**
	 * 文件上传
	 * 
	 * <pre>
	 * 示例填写区
	 * </pre>
	 * 
	 * @param requestContext
	 *            jetspeed RequestContext对象
	 * @param params
	 *            封装非文件上传表单元素
	 * @param directory
	 *            上传服务器目录
	 * @param isNeedReName
	 *            上传的文件是否需要重命名
	 * @return
	 */
	@RequestMapping("upload")
	@ResponseBody
	public  List<Map<String, Object>> upload(HttpServletRequest request,String fileDirName){
		 List<Map<String, Object>>	result=fileService.upload(request,fileDirName);
		 return result;
	}
	

    
	
}
