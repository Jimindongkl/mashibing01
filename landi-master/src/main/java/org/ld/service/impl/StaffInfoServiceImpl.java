package org.ld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.ld.dao.NationDao;
import org.ld.dao.PoliticalDao;
import org.ld.dao.StaffCategoryDao;
import org.ld.dao.StaffGroupDao;
import org.ld.dao.StaffInfoDao;
import org.ld.dao.congressDao.AgendaPersonDao;
import org.ld.model.Dictionary;
import org.ld.model.Nation;
import org.ld.model.StaffCategory;
import org.ld.model.StaffGroup;
import org.ld.model.StaffInfo;
import org.ld.model.congressModel.Agenda;
import org.ld.poi.StaffInfoPoi;
import org.ld.response.ResponseServer;
import org.ld.service.IStaffInfoService;
import org.ld.service.congressService.IAgendaPersonService;
import org.ld.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffInfoService")
public class StaffInfoServiceImpl implements IStaffInfoService {

	@Autowired
	private StaffInfoDao staffInfoDao;
	
	@Autowired
	private NationDao nationDao;
	
	@Autowired
	private PoliticalDao politicalDao;
	
	@Autowired
	private StaffCategoryDao staffCategoryDao;
	
	@Autowired
	private StaffGroupDao staffGroupDao;
	
	@Autowired
	private AgendaPersonDao agendaPersondao;


	@Override
	public Long getCount(StaffInfo staffInfo) {

		return staffInfoDao.getCount(staffInfo);
	}

	@Override
	public List<StaffInfo> getStaffInfoPageList(StaffInfo staffInfo) {
		List<StaffInfo> staffInfos = staffInfoDao.getStaffInfoPageList(staffInfo);
		return staffInfos;
	}

	@Override
	public void addOrUpdateStaffInfo(StaffInfo staffInfo) {
		Date t = new Date();
		if (staffInfo.getId() != null) {
			staffInfo.setUpdatetime(t);
			staffInfoDao.updateStaffInfo(staffInfo);
		} else {
			// 修改时间
			staffInfo.setUpdatetime(t);
			// 创建时间
			staffInfo.setCreateTime(t);
			staffInfoDao.addStaffInfo(staffInfo);
		}
	}

	@Override
	public ResponseServer deleteStaffInfo(String ids) {
		String str = "";
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			List<Integer> idNotList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				// 循环判断人员是否绑定日程
				Integer intId = Integer.parseInt(id);
				List<Agenda> agendas = agendaPersondao.findPersonIsAgenda(intId);
				if (agendas.size() > 0) {
					idNotList.add(intId);
				} else {
					idList.add(intId);
				}
			}
			if (idList.size() > 0) {
				staffInfoDao.deleteStaffInfo(idList);

			}
			if (idNotList.size() > 0) {
				str += "成功删除" + idList.size() + "条数据;" + "共" + idNotList.size() + "条数据绑定日程;" + "失败删除" + idNotList.size()
						+ "条数据";
			} else {
				str += "成功删除" + idList.size() + "条数据;";
			}
		}
		return ResponseServer.success(str);
	}

	@Override
	public void exportExcelStaffInfo(StaffInfo staffInfo, HttpServletResponse response) {
		// 1,查询到符合条件的数据
		List<StaffInfo> staffInfos = staffInfoDao.findStaffInfoAll(staffInfo);
		// 2.将数据转换为指定的格式
		HSSFWorkbook Workbook = buildWordBook(staffInfos);
		// 3,下载
		FileUtil.excelDownload(Workbook, response);
	}
