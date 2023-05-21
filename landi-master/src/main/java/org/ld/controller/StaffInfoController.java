package org.ld.controller;

import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.ld.model.StaffInfo;
import org.ld.poi.StaffInfoPoi;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffInfoService;
import org.ld.utils.FileUploadUtil;
import org.ld.utils.PropertiesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("staffInfoController")
public class StaffInfoController {
	
	@Resource(name = "staffInfoService")
	private IStaffInfoService staffInfoService;
	
	/**
	 * <pre>staffInfoPageList(查询人员列表)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:38:32    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:38:32    
	 * 修改备注： 
	 * @param staffInfo
	 * @return</pre>
	 */
	@RequestMapping("/staffInfoPageList")
	@ResponseBody 
	public ResponseServer staffInfoPageList(StaffInfo staffInfo) {
		Map map = new HashMap<>();
		Long count =staffInfoService.getCount(staffInfo);
		//总条数
		staffInfo.setTotalCount(count);
		//计算开始下标
		staffInfo.calculatePage();
		//查询数据
		List<StaffInfo> staffInfos=staffInfoService.getStaffInfoPageList(staffInfo);
		map.put("page", staffInfo);
		map.put("staffInfos", staffInfos);
		return ResponseServer.success(map);
	}
	
	
	/**
	 * <pre>staffInfoPageList(增加和修改)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月8日 下午3:38:32    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月8日 下午3:38:32    
	 * 修改备注： 
	 * @param staffInfo
	 * @return</pre>
	 */
	@RequestMapping("/addOrUpdateStaffInfo")
	@ResponseBody 
	public ResponseServer addOrUpdateStaffInfo(StaffInfo staffInfo) {
		staffInfoService.addOrUpdateStaffInfo(staffInfo);
		return ResponseServer.success();
	}
	
	/**
	 * 附件上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/fileUpload")
	@ResponseBody
	public ResponseServer fileUpload(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap<>();
		try {
			//获取会议文件目录
			String fileDirName = "userimage" ;
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
	 * 删除附件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteUpload")
	@ResponseBody
	public ResponseServer deleteUpload(String imagePath,HttpServletRequest request, HttpServletResponse response){	
		//获取文件绝对路径
    	String basePath = new PropertiesUtil("config.properties").readProperty("basePath");
    	//绝对路径+图片路径
    	String  filePath = basePath + imagePath;
    	File file = new File(filePath);
        if(file.exists()){
        	//删除
        	file.delete();
         return ResponseServer.success();
        }
       return ResponseServer.error(ResponseEnum.DELETE_ERROR);
	}
	
	/**
	 * <pre>deleteStaffInfo(删除)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月11日 下午3:34:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月11日 下午3:34:50    
	 * 修改备注： 
	 * @param Ids
	 * @return</pre>
	 */
	@RequestMapping("/deleteStaffInfo")
	@ResponseBody
	public ResponseServer deleteStaffInfo(String Ids){	
		if (StringUtils.isNotEmpty(Ids)) {
			ResponseServer responseServer = staffInfoService.deleteStaffInfo(Ids);
			 return responseServer;
		}
		return ResponseServer.error(ResponseEnum.NAME_NULL);
	}
	
	/**
	 * <pre>exportExcelStaffInfo(导出基础人员)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月14日 下午2:06:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月14日 下午2:06:38    
	 * 修改备注： 
	 * @param staffInfo
	 * @return</pre>
	 */
	@RequestMapping("/exportExcelStaffInfo")
	public void exportExcelStaffInfo(StaffInfo staffInfo,HttpServletResponse response){	
		//把需要的数据传到业务层
		staffInfoService.exportExcelStaffInfo(staffInfo,response);
	}
	
	/**
	 * <pre>importExcelStaffInfo(导入)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月16日 上午9:34:50    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月16日 上午9:34:50    
	 * 修改备注： </pre>
	 * @throws Exception 
	 */
	@RequestMapping("/importExcelStaffInfo")
	@ResponseBody
	public ResponseServer importExcelStaffInfo(HttpServletRequest request) throws Exception {
		  MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		  InputStream in =null; 
		  MultipartFile file = multipartRequest.getFile("upfile"); 
		  if(file.isEmpty()){ 
		   throw new Exception("文件不存在！"); 
		  } 
		  in = file.getInputStream(); 
		  POIFSFileSystem fs = new POIFSFileSystem(in);
		  //1.解析Excel
		  //1.1.根据Excel文件创建工作簿
		  HSSFWorkbook wb = new HSSFWorkbook(fs);
		  //1.2.获取sheet
		  HSSFSheet sheet=wb.getSheetAt(0); //参数索引
		  //1.3.获取sheet中的每一行，和每一个单元格。
		  //2.获取用户数据列表
		  List<StaffInfoPoi> list =new ArrayList<>();
          for (int rowNum = 3; rowNum<= sheet.getLastRowNum() ;rowNum ++) {
           HSSFRow  row = sheet.getRow(rowNum);
           Object [] values = new Object[row.getLastCellNum()];
           for(int cellNum = 0;cellNum< row.getLastCellNum();cellNum++) {
        	   HSSFCell cell = row.getCell(cellNum);
        	   String value = getValue(cell);
        	   if(StringUtils.isEmpty(value)) {
        		   values[cellNum] = "";
        	   }else {
        		   values[cellNum] = value;
        	   }
           }
           StaffInfoPoi staffInfoPoi = new StaffInfoPoi(values);
           if(staffInfoPoi!=null) {
        	   list.add(staffInfoPoi);
           }
         }
          //3.批量保存用户
          staffInfoService.addBatch(list);
		 return ResponseServer.success(list);
	}
	
	/**
     * 格式转为String
     * @param cell
     * @return
     */
	private static String getValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cellvalue = String.valueOf(cell.getStringCellValue().trim());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
	
	/**
	 * <pre>excelStandardTemplateOut(下载Excel模板)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月12日 上午10:37:39    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月12日 上午10:37:39    
	 * 修改备注： 
	 * @param request
	 * @return</pre>
	 */
	@RequestMapping(value = "/excelOut")
	@ResponseBody
    public ResponseServer excelStandardTemplateOut(HttpServletRequest request){
        String contextPath = request.getContextPath();  
        String ip = "";
        try {
			 ip = InetAddress.getLocalHost().getHostAddress();
			 System.out.println("本机ip:"+ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String basePath = request.getScheme()+"://"+ip+":"+  
                request.getServerPort()+contextPath+"/"; 
        String  str = basePath +"template/userTemplate.xls";//Excel模板所在的路径。
       return ResponseServer.success(str);
}
	
	/**
	 * <pre>getStaffInfoList(无分页的条件查询-用于人员管理模块绑定会议或议程)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月31日 下午2:57:35    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月31日 下午2:57:35    
	 * 修改备注： 
	 * @param staffInfo
	 * @return</pre>
	 */
	@RequestMapping("/getStaffInfoList")
	@ResponseBody
	public ResponseServer getStaffInfoList(StaffInfo staffInfo){	
		List<StaffInfo> staffInfos=staffInfoService.getStaffInfoList(staffInfo);
       return ResponseServer.success(staffInfos);
	}
	
	
	
}
