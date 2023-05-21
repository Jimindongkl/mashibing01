package org.ld.utils;
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

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtil {
	
	
	 /** 
     * 文件重命名 
     *  
     * @author XuDan 
     * @date 2017-8-31 下午3:39:53 
     * @param name 原文件名
     * @return 返回重命名之后的文件名
     */  
    private static String rename(String name) {  
    	//文件重命名
		//获取当前时间，并格式化，把格式化后的字符串转换成long类型的数字
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())); 
        //获取0到now之间的随机数
        Long random = (long) (Math.random() * now);  
        String fileName = now + "" + random;  
        if (name.indexOf(".") != -1) {  
            fileName += name.substring(name.lastIndexOf("."));  
        }  
        return fileName;  
    } 
    
    
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
	public static List<Map<String, Object>> upload(HttpServletRequest request,String fileDirName){
    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
    	Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
    	//获取文件绝对路径
    	String basePath = new PropertiesUtil("config.properties").readProperty("basePath");
    	basePath = basePath + System.getProperty("file.separator") + fileDirName.replace("/", System.getProperty("file.separator"));
        File file = new File(basePath);
        if(!file.exists()){
        	file.mkdirs();
        }
        Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();
        try {
        	while(it.hasNext()){
                Map.Entry<String, MultipartFile> entry = it.next();
                MultipartFile mFile = entry.getValue();
                if(mFile.getSize() != 0 && !"".equals(mFile.getName())){
                	// 获取上传的文件名 
    				String fileName = mFile.getOriginalFilename();
    				//截取后缀
    				String str1=fileName.substring(0, fileName.indexOf("."));
    				String str2=fileName.substring(str1.length()+1, fileName.length());
    				String suffix = str2;
    				String fileOldName = "";
    				if (fileName.indexOf("\\") > 0) {
    					fileOldName = fileName.substring(fileName.lastIndexOf("\\") + 1);
    				}else{
    					fileOldName=fileName;
    				}
    				String storeName = rename(fileOldName); 
    				String filePath = basePath +System.getProperty("file.separator")+ storeName;
    				// 上传文件  
    				InputStream is = mFile.getInputStream();
    				//创建一个文件输出流
    				FileOutputStream out = new FileOutputStream(filePath);
    				//创建一个缓冲区
    				byte buffer[] = new byte[1024];
    				//判断输入流中的数据是否已经读完的标致
    				int len = 0;
    				while((len = is.read(buffer)) > 0){
    				     out.write(buffer, 0, len);
    				}
    				//关闭输出流
    				out.close(); 
    				//关闭输入流
    				is.close();
                    Map<String, Object> map = new HashMap<String, Object>();
                    // 固定参数值对  
                    //原来的名称
                    map.put("fileOldName", fileOldName); 
                    //新的名称
                    map.put("fileNewName", storeName); 
                    //文件存储的相对路径
                    map.put("realPath",fileDirName+"/"+storeName);
                    //获取文件绝对路径
                    map.put("absPath",filePath);
                    //文件夹的名字
                    map.put("fileDir",fileDirName);
                    double size = checkFileSize(mFile.getSize(),"K");
                    //文件的大小
                    map.put("size", size);
                    //文件后缀
                    map.put("suffix", suffix);
                    //上传文件的时间
                    map.put("fileUploadDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    //切图
                    //fileService.addFile(map);
                    result.add(map);
    			}
            }
        }catch (Exception e) {
			e.printStackTrace();
		}  
		return result;
	}
	
	//文件大小的转换
	public static double checkFileSize(Long len, String unit) {
      double fileSize = 0;
      if ("B".equals(unit.toUpperCase())) {
          fileSize = (double) len;
      } else if ("K".equals(unit.toUpperCase())) {
          fileSize = (double) len / 1024;
      } else if ("M".equals(unit.toUpperCase())) {
          fileSize = (double) len / 1048576;
      } else if ("G".equals(unit.toUpperCase())) {
          fileSize = (double) len / 1073741824;
      }
      if(fileSize >0 ) {
    	  fileSize = (double)Math.round(fileSize*100)/100;
      }
      return fileSize;
  }
	
	
	
}