/**************************************poi导出Excel*********开始**********************************************************************/
	/**
	 * <pre>
	 * buildWordBook(将数据转换为指定的格式)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午2:19:46    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午2:19:46    
	 * 修改备注： 
	 * &#64;param staffInfos
	 * &#64;return
	 * </pre>
	 */
	private HSSFWorkbook buildWordBook(List<StaffInfo> staffInfos) {
		// 创建工作簿
		HSSFWorkbook Workbook = new HSSFWorkbook();
		// 创建sheet
		buildSheet(staffInfos, Workbook);
		return Workbook;
	}

	/**
	 * <pre>
	 * buildSheet(创建sheet)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午2:18:34    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午2:18:34    
	 * 修改备注： 
	 * &#64;param staffInfos
	 * &#64;param Workbook
	 * </pre>
	 */
	private void buildSheet(List<StaffInfo> staffInfos, HSSFWorkbook Workbook) {
		// 偏移量
		Integer startRow = 0;
		Integer stratCol = 0;
		// 构建表头
		HSSFSheet sheet = buildHeader(Workbook, startRow, stratCol);
		// 构建表体
		buildBody(staffInfos, sheet, startRow, stratCol);
	}

	/**
	 * <pre>
	 * buildHeader(构建表头)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午2:18:53    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午2:18:53    
	 * 修改备注： 
	 * &#64;param Workbook
	 * &#64;return
	 * </pre>
	 */
	private HSSFSheet buildHeader(HSSFWorkbook Workbook, Integer startRow, Integer stratCol) {
		HSSFSheet sheet = Workbook.createSheet("基础人员表");
		// 设置列宽
		int[] width = {2000,2000,2000,2000,2000,2500,2500,3000,2000,3000,3000,2500};
		for (int i = 0; i < width.length; i++) {
			sheet.setColumnWidth(i, width[i]);
		}
		String[] headers = {"编号","姓名","性别","人员类型","团组","电话","工作单位","职务","民族","党派","身份证号","备注信息"};
		// 大标题(合并单元格,样式)
		buildFirstTitle(Workbook, startRow, stratCol, sheet, headers.length);
		// 小标题
		buildTitle(Workbook, startRow, stratCol, sheet, headers);
		return sheet;
	}

	/**
	 * <pre>
	 * buildTitle(构建小标题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午4:02:15    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午4:02:15    
	 * 修改备注： 
	 * &#64;param startRow
	 * &#64;param stratCol
	 * &#64;param sheet
	 * &#64;param headers
	 * </pre>
	 */
	private void buildTitle(HSSFWorkbook Workbook, Integer startRow, Integer stratCol, HSSFSheet sheet,
			String[] headers) {
		// 创建小标题的样式
		HSSFCellStyle style = buildTitleStyle(Workbook);
		// 创建小标题的位置
		HSSFRow rowtitle = sheet.createRow(startRow + 2);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cellTitle = rowtitle.createCell(i + stratCol);
			cellTitle.setCellValue(headers[i]);
			cellTitle.setCellStyle(style);
		}
	}

	/**
	 * <pre>
	 * buildFirstTitle(构建大标题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午3:54:13    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午3:54:13    
	 * 修改备注： 
	 * &#64;param Workbook
	 * &#64;param startRow
	 * &#64;param stratCol
	 * &#64;param sheet
	 * &#64;param length
	 * </pre>
	 */
	private void buildFirstTitle(HSSFWorkbook Workbook, Integer startRow, Integer stratCol, HSSFSheet sheet,
			Integer length) {
		// 大标题的位置
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		// 开始行，结束行，开始列，结束列
		CellRangeAddress cellRangeAddress = new CellRangeAddress(startRow, startRow + 1, stratCol,
				stratCol + length - 1);
		sheet.addMergedRegion(cellRangeAddress);
		cell.setCellValue("基础人员列表");
		// 大标题样式
		HSSFCellStyle style = buildFirstTitleStyle(Workbook);
		cell.setCellStyle(style);
	}

	/**
	 * <pre>
	 * buildTitleStyle(小标题样式)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午4:26:32    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午4:26:32    
	 * 修改备注： 
	 * &#64;param Workbook
	 * &#64;return
	 * </pre>
	 */
	private HSSFCellStyle buildTitleStyle(HSSFWorkbook Workbook) {
		// 生成一个样式
		HSSFCellStyle style = Workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		// 生成一个字体
		HSSFFont font = Workbook.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.BLACK.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		style.setFont(font);
		return style;
	}

	/**
	 * <pre>
	 * buildFirstTitleStyle(大标题样式)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午4:11:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午4:11:37    
	 * 修改备注： 
	 * &#64;param Workbook
	 * &#64;return
	 * </pre>
	 */
	private HSSFCellStyle buildFirstTitleStyle(HSSFWorkbook Workbook) {
		// 生成一个样式
		HSSFCellStyle style = Workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		// 生成一个字体
		HSSFFont font = Workbook.createFont();
		font.setFontHeightInPoints((short) 20);
		font.setColor(HSSFColor.BLACK.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		style.setFont(font);
		return style;
	}

	/**
	 * <pre>
	 * buildBody(构建表体)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年1月15日 下午2:18:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年1月15日 下午2:18:12    
	 * 修改备注： 
	 * &#64;param staffInfos
	 * &#64;param sheet
	 * </pre>
	 */
	private void buildBody(List<StaffInfo> staffInfos, HSSFSheet sheet, Integer startRow, Integer stratCol) {
		for (int i = 0; i < staffInfos.size(); i++) {
			StaffInfo staff = staffInfos.get(i);
			// 创建行
			HSSFRow row = sheet.createRow(i + 3 + startRow);
			// 创建第1个单元格,赋值,编号
			HSSFCell cellNum = row.createCell(stratCol);
			cellNum.setCellValue(staff.getNum() == null ? "" : staff.getNum());
			// 创建第2个单元格,赋值,姓名
			HSSFCell cellName = row.createCell(stratCol + 1);
			cellName.setCellValue(staff.getName() == null ? "" : staff.getName());
			// 创建第3个单元格,赋值,性别
			HSSFCell cellSex = row.createCell(stratCol + 2);
			if (staff.getSex() == null) {
				cellSex.setCellValue("");
			} else if (staff.getSex() == 0) {
				cellSex.setCellValue("男");
			} else if (staff.getSex() == 1) {
				cellSex.setCellValue("女");
			} else {
				cellSex.setCellValue("保密");
			}
			// 创建第4个单元格,赋值,类别
			HSSFCell cellStaffCategory = row.createCell(stratCol + 3);
			cellStaffCategory.setCellValue(staff.getStaffCategory().getCategoryName() == null ? ""
					: staff.getStaffCategory().getCategoryName());
			// 创建第5个单元格,赋值,团组
			HSSFCell cellStaffGroup = row.createCell(stratCol + 4);
			cellStaffGroup.setCellValue(
					staff.getStaffGroup().getGroupName() == null ? "" : staff.getStaffGroup().getGroupName());
			// 创建第6个单元格,赋值,电话
			HSSFCell cellPhone = row.createCell(stratCol + 5);
			cellPhone.setCellValue(staff.getPhone() == null ? "" : staff.getPhone());
			// 创建第7个单元格,赋值,工作单位
			HSSFCell cellWorkUnit = row.createCell(stratCol + 6);
			cellWorkUnit.setCellValue(staff.getWorkUnit() == null ? "" : staff.getWorkUnit());
			// 创建第8个单元格,赋值,职务
			HSSFCell cellJob = row.createCell(stratCol + 7);
			cellJob.setCellValue(staff.getJob() == null ? "" : staff.getJob());
			// 创建第9个单元格,赋值,民族
			HSSFCell cellNation = row.createCell(stratCol + 8);
			cellNation.setCellValue(staff.getNation().getNationName() == null ? "" : staff.getNation().getNationName());
			// 创建第10个单元格,赋值,党派
			HSSFCell cellDictionary = row.createCell(stratCol + 9);
			cellDictionary.setCellValue(staff.getDictionary().getDicName() == null ? "" : staff.getDictionary().getDicName());
			// 创建第11个单元格,赋值,身份证号
			HSSFCell cellCardNum = row.createCell(stratCol + 10);
			cellCardNum.setCellValue(staff.getCardNum() == null ? "" : staff.getCardNum());
			// 创建第12个单元格,赋值,备注信息
			HSSFCell cellWynum = row.createCell(stratCol + 11);
			cellWynum.setCellValue(staff.getRemarks() == null ? "" : staff.getWynum());
		}
	}
/**************************************poi导出Excel*********结束**********************************************************************/
	@Override
	public void addBatch(List<StaffInfoPoi> list) {
		List staffInfos = new ArrayList<>();
		//1,查询出符合条件的属性
		// 编号 姓名 性别 人员类别 团组 电话 工作单位 职务
		// 民族 党派 身份证号 备注信息
		for(int i = 0;i<list.size();i++) {
			StaffInfo staffInfo = new StaffInfo();
			// 编号
			staffInfo.setNum(list.get(i).getNum());
			//姓名
			staffInfo.setName(list.get(i).getName());
			//性别
			if(list.get(i).getSex().equals("女")) {
				staffInfo.setSex(1);
			}else if(list.get(i).getSex().equals("男")){
				staffInfo.setSex(0);
			}
			//人员类别
			if(!StringUtils.isEmpty(list.get(i).getStaffCategoryName())) {
				StaffCategory staffCategory = new StaffCategory();
				staffCategory.setCategoryName(list.get(i).getStaffCategoryName());
				staffCategory = staffCategoryDao.findStaffCategoryModel(staffCategory);
				staffInfo.setStaffCategoryId(staffCategory.getId());
			}
			//团组 
			if(!StringUtils.isEmpty(list.get(i).getStaffGroupName())) {
				StaffGroup staffGroup = new StaffGroup();
				staffGroup.setGroupName(list.get(i).getStaffGroupName());
				staffGroup = staffGroupDao.findStaffGroupModel(staffGroup);
				staffInfo.setStaffGroupId(staffGroup.getId());
			}
			//电话
			staffInfo.setPhone(list.get(i).getPhone());
			//工作单位
			staffInfo.setWorkUnit(list.get(i).getWorkUnit());
			//职务
			staffInfo.setJob(list.get(i).getJob());
			//民族
			if(!StringUtils.isEmpty(list.get(i).getNationName())) {
				Nation nation=new Nation();
				nation.setNationName(list.get(i).getNationName());
				nation=nationDao.findNationId(nation);
				staffInfo.setNationId(nation.getId());
			}
			//党派
			if(!StringUtils.isEmpty(list.get(i).getDpName())) {
				Dictionary dictionary = new Dictionary();
				dictionary.setDicName(list.get(i).getDpName());
				dictionary=politicalDao.findDictionaryId(dictionary);
				staffInfo.setDictionaryId(dictionary.getId());
			}
			//身份证号
			staffInfo.setCardNum(list.get(i).getCardNum());
			//备注信息
			staffInfo.setWorkUnit(list.get(i).getWorkUnit());
			staffInfo.setEnabled(1);
			Date date = new Date();
			staffInfo.setUpdatetime(date);
			staffInfo.setCreateTime(date);
			staffInfos.add(staffInfo);
		}
		//批量增加到数据库
		if(staffInfos.size()>0) {
			staffInfoDao.addBatch(staffInfos);
		}
			
	}

	@Override
	public List<StaffInfo> getStaffInfoList(StaffInfo staffInfo) {
	
		return staffInfoDao.getStaffInfoList(staffInfo);
	}

	@Override
	public StaffInfo getUserByUserName(String userName) {
		
		return staffInfoDao.getUserByUserName(userName);
	}

	
	
	
}
